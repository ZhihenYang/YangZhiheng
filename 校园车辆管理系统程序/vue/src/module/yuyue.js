import http from "@/utils/ajax/http";
import { useRoute } from "vue-router";
import { useUserStore } from "@/stores";
import { reactive, ref, unref } from "vue";
import rule from "@/utils/rule";
import { extend, isArray } from "@/utils/extend";
import { ElMessageBox } from "element-plus";
import router from "@/router";

import { canShengyucheweiFindById } from "./shengyuchewei";

/**
 * 响应式的对象数据
 */

export const YuyueCreateForm = () => {
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
        yuyuebianhao: rule.getID(),
        yuyueshijian: "",
        chepaihao: "",
        shenfenzhenghao: "",
        shoujihao: "",
        xingming: "",
        qitabeizhu: "",
        yuyuefangke: $session.username,
        zhuangtai: "已预约",
    };

    return form;
};

function exportForm(form, readMap) {
    var autoText = ["shengyucheweiid", "bianhao", "mingcheng", "quyu", "weizhi", "riqi"];
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
export const canYuyueCreateForm = (id, readMap) => {
    return new Promise(async (resolve, reject) => {
        var form = YuyueCreateForm();
        if (!readMap || !readMap.id) {
            readMap = await canShengyucheweiFindById(id).catch(reject);
        }
        exportForm(form, readMap);
        form.shengyucheweiid = readMap.id;
        resolve({ form, readMap });
    });
};

/**
 * 响应式获取预约 模块的表单字段数据
 * @return {UnwrapNestedRefs<{}>}
 */
export const useYuyueCreateForm = (id) => {
    const form = YuyueCreateForm();
    const formReactive = reactive(form);

    const readMap = reactive({});
    canShengyucheweiFindById(id).then(
        (map) => {
            exportForm(formReactive, map);
            extend(readMap, map);
            formReactive.shengyucheweiid = map.id;
        },
        (err) => {
            ElMessageBox.alert(err.message);
        }
    );
    return { form: formReactive, readMap };
};

export const canYuyueSelect = (filter, result) => {
    http.post("/api/yuyue/selectPages").then((res) => {
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
export const useYuyueSelect = (filter) => {
    const result = reactive({
        lists: [],
        total: {},
    });
    canYuyueSelect(filter, result);
    return result;
};

/**
 * 根据
 * @param id
 * @return {Promise|form}
 */
export const canYuyueFindById = (id) => {
    return new Promise((resolve, reject) => {
        // 读取后台数据
        http.get("/api/yuyue/findById", { id }).then((res) => {
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
export const useYuyueFindById = (id) => {
    var form = reactive({});

    canYuyueFindById(id).then((res) => {
        extend(form, res);
    });
    return form;
};

/**
 * 根据数据,插入到数据库中
 * @param data
 * @return {Promise<unknown>}
 */
export const canYuyueInsert = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/yuyue/insert", data)
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
export const canYuyueUpdate = (data) => {
    return new Promise((resolve, reject) => {
        http.post("/api/yuyue/update", data)
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
export const canYuyueDelete = (id) => {
    var res = [];
    if (!isArray(id)) {
        res.push(id);
    } else {
        res = id;
    }

    return new Promise((resolve, reject) => {
        http.post("/api/yuyue/delete", res)
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
