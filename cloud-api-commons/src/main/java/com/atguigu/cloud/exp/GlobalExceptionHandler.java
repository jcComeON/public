//package com.atguigu.cloud.exp;
//
//import com.atguigu.cloud.resp.ResultData;
//import com.atguigu.cloud.resp.ReturnCodeEnum;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@Slf4j
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    /**
//     * 全局异常处理
//     */
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResultData<String> handleException(Exception e){
//        log.error("##########系统异常:{}##########",e.getMessage(),e);
//        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
//    }
//}
