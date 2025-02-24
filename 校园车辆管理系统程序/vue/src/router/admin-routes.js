import { session } from "@/utils/utils";

export default [
    {
        path: "admins",
        name: "AdminadminsList",
        component: () => import("@/views/admins/list.vue"),
        meta: { title: "管理员列表", authLogin: true },
    },

    {
        path: "admins/add",
        name: "AdminadminsAdd",
        component: () => import("@/views/admins/add.vue"),
        meta: { title: "添加管理员", authLogin: true },
    },
    {
        path: "admins/updt",
        name: "AdminadminsUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/admins/updt.vue"),
        meta: { title: "编辑管理员", authLogin: true },
    },
    {
        path: "admins/updtself",
        name: "AdminadminsUpdtSelf",
        props: (route) => ({ id: session("id") }),
        component: () => import("@/views/admins/updtself.vue"),
        meta: { title: "更新个人资料", authLogin: true },
    },
    {
        path: "admins/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminadminsDetail",
        component: () => import("@/views/admins/detail.vue"),
        meta: { title: "管理员详情", authLogin: true },
    },
    {
        path: "fangkeyonghu",
        name: "AdminfangkeyonghuList",
        component: () => import("@/views/fangkeyonghu/list.vue"),
        meta: { title: "访客用户列表", authLogin: true },
    },

    {
        path: "fangkeyonghu/add",
        name: "AdminfangkeyonghuAdd",
        component: () => import("@/views/fangkeyonghu/add.vue"),
        meta: { title: "添加访客用户", authLogin: true },
    },
    {
        path: "fangkeyonghu/updt",
        name: "AdminfangkeyonghuUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/fangkeyonghu/updt.vue"),
        meta: { title: "编辑访客用户", authLogin: true },
    },
    {
        path: "fangkeyonghu/updtself",
        name: "AdminfangkeyonghuUpdtSelf",
        props: (route) => ({ id: session("id") }),
        component: () => import("@/views/fangkeyonghu/updtself.vue"),
        meta: { title: "更新个人资料", authLogin: true },
    },
    {
        path: "fangkeyonghu/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminfangkeyonghuDetail",
        component: () => import("@/views/fangkeyonghu/detail.vue"),
        meta: { title: "访客用户详情", authLogin: true },
    },
    {
        path: "xiaoneicheliang",
        name: "AdminxiaoneicheliangList",
        component: () => import("@/views/xiaoneicheliang/list.vue"),
        meta: { title: "校内车辆列表", authLogin: true },
    },

    {
        path: "xiaoneicheliang/add",
        name: "AdminxiaoneicheliangAdd",
        component: () => import("@/views/xiaoneicheliang/add.vue"),
        meta: { title: "添加校内车辆", authLogin: true },
    },
    {
        path: "xiaoneicheliang/updt",
        name: "AdminxiaoneicheliangUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/xiaoneicheliang/updt.vue"),
        meta: { title: "编辑校内车辆", authLogin: true },
    },
    {
        path: "xiaoneicheliang/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminxiaoneicheliangDetail",
        component: () => import("@/views/xiaoneicheliang/detail.vue"),
        meta: { title: "校内车辆详情", authLogin: true },
    },
    {
        path: "fangwenshijian",
        name: "AdminfangwenshijianList",
        component: () => import("@/views/fangwenshijian/list.vue"),
        meta: { title: "访问时间列表", authLogin: true },
    },

    {
        path: "fangwenshijian/add",
        name: "AdminfangwenshijianAdd",
        component: () => import("@/views/fangwenshijian/add.vue"),
        meta: { title: "添加访问时间", authLogin: true },
    },
    {
        path: "fangwenshijian/updt",
        name: "AdminfangwenshijianUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/fangwenshijian/updt.vue"),
        meta: { title: "编辑访问时间", authLogin: true },
    },
    {
        path: "chewei",
        name: "AdmincheweiList",
        component: () => import("@/views/chewei/list.vue"),
        meta: { title: "车位列表", authLogin: true },
    },

    {
        path: "chewei/add",
        name: "AdmincheweiAdd",
        component: () => import("@/views/chewei/add.vue"),
        meta: { title: "添加车位", authLogin: true },
    },
    {
        path: "chewei/updt",
        name: "AdmincheweiUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/chewei/updt.vue"),
        meta: { title: "编辑车位", authLogin: true },
    },
    {
        path: "chewei/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdmincheweiDetail",
        component: () => import("@/views/chewei/detail.vue"),
        meta: { title: "车位详情", authLogin: true },
    },
    {
        path: "shengyuchewei",
        name: "AdminshengyucheweiList",
        component: () => import("@/views/shengyuchewei/list.vue"),
        meta: { title: "剩余车位列表", authLogin: true },
    },

    {
        path: "shengyuchewei/add",
        name: "AdminshengyucheweiAdd",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/shengyuchewei/add.vue"),
        meta: { title: "添加剩余车位", authLogin: true },
    },
    {
        path: "shengyuchewei/updt",
        name: "AdminshengyucheweiUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/shengyuchewei/updt.vue"),
        meta: { title: "编辑剩余车位", authLogin: true },
    },
    {
        path: "shengyuchewei/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminshengyucheweiDetail",
        component: () => import("@/views/shengyuchewei/detail.vue"),
        meta: { title: "剩余车位详情", authLogin: true },
    },
    {
        path: "yuyue",
        name: "AdminyuyueList",
        component: () => import("@/views/yuyue/list.vue"),
        meta: { title: "预约列表", authLogin: true },
    },

    {
        path: "yuyue/yuyuefangke",
        name: "AdminyuyueListyuyuefangke",
        component: () => import("@/views/yuyue/yuyuefangke.vue"),
        meta: { title: "预约列表", authLogin: true },
    },

    {
        path: "yuyue/add",
        name: "AdminyuyueAdd",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/yuyue/add.vue"),
        meta: { title: "添加预约", authLogin: true },
    },
    {
        path: "yuyue/updt",
        name: "AdminyuyueUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/yuyue/updt.vue"),
        meta: { title: "编辑预约", authLogin: true },
    },
    {
        path: "yuyue/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminyuyueDetail",
        component: () => import("@/views/yuyue/detail.vue"),
        meta: { title: "预约详情", authLogin: true },
    },
    {
        path: "quxiao",
        name: "AdminquxiaoList",
        component: () => import("@/views/quxiao/list.vue"),
        meta: { title: "取消列表", authLogin: true },
    },

    {
        path: "quxiao/yuyuefangke",
        name: "AdminquxiaoListyuyuefangke",
        component: () => import("@/views/quxiao/yuyuefangke.vue"),
        meta: { title: "取消列表", authLogin: true },
    },

    {
        path: "quxiao/add",
        name: "AdminquxiaoAdd",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/quxiao/add.vue"),
        meta: { title: "添加取消", authLogin: true },
    },
    {
        path: "quxiao/updt",
        name: "AdminquxiaoUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/quxiao/updt.vue"),
        meta: { title: "编辑取消", authLogin: true },
    },
    {
        path: "quxiao/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminquxiaoDetail",
        component: () => import("@/views/quxiao/detail.vue"),
        meta: { title: "取消详情", authLogin: true },
    },
    {
        path: "xiaoneirenyuan",
        name: "AdminxiaoneirenyuanList",
        component: () => import("@/views/xiaoneirenyuan/list.vue"),
        meta: { title: "校内人员列表", authLogin: true },
    },

    {
        path: "xiaoneirenyuan/add",
        name: "AdminxiaoneirenyuanAdd",
        component: () => import("@/views/xiaoneirenyuan/add.vue"),
        meta: { title: "添加校内人员", authLogin: true },
    },
    {
        path: "xiaoneirenyuan/updt",
        name: "AdminxiaoneirenyuanUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/xiaoneirenyuan/updt.vue"),
        meta: { title: "编辑校内人员", authLogin: true },
    },
    {
        path: "xiaoneirenyuan/updtself",
        name: "AdminxiaoneirenyuanUpdtSelf",
        props: (route) => ({ id: session("id") }),
        component: () => import("@/views/xiaoneirenyuan/updtself.vue"),
        meta: { title: "更新个人资料", authLogin: true },
    },
    {
        path: "xiaoneirenyuan/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminxiaoneirenyuanDetail",
        component: () => import("@/views/xiaoneirenyuan/detail.vue"),
        meta: { title: "校内人员详情", authLogin: true },
    },
    {
        path: "teshufangxing",
        name: "AdminteshufangxingList",
        component: () => import("@/views/teshufangxing/list.vue"),
        meta: { title: "特殊放行列表", authLogin: true },
    },

    {
        path: "teshufangxing/jingshouren",
        name: "AdminteshufangxingListjingshouren",
        component: () => import("@/views/teshufangxing/jingshouren.vue"),
        meta: { title: "特殊放行列表", authLogin: true },
    },

    {
        path: "teshufangxing/add",
        name: "AdminteshufangxingAdd",
        component: () => import("@/views/teshufangxing/add.vue"),
        meta: { title: "添加特殊放行", authLogin: true },
    },
    {
        path: "teshufangxing/updt",
        name: "AdminteshufangxingUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/teshufangxing/updt.vue"),
        meta: { title: "编辑特殊放行", authLogin: true },
    },
    {
        path: "teshufangxing/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminteshufangxingDetail",
        component: () => import("@/views/teshufangxing/detail.vue"),
        meta: { title: "特殊放行详情", authLogin: true },
    },
    {
        path: "zhiliuquanchu",
        name: "AdminzhiliuquanchuList",
        component: () => import("@/views/zhiliuquanchu/list.vue"),
        meta: { title: "滞留劝出列表", authLogin: true },
    },

    {
        path: "zhiliuquanchu/jingshouren",
        name: "AdminzhiliuquanchuListjingshouren",
        component: () => import("@/views/zhiliuquanchu/jingshouren.vue"),
        meta: { title: "滞留劝出列表", authLogin: true },
    },

    {
        path: "zhiliuquanchu/add",
        name: "AdminzhiliuquanchuAdd",
        component: () => import("@/views/zhiliuquanchu/add.vue"),
        meta: { title: "添加滞留劝出", authLogin: true },
    },
    {
        path: "zhiliuquanchu/updt",
        name: "AdminzhiliuquanchuUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/zhiliuquanchu/updt.vue"),
        meta: { title: "编辑滞留劝出", authLogin: true },
    },
    {
        path: "zhiliuquanchu/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminzhiliuquanchuDetail",
        component: () => import("@/views/zhiliuquanchu/detail.vue"),
        meta: { title: "滞留劝出详情", authLogin: true },
    },
    {
        path: "cheliangruchang",
        name: "AdmincheliangruchangList",
        component: () => import("@/views/cheliangruchang/list.vue"),
        meta: { title: "车辆入场列表", authLogin: true },
    },

    {
        path: "cheliangruchang/jingshouren",
        name: "AdmincheliangruchangListjingshouren",
        component: () => import("@/views/cheliangruchang/jingshouren.vue"),
        meta: { title: "车辆入场列表", authLogin: true },
    },

    {
        path: "cheliangruchang/add",
        name: "AdmincheliangruchangAdd",
        component: () => import("@/views/cheliangruchang/add.vue"),
        meta: { title: "添加车辆入场", authLogin: true },
    },
    {
        path: "cheliangruchang/updt",
        name: "AdmincheliangruchangUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/cheliangruchang/updt.vue"),
        meta: { title: "编辑车辆入场", authLogin: true },
    },
    {
        path: "cheliangruchang/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdmincheliangruchangDetail",
        component: () => import("@/views/cheliangruchang/detail.vue"),
        meta: { title: "车辆入场详情", authLogin: true },
    },
    {
        path: "chelianglichang",
        name: "AdminchelianglichangList",
        component: () => import("@/views/chelianglichang/list.vue"),
        meta: { title: "车辆离场列表", authLogin: true },
    },

    {
        path: "chelianglichang/jingshouren",
        name: "AdminchelianglichangListjingshouren",
        component: () => import("@/views/chelianglichang/jingshouren.vue"),
        meta: { title: "车辆离场列表", authLogin: true },
    },

    {
        path: "chelianglichang/add",
        name: "AdminchelianglichangAdd",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/chelianglichang/add.vue"),
        meta: { title: "添加车辆离场", authLogin: true },
    },
    {
        path: "chelianglichang/updt",
        name: "AdminchelianglichangUpdt",
        props: (route) => ({ id: route.query.id }),
        component: () => import("@/views/chelianglichang/updt.vue"),
        meta: { title: "编辑车辆离场", authLogin: true },
    },
    {
        path: "chelianglichang/detail",
        props: (route) => ({ id: route.query.id }),
        name: "AdminchelianglichangDetail",
        component: () => import("@/views/chelianglichang/detail.vue"),
        meta: { title: "车辆离场详情", authLogin: true },
    },
];
