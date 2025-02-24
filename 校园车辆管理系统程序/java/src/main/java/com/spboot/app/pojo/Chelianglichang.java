package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("chelianglichang")
public class Chelianglichang implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer cheliangruchangid;

    private String ruchangbianhao;

    private String ruchangshijian;

    private String cheliangpaihao;

    private String chezhudianhua;

    private String lichangshijian;

    private Integer tingcheshichang;

    private String lichangbeizhu;

    private String jingshouren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheliangruchangid() {
        return cheliangruchangid;
    }

    public void setCheliangruchangid(Integer cheliangruchangid) {
        this.cheliangruchangid = cheliangruchangid == null ? 0 : cheliangruchangid;
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

    public String getLichangshijian() {
        return lichangshijian;
    }

    public void setLichangshijian(String lichangshijian) {
        this.lichangshijian = lichangshijian == null ? "" : lichangshijian.trim();
    }

    public Integer getTingcheshichang() {
        return tingcheshichang;
    }

    public void setTingcheshichang(Integer tingcheshichang) {
        this.tingcheshichang = tingcheshichang == null ? 0 : tingcheshichang;
    }

    public String getLichangbeizhu() {
        return lichangbeizhu;
    }

    public void setLichangbeizhu(String lichangbeizhu) {
        this.lichangbeizhu = lichangbeizhu == null ? "" : lichangbeizhu.trim();
    }

    public String getJingshouren() {
        return jingshouren;
    }

    public void setJingshouren(String jingshouren) {
        this.jingshouren = jingshouren == null ? "" : jingshouren.trim();
    }
}
