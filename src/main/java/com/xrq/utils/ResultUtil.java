package com.xrq.utils;

import com.xrq.domain.Result;

/**
 * Created by user on 2017/7/23.
 */
public class ResultUtil {
    public static Result success(Object object)
    {
        Result result=new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }
    public static Result success()
    {
        return success(null);
    }



    public static Result error(Integer code, String mesg)
    {
        Result result=new Result();
        result.setCode(code);
        result.setMessage(mesg);
        return result;
    }

}
