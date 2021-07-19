/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

public class Preset$Row {
    public int control;
    public float dead;
    public int follow;
    public int smooth;

    public Preset$Row() {
    }

    public Preset$Row(int n10, int n11, int n12, float f10) {
        this.follow = n10;
        this.control = n11;
        this.smooth = n12;
        this.dead = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Row{follow=");
        int n10 = this.follow;
        stringBuilder.append(n10);
        stringBuilder.append(", control=");
        n10 = this.control;
        stringBuilder.append(n10);
        stringBuilder.append(", smooth=");
        n10 = this.smooth;
        stringBuilder.append(n10);
        stringBuilder.append(", dead=");
        float f10 = this.dead;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

