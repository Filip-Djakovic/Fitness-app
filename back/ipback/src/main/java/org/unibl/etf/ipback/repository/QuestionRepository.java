package org.unibl.etf.ipback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ipback.entities.QuestionEntity;
import org.unibl.etf.ipback.entities.*;
import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
    public List<QuestionEntity> findQuestionEntitiesByProgramm_Id(Integer id);
    @Transactional
    @Modifying
    @Query("DELETE FROM QuestionEntity q WHERE q.programm.id = :programmsId")
    void deleteByProgrammsId(Integer programmsId);
}
