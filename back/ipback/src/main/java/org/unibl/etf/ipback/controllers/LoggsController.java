package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ipback.service.LoggsService;

import java.util.ArrayList;

@RestController
@RequestMapping("/loggs")
public class LoggsController {
    @Autowired
    private LoggsService loggsService;

    @GetMapping
    public ArrayList<String> getAllString(){
        return loggsService.getAllStrings();
    }
}
