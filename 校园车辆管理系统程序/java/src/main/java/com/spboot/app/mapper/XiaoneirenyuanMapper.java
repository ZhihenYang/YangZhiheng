package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Xiaoneirenyuan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("校内人员")
public interface XiaoneirenyuanMapper extends BaseMapper<Xiaoneirenyuan> {}
