/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public class GT3ErrorBean {
    public String challenge;
    public long duration;
    public String errorCode;
    public String errorDesc;
    private boolean isChangeDesc = false;
    public String sdkVersion;
    public String type;

    public GT3ErrorBean(String string2, String string3, long l10, String string4, String string5, String string6) {
        this.errorCode = string2;
        this.errorDesc = string3;
        this.duration = l10;
        this.challenge = string4;
        this.type = string5;
        this.sdkVersion = string6;
    }

    public boolean isChangeDesc() {
        return this.isChangeDesc;
    }

    public void setChangeDesc(boolean bl2) {
        this.isChangeDesc = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GT3ErrorBean{errorCode='");
        String string2 = this.errorCode;
        stringBuilder.append(string2);
        char bl2 = '\'';
        stringBuilder.append(bl2);
        stringBuilder.append(", errorDesc='");
        String string3 = this.errorDesc;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", duration=");
        long l10 = this.duration;
        stringBuilder.append(l10);
        stringBuilder.append(", challenge='");
        string3 = this.challenge;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", type='");
        string3 = this.type;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", sdkVersion='");
        string3 = this.sdkVersion;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", isChangeDesc=");
        boolean bl3 = this.isChangeDesc;
        stringBuilder.append(bl3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

