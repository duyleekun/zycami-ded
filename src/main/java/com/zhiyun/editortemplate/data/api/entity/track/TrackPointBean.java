/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.track;

import com.zhiyun.editortemplate.data.api.entity.track.TrackFocus;

public class TrackPointBean {
    private long duration;
    private TrackFocus focus;
    private String func = "instant";
    private String orientation = "horizontal";
    private Float pitch;
    private Float roll;
    private String type;
    private Float yaw;
    private TrackFocus zoom;

    public long getDuration() {
        return this.duration;
    }

    public TrackFocus getFocus() {
        return this.focus;
    }

    public String getFunc() {
        return this.func;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public Float getPitch() {
        return this.pitch;
    }

    public Float getRoll() {
        return this.roll;
    }

    public String getType() {
        return this.type;
    }

    public Float getYaw() {
        return this.yaw;
    }

    public TrackFocus getZoom() {
        return this.zoom;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public TrackPointBean setFocus(TrackFocus trackFocus) {
        this.focus = trackFocus;
        return this;
    }

    public void setFunc(String string2) {
        this.func = string2;
    }

    public void setOrientation(String string2) {
        this.orientation = string2;
    }

    public void setPitch(Float f10) {
        this.pitch = f10;
    }

    public void setRoll(Float f10) {
        this.roll = f10;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public void setYaw(Float f10) {
        this.yaw = f10;
    }

    public TrackPointBean setZoom(TrackFocus trackFocus) {
        this.zoom = trackFocus;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Track{type='");
        String string2 = this.type;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", duration=");
        long l10 = this.duration;
        stringBuilder.append(l10);
        stringBuilder.append(", yaw=");
        Object object = this.yaw;
        stringBuilder.append(object);
        stringBuilder.append(", pitch=");
        object = this.pitch;
        stringBuilder.append(object);
        stringBuilder.append(", roll=");
        object = this.roll;
        stringBuilder.append(object);
        stringBuilder.append(", focus=");
        object = this.focus;
        stringBuilder.append(object);
        stringBuilder.append(", zoom=");
        object = this.zoom;
        stringBuilder.append(object);
        stringBuilder.append(", orientation='");
        object = this.orientation;
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append(", func='");
        object = this.func;
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

