<template>
    <div class="views-teshufangxing-list">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 特殊放行查询 </span>
                    </div>
                </template>

                <div class="form-search">
                    <el-form @submit.prevent.stop :inline="true" size="small">
                        <el-form-item label="放行编号">
                            <el-input v-model="search.fangxingbianhao"></el-input>
                        </el-form-item>
                        <el-form-item label="车辆牌号">
                            <el-input v-model="search.cheliangpaihao"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="searchSubmit" icon="el-icon-search">查询</el-button>
                        </el-form-item>
                    </el-form>
                </div>

                <el-table border :data="lists" style="width: 100%" @sort-change="sortChange" highlight-current-row>
                    <el-table-column type="index" label="#"></el-table-column>
                    <!-- 序号 -->

                    <el-table-column prop="fangxingbianhao" label="放行编号" width="130">
                        <template #default="{row}"> {{ row.fangxingbianhao }} </template>
                    </el-table-column>
                    <el-table-column prop="fangxingshijian" label="放行时间" width="120">
                        <template #default="{row}"> {{ row.fangxingshijian }} </template>
                    </el-table-column>
                    <el-table-column prop="cheliangpaihao" label="车辆牌号" width="130">
                        <template #default="{row}"> {{ row.cheliangpaihao }} </template>
                    </el-table-column>
                    <el-table-column prop="chezhudianhua" label="车主电话" width="130">
                        <template #default="{row}"> {{ row.chezhudianhua }} </template>
                    </el-table-column>
                    <el-table-column prop="chezhuxingming" label="车主姓名" width="130">
                        <template #default="{row}"> {{ row.chezhuxingming }} </template>
                    </el-table-column>
                    <el-table-column prop="chezhushenfenzhenghao" label="车主身份证号" width="130">
                        <template #default="{row}"> {{ row.chezhushenfenzhenghao }} </template>
                    </el-table-column>
                    <el-table-column prop="fangxingshuoming" label="放行说明">
                        <template #default="{row}"> {{ row.fangxingshuoming }} </template>
                    </el-table-column>
                    <el-table-column prop="jingshouren" label="经手人" width="120">
                        <template #default="{row}"> {{ row.jingshouren }} </template>
                    </el-table-column>

                    <el-table-column label="操作" fixed="right" width="220">
                        <template #default="{row}">
                            <el-button-group>
                                <el-tooltip effect="dark" content="详情" placement="top-start"
                                    ><el-button type="info" :icon="InfoFilled" size="small" @click="$router.push('/admin/teshufangxing/detail?id='+row.id)">详情</el-button>
                                </el-tooltip>

                            </el-button-group>
                        </template>
                    </el-table-column>
                </el-table>
                <div class="e-pages" style="margin-top: 10px; text-align: center">
                    <el-pagination
                        @current-change="loadList"
                        :page-sizes="[12, 24, 36, 48,60]"
                        v-model:current-page="search.page"
                        v-model:page-size="search.pagesize"
                        @size-change="sizeChange"
                        layout="total, sizes, prev, pager, next"
                        :total="totalCount"
                    >
                    </el-pagination>
                </div>
            </el-card>
        </div>
    </div>
</template>

<script setup>
    import http from "@/utils/ajax/http";
    import DB from "@/utils/db";
    import router from "@/router";

    import { ref, reactive, watch, unref, onBeforeMount } from "vue";
    import { useRoute } from "vue-router";
    import { session } from "@/utils/utils";
    import { canTeshufangxingSelect, useTeshufangxingSelect, canTeshufangxingDelete } from "@/module";
    import { extend } from "@/utils/extend";
    import { ElMessageBox, ElMessage } from "element-plus";
    import { InfoFilled, Edit, Delete } from "@element-plus/icons-vue";

    const route = useRoute();
    const search = reactive({
        fangxingbianhao: "",
        cheliangpaihao: "",
        page: 1, // 当前页
        pagesize: 12, // 每页行数
        orderby: "id", // 排序字段
        sort: "desc", // 排序类型
    });
    extend(search, route.query);
    // 链接参数变化时更新这些内容
    watch(
        () => route.query,
        () => {
            extend(search, route.query);
            loadList(1);
        },
        { deep: true }
    );

    // 总行数
    const totalCount = ref(0);
    // 列表数据
    const lists = ref([]);
    // 加载状态
    const loading = ref(false);

    // 排序操作
    const sortChange = (e) => {
        console.log(e);
        if (e.order == null) {
            search.orderby = "id";
            search.sort = "desc";
        } else {
            search.orderby = e.prop;
            search.sort = e.order == "ascending" ? "asc" : "desc";
        }
        loadList(1);
    };
    // 设置页数多少
    const sizeChange = (e) => {
        search.pagesize = e;
        loadList(1);
    };

    const deleteItems = (ids) => {
        return new Promise((resolve, reject) => {
            ElMessageBox.confirm("确定删除？")
                .then((res) => {
                    canTeshufangxingDelete(ids).then((res) => {
                        if (res.code == 0) {
                            ElMessage.success("删除成功");
                            loadList(search.page);
                            resolve(res.data);
                        } else {
                            ElMessage.error(res.msg);
                        }
                    });
                })
                .catch((err) => {
                    reject(err);
                });
        });
    };

    // 加载特殊放行列表方法
    const loadList = (page) => {
        // 加载
        if (unref(loading)) return;
        loading.value = true;
        search.page = page;

        http.post("/api/teshufangxing/selectJingshouren", search).then(
            (res) => {
                loading.value = false;
                if (res.code == 0) {
                    var data = res.data;
                    lists.value = data.lists.records;
                    totalCount.value = data.lists.total;
                }
            },
            (err) => {
                ElMessage.error(err.message);
            }
        );
    };

    onBeforeMount(() => {
        loadList(1);
    });
    const searchSubmit = () => {
        loadList(1);
    };
</script>

<style scoped lang="scss">
    .views-teshufangxing-list {
    }
</style>
