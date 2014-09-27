/**
 *  
 * 日    期：12-2-29
 */
package com.appleframework.rop.impl;

import com.appleframework.rop.annotation.IgnoreSign;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class CreateUserRequest {

    @Pattern(regexp = "\\w{4,30}")
    private String userName;

    @Valid
    private Addresss address;

    @IgnoreSign
    private String remark;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Addresss getAddress() {
        return address;
    }

    public void setAddress(Addresss address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

