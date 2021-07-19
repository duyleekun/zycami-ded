/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ActionStateCallback$FocusResult
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;

public final class ActionStateCallback$FocusResult
extends ActionStateCallback$AbstractResult {
    private ActionStateCallback.FocusResult result;

    private ActionStateCallback$FocusResult(ActionStateCallback.FocusResult focusResult) {
        this.result = focusResult;
    }

    public /* synthetic */ ActionStateCallback$FocusResult(ActionStateCallback.FocusResult focusResult, ActionStateCallback$1 actionStateCallback$1) {
        this(focusResult);
    }
}

