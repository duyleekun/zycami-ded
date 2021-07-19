/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.zhiyun.stabilizer.entities.PathShot$Transition$CaptureType;

public class PathShot$Transition {
    private PathShot$Transition$CaptureType captureType;
    private Integer elapsedTime;
    private Integer exposureTime;
    private String func = "linear";
    private Integer shotInterval;
    private String type = "transition";

    public PathShot$Transition$CaptureType getCaptureType() {
        return this.captureType;
    }

    public Integer getElapsedTime() {
        return this.elapsedTime;
    }

    public Integer getExposureTime() {
        return this.exposureTime;
    }

    public String getFunc() {
        return this.func;
    }

    public Integer getShotInterval() {
        return this.shotInterval;
    }

    public void setCaptureType(PathShot$Transition$CaptureType pathShot$Transition$CaptureType) {
        this.captureType = pathShot$Transition$CaptureType;
    }

    public void setElapsedTime(Integer n10) {
        this.elapsedTime = n10;
    }

    public void setExposureTime(Integer n10) {
        this.exposureTime = n10;
    }

    public void setFunc(String string2) {
        this.func = string2;
    }

    public void setShotInterval(Integer n10) {
        this.shotInterval = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transition{type='");
        Object object = this.type;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", func='");
        String string2 = this.func;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", elapsedTime=");
        object = this.elapsedTime;
        stringBuilder.append(object);
        stringBuilder.append(", shotInterval=");
        object = this.shotInterval;
        stringBuilder.append(object);
        stringBuilder.append(", exposureTime=");
        object = this.exposureTime;
        stringBuilder.append(object);
        stringBuilder.append(", captureType=");
        object = this.captureType;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

