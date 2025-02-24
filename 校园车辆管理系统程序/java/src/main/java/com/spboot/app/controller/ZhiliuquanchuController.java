package com.spboot.app.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.jntoo.db.DB;
import com.jntoo.db.utils.StringUtil;
import com.spboot.app.mapper.ZhiliuquanchuMapper;
import com.spboot.app.pojo.Zhiliuquanchu;
import com.spboot.app.service.ZhiliuquanchuService;
import com.spboot.app.utils.R;
import com.spboot.app.utils.SessionFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = { "滞留劝出控制器" })
@RestController
@RequestMapping("/api/zhiliuquanchu")
public class ZhiliuquanchuController {

    @Autowired
    public ZhiliuquanchuService zhiliuquanchuService;

    @ApiOperation(value = "获取全部滞留劝出", httpMethod = "GET")
    @RequestMapping("/selectAll")
    public R<List<Zhiliuquanchu>> selectAll() {
        return zhiliuquanchuService.selectAll();
    }

    @ApiOperation(value = "根据条件筛选获取管理员列表，并分页", httpMethod = "POST")
    @RequestMapping("/selectPages")
    public R selectPages(@RequestBody Map<String, Object> req) {
        return zhiliuquanchuService.selectPages(req);
    }

    @ApiOperation(value = "根据条件筛选获取经手人字段值为当前用户列表并分页", httpMethod = "POST")
    @RequestMapping("/selectJingshouren")
    public R selectJingshouren(@RequestBody Map<String, Object> req) {
        return zhiliuquanchuService.selectPagesJingshouren(req);
    }

    @ApiOperation(value = "根据id获取信息", httpMethod = "GET")
    @RequestMapping("/findById")
    @ApiImplicitParam(name = "id", value = "滞留劝出对应的id", dataType = "Integer")
    public R findById(@RequestParam Integer id) {
        return zhiliuquanchuService.findById(id);
    }

    @ApiOperation(value = "根据id更新数据", httpMethod = "POST")
    @RequestMapping("/update")
    @ApiImplicitParam(name = "data", value = "使用json数据提交", type = "json", dataTypeClass = Zhiliuquanchu.class, paramType = "body")
    public R update(@RequestBody Map data) {
        Zhiliuquanchu post = BeanUtil.mapToBean(data, Zhiliuquanchu.class, true);
        return zhiliuquanchuService.update(post, data);
    }

    @ApiOperation(value = "插入一行数据，返回插入后的点赞", httpMethod = "POST")
    @RequestMapping("/insert")
    @ApiImplicitParam(name = "data", value = "使用json数据提交", type = "json", dataTypeClass = Zhiliuquanchu.class, paramType = "body")
    public R insert(@RequestBody Map data) {
        Zhiliuquanchu post = BeanUtil.mapToBean(data, Zhiliuquanchu.class, true);
        return zhiliuquanchuService.insert(post, data);
    }

    @ApiOperation(value = "根据id列表删除数据", httpMethod = "POST")
    @RequestMapping("/delete")
    @ApiImplicitParam(name = "id", value = "滞留劝出对应的id", type = "json", dataTypeClass = List.class)
    public R delete(@RequestBody List<Integer> id) {
        return zhiliuquanchuService.delete(id);
    }
}
