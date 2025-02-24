<template>
    <div class="views-xiaoneicheliang-add">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item
                        label="车辆编号"
                        prop="cheliangbianhao"
                        required
                        :rules="[{required:true, message:'请填写车辆编号'}, {validator:rule.checkRemote, message:'内容重复了', checktype:'insert', module:'xiaoneicheliang', col:'cheliangbianhao', trigger:'blur'}]"
                    >
                        <el-input type="text" placeholder="输入车辆编号" style="width: 450px" v-model="form.cheliangbianhao" />
                    </el-form-item>

                    <el-form-item label="车辆名称" prop="cheliangmingcheng" required :rules="[{required:true, message:'请填写车辆名称'}]">
                        <el-input type="text" placeholder="输入车辆名称" style="width: 450px" v-model="form.cheliangmingcheng" />
                    </el-form-item>

                    <el-form-item label="车辆品牌" prop="cheliangpinpai" required :rules="[{required:true, message:'请填写车辆品牌'}]">
                        <el-input type="text" placeholder="输入车辆品牌" style="width: 450px" v-model="form.cheliangpinpai" />
                    </el-form-item>

                    <el-form-item label="车辆颜色" prop="cheliangyanse" required :rules="[{required:true, message:'请填写车辆颜色'}]">
                        <el-input type="text" placeholder="输入车辆颜色" style="width: 450px" v-model="form.cheliangyanse" />
                    </el-form-item>

                    <el-form-item
                        label="车辆牌号"
                        prop="cheliangpaihao"
                        required
                        :rules="[{required:true, message:'请填写车辆牌号'}, {validator:rule.checkRemote, message:'内容重复了', checktype:'insert', module:'xiaoneicheliang', col:'cheliangpaihao', trigger:'blur'}]"
                    >
                        <el-input type="text" placeholder="输入车辆牌号" style="width: 450px" v-model="form.cheliangpaihao" />
                    </el-form-item>

                    <el-form-item label="车辆简介" prop="cheliangjianjie"> <el-input type="textarea" v-model="form.cheliangjianjie"></el-input> </el-form-item>

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
    import { useXiaoneicheliangCreateForm, canXiaoneicheliangInsert } from "@/module";
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
    const { form } = useXiaoneicheliangCreateForm();
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);
    var submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canXiaoneicheliangInsert(form).then(
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
    .views-xiaoneicheliang-add {
    }
</style>
