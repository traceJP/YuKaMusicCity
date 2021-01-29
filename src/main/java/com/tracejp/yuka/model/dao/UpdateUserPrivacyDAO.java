package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class UpdateUserPrivacyDAO {

    private String userUid;
    private String userEmail;

    public UpdateUserPrivacyDAO() {
    }

    public UpdateUserPrivacyDAO(String userUid, String userEmail) {
        this.userUid = userUid;
        this.userEmail = userEmail;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "UpdateUserPrivacyDAO{" +
                "userUid='" + userUid + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

}
