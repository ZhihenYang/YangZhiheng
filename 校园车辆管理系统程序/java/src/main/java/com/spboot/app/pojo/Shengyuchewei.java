package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("shengyuchewei")
public class Shengyuchewei implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer cheweiid;

    private String bianhao;

    private String mingcheng;

    private String quyu;

    private String weizhi;

    private String riqi;

    private Integer shengyuchewei;

    private String shuoming;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getYuyueCount() {
        return DB.name("yuyue").where("shengyucheweiid", id).count();
    }

    public Integer getCheweiid() {
        return cheweiid;
    }

    public void setCheweiid(Integer cheweiid) {
        this.cheweiid = cheweiid == null ? 0 : cheweiid;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? "" : bianhao.trim();
    }

    public String getMingcheng() {
        return mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng == null ? "" : mingcheng.trim();
    }

    public String getQuyu() {
        return quyu;
    }

    public void setQuyu(String quyu) {
        this.quyu = quyu == null ? "" : quyu.trim();
    }

    public String getWeizhi() {
        return weizhi;
    }

    public void setWeizhi(String weizhi) {
        this.weizhi = weizhi == null ? "" : weizhi.trim();
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi == null ? "" : riqi.trim();
    }

    public Integer getShengyuchewei() {
        return shengyuchewei;
    }

    public void setShengyuchewei(Integer shengyuchewei) {
        this.shengyuchewei = shengyuchewei == null ? 0 : shengyuchewei;
    }

    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming == null ? "" : shuoming.trim();
    }
}
