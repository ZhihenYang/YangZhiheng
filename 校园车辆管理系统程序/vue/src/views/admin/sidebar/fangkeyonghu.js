export default [
    {
        label: "车位信息",
        to: "",
        children: [
            {
                label: "车位信息查询",
                to: { path: "/admin/chewei" },
            },
        ],
    },
    {
        label: "车位预约",
        to: "",
        children: [
            {
                label: "车位预约记录",
                to: { path: "/admin/yuyue/yuyuefangke" },
            },
            {
                label: "取消预约记录",
                to: { path: "/admin/quxiao/yuyuefangke" },
            },
        ],
    },
    {
        label: "个人中心",
        to: "",
        children: [
            {
                label: "修改个人资料",
                to: { path: "/admin/fangkeyonghu/updtself" },
            },
            {
                label: "修改密码",
                to: { path: "/admin/mod" },
            },
        ],
    },
];
