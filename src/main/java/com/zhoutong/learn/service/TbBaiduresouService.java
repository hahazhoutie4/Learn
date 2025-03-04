package com.zhoutong.learn.service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.zhoutong.learn.model.TbBaiduresou;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TbBaiduresouService {


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

}
