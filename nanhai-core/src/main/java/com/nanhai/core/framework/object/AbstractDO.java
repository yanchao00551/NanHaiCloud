package com.nanhai.core.framework.object;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractDO implements Serializable {
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     */
    private static final long serialVersionUID = 5088697673359856350L;


    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;


}
