export default [
    {
        label: "访客车辆管理",
        to: "",
        children: [
            {
                label: "车辆入场添加",
                to: { path: "/admin/cheliangruchang/add" },
            },
            {
                label: "车辆入场查询",
                to: { path: "/admin/cheliangruchang/jingshouren" },
            },
            {
                label: "车辆离场查询",
                to: { path: "/admin/chelianglichang/jingshouren" },
            },
        ],
    },
    {
        label: "特殊放行管理",
        to: "",
        children: [
            {
                label: "特殊放行添加",
                to: { path: "/admin/teshufangxing/add" },
            },
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
                label: "滞留劝出添加",
                to: { path: "/admin/zhiliuquanchu/add" },
            },
            {
                label: "滞留劝出查询",
                to: { path: "/admin/zhiliuquanchu" },
            },
        ],
    },
    {
        label: "个人中心",
        to: "",
        children: [
            {
                label: "修改个人资料",
                to: { path: "/admin/admins/updtself" },
            },
            {
                label: "修改密码",
                to: { path: "/admin/mod" },
            },
        ],
    },
];
