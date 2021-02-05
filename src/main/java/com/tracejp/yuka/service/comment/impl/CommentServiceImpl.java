package com.tracejp.yuka.service.comment.impl;

import com.tracejp.yuka.dao.CommentMapper;
import com.tracejp.yuka.model.dao.MusicCommentDAO;
import com.tracejp.yuka.service.comment.PaginationModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 * @author traceJP
 *********************************/

// TODO: 2021/1/31 此类为评论类的总service，还可以继承其他接口，如评论点赞功能等接口

@Service
public class CommentServiceImpl implements PaginationModelService<MusicCommentDAO> {

    /**
     * 前端一页展示的数量
     */
    public static Integer elementReturnCount = 6;

    @Autowired
    CommentMapper commentDAO;

    @Override
    public List<MusicCommentDAO> getPaginationService(Integer pageNumber, Integer id, Integer type) {
        // 传入pageNumber参数不可以大于总页数
        int elementCount = getElementCount(id, type);
        if(pageNumber > elementCount) {
            return null;
        }
        int pageBegin = getElementBegin(pageNumber);
        List<MusicCommentDAO> list = commentDAO.selectCommentElement(id, type, pageBegin, elementReturnCount);
        return list;
    }

    @Override
    public Integer getElementCount(Integer id, Integer type) {
        return commentDAO.selectCommentCount(id, type);
    }

    @Override
    public Integer getPaginationCount(Integer elementCount) {
        int ans = elementCount / elementReturnCount;
        if(elementCount % elementReturnCount > 0) {
            ans++;
        }
        return ans;
    }

    @Override
    public Integer getElementBegin(Integer pageNo) {
        return (pageNo - 1) * elementReturnCount;
    }

}
