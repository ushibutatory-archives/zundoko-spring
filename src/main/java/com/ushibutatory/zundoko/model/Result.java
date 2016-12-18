package com.ushibutatory.zundoko.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 結果クラス
 */
@Data
public class Result {

    /**
     * 試行回数
     */
    private int count;

    /**
     * 結果フレーズリスト
     */
    private List<String> results;

    /**
     * コンストラクタ
     */
    public Result() {
        this.results = new ArrayList<>();
    }

    /**
     * フレーズを追加します。
     *
     * @param phrase フレーズ
     */
    public void addPhrase(String phrase) {
        this.results.add(phrase);
    }

    /**
     * 完成フレーズを取得します。
     *
     * @return 完成フレーズ
     */
    public String phrases() {
        return this.phrases("");
    }

    /**
     * 完成フレーズを取得します。
     *
     * @param separator 区切り文字
     * @return 完成フレーズ
     */
    public String phrases(String separator) {
        return String.join(separator, this.results);
    }

}
