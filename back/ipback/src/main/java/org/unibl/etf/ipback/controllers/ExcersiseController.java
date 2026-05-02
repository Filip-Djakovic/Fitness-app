package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ipback.entities.Excersise;
import org.unibl.etf.ipback.service.ExcersiseServices;

import java.util.List;

@RestController
@RequestMapping("/excersises")
public class ExcersiseController {

    @Autowired
    private ExcersiseServices excersiseServices;

    @GetMapping
    public List<Excersise> getAll(){
        return this.excersiseServices.getExercises();
    }
}
