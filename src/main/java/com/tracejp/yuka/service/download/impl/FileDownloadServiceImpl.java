package com.tracejp.yuka.service.download.impl;

import com.mchange.io.FileUtils;
import com.tracejp.yuka.dao.FileDownloadMapper;
import com.tracejp.yuka.service.download.FileDownloadService;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    @Autowired
    FileDownloadMapper fileDownloadDAO;

    @Override
    public ResponseEntity<byte[]> musicDownload(Integer id) {
        String localFileUrl = fileDownloadDAO.selectMusicResourcesUrl(id);
        if(localFileUrl == null) {
            return null;
        }
        String absoluteUrl = null;
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties(
                    "properties/LocalFileUrlConfig.properties"
            );
            absoluteUrl = properties.getProperty("localURL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(absoluteUrl + localFileUrl);
        byte[] bytes = new byte[1024];
        try {
            bytes = FileUtils.getBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileResponseService(bytes, file.getName());
    }

    @Override
    public ResponseEntity<byte[]> musicListDownload(Integer id) {
        String listName = fileDownloadDAO.selectMusicListName(id);
        List<String> listLocalFile = fileDownloadDAO.selectMusicResourcesUrlByList(id);
        if(listName == null || listLocalFile == null) {
            return null;
        }
        byte[] bytes = new byte[1024];
        try {
            bytes = musicListToZip(listLocalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileResponseService(bytes, listName + ".zip");
    }

    @Override
    public byte[] musicListToZip(List<String> musicList) throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties(
                "properties/LocalFileUrlConfig.properties"
        );
        String absoluteUrl = properties.getProperty("localURL");
        String url = properties.getProperty("musicAudioUrl");
        // 创建zip文件流并压缩文件集合
        String randomName = absoluteUrl + url + Util.getRandomString(3);
        ZipOutputStream zipFile = new ZipOutputStream(
                new FileOutputStream(randomName)
        );
        for (String list : musicList) {
            File file = new File(absoluteUrl + list);
            FileInputStream input = new FileInputStream(file);
            zipFile.putNextEntry(
                    new ZipEntry(file.getName())
            );
            int temp = 0;
            while((temp = input.read()) != -1){
                zipFile.write(temp);
            }
            input.close();
        }
        // zip文件转化为byte数组并删除
        File file = new File(randomName);
        byte[] bytes = FileUtils.getBytes(file);
        file.delete();
        return bytes;
    }

}
