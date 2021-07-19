/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

public class SubAppInfo {
    private String a;

    public SubAppInfo(SubAppInfo object) {
        if (object != null) {
            this.a = object = ((SubAppInfo)object).getSubAppID();
        }
    }

    public SubAppInfo(String string2) {
        this.a = string2;
    }

    public String getSubAppID() {
        return this.a;
    }

    public void setSubAppID(String string2) {
        this.a = string2;
    }
}

