package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Chelianglichang;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("车辆离场")
public interface ChelianglichangMapper extends BaseMapper<Chelianglichang> {}
