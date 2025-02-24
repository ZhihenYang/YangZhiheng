package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("cheliangruchang")
public class Cheliangruchang implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String ruchangbianhao;

    private String ruchangshijian;

    private String cheliangpaihao;

    private String chezhudianhua;

    private String ruchangshuoming;

    private String zhuangtai;

    private String jingshouren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getChelianglichangCount() {
        return DB.name("chelianglichang").where("cheliangruchangid", id).count();
    }

    public String getRuchangbianhao() {
        return ruchangbianhao;
    }

    public void setRuchangbianhao(String ruchangbianhao) {
        this.ruchangbianhao = ruchangbianhao == null ? "" : ruchangbianhao.trim();
    }

    public String getRuchangshijian() {
        return ruchangshijian;
    }

    public void setRuchangshijian(String ruchangshijian) {
        this.ruchangshijian = ruchangshijian == null ? "" : ruchangshijian.trim();
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

    public String getRuchangshuoming() {
        return ruchangshuoming;
    }

    public void setRuchangshuoming(String ruchangshuoming) {
        this.ruchangshuoming = ruchangshuoming == null ? "" : ruchangshuoming.trim();
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? "" : zhuangtai.trim();
    }

    public String getJingshouren() {
        return jingshouren;
    }

    public void setJingshouren(String jingshouren) {
        this.jingshouren = jingshouren == null ? "" : jingshouren.trim();
    }
}
