package com.ushibutatory.zundoko.model.nabeatsu;

import com.ushibutatory.zundoko.model.nabeatsu.states.IState;
import com.ushibutatory.zundoko.model.nabeatsu.states.lv0.DefaultState;
import com.ushibutatory.zundoko.model.nabeatsu.states.lv1.FoolState;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * プレイヤークラス
 */
public class Player {

    /**
     * 特殊な状態リスト
     */
    private static List<IState> _customStates;

    /**
     * 既定の状態
     */
    private static final IState _defaultState = new DefaultState();

    /**
     * コンストラクタ
     */
    public Player() {
        this._customStates = Arrays.asList(
                new FoolState()
        );
    }

    /**
     * 指定した数値を変換します。
     *
     * @param value 数値
     * @return 変換結果
     */
    public Result answer(BigInteger value) {
        // 状態を取得
        IState state = this.getState(value);

        // 結果を返す
        return new Result(value, state);
    }

    /**
     * 状態を取得します。
     *
     * @param value 数値
     * @return 状態
     */
    private IState getState(BigInteger value) {
        // 条件に当てはまる状態を取得する
        return this._customStates.stream()
                .filter(s -> s.enabled() && s.isApplied(value))
                .sorted(Comparator.comparing(IState::getLevel))
                .findFirst()
                .orElse(this._defaultState);
    }
}
