package com.nanhai.file;

import com.nanhai.file.entity.VirtualFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;


public interface ApiClient {

    VirtualFile uploadImg(MultipartFile file);

    VirtualFile uploadImg(File file);

    VirtualFile uploadImg(InputStream is, String key);

    boolean removeFile(String key);
}
