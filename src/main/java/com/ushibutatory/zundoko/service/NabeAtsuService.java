package com.ushibutatory.zundoko.service;

import com.ushibutatory.zundoko.model.nabeatsu.Player;
import com.ushibutatory.zundoko.model.nabeatsu.Result;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * ナベアツサービス
 */
@Service
public class NabeAtsuService extends BaseService {

    private Player _player = new Player();

    public Result execute(BigInteger value) {
        return this._player.answer(value);
    }

}
