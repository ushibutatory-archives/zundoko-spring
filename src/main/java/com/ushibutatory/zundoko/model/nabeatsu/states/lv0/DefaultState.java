package com.ushibutatory.zundoko.model.nabeatsu.states.lv0;

import com.ushibutatory.zundoko.model.nabeatsu.states.BaseState;
import com.ushibutatory.zundoko.model.nabeatsu.states.IState;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * 通常状態
 */
public class DefaultState extends BaseState {

    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public boolean isApplied(BigInteger value) {
        // 常に
        return true;
    }

    @Override
    public String convert(BigInteger value) {
        return value.toString();
    }

    @Override
    protected List<IState> _createSubStateList() {
        return Arrays.asList();
    }
}
