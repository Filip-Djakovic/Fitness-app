package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.*;
import org.unibl.etf.ipback.repository.ProgrammRepository;
import org.unibl.etf.ipback.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProgrammService {

    @Autowired
    private ProgrammRepository programmRepository;
    @Autowired
    private QuestionRepository questionRepository;
    private static final Logger logger = Logger.getLogger(ProgrammService.class.getName());
    public List<ProgrammsEntity> getAll(){

        List<ProgrammsEntity> list = programmRepository.findAll();
        for(ProgrammsEntity programm : list){
            programm.setPictureBase64(Base64.getEncoder().encodeToString(programm.getPicture()));
        }

        return list;
    }

    public ProgrammsEntity createProgramm(ProgrammsEntity programmEntity) {
        String base64Picture = programmEntity.getPictureBase64();

        if (base64Picture != null && !base64Picture.isEmpty()) {
            try {
                // Strip the prefix before decoding
                //String encodedImage = base64Picture.split(",")[1];
                programmEntity.setPicture(Base64.getMimeDecoder().decode(base64Picture));//.split(",")[1]));
                programmEntity.setPictureBase64("A");
                System.out.println("Image size in bytes: " + programmEntity.getPicture().length);
            } catch (IllegalArgumentException e) {
                // Log the error with the Base64 string length and a snippet for debugging
                logger.severe("Failed to decode Base64 image. Length: " + base64Picture.length() +
                        ", Snippet: " + base64Picture.substring(0, Math.min(100, base64Picture.length())));
                throw new RuntimeException("Failed to decode Base64 image", e);
            }
        }

        return programmRepository.save(programmEntity);
    }

    // Method to ensure Base64 string has correct padding
    private String ensureProperPadding(String base64String) {
        int paddingLength = 4 - (base64String.length() % 4);
        if (paddingLength < 4) {
            base64String += "=".repeat(paddingLength);
        }
        return base64String;
    }

    public ProgrammsEntity getOne(Integer id){
        return programmRepository.findProgrammsEntityById(id);
    }

    public List<ProgrammsEntity> getAllByUser(Integer id){
        List<ProgrammsEntity> list =  programmRepository.findProgrammsEntityByUser_Id(id);
        for(ProgrammsEntity programm : list){
            programm.setPictureBase64(Base64.getEncoder().encodeToString(programm.getPicture()));
        }
        return list;
    }
    public void deleteProgramm(Integer id){
        questionRepository.deleteByProgrammsId(id);
        programmRepository.deleteById(id);
    }
}
