package com.nanhai.core.business.util;


import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import javax.validation.ConstraintViolationException;

/**
 * 控制器增强，进行异常处理等
 *
 * @author luobo
 * @date 2021/04/20
 */
@RestControllerAdvice
public class DefaultControllerAdvisor {

    private static Logger logger = LoggerFactory.getLogger(com.nanhai.core.business.util.DefaultControllerAdvisor.class);

    /**
     * 处理系统异常
     *
     * @param e 异常对象
     * @return 处理信息
     */
    @ExceptionHandler(Exception.class)
    public R processException(Exception e) {
        logger.error(e.getMessage(), e);
        R msg = new R();
        msg.put("result", "fail");
        msg.put("errorCode", "000001");
        msg.put("errorMsg", e.getMessage());
        return msg;
    }

    /**
     * 处理api异常
     *
     * @param e 异常对象
     * @return 处理信息
     */
    @ExceptionHandler(ApiException.class)
    public R  processApiException(ApiException e) {
        logger.error(e.getMessage(), e);
        R msg = new R();
        msg.put("result", "fail");
        msg.put("errorCode", "000002");
        msg.put("errorMsg", e.getMessage());
        return msg;
    }

    /**
     * 处理参数校验异常
     *
     * @param e 异常对象
     * @return 处理信息
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public R processConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage(), e);
        String error = e.getConstraintViolations().iterator().next().getMessage();
        R msg = new R();
        msg.put("result", "fail");
        msg.put("errorCode", "000003");
        msg.put("errorMsg",error);
        return msg;
    }

    /**
     * 处理参数校验异常
     *
     * @param e 异常对象
     * @return 处理信息
     */
    @ExceptionHandler(BindException.class)
    public R processBindException(BindException e) {
        logger.error(e.getMessage(), e);
        String error = e.getAllErrors().get(0).getDefaultMessage();
        R msg = new R();
        msg.put("result", "fail");
        msg.put("errorCode", "000004");
        msg.put("errorMsg",error);
        return msg;
    }

    /**
     * 处理请求方式异常
     *
     * @param e 异常
     * @return 处理信息
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public R processHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage(), e);
        R msg = new R();
        msg.put("result", "fail");
        msg.put("errorCode", "000005");
        msg.put("errorMsg",e.getMethod());
        return msg;
    }

    /**
     * 处理上传文件异常
     *
     * @param e 上传文件异常
     * @return 处理信息
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public R processMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        logger.error(e.getMessage(), e);
        String m = e.getMessage();
        int end = m.lastIndexOf(' ');
        int start = m.lastIndexOf(' ', end - 1);
        String size = m.substring(start + 1, end);
        long s = Long.parseLong(size);
        s /= 1024L;
        R msg = new R();

        msg.put("result", "fail");
        msg.put("errorCode", "000006");
        msg.put("errorMsg","上传文件大小不能超过 " + s + "kb");
        return msg;
    }




}
