package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Quxiao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("取消")
public interface QuxiaoMapper extends BaseMapper<Quxiao> {}
