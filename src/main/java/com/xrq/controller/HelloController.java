package com.xrq.controller;

import com.xrq.properties.GirlPoperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/** hhh
 * Created by user on 2017/7/11.
 */
@RestController
@RequestMapping("/HELLOCONTROLLER")
public class HelloController {

    @Value("${cupSize}")
    private String cupsize;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlPoperties girlPoperties;

    @RequestMapping(value={"/hello/{id}","/hi"},method = RequestMethod.POST)
    public String hello(@PathVariable("id") Integer id)
    {
        return "id："+id;
      /*  return girlPoperties.getCupSize();*/
    }
    @RequestMapping(value={"/bye"},method = RequestMethod.GET)
    public String bye(@RequestParam(value="id",required = false,defaultValue = "0") Integer id)
    {
        return "id："+id;
    }


}
