package com.zxit.dao;

import com.zxit.model.CallinfoBb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author nanxiaofeng
 * @date 2018
 * 录音流水表
 */
public interface CallinfoBbRepository extends JpaRepository<CallinfoBb, String> {

    /**
     * 通过录音时间ID查询录音集合
     * @param eventid
     * @return
     */
    @Query("select t from CallinfoBb t where t.eventid = ?1 order by t.guid asc")
    List<CallinfoBb> findCallinfoBbByEventid(String eventid);

}