package org.unibl.etf.ipback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ipback.entities.ProgrammsEntity;

import java.util.List;

public interface ProgrammRepository extends JpaRepository<ProgrammsEntity, Integer> {
    public ProgrammsEntity findProgrammsEntityById(Integer id);

    public List<ProgrammsEntity> findProgrammsEntityByUser_Id(Integer id);
}
