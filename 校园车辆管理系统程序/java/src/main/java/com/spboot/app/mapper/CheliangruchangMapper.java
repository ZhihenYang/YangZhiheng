package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Cheliangruchang;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("车辆入场")
public interface CheliangruchangMapper extends BaseMapper<Cheliangruchang> {}
