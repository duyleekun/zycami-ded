/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ActionStateCallback$SceneDetectionResult
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;
import java.util.HashMap;
import java.util.Map;

public final class ActionStateCallback$SceneDetectionResult
extends ActionStateCallback$AbstractResult {
    private ActionStateCallback.SceneDetectionResult result;

    private ActionStateCallback$SceneDetectionResult(ActionStateCallback.SceneDetectionResult sceneDetectionResult) {
        this.result = sceneDetectionResult;
    }

    public /* synthetic */ ActionStateCallback$SceneDetectionResult(ActionStateCallback.SceneDetectionResult sceneDetectionResult, ActionStateCallback$1 actionStateCallback$1) {
        this(sceneDetectionResult);
    }

    public Map getScenes() {
        Object object = this.result;
        if (object != null) {
            return object.getScenes();
        }
        object = new HashMap(0);
        return object;
    }
}

