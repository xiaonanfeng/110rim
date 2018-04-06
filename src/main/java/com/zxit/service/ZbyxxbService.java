package com.zxit.service;

import com.zxit.model.Zbyxxb;

import java.util.List;

/**
 * Created by xiaonanfeng on 2018/3/31.
 * 每天都在写BUG！
 */
public interface ZbyxxbService {

    Zbyxxb findOne(String id);

    List<Zbyxxb> findAll();

    Zbyxxb findZbyxxbByIdAndMm(String id,String mm);

}
