<template>
  <div class="views-chewei-add">
    <div>
      <el-card class="box-card">
        <!-- 卡片头部 -->
        <template #header>
          <div class="clearfix">
            <span class="title"> 添加 </span>
          </div>
        </template>

        <!-- 表单 -->
        <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
          <!-- 编号输入框 -->
          <el-form-item label="编号" prop="bianhao" :rules="[{required:true, message:'请填写编号'}]">
            <el-input type="text" placeholder="输入编号" style="width: 450px" v-model="form.bianhao" />
          </el-form-item>

          <!-- 名称输入框 -->
          <el-form-item label="名称" prop="mingcheng" required :rules="[{required:true, message:'请填写名称'}]">
            <el-input type="text" placeholder="输入名称" style="width: 450px" v-model="form.mingcheng" />
          </el-form-item>

          <!-- 区域选择框 -->
          <el-form-item label="区域" prop="quyu" required :rules="[{required:true, message:'请填写区域'}]">
            <el-select v-model="form.quyu">
              <el-option label="A" value="A"></el-option>
              <el-option label="B" value="B"></el-option>
              <el-option label="C" value="C"></el-option>
              <el-option label="D" value="D"></el-option>
            </el-select>
          </el-form-item>

          <!-- 位置输入框 -->
          <el-form-item label="位置" prop="weizhi" required :rules="[{required:true, message:'请填写位置'}]">
            <el-input type="text" placeholder="输入位置" style="width: 450px" v-model="form.weizhi" />
          </el-form-item>

          <!-- 备注文本区域 -->
          <el-form-item label="备注" prop="beizhu">
            <el-input type="textarea" v-model="form.beizhu"></el-input>
          </el-form-item>

          <!-- 提交按钮，根据父组件传递的btnText属性显示按钮文本 -->
          <el-form-item v-if="btnText">
            <el-button type="primary" @click="submit">{{ btnText }}</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </div>
</template>

<script setup>
import http from "@/utils/ajax/http"; // 导入HTTP请求工具
import DB from "@/utils/db"; // 导入数据库操作工具
import rule from "@/utils/rule"; // 导入规则验证工具
import router from "@/router"; // 导入路由实例

import { ref, reactive, computed } from "vue"; // 导入Vue响应式API
import { useRoute } from "vue-router"; // 导入路由钩子函数
import { session } from "@/utils/utils"; // 导入会话管理工具
import { ElMessage, ElMessageBox } from "element-plus"; // 导入Element Plus的消息和消息框组件
import { useCheweiCreateForm, canCheweiInsert } from "@/module"; // 导入车位创建表单和插入权限检查方法
import { extend } from "vue-design-plugin"; // 导入扩展插件

const route = useRoute(); // 获取当前路由信息
// 定义props属性，默认值为保存、只读模式开启、后续操作开启
const props = defineProps({
  btnText: {
    type: String,
    default: "保存",
  },
  isRead: {
    type: Boolean,
    default: true,
  },
  isHouxu: {
    type: Boolean,
    default: true,
  },
});

// 使用useCheweiCreateForm钩子获取表单数据对象
const { form } = useCheweiCreateForm();
// 定义emit事件，用于通知父组件操作成功
const emit = defineEmits(["success"]);
// 创建一个ref引用指向表单实例
const formModel = ref();
// 加载状态控制变量
const loading = ref(false);

// 提交表单的方法
var submit = () => {
  // 触发表单验证
  formModel.value.validate().then((res) => {
    if (loading.value) return; // 如果正在加载中，则不处理
    loading.value = true; // 设置加载状态为true

    // 检查是否有权限插入新记录
    canCheweiInsert(form).then(
        (res) => {
          loading.value = false; // 插入完成后关闭加载状态
          if (res.code == 0) { // 如果返回码为0表示操作成功
            emit("success", res.data); // 发送成功事件给父组件
            if (props.isHouxu) { // 如果允许后续操作
              ElMessage.success("添加成功"); // 显示成功提示
              formModel.value.resetFields(); // 重置表单字段
            }
          } else {
            ElMessageBox.alert(res.msg); // 显示错误消息
          }
        },
        (err) => {
          loading.value = false; // 错误情况下也关闭加载状态
          ElMessageBox.alert(err.message); // 显示错误消息
        }
    );
  });
};
</script>