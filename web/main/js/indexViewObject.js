var index = new Vue({
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
    }
})

// function getUrlParam(name) {
//     let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)")
//     let value = window.location.search.substr(1).match(reg)
//     if (value != null) {
//         return unescape(value[2])
//     }
//     return null
// }
// var xx = getUrlParam('reurl')
// alert(xx)

function searchRequestFun() {
    axios.request({
        url: '/YuKaMusicCity/search',
        params: {
            word: index.searchValue,
            resultCount: 6,
        },
    })
    .then(response => {
        index.searchResponse = response.data
    })
    .catch(error => {
        console.log("搜索请求失败" + error)
    })

}

// 初始化页面渲染
function initPageData(data) {
    index.popularMusicList = data.popularMusicList
    index.newSongMusic = data.newSongMusic
    index.rankListOneMusic = data.rankListOneMusic
    index.rankListTwoMusic = data.rankListTwoMusic
    index.rankListThreeMusic = data.rankListThreeMusic
}

// 修改变化背景主题
function backgroundSwitchFun(model) {
    if(model.backgroundStatus === "black") {
        model.backgroundBox = ''
        model.bgNav = 'navbar-default'
        model.bgLeaderBoard = 'table-striped'
        model.bgTail = ''
        setBackgroundCookie("white")
        model.backgroundStatus = "white"
    } else if(model.backgroundStatus === "white") {
        model.backgroundBox = 'background-max'
        model.bgNav = 'navbar-inverse'
        model.bgLeaderBoard = ''
        model.bgTail = 'background-tail'
        setBackgroundCookie("black")
        model.backgroundStatus = "black"
    }
}

// 初始化背景主题
function initBackgroundFun(model) {
    if(getBackgroundCookie() === "black") {
        model.backgroundBox = 'background-max'
        model.bgNav = 'navbar-inverse'
        model.bgLeaderBoard = ''
        model.bgTail = 'background-tail'
        model.backgroundStatus = 'black'
    }
}

// 初始化用户服务
function initUserServiceFun(model) {
    index.userName = model.data
    index.myMusicButtonHref = 'myMusic.html'
    index.userNameButtonHref = 'home.html'

}

// index.html页面初始化渲染
axios.get('/YuKaMusicCity/indexView')
    .then(response => {
        initPageData(response.data)
    })
    .catch(error => {
        // 页面渲染失败，需要跳出提示信息
    })

// 获取已登录的用户信息
axios.get('/YuKaMusicCity/user/userName')
    .then(response => {
        if(response.data === 1005) {
            return;
        }
        initUserServiceFun(response)
    })
    .catch(error => {
        console.log("请求用户信息失败" + error)
    })
