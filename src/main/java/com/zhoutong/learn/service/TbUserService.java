package com.zhoutong.learn.service;


import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.TbUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserService {

    @Autowired
    private TbUserinfoDao tbUserinfoDao;


}
