package com.ushibutatory.zundoko.model.zundoko;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * 歌インタフェース
 */
public interface ISong {

    /**
     * クラス名を取得します。
     *
     * @return クラス名
     */
    // TODO: thymeleaf側で使うためにやむなく定義。他の方法考える
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
    List<String> getPhrases();

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
    Integer getCompletePhrasesCount();

    /**
     * 決め台詞を取得します。
     *
     * @return 決め台詞
     */
    String getShout();

    /**
     * フレーズが完成しているかどうかを取得します。
     *
     * @param phrases フレーズリスト
     * @return 完成しているかどうか
     */
    @JsonIgnore
    Boolean isCompleted(List<String> phrases);
}
