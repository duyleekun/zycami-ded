/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import d.v.y.d.i;

public class PresetLimit$Row {
    public i control;
    public i dead;
    public i follow;
    public i smooth;

    public PresetLimit$Row() {
    }

    public PresetLimit$Row(i i10, i i11, i i12, i i13) {
        this.follow = i10;
        this.control = i11;
        this.smooth = i12;
        this.dead = i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Row{follow=");
        i i10 = this.follow;
        stringBuilder.append(i10);
        stringBuilder.append(", control=");
        i10 = this.control;
        stringBuilder.append(i10);
        stringBuilder.append(", smooth=");
        i10 = this.smooth;
        stringBuilder.append(i10);
        stringBuilder.append(", dead=");
        i10 = this.dead;
        stringBuilder.append(i10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

