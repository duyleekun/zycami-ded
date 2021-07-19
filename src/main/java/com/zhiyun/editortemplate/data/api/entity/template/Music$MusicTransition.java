/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

public class Music$MusicTransition {
    private long endTime;
    private float endVolume;
    private long startTime;
    private float startVolume;

    public Music$MusicTransition(long l10, long l11, float f10, float f11) {
        this.startTime = l10;
        this.endTime = l11;
        this.startVolume = f10;
        this.endVolume = f11;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public float getEndVolume() {
        return this.endVolume;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public float getStartVolume() {
        return this.startVolume;
    }

    public void setEndTime(long l10) {
        this.endTime = l10;
    }

    public void setEndVolume(float f10) {
        this.endVolume = f10;
    }

    public void setStartTime(long l10) {
        this.startTime = l10;
    }

    public void setStartVolume(float f10) {
        this.startVolume = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MusicTransition{startTime=");
        long l10 = this.startTime;
        stringBuilder.append(l10);
        stringBuilder.append(", endTime=");
        l10 = this.endTime;
        stringBuilder.append(l10);
        stringBuilder.append(", startVolume=");
        float f10 = this.startVolume;
        stringBuilder.append(f10);
        stringBuilder.append(", endVolume=");
        f10 = this.endVolume;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

