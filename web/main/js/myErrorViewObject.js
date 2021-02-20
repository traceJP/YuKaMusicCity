var app = new Vue({
    el: '#vue-model',

    data: {
        // 背景状态
        backgroundStatus: 'white',
        // 全局背景色变量
        backgroundBox: '',
        // 排行榜背景颜色变量
        bgLeaderBoard: 'table-striped',
        // 页脚背景颜色变量
        bgTail: '',
        // 导航条背景色
        bgNav: 'navbar-default',
        // 导航标题背景色
        bgError: '',

        // 搜索框绑定值
        searchValue: '',
        // 搜索框回显响应数据
        searchResponse: [],
    },

    methods: {
        // 背景变换按钮
        backgroundSwitch: function() { backgroundSwitchFun(this) },
        // 搜索框跳转和查询
        searchRequest: function(event) {
            searchRequestFun()
        },
        searchRouter: function(id, type) {
            if(type == "1") {
                window.location.href = "/YuKaMusicCity/main/html/song.html?id=" + id
            } else if(type == "2") {
                window.location.href = "/YuKaMusicCity/main/html/playlist.html?id=" + id
            }
        },

    },
    created: function() {
        initBackgroundFun(this)
    }
})