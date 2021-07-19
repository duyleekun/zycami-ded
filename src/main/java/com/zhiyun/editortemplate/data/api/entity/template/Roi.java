/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.Roi$RoiInfo;

public class Roi {
    private long duration;
    private boolean enable;
    private Roi$RoiInfo end;
    private Roi$RoiInfo start;

    public Roi(boolean bl2, long l10, Roi$RoiInfo roi$RoiInfo, Roi$RoiInfo roi$RoiInfo2) {
        this.enable = bl2;
        this.duration = l10;
        this.start = roi$RoiInfo;
        this.end = roi$RoiInfo2;
    }

    public long getDuration() {
        return this.duration;
    }

    public Roi$RoiInfo getEnd() {
        return this.end;
    }

    public Roi$RoiInfo getStart() {
        return this.start;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setEnable(boolean bl2) {
        this.enable = bl2;
    }

    public void setEnd(Roi$RoiInfo roi$RoiInfo) {
        this.end = roi$RoiInfo;
    }

    public void setStart(Roi$RoiInfo roi$RoiInfo) {
        this.start = roi$RoiInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Roi{enable=");
        boolean bl2 = this.enable;
        stringBuilder.append(bl2);
        stringBuilder.append(", start=");
        Roi$RoiInfo roi$RoiInfo = this.start;
        stringBuilder.append(roi$RoiInfo);
        stringBuilder.append(", end=");
        roi$RoiInfo = this.end;
        stringBuilder.append(roi$RoiInfo);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

