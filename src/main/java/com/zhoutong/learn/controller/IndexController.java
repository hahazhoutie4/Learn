package com.zhoutong.learn.controller;

import com.zhoutong.learn.mapper.DepartDao;
import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.Depart;
import com.zhoutong.learn.model.Result;
import com.zhoutong.learn.model.ResultImpl;
import com.zhoutong.learn.model.TbUserinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class IndexController {

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;

    @Autowired
    private DepartDao departDao;

    @Autowired
    private TbUserinfoDao tb_userinfoDao;
    @RequestMapping("/depart")
    public Result getDepart(){
        List<Depart> list = departDao.list();
        Result r = ResultImpl.okResult(list);
        System.out.println(r);
        return r;
    }
    @RequestMapping("/depart/{id}")
    public Result getDepartById(@PathVariable(name="id")int id){
        List<Depart> depart = departDao.getDepartById(id);
        Result r = ResultImpl.okResult(depart);
        System.out.println(r);
        return r;
    }
    @RequestMapping("/user")
    public Result list(){
        List<TbUserinfo> list = tb_userinfoDao.list();
        Result r = ResultImpl.okResult(list);
        System.out.println(r);
        return r;
    }
    @RequestMapping("/user/{id}")
    public Result getUserById(@PathVariable(name="id") int id){
        List<TbUserinfo>  user = tb_userinfoDao.getUserById(id);
        Result r = ResultImpl.okResult(user);
        System.out.println(r);
        return r;
    }
    @RequestMapping("/user/insert")
    public Result insertUser(@RequestBody TbUserinfo tb_userinfo){
        int result = tb_userinfoDao.insertUser(tb_userinfo);   //update_ numbers
        if(result>0){
            return ResultImpl.okResult("插入字段的主键id:"+tb_userinfo.getId());
        }
       return ResultImpl.errorResult("插入字段失败");
    }
    @RequestMapping("/baiduresou/insert")
    public Result inserData(@RequestBody String jsonString) {
        return ResultImpl.okResult("插入字段成功");
    }
}
