/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.zhiyun.protocol.core.entities.Preset$Row;

public class Preset {
    public Preset$Row pitch;
    public Preset$Row roll;
    public Preset$Row yaw;

    public Preset() {
    }

    public Preset(Preset$Row preset$Row, Preset$Row preset$Row2, Preset$Row preset$Row3) {
        this.pitch = preset$Row;
        this.roll = preset$Row2;
        this.yaw = preset$Row3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{pitch=");
        Preset$Row preset$Row = this.pitch;
        stringBuilder.append(preset$Row);
        stringBuilder.append(", roll=");
        preset$Row = this.roll;
        stringBuilder.append(preset$Row);
        stringBuilder.append(", yaw=");
        preset$Row = this.yaw;
        stringBuilder.append(preset$Row);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

