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

        
        // 当前歌曲页面编号
        pageMusicId: 0,
        // 歌曲信息初始化数据
        songMessage: '',
        // 评论初始化数据
        comment: [],
        // 评论分页模型初始化数据
        paginationInfo: '',
        // 用户评论点赞点踩数据
        UserCommentAoInfo: '',

        // 用户歌单数据
        userMusicListDate: [],

        // 评论表单：文本框
        commentText: '',
        // 评论输入字数
        commentFontCount: 140,
        // 当前评论页码
        commentPageItemCount: 1,


    },

    methods: {
        // 背景变换按钮
        backgroundSwitch: function() { backgroundSwitchFun(this) },
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
        // 用户歌单收藏按钮
        userCollectButton: function() {
            userCollect(this)
        },
        // 添加音乐收藏按钮
        userCollectMusicButton: function(listId) {
            userCollectMusic(this, listId)
        },
        // 歌曲下载按钮
        musicDownloadButton: function() {
            musicDownload(this.pageMusicId)
        },
        // 评论发表按钮
        commentPublishButton: function() {
            commentPublish(this)
        },
        // 评论点赞-取消按钮
        commentUpvoteButton: function(isUpvote, index, id) {
            if(this.userName == "登录") {
                window.location.href = "/YuKaMusicCity/main/html/myError.html"
            }
            if(isUpvote) {
                userCommentAoAdd(id, 1, index, this)
            } else {
                userCommentAoCancel(id, 1, index, this)
            }
            this.$forceUpdate()
        },
        // 评论点踩-取消按钮
        commentOpposeButton: function(isOppose, index, id) {
            if(this.userName == "登录") {
                window.location.href = "/YuKaMusicCity/main/html/myError.html"
            }
            if(isOppose) {
                userCommentAoAdd(id, 2, index, this)
            } else {
                userCommentAoCancel(id, 2, index, this)
            }
            this.$forceUpdate()
        },
        // 分页资源获取
        commentPaginationButton: function(pageNo) {
            if(pageNo == this.commentPageItemCount) {
                return
            }
            commentPagination(pageNo, 1, this)
            this.commentPageItemCount = pageNo
            this.$forceUpdate()
            $('html, body').animate({scrollTop: $('#commentFirst').offset().top}, 1000)
        },

    },
    created: function() {
        this.pageMusicId = getUrlParam("id")
        initBackgroundFun(this)
        getUserNameService()
        getPageDataService("songView/" + this.pageMusicId)
    },

    watch: {
        commentText: function() {
            let textSize = this.commentText.length
            if(textSize >= 140) {
                this.commentText = String(this.commentText).slice(0, 140);
            }
            this.commentFontCount = 140 - textSize
        },
        // 用户服务评论点赞点踩状态获取
        comment: function() {
            if( this.userName == "登录") {
                return
            }
            getUserCommentAO(this)   // AO:awesome,oppose
        }
        
    },

})

// 初始化页面渲染
function initPageData(data) {
    app.songMessage = data.songMessage
    app.comment = data.comment
    app.paginationInfo = data.paginationInfo
}

// 用户歌单收藏服务
function userCollect(model) {
    // 无用户服务时直接跳转至myerror页面
    if(model.userName == "登录") {
        window.location.href = "/YuKaMusicCity/main/html/myError.html"
    }
    // 缓存时防止重复发起请求
    if(model.userMusicListDate != 0) {
        return
    }
    // 回显用户歌单
    axios.request({
        url: '/YuKaMusicCity/user/findUserMusicList',
        params: {
            musicId: model.pageMusicId,
        },
    })
    .then(response => {
        model.userMusicListDate = response.data
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 添加音乐收藏服务
function userCollectMusic(model, listId) {
    axios.request({
        url: '/YuKaMusicCity/user/addMusicCollect',
        method: 'post',
        params: {
            musicId: model.pageMusicId,
            listId: listId,
        },
    })
    .then(response => {
        if(response.data == "200") {
            for(let i = 0;i < model.userMusicListDate.length;i++) {
                if(model.userMusicListDate[i].id == listId) {
                    model.userMusicListDate[i].hasMusic = true
                    break
                }
            }
        }
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 歌曲下载服务
function musicDownload(id) {
    axios.get("/YuKaMusicCity/musicDownload/" + id)
    .then(response => {
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}





// 评论发表服务
function commentPublish(model) {
    // 无用户服务时直接跳转至myerror页面
    if(model.userName == "登录") {
        window.location.href = "/YuKaMusicCity/main/html/myError.html"
    }
    axios.request({
        url: '/YuKaMusicCity/user/addComment',
        method: 'post',
        params: {
            id: model.pageMusicId,
            type: 1,
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
            commentPagination(lastPageCount, 1, model)
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
