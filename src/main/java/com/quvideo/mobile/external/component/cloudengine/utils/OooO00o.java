/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.utils;

public class OooO00o {
    private String OooO00o;
    private String OooO0O0;
    private String OooO0OO;

    public OooO00o(String string2, String string3, String string4) {
        this.OooO00o = string2;
        this.OooO0O0 = string3;
        this.OooO0OO = string4;
    }

    public String OooO00o() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.OooO00o;
        stringBuilder.append(string2);
        stringBuilder.append("_");
        string2 = this.OooO0OO;
        stringBuilder.append(string2);
        stringBuilder.append("_1");
        return stringBuilder.toString();
    }

    public String OooO0O0() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.OooO00o;
        stringBuilder.append(string2);
        stringBuilder.append("_");
        string2 = this.OooO0OO;
        stringBuilder.append(string2);
        stringBuilder.append("_1");
        string2 = this.OooO0O0;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

