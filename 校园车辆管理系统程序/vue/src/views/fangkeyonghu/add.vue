<template>
    <div class="views-fangkeyonghu-add">
        <div>
            <el-card class="box-card">
                <template #header>
                    <template v-if="$session.cx == '超级管理员'">
                        <div class="clearfix">
                            <span class="title"> 添加访客用户 </span>
                        </div>
                    </template>

                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item
                        label="账号"
                        prop="zhanghao"
                        required
                        :rules="[{required:true, message:'请填写账号'}, {validator:rule.checkRemote, message:'内容重复了', checktype:'insert', module:'fangkeyonghu', col:'zhanghao', trigger:'blur'}]"
                    >
                        <el-input type="text" placeholder="输入账号" style="width: 450px" v-model="form.zhanghao" />
                    </el-form-item>

                    <el-form-item label="密码" prop="mima" required :rules="[{required:true, message:'请填写密码'}]">
                        <el-input type="password" placeholder="输入密码" style="width: 450px" v-model="form.mima" />
                    </el-form-item>

                    <el-form-item label="姓名" prop="xingming" required :rules="[{required:true, message:'请填写姓名'}]">
                        <el-input type="text" placeholder="输入姓名" style="width: 450px" v-model="form.xingming" />
                    </el-form-item>

                    <el-form-item label="性别" prop="xingbie" required :rules="[{required:true, message:'请填写性别'}]">
                        <el-select v-model="form.xingbie"
                            ><el-option label="男" value="男"></el-option>
                            <el-option label="女" value="女"></el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="联系方式" prop="lianxifangshi" :rules="[{validator:rule.checkPhone, message:'请输入正确手机号码'}]">
                        <el-input type="text" placeholder="输入联系方式" style="width: 450px" v-model="form.lianxifangshi" />
                    </el-form-item>

                    <el-form-item label="个人邮箱" prop="gerenyouxiang" :rules="[{type:'email', message:'请输入正确邮箱地址'}]">
                        <el-input type="text" placeholder="输入个人邮箱" style="width: 450px" v-model="form.gerenyouxiang" />
                    </el-form-item>

                    <el-form-item label="个人简介" prop="gerenjianjie"> <el-input type="textarea" v-model="form.gerenjianjie"></el-input> </el-form-item>

                    <el-form-item v-if="btnText">
                        <el-button type="primary" @click="submit">{{ btnText }}</el-button>
                    </el-form-item>
                </el-form></el-card
            >
        </div>
    </div>
</template>

<script setup>
    import http from "@/utils/ajax/http";
    import DB from "@/utils/db";
    import rule from "@/utils/rule";
    import router from "@/router";

    import { ref, reactive, computed } from "vue";
    import { useRoute } from "vue-router";
    import { session } from "@/utils/utils";
    import { ElMessage, ElMessageBox } from "element-plus";
    import { useFangkeyonghuCreateForm, canFangkeyonghuInsert } from "@/module";
    import { extend } from "vue-design-plugin";

    const route = useRoute();
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
    const { form } = useFangkeyonghuCreateForm();
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);
    var submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canFangkeyonghuInsert(form).then(
                (res) => {
                    loading.value = false;
                    if (res.code == 0) {
                        emit("success", res.data);
                        if (props.isHouxu) {
                            ElMessage.success("添加成功");
                            formModel.value.resetFields();
                        }
                    } else {
                        ElMessageBox.alert(res.msg);
                    }
                },
                (err) => {
                    loading.value = false;
                    ElMessageBox.alert(err.message);
                }
            );
        });
    };
</script>

<style scoped lang="scss">
    .views-fangkeyonghu-add {
    }
</style>
