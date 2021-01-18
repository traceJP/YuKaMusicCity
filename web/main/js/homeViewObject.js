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
                vueTail.bgTail = ''
                setBackgroundCookie("white")
                background_status = "white"
            } else {
                document.getElementById("background-box").setAttribute("class", "background-max")
                this.bgNav = 'navbar-inverse'
                vueTail.bgTail = 'background-tail'
                setBackgroundCookie("black")
                background_status = "black"
            }
        }

    },

})

// 个人信息盒模型
var vueInfo = new Vue({
    el: '#info_vue_object',
    data() {
        return {

        }
    },
})

// 个人等级盒模型
var vueLevel = new Vue({
    el: '#level_vue_object',
    data() {
        return {

        }
    },
})

// 个人听歌排行榜盒模型
var vueRank = new Vue({
    el: '#rank_vue_object',
    data() {
        return {

        }
    },
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
            this.bgTail = 'background-tail'
            background_status = "black"
        }
    },
})



