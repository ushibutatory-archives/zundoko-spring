package com.ushibutatory.zundoko.rest;

import com.ushibutatory.zundoko.model.*;
import com.ushibutatory.zundoko.service.ZundokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * ズンドコキヨシコントローラ
 */
@RestController
@RequestMapping("/api/zundoko")
public class ZundokoRestController {

    @Autowired
    ZundokoService _zundokoService;

    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public Result execute(@PathVariable String title, @RequestParam Optional<Integer> count) {
        return this._zundokoService.execute(title, count);
    }
}
