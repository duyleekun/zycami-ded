/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ActionStateCallback
 *  com.huawei.camerakit.api.ActionStateCallback$BurstResult
 *  com.huawei.camerakit.api.ActionStateCallback$FaceDetectionResult
 *  com.huawei.camerakit.api.ActionStateCallback$FocusResult
 *  com.huawei.camerakit.api.ActionStateCallback$ParametersResult
 *  com.huawei.camerakit.api.ActionStateCallback$PreviewResult
 *  com.huawei.camerakit.api.ActionStateCallback$RecordingResult
 *  com.huawei.camerakit.api.ActionStateCallback$SceneDetectionResult
 *  com.huawei.camerakit.api.ActionStateCallback$TakePictureResult
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.ActionStateCallback;
import com.huawei.camera.camerakit.ActionStateCallback$1;
import com.huawei.camera.camerakit.ActionStateCallback$BurstResult;
import com.huawei.camera.camerakit.ActionStateCallback$FaceDetectionResult;
import com.huawei.camera.camerakit.ActionStateCallback$FocusResult;
import com.huawei.camera.camerakit.ActionStateCallback$ParametersResult;
import com.huawei.camera.camerakit.ActionStateCallback$PreviewResult;
import com.huawei.camera.camerakit.ActionStateCallback$RecordingResult;
import com.huawei.camera.camerakit.ActionStateCallback$SceneDetectionResult;
import com.huawei.camera.camerakit.ActionStateCallback$TakePictureResult;
import com.huawei.camera.camerakit.Mode;
import com.huawei.camerakit.api.ActionStateCallback;

public final class ActionStateCallback$StateCallbackWrapper
extends com.huawei.camerakit.api.ActionStateCallback {
    private Mode mode;
    private ActionStateCallback stateCallback;

    private ActionStateCallback$StateCallbackWrapper(Mode mode, ActionStateCallback actionStateCallback) {
        this.mode = mode;
        this.stateCallback = actionStateCallback;
    }

    public /* synthetic */ ActionStateCallback$StateCallbackWrapper(Mode mode, ActionStateCallback actionStateCallback, ActionStateCallback$1 actionStateCallback$1) {
        this(mode, actionStateCallback);
    }

    public void onBurst(int n10, ActionStateCallback.BurstResult burstResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$BurstResult actionStateCallback$BurstResult = new ActionStateCallback$BurstResult(burstResult, null);
        actionStateCallback.onBurst(mode, n10, actionStateCallback$BurstResult);
    }

    public void onFaceDetection(int n10, ActionStateCallback.FaceDetectionResult faceDetectionResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$FaceDetectionResult actionStateCallback$FaceDetectionResult = new ActionStateCallback$FaceDetectionResult(faceDetectionResult, null);
        actionStateCallback.onFaceDetection(mode, n10, actionStateCallback$FaceDetectionResult);
    }

    public void onFocus(int n10, ActionStateCallback.FocusResult focusResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$FocusResult actionStateCallback$FocusResult = new ActionStateCallback$FocusResult(focusResult, null);
        actionStateCallback.onFocus(mode, n10, actionStateCallback$FocusResult);
    }

    public void onParameters(int n10, ActionStateCallback.ParametersResult parametersResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$ParametersResult actionStateCallback$ParametersResult = new ActionStateCallback$ParametersResult(parametersResult, null);
        actionStateCallback.onParameters(mode, n10, actionStateCallback$ParametersResult);
    }

    public void onPreview(int n10, ActionStateCallback.PreviewResult previewResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$PreviewResult actionStateCallback$PreviewResult = new ActionStateCallback$PreviewResult(previewResult, null);
        actionStateCallback.onPreview(mode, n10, actionStateCallback$PreviewResult);
    }

    public void onRecording(int n10, ActionStateCallback.RecordingResult recordingResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$RecordingResult actionStateCallback$RecordingResult = new ActionStateCallback$RecordingResult(recordingResult, null);
        actionStateCallback.onRecording(mode, n10, actionStateCallback$RecordingResult);
    }

    public void onSceneDetection(int n10, ActionStateCallback.SceneDetectionResult sceneDetectionResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$SceneDetectionResult actionStateCallback$SceneDetectionResult = new ActionStateCallback$SceneDetectionResult(sceneDetectionResult, null);
        actionStateCallback.onSceneDetection(mode, n10, actionStateCallback$SceneDetectionResult);
    }

    public void onTakePicture(int n10, ActionStateCallback.TakePictureResult takePictureResult) {
        ActionStateCallback actionStateCallback = this.stateCallback;
        Mode mode = this.mode;
        ActionStateCallback$TakePictureResult actionStateCallback$TakePictureResult = new ActionStateCallback$TakePictureResult(takePictureResult, null);
        actionStateCallback.onTakePicture(mode, n10, actionStateCallback$TakePictureResult);
    }
}

