/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sms;

public class AVCaptchaDigest {
    private String captchaToken;
    private String captchaUrl;

    public String getCaptchaToken() {
        return this.captchaToken;
    }

    public String getCaptchaUrl() {
        return this.captchaUrl;
    }

    public void setCaptchaToken(String string2) {
        this.captchaToken = string2;
    }

    public void setCaptchaUrl(String string2) {
        this.captchaUrl = string2;
    }
}

