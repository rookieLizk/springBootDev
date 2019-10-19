package com.mould.boot.advice;

import com.mould.boot.exception.MyException;
import com.mould.boot.net.NetworkUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @Autowired
//    private MessageSource messageSource;
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<Object> exceptionHandler(MyException ex, HttpServletRequest request){
        log.error("[MyException-REQUEST] api: {},ip:{},请求错误,{}",request.getRequestURI(), NetworkUtils.getIpAddress(request),ex.getMsg());
        try {
            return  new ResponseEntity<>(ex.toObject(), HttpStatus.valueOf(ex.getCode()) );
        } catch (Exception e) {
            return  new ResponseEntity<>("service error", HttpStatus.valueOf(500));
        }
    }
    /*@ExceptionHandler(Throwable.class)
    public ResponseEntity<Result> handleGlobalExceptionResponse(Throwable e, HttpServletRequest request){
        log.error("[Exception-REQUEST] api: {},ip:{},请求错误,{}",request.getRequestURI(),NetworkUtils.getIpAddress(request),e.getMessage());
        return ExecptionResponseHandlerUtil.handleGlobalException(request,messageSource);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Result> handleApiExceptionResponse(ApiException apiException, HttpServletRequest request){
        log.error("[ApiException-REQUEST] api: {},ip:{},请求错误,{}",request.getRequestURI(),NetworkUtils.getIpAddress(request),apiException.getErrorKey());
        return ExecptionResponseHandlerUtil.handleApiException(request,messageSource,apiException);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Result> handleServiceExceptionResponse(BusinessException businessException, HttpServletRequest request){
        log.error("[BusinessException-REQUEST] api: {},ip:{},请求错误,{}",request.getRequestURI(),NetworkUtils.getIpAddress(request),businessException.getErrorKey());
        return ExecptionResponseHandlerUtil.handlBusinessException(request,messageSource,businessException);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        log.error("[MethodArgumentNotValidException-REQUEST] api: {},ip:{},请求错误,{}",request.getRequestURI(),NetworkUtils.getIpAddress(request),e.getMessage());
        String key = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ExecptionResponseHandlerUtil.handleApiException(request,messageSource,new ApiException(key));
    }*/
}
