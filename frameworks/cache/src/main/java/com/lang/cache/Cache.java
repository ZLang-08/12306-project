package com.lang.cache;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 缓存接口
 *
 * @Author: lang
 * @Since: 2026/1/10
 */
public interface Cache {

    /**
     * 获取缓存
     */
    <T> T get(@NotBlank String key, Class<T> clazz);

    /**
     * 放入缓存
     */
    void put(@NotBlank String key, @NotNull Object value);


}
