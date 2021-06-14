package com.nanhai.file.exception;


import com.nanhai.file.exception.GlobalFileException;

public class OssApiException extends GlobalFileException {

    public OssApiException(String message) {
        super(message);
    }

    public OssApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
