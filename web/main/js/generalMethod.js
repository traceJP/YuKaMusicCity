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
        return c.substring(cookieName.length, c.length)
    }
}

// 获取用户信息服务：需要重写initUserServiceFun(response)方法
function getUserNameService() {
    axios.get('/YuKaMusicCity/user/userName')
    .then(response => {
        if(response.data === 1005) {
            return;
        }
        initUserServiceFun(response)
    })
    .catch(error => {
        console.log("请求服务请求失败" + error)
    })
}
// 初始化用户服务
function initUserServiceFun(model) {
    app.userName = model.data
    app.myMusicButtonHref = 'myMusic.html'
    app.userNameButtonHref = 'home.html'
    app.adminService = true
}

// 获取页面初始化数据：需要重写initPageData(model)
function getPageDataService(page) {
    axios.get("/YuKaMusicCity/" + page)
    .then(response => {
        initPageData(response.data)
    })
    .catch(error => {
        // 页面渲染失败，需要跳出提示信息
    })
}

// 解析地址栏中的参数（name=key）
function getUrlParam(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)")
    let value = window.location.search.substr(1).match(reg)
    if (value != null) {
        return unescape(value[2])
    }
    return null
}

// 通过图片对象获取本地地址
function getImg(file) {
    let url = ''
    if (window.createObjectURL !== undefined) {
      url = window.createObjectURL(file)
    } else if (window.URL !== undefined) {
      url = window.URL.createObjectURL(file)
    } else if (window.webkitURL !== undefined) {
      url = window.webkitURL.createObjectURL(file)
    }
    return url
}

// 时间戳转日期
function formatDate(date) {
    if(date == null) {
        return null
    }
    let dateObj = new Date(date)
    let YY = dateObj.getFullYear() + '-'
    let MM = (dateObj.getMonth() + 1 < 10 ? '0' + (dateObj.getMonth() + 1) : dateObj.getMonth() + 1) + '-'
    let DD = (dateObj.getDate() < 10 ? '0' + (dateObj.getDate()) : dateObj.getDate())
    return YY + MM + DD
}

// 搜索请求方法
function searchRequestFun() {
    axios.request({
        url: '/YuKaMusicCity/search',
        params: {
            word: app.searchValue,
            resultCount: 6,
        },
    })
    .then(response => {
        app.searchResponse = response.data
    })
    .catch(error => {
        console.log("搜索请求失败" + error)
    })
}


// 初始化背景主题
function initBackgroundFun(model) {
    if(getBackgroundCookie() === "black") {
        model.backgroundBox = 'background-max'
        model.bgNav = 'navbar-inverse'
        model.bgLeaderBoard = ''
        model.bgTail = 'background-tail'
        model.bgError = 'background-max'
        model.backgroundStatus = 'black'
    }
}

// 修改变化背景主题
function backgroundSwitchFun(model) {
    if(model.backgroundStatus === "black") {
        model.backgroundBox = ''
        model.bgNav = 'navbar-default'
        model.bgLeaderBoard = 'table-striped'
        model.bgTail = ''
        model.bgError = ''
        setBackgroundCookie("white")
        model.backgroundStatus = "white"
    } else if(model.backgroundStatus === "white") {
        model.backgroundBox = 'background-max'
        model.bgNav = 'navbar-inverse'
        model.bgLeaderBoard = ''
        model.bgTail = 'background-tail'
        model.bgError = 'background-max'
        setBackgroundCookie("black")
        model.backgroundStatus = "black"
    }
}

