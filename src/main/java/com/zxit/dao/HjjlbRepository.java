package com.zxit.dao;

import com.zxit.model.Hjjlb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


/**
 * @author xiaonanfeng
 * @Date 2018
 * 呼叫记录表统计
 */
public interface HjjlbRepository extends JpaRepository<Hjjlb, String> {

    /**
     * 呼叫状态统计
     * @param ldsjStart
     * @param ldsjEnd
     * @return
     */
    @Query("select count(t.hjzt),t.hjzt from Hjjlb t where t.ldsj >= ?1 and  t.ldsj <= ?2 group by t.hjzt order by count(t.hjzt)")
    List<Object[]> findLdsjBetweenGroupByHjzt(Date ldsjStart,Date ldsjEnd);

    /**
     * 报警号码统计
     * @param ldsjStart
     * @param ldsjEnd
     * @return
     */
    @Query("select count(t.bjhm),t.bjhm from Hjjlb t where t.ldsj >= ?1 and  t.ldsj <= ?2 group by t.bjhm order by count(t.bjhm)")
    List<Object[]> findLdsjBetweenGroupByBjhm(Date ldsjStart,Date ldsjEnd);

    /**
     * 110报警电话总量
     * @param ldsjStart
     * @param ldsjEnd
     * @return
     */
    @Query("select count(t.bjhm) from Hjjlb t where t.ldsj >= ?1 and  t.ldsj <= ?2 and t.bjhm = '110' ")
    Long findLdsjBetweenCount110(Date ldsjStart,Date ldsjEnd);

    /**
     * 122报警电话统计
     * @param ldsjStart
     * @param ldsjEnd
     * @return
     */
    @Query("select count(t.bjhm) from Hjjlb t where t.ldsj >= ?1 and  t.ldsj <= ?2 and t.bjhm = '122' ")
    Long findLdsjBetweenCount122(Date ldsjStart,Date ldsjEnd);

    /**
     * 其他电话统计
     * 不是110也不是122的
     * @param ldsjStart
     * @param ldsjEnd
     * @return
     */
    @Query("select count(t.bjhm) from Hjjlb t where t.ldsj >= ?1 and  t.ldsj <= ?2 and t.bjhm <> '122' and t.bjhm <>'110' ")
    Long findLdsjBetweenCountOther(Date ldsjStart,Date ldsjEnd);

}
    



