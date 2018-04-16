package com.zxit.share;


import com.xnf.utils.DateUtil;
import com.xnf.utils.RandomUtils;

import java.util.UUID;


/**
 * 祖传代码，没事儿别改了
 * 功能描述：生成数据库表中的主键的对象
 * 作者：JoryLee 日期：
 */
public class CreaterPK {

    private static int random = 0; // 主键后缀

    /**
     * yyyymmddhhmmss+random5
     * 2016 03 24 00 22 58 00001
     *
     * @return
     */
    public static String CreatePK() {
        // 获得按照年月日生成的流水号
        String ymdhms = DateUtil.getCurDateStr("yyyyMMddHHmmssSSS");//年月日时分秒
        random++;
        if (random > 999) {
            random = 0;
        }
        String end = formatRdm(random);
        String strTmp = ymdhms + end;
        return strTmp;
    }

    /**
     * 给不够长的添加个0
     *
     * @param param
     * @return
     */
    private static String formatRdm(int param) {
        String returnStr = String.valueOf(param);
        while (returnStr.length() < 3) {
            returnStr = "0" + returnStr;
        }
        return returnStr;
    }

    /**
     * @param param
     * @param length
     * @return
     */
    private static String formatRdm(int param, int length) {
        String returnStr = String.valueOf(param);
        while (returnStr.length() < length) {
            returnStr = "0" + returnStr;
        }
        return returnStr;
    }

    /**
     * 创建UUID
     *
     * @param hasDec 是否包含横杠
     * @return
     */
    public static String findUUID(boolean hasDec) {
        String uid = UUID.randomUUID().toString();
        if (hasDec) {
            return uid;
        } else {
            return uid.replaceAll("-", "");
        }
    }

    /**
     * @return
     */
    public static String createOrgId() {
        String orgId = RandomUtils.getRandomNumbers(16);
        return orgId;
    }


    /**
     * * 创建接警单编号接警单编号、处警单编号、反馈单编号编码规则说明：<p>
     * 编码共30位，<p>
     * 第1位字母：<p>
     * S表示指挥中心流转至中间库接警信息，<p>
     * Z表示单位自接警信息，<p>
     * C表示处警信息，<p>
     * F表示反馈信息；<p>
     * 第2至第7位为所在市县行政区划代码，<p>
     * 第8至第15位，为日期年份及月日；<p>
     * 第16至30位为序号；<p>
     * 例如:S 410000 20120603 000000000000774<p>
     * 系统定义：字头+行政区划+yyyyMMddHHmmssSSS+6位自增
     *
     * @param xzqh        当前行政区划
     * @param title       字头  S Z C F  具体参见省厅报警标准
     * @param sufx_length 后缀长度
     * @return
     */
    public static String CreateJJDBH(String xzqh, String title, int sufx_length) {
        title = title.toUpperCase();
        String infoId;
        String ymdhms = DateUtil.getCurDateStr("yyyyMMddHHmmssSSS");//年月日时分秒
        random++;
        if (random > 999999) {
            random = 0;
        }
        String sfx = formatRdm(random, sufx_length);
        infoId = title + xzqh + ymdhms + sfx;
        return infoId;
    }


}
