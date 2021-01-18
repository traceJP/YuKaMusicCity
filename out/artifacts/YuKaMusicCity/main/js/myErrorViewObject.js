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
                vueError.bgError = ''
                setBackgroundCookie("white")
                background_status = "white"
            } else {
                document.getElementById("background-box").setAttribute("class", "background-max")
                this.bgNav = 'navbar-inverse'
                vueTail.bgTail = 'background-tail'
                vueError.bgError = 'background-max'
                setBackgroundCookie("black")
                background_status = "black"
            }
        }

    },

})

// 错误提示盒模型
var vueError = new Vue({
    el: '#error_vue_object',
    data() {
        return {
            bgError: ''
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
            vueError.bgError = 'background-max'
            this.bgTail = 'background-tail'
            background_status = "black"
        }
    },
})
