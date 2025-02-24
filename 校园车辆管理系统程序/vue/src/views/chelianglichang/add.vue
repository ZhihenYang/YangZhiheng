<template>
    <div class="views-chelianglichang-add">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item v-if="isRead" label="入场编号" prop="ruchangbianhao"> {{ form.ruchangbianhao }} </el-form-item>

                    <el-form-item v-if="isRead" label="入场时间" prop="ruchangshijian"> {{ form.ruchangshijian }} </el-form-item>

                    <el-form-item v-if="isRead" label="车辆牌号" prop="cheliangpaihao"> {{ form.cheliangpaihao }} </el-form-item>

                    <el-form-item v-if="isRead" label="车主电话" prop="chezhudianhua"> {{ form.chezhudianhua }} </el-form-item>

                    <el-form-item label="离场时间" prop="lichangshijian" :rules="[{required:true, message:'请填写离场时间'}]">
                        <el-date-picker v-model="form.lichangshijian" type="datetime" :editable="false" value-format="YYYY-MM-DD HH:mm:ss" placeholder="选择日期"> </el-date-picker>
                    </el-form-item>

                    <el-form-item label="离场备注" prop="lichangbeizhu"> <el-input type="textarea" v-model="form.lichangbeizhu"></el-input> </el-form-item>

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
    import { useChelianglichangCreateForm, canChelianglichangInsert } from "@/module";

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
    const { form, readMap } = useChelianglichangCreateForm(props.id);
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);
    var submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canChelianglichangInsert(form).then(
                (res) => {
                    loading.value = false;
                    if (res.code == 0) {
                        emit("success", res.data);
                        if (props.isHouxu) {
                            ElMessage.success("添加成功");
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
    .views-chelianglichang-add {
    }
</style>
