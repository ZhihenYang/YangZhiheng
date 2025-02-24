package com.spboot.app.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jntoo.db.DB;
import com.jntoo.db.utils.Convert;
import com.jntoo.db.utils.StringUtil;
import com.spboot.app.mapper.ZhiliuquanchuMapper;
import com.spboot.app.pojo.Zhiliuquanchu;
import com.spboot.app.utils.*;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ZhiliuquanchuService {

    // 获取数据库操作类mapper
    @Resource
    private ZhiliuquanchuMapper mapper;

    /**
     *  根据id 获取一行数据
     */
    public R<Zhiliuquanchu> findById(Integer id) {
        return R.success(mapper.selectById(id));
    }

    /**
     *  根据Wrapper 对象进行数据筛选
     */
    public R<List<Zhiliuquanchu>> selectAll(Wrapper<Zhiliuquanchu> query) {
        return R.success(mapper.selectList(query));
    }

    /**
     *  直接筛选所有数据
     */
    public R<List<Zhiliuquanchu>> selectAll() {
        QueryWrapper<Zhiliuquanchu> wrapper = Wrappers.query();
        wrapper.orderByDesc("id");
        return selectAll(wrapper);
    }

    /**
     *  根据map 条件筛选数据
     *
     */
    public R selectAll(Map<String, Object> map) {
        // 获取筛选数据
        SelectPage selectPage = new SelectPage(map, 10, "id", "DESC");
        // 将提交的参数转换成 mybatisplus 的QueryWrapper 筛选数据对象，执行动态查询
        QueryWrapper<Zhiliuquanchu> wrapper = mapToWrapper(map);
        // 设置排序
        wrapper.orderBy(true, selectPage.isAsc(), selectPage.getOrderby());
        return selectAll(wrapper);
    }

    /**
     *  根据map 条件筛选数据并分页
     *
     */
    public R selectPages(Map<String, Object> map) {
        // 获取筛选数据
        SelectPage selectPage = new SelectPage(map, 10, "id", "DESC");
        // 将提交的参数转换成 mybatisplus 的QueryWrapper 筛选数据对象，执行动态查询
        QueryWrapper<Zhiliuquanchu> wrapper = mapToWrapper(map);
        // 设置排序
        wrapper.orderBy(true, selectPage.isAsc(), selectPage.getOrderby());
        // 设置分页数据
        Page page = new Page(selectPage.getPage(), selectPage.getPagesize());
        return selectPages(wrapper, page);
    }

    /**
     *  根据map 条件筛选jingshouren字段等于session.username的数据并分页
     *
     */
    public R selectPagesJingshouren(Map<String, Object> map) {
        // 获取前端给到列表基础参数
        SelectPage selectPage = new SelectPage(map, 10, "id", "DESC");
        // 将map参数转换为mybatis-plus的QueryWrapper类
        QueryWrapper<Zhiliuquanchu> wrapper = mapToWrapper(map);
        // 设置为当前角色
        wrapper.eq("jingshouren", SessionFactory.getUsername());
        wrapper.orderBy(true, selectPage.isAsc(), selectPage.getOrderby());
        Page page = new Page(selectPage.getPage(), selectPage.getPagesize());
        return selectPages(wrapper, page);
    }

    /**
     *   将提交的参数转换成 mybatisplus 的QueryWrapper 筛选数据对象
     */
    public QueryWrapper<Zhiliuquanchu> mapToWrapper(Map<String, Object> map) {
        // 创建 QueryWrapper 对象
        QueryWrapper<Zhiliuquanchu> wrapper = Wrappers.query();

        String where = " 1=1 ";
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句

        if (!StringUtil.isNullOrEmpty(map.get("quanchubianhao"))) {
            wrapper.like("quanchubianhao", map.get("quanchubianhao"));
        }
        if (!StringUtil.isNullOrEmpty(map.get("cheliangpaihao"))) {
            wrapper.like("cheliangpaihao", map.get("cheliangpaihao"));
        }

        if (map.containsKey("session_name")) {
            wrapper.eq(map.get("session_name").toString(), SessionFactory.getUsername());
        }

        wrapper.apply(where);
        return wrapper;
    }

    public R selectPages(QueryWrapper<Zhiliuquanchu> wrapper, IPage page) {
        Map result = new HashMap();
        result.put("lists", mapper.selectPage(page, wrapper));

        return R.success(result);
    }

    /**
     * 插入用户数据
     * @param entityData 插入的对象
     * @param post 提交的数据
     * @return 是否处理成功
     */
    public R insert(Zhiliuquanchu entityData, Map post) {
        // 判断是否有填写劝出编号。
        if (StringUtil.isNullOrEmpty(entityData.getQuanchubianhao())) {
            return R.error("请填写劝出编号");
        }

        // 判断是否有填写车辆牌号。
        if (StringUtil.isNullOrEmpty(entityData.getCheliangpaihao())) {
            return R.error("请填写车辆牌号");
        }

        // 判断是否有填写车主姓名。
        if (StringUtil.isNullOrEmpty(entityData.getChezhuxingming())) {
            return R.error("请填写车主姓名");
        }

        // 判断是否有填写车主电话。
        if (StringUtil.isNullOrEmpty(entityData.getChezhudianhua())) {
            return R.error("请填写车主电话");
        }

        // 判断是否有填写车主电话,有则判断是否为手机号码或者座机。
        if (!StringUtil.isNullOrEmpty(entityData.getChezhudianhua())) {
            if (!(Validator.isMatchRegex(PatternPool.TEL, entityData.getChezhudianhua()) || Validator.isMobile(entityData.getChezhudianhua()))) {
                return R.error("请输入正确的车主电话");
            }
        }

        // 判断是否有填写入场时间。
        if (StringUtil.isNullOrEmpty(entityData.getRuchangshijian())) {
            return R.error("请填写入场时间");
        }

        // 判断是否有填写劝出时间。
        if (StringUtil.isNullOrEmpty(entityData.getQuanchushijian())) {
            return R.error("请填写劝出时间");
        }

        Info.handlerNullEntity(entityData);

        entityData.setId(null);
        mapper.insert(entityData);
        if (entityData.getId() != null) {
            Integer charuid = entityData.getId();
            DB.execute("UPDATE zhiliuquanchu SET zhiliushizhang=(TIMESTAMPDIFF(HOUR , ruchangshijian,quanchushijian)+1) WHERE id='" + charuid + "'");

            return findById(entityData.getId());
        } else {
            return R.error("插入错误");
        }
    }

    /**
     * 根据id进行更新滞留劝出数据
     * @param entityData 更新的数据
     * @param post 提交的数据
     * @return 是否处理成功
     */
    public R<Object> update(Zhiliuquanchu entityData, Map post) {
        // 判断是否有填写劝出编号。
        if (StringUtil.isNullOrEmpty(entityData.getQuanchubianhao())) {
            return R.error("请填写劝出编号");
        }

        // 判断是否有填写车辆牌号。
        if (StringUtil.isNullOrEmpty(entityData.getCheliangpaihao())) {
            return R.error("请填写车辆牌号");
        }

        // 判断是否有填写车主姓名。
        if (StringUtil.isNullOrEmpty(entityData.getChezhuxingming())) {
            return R.error("请填写车主姓名");
        }

        // 判断是否有填写车主电话。
        if (StringUtil.isNullOrEmpty(entityData.getChezhudianhua())) {
            return R.error("请填写车主电话");
        }

        // 判断是否有填写车主电话,有则判断是否为手机号码或者座机。
        if (!StringUtil.isNullOrEmpty(entityData.getChezhudianhua())) {
            if (!(Validator.isMatchRegex(PatternPool.TEL, entityData.getChezhudianhua()) || Validator.isMobile(entityData.getChezhudianhua()))) {
                return R.error("请输入正确的车主电话");
            }
        }

        // 判断是否有填写入场时间。
        if (StringUtil.isNullOrEmpty(entityData.getRuchangshijian())) {
            return R.error("请填写入场时间");
        }

        // 判断是否有填写劝出时间。
        if (StringUtil.isNullOrEmpty(entityData.getQuanchushijian())) {
            return R.error("请填写劝出时间");
        }

        mapper.updateById(entityData);

        Integer charuid = entityData.getId();
        DB.execute("UPDATE zhiliuquanchu SET zhiliushizhang=(TIMESTAMPDIFF(HOUR , ruchangshijian,quanchushijian)+1) WHERE id='" + post.get("id") + "'");

        return R.success(mapper.selectById(entityData.getId()));
    }

    /**
     * 根据 id列表 删除
     * @param ids  id 列表值
     * @return 是否成功
     */
    public R<Object> delete(List<Integer> ids) {
        try {
            for (Integer id : ids) {
                delete(id);
            }
            return R.success("操作成功");
        } catch (Exception e) {
            return R.error("操作失败");
        }
    }

    /**
     * 根据 id 删除
     * @param id  id 列表值
     * @return 是否成功
     */
    public R<Object> delete(Integer id) {
        try {
            mapper.deleteById(id);

            return R.success("操作成功");
        } catch (Exception e) {
            return R.error("操作失败");
        }
    }
}
