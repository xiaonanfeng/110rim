package com.zxit.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Jcjb implements Serializable {

    private String jjh;
    private String bjxs;
    private String bjdh;
    private String bjhm;
    private String bjdz;
    private String bjdw;
    private String tlx;
    private String jjth;
    private String zby;
    private String sjdh;
    private String sjzby;
    private String ssdwbh;
    private Date bjsj;
    private Date jjsj;
    private Date gjsj;
    private Date cjsj;
    private Date ddsj;
    private String bjrxm;
    private String bjrxb;
    private String bjrlxdh;
    private String lxdh;
    private String fadz;
    private String ssfj;
    private String sspcs;
    private String ssjq;
    private String sszrq;
    private String ssxlld;
    private String zdbw;
    private String ssxq;
    private String fabw;
    private String bwfl;
    private String bwxl;
    private String ajlx;
    private String ajxz;
    private String xzfl;
    private String ywlx;
    private String jjzy;
    private String jyqk;
    private String cjjg;
    private String cjbz;
    private String ldps;
    private String lywj;
    private String ddlywj;
    private String cjlb;
    private String ejcjdw;
    private String dybz;
    private String glaj;
    private String tq;
    private String xfjb;
    private String hjzl;
    private String hqzy;
    private String qhlc;
    private String qhwz;
    private String zwhj;
    private String bkry;
    private String wxp;
    private String qkly;
    private String zscl;
    private String zscx;
    private String sggc;
    private String cph;
    private String jc;
    private String ty;
    private String ys;
    private Long zhrs;
    private String cjxl;
    private Boolean yqbz;
    private String bz;
    private String xlch;
    private Date rwpfsj;
    private Date rwddsj;
    private Date rwslsj;
    private String cswsl;
    private String cswdc;
    private String cswfk;
    private String tycx;
    private String cfbj;
    private Long swrs;
    private Long ssrs;
    private String dwzbx;
    private String dwzby;
    private String sqjrbz;
    private String hjlsh;
    private String sjgxdw;
    private String gxdwbh;
    private String dxlsh;
    private String gpscl;
    private String xzxl;
    private String ajrz;
    private String pcsrz;
    private String hgrz;
    private String sgjb;
    private String qtrz;
    private String dxhf;
    private String guid;
    private String qtxtbh;
    private Set<Cjb> cjbs;
    private Set<CallinfoBb> callinfoBbs;


    private Date bjsjStart;
    private Date bjsjEnd;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Transient
    public Date getBjsjStart() {
        return bjsjStart;
    }

    public void setBjsjStart(Date bjsjStart) {
        this.bjsjStart = bjsjStart;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Transient
    public Date getBjsjEnd() {
        return bjsjEnd;
    }

    public void setBjsjEnd(Date bjsjEnd) {
        this.bjsjEnd = bjsjEnd;
    }

    @Basic
    @Column(name = "JJH")
    public String getJjh() {
        return jjh;
    }

    public void setJjh(String jjh) {
        this.jjh = jjh;
    }

    @Basic
    @Column(name = "BJXS")
    public String getBjxs() {
        return bjxs;
    }

    public void setBjxs(String bjxs) {
        this.bjxs = bjxs;
    }

    @Basic
    @Column(name = "BJDH")
    public String getBjdh() {
        return bjdh;
    }

    public void setBjdh(String bjdh) {
        this.bjdh = bjdh;
    }

    @Basic
    @Column(name = "BJHM")
    public String getBjhm() {
        return bjhm;
    }

    public void setBjhm(String bjhm) {
        this.bjhm = bjhm;
    }

    @Basic
    @Column(name = "BJDZ")
    public String getBjdz() {
        return bjdz;
    }

    public void setBjdz(String bjdz) {
        this.bjdz = bjdz;
    }

    @Basic
    @Column(name = "BJDW")
    public String getBjdw() {
        return bjdw;
    }

    public void setBjdw(String bjdw) {
        this.bjdw = bjdw;
    }

    @Basic
    @Column(name = "TLX")
    public String getTlx() {
        return tlx;
    }

    public void setTlx(String tlx) {
        this.tlx = tlx;
    }

    @Basic
    @Column(name = "JJTH")
    public String getJjth() {
        return jjth;
    }

    public void setJjth(String jjth) {
        this.jjth = jjth;
    }

    @Basic
    @Column(name = "ZBY")
    public String getZby() {
        return zby;
    }

    public void setZby(String zby) {
        this.zby = zby;
    }

    @Basic
    @Column(name = "SJDH")
    public String getSjdh() {
        return sjdh;
    }

    public void setSjdh(String sjdh) {
        this.sjdh = sjdh;
    }

    @Basic
    @Column(name = "SJZBY")
    public String getSjzby() {
        return sjzby;
    }

    public void setSjzby(String sjzby) {
        this.sjzby = sjzby;
    }

    @Basic
    @Column(name = "SSDWBH")
    public String getSsdwbh() {
        return ssdwbh;
    }

    public void setSsdwbh(String ssdwbh) {
        this.ssdwbh = ssdwbh;
    }

    @Basic
    @Column(name = "BJSJ")
    public Date getBjsj() {
        return bjsj;
    }

    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
    }

    @Basic
    @Column(name = "JJSJ")
    public Date getJjsj() {
        return jjsj;
    }

    public void setJjsj(Date jjsj) {
        this.jjsj = jjsj;
    }

    @Basic
    @Column(name = "GJSJ")
    public Date getGjsj() {
        return gjsj;
    }

    public void setGjsj(Date gjsj) {
        this.gjsj = gjsj;
    }

    @Basic
    @Column(name = "CJSJ")
    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    @Basic
    @Column(name = "DDSJ")
    public Date getDdsj() {
        return ddsj;
    }

    public void setDdsj(Date ddsj) {
        this.ddsj = ddsj;
    }

    @Basic
    @Column(name = "BJRXM")
    public String getBjrxm() {
        return bjrxm;
    }

    public void setBjrxm(String bjrxm) {
        this.bjrxm = bjrxm;
    }

    @Basic
    @Column(name = "BJRXB")
    public String getBjrxb() {
        return bjrxb;
    }

    public void setBjrxb(String bjrxb) {
        this.bjrxb = bjrxb;
    }

    @Basic
    @Column(name = "BJRLXDH")
    public String getBjrlxdh() {
        return bjrlxdh;
    }

    public void setBjrlxdh(String bjrlxdh) {
        this.bjrlxdh = bjrlxdh;
    }

    @Basic
    @Column(name = "LXDH")
    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    @Basic
    @Column(name = "FADZ")
    public String getFadz() {
        return fadz;
    }

    public void setFadz(String fadz) {
        this.fadz = fadz;
    }

    @Basic
    @Column(name = "SSFJ")
    public String getSsfj() {
        return ssfj;
    }

    public void setSsfj(String ssfj) {
        this.ssfj = ssfj;
    }

    @Basic
    @Column(name = "SSPCS")
    public String getSspcs() {
        return sspcs;
    }

    public void setSspcs(String sspcs) {
        this.sspcs = sspcs;
    }

    @Basic
    @Column(name = "SSJQ")
    public String getSsjq() {
        return ssjq;
    }

    public void setSsjq(String ssjq) {
        this.ssjq = ssjq;
    }

    @Basic
    @Column(name = "SSZRQ")
    public String getSszrq() {
        return sszrq;
    }

    public void setSszrq(String sszrq) {
        this.sszrq = sszrq;
    }

    @Basic
    @Column(name = "SSXLLD")
    public String getSsxlld() {
        return ssxlld;
    }

    public void setSsxlld(String ssxlld) {
        this.ssxlld = ssxlld;
    }

    @Basic
    @Column(name = "ZDBW")
    public String getZdbw() {
        return zdbw;
    }

    public void setZdbw(String zdbw) {
        this.zdbw = zdbw;
    }

    @Basic
    @Column(name = "SSXQ")
    public String getSsxq() {
        return ssxq;
    }

    public void setSsxq(String ssxq) {
        this.ssxq = ssxq;
    }

    @Basic
    @Column(name = "FABW")
    public String getFabw() {
        return fabw;
    }

    public void setFabw(String fabw) {
        this.fabw = fabw;
    }

    @Basic
    @Column(name = "BWFL")
    public String getBwfl() {
        return bwfl;
    }

    public void setBwfl(String bwfl) {
        this.bwfl = bwfl;
    }

    @Basic
    @Column(name = "BWXL")
    public String getBwxl() {
        return bwxl;
    }

    public void setBwxl(String bwxl) {
        this.bwxl = bwxl;
    }

    @Basic
    @Column(name = "AJLX")
    public String getAjlx() {
        return ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    @Basic
    @Column(name = "AJXZ")
    public String getAjxz() {
        return ajxz;
    }

    public void setAjxz(String ajxz) {
        this.ajxz = ajxz;
    }

    @Basic
    @Column(name = "XZFL")
    public String getXzfl() {
        return xzfl;
    }

    public void setXzfl(String xzfl) {
        this.xzfl = xzfl;
    }

    @Basic
    @Column(name = "YWLX")
    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    @Basic
    @Column(name = "JJZY")
    public String getJjzy() {
        return jjzy;
    }

    public void setJjzy(String jjzy) {
        this.jjzy = jjzy;
    }

    @Basic
    @Column(name = "JYQK")
    public String getJyqk() {
        return jyqk;
    }

    public void setJyqk(String jyqk) {
        this.jyqk = jyqk;
    }

    @Basic
    @Column(name = "CJJG")
    public String getCjjg() {
        return cjjg;
    }

    public void setCjjg(String cjjg) {
        this.cjjg = cjjg;
    }

    @Basic
    @Column(name = "CJBZ")
    public String getCjbz() {
        return cjbz;
    }

    public void setCjbz(String cjbz) {
        this.cjbz = cjbz;
    }

    @Basic
    @Column(name = "LDPS")
    public String getLdps() {
        return ldps;
    }

    public void setLdps(String ldps) {
        this.ldps = ldps;
    }

    @Basic
    @Column(name = "LYWJ")
    public String getLywj() {
        return lywj;
    }

    public void setLywj(String lywj) {
        this.lywj = lywj;
    }

    @Basic
    @Column(name = "DDLYWJ")
    public String getDdlywj() {
        return ddlywj;
    }

    public void setDdlywj(String ddlywj) {
        this.ddlywj = ddlywj;
    }

    @Basic
    @Column(name = "CJLB")
    public String getCjlb() {
        return cjlb;
    }

    public void setCjlb(String cjlb) {
        this.cjlb = cjlb;
    }

    @Basic
    @Column(name = "EJCJDW")
    public String getEjcjdw() {
        return ejcjdw;
    }

    public void setEjcjdw(String ejcjdw) {
        this.ejcjdw = ejcjdw;
    }

    @Basic
    @Column(name = "DYBZ")
    public String getDybz() {
        return dybz;
    }

    public void setDybz(String dybz) {
        this.dybz = dybz;
    }

    @Basic
    @Column(name = "GLAJ")
    public String getGlaj() {
        return glaj;
    }

    public void setGlaj(String glaj) {
        this.glaj = glaj;
    }

    @Basic
    @Column(name = "TQ")
    public String getTq() {
        return tq;
    }

    public void setTq(String tq) {
        this.tq = tq;
    }

    @Basic
    @Column(name = "XFJB")
    public String getXfjb() {
        return xfjb;
    }

    public void setXfjb(String xfjb) {
        this.xfjb = xfjb;
    }

    @Basic
    @Column(name = "HJZL")
    public String getHjzl() {
        return hjzl;
    }

    public void setHjzl(String hjzl) {
        this.hjzl = hjzl;
    }

    @Basic
    @Column(name = "HQZY")
    public String getHqzy() {
        return hqzy;
    }

    public void setHqzy(String hqzy) {
        this.hqzy = hqzy;
    }

    @Basic
    @Column(name = "QHLC")
    public String getQhlc() {
        return qhlc;
    }

    public void setQhlc(String qhlc) {
        this.qhlc = qhlc;
    }

    @Basic
    @Column(name = "QHWZ")
    public String getQhwz() {
        return qhwz;
    }

    public void setQhwz(String qhwz) {
        this.qhwz = qhwz;
    }

    @Basic
    @Column(name = "ZWHJ")
    public String getZwhj() {
        return zwhj;
    }

    public void setZwhj(String zwhj) {
        this.zwhj = zwhj;
    }

    @Basic
    @Column(name = "BKRY")
    public String getBkry() {
        return bkry;
    }

    public void setBkry(String bkry) {
        this.bkry = bkry;
    }

    @Basic
    @Column(name = "WXP")
    public String getWxp() {
        return wxp;
    }

    public void setWxp(String wxp) {
        this.wxp = wxp;
    }

    @Basic
    @Column(name = "QKLY")
    public String getQkly() {
        return qkly;
    }

    public void setQkly(String qkly) {
        this.qkly = qkly;
    }

    @Basic
    @Column(name = "ZSCL")
    public String getZscl() {
        return zscl;
    }

    public void setZscl(String zscl) {
        this.zscl = zscl;
    }

    @Basic
    @Column(name = "ZSCX")
    public String getZscx() {
        return zscx;
    }

    public void setZscx(String zscx) {
        this.zscx = zscx;
    }

    @Basic
    @Column(name = "SGGC")
    public String getSggc() {
        return sggc;
    }

    public void setSggc(String sggc) {
        this.sggc = sggc;
    }

    @Basic
    @Column(name = "CPH")
    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    @Basic
    @Column(name = "JC")
    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    @Basic
    @Column(name = "TY")
    public String getTy() {
        return ty;
    }

    public void setTy(String ty) {
        this.ty = ty;
    }

    @Basic
    @Column(name = "YS")
    public String getYs() {
        return ys;
    }

    public void setYs(String ys) {
        this.ys = ys;
    }

    @Basic
    @Column(name = "ZHRS")
    public Long getZhrs() {
        return zhrs;
    }

    public void setZhrs(Long zhrs) {
        this.zhrs = zhrs;
    }

    @Basic
    @Column(name = "CJXL")
    public String getCjxl() {
        return cjxl;
    }

    public void setCjxl(String cjxl) {
        this.cjxl = cjxl;
    }

    @Basic
    @Column(name = "YQBZ")
    public Boolean getYqbz() {
        return yqbz;
    }

    public void setYqbz(Boolean yqbz) {
        this.yqbz = yqbz;
    }

    @Basic
    @Column(name = "BZ")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "XLCH")
    public String getXlch() {
        return xlch;
    }

    public void setXlch(String xlch) {
        this.xlch = xlch;
    }

    @Basic
    @Column(name = "RWPFSJ")
    public Date getRwpfsj() {
        return rwpfsj;
    }

    public void setRwpfsj(Date rwpfsj) {
        this.rwpfsj = rwpfsj;
    }

    @Basic
    @Column(name = "RWDDSJ")
    public Date getRwddsj() {
        return rwddsj;
    }

    public void setRwddsj(Date rwddsj) {
        this.rwddsj = rwddsj;
    }

    @Basic
    @Column(name = "RWSLSJ")
    public Date getRwslsj() {
        return rwslsj;
    }

    public void setRwslsj(Date rwslsj) {
        this.rwslsj = rwslsj;
    }

    @Basic
    @Column(name = "CSWSL")
    public String getCswsl() {
        return cswsl;
    }

    public void setCswsl(String cswsl) {
        this.cswsl = cswsl;
    }

    @Basic
    @Column(name = "CSWDC")
    public String getCswdc() {
        return cswdc;
    }

    public void setCswdc(String cswdc) {
        this.cswdc = cswdc;
    }

    @Basic
    @Column(name = "CSWFK")
    public String getCswfk() {
        return cswfk;
    }

    public void setCswfk(String cswfk) {
        this.cswfk = cswfk;
    }

    @Basic
    @Column(name = "TYCX")
    public String getTycx() {
        return tycx;
    }

    public void setTycx(String tycx) {
        this.tycx = tycx;
    }

    @Basic
    @Column(name = "CFBJ")
    public String getCfbj() {
        return cfbj;
    }

    public void setCfbj(String cfbj) {
        this.cfbj = cfbj;
    }

    @Basic
    @Column(name = "SWRS")
    public Long getSwrs() {
        return swrs;
    }

    public void setSwrs(Long swrs) {
        this.swrs = swrs;
    }

    @Basic
    @Column(name = "SSRS")
    public Long getSsrs() {
        return ssrs;
    }

    public void setSsrs(Long ssrs) {
        this.ssrs = ssrs;
    }

    @Basic
    @Column(name = "DWZBX")
    public String getDwzbx() {
        return dwzbx;
    }

    public void setDwzbx(String dwzbx) {
        this.dwzbx = dwzbx;
    }

    @Basic
    @Column(name = "DWZBY")
    public String getDwzby() {
        return dwzby;
    }

    public void setDwzby(String dwzby) {
        this.dwzby = dwzby;
    }

    @Basic
    @Column(name = "SQJRBZ")
    public String getSqjrbz() {
        return sqjrbz;
    }

    public void setSqjrbz(String sqjrbz) {
        this.sqjrbz = sqjrbz;
    }

    @Basic
    @Column(name = "HJLSH")
    public String getHjlsh() {
        return hjlsh;
    }

    public void setHjlsh(String hjlsh) {
        this.hjlsh = hjlsh;
    }

    @Basic
    @Column(name = "SJGXDW")
    public String getSjgxdw() {
        return sjgxdw;
    }

    public void setSjgxdw(String sjgxdw) {
        this.sjgxdw = sjgxdw;
    }

    @Basic
    @Column(name = "GXDWBH")
    public String getGxdwbh() {
        return gxdwbh;
    }

    public void setGxdwbh(String gxdwbh) {
        this.gxdwbh = gxdwbh;
    }

    @Basic
    @Column(name = "DXLSH")
    public String getDxlsh() {
        return dxlsh;
    }

    public void setDxlsh(String dxlsh) {
        this.dxlsh = dxlsh;
    }

    @Basic
    @Column(name = "GPSCL")
    public String getGpscl() {
        return gpscl;
    }

    public void setGpscl(String gpscl) {
        this.gpscl = gpscl;
    }

    @Basic
    @Column(name = "XZXL")
    public String getXzxl() {
        return xzxl;
    }

    public void setXzxl(String xzxl) {
        this.xzxl = xzxl;
    }

    @Basic
    @Column(name = "AJRZ")
    public String getAjrz() {
        return ajrz;
    }

    public void setAjrz(String ajrz) {
        this.ajrz = ajrz;
    }

    @Basic
    @Column(name = "PCSRZ")
    public String getPcsrz() {
        return pcsrz;
    }

    public void setPcsrz(String pcsrz) {
        this.pcsrz = pcsrz;
    }

    @Basic
    @Column(name = "HGRZ")
    public String getHgrz() {
        return hgrz;
    }

    public void setHgrz(String hgrz) {
        this.hgrz = hgrz;
    }

    @Basic
    @Column(name = "SGJB")
    public String getSgjb() {
        return sgjb;
    }

    public void setSgjb(String sgjb) {
        this.sgjb = sgjb;
    }

    @Basic
    @Column(name = "QTRZ")
    public String getQtrz() {
        return qtrz;
    }

    public void setQtrz(String qtrz) {
        this.qtrz = qtrz;
    }

    @Basic
    @Column(name = "DXHF")
    public String getDxhf() {
        return dxhf;
    }

    public void setDxhf(String dxhf) {
        this.dxhf = dxhf;
    }

    @Id
    @GeneratedValue
    @Column(name = "GUID")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "QTXTBH")
    public String getQtxtbh() {
        return qtxtbh;
    }

    public void setQtxtbh(String qtxtbh) {
        this.qtxtbh = qtxtbh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jcjb jcjb = (Jcjb) o;
        return Objects.equals(jjh, jcjb.jjh) &&
                Objects.equals(bjxs, jcjb.bjxs) &&
                Objects.equals(bjdh, jcjb.bjdh) &&
                Objects.equals(bjhm, jcjb.bjhm) &&
                Objects.equals(bjdz, jcjb.bjdz) &&
                Objects.equals(bjdw, jcjb.bjdw) &&
                Objects.equals(tlx, jcjb.tlx) &&
                Objects.equals(jjth, jcjb.jjth) &&
                Objects.equals(zby, jcjb.zby) &&
                Objects.equals(sjdh, jcjb.sjdh) &&
                Objects.equals(sjzby, jcjb.sjzby) &&
                Objects.equals(ssdwbh, jcjb.ssdwbh) &&
                Objects.equals(bjsj, jcjb.bjsj) &&
                Objects.equals(jjsj, jcjb.jjsj) &&
                Objects.equals(gjsj, jcjb.gjsj) &&
                Objects.equals(cjsj, jcjb.cjsj) &&
                Objects.equals(ddsj, jcjb.ddsj) &&
                Objects.equals(bjrxm, jcjb.bjrxm) &&
                Objects.equals(bjrxb, jcjb.bjrxb) &&
                Objects.equals(bjrlxdh, jcjb.bjrlxdh) &&
                Objects.equals(lxdh, jcjb.lxdh) &&
                Objects.equals(fadz, jcjb.fadz) &&
                Objects.equals(ssfj, jcjb.ssfj) &&
                Objects.equals(sspcs, jcjb.sspcs) &&
                Objects.equals(ssjq, jcjb.ssjq) &&
                Objects.equals(sszrq, jcjb.sszrq) &&
                Objects.equals(ssxlld, jcjb.ssxlld) &&
                Objects.equals(zdbw, jcjb.zdbw) &&
                Objects.equals(ssxq, jcjb.ssxq) &&
                Objects.equals(fabw, jcjb.fabw) &&
                Objects.equals(bwfl, jcjb.bwfl) &&
                Objects.equals(bwxl, jcjb.bwxl) &&
                Objects.equals(ajlx, jcjb.ajlx) &&
                Objects.equals(ajxz, jcjb.ajxz) &&
                Objects.equals(xzfl, jcjb.xzfl) &&
                Objects.equals(ywlx, jcjb.ywlx) &&
                Objects.equals(jjzy, jcjb.jjzy) &&
                Objects.equals(jyqk, jcjb.jyqk) &&
                Objects.equals(cjjg, jcjb.cjjg) &&
                Objects.equals(cjbz, jcjb.cjbz) &&
                Objects.equals(ldps, jcjb.ldps) &&
                Objects.equals(lywj, jcjb.lywj) &&
                Objects.equals(ddlywj, jcjb.ddlywj) &&
                Objects.equals(cjlb, jcjb.cjlb) &&
                Objects.equals(ejcjdw, jcjb.ejcjdw) &&
                Objects.equals(dybz, jcjb.dybz) &&
                Objects.equals(glaj, jcjb.glaj) &&
                Objects.equals(tq, jcjb.tq) &&
                Objects.equals(xfjb, jcjb.xfjb) &&
                Objects.equals(hjzl, jcjb.hjzl) &&
                Objects.equals(hqzy, jcjb.hqzy) &&
                Objects.equals(qhlc, jcjb.qhlc) &&
                Objects.equals(qhwz, jcjb.qhwz) &&
                Objects.equals(zwhj, jcjb.zwhj) &&
                Objects.equals(bkry, jcjb.bkry) &&
                Objects.equals(wxp, jcjb.wxp) &&
                Objects.equals(qkly, jcjb.qkly) &&
                Objects.equals(zscl, jcjb.zscl) &&
                Objects.equals(zscx, jcjb.zscx) &&
                Objects.equals(sggc, jcjb.sggc) &&
                Objects.equals(cph, jcjb.cph) &&
                Objects.equals(jc, jcjb.jc) &&
                Objects.equals(ty, jcjb.ty) &&
                Objects.equals(ys, jcjb.ys) &&
                Objects.equals(zhrs, jcjb.zhrs) &&
                Objects.equals(cjxl, jcjb.cjxl) &&
                Objects.equals(yqbz, jcjb.yqbz) &&
                Objects.equals(bz, jcjb.bz) &&
                Objects.equals(xlch, jcjb.xlch) &&
                Objects.equals(rwpfsj, jcjb.rwpfsj) &&
                Objects.equals(rwddsj, jcjb.rwddsj) &&
                Objects.equals(rwslsj, jcjb.rwslsj) &&
                Objects.equals(cswsl, jcjb.cswsl) &&
                Objects.equals(cswdc, jcjb.cswdc) &&
                Objects.equals(cswfk, jcjb.cswfk) &&
                Objects.equals(tycx, jcjb.tycx) &&
                Objects.equals(cfbj, jcjb.cfbj) &&
                Objects.equals(swrs, jcjb.swrs) &&
                Objects.equals(ssrs, jcjb.ssrs) &&
                Objects.equals(dwzbx, jcjb.dwzbx) &&
                Objects.equals(dwzby, jcjb.dwzby) &&
                Objects.equals(sqjrbz, jcjb.sqjrbz) &&
                Objects.equals(hjlsh, jcjb.hjlsh) &&
                Objects.equals(sjgxdw, jcjb.sjgxdw) &&
                Objects.equals(gxdwbh, jcjb.gxdwbh) &&
                Objects.equals(dxlsh, jcjb.dxlsh) &&
                Objects.equals(gpscl, jcjb.gpscl) &&
                Objects.equals(xzxl, jcjb.xzxl) &&
                Objects.equals(ajrz, jcjb.ajrz) &&
                Objects.equals(pcsrz, jcjb.pcsrz) &&
                Objects.equals(hgrz, jcjb.hgrz) &&
                Objects.equals(sgjb, jcjb.sgjb) &&
                Objects.equals(qtrz, jcjb.qtrz) &&
                Objects.equals(dxhf, jcjb.dxhf) &&
                Objects.equals(guid, jcjb.guid) &&
                Objects.equals(qtxtbh, jcjb.qtxtbh);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jjh, bjxs, bjdh, bjhm, bjdz, bjdw, tlx, jjth, zby, sjdh, sjzby, ssdwbh, bjsj, jjsj, gjsj, cjsj, ddsj, bjrxm, bjrxb, bjrlxdh, lxdh, fadz, ssfj, sspcs, ssjq, sszrq, ssxlld, zdbw, ssxq, fabw, bwfl, bwxl, ajlx, ajxz, xzfl, ywlx, jjzy, jyqk, cjjg, cjbz, ldps, lywj, ddlywj, cjlb, ejcjdw, dybz, glaj, tq, xfjb, hjzl, hqzy, qhlc, qhwz, zwhj, bkry, wxp, qkly, zscl, zscx, sggc, cph, jc, ty, ys, zhrs, cjxl, yqbz, bz, xlch, rwpfsj, rwddsj, rwslsj, cswsl, cswdc, cswfk, tycx, cfbj, swrs, ssrs, dwzbx, dwzby, sqjrbz, hjlsh, sjgxdw, gxdwbh, dxlsh, gpscl, xzxl, ajrz, pcsrz, hgrz, sgjb, qtrz, dxhf, guid, qtxtbh);
    }

    @OneToMany(mappedBy = "jcjb",fetch = FetchType.EAGER)
    public Set<Cjb> getCjbs() {
        return cjbs;
    }

    public void setCjbs(Set<Cjb> cjbs) {
        this.cjbs = cjbs;
    }


    @OneToMany(mappedBy = "jcjb",fetch = FetchType.EAGER)
    public Set<CallinfoBb> getCallinfoBbs() {
        return callinfoBbs;
    }

    public void setCallinfoBbs(Set<CallinfoBb> callinfoBbs) {
        this.callinfoBbs = callinfoBbs;
    }
}
    



