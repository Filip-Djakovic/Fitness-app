package org.unibl.etf.ipback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ipback.entities.InstructorEntity;

public interface InstructorRepository extends JpaRepository<InstructorEntity, Integer> {
}
