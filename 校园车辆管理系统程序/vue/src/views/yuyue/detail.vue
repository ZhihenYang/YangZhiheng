<template>
    <div class="views-yuyue-detail">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 详情 </span>
                    </div>
                </template>

                <div id="printdetail">
                    <el-descriptions class="margin-top" :column="3" border>
                        <el-descriptions-item label="编号"> {{ map.bianhao }} </el-descriptions-item>
                        <el-descriptions-item label="名称"> {{ map.mingcheng }} </el-descriptions-item>
                        <el-descriptions-item label="区域"> {{ map.quyu }} </el-descriptions-item>
                        <el-descriptions-item label="位置"> {{ map.weizhi }} </el-descriptions-item>
                        <el-descriptions-item label="日期"> {{ map.riqi }} </el-descriptions-item>
                        <el-descriptions-item label="预约编号"> {{ map.yuyuebianhao }} </el-descriptions-item>
                        <el-descriptions-item label="预约时间"> {{ map.yuyueshijian }} </el-descriptions-item>
                        <el-descriptions-item label="车牌号"> {{ map.chepaihao }} </el-descriptions-item>
                        <el-descriptions-item label="身份证号"> {{ map.shenfenzhenghao }} </el-descriptions-item>
                        <el-descriptions-item label="手机号"> {{ map.shoujihao }} </el-descriptions-item>
                        <el-descriptions-item label="姓名"> {{ map.xingming }} </el-descriptions-item>
                        <el-descriptions-item label="预约访客"> {{ map.yuyuefangke }} </el-descriptions-item>
                        <el-descriptions-item label="状态"> {{ map.zhuangtai }} </el-descriptions-item>
                        <el-descriptions-item label="提交时间"> {{ map.addtime }} </el-descriptions-item>
                    </el-descriptions>

                    <el-descriptions direction="vertical" class="margin-top" :column="1" border>
                        <el-descriptions-item label="其他备注"> {{ map.qitabeizhu }} </el-descriptions-item>
                    </el-descriptions>
                </div>
                <div class="no-print" v-if="isShowBtn">
                    <el-button @click="$router.go(-1)">返回</el-button>
                    <el-button @click="$print('#printdetail')">打印</el-button>
                </div>
            </el-card>
        </div>
    </div>
</template>

<script setup>
    import http from "@/utils/ajax/http";
    import DB from "@/utils/db";

    import { ref, reactive, watch, computed } from "vue";
    import { useRoute } from "vue-router";
    import { session } from "@/utils/utils";
    import { extend } from "@/utils/extend";
    import { useYuyueFindById, canYuyueFindById } from "@/module";

    const route = useRoute();
    const props = defineProps({
        id: {
            type: [Number, String],
        },
        isShowBtn: {
            type: Boolean,
            default: true,
        },
    });

    // 获取详情页面的一行数据,当url参数id变更时，自动
    const map = useYuyueFindById(props.id);
    // 当url参数id变更时，自动更新map中的数据
    watch(
        () => props.id,
        (id) => {
            canYuyueFindById(id).then((res) => {
                extend(map, res);
            });
        }
    );
    // end 获取详情页面的一行数据
</script>

<style scoped lang="scss">
    .views-yuyue-detail {
    }
</style>
