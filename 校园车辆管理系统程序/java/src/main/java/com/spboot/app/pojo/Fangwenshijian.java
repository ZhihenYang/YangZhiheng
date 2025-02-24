package com.spboot.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jntoo.db.DB;
import java.io.Serializable;
import java.util.*;

@TableName("fangwenshijian")
public class Fangwenshijian implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String kaishi;

    private String jiezhi;

    private String shuoming;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKaishi() {
        return kaishi;
    }

    public void setKaishi(String kaishi) {
        this.kaishi = kaishi == null ? "" : kaishi.trim();
    }

    public String getJiezhi() {
        return jiezhi;
    }

    public void setJiezhi(String jiezhi) {
        this.jiezhi = jiezhi == null ? "" : jiezhi.trim();
    }

    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming == null ? "" : shuoming.trim();
    }
}
