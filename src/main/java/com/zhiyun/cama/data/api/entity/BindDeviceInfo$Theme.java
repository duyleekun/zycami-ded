/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.cama.data.api.entity.BindDeviceInfo;

public class BindDeviceInfo$Theme {
    private String label;
    public final /* synthetic */ BindDeviceInfo this$0;
    private int value;

    public BindDeviceInfo$Theme(BindDeviceInfo bindDeviceInfo, String string2, int n10) {
        this.this$0 = bindDeviceInfo;
        this.label = string2;
        this.value = n10;
    }

    public String getLabel() {
        return this.label;
    }

    public int getValue() {
        return this.value;
    }

    public void setLabel(String string2) {
        this.label = string2;
    }

    public void setValue(int n10) {
        this.value = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Theme{label='");
        String string2 = this.label;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", value=");
        int n10 = this.value;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

