package com.zxit.service.impl;

import com.zxit.model.dto.DateAndColDto;
import com.zxit.share.Constants;
import com.zxit.model.CallinfoBb;
import com.zxit.model.Cjb;
import com.zxit.model.Jcjb;
import com.zxit.model.dto.CountDto;
import com.zxit.model.dto.TimeScopeAndDateDto;
import com.zxit.dao.JcjbRepository;
import com.zxit.service.JcjbService;
import com.zxit.share.Share;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class JcjbServiceImpl extends ABaseServiceImpl implements JcjbService {

    @Resource
    private JcjbRepository jcjbRepository;

    @Override
    public Page<Jcjb> findJcjbs(Pageable pageable, Jcjb jcjb) {
        Page<Jcjb> jcjbPage = jcjbRepository.findAll(this.getQuerys(jcjb), pageable);
        return jcjbPage;
    }

    @Override
    public List<Jcjb> findJcjbs(Sort sort, Jcjb jcjb) {
        List<Jcjb> list = jcjbRepository.findAll(this.getQuerys(jcjb), sort);
        return list;
    }

    @Override
    public Jcjb findByJjh(String jjh) {
        Jcjb jcjb = jcjbRepository.findByJjh(jjh);
        return jcjb;
    }

    @Override
    public List<CountDto> findJcjbCountByCol(Jcjb jcjb, String col) {
        String hql = this.getQueryJPQL(jcjb);
        hql = "select " + col + " as name,count(" + col + ") as countNum  " + hql + "  group by " + col + " ";
        List<CountDto> list = this.findByHQL(hql).list();
        return list;
    }

    @Override
    public List<TimeScopeAndDateDto> findJcjbCountsByTimeScope(Jcjb jcjb, String col) {
        String hql = this.getQueryJPQL(jcjb);
        //计算时间段集合
        List<TimeScopeAndDateDto> list = new ArrayList<>();
        String[] timeScope = Constants.TIME_SCOPE;//每天24小时  0-23
        //需要计算的时间跨度日历
        Date start = jcjb.getBjsjStart();//开始时间
        Date end = jcjb.getBjsjEnd();//结束时间
        List<Date> dates = Share.getDatesBetweenTwoDate(start, end);//得到时间段内的日期
        //开始封装
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String l_scope : timeScope) {//循环24小时
            TimeScopeAndDateDto timeScopeAndDateDto = new TimeScopeAndDateDto();
            timeScopeAndDateDto.setTimeScope(l_scope);//0-23小时节点
            //计算日期和列的统计
            List<DateAndColDto> dateAndColDtos = new ArrayList<>();//日期和案件类型Dto
            for (Date date : dates) {//循环天数
                DateAndColDto dateAndColDto = new DateAndColDto();
                dateAndColDto.setDate(date);//存日历
                //计算时间段
                String cal = simpleDateFormat.format(date);
                String hqlResult = "select " + col + " as name,count(" + col + ") as countNum"
                        + hql + //from Jcjb where …… 1=1
                        " and to_char(trunc(bjsj),'yyyy-MM-dd') = '" + cal + "' " +
                        " and to_char(bjsj,'HH24') = " + l_scope + " group by " + col + " ";
                List<CountDto> countDtos = this.findByHQL(hqlResult).list();
                dateAndColDto.setCountDtoList(countDtos);
                dateAndColDtos.add(dateAndColDto);
            }
            timeScopeAndDateDto.setDateAndColDtoList(dateAndColDtos);
            list.add(timeScopeAndDateDto);
        }
        return list;
    }

    @Override
    public List<DateAndColDto> findJcjbCountsByDate(Jcjb jcjb, String col) {
        String hql = this.getQueryJPQL(jcjb);
        //需要计算的时间跨度日历
        Date start = jcjb.getBjsjStart();//开始时间
        Date end = jcjb.getBjsjEnd();//结束时间
        List<Date> dates = Share.getDatesBetweenTwoDate(start, end);//得到时间段内的日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //计算日期和列的统计
        List<DateAndColDto> dateAndColDtos = new ArrayList<>();//日期和案件类型Dto
        for (Date date : dates) {//循环天数
            DateAndColDto dateAndColDto = new DateAndColDto();
            dateAndColDto.setDate(date);//存日历
            //计算时间段
            String cal = simpleDateFormat.format(date);
            String hqlResult = "select " + col + " as name,count(" + col + ") as countNum "
                    + hql + //from Jcjb where …… 1=1
                    " and to_char(trunc(bjsj),'yyyy-MM-dd') = '" + cal + "' group by " + col + " ";
            List<CountDto> countDtos = this.findByHQL(hqlResult).list();
            dateAndColDto.setCountDtoList(countDtos);
            dateAndColDtos.add(dateAndColDto);
        }
        return dateAndColDtos;
    }

    private Specification<Jcjb> getQuerys(Jcjb jcjb) {
        Specification<Jcjb> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> list = this.getQueryArray(jcjb, root, criteriaBuilder);
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        };
        return specification;
    }


    private String getQueryJPQL(Jcjb jcjb) {
        String hql = "";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(" from Jcjb t where ");
        String jjh = jcjb.getJjh();
        if (StringUtils.isNoneBlank(jjh)) {
            stringBuilder.append("jjh like '%" + jjh + "%' and ");
        }
        String bjxs = jcjb.getBjxs();
        if (StringUtils.isNoneBlank(bjxs)) {
            stringBuilder.append("bjxs like '%" + bjxs + "%' and ");
        }
        String bjdh = jcjb.getBjdh();
        if (StringUtils.isNoneBlank(bjdh)) {
            stringBuilder.append("bjdh like '%" + bjdh + "%' and ");
        }
        String bjhm = jcjb.getBjhm();
        if (StringUtils.isNoneBlank(bjhm)) {
            stringBuilder.append("bjhm like '%" + bjhm + "%' and ");
        }
        String bjdz = jcjb.getBjdz();
        if (StringUtils.isNoneBlank(bjdz)) {
            stringBuilder.append("bjdz like '%" + bjdz + "%' and ");
        }
        String bjdw = jcjb.getBjdw();
        if (StringUtils.isNoneBlank(bjdw)) {
            stringBuilder.append("bjdw like '%" + bjdw + "%' and ");
        }
        String tlx = jcjb.getTlx();
        if (StringUtils.isNoneBlank(tlx)) {
            stringBuilder.append("tlx like '%" + tlx + "%' and ");
        }
        String jjth = jcjb.getJjth();
        if (StringUtils.isNoneBlank(jjth)) {
            stringBuilder.append("jjth like '%" + jjth + "%' and ");
        }
        String zby = jcjb.getZby();
        if (StringUtils.isNoneBlank(zby)) {
            stringBuilder.append("zby like '%" + zby + "%' and ");
        }
        String sjdh = jcjb.getSjdh();
        if (StringUtils.isNoneBlank(sjdh)) {
            stringBuilder.append("sjdh like '%" + sjdh + "%' and ");
        }
        String sjzby = jcjb.getSjzby();
        if (StringUtils.isNoneBlank(sjzby)) {
            stringBuilder.append("sjzby like '%" + sjzby + "%' and ");
        }
        String ssdwbh = jcjb.getSsdwbh();
        if (StringUtils.isNoneBlank(ssdwbh)) {
            stringBuilder.append("ssdwbh like '%" + ssdwbh + "%' and ");
        }
        Date bjsjStart = jcjb.getBjsjStart();
        if (null != bjsjStart) {
            String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bjsjStart);
            stringBuilder.append("bjsj >= to_date('" + start + "','yyyy-MM-dd HH24:mi:ss') and ");
        }
        Date bjsjEnd = jcjb.getBjsjEnd();
        if (null != bjsjEnd) {
            String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bjsjEnd);
            stringBuilder.append("bjsj <= to_date('" + end + "','yyyy-MM-dd HH24:mi:ss') and ");
        }
        String bjrxm = jcjb.getBjrxm();
        if (StringUtils.isNoneBlank(bjrxm)) {
            stringBuilder.append("bjrxm like '%" + bjrxm + "%' and ");
        }
        String bjrxb = jcjb.getBjrxb();
        if (StringUtils.isNoneBlank(bjrxb)) {
            stringBuilder.append("bjrxb like '%" + bjrxb + "%' and ");
        }
        String bjrlxdh = jcjb.getBjrlxdh();
        if (StringUtils.isNoneBlank(bjrlxdh)) {
            stringBuilder.append("bjrlxdh like '%" + bjrlxdh + "%' and ");
        }
        String lxdh = jcjb.getLxdh();
        if (StringUtils.isNoneBlank(lxdh)) {
            stringBuilder.append("lxdh like '%" + lxdh + "%' and ");
        }
        String fadz = jcjb.getFadz();
        if (StringUtils.isNoneBlank(fadz)) {
            stringBuilder.append("fadz like '%" + fadz + "%' and ");
        }
        String ssfj = jcjb.getSsfj();
        if (StringUtils.isNoneBlank(ssfj)) {
            stringBuilder.append("ssfj like '%" + ssfj + "%' and ");
        }
        String sspcs = jcjb.getSspcs();
        if (StringUtils.isNoneBlank(sspcs)) {
            stringBuilder.append("sspcs like '%" + sspcs + "%' and ");
        }
        String ssjq = jcjb.getSsjq();
        if (StringUtils.isNoneBlank(ssjq)) {
            stringBuilder.append("ssjq like '%" + ssjq + "%' and ");
        }
        String sszrq = jcjb.getSszrq();
        if (StringUtils.isNoneBlank(sszrq)) {
            stringBuilder.append("sszrq like '%" + sszrq + "%' and ");
        }
        String ssxlld = jcjb.getSsxlld();
        if (StringUtils.isNoneBlank(ssxlld)) {
            stringBuilder.append("ssxlld like '%" + ssxlld + "%' and ");
        }
        String zdbw = jcjb.getZdbw();
        if (StringUtils.isNoneBlank(zdbw)) {
            stringBuilder.append("zdbw like '%" + zdbw + "%' and ");
        }
        String ssxq = jcjb.getSsxq();
        if (StringUtils.isNoneBlank(ssxq)) {
            stringBuilder.append("ssxq like '%" + ssxq + "%' and ");
        }
        String fabw = jcjb.getFabw();
        if (StringUtils.isNoneBlank(fabw)) {
            stringBuilder.append("fabw like '%" + fabw + "%' and ");
        }
        String bwfl = jcjb.getBwfl();
        if (StringUtils.isNoneBlank(bwfl)) {
            stringBuilder.append("bwfl like '%" + bwfl + "%' and ");
        }
        String bwxl = jcjb.getBwxl();
        if (StringUtils.isNoneBlank(bwxl)) {
            stringBuilder.append("bwxl like '%" + bwxl + "%' and ");
        }
        String ajlx = jcjb.getAjlx();
        if (StringUtils.isNoneBlank(ajlx)) {
            stringBuilder.append("ajlx like '%" + ajlx + "%' and ");
        }
        String ajxz = jcjb.getAjxz();
        if (StringUtils.isNoneBlank(ajxz)) {
            stringBuilder.append("ajxz like '%" + ajxz + "%' and ");
        }
        String xzfl = jcjb.getXzfl();
        if (StringUtils.isNoneBlank(xzfl)) {
            stringBuilder.append("xzfl like '%" + xzfl + "%' and ");
        }
        String ywlx = jcjb.getYwlx();
        if (StringUtils.isNoneBlank(ywlx)) {
            stringBuilder.append("ywlx like '%" + ywlx + "%' and ");
        }
        String jjzy = jcjb.getJjzy();
        if (StringUtils.isNoneBlank(jjzy)) {
            stringBuilder.append("jjzy like '%" + jjzy + "%' and ");
        }
        String jyqk = jcjb.getJyqk();
        if (StringUtils.isNoneBlank(jyqk)) {
            stringBuilder.append("jyqk like '%" + jyqk + "%' and ");
        }
        String cjjg = jcjb.getCjjg();
        if (StringUtils.isNoneBlank(cjjg)) {
            stringBuilder.append("cjjg like '%" + cjjg + "%' and ");
        }
        String cjbz = jcjb.getCjbz();
        if (StringUtils.isNoneBlank(cjbz)) {
            stringBuilder.append("cjbz like '%" + cjbz + "%' and ");
        }
        String ldps = jcjb.getLdps();
        if (StringUtils.isNoneBlank(ldps)) {
            stringBuilder.append("ldps like '%" + ldps + "%' and ");
        }
        String lywj = jcjb.getLywj();
        if (StringUtils.isNoneBlank(lywj)) {
            stringBuilder.append("lywj like '%" + lywj + "%' and ");
        }
        String ddlywj = jcjb.getDdlywj();
        if (StringUtils.isNoneBlank(ddlywj)) {
            stringBuilder.append("ddlywj like '%" + ddlywj + "%' and ");
        }
        String cjlb = jcjb.getCjlb();
        if (StringUtils.isNoneBlank(cjlb)) {
            stringBuilder.append("cjlb like '%" + cjlb + "%' and ");
        }
        String ejcjdw = jcjb.getEjcjdw();
        if (StringUtils.isNoneBlank(ejcjdw)) {
            stringBuilder.append("ejcjdw like '%" + ejcjdw + "%' and ");
        }
        String dybz = jcjb.getDybz();
        if (StringUtils.isNoneBlank(dybz)) {
            stringBuilder.append("dybz like '%" + dybz + "%' and ");
        }
        String glaj = jcjb.getGlaj();
        if (StringUtils.isNoneBlank(glaj)) {
            stringBuilder.append("glaj like '%" + glaj + "%' and ");
        }
        String tq = jcjb.getTq();
        if (StringUtils.isNoneBlank(tq)) {
            stringBuilder.append("tq like '%" + tq + "%' and ");
        }
        String xfjb = jcjb.getXfjb();
        if (StringUtils.isNoneBlank(xfjb)) {
            stringBuilder.append("xfjb like '%" + xfjb + "%' and ");
        }
        String hjzl = jcjb.getHjzl();
        if (StringUtils.isNoneBlank(hjzl)) {
            stringBuilder.append("hjzl like '%" + hjzl + "%' and ");
        }
        String hqzy = jcjb.getHqzy();
        if (StringUtils.isNoneBlank(hqzy)) {
            stringBuilder.append("hqzy like '%" + hqzy + "%' and ");
        }
        String qhlc = jcjb.getQhlc();
        if (StringUtils.isNoneBlank(qhlc)) {
            stringBuilder.append("qhlc like '%" + qhlc + "%' and ");
        }
        String qhwz = jcjb.getQhwz();
        if (StringUtils.isNoneBlank(qhwz)) {
            stringBuilder.append("qhwz like '%" + qhwz + "%' and ");
        }
        String zwhj = jcjb.getZwhj();
        if (StringUtils.isNoneBlank(zwhj)) {
            stringBuilder.append("zwhj like '%" + zwhj + "%' and ");
        }
        String bkry = jcjb.getBkry();
        if (StringUtils.isNoneBlank(bkry)) {
            stringBuilder.append("bkry like '%" + bkry + "%' and ");
        }
        String wxp = jcjb.getWxp();
        if (StringUtils.isNoneBlank(wxp)) {
            stringBuilder.append("wxp like '%" + wxp + "%' and ");
        }
        String qkly = jcjb.getQkly();
        if (StringUtils.isNoneBlank(qkly)) {
            stringBuilder.append("qkly like '%" + qkly + "%' and ");
        }
        String zscl = jcjb.getZscl();
        if (StringUtils.isNoneBlank(zscl)) {
            stringBuilder.append("zscl like '%" + zscl + "%' and ");
        }
        String zscx = jcjb.getZscx();
        if (StringUtils.isNoneBlank(zscx)) {
            stringBuilder.append("zscx like '%" + zscx + "%' and ");
        }
        String sggc = jcjb.getSggc();
        if (StringUtils.isNoneBlank(sggc)) {
            stringBuilder.append("sggc like '%" + sggc + "%' and ");
        }
        String cph = jcjb.getCph();
        if (StringUtils.isNoneBlank(cph)) {
            stringBuilder.append("cph like '%" + cph + "%' and ");
        }
        String jc = jcjb.getJc();
        if (StringUtils.isNoneBlank(jc)) {
            stringBuilder.append("jc like '%" + jc + "%' and ");
        }
        String ty = jcjb.getTy();
        if (StringUtils.isNoneBlank(ty)) {
            stringBuilder.append("ty like '%" + ty + "%' and ");
        }
        String ys = jcjb.getYs();
        if (StringUtils.isNoneBlank(ys)) {
            stringBuilder.append("ys like '%" + ys + "%' and ");
        }
        Long zhrs = jcjb.getZhrs();
        if (null != zhrs) {
            stringBuilder.append("zhrs = " + zhrs + " and ");
        }
        String cjxl = jcjb.getCjxl();
        if (StringUtils.isNoneBlank(cjxl)) {
            stringBuilder.append("cjxl like '%" + cjxl + "%' and ");
        }
        String bz = jcjb.getBz();
        if (StringUtils.isNoneBlank(bz)) {
            stringBuilder.append("bz like '%" + bz + "%' and ");
        }
        String xlch = jcjb.getXlch();
        if (StringUtils.isNoneBlank(xlch)) {
            stringBuilder.append("xlch like '%" + xlch + "%' and ");
        }
        String cswsl = jcjb.getCswsl();
        if (StringUtils.isNoneBlank(cswsl)) {
            stringBuilder.append("cswsl like '%" + cswsl + "%' and ");
        }
        String cswdc = jcjb.getCswdc();
        if (StringUtils.isNoneBlank(cswdc)) {
            stringBuilder.append("cswdc like '%" + cswdc + "%' and ");
        }
        String cswfk = jcjb.getCswfk();
        if (StringUtils.isNoneBlank(cswfk)) {
            stringBuilder.append("cswfk like '%" + cswfk + "%' and ");
        }
        String tycx = jcjb.getTycx();
        if (StringUtils.isNoneBlank(tycx)) {
            stringBuilder.append("tycx like '%" + tycx + "%' and ");
        }
        String cfbj = jcjb.getCfbj();
        if (StringUtils.isNoneBlank(cfbj)) {
            stringBuilder.append("cfbj like '%" + cfbj + "%' and ");
        }
        Long swrs = jcjb.getSwrs();
        if (null != swrs) {
            stringBuilder.append("swrs = " + swrs + " and ");
        }
        Long ssrs = jcjb.getSsrs();
        if (null != ssrs) {
            stringBuilder.append("ssrs = " + ssrs + " and ");
        }
        String dwzbx = jcjb.getDwzbx();
        if (StringUtils.isNoneBlank(dwzbx)) {
            stringBuilder.append("dwzbx like '%" + dwzbx + "%' and ");
        }
        String dwzby = jcjb.getDwzby();
        if (StringUtils.isNoneBlank(dwzby)) {
            stringBuilder.append("dwzby like '%" + dwzby + "%' and ");
        }
        String sqjrbz = jcjb.getSqjrbz();
        if (StringUtils.isNoneBlank(sqjrbz)) {
            stringBuilder.append("sqjrbz like '%" + sqjrbz + "%' and ");
        }
        String hjlsh = jcjb.getHjlsh();
        if (StringUtils.isNoneBlank(hjlsh)) {
            stringBuilder.append("hjlsh like '%" + hjlsh + "%' and ");
        }
        String sjgxdw = jcjb.getSjgxdw();
        if (StringUtils.isNoneBlank(sjgxdw)) {
            stringBuilder.append("sjgxdw like '%" + sjgxdw + "%' and ");
        }
        String gxdwbh = jcjb.getGxdwbh();
        if (StringUtils.isNoneBlank(gxdwbh)) {
            stringBuilder.append("gxdwbh like '%" + gxdwbh + "%' and ");
        }
        String dxlsh = jcjb.getDxlsh();
        if (StringUtils.isNoneBlank(dxlsh)) {
            stringBuilder.append("dxlsh like '%" + dxlsh + "%' and ");
        }
        String gpscl = jcjb.getGpscl();
        if (StringUtils.isNoneBlank(gpscl)) {
            stringBuilder.append("gpscl like '%" + gpscl + "%' and ");
        }
        String xzxl = jcjb.getXzxl();
        if (StringUtils.isNoneBlank(xzxl)) {
            stringBuilder.append("xzxl like '%" + xzxl + "%' and ");
        }
        String ajrz = jcjb.getAjrz();
        if (StringUtils.isNoneBlank(ajrz)) {
            stringBuilder.append("ajrz like '%" + ajrz + "%' and ");
        }
        String pcsrz = jcjb.getPcsrz();
        if (StringUtils.isNoneBlank(pcsrz)) {
            stringBuilder.append("pcsrz like '%" + pcsrz + "%' and ");
        }
        String hgrz = jcjb.getHgrz();
        if (StringUtils.isNoneBlank(hgrz)) {
            stringBuilder.append("hgrz like '%" + hgrz + "%' and ");
        }
        String sgjb = jcjb.getSgjb();
        if (StringUtils.isNoneBlank(sgjb)) {
            stringBuilder.append("sgjb like '%" + sgjb + "%' and ");
        }
        String qtrz = jcjb.getQtrz();
        if (StringUtils.isNoneBlank(qtrz)) {
            stringBuilder.append("qtrz like '%" + qtrz + "%' and ");
        }
        String dxhf = jcjb.getDxhf();
        if (StringUtils.isNoneBlank(dxhf)) {
            stringBuilder.append("dxhf like '%" + dxhf + "%' and ");
        }
        String guid = jcjb.getGuid();
        if (StringUtils.isNoneBlank(guid)) {
            stringBuilder.append("guid like '%" + guid + "%' and ");
        }
        String qtxtbh = jcjb.getQtxtbh();
        if (StringUtils.isNoneBlank(qtxtbh)) {
            stringBuilder.append("qtxtbh like '%" + qtxtbh + "%' and ");
        }
        //TODO 子查询条件
        Set<CallinfoBb> callinfoBbs = jcjb.getCallinfoBbs();
        if (callinfoBbs != null) {
//            list.add(criteriaBuilder.equal(root.get("callinfoBbs").as(CallinfoBb.class), 1));
        }
        Set<Cjb> cjbs = jcjb.getCjbs();
        if (cjbs != null) {
//            System.out.println(2);
        }
        stringBuilder.append(" 1 =1 ");
        hql = stringBuilder.toString();
        return hql;
    }

    private List<Predicate> getQueryArray(Jcjb jcjb, Root<Jcjb> root, CriteriaBuilder criteriaBuilder) {

        List<Predicate> list = new ArrayList<>();

        Date bjsjStart = jcjb.getBjsjStart();
        if (null != bjsjStart) {
            list.add(criteriaBuilder.greaterThan(root.get("bjsj").as(Date.class), bjsjStart));
        }
        Date bjsjEnd = jcjb.getBjsjEnd();
        if (null != bjsjEnd) {
            list.add(criteriaBuilder.lessThan(root.get("bjsj").as(Date.class), bjsjEnd));
        }
        String jjh = jcjb.getJjh();
        if (StringUtils.isNoneBlank(jjh)) {
            list.add(criteriaBuilder.like(root.get("jjh").as(String.class), "%" + jjh + "%"));
        }
        String bjxs = jcjb.getBjxs();
        if (StringUtils.isNoneBlank(bjxs)) {
            list.add(criteriaBuilder.like(root.get("bjxs").as(String.class), "%" + bjxs + "%"));
        }
        String bjdh = jcjb.getBjdh();
        if (StringUtils.isNoneBlank(bjdh)) {
            list.add(criteriaBuilder.like(root.get("bjdh").as(String.class), "%" + bjdh + "%"));
        }
        String bjhm = jcjb.getBjhm();
        if (StringUtils.isNoneBlank(bjhm)) {
            list.add(criteriaBuilder.like(root.get("bjhm").as(String.class), "%" + bjhm + "%"));
        }
        String bjdz = jcjb.getBjdz();
        if (StringUtils.isNoneBlank(bjdz)) {
            list.add(criteriaBuilder.like(root.get("bjdz").as(String.class), "%" + bjdz + "%"));
        }
        String bjdw = jcjb.getBjdw();
        if (StringUtils.isNoneBlank(bjdw)) {
            list.add(criteriaBuilder.like(root.get("bjdw").as(String.class), "%" + bjdw + "%"));
        }
        String tlx = jcjb.getTlx();
        if (StringUtils.isNoneBlank(tlx)) {
            list.add(criteriaBuilder.like(root.get("tlx").as(String.class), "%" + tlx + "%"));
        }
        String jjth = jcjb.getJjth();
        if (StringUtils.isNoneBlank(jjth)) {
            list.add(criteriaBuilder.like(root.get("jjth").as(String.class), "%" + jjth + "%"));
        }
        String zby = jcjb.getZby();
        if (StringUtils.isNoneBlank(zby)) {
            list.add(criteriaBuilder.like(root.get("zby").as(String.class), "%" + zby + "%"));
        }
        String sjdh = jcjb.getSjdh();
        if (StringUtils.isNoneBlank(sjdh)) {
            list.add(criteriaBuilder.like(root.get("sjdh").as(String.class), "%" + sjdh + "%"));
        }
        String sjzby = jcjb.getSjzby();
        if (StringUtils.isNoneBlank(sjzby)) {
            list.add(criteriaBuilder.like(root.get("sjzby").as(String.class), "%" + sjzby + "%"));
        }
        String ssdwbh = jcjb.getSsdwbh();
        if (StringUtils.isNoneBlank(ssdwbh)) {
            list.add(criteriaBuilder.like(root.get("ssdwbh").as(String.class), "%" + ssdwbh + "%"));
        }
        String bjrxm = jcjb.getBjrxm();
        if (StringUtils.isNoneBlank(bjrxm)) {
            list.add(criteriaBuilder.like(root.get("bjrxm").as(String.class), "%" + bjrxm + "%"));
        }
        String bjrxb = jcjb.getBjrxb();
        if (StringUtils.isNoneBlank(bjrxb)) {
            list.add(criteriaBuilder.like(root.get("bjrxb").as(String.class), "%" + bjrxb + "%"));
        }
        String bjrlxdh = jcjb.getBjrlxdh();
        if (StringUtils.isNoneBlank(bjrlxdh)) {
            list.add(criteriaBuilder.like(root.get("bjrlxdh").as(String.class), "%" + bjrlxdh + "%"));
        }
        String lxdh = jcjb.getLxdh();
        if (StringUtils.isNoneBlank(lxdh)) {
            list.add(criteriaBuilder.like(root.get("lxdh").as(String.class), "%" + lxdh + "%"));
        }
        String fadz = jcjb.getFadz();
        if (StringUtils.isNoneBlank(fadz)) {
            list.add(criteriaBuilder.like(root.get("fadz").as(String.class), "%" + fadz + "%"));
        }
        String ssfj = jcjb.getSsfj();
        if (StringUtils.isNoneBlank(ssfj)) {
            list.add(criteriaBuilder.like(root.get("ssfj").as(String.class), "%" + ssfj + "%"));
        }
        String sspcs = jcjb.getSspcs();
        if (StringUtils.isNoneBlank(sspcs)) {
            list.add(criteriaBuilder.like(root.get("sspcs").as(String.class), "%" + sspcs + "%"));
        }
        String ssjq = jcjb.getSsjq();
        if (StringUtils.isNoneBlank(ssjq)) {
            list.add(criteriaBuilder.like(root.get("ssjq").as(String.class), "%" + ssjq + "%"));
        }
        String sszrq = jcjb.getSszrq();
        if (StringUtils.isNoneBlank(sszrq)) {
            list.add(criteriaBuilder.like(root.get("sszrq").as(String.class), "%" + sszrq + "%"));
        }
        String ssxlld = jcjb.getSsxlld();
        if (StringUtils.isNoneBlank(ssxlld)) {
            list.add(criteriaBuilder.like(root.get("ssxlld").as(String.class), "%" + ssxlld + "%"));
        }
        String zdbw = jcjb.getZdbw();
        if (StringUtils.isNoneBlank(zdbw)) {
            list.add(criteriaBuilder.like(root.get("zdbw").as(String.class), "%" + zdbw + "%"));
        }
        String ssxq = jcjb.getSsxq();
        if (StringUtils.isNoneBlank(ssxq)) {
            list.add(criteriaBuilder.like(root.get("ssxq").as(String.class), "%" + ssxq + "%"));
        }
        String fabw = jcjb.getFabw();
        if (StringUtils.isNoneBlank(fabw)) {
            list.add(criteriaBuilder.like(root.get("fabw").as(String.class), "%" + fabw + "%"));
        }
        String bwfl = jcjb.getBwfl();
        if (StringUtils.isNoneBlank(bwfl)) {
            list.add(criteriaBuilder.like(root.get("bwfl").as(String.class), "%" + bwfl + "%"));
        }
        String bwxl = jcjb.getBwxl();
        if (StringUtils.isNoneBlank(bwxl)) {
            list.add(criteriaBuilder.like(root.get("bwxl").as(String.class), "%" + bwxl + "%"));
        }
        String ajlx = jcjb.getAjlx();
        if (StringUtils.isNoneBlank(ajlx)) {
            list.add(criteriaBuilder.like(root.get("ajlx").as(String.class), "%" + ajlx + "%"));
        }
        String ajxz = jcjb.getAjxz();
        if (StringUtils.isNoneBlank(ajxz)) {
            list.add(criteriaBuilder.like(root.get("ajxz").as(String.class), "%" + ajxz + "%"));
        }
        String xzfl = jcjb.getXzfl();
        if (StringUtils.isNoneBlank(xzfl)) {
            list.add(criteriaBuilder.like(root.get("xzfl").as(String.class), "%" + xzfl + "%"));
        }
        String ywlx = jcjb.getYwlx();
        if (StringUtils.isNoneBlank(ywlx)) {
            list.add(criteriaBuilder.like(root.get("ywlx").as(String.class), "%" + ywlx + "%"));
        }
        String jjzy = jcjb.getJjzy();
        if (StringUtils.isNoneBlank(jjzy)) {
            list.add(criteriaBuilder.like(root.get("jjzy").as(String.class), "%" + jjzy + "%"));
        }
        String jyqk = jcjb.getJyqk();
        if (StringUtils.isNoneBlank(jyqk)) {
            list.add(criteriaBuilder.like(root.get("jyqk").as(String.class), "%" + jyqk + "%"));
        }
        String cjjg = jcjb.getCjjg();
        if (StringUtils.isNoneBlank(cjjg)) {
            list.add(criteriaBuilder.like(root.get("cjjg").as(String.class), "%" + cjjg + "%"));
        }
        String cjbz = jcjb.getCjbz();
        if (StringUtils.isNoneBlank(cjbz)) {
            list.add(criteriaBuilder.like(root.get("cjbz").as(String.class), "%" + cjbz + "%"));
        }
        String ldps = jcjb.getLdps();
        if (StringUtils.isNoneBlank(ldps)) {
            list.add(criteriaBuilder.like(root.get("ldps").as(String.class), "%" + ldps + "%"));
        }
        String lywj = jcjb.getLywj();
        if (StringUtils.isNoneBlank(lywj)) {
            list.add(criteriaBuilder.like(root.get("lywj").as(String.class), "%" + lywj + "%"));
        }
        String ddlywj = jcjb.getDdlywj();
        if (StringUtils.isNoneBlank(ddlywj)) {
            list.add(criteriaBuilder.like(root.get("ddlywj").as(String.class), "%" + ddlywj + "%"));
        }
        String cjlb = jcjb.getCjlb();
        if (StringUtils.isNoneBlank(cjlb)) {
            list.add(criteriaBuilder.like(root.get("cjlb").as(String.class), "%" + cjlb + "%"));
        }
        String ejcjdw = jcjb.getEjcjdw();
        if (StringUtils.isNoneBlank(ejcjdw)) {
            list.add(criteriaBuilder.like(root.get("ejcjdw").as(String.class), "%" + ejcjdw + "%"));
        }
        String dybz = jcjb.getDybz();
        if (StringUtils.isNoneBlank(dybz)) {
            list.add(criteriaBuilder.like(root.get("dybz").as(String.class), "%" + dybz + "%"));
        }
        String glaj = jcjb.getGlaj();
        if (StringUtils.isNoneBlank(glaj)) {
            list.add(criteriaBuilder.like(root.get("glaj").as(String.class), "%" + glaj + "%"));
        }
        String tq = jcjb.getTq();
        if (StringUtils.isNoneBlank(tq)) {
            list.add(criteriaBuilder.like(root.get("tq").as(String.class), "%" + tq + "%"));
        }
        String xfjb = jcjb.getXfjb();
        if (StringUtils.isNoneBlank(xfjb)) {
            list.add(criteriaBuilder.like(root.get("xfjb").as(String.class), "%" + xfjb + "%"));
        }
        String hjzl = jcjb.getHjzl();
        if (StringUtils.isNoneBlank(hjzl)) {
            list.add(criteriaBuilder.like(root.get("hjzl").as(String.class), "%" + hjzl + "%"));
        }
        String hqzy = jcjb.getHqzy();
        if (StringUtils.isNoneBlank(hqzy)) {
            list.add(criteriaBuilder.like(root.get("hqzy").as(String.class), "%" + hqzy + "%"));
        }
        String qhlc = jcjb.getQhlc();
        if (StringUtils.isNoneBlank(qhlc)) {
            list.add(criteriaBuilder.like(root.get("qhlc").as(String.class), "%" + qhlc + "%"));
        }
        String qhwz = jcjb.getQhwz();
        if (StringUtils.isNoneBlank(qhwz)) {
            list.add(criteriaBuilder.like(root.get("qhwz").as(String.class), "%" + qhwz + "%"));
        }
        String zwhj = jcjb.getZwhj();
        if (StringUtils.isNoneBlank(zwhj)) {
            list.add(criteriaBuilder.like(root.get("zwhj").as(String.class), "%" + zwhj + "%"));
        }
        String bkry = jcjb.getBkry();
        if (StringUtils.isNoneBlank(bkry)) {
            list.add(criteriaBuilder.like(root.get("bkry").as(String.class), "%" + bkry + "%"));
        }
        String wxp = jcjb.getWxp();
        if (StringUtils.isNoneBlank(wxp)) {
            list.add(criteriaBuilder.like(root.get("wxp").as(String.class), "%" + wxp + "%"));
        }
        String qkly = jcjb.getQkly();
        if (StringUtils.isNoneBlank(qkly)) {
            list.add(criteriaBuilder.like(root.get("qkly").as(String.class), "%" + qkly + "%"));
        }
        String zscl = jcjb.getZscl();
        if (StringUtils.isNoneBlank(zscl)) {
            list.add(criteriaBuilder.like(root.get("zscl").as(String.class), "%" + zscl + "%"));
        }
        String zscx = jcjb.getZscx();
        if (StringUtils.isNoneBlank(zscx)) {
            list.add(criteriaBuilder.like(root.get("zscx").as(String.class), "%" + zscx + "%"));
        }
        String sggc = jcjb.getSggc();
        if (StringUtils.isNoneBlank(sggc)) {
            list.add(criteriaBuilder.like(root.get("sggc").as(String.class), "%" + sggc + "%"));
        }
        String cph = jcjb.getCph();
        if (StringUtils.isNoneBlank(cph)) {
            list.add(criteriaBuilder.like(root.get("cph").as(String.class), "%" + cph + "%"));
        }
        String jc = jcjb.getJc();
        if (StringUtils.isNoneBlank(jc)) {
            list.add(criteriaBuilder.like(root.get("jc").as(String.class), "%" + jc + "%"));
        }
        String ty = jcjb.getTy();
        if (StringUtils.isNoneBlank(ty)) {
            list.add(criteriaBuilder.like(root.get("ty").as(String.class), "%" + ty + "%"));
        }
        String ys = jcjb.getYs();
        if (StringUtils.isNoneBlank(ys)) {
            list.add(criteriaBuilder.like(root.get("ys").as(String.class), "%" + ys + "%"));
        }
        String cjxl = jcjb.getCjxl();
        if (StringUtils.isNoneBlank(cjxl)) {
            list.add(criteriaBuilder.like(root.get("cjxl").as(String.class), "%" + cjxl + "%"));
        }
        String bz = jcjb.getBz();
        if (StringUtils.isNoneBlank(bz)) {
            list.add(criteriaBuilder.like(root.get("bz").as(String.class), "%" + bz + "%"));
        }
        String xlch = jcjb.getXlch();
        if (StringUtils.isNoneBlank(xlch)) {
            list.add(criteriaBuilder.like(root.get("xlch").as(String.class), "%" + xlch + "%"));
        }
        String cswsl = jcjb.getCswsl();
        if (StringUtils.isNoneBlank(cswsl)) {
            list.add(criteriaBuilder.like(root.get("cswsl").as(String.class), "%" + cswsl + "%"));
        }
        String cswdc = jcjb.getCswdc();
        if (StringUtils.isNoneBlank(cswdc)) {
            list.add(criteriaBuilder.like(root.get("cswdc").as(String.class), "%" + cswdc + "%"));
        }
        String cswfk = jcjb.getCswfk();
        if (StringUtils.isNoneBlank(cswfk)) {
            list.add(criteriaBuilder.like(root.get("cswfk").as(String.class), "%" + cswfk + "%"));
        }
        String tycx = jcjb.getTycx();
        if (StringUtils.isNoneBlank(tycx)) {
            list.add(criteriaBuilder.like(root.get("tycx").as(String.class), "%" + tycx + "%"));
        }
        String cfbj = jcjb.getCfbj();
        if (StringUtils.isNoneBlank(cfbj)) {
            list.add(criteriaBuilder.like(root.get("cfbj").as(String.class), "%" + cfbj + "%"));
        }
        String dwzbx = jcjb.getDwzbx();
        if (StringUtils.isNoneBlank(dwzbx)) {
            list.add(criteriaBuilder.like(root.get("dwzbx").as(String.class), "%" + dwzbx + "%"));
        }
        String dwzby = jcjb.getDwzby();
        if (StringUtils.isNoneBlank(dwzby)) {
            list.add(criteriaBuilder.like(root.get("dwzby").as(String.class), "%" + dwzby + "%"));
        }
        String sqjrbz = jcjb.getSqjrbz();
        if (StringUtils.isNoneBlank(sqjrbz)) {
            list.add(criteriaBuilder.like(root.get("sqjrbz").as(String.class), "%" + sqjrbz + "%"));
        }
        String hjlsh = jcjb.getHjlsh();
        if (StringUtils.isNoneBlank(hjlsh)) {
            list.add(criteriaBuilder.like(root.get("hjlsh").as(String.class), "%" + hjlsh + "%"));
        }
        String sjgxdw = jcjb.getSjgxdw();
        if (StringUtils.isNoneBlank(sjgxdw)) {
            list.add(criteriaBuilder.like(root.get("sjgxdw").as(String.class), "%" + sjgxdw + "%"));
        }
        String gxdwbh = jcjb.getGxdwbh();
        if (StringUtils.isNoneBlank(gxdwbh)) {
            list.add(criteriaBuilder.like(root.get("gxdwbh").as(String.class), "%" + gxdwbh + "%"));
        }
        String dxlsh = jcjb.getDxlsh();
        if (StringUtils.isNoneBlank(dxlsh)) {
            list.add(criteriaBuilder.like(root.get("dxlsh").as(String.class), "%" + dxlsh + "%"));
        }
        String gpscl = jcjb.getGpscl();
        if (StringUtils.isNoneBlank(gpscl)) {
            list.add(criteriaBuilder.like(root.get("gpscl").as(String.class), "%" + gpscl + "%"));
        }
        String xzxl = jcjb.getXzxl();
        if (StringUtils.isNoneBlank(xzxl)) {
            list.add(criteriaBuilder.like(root.get("xzxl").as(String.class), "%" + xzxl + "%"));
        }
        String ajrz = jcjb.getAjrz();
        if (StringUtils.isNoneBlank(ajrz)) {
            list.add(criteriaBuilder.like(root.get("ajrz").as(String.class), "%" + ajrz + "%"));
        }
        String pcsrz = jcjb.getPcsrz();
        if (StringUtils.isNoneBlank(pcsrz)) {
            list.add(criteriaBuilder.like(root.get("pcsrz").as(String.class), "%" + pcsrz + "%"));
        }
        String hgrz = jcjb.getHgrz();
        if (StringUtils.isNoneBlank(hgrz)) {
            list.add(criteriaBuilder.like(root.get("hgrz").as(String.class), "%" + hgrz + "%"));
        }
        String sgjb = jcjb.getSgjb();
        if (StringUtils.isNoneBlank(sgjb)) {
            list.add(criteriaBuilder.like(root.get("sgjb").as(String.class), "%" + sgjb + "%"));
        }
        String qtrz = jcjb.getQtrz();
        if (StringUtils.isNoneBlank(qtrz)) {
            list.add(criteriaBuilder.like(root.get("qtrz").as(String.class), "%" + qtrz + "%"));
        }
        String dxhf = jcjb.getDxhf();
        if (StringUtils.isNoneBlank(dxhf)) {
            list.add(criteriaBuilder.like(root.get("dxhf").as(String.class), "%" + dxhf + "%"));
        }
        String guid = jcjb.getGuid();
        if (StringUtils.isNoneBlank(guid)) {
            list.add(criteriaBuilder.like(root.get("guid").as(String.class), "%" + guid + "%"));
        }
        String qtxtbh = jcjb.getQtxtbh();
        if (StringUtils.isNoneBlank(qtxtbh)) {
            list.add(criteriaBuilder.like(root.get("qtxtbh").as(String.class), "%" + qtxtbh + "%"));
        }
        Long zhrs = jcjb.getZhrs();
        if (null != zhrs) {
            list.add(criteriaBuilder.equal(root.get("zhrs").as(Long.class), zhrs));
        }
        Long swrs = jcjb.getSwrs();
        if (null != swrs) {
            list.add(criteriaBuilder.equal(root.get("swrs").as(Long.class), swrs));
        }
        Long ssrs = jcjb.getSsrs();
        if (null != ssrs) {
            list.add(criteriaBuilder.equal(root.get("ssrs").as(Long.class), ssrs));
        }
        //TODO 子查询条件
        Set<CallinfoBb> callinfoBbs = jcjb.getCallinfoBbs();
        if (callinfoBbs != null) {
//            list.add(criteriaBuilder.equal(root.get("callinfoBbs").as(CallinfoBb.class), 1));
        }
        Set<Cjb> cjbs = jcjb.getCjbs();
        if (cjbs != null) {
//            System.out.println(2);
        }

        return list;
    }

}
    



