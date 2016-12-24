package com.ushibutatory.zundoko.controller;

import com.ushibutatory.zundoko.form.NabeAtsuForm;
import com.ushibutatory.zundoko.model.zundoko.Album;
import com.ushibutatory.zundoko.service.ZundokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    ZundokoService _zundokoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("songs", Album.getInstance().findAll());
        return "index";
    }

    @RequestMapping(value = "{title}", method = RequestMethod.GET)
    public String zundoko(Model model, @PathVariable String title) {
        model.addAttribute("title", title);
        model.addAttribute("result", this._zundokoService.execute(title, Optional.of(0)));
        return "zundoko";
    }

    @RequestMapping(value = "nabeatsu", method = RequestMethod.POST)
    public String nabeatsu(Model model, @ModelAttribute NabeAtsuForm form) {
        model.addAttribute("start", form.getStart());
        model.addAttribute("count", form.getCount());
        return "nabeatsu";
    }
}
