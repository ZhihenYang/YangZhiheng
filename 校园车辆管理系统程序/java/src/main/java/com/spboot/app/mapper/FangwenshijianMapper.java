package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Fangwenshijian;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("访问时间")
public interface FangwenshijianMapper extends BaseMapper<Fangwenshijian> {}
