package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Fangkeyonghu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("访客用户")
public interface FangkeyonghuMapper extends BaseMapper<Fangkeyonghu> {}
