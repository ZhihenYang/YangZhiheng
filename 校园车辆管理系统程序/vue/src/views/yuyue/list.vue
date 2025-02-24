<template>
    <div class="views-yuyue-list">
        <div>
            <el-card class="box-card">
                <template #header>
                    <div class="clearfix">
                        <span class="title"> 查询 </span>
                    </div>
                </template>

                <div class="form-search">
                    <el-form @submit.prevent.stop :inline="true" size="small">
                        <el-form-item label="名称">
                            <el-input v-model="search.mingcheng"></el-input>
                        </el-form-item>
                        <el-form-item label="区域">
                            <el-select v-model="search.quyu"
                                ><el-option label="请选择" value=""></el-option><el-option label="A" value="A"></el-option>
                                <el-option label="B" value="B"></el-option>
                                <el-option label="C" value="C"></el-option>
                                <el-option label="D" value="D"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="日期">
                            <div style="display: flex">
                                <el-date-picker v-model="search.riqi_start" style="width: 120px" type="date" value-format="YYYY-MM-DD" placeholder="选择开始日期" />
                                -
                                <el-date-picker v-model="search.riqi_end" style="width: 120px" type="date" value-format="YYYY-MM-DD" placeholder="选择结束日期" />
                            </div>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" @click="searchSubmit" icon="el-icon-search">查询</el-button>
                        </el-form-item>
                    </el-form>
                </div>

                <el-table border :data="lists" style="width: 100%" @sort-change="sortChange" highlight-current-row>
                    <el-table-column type="index" label="#"></el-table-column>
                    <!-- 序号 -->

                    <el-table-column prop="mingcheng" label="名称">
                        <template #default="{row}"> {{ row.mingcheng }} </template>
                    </el-table-column>
                    <el-table-column prop="quyu" label="区域" width="120">
                        <template #default="{row}"> {{ row.quyu }} </template>
                    </el-table-column>
                    <el-table-column prop="weizhi" label="位置" width="130">
                        <template #default="{row}"> {{ row.weizhi }} </template>
                    </el-table-column>
                    <el-table-column prop="riqi" label="日期" width="120">
                        <template #default="{row}"> {{ row.riqi }} </template>
                    </el-table-column>
                    <el-table-column prop="yuyuebianhao" label="预约编号" width="130">
                        <template #default="{row}"> {{ row.yuyuebianhao }} </template>
                    </el-table-column>
                    <el-table-column prop="yuyueshijian" label="预约时间" width="120">
                        <template #default="{row}"> {{ row.yuyueshijian }} </template>
                    </el-table-column>
                    <el-table-column prop="chepaihao" label="车牌号" width="130">
                        <template #default="{row}"> {{ row.chepaihao }} </template>
                    </el-table-column>
                    <el-table-column prop="shenfenzhenghao" label="身份证号" width="130">
                        <template #default="{row}"> {{ row.shenfenzhenghao }} </template>
                    </el-table-column>
                    <el-table-column prop="shoujihao" label="手机号" width="130">
                        <template #default="{row}"> {{ row.shoujihao }} </template>
                    </el-table-column>
                    <el-table-column prop="xingming" label="姓名" width="130">
                        <template #default="{row}"> {{ row.xingming }} </template>
                    </el-table-column>
                    <el-table-column prop="qitabeizhu" label="其他备注">
                        <template #default="{row}"> {{ row.qitabeizhu }} </template>
                    </el-table-column>
                    <el-table-column prop="yuyuefangke" label="预约访客" width="120">
                        <template #default="{row}"> {{ row.yuyuefangke }} </template>
                    </el-table-column>
                    <el-table-column prop="zhuangtai" label="状态" width="120">
                        <template #default="{row}"> {{ row.zhuangtai }} </template>
                    </el-table-column>

                    <el-table-column label="操作" fixed="right" width="220">
                        <template #default="{row}">
                            <el-button-group>

                                <el-tooltip effect="dark" content="详情" placement="top-start"
                                    ><el-button type="info" :icon="InfoFilled" size="small" @click="$router.push('/admin/yuyue/detail?id='+row.id)">详情</el-button>
                                </el-tooltip>
                                <el-tooltip effect="dark" content="编辑" placement="top-start"
                                    ><el-button type="success" :icon="Edit" size="small" @click="$router.push('/admin/yuyue/updt?id='+row.id)">编辑</el-button>
                                </el-tooltip>
                                <el-tooltip effect="dark" content="删除" placement="top-start"
                                    ><el-button type="danger" :icon="Delete" size="small" @click="deleteItems(row.id)">删除</el-button>
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
    import { canYuyueSelect, useYuyueSelect, canYuyueDelete } from "@/module";
    import { extend } from "@/utils/extend";
    import { ElMessageBox, ElMessage } from "element-plus";
    import { Plus, Search, InfoFilled, Edit, Delete } from "@element-plus/icons-vue";

    const route = useRoute();
    const search = reactive({
        shengyucheweiid: "",
        mingcheng: "",
        quyu: "",
        riqi_start: "",
        riqi_end: "",
        yuyuebianhao: "",
        yuyueshijian_start: "",
        yuyueshijian_end: "",
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
                    canYuyueDelete(ids).then((res) => {
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

    // 加载预约列表方法
    const loadList = (page) => {
        // 加载
        if (unref(loading)) return;
        loading.value = true;
        search.page = page;

        http.post("/api/yuyue/selectPages", search).then(
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
    .views-yuyue-list {
    }
</style>
