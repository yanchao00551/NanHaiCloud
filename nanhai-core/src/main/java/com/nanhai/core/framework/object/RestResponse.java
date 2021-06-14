package com.nanhai.core.framework.object;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nanhai.core.business.entity.AdministrativeArea;
import com.nanhai.core.util.R;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @PackageName:com.nanhai.core.framework.object
 * @ClassName:RestResponse
 * @Description:
 * @author: 悟空
 * @date: 2021/5/16 12:52
 * @email: 10947@163.com
 */
public class RestResponse<T> {

    /**
     * 数据解析
     * @author 悟空
     * @description //TODO
     * @date 12:50 2021/5/16
     * @param
     * @return java.util.List<T>
     */
    public List<T> getList(String jsonStr,Class<T> clazz){
        //对字符串进行解析
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray list = data.getJSONArray("list");
        List<T> temp = new LinkedList<>();
        for(int i = 0; i< list.size(); i++){
            JSONObject o = (JSONObject) list.get(i);
            T a = o.toJavaObject(clazz);
            temp.add(a);
        }
        return temp;
    }


}
