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

        // 用户服务
        adminService: false,
        
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

        // 歌曲总时长
        audioDuration: 0,
        // 是否完整听过
        audioIsPlayMusicComplete: false,

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
        // 用户歌曲收藏按钮
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
            commentPublish(1, this)
        },
        // 评论点赞-取消按钮
        commentUpvoteButton: function(isUpvote, index, id) {
            if(isUpvote) {
                userCommentAoAdd(id, 1, index, this)
            } else {
                userCommentAoCancel(id, 1, index, this)
            }
            this.$forceUpdate()
        },
        // 评论点踩-取消按钮
        commentOpposeButton: function(isOppose, index, id) {
            if(isOppose) {
                userCommentAoAdd(id, 2, index, this)
            } else {
                userCommentAoCancel(id, 2, index, this)
            }
            this.$forceUpdate()
        },
        // 评论时间戳转换为时间方法
        commentDataFormat: function(date) {
            return formatDate(date)
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

        // audio播放
        getDuration() {
            this.audioDuration = this.$refs.audio.duration
        },
        updateTime(e) {
            if(!this.adminService) {
                return
            }
            let record = e.target.currentTime > this.audioDuration * 0.75
            // 如果 当前播放时间>0.75的总时间 并且 未发送过请求 , 则发送请求
            if(!this.audioIsPlayMusicComplete && record) {
                axiosUserSongPlayRecord()
                this.audioIsPlayMusicComplete = true
            // 如果 发送过请求 并且 当前时间=总时间，则重置为未发送过请求
            } else if(this.audioIsPlayMusicComplete && e.target.currentTime == this.audioDuration) {
                this.audioIsPlayMusicComplete = false
            }
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
            if(this.adminService) {
                getUserCommentAO(this)   // AO:awesome,oppose
            }
        }
        
    },

})

// 初始化页面渲染
function initPageData(data) {
    app.songMessage = data.songMessage
    app.comment = data.comment
    app.paginationInfo = data.paginationInfo
}

// 用户歌曲收藏按钮服务
function userCollect(model) {
    // 无用户服务时直接跳转至myerror页面
    if(!model.adminService) {
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


// 用户服务-听歌记录
function axiosUserSongPlayRecord() {
    axios.put("/YuKaMusicCity/user/songPlayRecord/" + app.pageMusicId)
    .then(response => {
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}