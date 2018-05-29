package com.wzq.springboot.util;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {
    @Autowired
    RedisTemplate redisTemplate;

    public Boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void put(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 3600, TimeUnit.SECONDS);
    }

    public void putMap(String key, Map<String, Object> map) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(map).toString());
    }


    public void putMap(String key, Map<String, Object> map, int expireSecond) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(map).toString());
        redisTemplate.expire(key, expireSecond, TimeUnit.SECONDS);
    }

    public void putClass(String key, Object obj, int expireSecond) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(obj).toString());
        redisTemplate.expire(key, expireSecond, TimeUnit.SECONDS);
    }

    public Map<String, Object> getMap(String key) {
        Gson gson = new Gson();
        Object obj = getValue(key);
        if (obj != null)
            return gson.fromJson(obj.toString(), new HashMap<String, Object>().getClass());
        else
            return null;

    }


    public void put(String key, String value, int expireSecond) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expireSecond, TimeUnit.SECONDS);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void deleteKeys(String prefix) {
        Set<String> keys = redisTemplate.keys(String.format("%s*", prefix));
        redisTemplate.delete(keys);
    }

    public void flushAll() {
        Set<String> keys = redisTemplate.keys("cache_*");
        redisTemplate.delete(keys);
    }

}
