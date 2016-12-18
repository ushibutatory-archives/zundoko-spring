package com.ushibutatory.zundoko.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 会場クラス
 */
public class House {

    /**
     * 歌手
     */
    private Singer _singer;

    /**
     * 観客
     */
    private Audience _audience;

    /**
     * 試行回数
     */
    private int _limitCount;

    /**
     * コンストラクタ
     *
     * @param singer   歌手
     * @param audience 観客
     */
    public House(Singer singer, Audience audience) {
        this._singer = singer;
        this._audience = audience;
        this._limitCount = 0;
    }

    /**
     * 試行回数を設定します。
     *
     * @param count 試行回数
     */
    public void setLimitCount(int count) {
        this._limitCount = count;
    }

    /**
     * 演奏します。
     *
     * @param song 歌
     * @return 結果
     * @throws Exception
     */
    public Result play(ISong song) throws Exception {
        if (song == null) {
            throw new Exception("songがnullです");
        } else if (this._singer == null) {
            throw new Exception("singerがいません");
        } else if (this._audience == null) {
            throw new Exception("audienceがいません");
        } else {
            Result result = new Result();

            this._singer.setSong(song);
            this._audience.setSong(song);

            List<String> phraseList = new ArrayList<>();
            int count = 0;
            while (!this._audience.IsSatisfied()) {
                String phrase = this._singer.sing();

                phraseList.add(phrase);
                result.addPhrase(phrase);
                count++;

                if (song.isCompleted(phraseList)) {
                    String shout = this._audience.shout();

                    result.addPhrase(shout);
                    result.setCount(count);
                    break;
                } else {
                    if (this._limitCount > 0 && count >= this._limitCount) {
                        result.addPhrase("もうこれ以上歌えない……。");
                        result.setCount(count);
                        break;
                    } else {
                        if (phraseList.size() > song.getCompletePhrasesCount()) {
                            phraseList.remove(0);
                        }
                    }
                }
            }
            return result;
        }
    }
}