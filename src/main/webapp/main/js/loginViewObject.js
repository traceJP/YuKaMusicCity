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

        // 表单回显：登录失败则设置为true
        responseInputError: false,
        // 表单：邮箱账号值
        accountValue: '',
        // 表单：密码值
        passwordValue: '',
        // 表单：是否自动登录
        isAutoLogin: false,

    },

    methods: {
        // 背景变换按钮
        backgroundSwitch: function() { backgroundSwitchFun(this) },
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
        // 登录表单提交
        submitButton: function() {
            submitAxios()
        },

    },
    created: function() {
        initBackgroundFun(this)
    }
})

function submitAxios() {
    // 触发检查
    $("#defaultForm").data("bootstrapValidator").validate()
    let flag =  $("#defaultForm").data("bootstrapValidator").isValid()
    if(flag == false) {
        return
    }
    axios.request({
        url: '/YuKaMusicCity/login',
        params: {
            email: app.accountValue,
            password: app.passwordValue,
            isAutoLogin: app.isAutoLogin,
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 登录成功
            window.location.href = "/YuKaMusicCity/main/html/index.html"
        } else {
            // 登录失败
            app.accountValue = ""
            app.passwordValue = ""
            $("#defaultForm").data("bootstrapValidator").resetForm()
            app.responseInputError = true
            setTimeout(() =>{
                app.responseInputError = false
            },3000);
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// bootStrap表单验证
$(document).ready(function () {
    $('#defaultForm').bootstrapValidator()
})
