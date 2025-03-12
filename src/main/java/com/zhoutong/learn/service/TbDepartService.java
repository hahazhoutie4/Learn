package com.zhoutong.learn.service;

import com.zhoutong.learn.mapper.DepartDao;
import com.zhoutong.learn.model.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbDepartService {

    @Autowired
    private DepartDao departDao;

    public List<Depart> findAllDepart(){
        List<Depart> list =departDao.findAllDepart();
        return  list;
    }

    public List<Depart> getDepartById(int id) {
     List<Depart> list=   departDao.getDepartById(id);
     return  list;
    }
}
