package com.zxit.controller;

import com.zxit.model.Jcjb;
import com.zxit.model.dto.CountDto;
import com.zxit.model.dto.DateAndColDto;
import com.zxit.model.dto.TimeScopeAndDateDto;
import com.zxit.service.JcjbService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/count")
public class CountController {

    @Resource
    private JcjbService jcjbService;

    @ApiOperation("有些字段不支持count，你懂得")
    @PostMapping("/findJcjbCountByCol/{col}")
    public List<CountDto> findJcjbCountByCol(@PathVariable String col, @RequestBody Jcjb jcjb) {
        List<CountDto> list = jcjbService.findJcjbCountByCol(jcjb, col);
        return list;
    }

    /**
     * 必须传入一个时间段
     * 得到日历、字段的分组统计
     *
     * @param col
     * @param jcjb
     * @return
     */
    @ApiOperation("必须传入一个时间段，而且有些字段不支持count，你懂得")
    @PostMapping("/findJcjbCountsByDate/{col}")
    public List<DateAndColDto> findJcjbCountsByDate(@PathVariable String col, @RequestBody Jcjb jcjb) {
        List<DateAndColDto> list = new ArrayList<>();
        Date start = jcjb.getBjsjStart();//开始时间
        Date end = jcjb.getBjsjEnd();//结束时间
        if (start == null || end == null) {
            list.add(new DateAndColDto(null, null));
        } else {
            list = jcjbService.findJcjbCountsByDate(jcjb, col);
        }
        return list;
    }


    /**
     * 必须传入一个时间段
     * 得到日历、时间段、字段的分组统计
     *
     * @param col
     * @param jcjb
     * @return
     */
    @ApiOperation("必须传入一个时间段，而且有些字段不支持count，你懂得")
    @PostMapping("/findJcjbCountsByTimeScope/{col}")
    public List<TimeScopeAndDateDto> findJcjbCountsByTimeScope(@PathVariable String col, @RequestBody Jcjb jcjb) {
        List<TimeScopeAndDateDto> list = new ArrayList<>();
        Date start = jcjb.getBjsjStart();//开始时间
        Date end = jcjb.getBjsjEnd();//结束时间
        if (start == null || end == null) {
            list.add(new TimeScopeAndDateDto("必须选择一个时间段", null));
        } else {
            list = jcjbService.findJcjbCountsByTimeScope(jcjb, col);
        }
        return list;
    }


}
    



