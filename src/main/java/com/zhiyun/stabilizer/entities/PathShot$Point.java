/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

public class PathShot$Point {
    private Double focus;
    private Double pitch;
    private Double roll;
    private String type = "point";
    private Double yaw;
    private Double zoom;

    public Double getFocus() {
        return this.focus;
    }

    public Double getPitch() {
        return this.pitch;
    }

    public Double getRoll() {
        return this.roll;
    }

    public Double getYaw() {
        return this.yaw;
    }

    public Double getZoom() {
        return this.zoom;
    }

    public void setFocus(double d10) {
        Double d11;
        this.focus = d11 = Double.valueOf(d10);
    }

    public void setPitch(double d10) {
        Double d11;
        this.pitch = d11 = Double.valueOf(d10);
    }

    public void setRoll(double d10) {
        Double d11;
        this.roll = d11 = Double.valueOf(d10);
    }

    public void setYaw(double d10) {
        Double d11;
        this.yaw = d11 = Double.valueOf(d10);
    }

    public void setZoom(double d10) {
        Double d11;
        this.zoom = d11 = Double.valueOf(d10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Point{type='");
        Object object = this.type;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", pitch=");
        object = this.pitch;
        stringBuilder.append(object);
        stringBuilder.append(", roll=");
        object = this.roll;
        stringBuilder.append(object);
        stringBuilder.append(", yaw=");
        object = this.yaw;
        stringBuilder.append(object);
        stringBuilder.append(", focus=");
        object = this.focus;
        stringBuilder.append(object);
        stringBuilder.append(", zoom=");
        object = this.zoom;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

