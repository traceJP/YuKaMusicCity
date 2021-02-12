package com.tracejp.yuka.service.download;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public interface FileDownloadService {

    /**
     * 音乐下载
     * @param id 音乐id
     * @return
     */
    ResponseEntity<byte[]> musicDownload(Integer id);

    /**
     * 歌单下载
     * @param id 歌单id
     * @return
     */
    ResponseEntity<byte[]> musicListDownload(Integer id);

    /**
     * 传入list集合url将其压缩成zip流，再转化为字节数组返回
     * @param musicList
     * @return
     */
    byte[] musicListToZip(List<String> musicList) throws IOException;

    /**
     * 字节转换为响应体方法
     * @param bytes
     * @param fileName
     * @return
     */
    default ResponseEntity<byte[]> fileResponseService(byte[] bytes, String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=" + fileName
        );
        headers.add(
                HttpHeaders.CONTENT_TYPE,
                "application/octet-stream"
        );
        HttpStatus status =  HttpStatus.OK;
        return new ResponseEntity<>(bytes, headers, status);
    }

}
