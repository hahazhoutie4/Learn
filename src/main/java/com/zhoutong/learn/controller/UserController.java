package com.zhoutong.learn.controller;


import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.configuration.DefineLogger;
import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.Result;
import com.zhoutong.learn.model.TbUserinfo;
import com.zhoutong.learn.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @DefineLogger
    private Logger logger;

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbUserinfoDao tbUserinfoDao;
    @GetMapping
    public Result list(){
        List<TbUserinfo> list = tbUserinfoDao.list();
        Result r = Result.okResult(list);
        logger.info("查询所有信息：{}",r);
        return r;
    }
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable(name="id") int id){
        List<TbUserinfo>  user = tbUserinfoDao.getUserById(id);
        Result r = Result.okResult(user);
        logger.info("根据id查询信息：{}",r);
        return r;
    }
    @PostMapping("/insert")
    public Result insertUser(@RequestBody TbUserinfo tb_userinfo){
        int result = tbUserinfoDao.insertUser(tb_userinfo);   //update_ numbers
        if(result>0){
            logger.info("插入成功:{}",result);
            return Result.okResult("插入字段的主键id:"+tb_userinfo.getId());
        }
        logger.info("插入失败:{}",result);
        return Result.errorResult("插入字段失败");
    }

    @PostMapping
    public Result login(@RequestBody TbUserinfo tb_userinfo){

        logger.info("登录操作:{}",tb_userinfo);
        TbUserinfo user = tbUserService.login(tb_userinfo);
        //插入JWT令牌生成，利用user
        return user!=null?Result.okResult("test"):Result.errorResult("error");
    }


}
