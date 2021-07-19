/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.zhiyun.protocol.core.entities.StoryAttribute$Precision;

public class StoryAttribute {
    public boolean duration;
    public boolean notify;
    public StoryAttribute$Precision pitch;
    public StoryAttribute$Precision roll;
    public StoryAttribute$Precision yaw;

    public StoryAttribute() {
    }

    public StoryAttribute(boolean bl2, boolean bl3, StoryAttribute$Precision storyAttribute$Precision, StoryAttribute$Precision storyAttribute$Precision2, StoryAttribute$Precision storyAttribute$Precision3) {
        this.notify = bl2;
        this.duration = bl3;
        this.pitch = storyAttribute$Precision;
        this.roll = storyAttribute$Precision2;
        this.yaw = storyAttribute$Precision3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{notify=");
        boolean bl2 = this.notify;
        stringBuilder.append(bl2);
        stringBuilder.append(", duration=");
        bl2 = this.duration;
        stringBuilder.append(bl2);
        stringBuilder.append(", pitch=");
        StoryAttribute$Precision storyAttribute$Precision = this.pitch;
        stringBuilder.append(storyAttribute$Precision);
        stringBuilder.append(", roll=");
        storyAttribute$Precision = this.roll;
        stringBuilder.append(storyAttribute$Precision);
        stringBuilder.append(", yaw=");
        storyAttribute$Precision = this.yaw;
        stringBuilder.append(storyAttribute$Precision);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

