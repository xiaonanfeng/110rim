package com.zxit.service;


import com.zxit.model.CallinfoBb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by xiaonanfeng on 2018/3/31.
 * 每天都在写BUG！
 */
public interface CallinfoBbService {

    CallinfoBb findOne(String guid);

    /**
     * 根据接警号查询录音集合
     * @param eventid
     * @return
     */
    List<CallinfoBb> findCallinfoBbByEventid(String eventid);

    /**
     * 根据录音ID查询录音文件的http路径
     * @param guid
     * @return
     */
    String findRecPathByEventId(String guid);
}
