package com.lang.cache;

import jakarta.validation.constraints.NotBlank;

import java.util.concurrent.TimeUnit;

/**
 *
 * @Author: lang
 * @Since: 2026/1/10
 */
public interface DistributedCache extends Cache{

    /**
     * 缓存数据
     * @param key 缓存 key
     * @param value 缓存 value
     * @param timeout 过期时间
     * @param timeUnit 时间单位
     */
    void put(@NotBlank String key, Object value, long timeout, TimeUnit timeUnit);
}
