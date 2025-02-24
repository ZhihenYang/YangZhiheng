import http from "@/utils/ajax/http";
import { useRoute } from "vue-router";
import { useUserStore } from "@/stores";
import { reactive, ref, unref } from "vue";
import rule from "@/utils/rule";
import { extend, isArray } from "@/utils/extend";
import { ElMessageBox } from "element-plus";
import router from "@/router";

import { canYuyueFindById } from "./yuyue";

/**
 * 响应式的对象数据
 */

export const QuxiaoCreateForm = () => {
    var route = unref(router.currentRoute);
    const userStore = useUserStore();
    const $session = userStore.session;
    if (!route.query) {
        route = useRoute();
    }
    const form = {
        bianhao: "",
        mingcheng: "",
        quyu: "",
        weizhi: "",
        riqi: "",
        yuyuebianhao: "",
        yuyueshijian: "",
        chepaihao: "",
        yuyuefangke: $session.username,
        quxiaoyuanyin: "",
    };

    return form;
};

function exportForm(form, readMap) {
    var autoText = ["yuyueid", "bianhao", "mingcheng", "quyu", "weizhi", "riqi", "yuyuebianhao", "yuyueshijian", "chepaihao", "yuyuefangke"];
    for (var txt of autoText) {
        form[txt] = readMap[txt];
    }
}

/**
 * 异步模式获取数据
 * @param id
 * @param readMap
 * @return {Promise}
 */
export const canQuxiaoCreateForm = (id, readMap) => {
    return new Promise(async (resolve, reject) => {
        var form = QuxiaoCreateForm();
        if (!readMap || !readMap.id) {
            readMap = await canYuyueFindById(id).catch(reject);
        }
        exportForm(form, readMap);
        form.yuyueid = readMap.id;
        resolve({ form, readMap });
    });
};

/**
 * 响应式获取取消 模块的表单字段数据
 * @return {UnwrapNestedRefs<{}>}
 */
export const useQuxiaoCreateForm = (id) => {
    const form = QuxiaoCreateForm();
    const formReactive = reactive(form);

    const readMap = reactive({});
    canYuyueFindById(id).then(
        (map) => {
            exportForm(formReactive, map);
            extend(readMap, map);
            formReactive.yuyueid = map.id;
        },
        (err) => {
            ElMessageBox.alert(err.message);
        }
    );
    return { form: formReactive, readMap };
};

export const canQuxiaoSelect = (filter, result) => {
    http.post("/api/quxiao/selectPages").then((res) => {
        if (res.code == 0) {
            extend(result, res.data);
        } else {
            ElMessageBox.alert(res.msg);
        }
    });
};

/**
 * 获取分页数据
 * @param filter
 */
export const useQuxiaoSelect = (filter) => {
    const result = reactive({
        lists: [],
        total: {},
    });
    canQuxiaoSelect(filter, result);
    return result;
};

/**
 * 根据
 * @param id
 * @return {Promise|form}
 */
export const canQuxiaoFindById = (id) => {
    return new Promise((resolve, reject) => {
        // 读取后台数据
        http.get("/api/quxiao/findById", { id }).then((res) => {
            if (res.code == 0) {
                resolve(res.data);
            } else {
                reject(new Error(res.msg));
            }
        }, reject);
    });
};

/**
 * 根据id 获取一行数据
 * @param id
 * @return {UnwrapNestedRefs<{}>}
 */
export const useQuxiaoFindById = (id) => {
    var form = reactive({});

    canQuxiaoFindById(id).then((res) => {
        extend(form, res);
    });
    return form;
};

/**
 * 根据数据,插入到数据库中
 * @param data
 * @return {Promise<unknown>}
 */
export const canQuxiaoInsert = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/quxiao/insert", data)
            .json()
            .then(
                (res) => {
                    resolve(res);
                },
                (err) => {
                    reject(err);
                }
            );
    });
};

/**
 * 根据数据更新数据库
 * @param data
 * @return {Promise<unknown>}
 */
export const canQuxiaoUpdate = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/quxiao/update", data)
            .json()
            .then(
                (res) => {
                    resolve(res);
                },
                (err) => {
                    reject(err);
                }
            );
    });
};

/**
 * 根据id 或者列表id
 * @param id
 * @return {Promise<unknown>}
 */
export const canQuxiaoDelete = (id) => {
    var res = [];
    if (!isArray(id)) {
        res.push(id);
    } else {
        res = id;
    }

    return new Promise((resolve, reject) => {
        http.post("/api/quxiao/delete", res)
            .json()
            .then(
                (res) => {
                    resolve(res);
                },
                (err) => {
                    reject(err);
                }
            );
    });
};
