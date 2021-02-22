// 初始化歌单状态：是否是用户创建的歌单 -> 是则转化为状态1
function initIsUserCreateMusicList(id) {
    axios.get("/YuKaMusicCity/user/isUserCreateList/" + id)
    .then(response => {
        if(response.data == true) {
            app.pageMusicStatus = 1
        } else {
            initIsUserCollectMusicList(id)
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}
// 初始化歌单状态：是否是用户收藏的歌单 -> 是则转化为状态2，否转化为状态3
function initIsUserCollectMusicList(id) {
    axios.get("/YuKaMusicCity/user/isUserCollectList/" + id)
    .then(response => {
        if(response.data == true) {
            app.pageMusicStatus = 2
        } else {
            app.pageMusicStatus = 3
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 用户歌单收藏按钮
function userCollectMusicList(model) {
    switch(model.pageMusicStatus) {
        // 未登录状态
        case 0 :
            window.location.href = "/YuKaMusicCity/main/html/myError.html"
            break
        // 是用户创建的歌单状态
        case 1 :
            return
        // 是用户收藏的状态
        case 2 :
            userCancelCollectList(model.pageMusicId, model)
            break
        // 非用户收藏的状态
        case 3 :
            userAddCollectList(model.pageMusicId,model)
            break
    }

}

// 添加歌单收藏
function userAddCollectList(id, model) {
    axios.post("/YuKaMusicCity/user/addMusicListCollect/" + id)
    .then(response => {
        if(response.data == "200") {
            model.pageMusicStatus = 2
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 取消歌单收藏
function userCancelCollectList(id, model) {
    axios.delete("/YuKaMusicCity/user/deleteMusicListCollect/" + id)
    .then(response => {
        if(response.data == "200") {
            model.pageMusicStatus = 3
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 删除歌单中的歌曲服务
function userCancelCollectList(id, model) {
    axios.delete("/YuKaMusicCity/user/deleteMusicListCollect/" + id)
    .then(response => {
        if(response.data == "200") {
            model.pageMusicStatus = 3
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}
