package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("yuyue")
public class Yuyue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer shengyucheweiid;

    private String bianhao;

    private String mingcheng;

    private String quyu;

    private String weizhi;

    private String riqi;

    private String yuyuebianhao;

    private String yuyueshijian;

    private String chepaihao;

    private String shenfenzhenghao;

    private String shoujihao;

    private String xingming;

    private String qitabeizhu;

    private String yuyuefangke;

    private String zhuangtai;

    private String addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getQuxiaoCount() {
        return DB.name("quxiao").where("yuyueid", id).count();
    }

    public Integer getShengyucheweiid() {
        return shengyucheweiid;
    }

    public void setShengyucheweiid(Integer shengyucheweiid) {
        this.shengyucheweiid = shengyucheweiid == null ? 0 : shengyucheweiid;
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

    public String getShenfenzhenghao() {
        return shenfenzhenghao;
    }

    public void setShenfenzhenghao(String shenfenzhenghao) {
        this.shenfenzhenghao = shenfenzhenghao == null ? "" : shenfenzhenghao.trim();
    }

    public String getShoujihao() {
        return shoujihao;
    }

    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao == null ? "" : shoujihao.trim();
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming == null ? "" : xingming.trim();
    }

    public String getQitabeizhu() {
        return qitabeizhu;
    }

    public void setQitabeizhu(String qitabeizhu) {
        this.qitabeizhu = qitabeizhu == null ? "" : qitabeizhu.trim();
    }

    public String getYuyuefangke() {
        return yuyuefangke;
    }

    public void setYuyuefangke(String yuyuefangke) {
        this.yuyuefangke = yuyuefangke == null ? "" : yuyuefangke.trim();
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? "" : zhuangtai.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? "" : addtime.trim();
    }
}
