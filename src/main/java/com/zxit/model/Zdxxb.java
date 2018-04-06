package com.zxit.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ZDXXB")
public class Zdxxb {

    private String xh;
    private String lx;
    private String th;
    private String ssdwbh;
    private String fjhm;
    private String zhfj;
    private String nxdh;
    private String bz;
    private String beijiao;
    private String guid;

    @Basic
    @Column(name = "XH")
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Basic
    @Column(name = "LX")
    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    @Basic
    @Column(name = "TH")
    public String getTh() {
        return th;
    }

    public void setTh(String th) {
        this.th = th;
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
    @Column(name = "FJHM")
    public String getFjhm() {
        return fjhm;
    }

    public void setFjhm(String fjhm) {
        this.fjhm = fjhm;
    }

    @Basic
    @Column(name = "ZHFJ")
    public String getZhfj() {
        return zhfj;
    }

    public void setZhfj(String zhfj) {
        this.zhfj = zhfj;
    }

    @Basic
    @Column(name = "NXDH")
    public String getNxdh() {
        return nxdh;
    }

    public void setNxdh(String nxdh) {
        this.nxdh = nxdh;
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
    @Column(name = "BEIJIAO")
    public String getBeijiao() {
        return beijiao;
    }

    public void setBeijiao(String beijiao) {
        this.beijiao = beijiao;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zdxxb zdxxb = (Zdxxb) o;
        return Objects.equals(xh, zdxxb.xh) &&
                Objects.equals(lx, zdxxb.lx) &&
                Objects.equals(th, zdxxb.th) &&
                Objects.equals(ssdwbh, zdxxb.ssdwbh) &&
                Objects.equals(fjhm, zdxxb.fjhm) &&
                Objects.equals(zhfj, zdxxb.zhfj) &&
                Objects.equals(nxdh, zdxxb.nxdh) &&
                Objects.equals(bz, zdxxb.bz) &&
                Objects.equals(beijiao, zdxxb.beijiao) &&
                Objects.equals(guid, zdxxb.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xh, lx, th, ssdwbh, fjhm, zhfj, nxdh, bz, beijiao, guid);
    }
}
    



