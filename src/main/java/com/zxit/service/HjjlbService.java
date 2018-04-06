package com.zxit.service;

import com.zxit.model.dto.CountDto;

import java.util.Date;
import java.util.List;

/**
 * Created by xiaonanfeng on 2018/4/4.
 * 每天都在写BUG！
 */
public interface HjjlbService {

    List<CountDto> findLdsjBetweenGroupByHjzt(Date ldsjStart, Date ldsjEnd);


    List<CountDto> findLdsjBetweenGroupByBjhm(Date ldsjStart, Date ldsjEnd);

}
