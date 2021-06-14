package com.nanhai.file.exception;


import com.nanhai.file.exception.GlobalFileException;

public class QiniuApiException extends GlobalFileException {
    public QiniuApiException() {
        super();
    }

    public QiniuApiException(String message) {
        super(message);
    }

    public QiniuApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public QiniuApiException(Throwable cause) {
        super(cause);
    }
}
