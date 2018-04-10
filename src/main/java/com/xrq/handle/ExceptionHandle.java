package com.xrq.handle;

import com.xrq.Exception.GirlException;
import com.xrq.domain.Result;
import com.xrq.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 2017/7/23.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
  public Result handle(Exception e)
  {
      if(e instanceof GirlException)
      {
          GirlException girlException=(GirlException)e;
          return ResultUtil.error(girlException.getCode(),girlException.getMessage());

      }
      else {
          return ResultUtil.error(-1,"未知错误");
      }

  }
}
