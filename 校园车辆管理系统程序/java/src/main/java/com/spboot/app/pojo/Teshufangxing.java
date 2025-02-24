package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("teshufangxing")
public class Teshufangxing implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String fangxingbianhao;

    private String fangxingshijian;

    private String cheliangpaihao;

    private String chezhudianhua;

    private String chezhuxingming;

    private String chezhushenfenzhenghao;

    private String fangxingshuoming;

    private String jingshouren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFangxingbianhao() {
        return fangxingbianhao;
    }

    public void setFangxingbianhao(String fangxingbianhao) {
        this.fangxingbianhao = fangxingbianhao == null ? "" : fangxingbianhao.trim();
    }

    public String getFangxingshijian() {
        return fangxingshijian;
    }

    public void setFangxingshijian(String fangxingshijian) {
        this.fangxingshijian = fangxingshijian == null ? "" : fangxingshijian.trim();
    }

    public String getCheliangpaihao() {
        return cheliangpaihao;
    }

    public void setCheliangpaihao(String cheliangpaihao) {
        this.cheliangpaihao = cheliangpaihao == null ? "" : cheliangpaihao.trim();
    }

    public String getChezhudianhua() {
        return chezhudianhua;
    }

    public void setChezhudianhua(String chezhudianhua) {
        this.chezhudianhua = chezhudianhua == null ? "" : chezhudianhua.trim();
    }

    public String getChezhuxingming() {
        return chezhuxingming;
    }

    public void setChezhuxingming(String chezhuxingming) {
        this.chezhuxingming = chezhuxingming == null ? "" : chezhuxingming.trim();
    }

    public String getChezhushenfenzhenghao() {
        return chezhushenfenzhenghao;
    }

    public void setChezhushenfenzhenghao(String chezhushenfenzhenghao) {
        this.chezhushenfenzhenghao = chezhushenfenzhenghao == null ? "" : chezhushenfenzhenghao.trim();
    }

    public String getFangxingshuoming() {
        return fangxingshuoming;
    }

    public void setFangxingshuoming(String fangxingshuoming) {
        this.fangxingshuoming = fangxingshuoming == null ? "" : fangxingshuoming.trim();
    }

    public String getJingshouren() {
        return jingshouren;
    }

    public void setJingshouren(String jingshouren) {
        this.jingshouren = jingshouren == null ? "" : jingshouren.trim();
    }
}
