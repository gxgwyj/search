package com.xinguoren.coolpen.cloud.web.redis.impl;

import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/1/10.
 */
@Component
public class RedisClientSingle implements RedisClient {
    @Autowired
    JedisPool  jedisPool;

    public String get(String key) {
        try {
            Jedis  jedis = jedisPool.getResource();
            String str = jedis.get(key);
            jedis.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String set(String key, String value) {
        try {
            Jedis jedis = jedisPool.getResource();
            String str =  jedis.set(key, value);
            jedis.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public Long del(String key) {
            Jedis jedis = jedisPool.getResource();
            Long result = jedis.del(key);
            jedis.close();
            return result;
    }
}
