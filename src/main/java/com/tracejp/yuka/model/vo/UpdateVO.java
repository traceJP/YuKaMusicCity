package com.tracejp.yuka.model.vo;

import com.tracejp.yuka.model.dao.UpdateBasicInformationDAO;
import com.tracejp.yuka.model.dao.UpdateUserPrivacyDAO;

/*********************************
 * @author traceJP
 *********************************/
public class UpdateVO {

    UpdateBasicInformationDAO basic;
    UpdateUserPrivacyDAO privacy;

    public UpdateVO() {
    }

    public UpdateVO(UpdateBasicInformationDAO basic, UpdateUserPrivacyDAO privacy) {
        this.basic = basic;
        this.privacy = privacy;
    }

    public UpdateBasicInformationDAO getBasic() {
        return basic;
    }

    public void setBasic(UpdateBasicInformationDAO basic) {
        this.basic = basic;
    }

    public UpdateUserPrivacyDAO getPrivacy() {
        return privacy;
    }

    public void setPrivacy(UpdateUserPrivacyDAO privacy) {
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        return "UpdateVO{" +
                "basic=" + basic +
                ", privacy=" + privacy +
                '}';
    }

}
