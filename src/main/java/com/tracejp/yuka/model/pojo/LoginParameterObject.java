package com.tracejp.yuka.model.pojo;

/*********************************
 * @author traceJP
 *
 * 登录服务前端参数传递JavaBean
 *********************************/
public class LoginParameterObject {

    private String accountNumber;
    private String password;

    public LoginParameterObject() {
    }

    public LoginParameterObject(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginParameterObject{" +
                "accountNumber='" + accountNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
