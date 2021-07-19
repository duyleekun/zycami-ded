/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ActionStateCallback$BurstResult
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;

public final class ActionStateCallback$BurstResult
extends ActionStateCallback$AbstractResult {
    private ActionStateCallback.BurstResult result;

    private ActionStateCallback$BurstResult(ActionStateCallback.BurstResult burstResult) {
        this.result = burstResult;
    }

    public /* synthetic */ ActionStateCallback$BurstResult(ActionStateCallback.BurstResult burstResult, ActionStateCallback$1 actionStateCallback$1) {
        this(burstResult);
    }
}

