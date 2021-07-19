/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ActionStateCallback$RecordingResult
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;

public final class ActionStateCallback$RecordingResult
extends ActionStateCallback$AbstractResult {
    private ActionStateCallback.RecordingResult result;

    private ActionStateCallback$RecordingResult(ActionStateCallback.RecordingResult recordingResult) {
        this.result = recordingResult;
    }

    public /* synthetic */ ActionStateCallback$RecordingResult(ActionStateCallback.RecordingResult recordingResult, ActionStateCallback$1 actionStateCallback$1) {
        this(recordingResult);
    }
}

