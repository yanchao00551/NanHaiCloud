package com.nanhai.zuulgateway.config;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class R extends HashMap<String,Object> {
    @Override
    public Object get(Object key) {
        return this.get(key);
    }

    public R(){
        put("result","success");
        put("errorCode","00000");
        put("errorMsg","success");
        put("data","");
    }

    public static R error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系管理员");
    }
    public static R error(String msg){
        return  error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }
    public static R error(int code,String msg){
        R r = new R();
        r.put("errorCode",code);
        r.put("errorMsg",msg);
        return r;
    }
    public static R ok(String msg){
        R r = new R();
        r.put("errorMsg",msg);
        return r;
    }
    public static R ok(Map<String,Object> map){
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok(){
        return new R();
    }


    @Override
    public R put(String key, Object value){
        super.put(key,value);
        return this;
    }
}
