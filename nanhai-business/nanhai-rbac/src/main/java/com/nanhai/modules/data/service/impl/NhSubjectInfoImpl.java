package com.nanhai.modules.data.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanhai.core.business.entity.LandSubjectRs;
import com.nanhai.core.business.entity.SubjectInfo;
import com.nanhai.core.business.exception.ApiException;
import com.nanhai.core.business.vo.SubjectInfoConditionVO;
import com.nanhai.core.business.vo.SysRoleConditionVO;
import com.nanhai.core.framework.object.MyRestTemplate;
import com.nanhai.core.framework.object.SsoUser;
import com.nanhai.core.persistence.beans.NhSubjectInfo;
import com.nanhai.modules.data.mapper.NhLandSubjectMapper;
import com.nanhai.modules.data.mapper.NhSubjectInfoMapper;
import com.nanhai.modules.data.service.NhSubjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author luobo
 * @create 2021/5/14
 */
@Service
public class NhSubjectInfoImpl implements NhSubjectInfoService {

    @Autowired
    private NhSubjectInfoMapper subjectInfoMapper;
    @Autowired
    NhLandSubjectMapper nhLandSubjectMapper;

    private static final String GATEWAY_SERVICE = "http://nanhai-zuul-gateway:8280/";


    @Override
    public NhSubjectInfo insert(NhSubjectInfo entity) {
        return null;
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean updateSelective(NhSubjectInfo entity) {
        return false;
    }

    @Override
    public NhSubjectInfo getByPrimaryKey(Long primaryKey) {
        return null;
    }


    @Autowired
    private MyRestTemplate myRestTemplate;

    @Override
    public void insertSubjectInfo(SubjectInfo subjectInfo) {


        subjectInfo.getNhSubjectInfo().setCreateTime(new Date());

        this.isExist(subjectInfo);
        subjectInfo.setSubjectCode(UUID.randomUUID().toString());
        if (null != subjectInfo.getSubjectType() && subjectInfo.getSubjectType() == 1) {
            if (null != subjectInfo.getSubjectCard()) {
                subjectInfo.setSubjectCode(subjectInfo.getSubjectCard());
            }
        } else {
            if (null != subjectInfo.getSubjectUscCode()) {
                subjectInfo.setSubjectCode(subjectInfo.getSubjectUscCode());
            }
        }

        if (subjectInfo.getSubjectCode() != null) {
            Example example3 = new Example(NhSubjectInfo.class);
            Example.Criteria criteria3 = example3.createCriteria();
            criteria3.andNotEqualTo("id", subjectInfo.getId());
            criteria3.andEqualTo("subjectCode", subjectInfo.getSubjectCode());
            int res3 = subjectInfoMapper.selectCountByExample(example3);
            if (res3 > 0) {
                throw new ApiException("组织编码或者统一信用编码已经存在");
            }
        }
        subjectInfoMapper.insertUseGeneratedKeys(subjectInfo.getNhSubjectInfo());
        System.out.println(subjectInfo.getNhSubjectInfo());

    }

    @Override
    public PageInfo<NhSubjectInfo> findPageBreakByCondition(SubjectInfoConditionVO subjectInfoConditionVO, SsoUser parse) {
        PageHelper.startPage(subjectInfoConditionVO.getPageNumber(), subjectInfoConditionVO.getPageSize());
        System.out.println("aaaa"+subjectInfoConditionVO.getSubjectIndustryList());
        List<NhSubjectInfo> list = subjectInfoMapper.findPageBreakByCondition(subjectInfoConditionVO);
        String imgs;
        for (NhSubjectInfo nh : list) {
            if (nh.getImgUrl() != null && !"".equals(nh.getImgUrl())) {
                try {
                imgs = myRestTemplate.getForObject(GATEWAY_SERVICE + "/oss/file/getList?pictureIds=" + nh.getImgUrl(), String.class);
                JSONObject j1 = JSONObject.parseObject(imgs);
                nh.setOssImgList(j1.getJSONArray("data"));
                }catch (Exception e){
                    nh.setOssImgList(new JSONArray());
                }
            }
            List<LandSubjectRs> res = nhLandSubjectMapper.findLandSubject1(nh.getSubjectCode(), null);
            nh.setLandSubjectRs(res);

        }
        return new PageInfo<>(list);
    }


    @Override
    public void updateSubjectInfo(SubjectInfo subjectInfo) {
        NhSubjectInfo nhSubjectInfo = subjectInfoMapper.selectByPrimaryKey(subjectInfo.getId());
        if (null == nhSubjectInfo) {
            throw new ApiException("找不到相关主体记录");
        }
        System.out.println("aaaa"+subjectInfo.getNhSubjectInfo());
        this.isExist(subjectInfo);
        subjectInfo.setSubjectCode(nhSubjectInfo.getSubjectCode());
        subjectInfo.getNhSubjectInfo().setUpdateTime(new Date());
        subjectInfoMapper.updateByPrimaryKeySelective(subjectInfo.getNhSubjectInfo());
    }

    private void isExist(SubjectInfo subjectInfo) {
        if (null == subjectInfo.getSubjectYearTotalValue()) {
            throw new ApiException("请输入正确年产值");
        }
        if (subjectInfo.getSubjectLinkman() == null || subjectInfo.getSubjectTele() == null) {
            throw new ApiException("联系人，联系电话为空");
        }
        Example example = new Example(NhSubjectInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("subjectTele", subjectInfo.getSubjectTele());
        criteria.andEqualTo("subjectLinkman", subjectInfo.getSubjectLinkman());
        criteria.andNotEqualTo("id", subjectInfo.getId());

        int res = subjectInfoMapper.selectCountByExample(example);
        if (res > 0) {
            throw new ApiException("联系人信息重复");
        }
        if (subjectInfo.getSubjectCard() != null) {
            Example example2 = new Example(NhSubjectInfo.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andNotEqualTo("id", subjectInfo.getId());
            criteria2.andEqualTo("subjectCard", subjectInfo.getSubjectCard());
            int res2 = subjectInfoMapper.selectCountByExample(example2);
            if (res2 > 0) {
                throw new ApiException("身份证号码重复");
            }
        }
    }




}
