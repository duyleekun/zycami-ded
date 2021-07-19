/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.zhiyun.protocol.utils.Axis;
import com.zhiyun.stabilizer.entities.StoryAxis$Type;

public class StoryAxis {
    public final Axis axis;
    public final StoryAxis$Type type;
    public final long wait;

    public StoryAxis(StoryAxis$Type object, float f10, float f11, float f12, int n10, long l10) {
        this.type = object;
        this.wait = l10;
        super(f10, f11, f12);
        this.axis = object;
        ((Axis)object).setDuration(n10);
    }
}

