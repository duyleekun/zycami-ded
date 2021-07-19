/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sms;

public class AVCaptchaValidateResult {
    private String validateToken;

    public String getToken() {
        return this.getValidateToken();
    }

    public String getValidateToken() {
        return this.validateToken;
    }

    public void setToken(String string2) {
        this.setValidateToken(string2);
    }

    public void setValidateToken(String string2) {
        this.validateToken = string2;
    }
}

