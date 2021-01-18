package com.tracejp.yuka.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/*********************************
 * @author traceJP
 *********************************/
@Repository
public interface UserTableDao {

    /**
     * 向User表中添加一条完整的记录
     * @param param
     */
    void addUserRecord(Map<String, Object> param);

    /**
     * 查询User表中是否有对应的email记录
     * @param email
     * @return 返回对应的email
     */
    String selectUserEmail(String email);

}
