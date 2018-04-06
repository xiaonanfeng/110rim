package com.zxit.dao;

import com.zxit.model.Hjjlb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HjjlbRepository extends JpaRepository<Hjjlb, String> {


    @Query("select count(t.hjzt),t.hjzt from Hjjlb t where t.ldsj > ?1 and  t.ldsj < ?2 group by t.hjzt order by count(t.hjzt)")
    List<Object[]> findLdsjBetweenGroupByHjzt(Date ldsjStart,Date ldsjEnd);

    @Query("select count(t.bjhm),t.bjhm from Hjjlb t where t.ldsj > ?1 and  t.ldsj < ?2 group by t.bjhm order by count(t.bjhm)")
    List<Object[]> findLdsjBetweenGroupByBjhm(Date ldsjStart,Date ldsjEnd);

    @Query("select count(t.bjhm) from Hjjlb t where t.ldsj > ?1 and  t.ldsj < ?2 and t.bjhm = '110' ")
    Long findLdsjBetweenCount110(Date ldsjStart,Date ldsjEnd);

    @Query("select count(t.bjhm) from Hjjlb t where t.ldsj > ?1 and  t.ldsj < ?2 and t.bjhm = '122' ")
    Long findLdsjBetweenCount122(Date ldsjStart,Date ldsjEnd);

    @Query("select count(t.bjhm) from Hjjlb t where t.ldsj > ?1 and  t.ldsj < ?2 and t.bjhm <> '122' and t.bjhm <>'110' ")
    Long findLdsjBetweenCountOther(Date ldsjStart,Date ldsjEnd);

}
    



