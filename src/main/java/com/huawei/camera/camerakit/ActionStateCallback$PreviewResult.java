/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ActionStateCallback$PreviewResult
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;

public final class ActionStateCallback$PreviewResult
extends ActionStateCallback$AbstractResult {
    public ActionStateCallback.PreviewResult result;

    private ActionStateCallback$PreviewResult(ActionStateCallback.PreviewResult previewResult) {
        this.result = previewResult;
    }

    public /* synthetic */ ActionStateCallback$PreviewResult(ActionStateCallback.PreviewResult previewResult, ActionStateCallback$1 actionStateCallback$1) {
        this(previewResult);
    }

    public byte getCurrentCameraId() {
        ActionStateCallback.PreviewResult previewResult = this.result;
        if (previewResult != null) {
            return previewResult.getCurrentCameraId();
        }
        return 0;
    }
}

