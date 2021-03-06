package com.tracejp.yuka.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/*********************************
 * @author traceJP
 *********************************/
public class LocalFileCommandUtil {

    /**
     * 本地路径配置文件config-url
     */
    private final String configUrl;

    /**
     * config-key
     */
    private final String configKey;

    /**
     * 文件名
     */
    private final String fileName;

    /**
     * 文件类型
     */
    private final String fileType;

    /**
     * springmvc文件对象
     */
    private final MultipartFile multipartFile;

    /**
     * 保存文件
     * @return
     */
    public void saveFile() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties(configUrl);
        String url = properties.getProperty(configKey);
        StringBuilder maxUrl = new StringBuilder();
        maxUrl.append(properties.getProperty("localURL"));
        maxUrl.append(url);
        maxUrl.append(File.separator);
        maxUrl.append(fileName);
        maxUrl.append(".");
        maxUrl.append(fileType);
        // 创建并保存文件
        File localFile = new File(maxUrl.toString());
        localFile.createNewFile();
        multipartFile.transferTo(localFile);
    }

    /**
     * 获取相对路径的文件url
     * @return 相对路径url
     * @throws IOException
     */
    public String getFileRelativelyUrl() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties(configUrl);
        String url = properties.getProperty(configKey);
        StringBuilder maxUrl = new StringBuilder();
        maxUrl.append(url);
        maxUrl.append(File.separator);
        maxUrl.append(fileName);
        maxUrl.append(".");
        maxUrl.append(fileType);
        return maxUrl.toString();
    }

    private LocalFileCommandUtil() {
        this(new Builder());
    }

    private LocalFileCommandUtil(Builder builder) {
        configUrl = builder.configUrl;
        configKey = builder.configKey;
        fileName = builder.fileName;
        fileType = builder.fileType;
        multipartFile = builder.multipartFile;
    }

    @Component
    @Scope(SCOPE_PROTOTYPE)
    public static final class Builder {

        private String configUrl;
        private String configKey;
        private String fileName;
        private String fileType;
        private MultipartFile multipartFile;

        public Builder() {
            // 默认构建值
            configUrl = "properties/LocalFileUrlConfig.properties";
            configKey = null;
            fileName = null;
            fileType = "jpg";
            multipartFile = null;
        }

        public Builder(LocalFileCommandUtil localFile) {
            configUrl = localFile.configUrl;
            configKey = localFile.configKey;
            fileName = localFile.fileName;
            fileType = localFile.fileType;
            multipartFile = localFile.multipartFile;
        }

        public Builder builderConfigUrl(String configUrl) {
            this.configUrl = configUrl;
            return this;
        }

        public Builder builderConfigKey(String configKey) {
            this.configKey = configKey;
            return this;
        }

        public Builder builderFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder builderFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Builder builderMultipartFile(MultipartFile multipartFile) {
            this.multipartFile = multipartFile;
            this.fileName = multipartFile.getOriginalFilename();
            String[] type = multipartFile.getContentType().split("/");
            this.fileType = type[1];
            return this;
        }

        public LocalFileCommandUtil builder() {
            return new LocalFileCommandUtil(this);
        }

    }




}
