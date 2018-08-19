package com.zxit.dao;

import com.zxit.model.Zbyxxb;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nanxiaofeng
 * @date 2018
 * 值班员信息表
 */
public interface ZbyxxbRepository extends JpaRepository<Zbyxxb,String> {
    /**
     * 通过id和密码查询用户信息
     * @param id
     * @param mm
     * @return
     */
    Zbyxxb findZbyxxbByIdAndMm(String id, String mm);
}