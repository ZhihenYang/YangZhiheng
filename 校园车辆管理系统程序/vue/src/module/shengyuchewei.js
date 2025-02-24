import http from "@/utils/ajax/http";
import { useRoute } from "vue-router";
import { useUserStore } from "@/stores";
import { reactive, ref, unref } from "vue";
import rule from "@/utils/rule";
import { extend, isArray } from "@/utils/extend";
import { ElMessageBox } from "element-plus";
import router from "@/router";

import { canCheweiFindById } from "./chewei";

/**
 * 响应式的对象数据
 */

export const ShengyucheweiCreateForm = () => {
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
        riqi: rule.date("Y-m-d"),
        shengyuchewei: "",
        shuoming: "",
    };

    return form;
};

function exportForm(form, readMap) {
    var autoText = ["cheweiid", "bianhao", "mingcheng", "quyu", "weizhi"];
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
export const canShengyucheweiCreateForm = (id, readMap) => {
    return new Promise(async (resolve, reject) => {
        var form = ShengyucheweiCreateForm();
        if (!readMap || !readMap.id) {
            readMap = await canCheweiFindById(id).catch(reject);
        }
        exportForm(form, readMap);
        form.cheweiid = readMap.id;
        resolve({ form, readMap });
    });
};

/**
 * 响应式获取剩余车位 模块的表单字段数据
 * @return {UnwrapNestedRefs<{}>}
 */
export const useShengyucheweiCreateForm = (id) => {
    const form = ShengyucheweiCreateForm();
    const formReactive = reactive(form);

    const readMap = reactive({});
    canCheweiFindById(id).then(
        (map) => {
            exportForm(formReactive, map);
            extend(readMap, map);
            formReactive.cheweiid = map.id;
        },
        (err) => {
            ElMessageBox.alert(err.message);
        }
    );
    return { form: formReactive, readMap };
};

export const canShengyucheweiSelect = (filter, result) => {
    http.post("/api/shengyuchewei/selectPages").then((res) => {
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
export const useShengyucheweiSelect = (filter) => {
    const result = reactive({
        lists: [],
        total: {},
    });
    canShengyucheweiSelect(filter, result);
    return result;
};

/**
 * 根据
 * @param id
 * @return {Promise|form}
 */
export const canShengyucheweiFindById = (id) => {
    return new Promise((resolve, reject) => {
        // 读取后台数据
        http.get("/api/shengyuchewei/findById", { id }).then((res) => {
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
export const useShengyucheweiFindById = (id) => {
    var form = reactive({});

    canShengyucheweiFindById(id).then((res) => {
        extend(form, res);
    });
    return form;
};

/**
 * 根据数据,插入到数据库中
 * @param data
 * @return {Promise<unknown>}
 */
export const canShengyucheweiInsert = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/shengyuchewei/insert", data)
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
export const canShengyucheweiUpdate = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/shengyuchewei/update", data)
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
export const canShengyucheweiDelete = (id) => {
    var res = [];
    if (!isArray(id)) {
        res.push(id);
    } else {
        res = id;
    }

    return new Promise((resolve, reject) => {
        http.post("/api/shengyuchewei/delete", res)
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
