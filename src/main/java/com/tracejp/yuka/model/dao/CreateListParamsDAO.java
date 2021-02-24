package com.tracejp.yuka.model.dao;

/*********************************
 * @author traceJP
 *********************************/
public class CreateListParamsDAO {

    private Integer id;
    private String uid;
    private String listName;
    private String listType;
    private String localUrl;
    private Boolean isDefault;

    public CreateListParamsDAO() {
    }

    public CreateListParamsDAO(Integer id, String uid, String listName, String listType, String localUrl, Boolean isDefault) {
        this.id = id;
        this.uid = uid;
        this.listName = listName;
        this.listType = listType;
        this.localUrl = localUrl;
        this.isDefault = isDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "CreateListParamsDAO{" +
                "id=" + id +
                ", uid=" + uid +
                ", listName='" + listName + '\'' +
                ", listType='" + listType + '\'' +
                ", localUrl='" + localUrl + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }

}
