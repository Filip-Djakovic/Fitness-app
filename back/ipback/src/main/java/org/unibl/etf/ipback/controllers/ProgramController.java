package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ipback.entities.ProgrammsEntity;
import org.unibl.etf.ipback.service.ProgrammService;

import java.util.List;

@RestController
@RequestMapping("/programms")
public class ProgramController {
    @Autowired
    private ProgrammService programmService;

    @GetMapping
    public List<ProgrammsEntity> getAll(){
        return programmService.getAll();
    }
    @PostMapping
    public ResponseEntity<?> createProgramm(@RequestBody ProgrammsEntity programmEntity){
        programmService.createProgramm(programmEntity);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @GetMapping("/programm/{id}")
    public ProgrammsEntity getOne(@PathVariable Integer id){
        return programmService.getOne(id);
    }
    @GetMapping("programm_by_user/{id}")
    public List<ProgrammsEntity> getAllByUser(@PathVariable Integer id){
        return programmService.getAllByUser(id);
    }
    @DeleteMapping("/programm/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        programmService.deleteProgramm(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }
}


