package com.zxit.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class CallinfoBb {

    private Jcjb jcjb;
    private String callid;
    private String eventid;
    private String callerid;
    private String calledid;
    private Time calltime;
    private Time hanguptime;
    private String calltype;
    private Time toagetime;
    private Time ageanswertime;
    private String dutyid;
    private String ageid;
    private String callprotype;
    private Time recStarttime;
    private Time recEndtime;
    private Long recTimelen;
    private String filename;
    private String calldir;
    private String absPath;
    private String note;
    private String guid;

    @Basic
    @Column(name = "CALLID")
    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    @Basic
    @Column(name = "EVENTID",insertable = false, updatable = false)
    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    @Basic
    @Column(name = "CALLERID")
    public String getCallerid() {
        return callerid;
    }

    public void setCallerid(String callerid) {
        this.callerid = callerid;
    }

    @Basic
    @Column(name = "CALLEDID")
    public String getCalledid() {
        return calledid;
    }

    public void setCalledid(String calledid) {
        this.calledid = calledid;
    }

    @Basic
    @Column(name = "CALLTIME")
    public Time getCalltime() {
        return calltime;
    }

    public void setCalltime(Time calltime) {
        this.calltime = calltime;
    }

    @Basic
    @Column(name = "HANGUPTIME")
    public Time getHanguptime() {
        return hanguptime;
    }

    public void setHanguptime(Time hanguptime) {
        this.hanguptime = hanguptime;
    }

    @Basic
    @Column(name = "CALLTYPE")
    public String getCalltype() {
        return calltype;
    }

    public void setCalltype(String calltype) {
        this.calltype = calltype;
    }

    @Basic
    @Column(name = "TOAGETIME")
    public Time getToagetime() {
        return toagetime;
    }

    public void setToagetime(Time toagetime) {
        this.toagetime = toagetime;
    }

    @Basic
    @Column(name = "AGEANSWERTIME")
    public Time getAgeanswertime() {
        return ageanswertime;
    }

    public void setAgeanswertime(Time ageanswertime) {
        this.ageanswertime = ageanswertime;
    }

    @Basic
    @Column(name = "DUTYID")
    public String getDutyid() {
        return dutyid;
    }

    public void setDutyid(String dutyid) {
        this.dutyid = dutyid;
    }

    @Basic
    @Column(name = "AGEID")
    public String getAgeid() {
        return ageid;
    }

    public void setAgeid(String ageid) {
        this.ageid = ageid;
    }

    @Basic
    @Column(name = "CALLPROTYPE")
    public String getCallprotype() {
        return callprotype;
    }

    public void setCallprotype(String callprotype) {
        this.callprotype = callprotype;
    }

    @Basic
    @Column(name = "REC_STARTTIME")
    public Time getRecStarttime() {
        return recStarttime;
    }

    public void setRecStarttime(Time recStarttime) {
        this.recStarttime = recStarttime;
    }

    @Basic
    @Column(name = "REC_ENDTIME")
    public Time getRecEndtime() {
        return recEndtime;
    }

    public void setRecEndtime(Time recEndtime) {
        this.recEndtime = recEndtime;
    }

    @Basic
    @Column(name = "REC_TIMELEN")
    public Long getRecTimelen() {
        return recTimelen;
    }

    public void setRecTimelen(Long recTimelen) {
        this.recTimelen = recTimelen;
    }

    @Basic
    @Column(name = "FILENAME")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Basic
    @Column(name = "CALLDIR")
    public String getCalldir() {
        return calldir;
    }

    public void setCalldir(String calldir) {
        this.calldir = calldir;
    }

    @Basic
    @Column(name = "ABS_PATH")
    public String getAbsPath() {
        return absPath;
    }

    public void setAbsPath(String absPath) {
        this.absPath = absPath;
    }

    @Basic
    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        CallinfoBb that = (CallinfoBb) o;
        return Objects.equals(callid, that.callid) &&
                Objects.equals(eventid, that.eventid) &&
                Objects.equals(callerid, that.callerid) &&
                Objects.equals(calledid, that.calledid) &&
                Objects.equals(calltime, that.calltime) &&
                Objects.equals(hanguptime, that.hanguptime) &&
                Objects.equals(calltype, that.calltype) &&
                Objects.equals(toagetime, that.toagetime) &&
                Objects.equals(ageanswertime, that.ageanswertime) &&
                Objects.equals(dutyid, that.dutyid) &&
                Objects.equals(ageid, that.ageid) &&
                Objects.equals(callprotype, that.callprotype) &&
                Objects.equals(recStarttime, that.recStarttime) &&
                Objects.equals(recEndtime, that.recEndtime) &&
                Objects.equals(recTimelen, that.recTimelen) &&
                Objects.equals(filename, that.filename) &&
                Objects.equals(calldir, that.calldir) &&
                Objects.equals(absPath, that.absPath) &&
                Objects.equals(note, that.note) &&
                Objects.equals(guid, that.guid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(callid, eventid, callerid, calledid, calltime, hanguptime, calltype, toagetime, ageanswertime, dutyid, ageid, callprotype, recStarttime, recEndtime, recTimelen, filename, calldir, absPath, note, guid);
    }

    @JSONField(serialize = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENTID", referencedColumnName = "JJH", nullable = false)
    public Jcjb getJcjb() {
        return jcjb;
    }

    public void setJcjb(Jcjb jcjb) {
        this.jcjb = jcjb;
    }

}
    



