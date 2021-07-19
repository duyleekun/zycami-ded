/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.auth.common;

import android.os.Bundle;
import java.io.Serializable;

public abstract class InternalResponse
implements Serializable {
    public static final String RESPONSE_PROP_COMMAND = "kwai_command";
    public static final String RESPONSE_PROP_ERROR_CODE = "kwai_response_error_code";
    public static final String RESPONSE_PROP_ERROR_MSG = "kwai_response_error_msg";
    private static final long serialVersionUID = 5681729302366624547L;
    public String accessToken;
    public String code;
    public String command;
    public int errorCode;
    public String errorMsg;
    public boolean newUser;
    public String state;

    public void fromBundle(Bundle object) {
        String string2;
        int n10;
        this.errorCode = n10 = object.getInt(RESPONSE_PROP_ERROR_CODE);
        this.errorMsg = string2 = object.getString(RESPONSE_PROP_ERROR_MSG);
        object = object.getString(RESPONSE_PROP_COMMAND);
        this.command = object;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getCode() {
        return this.code;
    }

    public String getCommand() {
        return this.command;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getState() {
        return this.state;
    }

    public boolean isNewUser() {
        return this.newUser;
    }

    public abstract boolean isSuccess();

    public void setCommand(String string2) {
        this.command = string2;
    }

    public void setErrorCode(int n10) {
        this.errorCode = n10;
    }

    public void setErrorMsg(String string2) {
        this.errorMsg = string2;
    }

    public void setNewUser(boolean bl2) {
        this.newUser = bl2;
    }

    public void setState(String string2) {
        this.state = string2;
    }
}

