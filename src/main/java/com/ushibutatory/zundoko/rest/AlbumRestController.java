package com.ushibutatory.zundoko.rest;

import com.ushibutatory.zundoko.model.Album;
import com.ushibutatory.zundoko.model.ISong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumRestController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ISong> all() {
        return Album.getInstance().findAll();
    }

}
