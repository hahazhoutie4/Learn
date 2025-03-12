package com.zhoutong.learn;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.zhoutong.learn.configuration.DefineLogger;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {

    private final static  String job = "C:\\Users\\周同\\Desktop\\工作表.json";
    private final static String music = "C:\\Users\\周同\\Desktop\\音乐.json";

    @DefineLogger
    private Logger logger;


    @Test
    public void generateData() throws IOException {


        File mus = new File(music);
        File jb = new File(job);
        BufferedReader musReader = new BufferedReader(new InputStreamReader(new FileInputStream(mus)));
        BufferedReader jbReader = new BufferedReader(new InputStreamReader(new FileInputStream(jb)));
        String jsonMusic = "";
        String jsonJb = "";
       String line="";
        while((line = musReader.readLine())!=null){

            jsonMusic +=line;
        }
        while((line = jbReader.readLine())!=null){
            jsonJb +=line;
        }
  //      System.out.println(jsonMusic);
   //     System.out.println(jsonJb);
        JSONObject jsonObject= JSONObject.parse(jsonMusic);
        JSONObject jsonObject1 = JSONObject.parse(jsonJb);
//        System.out.println(jsonObject1);
        Map<String,String> musicmap = new HashMap<>();
        String param ="";
        int id =1;
        for (String s : jsonObject1.keySet()) {
            JSONObject data = jsonObject1.getJSONObject(s);
            param +="(";
            for(String key : data.keySet()){
                param += "'" + data.getString(key)   ;
              if(id==7){
                  param +="'),";
              }else{
                  param +="',";
              }
                id++;
            }
        id=1;
            param += "\r\n";
 //           param += "(" +id + ",'" + s + "','" + jsonObject1.getJSONObject(s) + "'),\r\n" ;
 //           id++;
        }
        logger.info(param);

 //       System.out.println(param);


    }

}
