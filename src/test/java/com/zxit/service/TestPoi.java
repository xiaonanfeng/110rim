package com.zxit.service;

import com.zxit.config.YmlConfig;
import com.zxit.share.CreaterPK;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPoi {

    @Resource
    private YmlConfig ymlConfig;

    @Test
    public void testExportWord() {
        String uuid = CreaterPK.findUUID(false);
        String tmpFile = ymlConfig.getHttpFilePath() + "word.doc";
        String expFile = ymlConfig.getHttpFilePath() + uuid + ".doc";
        Map<String, String> datas = new HashMap<>();
        datas.put("jjh", "接处警流水号");
        datas.put("jjzy", "接处警信息");
        datas.put("ywlx", "110");
        datas.put("bjxs", "电话报警");
        datas.put("bjdh", "18739935629");
        datas.put("bjrxm", "南晓峰");
        datas.put("bjrxb", "男");
        datas.put("pfsj", "2017-08-01 00:00:00");
        datas.put("fadz", "发案地址发案地址发案地址发案地址发案地址发案地址发案地址发案地址发案地址发案地址发案地址发案地址发案地址");


//        build(new File(tmpFile), datas, expFile);
    }


    private void build(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception {
        FileInputStream tempFileInputStream = new FileInputStream(tmpFile);
        HWPFDocument document = new HWPFDocument(tempFileInputStream);
        // 读取文本内容
        Range bodyRange = document.getRange();
        // 替换内容
        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }
        //导出到文件
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);
        OutputStream outputStream = new FileOutputStream(exportFile);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.close();
    }

}
    



