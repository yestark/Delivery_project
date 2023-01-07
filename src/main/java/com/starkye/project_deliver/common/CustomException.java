package com.starkye.project_deliver.common;

/**
 * 自定义业务异常
 */
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}
