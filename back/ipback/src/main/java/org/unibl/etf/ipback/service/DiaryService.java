package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.DiaryEntity;
import org.unibl.etf.ipback.repository.DiaryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;
    public List<DiaryEntity> getByUserId(Integer id){
        return diaryRepository.findDiaryEntitiesByUser_Id(id);
    }

    public List<DiaryEntity> getAllDiary(){
        return diaryRepository.findAll();
    }

    public DiaryEntity updateCreateDiary(DiaryEntity diaryEntity){
        return diaryRepository.save(diaryEntity);
    }

    public List<Integer> getWeights(Integer id){
        List<DiaryEntity> list = diaryRepository.findDiaryEntitiesByUser_Id(id);

        ArrayList<Integer> listWeight = new ArrayList<>();

        for(DiaryEntity entity : list){
            listWeight.add(entity.getNewWeight());
        }
        return listWeight;
    }
}
