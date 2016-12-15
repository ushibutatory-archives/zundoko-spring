package com.ushibutatory.zundoko.model;

import lombok.Data;

/**
 * 歌手クラス
 */
@Data
public class Singer {

    /**
     * 歌
     */
    private ISong song;

    /**
     * 歌う歌を設定します。
     *
     * @param song 歌
     */
    public void setSong(ISong song) {
        this.song = song;
    }

    /**
     * 1フレーズ歌います。
     *
     * @return 1フレーズ
     * @throws Exception
     */
    public String sing() throws Exception {
        if (this.song == null) {
            // TODO 適切な例外処理
            throw new Exception("Singer has no song.");
        } else {
            return this.song.getUsingPhrases().get((int) (Math.random() * this.song.getUsingPhrases().size()));
        }
    }
}
