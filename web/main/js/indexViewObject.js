// 全局变量
// 背景状态变量
var background_status = 'black'

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
                // TODO:如果是黑色背景，那么就变成白色
            }
            if(background_status === "white") {
                // TODO:如果是白色背景，那么就变成黑色
            }
            
            this.bgNav = 'navbar-inverse'
            
            
            // TODO...
            
        }

        // 初始化背景变换按钮

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
    }
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
    }
})


// 其他方法

// 保存背景Status到Cookie
function setBackgroundCookie(statusValue) {
    // 保存时间：天
    let Days = 7;
    let exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    let keyValue = "backgroundValue=" + statusValue + ";"
    let timeout = "expires=" + exp.toGMTString() + ";"
    document.cookie = keyValue + timeout
}

// 获取背景Cookie
function getBackgroundCookie() {
    let cookieName = "backgroundValue="
    let cookies = document.cookie.split(";")
    for(let i = 0;i < cookies.length;i++) {
        let c = cookies[i].trim();
        return c.indexOf(cookieName) == 0 && c.substring(cookieName.length, c.length) === "true"
    }
}
