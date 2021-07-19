/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import com.zhiyun.cama.camera.data.CameraSet$Mode;

public class TypeCameraModeConverters {
    public static CameraSet$Mode idToMode(int n10) {
        return CameraSet$Mode.fromId(n10);
    }

    public static int modeToId(CameraSet$Mode cameraSet$Mode) {
        return cameraSet$Mode.getId();
    }
}

