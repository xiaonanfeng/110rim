package com.zxit.service;

import com.zxit.model.Jcjb;
import com.zxit.model.dto.CountDto;
import com.zxit.model.dto.DateAndColDto;
import com.zxit.model.dto.TimeScopeAndDateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by xiaonanfeng on 2018/3/31.
 * 每天都在写BUG！
 */
public interface JcjbService extends ABaseService {

    /**
     * 通过各种查询条件查询接警记录
     * 带分页
     *
     * @param pageable
     * @param jcjb
     * @return
     */
    Page<Jcjb> findJcjbs(Pageable pageable, Jcjb jcjb);

    /**
     * 通过各种查询条件查询接警记录
     * 无分页，慎用
     *
     * @param sort
     * @param jcjb
     * @return
     */
    List<Jcjb> findJcjbs(Sort sort, Jcjb jcjb);

    /**
     * 通过接警单号查询一个接警单和相关的处警集合
     *
     * @param jjh
     * @return
     */
    Jcjb findByJjh(String jjh);

    /**
     * 根据jjh返回word的http路径，提供给前端下载
     * @param jjh
     * @return
     */
    String findJcjbByJjh2Word(String jjh);

    /**
     * 二维统计
     * @param jcjb
     * @param col
     * @return
     */
    List<CountDto> findJcjbCountByCol(Jcjb jcjb, String col);

    /**
     * 按照日历、时间段、字段查询
     * @param jcjb
     * @param col
     * @return
     */
    List<TimeScopeAndDateDto> findJcjbCountsByTimeScope(Jcjb jcjb, String col);


    /**
     * 按照日历、字段统计
     * @param jcjb
     * @param col
     * @return
     */
    List<DateAndColDto> findJcjbCountsByDate(Jcjb jcjb, String col);

}
