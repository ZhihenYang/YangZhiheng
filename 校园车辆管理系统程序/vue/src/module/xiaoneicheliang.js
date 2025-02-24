import http from "@/utils/ajax/http";
import { useRoute } from "vue-router";
import { useUserStore } from "@/stores";
import { reactive, ref, unref } from "vue";
import rule from "@/utils/rule";
import { extend, isArray } from "@/utils/extend";
import { ElMessageBox } from "element-plus";
import router from "@/router";

/**
 * 响应式的对象数据
 */

export const XiaoneicheliangCreateForm = () => {
    var route = unref(router.currentRoute);
    const userStore = useUserStore();
    const $session = userStore.session;
    if (!route.query) {
        route = useRoute();
    }
    const form = {
        cheliangbianhao: "",
        cheliangmingcheng: "",
        cheliangpinpai: "",
        cheliangyanse: "",
        cheliangpaihao: "",
        cheliangjianjie: "",
    };

    return form;
};

/**
 * 异步模式获取数据
 * @param id
 * @param readMap
 * @return {Promise}
 */
export const canXiaoneicheliangCreateForm = () => {
    return new Promise(async (resolve, reject) => {
        var form = XiaoneicheliangCreateForm();
        resolve({ form });
    });
};

/**
 * 响应式获取校内车辆 模块的表单字段数据
 * @return {UnwrapNestedRefs<{}>}
 */
export const useXiaoneicheliangCreateForm = () => {
    const form = XiaoneicheliangCreateForm();
    const formReactive = reactive(form);

    return { form: formReactive };
};

export const canXiaoneicheliangSelect = (filter, result) => {
    http.post("/api/xiaoneicheliang/selectPages").then((res) => {
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
export const useXiaoneicheliangSelect = (filter) => {
    const result = reactive({
        lists: [],
        total: {},
    });
    canXiaoneicheliangSelect(filter, result);
    return result;
};

/**
 * 根据
 * @param id
 * @return {Promise|form}
 */
export const canXiaoneicheliangFindById = (id) => {
    return new Promise((resolve, reject) => {
        // 读取后台数据
        http.get("/api/xiaoneicheliang/findById", { id }).then((res) => {
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
export const useXiaoneicheliangFindById = (id) => {
    var form = reactive({});

    canXiaoneicheliangFindById(id).then((res) => {
        extend(form, res);
    });
    return form;
};

/**
 * 根据数据,插入到数据库中
 * @param data
 * @return {Promise<unknown>}
 */
export const canXiaoneicheliangInsert = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/xiaoneicheliang/insert", data)
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
export const canXiaoneicheliangUpdate = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/xiaoneicheliang/update", data)
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
export const canXiaoneicheliangDelete = (id) => {
    var res = [];
    if (!isArray(id)) {
        res.push(id);
    } else {
        res = id;
    }

    return new Promise((resolve, reject) => {
        http.post("/api/xiaoneicheliang/delete", res)
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
