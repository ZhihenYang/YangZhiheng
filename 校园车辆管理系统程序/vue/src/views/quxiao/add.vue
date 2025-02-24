<template>
    <div class="views-quxiao-add">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 添加 </span>
                    </div>
                </template>

                <el-form :model="form" ref="formModel" label-width="140px" status-icon validate-on-rule-change>
                    <el-form-item v-if="isRead" label="编号" prop="bianhao"> {{ form.bianhao }} </el-form-item>

                    <el-form-item v-if="isRead" label="名称" prop="mingcheng"> {{ form.mingcheng }} </el-form-item>

                    <el-form-item v-if="isRead" label="区域" prop="quyu"> {{ form.quyu }} </el-form-item>

                    <el-form-item v-if="isRead" label="位置" prop="weizhi"> {{ form.weizhi }} </el-form-item>

                    <el-form-item v-if="isRead" label="日期" prop="riqi"> {{ form.riqi }} </el-form-item>

                    <el-form-item v-if="isRead" label="预约编号" prop="yuyuebianhao"> {{ form.yuyuebianhao }} </el-form-item>

                    <el-form-item v-if="isRead" label="预约时间" prop="yuyueshijian"> {{ form.yuyueshijian }} </el-form-item>

                    <el-form-item v-if="isRead" label="车牌号" prop="chepaihao"> {{ form.chepaihao }} </el-form-item>

                    <el-form-item v-if="isRead" label="预约访客" prop="yuyuefangke"> {{ form.yuyuefangke }} </el-form-item>

                    <el-form-item label="取消原因" prop="quxiaoyuanyin"> <el-input type="textarea" v-model="form.quxiaoyuanyin"></el-input> </el-form-item>

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
    import { useQuxiaoCreateForm, canQuxiaoInsert } from "@/module";

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
    const { form, readMap } = useQuxiaoCreateForm(props.id);
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);
    var submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canQuxiaoInsert(form).then(
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
    .views-quxiao-add {
    }
</style>
