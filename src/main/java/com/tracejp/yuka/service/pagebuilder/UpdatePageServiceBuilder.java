package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.dao.UpdateViewPageMapper;
import com.tracejp.yuka.model.dao.UpdateBasicInformationDAO;
import com.tracejp.yuka.model.dao.UpdateUserPrivacyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/*********************************
 * @author traceJP
 *********************************/
@Service
@RequestScope
public class UpdatePageServiceBuilder extends UpdatePageBuilder {

    @Autowired
    UpdateViewPageMapper viewPage;

    @Override
    protected UpdateBasicInformationDAO basicInformation() {
        return viewPage.selectUserInfo(userUid);
    }

    @Override
    protected UpdateUserPrivacyDAO selfIntroduction() {
        return viewPage.selectUserPrivacy(userUid);
    }

}
