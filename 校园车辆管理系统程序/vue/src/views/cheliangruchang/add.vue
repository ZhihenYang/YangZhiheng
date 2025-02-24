<template>
    <div class="views-cheliangruchang-add">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item label="入场编号" prop="ruchangbianhao" :rules="[{required:true, message:'请填写入场编号'}]">
                        <el-input type="text" placeholder="输入入场编号" style="width: 450px" v-model="form.ruchangbianhao" />
                    </el-form-item>

                    <el-form-item label="入场时间" prop="ruchangshijian" :rules="[{required:true, message:'请填写入场时间'}]">
                        <el-date-picker v-model="form.ruchangshijian" type="datetime" :editable="false" value-format="YYYY-MM-DD HH:mm:ss" placeholder="选择日期"> </el-date-picker>
                    </el-form-item>

                    <el-form-item label="车辆牌号" prop="cheliangpaihao" required :rules="[{required:true, message:'请填写车辆牌号'}]">
                        <el-input type="text" placeholder="输入车辆牌号" style="width: 450px" v-model="form.cheliangpaihao" />
                    </el-form-item>

                    <el-form-item
                        label="车主电话"
                        prop="chezhudianhua"
                        required
                        :rules="[{required:true, message:'请填写车主电话'}, {validator:rule.checkPhone, message:'请输入正确手机号码'}]"
                    >
                        <el-input type="text" placeholder="输入车主电话" style="width: 450px" v-model="form.chezhudianhua" />
                    </el-form-item>

                    <el-form-item label="入场说明" prop="ruchangshuoming">
                        <el-input type="text" placeholder="输入入场说明" style="width: 450px" v-model="form.ruchangshuoming" />
                    </el-form-item>

                    <el-form-item label="经手人" prop="jingshouren"> <el-input v-model="form.jingshouren" readonly style="width: 250px"></el-input> </el-form-item>

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
    import { useCheliangruchangCreateForm, canCheliangruchangInsert } from "@/module";
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
    const { form } = useCheliangruchangCreateForm();
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);
    var submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canCheliangruchangInsert(form).then(
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
    .views-cheliangruchang-add {
    }
</style>
