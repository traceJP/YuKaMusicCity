var background = new Vue({

    el: '#bg-app',

    data: {
        // 开关状态    黑背景：true；白背景：false
        status : false,
        // 全局背景
        bgMax : '',
        // 导航条
        bgNav : 'navbar-default',
        // 排行榜
        bgLeaderBoard : 'table-striped',
        // 页脚
        bgTail : '',
    },

    methods: {
        backgroundSwitch: function() {
            if(this.status) {
                this.bgMax = ''
                this.bgNav = 'navbar-default'
                this.bgLeaderBoard = 'table-striped'
                this.bgTail = ''
                this.status = false
                setBackgroundCookie("false")
            } else {
                this.bgMax = 'background-max'
                this.bgNav = 'navbar-inverse'
                this.bgLeaderBoard = ''
                this.bgTail = 'background-tail'
                this.status = true
                setBackgroundCookie("true")
            }
        }
    },

    mounted: function() {
        if(getBackgroundCookie()) {
            this.bgMax = 'background-max'
            this.bgNav = 'navbar-inverse'
            this.bgLeaderBoard = ''
            this.bgTail = 'background-tail'
            this.status = true
        } else {
            this.bgMax = ''
            this.bgNav = 'navbar-default'
            this.bgLeaderBoard = 'table-striped'
            this.bgTail = ''
            this.status = false
        }
    },

})

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



