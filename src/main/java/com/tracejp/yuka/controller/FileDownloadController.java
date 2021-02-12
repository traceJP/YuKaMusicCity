package com.tracejp.yuka.controller;

import com.tracejp.yuka.service.download.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 * @author traceJP
 *********************************/
@RestController
public class FileDownloadController {

    @Autowired
    FileDownloadService fileDownloadService;

    @GetMapping("/musicDownload/{id}")
    public ResponseEntity<byte[]> musicDownload(@PathVariable("id") Integer id) {
        return fileDownloadService.musicDownload(id);
    }

    @GetMapping("/listDownload/{id}")
    public ResponseEntity<byte[]> listDownload(@PathVariable("id") Integer id) {
        return fileDownloadService.musicListDownload(id);
    }

}
