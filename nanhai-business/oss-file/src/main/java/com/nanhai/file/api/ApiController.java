package com.nanhai.file.api;

import com.alibaba.fastjson.JSON;
import com.nanhai.core.business.entity.Picture;
import com.nanhai.core.business.vo.PictureConditionVO;
import com.nanhai.core.framework.object.AbstractController;
import com.nanhai.core.util.R;
import com.nanhai.file.service.NhPictureService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author luobo
 * @create 2021/5/14
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class ApiController  extends AbstractController {
    private final NhPictureService ossService;

    public ApiController(NhPictureService ossService) {
        this.ossService = ossService;
    }


    @PostMapping("/upload")
    public R uploadFile(@RequestParam("file") MultipartFile file) {
        return R.ok().put("data", (ossService.insertPicture (ossService.uploadFile(file))))     ;
    }

    @GetMapping(value = {"/getList"})
    public R getPictureListById(PictureConditionVO vo){
        List<Picture> res=   ossService.getPictureListById(vo);
        return  R.ok().put("data", res);
    }


}
