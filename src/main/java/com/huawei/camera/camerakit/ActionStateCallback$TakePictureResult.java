/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ActionStateCallback$TakePictureResult
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;

public final class ActionStateCallback$TakePictureResult
extends ActionStateCallback$AbstractResult {
    private ActionStateCallback.TakePictureResult result;

    private ActionStateCallback$TakePictureResult(ActionStateCallback.TakePictureResult takePictureResult) {
        this.result = takePictureResult;
    }

    public /* synthetic */ ActionStateCallback$TakePictureResult(ActionStateCallback.TakePictureResult takePictureResult, ActionStateCallback$1 actionStateCallback$1) {
        this(takePictureResult);
    }

    public int getExposureTime() {
        ActionStateCallback.TakePictureResult takePictureResult = this.result;
        if (takePictureResult != null) {
            return takePictureResult.getExposureTime();
        }
        return 0;
    }
}

