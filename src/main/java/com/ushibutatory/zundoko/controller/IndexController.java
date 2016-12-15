package com.ushibutatory.zundoko.controller;

import com.ushibutatory.zundoko.service.ZundokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    ZundokoService _zundokoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String root() {
        return "index";
    }

    @RequestMapping(value = "{title}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable String title) {
        model.addAttribute("title", title);
        model.addAttribute("result", this._zundokoService.execute(title, Optional.of(0)));
        return "result";
    }
}
