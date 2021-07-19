/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import com.zhiyun.cama.camera.data.CameraSet$Mode;
import d.v.d.i.g.k$a;
import java.util.Objects;

public class CameraParam {
    private int facing;
    private CameraSet$Mode mode;
    private k$a videoResolution;
    private int whiteBalance;

    public CameraParam(int n10, CameraSet$Mode cameraSet$Mode, k$a k$a, int n11) {
        this.facing = n10;
        this.mode = cameraSet$Mode;
        this.videoResolution = k$a;
        this.whiteBalance = n11;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (CameraParam)object;
            int n10 = this.facing;
            int n11 = ((CameraParam)object).facing;
            if (n10 != n11 || (n10 = this.whiteBalance) != (n11 = ((CameraParam)object).whiteBalance) || (object3 = this.mode) != (object2 = ((CameraParam)object).mode) || !(bl3 = Objects.equals(object3 = this.videoResolution, object = ((CameraParam)object).videoResolution))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getFacing() {
        return this.facing;
    }

    public CameraSet$Mode getMode() {
        return this.mode;
    }

    public k$a getVideoResolution() {
        return this.videoResolution;
    }

    public int getWhiteBalance() {
        return this.whiteBalance;
    }

    public int hashCode() {
        Object[] objectArray = new Object[4];
        Object object = this.facing;
        objectArray[0] = object;
        object = this.mode;
        objectArray[1] = object;
        object = this.videoResolution;
        objectArray[2] = object;
        object = this.whiteBalance;
        objectArray[3] = object;
        return Objects.hash(objectArray);
    }

    public void setFacing(int n10) {
        this.facing = n10;
    }

    public void setMode(CameraSet$Mode cameraSet$Mode) {
        this.mode = cameraSet$Mode;
    }

    public void setVideoResolution(k$a k$a) {
        this.videoResolution = k$a;
    }

    public void setWhiteBalance(int n10) {
        this.whiteBalance = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CameraParam{facing=");
        int n10 = this.facing;
        stringBuilder.append(n10);
        stringBuilder.append(", mode=");
        Object object = this.mode;
        stringBuilder.append(object);
        stringBuilder.append(", videoResolution=");
        object = this.videoResolution;
        stringBuilder.append(object);
        stringBuilder.append(", whiteBalance=");
        n10 = this.whiteBalance;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

