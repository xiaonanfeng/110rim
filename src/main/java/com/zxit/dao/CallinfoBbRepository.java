package com.zxit.dao;

import com.zxit.model.CallinfoBb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CallinfoBbRepository extends JpaRepository<CallinfoBb, String> {

    @Query("select t from CallinfoBb t where t.eventid = ?1 order by t.guid asc")
    List<CallinfoBb> findCallinfoBbByEventid(String eventid);

}