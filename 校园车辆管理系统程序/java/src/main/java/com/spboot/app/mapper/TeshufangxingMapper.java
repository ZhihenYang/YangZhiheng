package com.spboot.app.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spboot.app.pojo.Teshufangxing;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("特殊放行")
public interface TeshufangxingMapper extends BaseMapper<Teshufangxing> {}
