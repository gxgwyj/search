package com.xinguoren.coolpen.cloud.web.controller;

import com.xinguoren.coolpen.cloud.web.common.utils.PropertiesUtils;
import com.xinguoren.coolpen.cloud.web.model.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/12.
 */
@Controller
public class SearchController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/config")
    @ResponseBody
    public Object config(HttpServletRequest request) {
        String key = request.getParameter("key");
        return PropertiesUtils.getValueByKey(key);
    }

    @RequestMapping(value = "/man", method = RequestMethod.POST)
    @ResponseBody
    public Object man(@RequestBody Blog blog) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "success");
        map.put("code", "00123");
        map.put("message", "操作成功");
        return map;
    }

}
