package com.michael.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: CommonResult
 * @Package com.michael.springcloud.entities
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/21 17:05
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message,null);
    }
}
