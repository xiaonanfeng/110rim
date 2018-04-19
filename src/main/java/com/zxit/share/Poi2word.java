package com.zxit.share;

import com.zxit.config.YmlConfig;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.util.Map;

/**
 * poi导出word
 */
public class Poi2word {

    /**
     * 导出word
     * @param resources 资源文件路径
     * @param contentMap 信息内容
     * @throws Exception
     */
    public static String buildWord(String resources,Map<String, String> contentMap) throws Exception {
        String uuid = CreaterPK.findUUID(false);
        String fileName = uuid + ".doc";
        String templateFile = resources + "word.doc";//模板文件
        String exportFile = resources + fileName;//导出文件
        FileInputStream tempFileInputStream = new FileInputStream(templateFile);
        HWPFDocument document = new HWPFDocument(tempFileInputStream);
        // 读取文本内容
        Range bodyRange = document.getRange();
        // 替换内容
        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue()==null?"":entry.getValue());
        }
        //导出到文件
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);
        OutputStream outputStream = new FileOutputStream(exportFile);
        outputStream.write(byteArrayOutputStream.toByteArray());

        outputStream.close();
        byteArrayOutputStream.close();
        tempFileInputStream.close();

        return fileName;
    }

}
    



