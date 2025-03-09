package com.zhoutong.learn.service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.model.PageBean;
import com.zhoutong.learn.model.TbBaiduresou;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TbBaiduresouService {

    private static final Logger log = LoggerFactory.getLogger(TbBaiduresouService.class);

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;

    /**
     *   解析json的方法
     * @param json
     * @return List<TbBaiduresou>
     */
    public List<TbBaiduresou> parseJson(String json){
        List<TbBaiduresou> list = new ArrayList<>();
        JSONObject parse = JSONObject.parse(json);
        Set<String> keyset = parse.keySet();
        for(String key : keyset){
            JSONArray jsonArray = parse.getJSONArray(key);
            jsonArray.stream().forEach(e->
            {
                list.add(new TbBaiduresou(key,(String)e));
            });
        }
        return list;
    }
    /**
     *  分页查询pageHelper实现
     * @param page
     * @param pageSize
     * @return
     */
    public PageBean getPage(int page, int pageSize) {
        int page_ = (page -1)*pageSize;
        Page<TbBaiduresou> pg =PageHelper.startPage(page_,pageSize);
        List<TbBaiduresou> list =this.listData();
        log.info("分页查询数据:{}",pg);
        log.info("分页查询数据完毕,数据:{}",list.toString());
        Page<TbBaiduresou> res = (Page<TbBaiduresou>) list;
        return new PageBean(res.getTotal(),pg.getResult());
    }

    /**
     *  插入json格式对象
     * @param jsonString
     * @return
     */
    public int insertData(String jsonString) {
        List<TbBaiduresou> tbBaiduresous = this.parseJson(jsonString);
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
        return code.get();
    }

    /**
     * 查询所有热搜数据
     * @return
     */
    public List<TbBaiduresou> listData(){
        return tbBaiduresouDao.list();
    }

    public List<TbBaiduresou> listDataLimit(int page, int pageSize){
        return tbBaiduresouDao.listLimit(page,pageSize);
    }

}
