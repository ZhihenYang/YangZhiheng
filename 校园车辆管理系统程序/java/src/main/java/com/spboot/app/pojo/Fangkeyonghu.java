package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("fangkeyonghu")
public class Fangkeyonghu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String zhanghao;

    //@JsonIgnore // 这个字段不返回前端
    private String mima;

    private String xingming;

    private String xingbie;

    private String lianxifangshi;

    private String gerenyouxiang;

    private String gerenjianjie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZhanghao() {
        return zhanghao;
    }

    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao == null ? "" : zhanghao.trim();
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima == null ? "" : mima.trim();
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming == null ? "" : xingming.trim();
    }

    public String getXingbie() {
        return xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? "" : xingbie.trim();
    }

    public String getLianxifangshi() {
        return lianxifangshi;
    }

    public void setLianxifangshi(String lianxifangshi) {
        this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi.trim();
    }

    public String getGerenyouxiang() {
        return gerenyouxiang;
    }

    public void setGerenyouxiang(String gerenyouxiang) {
        this.gerenyouxiang = gerenyouxiang == null ? "" : gerenyouxiang.trim();
    }

    public String getGerenjianjie() {
        return gerenjianjie;
    }

    public void setGerenjianjie(String gerenjianjie) {
        this.gerenjianjie = gerenjianjie == null ? "" : gerenjianjie.trim();
    }
}
