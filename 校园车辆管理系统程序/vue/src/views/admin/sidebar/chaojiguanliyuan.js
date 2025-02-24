export default [
    {
        label: "账号管理",
        to: "",
        children: [
            {
                label: "管理员账号管理",
                to: { path: "/admin/admins" },
            },
            {
                label: "管理员账号添加",
                to: { path: "/admin/admins/add" },
            },
            {
                label: "密码修改",
                to: { path: "/admin/mod" },
            },
        ],
    },
    {
        label: "访客用户",
        to: "",
        children: [
            {
                label: "访客用户添加",
                to: { path: "/admin/fangkeyonghu/add" },
            },
            {
                label: "访客用户查询",
                to: { path: "/admin/fangkeyonghu" },
            },
        ],
    },
    {
        label: "校内人员",
        to: "",
        children: [
            {
                label: "校内人员添加",
                to: { path: "/admin/xiaoneirenyuan/add" },
            },
            {
                label: "校内人员查询",
                to: { path: "/admin/xiaoneirenyuan" },
            },
        ],
    },
    {
        label: "访问时间管理",
        to: "",
        children: [

            {
                label: "访问时间查询",
                to: { path: "/admin/fangwenshijian" },
            },
        ],
    },
    {
        label: "校内车辆管理",
        to: "",
        children: [
            {
                label: "校内车辆添加",
                to: { path: "/admin/xiaoneicheliang/add" },
            },
            {
                label: "校内车辆查询",
                to: { path: "/admin/xiaoneicheliang" },
            },
        ],
    },
    {
        label: "车位信息管理",
        to: "",
        children: [
            {
                label: "车位添加",
                to: { path: "/admin/chewei/add" },
            },
            {
                label: "车位查询",
                to: { path: "/admin/chewei" },
            },
            {
                label: "剩余车位查询",
                to: { path: "/admin/shengyuchewei" },
            },
        ],
    },
    {
        label: "预约信息管理",
        to: "",
        children: [
            {
                label: "预约查询",
                to: { path: "/admin/yuyue" },
            },
            {
                label: "取消查询",
                to: { path: "/admin/quxiao" },
            },
        ],
    },
    {
        label: "特殊放行管理",
        to: "",
        children: [
            {
                label: "特殊放行查询",
                to: { path: "/admin/teshufangxing" },
            },
        ],
    },
    {
        label: "滞留劝出管理",
        to: "",
        children: [
            {
                label: "滞留劝出查询",
                to: { path: "/admin/zhiliuquanchu" },
            },
        ],
    },
    {
        label: "访客车辆管理",
        to: "",
        children: [
            {
                label: "车辆入场查询",
                to: { path: "/admin/cheliangruchang" },
            },
            {
                label: "车辆离场查询",
                to: { path: "/admin/chelianglichang" },
            },
        ],
    },
];
