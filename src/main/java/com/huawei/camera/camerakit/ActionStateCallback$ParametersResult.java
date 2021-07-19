/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CaptureResult$Key
 *  com.huawei.camerakit.api.ActionStateCallback$ParametersResult
 */
package com.huawei.camera.camerakit;

import android.hardware.camera2.CaptureResult;
import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;
import java.util.List;

public final class ActionStateCallback$ParametersResult
extends ActionStateCallback$AbstractResult {
    public ActionStateCallback.ParametersResult result;

    private ActionStateCallback$ParametersResult(ActionStateCallback.ParametersResult parametersResult) {
        this.result = parametersResult;
    }

    public /* synthetic */ ActionStateCallback$ParametersResult(ActionStateCallback.ParametersResult parametersResult, ActionStateCallback$1 actionStateCallback$1) {
        this(parametersResult);
    }

    public List getAvailableResultKeys() {
        return this.result.getAvailableResultKeys();
    }

    public Object getResultValue(CaptureResult.Key key) {
        return this.result.getResultValue(key);
    }
}

