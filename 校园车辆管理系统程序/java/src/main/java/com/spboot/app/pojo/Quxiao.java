package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("quxiao")
public class Quxiao implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer yuyueid;

    private String bianhao;

    private String mingcheng;

    private String quyu;

    private String weizhi;

    private String riqi;

    private String yuyuebianhao;

    private String yuyueshijian;

    private String chepaihao;

    private String yuyuefangke;

    private String quxiaoyuanyin;

    private String addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYuyueid() {
        return yuyueid;
    }

    public void setYuyueid(Integer yuyueid) {
        this.yuyueid = yuyueid == null ? 0 : yuyueid;
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

    public String getYuyuebianhao() {
        return yuyuebianhao;
    }

    public void setYuyuebianhao(String yuyuebianhao) {
        this.yuyuebianhao = yuyuebianhao == null ? "" : yuyuebianhao.trim();
    }

    public String getYuyueshijian() {
        return yuyueshijian;
    }

    public void setYuyueshijian(String yuyueshijian) {
        this.yuyueshijian = yuyueshijian == null ? "" : yuyueshijian.trim();
    }

    public String getChepaihao() {
        return chepaihao;
    }

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao == null ? "" : chepaihao.trim();
    }

    public String getYuyuefangke() {
        return yuyuefangke;
    }

    public void setYuyuefangke(String yuyuefangke) {
        this.yuyuefangke = yuyuefangke == null ? "" : yuyuefangke.trim();
    }

    public String getQuxiaoyuanyin() {
        return quxiaoyuanyin;
    }

    public void setQuxiaoyuanyin(String quxiaoyuanyin) {
        this.quxiaoyuanyin = quxiaoyuanyin == null ? "" : quxiaoyuanyin.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }
}
