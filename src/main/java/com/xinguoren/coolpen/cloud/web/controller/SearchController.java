package com.xinguoren.coolpen.cloud.web.controller;

import com.xinguoren.coolpen.cloud.web.common.utils.PropertiesUtils;
import com.xinguoren.coolpen.cloud.web.model.Blog;
import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/12.
 */
@Controller
public class SearchController {

    @Autowired
    RedisClient  redisClient;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/config")
    @ResponseBody
    public Object config(HttpServletRequest  request){
        String key = request.getParameter("key");
        return PropertiesUtils.getValueByKey(key);
    }

    @RequestMapping(value = "/redis")
    public ModelAndView redis(HttpServletRequest  request){
        return new ModelAndView("/tools/redis");
    }

    @RequestMapping(value = "/redis/add")
    @ResponseBody
    public Object add(HttpServletRequest  request){
        String key = request.getParameter("key");
        String content = request.getParameter("content");
        return redisClient.set(key,content);
    }



    @RequestMapping(value = "/man",method = RequestMethod.POST)
    @ResponseBody
    public Object man(@RequestBody Blog blog){
        Map<String,String> map = new HashMap<String,String>();
        map.put("result","success");
        map.put("code","00123");
        map.put("message","操作成功");
        return map;
    }

}
