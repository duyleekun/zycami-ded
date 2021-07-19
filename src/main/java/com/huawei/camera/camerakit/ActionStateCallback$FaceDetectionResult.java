/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.Face
 *  com.huawei.camerakit.api.ActionStateCallback$FaceDetectionResult
 */
package com.huawei.camera.camerakit;

import android.hardware.camera2.params.Face;
import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$AbstractResult;
import com.huawei.camerakit.api.ActionStateCallback;
import java.util.Collections;
import java.util.Map;

public final class ActionStateCallback$FaceDetectionResult
extends ActionStateCallback$AbstractResult {
    private ActionStateCallback.FaceDetectionResult result;

    private ActionStateCallback$FaceDetectionResult(ActionStateCallback.FaceDetectionResult faceDetectionResult) {
        this.result = faceDetectionResult;
    }

    public /* synthetic */ ActionStateCallback$FaceDetectionResult(ActionStateCallback.FaceDetectionResult faceDetectionResult, ActionStateCallback$1 actionStateCallback$1) {
        this(faceDetectionResult);
    }

    public Face[] getFaces() {
        Face[] faceArray = this.result;
        faceArray = faceArray == null ? new Face[]{} : faceArray.getFaces();
        return faceArray;
    }

    public Map getSmiles() {
        Object object = this.result;
        object = object == null ? Collections.EMPTY_MAP : object.getSmiles();
        return object;
    }
}

