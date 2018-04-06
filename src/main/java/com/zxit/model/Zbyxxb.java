package com.zxit.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Zbyxxb {

    private String id;
    private String xm;
    private String mm;
    private String bc;
    private String xtsf;
    private Time djrq;
    private String zxbz;
    private Time zxrq;
    private String guid;

    @Basic
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "XM")
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    @Basic
    @Column(name = "MM")
    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    @Basic
    @Column(name = "BC")
    public String getBc() {
        return bc;
    }

    public void setBc(String bc) {
        this.bc = bc;
    }

    @Basic
    @Column(name = "XTSF")
    public String getXtsf() {
        return xtsf;
    }

    public void setXtsf(String xtsf) {
        this.xtsf = xtsf;
    }

    @Basic
    @Column(name = "DJRQ")
    public Time getDjrq() {
        return djrq;
    }

    public void setDjrq(Time djrq) {
        this.djrq = djrq;
    }

    @Basic
    @Column(name = "ZXBZ")
    public String getZxbz() {
        return zxbz;
    }

    public void setZxbz(String zxbz) {
        this.zxbz = zxbz;
    }

    @Basic
    @Column(name = "ZXRQ")
    public Time getZxrq() {
        return zxrq;
    }

    public void setZxrq(Time zxrq) {
        this.zxrq = zxrq;
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
        Zbyxxb zbyxxb = (Zbyxxb) o;
        return Objects.equals(id, zbyxxb.id) &&
                Objects.equals(xm, zbyxxb.xm) &&
                Objects.equals(mm, zbyxxb.mm) &&
                Objects.equals(bc, zbyxxb.bc) &&
                Objects.equals(xtsf, zbyxxb.xtsf) &&
                Objects.equals(djrq, zbyxxb.djrq) &&
                Objects.equals(zxbz, zbyxxb.zxbz) &&
                Objects.equals(zxrq, zbyxxb.zxrq) &&
                Objects.equals(guid, zbyxxb.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, xm, mm, bc, xtsf, djrq, zxbz, zxrq, guid);
    }
}
    



