package com.ushibutatory.zundoko.model.nabeatsu.states;

import java.math.BigInteger;

/**
 * 状態インタフェース
 */
public interface IState {

    /**
     * 有効かどうかを取得します。
     *
     * @return 有効かどうか
     */
    boolean enabled();

    /**
     * 指定された数値が状態の条件に当てはまるかどうかを取得します。
     *
     * @param value 数値
     * @return 状態の条件に当てはまるかどうか
     */
    boolean isApplied(BigInteger value);

    /**
     * 数値を変換します。
     *
     * @param value 数値
     * @return 変換した文字列
     */
    String convert(BigInteger value);

    /**
     * レベルを取得します。
     * 入力値に対して複数の状態が当てはまる時、優先度（どの状態を採用するか）を決めるための値です。
     * 高ければ高いほど採用されやすいものとします。
     *
     * @return レベル
     */
    int getLevel();

}
