var app = new Vue({
    el: '#vue-model',

    data: {
        // 背景状态
        backgroundStatus: 'white',
        // 全局背景色变量
        backgroundBox: '',
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
        

        // 用户基本信息
        userInfomation: '',
        // 用户头像
        avtar : '../image/ge3.jpg',
        // 用户名
        name: 'admin',
        // 用户性别
        sex: '未设置性别',
        // 用户年龄
        age: '未知年龄',
        // 用户个人简介
        introduction: '编辑个签，展示我的独特态度~',
        // 用户所在地区
        area: '地球村',
        // 用户等级信息初始化数据
        userLevel: '',
        // 登录进度条
        loginDays: {width: '0%'},
        // 听歌进度条
        ListenSong: {width: '0%'},

        // 用户听歌排行初始化数据
        songRank: [],

    },

    methods: {
        // 背景变换按钮
        backgroundSwitch: function() { backgroundSwitchFun(this) },
        // 歌曲页面跳转
        songRouter: function(musicId) {
            window.location.href = "/YuKaMusicCity/main/html/song.html?id=" + musicId
        },
        // 搜索栏数据请求和跳转
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
        // bootStrap弹出框按钮
        bootStrapWindow: function(id) {
            $(id).popover("show")
        },

    },
    created: function() {
        initBackgroundFun(this)
        getUserNameService()
        getPageDataService("user/homeView")
    },

})

// 初始化页面渲染
function initPageData(model) {
    console.log(model)
    app.userInfomation = model.userInfomation
    let info = model.userInfomation
    if(info.userName != null) app.name = info.userName
    if(info.userSex != null) app.sex = info.userSex
    if(info.userAge != null) app.age = info.userAge
    if(info.introduction != null) app.introduction = info.introduction
    if(info.userArea != null) app.area = info.userArea
    app.userLevel = model.userLevel
    app.songRank = model.songRank
    // 进度条渲染
    app.loginDays.width = (Number(app.userLevel.loginDaysPercentage)*100).toFixed(2) + "%"
    app.ListenSong.width = (Number(app.userLevel.listenToSongPercentage)*100).toFixed(2) + "%"
}
