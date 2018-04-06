package com.zxit.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ajb {

    private String xh;
    private String ywlx;
    private String ajlx;
    private String ajxz;
    private String xzfl;
    private String xzxl;
    private String xsj;
    private String ajjb;
    private String sffs;
    private String sfyczjhm;
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
    @Column(name = "YWLX")
    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
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
    @Column(name = "XZXL")
    public String getXzxl() {
        return xzxl;
    }

    public void setXzxl(String xzxl) {
        this.xzxl = xzxl;
    }

    @Basic
    @Column(name = "XSJ")
    public String getXsj() {
        return xsj;
    }

    public void setXsj(String xsj) {
        this.xsj = xsj;
    }

    @Basic
    @Column(name = "AJJB")
    public String getAjjb() {
        return ajjb;
    }

    public void setAjjb(String ajjb) {
        this.ajjb = ajjb;
    }

    @Basic
    @Column(name = "SFFS")
    public String getSffs() {
        return sffs;
    }

    public void setSffs(String sffs) {
        this.sffs = sffs;
    }

    @Basic
    @Column(name = "SFYCZJHM")
    public String getSfyczjhm() {
        return sfyczjhm;
    }

    public void setSfyczjhm(String sfyczjhm) {
        this.sfyczjhm = sfyczjhm;
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
        Ajb ajb = (Ajb) o;
        return Objects.equals(xh, ajb.xh) &&
                Objects.equals(ywlx, ajb.ywlx) &&
                Objects.equals(ajlx, ajb.ajlx) &&
                Objects.equals(ajxz, ajb.ajxz) &&
                Objects.equals(xzfl, ajb.xzfl) &&
                Objects.equals(xzxl, ajb.xzxl) &&
                Objects.equals(xsj, ajb.xsj) &&
                Objects.equals(ajjb, ajb.ajjb) &&
                Objects.equals(sffs, ajb.sffs) &&
                Objects.equals(sfyczjhm, ajb.sfyczjhm) &&
                Objects.equals(guid, ajb.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xh, ywlx, ajlx, ajxz, xzfl, xzxl, xsj, ajjb, sffs, sfyczjhm, guid);
    }



}
    



