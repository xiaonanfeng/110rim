package com.zxit.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Hjjlb {

    private String lsh;
    private String zjhm;
    private String zjlx;
    private String hjzt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date ldsj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date slsj;
    private Long ddsc;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date gjsj;
    private Long slsc;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date ddkssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date ddjssj;
    private Long ddusc;
    private String slth;
    private String xxly;
    private String bjhm;
    private String dqbz;
    private String fpfs;
    private String zlfj;
    private String guid;
    
    private Date ldsjStart;
    private Date ldsjEnd;

    @Basic
    @Column(name = "LSH")
    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    @Basic
    @Column(name = "ZJHM")
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    @Basic
    @Column(name = "ZJLX")
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    @Basic
    @Column(name = "HJZT")
    public String getHjzt() {
        return hjzt;
    }

    public void setHjzt(String hjzt) {
        this.hjzt = hjzt;
    }

    @Basic
    @Column(name = "LDSJ")
    public Date getLdsj() {
        return ldsj;
    }

    public void setLdsj(Date ldsj) {
        this.ldsj = ldsj;
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
    @Column(name = "DDSC")
    public Long getDdsc() {
        return ddsc;
    }

    public void setDdsc(Long ddsc) {
        this.ddsc = ddsc;
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
    @Column(name = "SLSC")
    public Long getSlsc() {
        return slsc;
    }

    public void setSlsc(Long slsc) {
        this.slsc = slsc;
    }

    @Basic
    @Column(name = "DDKSSJ")
    public Date getDdkssj() {
        return ddkssj;
    }

    public void setDdkssj(Date ddkssj) {
        this.ddkssj = ddkssj;
    }

    @Basic
    @Column(name = "DDJSSJ")
    public Date getDdjssj() {
        return ddjssj;
    }

    public void setDdjssj(Date ddjssj) {
        this.ddjssj = ddjssj;
    }

    @Basic
    @Column(name = "DDUSC")
    public Long getDdusc() {
        return ddusc;
    }

    public void setDdusc(Long ddusc) {
        this.ddusc = ddusc;
    }

    @Basic
    @Column(name = "SLTH")
    public String getSlth() {
        return slth;
    }

    public void setSlth(String slth) {
        this.slth = slth;
    }

    @Basic
    @Column(name = "XXLY")
    public String getXxly() {
        return xxly;
    }

    public void setXxly(String xxly) {
        this.xxly = xxly;
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
    @Column(name = "DQBZ")
    public String getDqbz() {
        return dqbz;
    }

    public void setDqbz(String dqbz) {
        this.dqbz = dqbz;
    }

    @Basic
    @Column(name = "FPFS")
    public String getFpfs() {
        return fpfs;
    }

    public void setFpfs(String fpfs) {
        this.fpfs = fpfs;
    }

    @Basic
    @Column(name = "ZLFJ")
    public String getZlfj() {
        return zlfj;
    }

    public void setZlfj(String zlfj) {
        this.zlfj = zlfj;
    }

    @Id
    @Column(name = "GUID")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Transient
    public Date getLdsjStart() {
        return ldsjStart;
    }

    public void setLdsjStart(Date ldsjStart) {
        this.ldsjStart = ldsjStart;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Transient
    public Date getLdsjEnd() {
        return ldsjEnd;
    }

    public void setLdsjEnd(Date ldsjEnd) {
        this.ldsjEnd = ldsjEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hjjlb hjjlb = (Hjjlb) o;
        return Objects.equals(lsh, hjjlb.lsh) &&
                Objects.equals(zjhm, hjjlb.zjhm) &&
                Objects.equals(zjlx, hjjlb.zjlx) &&
                Objects.equals(hjzt, hjjlb.hjzt) &&
                Objects.equals(ldsj, hjjlb.ldsj) &&
                Objects.equals(slsj, hjjlb.slsj) &&
                Objects.equals(ddsc, hjjlb.ddsc) &&
                Objects.equals(gjsj, hjjlb.gjsj) &&
                Objects.equals(slsc, hjjlb.slsc) &&
                Objects.equals(ddkssj, hjjlb.ddkssj) &&
                Objects.equals(ddjssj, hjjlb.ddjssj) &&
                Objects.equals(ddusc, hjjlb.ddusc) &&
                Objects.equals(slth, hjjlb.slth) &&
                Objects.equals(xxly, hjjlb.xxly) &&
                Objects.equals(bjhm, hjjlb.bjhm) &&
                Objects.equals(dqbz, hjjlb.dqbz) &&
                Objects.equals(fpfs, hjjlb.fpfs) &&
                Objects.equals(zlfj, hjjlb.zlfj) &&
                Objects.equals(guid, hjjlb.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lsh, zjhm, zjlx, hjzt, ldsj, slsj, ddsc, gjsj, slsc, ddkssj, ddjssj, ddusc, slth, xxly, bjhm, dqbz, fpfs, zlfj, guid);
    }
}
    



