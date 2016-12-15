package com.ushibutatory.zundoko.model;

import java.util.List;

/**
 * 歌インタフェース
 */
public interface ISong {

    // TODO: thymeleaf側で使うためにやむなく定義。他の方法考える
    /**
     * クラス名を取得します。
     * @return クラス名
     */
    String getClassName();

    /**
     * 歌の名前を取得します。
     *
     * @return 歌名
     */
    String getName();

    /**
     * 使用フレーズリストを取得します。
     *
     * @return 使用フレーズリスト
     */
    List<String> getUsingPhrases();

    /**
     * 完成フレーズリストを取得します。
     *
     * @return 完成フレーズリスト
     */
    List<String> getCompletePhrases();

    /**
     * 完成フレーズ数を取得します。
     *
     * @return 完成フレーズ数
     */
    Integer getCompletePhraseCount();

    /**
     * 決め台詞を取得します。
     *
     * @return 決め台詞
     */
    String getShoutPhrase();

    /**
     * フレーズが完成しているかどうかを取得します。
     *
     * @param phrases フレーズリスト
     * @return 完成しているかどうか
     */
    Boolean isCompleted(List<String> phrases);
}
