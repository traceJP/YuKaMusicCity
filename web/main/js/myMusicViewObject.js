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

        // 用户创建的歌单信息初始化数据
        userCreateList: [],
        // 用户收藏的歌单信息初始化数据
        userFavoritesList: [],
        
        // 当前歌曲页面编号
        pageMusicId: 0,
        // 歌单状态：0用户未登录-1用户歌单-2其他用户歌单（已收藏）-3其他用户歌单（未收藏）
        pageMusicStatus: 0,
        // 歌单信息初始化数据
        listMessage: '',
        // 歌单列表信息初始化数据
        musicList: [],
        // 歌曲个数信息
        musicCount: '',

        // 评论初始化数据
        comment: [],
        // 评论分页模型初始化数据
        paginationInfo: '',
        // 用户评论点赞点踩数据
        UserCommentAoInfo: '',

        // 评论表单：文本框
        commentText: '',
        // 评论输入字数
        commentFontCount: 140,
        // 当前评论页码
        commentPageItemCount: 1,

        // 创建歌单表单参数
        createListFileImg: '',
        createListFileImgName: '',
        createListName: '',
        createListType: '',
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
            userCollectMusicList(this)
        },
        // 歌单下载按钮
        musicListDownloadButton: function() {
            musicListDownload(this.pageMusicId)
        },
        // 单曲下载按钮
        musicDownloadButton: function(id) {
            musicDownload(id)
        },
        // 音乐删除按钮
        musicDeleteButton: function() {
            userCancelCollectList(id, this)
        },
        // 评论发表按钮
        commentPublishButton: function() {
            commentPublish(2, this)
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

        // 歌单页面资源请求服务
        pageMusicListRouter: function(id) {
            pageMusicListAxios(id, this)
        },

        // 文件上传绑定
        getFile: function(event) {
            this.createListFileImg = event.target.files[0];
        },
        // 创建歌单确认按钮
        createListButton: function() {
            // 触发检查
            $("#formCreateList").data("bootstrapValidator").validate();
            let flag =  $("#formCreateList").data("bootstrapValidator").isValid();
            if(!flag) {
                return
            }
            createUserMusicList(this)
        },

    },
    created: function() {
        initBackgroundFun(this)
        getUserNameService()
        getPageDataService("user/myMusicView")
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
        },
        pageMusicId: function() {
            if(this.adminService) {
                initIsUserCreateMusicList(this.pageMusicId)
            }
        }
    },

})

// 初始化页面渲染
function initPageData(data) {
    app.userCreateList = data.create
    app.userFavoritesList = data.favorites
    app.listMessage = data.listVO.message
    app.musicList = data.listVO.musicList
    app.musicCount = data.listVO.musicCount
    app.comment = data.listVO.comment
    app.paginationInfo = data.listVO.paginationInfo
    app.pageMusicId = data.listVO.message.id
}

// 用户歌单页面资源请求服务
function pageMusicListAxios(id, model) {
    if(id == model.pageMusicId) {
        return
    }
    axios.get("/YuKaMusicCity/playlistView/" + id)
    .then(response => {
        model.listMessage = response.data.message
        model.musicList = response.data.musicList
        model.musicCount = response.data.musicCount
        model.comment = response.data.comment
        model.paginationInfo = response.data.paginationInfo
        // 修改当前歌单id
        model.pageMusicId = response.data.message.id
    })
    .catch(error => {
        console.log("请求失败" + error)
    })
}

// 创建歌单
function createUserMusicList(model) {
    let forms = new FormData()
    forms.append("fileImg", model.createListFileImg)
    forms.append("listName", model.createListName)
    forms.append("listType", model.createListType)
    axios.post("/YuKaMusicCity/user/addMusicList", forms, {
        headers: {
            "Content-Type": "multipart/form-data"
        },
    })
    .then(response => {
        if(response.data == "200") {
            // 创建成功
            // 1 后端返回创建成功的歌单自增唯一标识
            // 2 通过该标识调用资源请求服务
            model.createListFileImg = ""
            model.createListFileImgName = ""
            model.createListName = ""
            model.createListType = ""
            $("#formCreateList").data("bootstrapValidator").resetForm()
            $("#createList").modal('hide')
        }
    })
    .catch(error => {
        console.log("接口请求失败" + error)
    })
}

// 表单验证注册
$(document).ready(function() {
    $('#formCreateList').bootstrapValidator();
});