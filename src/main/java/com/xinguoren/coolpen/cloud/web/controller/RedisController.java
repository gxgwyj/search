package com.xinguoren.coolpen.cloud.web.controller;

import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    RedisClient redisClient;

    /**
     * redis操作页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView redis(HttpServletRequest request){
        return new ModelAndView("/tools/redis");
    }

    /**
     * set操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/set")
    @ResponseBody
    public Object set(HttpServletRequest  request){
        String key = request.getParameter("key");
        String content = request.getParameter("content");
        return redisClient.set(key,content);
    }

    /**
     * hmet 操作
     * @param map
     * @return
     */
    @RequestMapping(value = "/hmet")
    @ResponseBody
    public Object hmet(@RequestBody Map map){
        String hkey = map.get("hkey").toString();
        Map<String,String> hmap = (Map<String,String>)map.get("map");
        return redisClient.hmset(hkey,hmap);
    }

}
