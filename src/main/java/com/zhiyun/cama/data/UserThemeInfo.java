/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

import java.io.Serializable;

public class UserThemeInfo
implements Serializable {
    private String sn;
    private int themeValue;
    private int userId;

    public UserThemeInfo(String string2, int n10, int n11) {
        this.sn = string2;
        this.userId = n10;
        this.themeValue = n11;
    }

    public String getSn() {
        return this.sn;
    }

    public int getThemeValue() {
        return this.themeValue;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setSn(String string2) {
        this.sn = string2;
    }

    public void setThemeValue(int n10) {
        this.themeValue = n10;
    }

    public void setUserId(int n10) {
        this.userId = n10;
    }
}

