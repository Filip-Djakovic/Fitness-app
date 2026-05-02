package org.unibl.etf.ipback.controllers;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ipback.entities.DiaryEntity;
import org.unibl.etf.ipback.service.DiaryService;

import java.util.List;

@RestController
@RequestMapping("/diarys")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;


    @GetMapping("/diary/{id}")
    public List<DiaryEntity> getDiaryByUser(@PathVariable Integer id){
        return diaryService.getByUserId(id);
    }

    @GetMapping
    public List<DiaryEntity> getAll(){
        return diaryService.getAllDiary();
    }

    @PutMapping
    public ResponseEntity<?> updateDiary(@RequestBody DiaryEntity diaryEntity){
        diaryService.updateCreateDiary(diaryEntity);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

    @PostMapping
    public ResponseEntity<?> createDiary(@RequestBody DiaryEntity diaryEntity){
        diaryService.updateCreateDiary(diaryEntity);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

    @GetMapping("/weights/{id}")
    public List<Integer> getWeights(@PathVariable Integer id){
        return diaryService.getWeights(id);
    }
}
