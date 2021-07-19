/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.CameraInfoInterface
 */
package com.huawei.camera.camerakit;

import com.huawei.camerakit.api.CameraInfoInterface;

public final class CameraInfo {
    private CameraInfoInterface cameraInfo;

    public CameraInfo(CameraInfoInterface cameraInfoInterface) {
        this.cameraInfo = cameraInfoInterface;
    }

    public int getDeviceLinkType(String string2) {
        return this.cameraInfo.getDeviceLinkType(string2);
    }

    public int getFacingType() {
        return this.cameraInfo.getFacingType();
    }

    public String[] getPhysicalIdList() {
        return this.cameraInfo.getPhysicalIdList();
    }
}

