package com.tracejp.yuka.dao;

import com.tracejp.yuka.model.dao.UpdateBasicInformationDAO;
import com.tracejp.yuka.model.dao.UpdateUserPrivacyDAO;
import org.apache.ibatis.annotations.Param;

/*********************************
 * @author traceJP
 *********************************/
public interface UpdateViewPageMapper {

    /**
     * 通过uid查询user_info表的全部信息以对应update页面
     * @param uid uid
     * @return UpdateBasicInformationDAO
     */
    UpdateBasicInformationDAO selectUserInfo(@Param("uid") String uid);

    /**
     * 通过uid查询user表的用户基本隐私信息（不包括密码）
     * @param uid uid
     * @return UpdateUserPrivacyDAO
     */
    UpdateUserPrivacyDAO selectUserPrivacy(@Param("uid") String uid);

}
