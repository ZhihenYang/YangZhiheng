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
import com.spboot.app.mapper.XiaoneirenyuanMapper;
import com.spboot.app.pojo.Xiaoneirenyuan;
import com.spboot.app.utils.*;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class XiaoneirenyuanService {

    // 获取数据库操作类mapper
    @Resource
    private XiaoneirenyuanMapper mapper;

    // 获取密码加密类
    @Resource
    private PasswordEncoder pwdEncoder;

    /**
     * 将数据转换成Session对象
     */
    public Session toSession(Xiaoneirenyuan user) {
        // 创建Session 对象
        Session session = new Session();
        // 设置相应数据进session 对象
        session.setId(user.getId());
        session.setUsername(user.getGonghao());
        session.setTable("xiaoneirenyuan");
        session.setRoles("校内人员");
        session.setCx(session.getRoles());

        session.setObject(BeanUtil.beanToMap(user));
        return session;
    }

    /**
     * 校内人员进行登录
     * @param username 用户名
     * @param pwd      密码
     * @return 校内人员对象实体类
     */
    public Xiaoneirenyuan login(String username, String pwd) {
        Xiaoneirenyuan row = findByGonghao(username);

        // row为null的则是没有账号匹配成功
        if (row == null) {
            return null;
        }

        // 新建密码匹配类进行密码匹配，是否正确
        if (!pwdEncoder.matches(pwd, row.getMima())) {
            return null;
        }
        return row;
    }

    /**
     * 修改密码
     * @param id 校内人员id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @return 处理是否成功
     */
    public R<Object> editPassword(int id, String oldPassword, String newPassword) {
        String encodePassword = pwdEncoder.encode(newPassword);
        Xiaoneirenyuan admins = mapper.selectById(id);
        if (!pwdEncoder.matches(oldPassword, admins.getMima())) {
            return R.error("原密码不正确，请重新输入");
        }
        admins.setMima(encodePassword);
        mapper.updateById(admins);
        return R.ok();
    }

    /**
     *   根据Gonghao字段参数获取一行数据
     */
    public Xiaoneirenyuan findByGonghao(String username) {
        // 新建校内人员模块实体类Xiaoneirenyuan
        Xiaoneirenyuan pojo = new Xiaoneirenyuan();
        // 设置参数
        pojo.setGonghao(username);
        // 根据实体类新建QueryWrapper查询条件类
        QueryWrapper<Xiaoneirenyuan> queryWrapper = Wrappers.query(pojo);
        Xiaoneirenyuan row = mapper.selectOne(queryWrapper);
        return row;
    }

    /**
     *   根据Gonghao字段参数获取一行数据，并不包含某uid 参数得行
     */
    public Xiaoneirenyuan findByGonghao(String username, Integer uid) {
        // 新建校内人员模块实体类Xiaoneirenyuan
        Xiaoneirenyuan pojo = new Xiaoneirenyuan();
        // 设置参数
        pojo.setGonghao(username);
        // 根据实体类新建QueryWrapper查询条件类
        QueryWrapper<Xiaoneirenyuan> queryWrapper = Wrappers.query(pojo);
        // 设置参数 id != uid变量
        queryWrapper.ne("id", uid);
        // 根据queryWrapper 查询
        Xiaoneirenyuan row = mapper.selectOne(queryWrapper);
        return row;
    }

    /**
     *  根据id 获取一行数据
     */
    public R<Xiaoneirenyuan> findById(Integer id) {
        return R.success(mapper.selectById(id));
    }

    /**
     *  根据Wrapper 对象进行数据筛选
     */
    public R<List<Xiaoneirenyuan>> selectAll(Wrapper<Xiaoneirenyuan> query) {
        return R.success(mapper.selectList(query));
    }

    /**
     *  直接筛选所有数据
     */
    public R<List<Xiaoneirenyuan>> selectAll() {
        QueryWrapper<Xiaoneirenyuan> wrapper = Wrappers.query();
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
        QueryWrapper<Xiaoneirenyuan> wrapper = mapToWrapper(map);
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
        QueryWrapper<Xiaoneirenyuan> wrapper = mapToWrapper(map);
        // 设置排序
        wrapper.orderBy(true, selectPage.isAsc(), selectPage.getOrderby());
        // 设置分页数据
        Page page = new Page(selectPage.getPage(), selectPage.getPagesize());
        return selectPages(wrapper, page);
    }

    /**
     *   将提交的参数转换成 mybatisplus 的QueryWrapper 筛选数据对象
     */
    public QueryWrapper<Xiaoneirenyuan> mapToWrapper(Map<String, Object> map) {
        // 创建 QueryWrapper 对象
        QueryWrapper<Xiaoneirenyuan> wrapper = Wrappers.query();

        String where = " 1=1 ";
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句

        if (!StringUtil.isNullOrEmpty(map.get("gonghao"))) {
            wrapper.like("gonghao", map.get("gonghao"));
        }

        if (map.containsKey("session_name")) {
            wrapper.eq(map.get("session_name").toString(), SessionFactory.getUsername());
        }

        wrapper.apply(where);
        return wrapper;
    }

    public R selectPages(QueryWrapper<Xiaoneirenyuan> wrapper, IPage page) {
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
    public R insert(Xiaoneirenyuan entityData, Map post) {
        // 判断是否有填写工号。
        if (StringUtil.isNullOrEmpty(entityData.getGonghao())) {
            return R.error("请填写工号");
        }

        // 判断是否有填写工号,有则判断是否在数据中已经存在，存在则报错。
        if (findByGonghao(entityData.getGonghao()) != null) {
            return R.error("工号已经存在");
        }

        // 判断是否有填写密码。
        if (StringUtil.isNullOrEmpty(entityData.getMima())) {
            return R.error("请填写密码");
        }

        // 判断是否有填写姓名。
        if (StringUtil.isNullOrEmpty(entityData.getXingming())) {
            return R.error("请填写姓名");
        }

        // 判断是否有填写性别。
        if (StringUtil.isNullOrEmpty(entityData.getXingbie())) {
            return R.error("请填写性别");
        }

        // 判断是否有填写联系方式。
        if (StringUtil.isNullOrEmpty(entityData.getLianxifangshi())) {
            return R.error("请填写联系方式");
        }

        // 判断是否有填写联系方式,有则判断是否为手机号码或者座机。
        if (!StringUtil.isNullOrEmpty(entityData.getLianxifangshi())) {
            if (!(Validator.isMatchRegex(PatternPool.TEL, entityData.getLianxifangshi()) || Validator.isMobile(entityData.getLianxifangshi()))) {
                return R.error("请输入正确的联系方式");
            }
        }

        // 判断是否有填写邮箱,有则判断是否为email格式。
        if (!StringUtil.isNullOrEmpty(entityData.getYouxiang()) && !Validator.isEmail(entityData.getYouxiang())) {
            return R.error("请输入正确的邮箱");
        }

        // 判断是否有填写职称。
        if (StringUtil.isNullOrEmpty(entityData.getZhicheng())) {
            return R.error("请填写职称");
        }

        Info.handlerNullEntity(entityData);

        // 对密码字段进行加密操作
        String pwd = pwdEncoder.encode(entityData.getMima());
        entityData.setMima(pwd);

        entityData.setId(null);
        mapper.insert(entityData);
        if (entityData.getId() != null) {
            return findById(entityData.getId());
        } else {
            return R.error("插入错误");
        }
    }

    /**
     * 根据id进行更新校内人员数据
     * @param entityData 更新的数据
     * @param post 提交的数据
     * @return 是否处理成功
     */
    public R<Object> update(Xiaoneirenyuan entityData, Map post) {
        // 判断是否有填写工号。
        if (StringUtil.isNullOrEmpty(entityData.getGonghao())) {
            return R.error("请填写工号");
        }

        // 判断是否有填写工号,有则判断是否在数据中已经存在，存在则报错。
        if (findByGonghao(entityData.getGonghao(), entityData.getId()) != null) {
            return R.error("工号已经存在");
        }
        // 判断是否有填写姓名。
        if (StringUtil.isNullOrEmpty(entityData.getXingming())) {
            return R.error("请填写姓名");
        }

        // 判断是否有填写性别。
        if (StringUtil.isNullOrEmpty(entityData.getXingbie())) {
            return R.error("请填写性别");
        }

        // 判断是否有填写联系方式。
        if (StringUtil.isNullOrEmpty(entityData.getLianxifangshi())) {
            return R.error("请填写联系方式");
        }

        // 判断是否有填写联系方式,有则判断是否为手机号码或者座机。
        if (!StringUtil.isNullOrEmpty(entityData.getLianxifangshi())) {
            if (!(Validator.isMatchRegex(PatternPool.TEL, entityData.getLianxifangshi()) || Validator.isMobile(entityData.getLianxifangshi()))) {
                return R.error("请输入正确的联系方式");
            }
        }

        // 判断是否有填写邮箱,有则判断是否为email格式。
        if (!StringUtil.isNullOrEmpty(entityData.getYouxiang()) && !Validator.isEmail(entityData.getYouxiang())) {
            return R.error("请输入正确的邮箱");
        }

        // 判断是否有填写职称。
        if (StringUtil.isNullOrEmpty(entityData.getZhicheng())) {
            return R.error("请填写职称");
        }

        String currentPwd = entityData.getMima();
        if (!StringUtil.isNullOrEmpty(currentPwd)) {
            // 不等于空，设置密码
            String pwd = pwdEncoder.encode(currentPwd);
            entityData.setMima(pwd);
        } else {
            Xiaoneirenyuan old = mapper.selectById(entityData.getId());
            entityData.setMima(old.getMima());
        }

        mapper.updateById(entityData);

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
