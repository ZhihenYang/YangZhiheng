package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("zhiliuquanchu")
public class Zhiliuquanchu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String quanchubianhao;

    private String cheliangpaihao;

    private String chezhuxingming;

    private String chezhudianhua;

    private String ruchangshijian;

    private String quanchushijian;

    private Integer zhiliushizhang;

    private String beizhushuoming;

    private String jingshouren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuanchubianhao() {
        return quanchubianhao;
    }

    public void setQuanchubianhao(String quanchubianhao) {
        this.quanchubianhao = quanchubianhao == null ? "" : quanchubianhao.trim();
    }

    public String getCheliangpaihao() {
        return cheliangpaihao;
    }

    public void setCheliangpaihao(String cheliangpaihao) {
        this.cheliangpaihao = cheliangpaihao == null ? "" : cheliangpaihao.trim();
    }

    public String getChezhuxingming() {
        return chezhuxingming;
    }

    public void setChezhuxingming(String chezhuxingming) {
        this.chezhuxingming = chezhuxingming == null ? "" : chezhuxingming.trim();
    }

    public String getChezhudianhua() {
        return chezhudianhua;
    }

    public void setChezhudianhua(String chezhudianhua) {
        this.chezhudianhua = chezhudianhua == null ? "" : chezhudianhua.trim();
    }

    public String getRuchangshijian() {
        return ruchangshijian;
    }

    public void setRuchangshijian(String ruchangshijian) {
        this.ruchangshijian = ruchangshijian == null ? "" : ruchangshijian.trim();
    }

    public String getQuanchushijian() {
        return quanchushijian;
    }

    public void setQuanchushijian(String quanchushijian) {
        this.quanchushijian = quanchushijian == null ? "" : quanchushijian.trim();
    }

    public Integer getZhiliushizhang() {
        return zhiliushizhang;
    }

    public void setZhiliushizhang(Integer zhiliushizhang) {
        this.zhiliushizhang = zhiliushizhang == null ? 0 : zhiliushizhang;
    }

    public String getBeizhushuoming() {
        return beizhushuoming;
    }

    public void setBeizhushuoming(String beizhushuoming) {
        this.beizhushuoming = beizhushuoming == null ? "" : beizhushuoming.trim();
    }

    public String getJingshouren() {
        return jingshouren;
    }

    public void setJingshouren(String jingshouren) {
        this.jingshouren = jingshouren == null ? "" : jingshouren.trim();
    }
}
