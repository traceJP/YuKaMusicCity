package com.tracejp.yuka.service;

import com.tracejp.yuka.model.vo.IndexVO;

import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 *********************************/
public interface BaseViewDataService {

    /**
     * 获取用户名服务
     * @param session 通过session获取uid
     * @return 用户名userName
     */
    String getUserName(HttpSession session);

    /**
     * 构建index页面的基本返回数据
     * @return vo视图数据
     */
    IndexVO builderIndexData();

    // TODO: 2021/1/20 根据各个页面所需情况的总构建逻辑返回 根据各个页面的需求制作对应的service对象。

//    void builderHomeData();




}
