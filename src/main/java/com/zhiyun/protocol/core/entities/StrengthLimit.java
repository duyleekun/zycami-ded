/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import d.v.y.d.i;

public class StrengthLimit {
    public i pitch;
    public i roll;
    public i yaw;

    public StrengthLimit() {
    }

    public StrengthLimit(i i10, i i11, i i12) {
        this.pitch = i10;
        this.roll = i11;
        this.yaw = i12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{pitch=");
        i i10 = this.pitch;
        stringBuilder.append(i10);
        stringBuilder.append(", roll=");
        i10 = this.roll;
        stringBuilder.append(i10);
        stringBuilder.append(", yaw=");
        i10 = this.yaw;
        stringBuilder.append(i10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

