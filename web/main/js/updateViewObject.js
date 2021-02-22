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

        // 用户基本信息初始化数据
        basic: '',
        // 用户标识信息初始化数据
        privacy: '',

        // 输入框绑定值
        serviceOk: false,
        updateName: '',
        updateEmail: '',
        oldPassword: '',
        oldPasswordError: false,
        updatePassword: '',
        updatePassword2: '',
        updateSex: '',
        updateBirthday: '',
        updateArea: '',
        updateIntroduction: '',
        updateAvatarFile: '',
        updateAvatarFileName: '',
        avatarFileSchedule: {width : "0%"},
    },

    methods: {
        // 背景变换按钮
        backgroundSwitch: function() { backgroundSwitchFun(this) },
        // 搜索跳转+回显
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
        // bootStrap弹出框注册
        bootStrapWindow: function() {
            $("#uidWindow").popover("show")
        },
        // 修改请求按钮
        updateAxiosButton: function(item) {
            switch(item) {
                case "name" :
                    updateAxiosUserName()
                    break
                case "email" :
                    updateAxiosUserEmail()
                    break
                case "password" :
                    updateAxiosUserPassword()
                    break    
                case "sex" :
                    updateAxiosUserSex()
                    break
                case "birthday" :       
                    updateAxiosUserBirthday()
                    break
                case "area" :
                    updateAxiosUserArea()
                    break
                case "introduction" :
                    updateAxiosIntroduction()  
                    break 
                case "avatar" :
                    updateAxiosUserAvatar()
                    break    
            }
        },
        // 文件上传绑定
        getFile: function(event) {
            this.updateAvatarFile = event.target.files[0];
        },

        // 退出登录按钮
        exitLogin: function() {
            exitSessionLogin()
        }

    },
    created: function() {
        initBackgroundFun(this)
        getUserNameService()
        getPageDataService("user/updateView")
    }
})

// 初始化页面渲染
function initPageData(data) {
    app.basic = data.basic
    app.privacy = data.privacy
    app.basic.userBirthday = formatDate(data.basic.userBirthday)
}

// 退出登录请求
function exitSessionLogin() {
    axios.delete("/YuKaMusicCity/user/loginOut")
    .then(response => {
        if(response.data == "200") {
            // 退出成功重定向至index页面
            window.location.replace("/YuKaMusicCity/main/html/index.html")
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户名
function updateAxiosUserName() {
    $("#formNickName").data("bootstrapValidator").validate();
    let flag =  $("#formNickName").data("bootstrapValidator").isValid();
    if(flag == false) {
        return;
    }
    axios.request({
        url: "/YuKaMusicCity/user/updateName",
        method: 'put',
        params: {
            newName: app.updateName,
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 修改成功
            app.basic.userName = app.updateName
            app.updateName = ""
            app.serviceOk = true
            $("#formNickName").data("bootstrapValidator").resetForm()
            $("#nickname").modal('hide')
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户邮箱
function updateAxiosUserEmail() {
    $("#formEmail").data("bootstrapValidator").validate();
    let flag =  $("#formEmail").data("bootstrapValidator").isValid();
    if(flag == false) {
        return;
    }
    axios.request({
        url: "/YuKaMusicCity/user/updateEmail",
        method: 'put',
        params: {
            newEmail: app.updateEmail,
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 修改成功
            app.privacy.userEmail = app.updateEmail
            app.updateEmail = ""
            app.serviceOk = true
            $("#formEmail").data("bootstrapValidator").resetForm()
            $("#email").modal('hide')
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户密码
function updateAxiosUserPassword() {
    $("#formPassword").data("bootstrapValidator").validate();
    let flag =  $("#formPassword").data("bootstrapValidator").isValid();
    if(flag == false) {
        return;
    }
    axios.request({
        url: "/YuKaMusicCity/user/updatePassword",
        method: 'put',
        params: {
            oldPassword: app.oldPassword,
            newPassword: app.updatePassword,
        },
    })
    .then(response => {
        app.oldPassword = ""
        app.updatePassword = ""
        app.updatePassword2 = ""
        $("#formPassword").data("bootstrapValidator").resetForm()
        $("#password").modal('hide')
        if(response.data == "200") {
            // 修改成功
            app.serviceOk = true
        } else if(response.data == "404") {
            // 旧密码错误
            app.oldPasswordError = true
            $("#password").modal('hide')
            setTimeout(() =>{
                app.oldPasswordError = false
            },3000);
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户性别
function updateAxiosUserSex() {
    axios.request({
        url: "/YuKaMusicCity/user/updateSex",
        method: 'put',
        params: {
            newSex: app.updateSex,
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 修改成功
            app.basic.userSex = app.updateSex
            app.updateSex = ""
            app.serviceOk = true
            $("#sex").modal('hide')
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户生日
function updateAxiosUserBirthday() {
    axios.request({
        url: "/YuKaMusicCity/user/updateBirthday",
        method: 'put',
        params: {
            newBirthday: app.updateBirthday,
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 修改成功
            app.basic.userBirthday = app.updateBirthday
            app.updateBirthday = ""
            app.serviceOk = true
            $("#birthday").modal('hide')
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户地区
function updateAxiosUserArea() {
    $("#formArea").data("bootstrapValidator").validate();
    let flag =  $("#formArea").data("bootstrapValidator").isValid();
    if(flag == false) {
        return;
    }
    axios.request({
        url: "/YuKaMusicCity/user/updateArea",
        method: 'put',
        params: {
            newArea: app.updateArea,
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 修改成功
            app.basic.userArea = app.updateArea
            app.updateArea = ""
            app.serviceOk = true
            $("#formArea").data("bootstrapValidator").resetForm()
            $("#area").modal('hide')
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户个人简介
function updateAxiosIntroduction() {
    axios.request({
        url: "/YuKaMusicCity/user/updateIntroduction",
        method: 'put',
        params: {
            newIntroduction: app.updateIntroduction,
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 修改成功
            app.basic.userIntroduction = app.updateIntroduction
            app.updateIntroduction = ""
            app.serviceOk = true
            $("#introduction").modal('hide')
        } else {
            alert("服务器出现未知错误-400")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 修改用户头像
function updateAxiosUserAvatar() {
    let forms = new FormData()
    forms.append("newAvatarFile", app.updateAvatarFile)
    axios.post("/YuKaMusicCity/user/updateAvatar", forms, {
        headers: {
            "Content-Type": "multipart/form-data"
        },
        onUploadProgress: function(progressEvent) {
            app.avatarFileSchedule.width = ((progressEvent.loaded / progressEvent.total) * 100) + "%"
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 修改成功：直接回显本地图片
            app.serviceOk = true
            app.basic.userAvatarImgUrl = getImg(app.updateAvatarFile)
            setTimeout(() =>{
                app.updateAvatarFileName = ""
                app.updateAvatarFile = ""
                app.avatarFileSchedule.width = "0%"
                $("#avatar").modal('hide')
            },3000);
        } else {
            alert("您已经上传过了头像~\n请勿重新上传")
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}


// 表单验证注册
$(document).ready(function() {
    $('#formNickName').bootstrapValidator();
    $('#formEmail').bootstrapValidator();
    $('#formPassword').bootstrapValidator();
    $('#formArea').bootstrapValidator();
});
