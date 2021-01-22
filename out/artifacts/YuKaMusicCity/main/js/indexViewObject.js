
// 背景状态变量
var background_status = 'white'

// 导航条盒模型
var vueNav = new Vue({
    el: '#nav_vue_object',
    data() {
        return {
            // 导航条背景色
            bgNav: 'navbar-default',
            // TODO：我的音乐按钮

            // 登录按钮
            userName: '登录',
            // 登录按钮链接
            userNameButtonHref: 'login.html',
        }
    },

    methods: {
        // 背景变换按钮
        backgroundSwitch: function() {
            if(background_status === "black") {
                document.getElementById("background-box").setAttribute("class", "")
                this.bgNav = 'navbar-default'
                vueRank.bgLeaderBoard = 'table-striped'
                vueTail.bgTail = ''
                setBackgroundCookie("white")
                background_status = "white"
            } else {
                document.getElementById("background-box").setAttribute("class", "background-max")
                this.bgNav = 'navbar-inverse'
                vueRank.bgLeaderBoard = ''
                vueTail.bgTail = 'background-tail'
                setBackgroundCookie("black")
                background_status = "black"
            }
        }

    },

})

// 歌曲展示盒模型
var vueSong = new Vue({
    el: '#song_vue_object',
    data() {
        return {
            hello : '紫罗兰永恒花园'
            // TODO...
        }
    },
})

// 专辑展示盒模型
var vueAlbum = new Vue({
    el: '#album_vue_object',
    data() {
        return {
            // TODO...
        }
    }
})

// 排行榜盒模型
var vueRank = new Vue({
    el: '#rank_vue_object',
    data() {
        return {
            // 排行榜背景样式
            bgLeaderBoard: 'table-striped'
        }
    }
})

// 页脚盒模型
var vueTail = new Vue({
    el: '#tail_vue_object',
    data() {
        return {
            // 页脚背景
            bgTail: '',
        }
    },
    // 初始化背景变换
    mounted: function() {
        if(getBackgroundCookie() === "black") {
            document.getElementById("background-box").setAttribute("class", "background-max")
            vueNav.bgNav = 'navbar-inverse'
            vueRank.bgLeaderBoard = ''
            this.bgTail = 'background-tail'
            background_status = "black"
        }
    },
})

// index.html页面初始化
$(document).ready(function(){
    $.ajax({
        url: "/YuKaMusicCity/indexView",
        type: "GET",
        success: function(data) {
            // 测试渲染：热门推荐歌曲标题
            vueSong.hello = data.newSongMusic[1].musicName


            // TODO: 需要根据后端返回的数据渲染全局页面

        },
        error: function(res) {
            // TODO：响应失败需要加载隐藏提示框
        },
    })
})

// 获取已登录的用户信息
$(document).ready(function(){
    $.ajax({
        url: "/YuKaMusicCity/login",
        type: "GET",
        success: function(data) {
            alert(data)
            
        },
        error: function(res) {
            
        },
    })
})
