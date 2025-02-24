<template>
    <div class="views-admins-add">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加管理员 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item label="权限" prop="cx" required :rules="[{required:true, message:'请填写权限'}]">
                        <el-select v-model="form.cx"
                            >
                            <el-option label="管理员" value="管理员"></el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item
                        label="帐号"
                        prop="username"
                        required
                        :rules="[{required:true, message:'请填写帐号'}, {validator:rule.checkRemote, message:'内容重复了', checktype:'insert', module:'admins', col:'username', trigger:'blur'}]"
                    >
                        <el-input type="text" placeholder="输入帐号" style="width: 450px" v-model="form.username" />
                    </el-form-item>

                    <el-form-item label="密码" prop="pwd" required :rules="[{required:true, message:'请填写密码'}]">
                        <el-input type="password" placeholder="输入密码" style="width: 450px" v-model="form.pwd" />
                    </el-form-item>

                    <el-form-item label="姓名" prop="xingming"> <el-input type="text" placeholder="输入姓名" style="width: 450px" v-model="form.xingming" /> </el-form-item>

                    <el-form-item label="性别" prop="xingbie" required :rules="[{required:true, message:'请填写性别'}]">
                        <el-select v-model="form.xingbie"
                            ><el-option label="男" value="男"></el-option>
                            <el-option label="女" value="女"></el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="电话" prop="dianhua" :rules="[{validator:rule.checkPhone, message:'请输入正确手机号码'}]">
                        <el-input type="text" placeholder="输入电话" style="width: 450px" v-model="form.dianhua" />
                    </el-form-item>

                    <el-form-item label="备注" prop="beizhu"> <el-input type="textarea" v-model="form.beizhu"></el-input> </el-form-item>

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
    import { useAdminsCreateForm, canAdminsInsert } from "@/module";
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
    const { form } = useAdminsCreateForm();
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);
    var submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canAdminsInsert(form).then(
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
    .views-admins-add {
    }
</style>
