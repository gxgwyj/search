package com.xinguoren.coolpen.cloud.web.redis;

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



}
