package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Yuyue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("预约")
public interface YuyueMapper extends BaseMapper<Yuyue> {}
