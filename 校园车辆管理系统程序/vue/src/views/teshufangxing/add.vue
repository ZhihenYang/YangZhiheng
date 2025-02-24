<template>
    <div class="views-teshufangxing-add">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item label="放行编号" prop="fangxingbianhao" :rules="[{required:true, message:'请填写放行编号'}]">
                        <el-input type="text" placeholder="输入放行编号" style="width: 450px" v-model="form.fangxingbianhao" />
                    </el-form-item>

                    <el-form-item label="放行时间" prop="fangxingshijian" :rules="[{required:true, message:'请填写放行时间'}]">
                        <el-date-picker v-model="form.fangxingshijian" type="datetime" :editable="false" value-format="YYYY-MM-DD HH:mm:ss" placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>

                    <el-form-item label="车辆牌号" prop="cheliangpaihao" required :rules="[{required:true, message:'请填写车辆牌号'}]">
                        <el-input type="text" placeholder="输入车辆牌号" style="width: 450px" v-model="form.cheliangpaihao" />
                    </el-form-item>

                    <el-form-item label="车主电话" prop="chezhudianhua" required :rules="[{required:true, message:'请填写车主电话'}]">
                        <el-input type="text" placeholder="输入车主电话" style="width: 450px" v-model="form.chezhudianhua" />
                    </el-form-item>

                    <el-form-item label="车主姓名" prop="chezhuxingming" required :rules="[{required:true, message:'请填写车主姓名'}]">
                        <el-input type="text" placeholder="输入车主姓名" style="width: 450px" v-model="form.chezhuxingming" />
                    </el-form-item>

                    <el-form-item
                        label="车主身份证号"
                        prop="chezhushenfenzhenghao"
                        required
                        :rules="[{required:true, message:'请填写车主身份证号'}, {validator:rule.checkCard, message:'请输入有效身份证号码'}]"
                    >
                        <el-input type="text" placeholder="输入车主身份证号" style="width: 450px" v-model="form.chezhushenfenzhenghao" />
                    </el-form-item>

                    <el-form-item label="放行说明" prop="fangxingshuoming"> <el-input type="textarea" v-model="form.fangxingshuoming"></el-input> </el-form-item>

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
    import { useTeshufangxingCreateForm, canTeshufangxingInsert } from "@/module";
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
    const { form } = useTeshufangxingCreateForm();
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);
    var submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canTeshufangxingInsert(form).then(
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
    .views-teshufangxing-add {
    }
</style>
