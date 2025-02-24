<template>
    <div class="views-fangwenshijian-updt">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item label="开始" prop="kaishi" required :rules="[{required:true, message:'请填写开始'}]">
                        <el-time-picker v-model="form.kaishi" value-format="HH:mm" placeholder="选择时间"> </el-time-picker>
                    </el-form-item>

                    <el-form-item label="截止" prop="jiezhi" required :rules="[{required:true, message:'请填写截止'}]">
                        <el-time-picker v-model="form.jiezhi" value-format="HH:mm" placeholder="选择时间"> </el-time-picker>
                    </el-form-item>

                    <el-form-item label="说明" prop="shuoming"> <el-input type="text" placeholder="输入说明" style="width: 450px" v-model="form.shuoming" /> </el-form-item>

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
    import { useFangwenshijianFindById, canFangwenshijianFindById, canFangwenshijianUpdate } from "@/module";

    const route = useRoute();
    const props = defineProps({
        id: [String, Number],
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
    const form = useFangwenshijianFindById(props.id);
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);

    const submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canFangwenshijianUpdate(form).then(
                (res) => {
                    loading.value = false;
                    if (res.code == 0) {
                        emit("success", res.data);
                        if (props.isHouxu) {
                            ElMessage.success("更新成功");
                            router.go(-1);
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
    .views-fangwenshijian-updt {
    }
</style>
