package com.zxit.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Cjb implements Serializable {

    private Jcjb jcjb;
    private String jjh;
    private String dwbh;
    private String cjdw;
    private String sldw;
    private String qy;
    private String ywlx;
    private String zt;
    private String aqzt;
    private Date fksj;
    private Date pfsj;
    private Date jjsj;
    private String slr;
    private Date slsj;
    private String cjr;
    private Date ddxcsj;
    private String hgr;
    private Date hgsj;
    private String cjjg;
    private String glaj;
    private String zbld;
    private String ldps;
    private String lwdw;
    private Date fasj;
    private String fadz;
    private String phbz;
    private String ajlx;
    private String ajxz;
    private String xzfl;
    private String fabw;
    private String bwfl;
    private String bwxl;
    private String ssfj;
    private String sspcs;
    private String ssjq;
    private String sszrq;
    private String ssxlld;
    private String zdbw;
    private String cjbz;
    private Long cdjl;
    private Long cdcc;
    private Long zhrs;
    private Long tfrs;
    private Long lzsc;
    private Long swrs;
    private Long ssrs;
    private Long jzsy;
    private Long jzqz;
    private String zcrs;
    private String cfwz;
    private String cfsj;
    private String cllb;
    private String cllbfl;
    private String clpp;
    private String clys;
    private String cph;
    private String rfcs;
    private String wfcs;
    private String jfcs;
    private String fjff;
    private String lc;
    private String ywzsry;
    private String ywzym;
    private String bjq;
    private String dpzl;
    private String zdf;
    private String yfzrs;
    private String nyfrs;
    private String lyfrs;
    private String yfqkbz;
    private String zajtgj;
    private String sjbxg;
    private String sflj;
    private String sfcjjhb;
    private String sfyzsry;
    private String sfyfdcs;
    private String cynxfds;
    private String sfyjjss;
    private String sfdzq;
    private String sfsjtf;
    private String sfsjflg;
    private String zasd;
    private String sdfl;
    private String sdxl;
    private String zasf;
    private String sffl;
    private String sfxl;
    private String zaxq;
    private String xqfl;
    private String xqxl;
    private String fayy;
    private String yyfl;
    private String yyxl;
    private String jqly;
    private String jqlb;
    private String cflx;
    private String xlch;
    private String xlld;
    private String fxf;
    private Boolean hjzl;
    private String czjg;
    private String clbh;
    private String cswsl;
    private String cswdc;
    private String cswfk;
    private String bz;
    private Date ddsj;
    private Date ddxjsj;
    private String cfbj;
    private String slrjh;
    private String cjrjh;
    private String hgrjh;
    private String zbldjh;
    private String gxdw;
    private String gxdwbh;
    private String gxbq;
    private String xzxl;
    private String guid;
    private String qtxtbh;


    @Basic
    @Column(name = "JJH", insertable = false, updatable = false)
    public String getJjh() {
        return jjh;
    }

    public void setJjh(String jjh) {
        this.jjh = jjh;
    }

    @Basic
    @Column(name = "DWBH")
    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    @Basic
    @Column(name = "CJDW")
    public String getCjdw() {
        return cjdw;
    }

    public void setCjdw(String cjdw) {
        this.cjdw = cjdw;
    }

    @Basic
    @Column(name = "SLDW")
    public String getSldw() {
        return sldw;
    }

    public void setSldw(String sldw) {
        this.sldw = sldw;
    }

    @Basic
    @Column(name = "QY")
    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
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
    @Column(name = "ZT")
    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    @Basic
    @Column(name = "AQZT")
    public String getAqzt() {
        return aqzt;
    }

    public void setAqzt(String aqzt) {
        this.aqzt = aqzt;
    }

    @Basic
    @Column(name = "FKSJ")
    public Date getFksj() {
        return fksj;
    }

    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }

    @Basic
    @Column(name = "PFSJ")
    public Date getPfsj() {
        return pfsj;
    }

    public void setPfsj(Date pfsj) {
        this.pfsj = pfsj;
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
    @Column(name = "SLR")
    public String getSlr() {
        return slr;
    }

    public void setSlr(String slr) {
        this.slr = slr;
    }

    @Basic
    @Column(name = "SLSJ")
    public Date getSlsj() {
        return slsj;
    }

    public void setSlsj(Date slsj) {
        this.slsj = slsj;
    }

    @Basic
    @Column(name = "CJR")
    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }

    @Basic
    @Column(name = "DDXCSJ")
    public Date getDdxcsj() {
        return ddxcsj;
    }

    public void setDdxcsj(Date ddxcsj) {
        this.ddxcsj = ddxcsj;
    }

    @Basic
    @Column(name = "HGR")
    public String getHgr() {
        return hgr;
    }

    public void setHgr(String hgr) {
        this.hgr = hgr;
    }

    @Basic
    @Column(name = "HGSJ")
    public Date getHgsj() {
        return hgsj;
    }

    public void setHgsj(Date hgsj) {
        this.hgsj = hgsj;
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
    @Column(name = "GLAJ")
    public String getGlaj() {
        return glaj;
    }

    public void setGlaj(String glaj) {
        this.glaj = glaj;
    }

    @Basic
    @Column(name = "ZBLD")
    public String getZbld() {
        return zbld;
    }

    public void setZbld(String zbld) {
        this.zbld = zbld;
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
    @Column(name = "LWDW")
    public String getLwdw() {
        return lwdw;
    }

    public void setLwdw(String lwdw) {
        this.lwdw = lwdw;
    }

    @Basic
    @Column(name = "FASJ")
    public Date getFasj() {
        return fasj;
    }

    public void setFasj(Date fasj) {
        this.fasj = fasj;
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
    @Column(name = "PHBZ")
    public String getPhbz() {
        return phbz;
    }

    public void setPhbz(String phbz) {
        this.phbz = phbz;
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
    @Column(name = "CJBZ")
    public String getCjbz() {
        return cjbz;
    }

    public void setCjbz(String cjbz) {
        this.cjbz = cjbz;
    }

    @Basic
    @Column(name = "CDJL")
    public Long getCdjl() {
        return cdjl;
    }

    public void setCdjl(Long cdjl) {
        this.cdjl = cdjl;
    }

    @Basic
    @Column(name = "CDCC")
    public Long getCdcc() {
        return cdcc;
    }

    public void setCdcc(Long cdcc) {
        this.cdcc = cdcc;
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
    @Column(name = "TFRS")
    public Long getTfrs() {
        return tfrs;
    }

    public void setTfrs(Long tfrs) {
        this.tfrs = tfrs;
    }

    @Basic
    @Column(name = "LZSC")
    public Long getLzsc() {
        return lzsc;
    }

    public void setLzsc(Long lzsc) {
        this.lzsc = lzsc;
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
    @Column(name = "JZSY")
    public Long getJzsy() {
        return jzsy;
    }

    public void setJzsy(Long jzsy) {
        this.jzsy = jzsy;
    }

    @Basic
    @Column(name = "JZQZ")
    public Long getJzqz() {
        return jzqz;
    }

    public void setJzqz(Long jzqz) {
        this.jzqz = jzqz;
    }

    @Basic
    @Column(name = "ZCRS")
    public String getZcrs() {
        return zcrs;
    }

    public void setZcrs(String zcrs) {
        this.zcrs = zcrs;
    }

    @Basic
    @Column(name = "CFWZ")
    public String getCfwz() {
        return cfwz;
    }

    public void setCfwz(String cfwz) {
        this.cfwz = cfwz;
    }

    @Basic
    @Column(name = "CFSJ")
    public String getCfsj() {
        return cfsj;
    }

    public void setCfsj(String cfsj) {
        this.cfsj = cfsj;
    }

    @Basic
    @Column(name = "CLLB")
    public String getCllb() {
        return cllb;
    }

    public void setCllb(String cllb) {
        this.cllb = cllb;
    }

    @Basic
    @Column(name = "CLLBFL")
    public String getCllbfl() {
        return cllbfl;
    }

    public void setCllbfl(String cllbfl) {
        this.cllbfl = cllbfl;
    }

    @Basic
    @Column(name = "CLPP")
    public String getClpp() {
        return clpp;
    }

    public void setClpp(String clpp) {
        this.clpp = clpp;
    }

    @Basic
    @Column(name = "CLYS")
    public String getClys() {
        return clys;
    }

    public void setClys(String clys) {
        this.clys = clys;
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
    @Column(name = "RFCS")
    public String getRfcs() {
        return rfcs;
    }

    public void setRfcs(String rfcs) {
        this.rfcs = rfcs;
    }

    @Basic
    @Column(name = "WFCS")
    public String getWfcs() {
        return wfcs;
    }

    public void setWfcs(String wfcs) {
        this.wfcs = wfcs;
    }

    @Basic
    @Column(name = "JFCS")
    public String getJfcs() {
        return jfcs;
    }

    public void setJfcs(String jfcs) {
        this.jfcs = jfcs;
    }

    @Basic
    @Column(name = "FJFF")
    public String getFjff() {
        return fjff;
    }

    public void setFjff(String fjff) {
        this.fjff = fjff;
    }

    @Basic
    @Column(name = "LC")
    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    @Basic
    @Column(name = "YWZSRY")
    public String getYwzsry() {
        return ywzsry;
    }

    public void setYwzsry(String ywzsry) {
        this.ywzsry = ywzsry;
    }

    @Basic
    @Column(name = "YWZYM")
    public String getYwzym() {
        return ywzym;
    }

    public void setYwzym(String ywzym) {
        this.ywzym = ywzym;
    }

    @Basic
    @Column(name = "BJQ")
    public String getBjq() {
        return bjq;
    }

    public void setBjq(String bjq) {
        this.bjq = bjq;
    }

    @Basic
    @Column(name = "DPZL")
    public String getDpzl() {
        return dpzl;
    }

    public void setDpzl(String dpzl) {
        this.dpzl = dpzl;
    }

    @Basic
    @Column(name = "ZDF")
    public String getZdf() {
        return zdf;
    }

    public void setZdf(String zdf) {
        this.zdf = zdf;
    }

    @Basic
    @Column(name = "YFZRS")
    public String getYfzrs() {
        return yfzrs;
    }

    public void setYfzrs(String yfzrs) {
        this.yfzrs = yfzrs;
    }

    @Basic
    @Column(name = "NYFRS")
    public String getNyfrs() {
        return nyfrs;
    }

    public void setNyfrs(String nyfrs) {
        this.nyfrs = nyfrs;
    }

    @Basic
    @Column(name = "LYFRS")
    public String getLyfrs() {
        return lyfrs;
    }

    public void setLyfrs(String lyfrs) {
        this.lyfrs = lyfrs;
    }

    @Basic
    @Column(name = "YFQKBZ")
    public String getYfqkbz() {
        return yfqkbz;
    }

    public void setYfqkbz(String yfqkbz) {
        this.yfqkbz = yfqkbz;
    }

    @Basic
    @Column(name = "ZAJTGJ")
    public String getZajtgj() {
        return zajtgj;
    }

    public void setZajtgj(String zajtgj) {
        this.zajtgj = zajtgj;
    }

    @Basic
    @Column(name = "SJBXG")
    public String getSjbxg() {
        return sjbxg;
    }

    public void setSjbxg(String sjbxg) {
        this.sjbxg = sjbxg;
    }

    @Basic
    @Column(name = "SFLJ")
    public String getSflj() {
        return sflj;
    }

    public void setSflj(String sflj) {
        this.sflj = sflj;
    }

    @Basic
    @Column(name = "SFCJJHB")
    public String getSfcjjhb() {
        return sfcjjhb;
    }

    public void setSfcjjhb(String sfcjjhb) {
        this.sfcjjhb = sfcjjhb;
    }

    @Basic
    @Column(name = "SFYZSRY")
    public String getSfyzsry() {
        return sfyzsry;
    }

    public void setSfyzsry(String sfyzsry) {
        this.sfyzsry = sfyzsry;
    }

    @Basic
    @Column(name = "SFYFDCS")
    public String getSfyfdcs() {
        return sfyfdcs;
    }

    public void setSfyfdcs(String sfyfdcs) {
        this.sfyfdcs = sfyfdcs;
    }

    @Basic
    @Column(name = "CYNXFDS")
    public String getCynxfds() {
        return cynxfds;
    }

    public void setCynxfds(String cynxfds) {
        this.cynxfds = cynxfds;
    }

    @Basic
    @Column(name = "SFYJJSS")
    public String getSfyjjss() {
        return sfyjjss;
    }

    public void setSfyjjss(String sfyjjss) {
        this.sfyjjss = sfyjjss;
    }

    @Basic
    @Column(name = "SFDZQ")
    public String getSfdzq() {
        return sfdzq;
    }

    public void setSfdzq(String sfdzq) {
        this.sfdzq = sfdzq;
    }

    @Basic
    @Column(name = "SFSJTF")
    public String getSfsjtf() {
        return sfsjtf;
    }

    public void setSfsjtf(String sfsjtf) {
        this.sfsjtf = sfsjtf;
    }

    @Basic
    @Column(name = "SFSJFLG")
    public String getSfsjflg() {
        return sfsjflg;
    }

    public void setSfsjflg(String sfsjflg) {
        this.sfsjflg = sfsjflg;
    }

    @Basic
    @Column(name = "ZASD")
    public String getZasd() {
        return zasd;
    }

    public void setZasd(String zasd) {
        this.zasd = zasd;
    }

    @Basic
    @Column(name = "SDFL")
    public String getSdfl() {
        return sdfl;
    }

    public void setSdfl(String sdfl) {
        this.sdfl = sdfl;
    }

    @Basic
    @Column(name = "SDXL")
    public String getSdxl() {
        return sdxl;
    }

    public void setSdxl(String sdxl) {
        this.sdxl = sdxl;
    }

    @Basic
    @Column(name = "ZASF")
    public String getZasf() {
        return zasf;
    }

    public void setZasf(String zasf) {
        this.zasf = zasf;
    }

    @Basic
    @Column(name = "SFFL")
    public String getSffl() {
        return sffl;
    }

    public void setSffl(String sffl) {
        this.sffl = sffl;
    }

    @Basic
    @Column(name = "SFXL")
    public String getSfxl() {
        return sfxl;
    }

    public void setSfxl(String sfxl) {
        this.sfxl = sfxl;
    }

    @Basic
    @Column(name = "ZAXQ")
    public String getZaxq() {
        return zaxq;
    }

    public void setZaxq(String zaxq) {
        this.zaxq = zaxq;
    }

    @Basic
    @Column(name = "XQFL")
    public String getXqfl() {
        return xqfl;
    }

    public void setXqfl(String xqfl) {
        this.xqfl = xqfl;
    }

    @Basic
    @Column(name = "XQXL")
    public String getXqxl() {
        return xqxl;
    }

    public void setXqxl(String xqxl) {
        this.xqxl = xqxl;
    }

    @Basic
    @Column(name = "FAYY")
    public String getFayy() {
        return fayy;
    }

    public void setFayy(String fayy) {
        this.fayy = fayy;
    }

    @Basic
    @Column(name = "YYFL")
    public String getYyfl() {
        return yyfl;
    }

    public void setYyfl(String yyfl) {
        this.yyfl = yyfl;
    }

    @Basic
    @Column(name = "YYXL")
    public String getYyxl() {
        return yyxl;
    }

    public void setYyxl(String yyxl) {
        this.yyxl = yyxl;
    }

    @Basic
    @Column(name = "JQLY")
    public String getJqly() {
        return jqly;
    }

    public void setJqly(String jqly) {
        this.jqly = jqly;
    }

    @Basic
    @Column(name = "JQLB")
    public String getJqlb() {
        return jqlb;
    }

    public void setJqlb(String jqlb) {
        this.jqlb = jqlb;
    }

    @Basic
    @Column(name = "CFLX")
    public String getCflx() {
        return cflx;
    }

    public void setCflx(String cflx) {
        this.cflx = cflx;
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
    @Column(name = "XLLD")
    public String getXlld() {
        return xlld;
    }

    public void setXlld(String xlld) {
        this.xlld = xlld;
    }

    @Basic
    @Column(name = "FXF")
    public String getFxf() {
        return fxf;
    }

    public void setFxf(String fxf) {
        this.fxf = fxf;
    }

    @Basic
    @Column(name = "HJZL")
    public Boolean getHjzl() {
        return hjzl;
    }

    public void setHjzl(Boolean hjzl) {
        this.hjzl = hjzl;
    }

    @Basic
    @Column(name = "CZJG")
    public String getCzjg() {
        return czjg;
    }

    public void setCzjg(String czjg) {
        this.czjg = czjg;
    }

    @Basic
    @Column(name = "CLBH")
    public String getClbh() {
        return clbh;
    }

    public void setClbh(String clbh) {
        this.clbh = clbh;
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
    @Column(name = "BZ")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
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
    @Column(name = "DDXJSJ")
    public Date getDdxjsj() {
        return ddxjsj;
    }

    public void setDdxjsj(Date ddxjsj) {
        this.ddxjsj = ddxjsj;
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
    @Column(name = "SLRJH")
    public String getSlrjh() {
        return slrjh;
    }

    public void setSlrjh(String slrjh) {
        this.slrjh = slrjh;
    }

    @Basic
    @Column(name = "CJRJH")
    public String getCjrjh() {
        return cjrjh;
    }

    public void setCjrjh(String cjrjh) {
        this.cjrjh = cjrjh;
    }

    @Basic
    @Column(name = "HGRJH")
    public String getHgrjh() {
        return hgrjh;
    }

    public void setHgrjh(String hgrjh) {
        this.hgrjh = hgrjh;
    }

    @Basic
    @Column(name = "ZBLDJH")
    public String getZbldjh() {
        return zbldjh;
    }

    public void setZbldjh(String zbldjh) {
        this.zbldjh = zbldjh;
    }

    @Basic
    @Column(name = "GXDW")
    public String getGxdw() {
        return gxdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
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
    @Column(name = "GXBQ")
    public String getGxbq() {
        return gxbq;
    }

    public void setGxbq(String gxbq) {
        this.gxbq = gxbq;
    }

    @Basic
    @Column(name = "XZXL")
    public String getXzxl() {
        return xzxl;
    }

    public void setXzxl(String xzxl) {
        this.xzxl = xzxl;
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

    @JSONField(serialize = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "JJH", referencedColumnName = "JJH", nullable = false)
    public Jcjb getJcjb() {
        return jcjb;
    }

    public void setJcjb(Jcjb jcjb) {
        this.jcjb = jcjb;
    }
}
    



