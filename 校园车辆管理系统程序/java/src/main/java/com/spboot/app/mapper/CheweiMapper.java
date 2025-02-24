package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Chewei;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("车位")
public interface CheweiMapper extends BaseMapper<Chewei> {}
