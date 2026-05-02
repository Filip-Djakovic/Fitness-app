package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ipback.entities.DiaryEntity;
import org.unibl.etf.ipback.other.PdfGenerator;
import org.unibl.etf.ipback.service.DiaryService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pdf_downloader")
public class PdfController {
    @Autowired
    private DiaryService diaryService;


    @GetMapping("/download/{id}")
    public ResponseEntity<FileSystemResource> downloadPdf(@PathVariable Integer id) throws IOException {
        PdfGenerator pdfGenerator = new PdfGenerator();
        List<DiaryEntity> entity = diaryService.getByUserId(id);

        // Generate and save the PDF to a file
        pdfGenerator.generatePdf(entity);

        File file = new File("output.pdf");
        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        FileSystemResource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(resource.contentLength())
                .body(resource);
    }
}
