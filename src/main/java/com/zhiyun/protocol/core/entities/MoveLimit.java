/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import d.v.y.d.i;

public class MoveLimit {
    public i pitch;
    public i roll;
    public i yaw;

    public MoveLimit() {
        Object object = -90;
        Integer n10 = 90;
        this.pitch = object = i.d((Comparable)object, n10);
        object = -45;
        n10 = 45;
        this.roll = object = i.d((Comparable)object, n10);
        object = -180;
        n10 = 180;
        this.yaw = object = i.d((Comparable)object, n10);
    }

    public MoveLimit(i i10, i i11, i i12) {
        Object object = -90;
        Integer n10 = 90;
        this.pitch = object = i.d((Comparable)object, n10);
        object = -45;
        n10 = 45;
        this.roll = object = i.d((Comparable)object, n10);
        object = -180;
        n10 = 180;
        this.yaw = object = i.d((Comparable)object, n10);
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

