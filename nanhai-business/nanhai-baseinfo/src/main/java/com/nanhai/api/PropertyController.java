package com.nanhai.api;

import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.PlanInfo;
import com.nanhai.core.business.entity.PropertyType;
import com.nanhai.core.business.entity.PropertyValue;
import com.nanhai.core.business.vo.PlanInfoConditionVO;
import com.nanhai.core.business.vo.PropertyTypeConditionVO;
import com.nanhai.core.business.vo.PropertyValueConditionVO;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhPropertyType;
import com.nanhai.core.persistence.beans.NhPropertyValue;
import com.nanhai.core.persistence.beans.NhUsers;
import com.nanhai.core.util.R;
import com.nanhai.service.NhPropertyTypeService;
import com.nanhai.service.NhPropertyValueService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 公共服务接口
 * @author 杨默
 * @date 2021/5/15 9:15
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = "/baseInfo")
public class PropertyController extends AbstractController {

    @Autowired
    private NhPropertyTypeService nhPropertyTypeService;

    @Autowired
    private NhPropertyValueService nhPropertyValueService;

    @GetMapping("/propertyType/selectPage")
    public R selecPropertyType(NhPropertyType nhPropertyType){
        PageInfo<NhPropertyType> pageInfo = nhPropertyTypeService.selectByPage(nhPropertyType);
        return R.ok().put("data",pageInfo);
    }


    /**
     * 新增属性类别
     * @param propertyType
     * @return
     */
    @RequestMapping("/propertyType/insert")
    public R insert(NhPropertyType propertyType){
        int index = nhPropertyTypeService.insertPropertyType(propertyType);
        if (Strings.isNotEmpty(propertyType.toString())){
            if (index == 1){
                Date date = new Date();
                System.out.println(date);
                propertyType.setCreateTime(date);
                return R.ok().put("result" , "新增成功");
            }
            return R.ok().put("errorMsg" , "新增失败");
        }else {
            return R.ok().put("errorMsg" , "传入参数错误");
        }
    }

    /**
     * 根据主键id删除属性类别
     * @param id
     * @return
     */
    @RequestMapping("/propertyType/delete")
    public R deleteByTId(String id){
        int index = nhPropertyTypeService.deleteById(id);
        if (id != null){
            if (index == 1){
                return R.ok().put("result" , "删除成功");
            }
            return R.error().put("errorMsg" , "删除失败");
        }
        return R.error().put("errorMsg" , "请确认属性值是否为空");
    }

    /**
     * 根据主键id修改属性类别
     * @param propertyType
     * @return
     */
    @RequestMapping("/propertyType/update")
    public R updateById(NhPropertyType propertyType){
        int index = nhPropertyTypeService.updateById(propertyType);
        if (Strings.isNotEmpty(propertyType.toString())){
            if (index == 1){
                Date date = new Date();
                System.out.println(date);
                propertyType.setUpdateTime(date);
                return R.ok().put("result" , "修改成功");
            }
            return R.ok().put("errorMsg" , "修改失败");
        }else {
            return R.ok().put("errorMsg" , "传入参数错误");
        }
    }

    /**
     * 根据主键id查询属性类别
     * @param id
     * @return
     */
    @GetMapping("/propertyType/select" )
    public R selectById(String id){
        return R.ok().put("data" , nhPropertyTypeService.selectById(id));
    }



    /********以下属性项接口方法***********/

    @GetMapping("/propertyValue/selectPage")
    public R propertyValueSelectPage(NhPropertyValue nhPropertyValue){
        PageInfo<NhPropertyValue> pageInfo = nhPropertyValueService.selectByPage(nhPropertyValue);
        return R.ok().put("data",pageInfo);
    }



    /**
     * 根据主键id查询属性
     * @param id
     * @return
     */
    @GetMapping("/propertyValue/getById" )
    public R getById(String id){
        return R.ok().put("data" , nhPropertyValueService.selectByPrimaryKey(id));
    }

    /**
     * 根据属性类别id新增属性值
     * @param propertyValue
     * @return
     */
    @RequestMapping("/propertyValue/insert")
    public R insert(NhPropertyValue propertyValue){
        int index = nhPropertyValueService.insertPropertyValue(propertyValue);
        if (null != propertyValue ){
            if (index == 1){
                Date date = new Date();
                System.out.println(date);
                propertyValue.setCreateTime(date);
                return R.ok().put("result" , "新增成功");
            }
            return R.ok().put("errorMsg" , "新增失败");
        }else {
            return R.ok().put("errorMsg" , "传入参数错误");
        }
    }

    /**
     * 根据主键id删除属性值
     * @param id
     * @return
     */
    @RequestMapping("/propertyValue/delete")
    public R deleteByVId(String id){
        int index = nhPropertyValueService.deleteById(id);
        if (index == 1){
            return R.ok().put("result" , "删除成功");
        }
        return R.ok().put("errorMsg" , "删除失败");
    }

    /**
     * 根据属性类别id修改属性值
     * @param propertyValue
     * @return
     */
    @RequestMapping("/propertyValue/update")
    public R updateById(NhPropertyValue propertyValue){
        int index = nhPropertyValueService.updateById(propertyValue);
        if (Strings.isNotEmpty(propertyValue.toString())){
            if (index == 1){
                Date date = new Date();
                System.out.println(date);
                propertyValue.setUpdateTime(date);
                return R.ok().put("result" , "修改成功");
            }
            return R.ok().put("errorMsg" , "修改失败");
        }else {
            return R.ok().put("errorMsg" , "传入参数错误");
        }
    }

    /**
     * 根据属性类别id查询属性值
     * 分页查询
     * 萝卜 修改
     * @param
     * @return
     */
    @RequestMapping("/propertyValue/select")
    public R selectByPropertyTypeId(NhPropertyValue nhPropertyValue){
        List<NhPropertyValue> nhPropertyValues = nhPropertyValueService.selectByPropertyTypeId(nhPropertyValue);

            return R.ok().put("data" , nhPropertyValues);

    }



}
