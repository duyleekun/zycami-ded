/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

public class StoryAttribute$Precision {
    public int notMove;
    public float value;

    public StoryAttribute$Precision() {
    }

    public StoryAttribute$Precision(float f10, int n10) {
        this.value = f10;
        this.notMove = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{value=");
        float f10 = this.value;
        stringBuilder.append(f10);
        stringBuilder.append(", notMove=");
        int n10 = this.notMove;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

