package com.ushibutatory.zundoko.model.nabeatsu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ushibutatory.zundoko.model.nabeatsu.states.IState;
import lombok.Data;

import java.math.BigInteger;

/**
 * 結果クラス
 */
@Data
public class Result {

    /**
     * 元の数値
     */
    private BigInteger value;

    /**
     * 適用した状態
     */
    @JsonIgnore
    public IState state;

    /**
     * 変換後の文字列
     */
    private String text;

    /**
     * コンストラクタ
     *
     * @param value 元の値
     * @param state 適用した状態
     */
    public Result(BigInteger value, IState state) {
        this.value = value;
        this.state = state;
        this.text = state.convert(value);
    }

}
