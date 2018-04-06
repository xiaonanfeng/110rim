package com.zxit.service;

import com.zxit.model.Jjdwb;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by xiaonanfeng on 2018/4/1.
 * 每天都在写BUG！
 */
public interface JjdwbService {

    List<Jjdwb> findAll(Sort sort);

}
