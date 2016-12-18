package com.ushibutatory.zundoko.rest;

import com.ushibutatory.zundoko.model.*;
import com.ushibutatory.zundoko.service.ZundokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * ズンドコAPI
 */
@RestController
@RequestMapping("/api/zundoko")
public class ZundokoRestController {

    @Autowired
    ZundokoService _zundokoService;

    /**
     * ズンドコテストを実行します。
     *
     * @param title タイトル（前方一致）
     * @param count 試行回数
     * @return 結果
     */
    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public Result execute(@PathVariable String title, @RequestParam Optional<Integer> count) {
        return this._zundokoService.execute(title, count);
    }
}
