package com.ushibutatory.zundoko.model.nabeatsu.states;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

/**
 * 状態基底クラス
 */
@Data
public abstract class BaseState implements IState {

    /**
     * 有効かどうか
     */
    private boolean enabled;

    /**
     * 包含する状態リスト
     */
    private final List<IState> _subStateList;

    /**
     * コンストラクタ
     */
    public BaseState() {
        this._subStateList = this._createSubStateList();
    }

    /**
     * 指定された数値が状態の条件に当てはまるかどうかを取得します。
     *
     * @param value 数値
     * @return 状態の条件に当てはまるかどうか
     */
    public abstract boolean isApplied(BigInteger value);

    /**
     * 数値を変換します。
     *
     * @param value 数値
     * @return 変換した文字列
     */
    public abstract String convert(BigInteger value);

    /**
     * レベルを取得します。
     *
     * @return レベル
     */
    @Override
    public int getLevel() {
        // サブ状態の数が多ければ多いほどレベルが高いとみなす
        return this._subStateList.size();
    }

    /**
     * サブ状態リストを生成します。
     *
     * @return サブ状態リスト
     */
    protected abstract List<IState> _createSubStateList();

}
