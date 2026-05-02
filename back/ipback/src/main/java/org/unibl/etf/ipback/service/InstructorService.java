package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.InstructorEntity;
import org.unibl.etf.ipback.repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<InstructorEntity> getAll(){
        return instructorRepository.findAll();
    }
}
