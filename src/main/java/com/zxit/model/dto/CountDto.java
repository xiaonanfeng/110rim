package com.zxit.model.dto;

public class CountDto {

    private String name;
    private Long countNum;

    public CountDto() {
    }


    public CountDto(String name, Long countNum) {
        this.name = name;
        this.countNum = countNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountNum() {
        return countNum;
    }

    public void setCountNum(Long countNum) {
        this.countNum = countNum;
    }

    @Override
    public String toString() {
        return "CountDto{" +
                "name='" + name + '\'' +
                ", countNum=" + countNum +
                '}';
    }
}
    



