import http from "@/utils/ajax/http";
import { useRoute } from "vue-router";
import { useUserStore } from "@/stores";
import { reactive, ref, unref } from "vue";
import rule from "@/utils/rule";
import { extend, isArray } from "@/utils/extend";
import { ElMessageBox } from "element-plus";
import router from "@/router";

import { canCheliangruchangFindById } from "./cheliangruchang";

/**
 * 响应式的对象数据
 */

export const ChelianglichangCreateForm = () => {
    var route = unref(router.currentRoute);
    const userStore = useUserStore();
    const $session = userStore.session;
    if (!route.query) {
        route = useRoute();
    }
    const form = {
        ruchangbianhao: "",
        ruchangshijian: "",
        cheliangpaihao: "",
        chezhudianhua: "",
        lichangshijian: rule.date("Y-m-d H:i:s"),
        lichangbeizhu: "",
        jingshouren: $session.username,
    };

    return form;
};

function exportForm(form, readMap) {
    var autoText = ["cheliangruchangid", "ruchangbianhao", "ruchangshijian", "cheliangpaihao", "chezhudianhua"];
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
export const canChelianglichangCreateForm = (id, readMap) => {
    return new Promise(async (resolve, reject) => {
        var form = ChelianglichangCreateForm();
        if (!readMap || !readMap.id) {
            readMap = await canCheliangruchangFindById(id).catch(reject);
        }
        exportForm(form, readMap);
        form.cheliangruchangid = readMap.id;
        resolve({ form, readMap });
    });
};

/**
 * 响应式获取车辆离场 模块的表单字段数据
 * @return {UnwrapNestedRefs<{}>}
 */
export const useChelianglichangCreateForm = (id) => {
    const form = ChelianglichangCreateForm();
    const formReactive = reactive(form);

    const readMap = reactive({});
    canCheliangruchangFindById(id).then(
        (map) => {
            exportForm(formReactive, map);
            extend(readMap, map);
            formReactive.cheliangruchangid = map.id;
        },
        (err) => {
            ElMessageBox.alert(err.message);
        }
    );
    return { form: formReactive, readMap };
};

export const canChelianglichangSelect = (filter, result) => {
    http.post("/api/chelianglichang/selectPages").then((res) => {
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
export const useChelianglichangSelect = (filter) => {
    const result = reactive({
        lists: [],
        total: {},
    });
    canChelianglichangSelect(filter, result);
    return result;
};

/**
 * 根据
 * @param id
 * @return {Promise|form}
 */
export const canChelianglichangFindById = (id) => {
    return new Promise((resolve, reject) => {
        // 读取后台数据
        http.get("/api/chelianglichang/findById", { id }).then((res) => {
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
export const useChelianglichangFindById = (id) => {
    var form = reactive({});

    canChelianglichangFindById(id).then((res) => {
        extend(form, res);
    });
    return form;
};

/**
 * 根据数据,插入到数据库中
 * @param data
 * @return {Promise<unknown>}
 */
export const canChelianglichangInsert = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/chelianglichang/insert", data)
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
export const canChelianglichangUpdate = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/chelianglichang/update", data)
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
export const canChelianglichangDelete = (id) => {
    var res = [];
    if (!isArray(id)) {
        res.push(id);
    } else {
        res = id;
    }

    return new Promise((resolve, reject) => {
        http.post("/api/chelianglichang/delete", res)
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
