package com.tracejp.yuka.model.dto;

/*********************************
 * @author traceJP
 *
 * 前端使用注册服务传递参数的JavaBean
 *********************************/
public class RegisteredParameterDTO {

    private String userName;
    private String email;
    private String password;

    public RegisteredParameterDTO() {
    }

    public RegisteredParameterDTO(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisteredParameterObject{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
