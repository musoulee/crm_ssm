package com.ml.commons.entity;

import lombok.Data;

/**
 * @description: ResponseBody
 * @author: musou
 * @Date: 2022/4/10 3:32 PM
 */
@Data
public class ResponseObject {
    private String code;
    private String message;
    private Object resultData;
}
