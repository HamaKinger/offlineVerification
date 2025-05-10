package org.freedom.verification.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.freedom.verification.enums.ResultCode;
import org.freedom.verification.enums.ResultCodeEnum;

/**
 * 响应返回
 * @author: freedom
 * @Date: 2021/6/4 14:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> {
    /**
     * 响应码
     */
    private int code ;
    /**
     * 响应信息
     */
    private String msg ;
    /**
     * 相关数据
     */
    private T data ;

    public static <T> Result<T> success(){
        return Result.<T>builder().code(ResultCodeEnum.SUCCESS.getCode())
                .msg(ResultCodeEnum.SUCCESS.getMsg()).build();
    }
    public static <T> Result<T> success(T data){
        return Result.<T>builder().code(ResultCodeEnum.SUCCESS.getCode())
                .msg(ResultCodeEnum.SUCCESS.getMsg()).data(data).build();
    }

    public static <T> Result<T> success(String msg){
        return Result.<T>builder().code(ResultCodeEnum.SUCCESS.getCode())
                .msg(msg).build();
    }
    public static <T> Result<T> success(String msg,T data){
        return Result.<T>builder().code(ResultCodeEnum.SUCCESS.getCode())
                .msg(msg).data(data).build();
    }
    public static <T> Result<T> failed(){
        return Result.<T>builder().code(ResultCodeEnum.FAILD.getCode()).msg(ResultCodeEnum.FAILD.getMsg()).build();
    }
    public static <T> Result<T> failed(ResultCode resultCode,String msg){
        return Result.<T>builder().code(resultCode.getCode()).msg(msg).build();
    }

    public static <T> Result<T> failed(String msg){
        return Result.<T>builder().code(ResultCodeEnum.FAILD.getCode()).msg(msg).build();
    }

    public static <T> Result<T> failed(ResultCode code,String msg,T data){
        return Result.<T>builder().code(code.getCode()).msg(msg).data(data).build();
    }

}
