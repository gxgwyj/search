package com.xinguoren.coolpen.cloud.web.redis;

import java.util.Map;

/**
 * Created by Administrator on 2017/1/10.
 */
public interface RedisClient {
    /**
     * 设置key
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     * 获取key
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 删除key
     * @param key
     * @return
     */
    Long del(String key);

    /**
     * 设置hash
     * @param hkey
     * @param map
     * @return
     */
    public String hmset(String hkey,Map<String,String> map);



}
