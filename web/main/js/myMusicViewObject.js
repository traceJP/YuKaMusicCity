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
                setBackgroundCookie("white")
                background_status = "white"
            } else {
                document.getElementById("background-box").setAttribute("class", "background-max")
                this.bgNav = 'navbar-inverse'
                setBackgroundCookie("black")
                background_status = "black"
            }
        }

    },

})


// TODO： 初始化背景




