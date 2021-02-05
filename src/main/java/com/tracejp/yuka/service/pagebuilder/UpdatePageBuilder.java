package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.model.dao.UpdateBasicInformationDAO;
import com.tracejp.yuka.model.dao.UpdateUserPrivacyDAO;
import com.tracejp.yuka.model.vo.UpdateVO;

/*********************************
 * @author traceJP
 *********************************/
public abstract class UpdatePageBuilder {

    /**
     * 查询当前home页面中uid的资料
     */
    protected String userUid;

    /**
     * update页面个人信息Service
     * 如头像性别等
     */
    protected abstract UpdateBasicInformationDAO basicInformation();

    /**
     * update页面个人隐私信息Service
     * 如邮箱，个人标识等
     */
    protected abstract UpdateUserPrivacyDAO selfIntroduction();

    /**
     * 构建update页面所有返回的数据
     * @param uid uid
     */
    public UpdateVO createUpdateVO(String uid) {
        userUid = uid;
        return new UpdateVO(
                basicInformation(),
                selfIntroduction()
        );
    }

}
