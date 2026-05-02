package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ipback.entities.InstructorEntity;
import org.unibl.etf.ipback.service.InstructorService;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;
    @GetMapping
    public List<InstructorEntity> getAll(){
        return instructorService.getAll();
    }
}
