/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest$Key
 *  com.huawei.camerakit.api.ModeCharacteristicsInterface
 */
package com.huawei.camera.camerakit;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import com.huawei.camera.camerakit.CameraKit;
import com.huawei.camerakit.api.ModeCharacteristicsInterface;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class ModeCharacteristics {
    private static final String TAG = "CameraKit";
    private final ModeCharacteristicsInterface characteristics;

    public ModeCharacteristics(ModeCharacteristicsInterface modeCharacteristicsInterface) {
        Objects.requireNonNull(modeCharacteristicsInterface, "Structure failed, ModeCharacteristics impl is null!");
        this.characteristics = modeCharacteristicsInterface;
    }

    public Object get(CameraCharacteristics.Key key) {
        return this.characteristics.get(key);
    }

    public Set getConflictActions() {
        return this.characteristics.getConflictActions();
    }

    public int getMaxPreviewSurfaceNumber() {
        int n10;
        int n11 = CameraKit.getApiLevel();
        if (n11 < (n10 = 1)) {
            return n10;
        }
        return this.characteristics.getMaxPreviewSurfaceNumber();
    }

    public ModeCharacteristics getModeCharacteristicsByCameraId(String string2) {
        string2 = this.characteristics.getModeCharacteristicsByCameraId(string2);
        ModeCharacteristics modeCharacteristics = new ModeCharacteristics((ModeCharacteristicsInterface)string2);
        return modeCharacteristics;
    }

    public List getParameterRange(CaptureRequest.Key key) {
        return this.characteristics.getParameterRange(key);
    }

    public int[] getSupportedAutoFocus() {
        return this.characteristics.getSupportedAutoFocus();
    }

    public int[] getSupportedBeauty(int n10) {
        return this.characteristics.getSupportedBeauty(n10);
    }

    public List getSupportedCameraId() {
        return this.characteristics.getSupportedCameraId();
    }

    public List getSupportedCaptureSizes(int n10) {
        return this.characteristics.getSupportedCaptureSizes(n10);
    }

    public int[] getSupportedColorMode() {
        return this.characteristics.getSupportedColorMode();
    }

    public int[] getSupportedFaceDetection() {
        return this.characteristics.getSupportedFaceDetection();
    }

    public int[] getSupportedFlashMode() {
        return this.characteristics.getSupportedFlashMode();
    }

    public List getSupportedParameters() {
        return this.characteristics.getSupportedParameters();
    }

    public List getSupportedPreviewSizes(Class clazz) {
        return this.characteristics.getSupportedPreviewSizes(clazz);
    }

    public boolean getSupportedSceneDetection() {
        return this.characteristics.getSupportedSceneDetection();
    }

    public Map getSupportedVideoSizes(Class clazz) {
        return this.characteristics.getSupportedVideoSizes(clazz);
    }

    public float[] getSupportedZoom() {
        return this.characteristics.getSupportedZoom();
    }

    public boolean isBurstSupported() {
        return this.characteristics.isBurstSupported();
    }

    public boolean isCaptureSupported() {
        return this.characteristics.isCaptureSupported();
    }

    public boolean isPreviewSupported() {
        return this.characteristics.isPreviewSupported();
    }

    public boolean isVideoSupported() {
        return this.characteristics.isVideoSupported();
    }
}

