package com.ushibutatory.zundoko.model;

import java.util.ArrayList;
import java.util.List;

public class House {

    private Singer _singer;

    private Audience _audience;

    private int _limitCount;

    public House(Singer singer, Audience audience) {
        this._singer = singer;
        this._audience = audience;
        this._limitCount = 0;
    }

    public void setLimitCount(int count) {
        this._limitCount = count;
    }

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
                        if (phraseList.size() > song.getCompletePhraseCount()) {
                            phraseList.remove(0);
                        }
                    }
                }
            }
            return result;
        }
    }
}