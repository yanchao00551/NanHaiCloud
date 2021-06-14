package com.nanhai.file.service.impl;

import com.nanhai.core.business.entity.Picture;
import com.nanhai.core.business.vo.PictureConditionVO;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.persistence.beans.NhPicture;
import com.nanhai.file.alioss.api.OssApi;
import com.nanhai.file.mapper.NhPictureMapper;
import com.nanhai.file.service.NhPictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author luobo
 * @create 2021/5/14
 */
@Service
public class NhPictureImpl implements NhPictureService {
    @Resource
    NhPictureMapper nhPictureMapper;
    /**
     * oss上传文件
     * @param file
     * @return
     */
    @Override
    public String   uploadFile(MultipartFile file){
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI5tNHnq8hyzD8Ec3eNuzV";
        String accessKeySecret = "6mU4bnCdTKUTjgLuVVLP4XjEGYG509";
        String newBucketName = "hujunjie";
        String fileHost = "nanhai";
        // 获取文件原名称
        String originalFilename = file.getOriginalFilename();
        // 获取文件类型
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + fileType;
        String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String uploadImgeUrl = fileHost + "/" + filePath + "/" + newFileName;
        String returnImgeUrl = "";

        OssApi ossApi = new OssApi(endpoint, accessKeyId, accessKeySecret);
        System.out.println("newBucketName"+newBucketName);
        try {
            InputStream inputStream = null;
            inputStream = file.getInputStream();
            System.out.println("newBucketName"+newBucketName);
            ossApi.uploadFile(inputStream, uploadImgeUrl, newBucketName);
            returnImgeUrl = "https://" + newBucketName + "." + endpoint + "/" + uploadImgeUrl;
            return returnImgeUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String,Object> insertPicture(String ossFileUrl) {

        NhPicture nhPicture=new NhPicture();
        nhPicture.setImgUrl(ossFileUrl);
        Map<String,Object > map=new HashMap<>(10);

        if(nhPictureMapper.insertPicture(nhPicture)<=0){
           System.out.println("到时候抛出异常");
       }
        map.put("id",nhPicture.getId());
        map.put("imgUrl",ossFileUrl);
        return  map;
    }

    @Override
    public List<Picture> getPictureListById(PictureConditionVO vo) {
        Example example = new Example(NhPicture.class);
        example.createCriteria().andIn("id",vo.getPictureIds());

        List<NhPicture> list= nhPictureMapper.selectByExample(example);

        List<Picture> pictures = new LinkedList<>();

        list.stream().forEach((item) -> {
            pictures.add(new Picture(item));
        });

        return pictures;
    }

    @Override
    public NhPicture insert(NhPicture entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(NhPicture entity) {
        return false;
    }

    @Override
    public NhPicture getByPrimaryKey(Long primaryKey) {
        return null;
    }
}
