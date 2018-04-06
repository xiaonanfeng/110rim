package com.zxit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Jjdwb {

    private String xh;
    private String ywlx;
    private String dwbh;
    private String dwmc;
    private String dhhm;
    private String gxdh;
    private String lwzt;
    private String qy;
    private String bhwlm;
    private String dip;
    private String dipport;
    private String uip;
    private String uipport;
    private String yssj;
    private String dsn;
    private String username;
    private String pass;
    private String xsj;
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
    @Column(name = "DWBH")
    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    @Basic
    @Column(name = "DWMC")
    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    @Basic
    @Column(name = "DHHM")
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    @Basic
    @Column(name = "GXDH")
    public String getGxdh() {
        return gxdh;
    }

    public void setGxdh(String gxdh) {
        this.gxdh = gxdh;
    }

    @Basic
    @Column(name = "LWZT")
    public String getLwzt() {
        return lwzt;
    }

    public void setLwzt(String lwzt) {
        this.lwzt = lwzt;
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
    @Column(name = "BHWLM")
    public String getBhwlm() {
        return bhwlm;
    }

    public void setBhwlm(String bhwlm) {
        this.bhwlm = bhwlm;
    }

    @Basic
    @Column(name = "DIP")
    public String getDip() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    @Basic
    @Column(name = "DIPPORT")
    public String getDipport() {
        return dipport;
    }

    public void setDipport(String dipport) {
        this.dipport = dipport;
    }

    @Basic
    @Column(name = "UIP")
    public String getUip() {
        return uip;
    }

    public void setUip(String uip) {
        this.uip = uip;
    }

    @Basic
    @Column(name = "UIPPORT")
    public String getUipport() {
        return uipport;
    }

    public void setUipport(String uipport) {
        this.uipport = uipport;
    }

    @Basic
    @Column(name = "YSSJ")
    public String getYssj() {
        return yssj;
    }

    public void setYssj(String yssj) {
        this.yssj = yssj;
    }

    @Basic
    @Column(name = "DSN")
    public String getDsn() {
        return dsn;
    }

    public void setDsn(String dsn) {
        this.dsn = dsn;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASS")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "XSJ")
    public String getXsj() {
        return xsj;
    }

    public void setXsj(String xsj) {
        this.xsj = xsj;
    }

    @Id
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
        Jjdwb jjdwb = (Jjdwb) o;
        return Objects.equals(xh, jjdwb.xh) &&
                Objects.equals(ywlx, jjdwb.ywlx) &&
                Objects.equals(dwbh, jjdwb.dwbh) &&
                Objects.equals(dwmc, jjdwb.dwmc) &&
                Objects.equals(dhhm, jjdwb.dhhm) &&
                Objects.equals(gxdh, jjdwb.gxdh) &&
                Objects.equals(lwzt, jjdwb.lwzt) &&
                Objects.equals(qy, jjdwb.qy) &&
                Objects.equals(bhwlm, jjdwb.bhwlm) &&
                Objects.equals(dip, jjdwb.dip) &&
                Objects.equals(dipport, jjdwb.dipport) &&
                Objects.equals(uip, jjdwb.uip) &&
                Objects.equals(uipport, jjdwb.uipport) &&
                Objects.equals(yssj, jjdwb.yssj) &&
                Objects.equals(dsn, jjdwb.dsn) &&
                Objects.equals(username, jjdwb.username) &&
                Objects.equals(pass, jjdwb.pass) &&
                Objects.equals(xsj, jjdwb.xsj) &&
                Objects.equals(guid, jjdwb.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xh, ywlx, dwbh, dwmc, dhhm, gxdh, lwzt, qy, bhwlm, dip, dipport, uip, uipport, yssj, dsn, username, pass, xsj, guid);
    }
}
    



