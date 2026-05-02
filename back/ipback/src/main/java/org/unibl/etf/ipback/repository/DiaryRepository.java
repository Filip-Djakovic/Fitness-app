package org.unibl.etf.ipback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ipback.entities.DiaryEntity;

import java.util.List;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer> {
    //public DiaryEntity findDiaryEntitiesByUser_Id(Integer id);

    public List<DiaryEntity> findDiaryEntitiesByUser_Id(Integer id);
}
