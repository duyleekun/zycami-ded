/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback$BurstResult;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.ActionStateCallback$FocusResult;
import com.huawei.camera.camerakit.ActionStateCallback$ParametersResult;
import com.huawei.camera.camerakit.ActionStateCallback$PreviewResult;
import com.huawei.camera.camerakit.ActionStateCallback$RecordingResult;
import com.huawei.camera.camerakit.ActionStateCallback$SceneDetectionResult;
import com.huawei.camera.camerakit.ActionStateCallback$StateCallbackWrapper;
import com.huawei.camera.camerakit.ActionStateCallback$TakePictureResult;
import com.huawei.camera.camerakit.Mode;

public abstract class ActionStateCallback {
    public static ActionStateCallback$StateCallbackWrapper obtain(Mode mode, ActionStateCallback actionStateCallback) {
        ActionStateCallback$StateCallbackWrapper actionStateCallback$StateCallbackWrapper = new ActionStateCallback$StateCallbackWrapper(mode, actionStateCallback, null);
        return actionStateCallback$StateCallbackWrapper;
    }

    public void onBurst(Mode mode, int n10, ActionStateCallback$BurstResult actionStateCallback$BurstResult) {
    }

    public void onFaceDetection(Mode mode, int n10, ActionStateCallback$FaceDetectionResult actionStateCallback$FaceDetectionResult) {
    }

    public void onFocus(Mode mode, int n10, ActionStateCallback$FocusResult actionStateCallback$FocusResult) {
    }

    public void onParameters(Mode mode, int n10, ActionStateCallback$ParametersResult actionStateCallback$ParametersResult) {
    }

    public void onPreview(Mode mode, int n10, ActionStateCallback$PreviewResult actionStateCallback$PreviewResult) {
    }

    public void onRecording(Mode mode, int n10, ActionStateCallback$RecordingResult actionStateCallback$RecordingResult) {
    }

    public void onSceneDetection(Mode mode, int n10, ActionStateCallback$SceneDetectionResult actionStateCallback$SceneDetectionResult) {
    }

    public void onTakePicture(Mode mode, int n10, ActionStateCallback$TakePictureResult actionStateCallback$TakePictureResult) {
    }
}

