package com.xrq.service;

import com.xrq.Exception.GirlException;
import com.xrq.domain.Girl;
import com.xrq.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2017/7/12.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void inserttwo()
    {
        Girl girlA=new Girl();
        girlA.setCupSize("X");
        girlA.setAge(25);
        girlRepository.save(girlA);

        Girl girlb=new Girl();
        girlb.setCupSize("XXXXXX");
        girlb.setAge(2);
        girlRepository.save(girlb);
    }

    public void getAge(Integer id)throws Exception
    {
        Girl girl = girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<10)
        {
           //小学
            throw new GirlException(100,"你还在上小学吧 ！");
        }
        else if (age>10 && age<16)
        {
            //初中
            throw new GirlException(101,"你还在上初中吧 ！");
        }
    }
}
