package com.zxit.model.dto;


import java.util.List;

public class TimeScopeAndDateDto {

    private String timeScope;
    private List<DateAndColDto> dateAndColDtoList;

    public TimeScopeAndDateDto() {
    }

    public TimeScopeAndDateDto(String timeScope, List<DateAndColDto> dateAndColDtoList) {
        this.timeScope = timeScope;
        this.dateAndColDtoList = dateAndColDtoList;
    }

    public String getTimeScope() {
        return timeScope;
    }

    public void setTimeScope(String timeScope) {
        this.timeScope = timeScope;
    }

    public List<DateAndColDto> getDateAndColDtoList() {
        return dateAndColDtoList;
    }

    public void setDateAndColDtoList(List<DateAndColDto> dateAndColDtoList) {
        this.dateAndColDtoList = dateAndColDtoList;
    }

    @Override
    public String toString() {
        return "TimeScopeAndDateDto{" +
                "timeScope='" + timeScope + '\'' +
                ", dateAndColDtoList=" + dateAndColDtoList +
                '}';
    }
}
    



