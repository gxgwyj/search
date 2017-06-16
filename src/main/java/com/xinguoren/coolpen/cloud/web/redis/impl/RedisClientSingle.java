package com.xinguoren.coolpen.cloud.web.redis.impl;

import com.xinguoren.coolpen.cloud.web.redis.RedisClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * Created by Administrator on 2017/1/10.
 */
@Component
public class RedisClientSingle implements RedisClient {
    private static Logger logger = Logger.getLogger(RedisClientSingle.class);
    @Autowired
    JedisPool jedisPool;

    @Override
    public String get(String key) {
        try {
            Jedis jedis = jedisPool.getResource();
            String str = jedis.get(key);
            jedis.close();
            return str;
        } catch (Exception e) {
            logger.info("redis get error", e);
            return "";
        }
    }

    @Override
    public String set(String key, String value) {
        try {
            Jedis jedis = jedisPool.getResource();
            String str = jedis.set(key, value);
            jedis.close();
            return str;
        } catch (Exception e) {
            logger.info("redis set error", e);
            return "";
        }
    }

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public String hmset(String hkey, Map<String, String> map) {
        try {
            Jedis jedis = jedisPool.getResource();
            String result = jedis.hmset(hkey, map);
            return result;
        } catch (Exception e) {
            logger.info("redis hmset error", e);
            return "";
        }
    }
}
