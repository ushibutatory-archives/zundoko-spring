package com.ushibutatory.zundoko.rest.nabeatsu;

import com.ushibutatory.zundoko.model.nabeatsu.Result;
import com.ushibutatory.zundoko.service.NabeAtsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * ナベアツAPI
 */
@RestController
@RequestMapping("/api/nabeatsu")
public class NabeatsuRestController {

    @Autowired
    NabeAtsuService _nabeatsuService;

    /**
     * 値を変換します。
     *
     * @return 歌リスト
     */
    @RequestMapping(value = "/{value}", method = RequestMethod.GET)
    public Result execute(@PathVariable BigInteger value) {
        return this._nabeatsuService.execute(value);
    }
}
