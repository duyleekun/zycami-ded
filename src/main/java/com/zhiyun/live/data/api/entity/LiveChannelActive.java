/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

public class LiveChannelActive {
    private boolean active;

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean bl2) {
        this.active = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Active{active=");
        boolean bl2 = this.active;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

