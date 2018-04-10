package com.xrq.repository;

import com.xrq.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017/7/12.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    public List<Girl> findByAge(Integer age);
}
