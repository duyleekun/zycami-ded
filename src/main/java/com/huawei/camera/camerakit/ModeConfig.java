/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ModeConfigInterface
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ModeConfig$1;
import com.huawei.camerakit.api.ModeConfigInterface;

public final class ModeConfig {
    private static final String TAG = "ModeConfigInterface";
    private ModeConfigInterface modeConfig;

    private ModeConfig(ModeConfigInterface modeConfigInterface) {
        this.modeConfig = modeConfigInterface;
    }

    public /* synthetic */ ModeConfig(ModeConfigInterface modeConfigInterface, ModeConfig$1 modeConfig$1) {
        this(modeConfigInterface);
    }

    public ModeConfigInterface get() {
        return this.modeConfig;
    }
}

