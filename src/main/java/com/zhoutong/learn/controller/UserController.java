package com.zhoutong.learn.controller;

import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.model.Result;
import com.zhoutong.learn.model.ResultImpl;
import com.zhoutong.learn.model.TbBaiduresou;
import com.zhoutong.learn.service.TbBaiduresouService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private TbBaiduresouService tbBaiduresouService;

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;
    @GetMapping("/resou/limit/{page}/{number}")
    public Result resouListLimit(@PathVariable(name = "page")int page ,
                                 @PathVariable(name = "number")int number){
        List<TbBaiduresou> tbBaiduresous = tbBaiduresouDao.listLimit(page,number);
        return ResultImpl.okResult(tbBaiduresous);
    }

    @PostMapping("/resou/insert")
    public Result inserData(@RequestBody String jsonString) {
        List<TbBaiduresou> tbBaiduresous = tbBaiduresouService.parseJson(jsonString);
        AtomicInteger code = new AtomicInteger();
        code.set(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                synchronized (tbBaiduresous){
                    tbBaiduresous.stream().forEach(e->{
                        tbBaiduresouDao.insertData(e);
                        log.info("插入数据完毕");
                        code.set(1);
                    });
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            log.info("插入数据错误",e);
        }
        if(code.get()==0){
            return ResultImpl.errorResult("插入数据失败");
        }
        return ResultImpl.okResult("插入字段成功");
    }

}
