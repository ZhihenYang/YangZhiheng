<template>
    <div class="views-xiaoneicheliang-detail">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 详情 </span>
                    </div>
                </template>

                <div id="printdetail">
                    <el-descriptions class="margin-top" :column="3" border>
                        <el-descriptions-item label="车辆编号"> {{ map.cheliangbianhao }} </el-descriptions-item>
                        <el-descriptions-item label="车辆名称"> {{ map.cheliangmingcheng }} </el-descriptions-item>
                        <el-descriptions-item label="车辆品牌"> {{ map.cheliangpinpai }} </el-descriptions-item>
                        <el-descriptions-item label="车辆颜色"> {{ map.cheliangyanse }} </el-descriptions-item>
                        <el-descriptions-item label="车辆牌号"> {{ map.cheliangpaihao }} </el-descriptions-item>
                    </el-descriptions>

                    <el-descriptions direction="vertical" class="margin-top" :column="1" border>
                        <el-descriptions-item label="车辆简介"> {{ map.cheliangjianjie }} </el-descriptions-item>
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
    import { useXiaoneicheliangFindById, canXiaoneicheliangFindById } from "@/module";

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
    const map = useXiaoneicheliangFindById(props.id);
    // 当url参数id变更时，自动更新map中的数据
    watch(
        () => props.id,
        (id) => {
            canXiaoneicheliangFindById(id).then((res) => {
                extend(map, res);
            });
        }
    );
    // end 获取详情页面的一行数据
</script>

<style scoped lang="scss">
    .views-xiaoneicheliang-detail {
    }
</style>
