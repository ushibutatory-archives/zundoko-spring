package com.ushibutatory.zundoko.model;

/**
 * 観客クラス
 */
public class Audience {

    /**
     * 歌
     */
    private ISong _song;

    /**
     * 満足したかどうか
     */
    private Boolean _isSatisfied = false;

    /**
     * 満足したかどうかを取得します。
     *
     * @return 満足したかどうか
     */
    public Boolean IsSatisfied() {
        return this._isSatisfied;
    }

    /**
     * 歌を設定します。
     *
     * @param song 歌
     */
    public void setSong(ISong song) {
        this._song = song;

        // 初期化
        this._isSatisfied = false;
    }

    /**
     * 決め台詞を取得します。
     *
     * @return 決め台詞
     * @throws Exception
     */
    public String shout() throws Exception {
        if (this._song == null) {
            // TODO 適切な例外処理
            throw new Exception("Songが設定されていません。");
        } else {
            // 満足した
            this._isSatisfied = true;

            // 決め台詞を返す
            return this._song.getShoutPhrase();
        }
    }
}
