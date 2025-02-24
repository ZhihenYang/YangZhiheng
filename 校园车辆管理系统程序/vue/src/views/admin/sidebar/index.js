import { useUserStore } from "@/stores/user";

import chaojiguanliyuan from "./chaojiguanliyuan";
import guanliyuan from "./guanliyuan";
import fangkeyonghu from "./fangkeyonghu";
import xiaoneirenyuan from "./xiaoneirenyuan";

export function getMenus() {
    return new Promise((resolve, reject) => {
        var userStore = useUserStore();
        var cx = userStore.getSession("cx");
        if (cx == "超级管理员") {
            resolve(chaojiguanliyuan);
        }
        if (cx == "管理员") {
            resolve(guanliyuan);
        }
        if (cx == "访客用户") {
            resolve(fangkeyonghu);
        }
        if (cx == "校内人员") {
            resolve(xiaoneirenyuan);
        }
    });
}

export default {
    getMenus,
};
