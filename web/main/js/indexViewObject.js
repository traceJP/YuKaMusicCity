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
        // 我的音乐按钮
        myMusicButtonHref: 'myError.html',
        // 登录按钮
        userName: '登录',
        // 登录按钮链接
        userNameButtonHref: 'login.html',
        // 搜索框绑定值
        searchValue: '',
        // 搜索框回显响应数据
        searchResponse: [],
        
        // 热门推荐初始化数据
        popularMusicList: [],
        // 新曲上架初始化数据
        newSongMusic: [],
        // 排行榜1初始化数据
        rankListOneMusic: [],
        // 排行榜2初始化数据
        rankListTwoMusic: [],
        // 排行榜3初始化数据
        rankListThreeMusic: [],

    },

    methods: {
        // 背景变换按钮
        backgroundSwitch: function() { backgroundSwitchFun(this) },
        // 热门推荐页面跳转
        playlistRouter: function(listId) {
            window.location.href = "/YuKaMusicCity/main/html/playlist.html?id=" + listId
        },
        songRouter: function(musicId) {
            window.location.href = "/YuKaMusicCity/main/html/song.html?id=" + musicId
        },
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
        getUserNameService()
        getPageDataService("indexView")
    }
})

// 初始化页面渲染
function initPageData(data) {
    app.popularMusicList = data.popularMusicList
    app.newSongMusic = data.newSongMusic
    app.rankListOneMusic = data.rankListOneMusic
    app.rankListTwoMusic = data.rankListTwoMusic
    app.rankListThreeMusic = data.rankListThreeMusic
}

