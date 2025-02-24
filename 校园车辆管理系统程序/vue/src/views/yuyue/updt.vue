<template>
    <div class="views-yuyue-updt">
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

                    <el-form-item label="预约编号" prop="yuyuebianhao" :rules="[{required:true, message:'请填写预约编号'}]">
                        <el-input type="text" placeholder="输入预约编号" style="width: 450px" v-model="form.yuyuebianhao" />
                    </el-form-item>

                    <el-form-item label="预约时间" prop="yuyueshijian" required :rules="[{required:true, message:'请填写预约时间'}]">
                        <el-time-picker v-model="form.yuyueshijian" value-format="HH:mm" placeholder="选择时间"> </el-time-picker>
                    </el-form-item>

                    <el-form-item label="车牌号" prop="chepaihao" required :rules="[{required:true, message:'请填写车牌号'}]">
                        <el-input type="text" placeholder="输入车牌号" style="width: 450px" v-model="form.chepaihao" />
                    </el-form-item>

                    <el-form-item
                        label="身份证号"
                        prop="shenfenzhenghao"
                        required
                        :rules="[{required:true, message:'请填写身份证号'}, {validator:rule.checkCard, message:'请输入有效身份证号码'}]"
                    >
                        <el-input type="text" placeholder="输入身份证号" style="width: 450px" v-model="form.shenfenzhenghao" />
                    </el-form-item>

                    <el-form-item
                        label="手机号"
                        prop="shoujihao"
                        required
                        :rules="[{required:true, message:'请填写手机号'}, {validator:rule.checkPhone, message:'请输入正确手机号码'}]"
                    >
                        <el-input type="text" placeholder="输入手机号" style="width: 450px" v-model="form.shoujihao" />
                    </el-form-item>

                    <el-form-item label="姓名" prop="xingming" required :rules="[{required:true, message:'请填写姓名'}]">
                        <el-input type="text" placeholder="输入姓名" style="width: 450px" v-model="form.xingming" />
                    </el-form-item>

                    <el-form-item label="其他备注" prop="qitabeizhu"> <el-input type="textarea" v-model="form.qitabeizhu"></el-input> </el-form-item>

                    <el-form-item label="预约访客" prop="yuyuefangke"> <el-input v-model="form.yuyuefangke" readonly style="width: 250px"></el-input> </el-form-item>

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

    import { ref, reactive, computed, watch } from "vue";
    import { useRoute } from "vue-router";
    import { session } from "@/utils/utils";
    import { ElMessage, ElMessageBox } from "element-plus";
    import { useYuyueFindById, canYuyueFindById, canYuyueUpdate, canShengyucheweiFindById } from "@/module";
    import { extend } from "@/utils/extend";

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
    const form = useYuyueFindById(props.id);
    const emit = defineEmits(["success"]);
    const formModel = ref();
    const loading = ref(false);

    const submit = () => {
        formModel.value.validate().then((res) => {
            if (loading.value) return;
            loading.value = true;
            canYuyueUpdate(form).then(
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

    const readMap = reactive({});
    watch(
        () => form.shengyucheweiid,
        (id) => {
            canShengyucheweiFindById(id).then((res) => {
                extend(readMap, res);
            });
        }
    );
</script>

<style scoped lang="scss">
    .views-yuyue-updt {
    }
</style>
