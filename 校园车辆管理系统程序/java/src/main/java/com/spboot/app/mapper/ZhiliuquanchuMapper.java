package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Zhiliuquanchu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("滞留劝出")
public interface ZhiliuquanchuMapper extends BaseMapper<Zhiliuquanchu> {}
