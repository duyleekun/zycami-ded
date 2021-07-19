/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.zhiyun.protocol.core.entities.PresetLimit$Row;

public class PresetLimit {
    public PresetLimit$Row pitch;
    public PresetLimit$Row roll;
    public PresetLimit$Row yaw;

    public PresetLimit() {
    }

    public PresetLimit(PresetLimit$Row presetLimit$Row, PresetLimit$Row presetLimit$Row2, PresetLimit$Row presetLimit$Row3) {
        this.pitch = presetLimit$Row;
        this.roll = presetLimit$Row2;
        this.yaw = presetLimit$Row3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{pitch=");
        PresetLimit$Row presetLimit$Row = this.pitch;
        stringBuilder.append(presetLimit$Row);
        stringBuilder.append(", roll=");
        presetLimit$Row = this.roll;
        stringBuilder.append(presetLimit$Row);
        stringBuilder.append(", yaw=");
        presetLimit$Row = this.yaw;
        stringBuilder.append(presetLimit$Row);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

