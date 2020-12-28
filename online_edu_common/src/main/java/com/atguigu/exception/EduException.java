package com.atguigu.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "这是一个自定义异常")
public class EduException extends  RuntimeException{

    @ApiModelProperty(value = "异常的code")
    private Integer code;

    @ApiModelProperty(value = "异常的信息")
    private String message;
}
