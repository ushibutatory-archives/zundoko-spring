package com.ushibutatory.zundoko.model;

import com.ushibutatory.zundoko.model.songs.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * アルバムクラス
 */
public class Album {

    /**
     * singletonインスタンス
     */
    private static Album _album;

    /**
     * 歌リスト
     */
    private List<ISong> _songs;

    /**
     * インスタンスを取得します。
     *
     * @return アルバムインスタンス
     */
    public static Album getInstance() {
        if (_album == null) {
            // 歌リストを生成
            List<ISong> songs = Arrays.asList(
//                    new Thrill(),
//                    new Ultrasoul(),
                    new SoranBushi(),
                    new ZundokoBushi()
            );

            // インスタンスを生成
            _album = new Album();

            // 歌リストを設定
            _album._songs = songs;
        }
        return _album;
    }

    /**
     * すべての歌を取得します。
     *
     * @return 歌リスト
     */
    public List<ISong> findAll() {
        return this._songs;
    }

    /**
     * 指定した文字で始まるタイトルの歌を取得します。
     *
     * @param title タイトル（前方一致）
     * @return 歌
     */
    public Optional<ISong> find(String title) {
        return this._songs.stream()
                .filter(song ->
                        song.getClassName().toUpperCase().startsWith(title.toUpperCase())).findFirst();
    }
}
