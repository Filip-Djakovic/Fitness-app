package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.QuestionEntity;
import org.unibl.etf.ipback.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<QuestionEntity> getAll(){
        return questionRepository.findAll();
    }

    public List<QuestionEntity> getQuestionById(Integer id){
        return questionRepository.findQuestionEntitiesByProgramm_Id(id);
    }

    public QuestionEntity updateQuestion(QuestionEntity questionEntity){
        return questionRepository.save(questionEntity);
    }

    public QuestionEntity createQuestion(QuestionEntity questionEntity){
        return questionRepository.save(questionEntity);
    }
}
