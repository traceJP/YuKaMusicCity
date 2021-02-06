package com.tracejp.yuka.model.vo;

/*********************************
 * @author traceJP
 *********************************/
public class SearchVO {

    private Integer id;
    private String name;
    private Integer type;

    public SearchVO() {
    }

    public SearchVO(Integer id, String name, Integer type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SearchVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
