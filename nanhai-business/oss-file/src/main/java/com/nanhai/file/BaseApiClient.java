package com.nanhai.file;

import cn.hutool.core.date.DateUtil;
import com.nanhai.file.ApiClient;
import com.nanhai.file.entity.VirtualFile;
import com.nanhai.file.exception.GlobalFileException;
import com.nanhai.file.exception.OssApiException;
import com.nanhai.file.exception.QiniuApiException;
import com.nanhai.file.util.FileUtil;
import com.nanhai.file.util.ImageUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;


public abstract class BaseApiClient implements ApiClient {

    protected String storageType;
    protected String newFileName;
    protected String suffix;

    public BaseApiClient(String storageType) {
        this.storageType = storageType;
    }

    @Override
    public VirtualFile uploadImg(MultipartFile file) {
        this.check();
        if (file == null) {
            throw new OssApiException("[" + this.storageType + "]文件上传失败：文件不可为空");
        }
        try {
            VirtualFile res = this.uploadImg(file.getInputStream(), file.getOriginalFilename());
            VirtualFile imageInfo = ImageUtil.getInfo(file);
            return res.setSize(imageInfo.getSize())
                    .setOriginalFileName(file.getOriginalFilename())
                    .setWidth(imageInfo.getWidth())
                    .setHeight(imageInfo.getHeight());
        } catch (IOException e) {
            throw new GlobalFileException("[" + this.storageType + "]文件上传失败：" + e.getMessage());
        }
    }

    @Override
    public VirtualFile uploadImg(File file) {
        this.check();
        if (file == null) {
            throw new QiniuApiException("[" + this.storageType + "]文件上传失败：文件不可为空");
        }
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            VirtualFile res = this.uploadImg(is, "temp" + FileUtil.getSuffix(file));
            VirtualFile imageInfo = ImageUtil.getInfo(file);
            return res.setSize(imageInfo.getSize())
                    .setOriginalFileName(file.getName())
                    .setWidth(imageInfo.getWidth())
                    .setHeight(imageInfo.getHeight());
        } catch (FileNotFoundException e) {
            throw new GlobalFileException("[" + this.storageType + "]文件上传失败：" + e.getMessage());
        }
    }

    void createNewFileName(String key, String pathPrefix) {
        this.suffix = FileUtil.getSuffix(key);
        if (!FileUtil.isPicture(this.suffix)) {
            throw new GlobalFileException("[" + this.storageType + "] 非法的图片文件[" + key + "]！目前只支持以下图片格式：[jpg, jpeg, png, gif, bmp]");
        }
        String fileName = DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");
        this.newFileName = pathPrefix + (fileName + this.suffix);
    }

    protected abstract void check();
}
