package com.nanhai.file.alioss.entity;

import com.nanhai.file.alioss.entity.AbstractEntity;
import lombok.Data;

import java.util.List;


@Data
public class RefererEntity extends AbstractEntity {

    List<String> refererList;

    public RefererEntity(String bucketName) {
        super(bucketName);
    }

    public void setRefererList(List<String> refererList) {
        this.refererList = refererList;
    }
}
