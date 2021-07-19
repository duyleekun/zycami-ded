/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureResult$Key
 */
package com.huawei.camera.camerakit;

import android.hardware.camera2.CaptureResult;
import com.huawei.camera.camerakit.KeyGenerator;

public final class ResultKey {
    public static final CaptureResult.Key HW_EXPOSURE_HINT_RESULT;

    static {
        Class<Integer> clazz = Integer.TYPE;
        HW_EXPOSURE_HINT_RESULT = KeyGenerator.generateCaptureResultKey("com.huawei.camerakit.hwExposureHintResult", clazz);
    }

    private ResultKey() {
    }
}

