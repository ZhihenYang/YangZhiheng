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

export const TeshufangxingCreateForm = () => {
    var route = unref(router.currentRoute);
    const userStore = useUserStore();
    const $session = userStore.session;
    if (!route.query) {
        route = useRoute();
    }
    const form = {
        fangxingbianhao: rule.getID(),
        fangxingshijian: rule.date("Y-m-d H:i:s"),
        cheliangpaihao: "",
        chezhudianhua: "",
        chezhuxingming: "",
        chezhushenfenzhenghao: "",
        fangxingshuoming: "",
        jingshouren: $session.username,
    };

    return form;
};

/**
 * 异步模式获取数据
 * @param id
 * @param readMap
 * @return {Promise}
 */
export const canTeshufangxingCreateForm = () => {
    return new Promise(async (resolve, reject) => {
        var form = TeshufangxingCreateForm();
        resolve({ form });
    });
};

/**
 * 响应式获取特殊放行 模块的表单字段数据
 * @return {UnwrapNestedRefs<{}>}
 */
export const useTeshufangxingCreateForm = () => {
    const form = TeshufangxingCreateForm();
    const formReactive = reactive(form);

    return { form: formReactive };
};

export const canTeshufangxingSelect = (filter, result) => {
    http.post("/api/teshufangxing/selectPages").then((res) => {
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
export const useTeshufangxingSelect = (filter) => {
    const result = reactive({
        lists: [],
        total: {},
    });
    canTeshufangxingSelect(filter, result);
    return result;
};

/**
 * 根据
 * @param id
 * @return {Promise|form}
 */
export const canTeshufangxingFindById = (id) => {
    return new Promise((resolve, reject) => {
        // 读取后台数据
        http.get("/api/teshufangxing/findById", { id }).then((res) => {
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
export const useTeshufangxingFindById = (id) => {
    var form = reactive({});

    canTeshufangxingFindById(id).then((res) => {
        extend(form, res);
    });
    return form;
};

/**
 * 根据数据,插入到数据库中
 * @param data
 * @return {Promise<unknown>}
 */
export const canTeshufangxingInsert = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/teshufangxing/insert", data)
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
export const canTeshufangxingUpdate = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/teshufangxing/update", data)
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
export const canTeshufangxingDelete = (id) => {
    var res = [];
    if (!isArray(id)) {
        res.push(id);
    } else {
        res = id;
    }

    return new Promise((resolve, reject) => {
        http.post("/api/teshufangxing/delete", res)
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
