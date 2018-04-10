package com.xrq.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.xrq.aspect.HttpAspect;
import com.xrq.domain.Girl;
import com.xrq.domain.Result;
import com.xrq.repository.GirlRepository;
import com.xrq.service.GirlService;
import com.xrq.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 2017/7/12.
 */
@RestController
public class GirlController {
    private  final static Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    //查找全部女生
    @GetMapping(value = "/girls")
    public List<Girl> girlList()
    {
        logger.info("getlist");
        return girlRepository.findAll();
    }
    //保存一个女生
    @PostMapping(value="/girls")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult)
    {
      /* Girl girl=new Girl();
       girl.setCupSize(cupSize);
       girl.setAge(age);*/
      if(bindingResult.hasErrors())
      {
         /* Result result=new Result();
          result.setCode(1);
          result.setMessage(bindingResult.getFieldError().getDefaultMessage());*/
          return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
      }
       /* Result result=new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(girlRepository.save(girl));*/
        return ResultUtil.success(girlRepository.save(girl));
    }
    //得到一个女生
    @GetMapping(value="/girls/{id}")
    public Girl getOne(@PathVariable("id")Integer id)
    {
      return girlRepository.findOne(id);
    }

    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age)
    {
        Girl girl=new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }
    //根据一个id删除一个女生
    @DeleteMapping (value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id)
    {
        girlRepository.delete(id);
    }
    //通过年龄查找女生
    @GetMapping(value="/girls/age/{age}")
    public List<Girl> girlListbyAge(@PathVariable("age") Integer age)
    {
        return girlRepository.findByAge(age);
    }

    @PostMapping (value="/girls/inserttwo")
    public void girltwo()
    {
        girlService.inserttwo();
    }

    @GetMapping(value="/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception
    {
        girlService.getAge(id);
    }
}
