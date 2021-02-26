// 评论发表服务
function commentPublish(type, model) {
    // 无用户服务时直接跳转至myerror页面
    if(!model.adminService) {
        window.location.href = "/YuKaMusicCity/main/html/myError.html"
    }
    axios.request({
        url: '/YuKaMusicCity/user/addComment',
        method: 'post',
        params: {
            id: model.pageMusicId,
            type: type,
            text: model.commentText,
            musicId: model.pageMusicId,
        },
    })
    .then(response => {
        if(response.data == "200") {
            let lastPageCount = model.paginationInfo.paginationCount
            if(lastPageCount == 0) {
                lastPageCount++
            }
            model.commentText = ""
            model.paginationInfo.commentCount += 1
            commentPagination(lastPageCount, type, model)
            model.commentPageItemCount = lastPageCount
            model.$forceUpdate()
            $('html, body').animate({scrollTop: $('#commentLast').offset().top}, 1000)
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}
// 获取分页数据：传入当前页码，id，type，回显数据date
function commentPagination(pageNo, type, model) {
    axios.request({
        url: '/YuKaMusicCity/getPagination',
        params: {
            pageNumber: pageNo,
            id: model.pageMusicId,
            type: type,
        },
    })
    .then(response => {
        model.comment = response.data
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}
// 用户服务评论点赞点踩状态获取
function getUserCommentAO(model) {
    let listId = []
    for (let i = 0; i < model.comment.length; i++) {
        listId[i] = model.comment[i].id
    }
    axios.get('/YuKaMusicCity/user/initUserComment?commentList=' + listId)
    .then(response => {
        model.UserCommentAoInfo = response.data
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}
// 点赞-点踩按钮 id-评论id type-1为点赞2为点踩 index-评论索引
function userCommentAoAdd(id, type, index, model) {
    if(!model.adminService) {
        window.location.href = "/YuKaMusicCity/main/html/myError.html"
    }
    let intf = ""
    if(type == 1) {
        intf = "/YuKaMusicCity/user/upvoteComment/" + id
    } else if(type == 2) {
        intf = "/YuKaMusicCity/user/opposeComment/" + id
    }
    axios.post(intf)
    .then(response => {
        if(response.data == "200") {
            if(type == 1) {
                if(model.UserCommentAoInfo[index] == 2) {
                    model.comment[index].commentOppose--
                }
                model.UserCommentAoInfo[index] = 1
                model.comment[index].commentAwesome++
            } else if(type == 2) {
                if(model.UserCommentAoInfo[index] == 1) {
                    model.comment[index].commentAwesome--
                }
                model.UserCommentAoInfo[index] = 2
                model.comment[index].commentOppose++
            }
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 取消点赞-点踩
function userCommentAoCancel(id, type, index, model) {
    if(!model.adminService) {
        window.location.href = "/YuKaMusicCity/main/html/myError.html"
    }
    let intf = ""
    if(type == 1) {
        intf = "/YuKaMusicCity/user/upvoteCancel/" + id
    } else if(type == 2) {
        intf = "/YuKaMusicCity/user/opposeCancel/" + id
    }
    axios.delete(intf)
    .then(response => {
        if(response.data == "200") {
            if(type == 1) {
                model.UserCommentAoInfo[index] = null
                model.comment[index].commentAwesome--
            } else if(type == 2) {
                model.UserCommentAoInfo[index] = null
                model.comment[index].commentOppose--
            }
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 歌曲下载服务
function musicDownload(id) {
    window.location.href = "/YuKaMusicCity/musicDownload/" + id
}

// 歌单下载服务
function musicListDownload(id) {
    window.location.href = "/YuKaMusicCity/listDownload/" + id
}
