/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.model.beans;

import com.geetest.sdk.GT3ErrorBean;

public class a {
    private String a;
    private String b;
    private long c;
    private String d;
    private String e = "Sensebot";
    private String f = "4.3.3";
    private boolean g = false;

    public String a() {
        return this.a;
    }

    public void a(long l10) {
        this.c = l10;
    }

    public void a(String string2) {
        this.d = string2;
    }

    public void a(boolean bl2) {
        this.g = bl2;
    }

    public String b() {
        return this.b;
    }

    public void b(String string2) {
        this.a = string2;
    }

    public void c(String string2) {
        this.b = string2;
    }

    public GT3ErrorBean clone() {
        String string2 = this.a;
        String string3 = this.b;
        long l10 = this.c;
        String string4 = this.d;
        String string5 = this.e;
        String string6 = this.f;
        GT3ErrorBean gT3ErrorBean = new GT3ErrorBean(string2, string3, l10, string4, string5, string6);
        boolean bl2 = this.g;
        gT3ErrorBean.setChangeDesc(bl2);
        return gT3ErrorBean;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ErrorBean{errorCode='");
        String string2 = this.a;
        stringBuilder.append(string2);
        char bl2 = '\'';
        stringBuilder.append(bl2);
        stringBuilder.append(", errorDesc='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", duration=");
        long l10 = this.c;
        stringBuilder.append(l10);
        stringBuilder.append(", challenge='");
        string3 = this.d;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", type='");
        string3 = this.e;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", sdkVersion='");
        string3 = this.f;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", isChangeDesc=");
        boolean bl3 = this.g;
        stringBuilder.append(bl3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

