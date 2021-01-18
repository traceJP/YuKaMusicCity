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
