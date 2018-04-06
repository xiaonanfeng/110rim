package com.zxit.share;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test_Share {

    @Test
    public void test_getDatesBetweenTwoDate() throws Exception{
        String start = "2014-01-03 13:00:00";
        String end = "2014-03-05 14:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dBegin = sdf.parse(start);
        Date dEnd = sdf.parse(end);
        List<Date> list = Share.getDatesBetweenTwoDate(dBegin,dEnd);
        System.out.println(JSON.toJSONString(list));
    }

}
    



