package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("xiaoneicheliang")
public class Xiaoneicheliang implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String cheliangbianhao;

    private String cheliangmingcheng;

    private String cheliangpinpai;

    private String cheliangyanse;

    private String cheliangpaihao;

    private String cheliangjianjie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheliangbianhao() {
        return cheliangbianhao;
    }

    public void setCheliangbianhao(String cheliangbianhao) {
        this.cheliangbianhao = cheliangbianhao == null ? "" : cheliangbianhao.trim();
    }

    public String getCheliangmingcheng() {
        return cheliangmingcheng;
    }

    public void setCheliangmingcheng(String cheliangmingcheng) {
        this.cheliangmingcheng = cheliangmingcheng == null ? "" : cheliangmingcheng.trim();
    }

    public String getCheliangpinpai() {
        return cheliangpinpai;
    }

    public void setCheliangpinpai(String cheliangpinpai) {
        this.cheliangpinpai = cheliangpinpai == null ? "" : cheliangpinpai.trim();
    }

    public String getCheliangyanse() {
        return cheliangyanse;
    }

    public void setCheliangyanse(String cheliangyanse) {
        this.cheliangyanse = cheliangyanse == null ? "" : cheliangyanse.trim();
    }

    public String getCheliangpaihao() {
        return cheliangpaihao;
    }

    public void setCheliangpaihao(String cheliangpaihao) {
        this.cheliangpaihao = cheliangpaihao == null ? "" : cheliangpaihao.trim();
    }

    public String getCheliangjianjie() {
        return cheliangjianjie;
    }

    public void setCheliangjianjie(String cheliangjianjie) {
        this.cheliangjianjie = cheliangjianjie == null ? "" : cheliangjianjie.trim();
    }
}
