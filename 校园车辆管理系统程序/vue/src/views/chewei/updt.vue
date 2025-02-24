<template>
    <div class="views-chewei-updt">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item label="编号" prop="bianhao" :rules="[{required:true, message:'请填写编号'}]">
                        <el-input type="text" placeholder="输入编号" style="width: 450px" v-model="form.bianhao" />
                    </el-form-item>

                    <el-form-item label="名称" prop="mingcheng" required :rules="[{required:true, message:'请填写名称'}]">
                        <el-input type="text" placeholder="输入名称" style="width: 450px" v-model="form.mingcheng" />
                    </el-form-item>

                    <el-form-item label="区域" prop="quyu" required :rules="[{required:true, message:'请填写区域'}]">
                        <el-select v-model="form.quyu"
                            ><el-option label="A" value="A"></el-option>
                            <el-option label="B" value="B"></el-option>
                            <el-option label="C" value="C"></el-option>
                            <el-option label="D" value="D"></el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="位置" prop="weizhi" required :rules="[{required:true, message:'请填写位置'}]">
                        <el-input type="text" placeholder="输入位置" style="width: 450px" v-model="form.weizhi" />
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
    import { useCheweiFindById, canCheweiFindById, canCheweiUpdate } from "@/module";

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
    const form = useCheweiFindById(props.id);
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);

    const submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canCheweiUpdate(form).then(
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
    .views-chewei-updt {
    }
</style>
