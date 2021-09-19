package com.nanhai.file.service;


import com.nanhai.core.business.entity.Picture;
import com.nanhai.core.business.vo.PictureConditionVO;
import com.nanhai.core.framework.object.AbstractService;
import com.nanhai.core.persistence.beans.NhPicture;
import com.nanhai.file.alioss.api.OssApi;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author luobo
 * @create 2021/5/14
 */

public interface NhPictureService  extends AbstractService<NhPicture,Long> {

    String uploadFile(MultipartFile file);


    Map<String,Object> insertPicture(String OssFileUrl);



    List<Picture> getPictureListById(PictureConditionVO idList);
}
