package com.zxit.model.dto;

import java.util.Date;
import java.util.List;

public class DateAndColDto {

    private Date date;//查询日历
    private List<CountDto> countDtoList; //二维查询统计


    public DateAndColDto() {
    }

    public DateAndColDto(Date date, List<CountDto> countDtoList) {
        this.date = date;
        this.countDtoList = countDtoList;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<CountDto> getCountDtoList() {
        return countDtoList;
    }

    public void setCountDtoList(List<CountDto> countDtoList) {
        this.countDtoList = countDtoList;
    }

    @Override
    public String toString() {
        return "DateAndColDto{" +
                "date=" + date +
                ", countDtoList=" + countDtoList +
                '}';
    }
}
    



