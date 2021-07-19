/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.utils;

import java.io.Serializable;
import java.util.Objects;

public final class Axis
implements Serializable {
    public int duration;
    public float pitch;
    public float roll;
    public float yaw;

    public Axis(float f10, float f11, float f12) {
        this.pitch = f10;
        this.roll = f11;
        this.yaw = f12;
    }

    public Axis(float f10, float f11, float f12, int n10) {
        this.pitch = f10;
        this.roll = f11;
        this.yaw = f12;
        this.duration = n10;
    }

    public Axis(Axis axis) {
        int n10;
        float f10;
        this.pitch = f10 = axis.pitch;
        this.roll = f10 = axis.roll;
        this.yaw = f10 = axis.yaw;
        this.duration = n10 = axis.duration;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<Axis> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = Axis.class) == (clazz = object.getClass())) {
            float f10;
            float f11;
            float f12;
            float f13;
            object = (Axis)object;
            float f14 = this.pitch;
            float f15 = ((Axis)object).pitch;
            float f16 = f14 - f15;
            Object object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object2 != false || (object2 = (f13 = (f14 = this.roll) - (f15 = ((Axis)object).roll)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) != false || (f12 = (f11 = (f14 = this.yaw) - (f10 = ((Axis)object).yaw)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        Float f10 = Float.valueOf(this.pitch);
        objectArray[0] = f10;
        f10 = Float.valueOf(this.roll);
        objectArray[1] = f10;
        f10 = Float.valueOf(this.yaw);
        objectArray[2] = f10;
        return Objects.hash(objectArray);
    }

    public final void negate() {
        float f10;
        this.pitch = f10 = -this.pitch;
        this.roll = f10 = -this.roll;
        this.yaw = f10 = -this.yaw;
    }

    public final void set(int n10, int n11, int n12) {
        float f10;
        this.pitch = f10 = (float)n10;
        this.roll = f10 = (float)n11;
        this.yaw = f10 = (float)n12;
    }

    public void setDuration(int n10) {
        this.duration = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Axis{pitch=");
        float f10 = this.pitch;
        stringBuilder.append(f10);
        stringBuilder.append(", roll=");
        f10 = this.roll;
        stringBuilder.append(f10);
        stringBuilder.append(", yaw=");
        f10 = this.yaw;
        stringBuilder.append(f10);
        stringBuilder.append(", duration=");
        int n10 = this.duration;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

