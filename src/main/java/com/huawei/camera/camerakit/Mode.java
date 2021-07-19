/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.location.Location
 *  android.util.Log
 *  com.huawei.camerakit.api.CameraModeException
 *  com.huawei.camerakit.api.ModeCharacteristicsInterface
 *  com.huawei.camerakit.api.ModeConfigInterface
 *  com.huawei.camerakit.api.ModeInterface
 */
package com.huawei.camera.camerakit;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.location.Location;
import android.util.Log;
import com.huawei.camera.camerakit.CameraKit;
import com.huawei.camera.camerakit.ModeCharacteristics;
import com.huawei.camera.camerakit.ModeConfig;
import com.huawei.camera.camerakit.ModeConfig$Builder;
import com.huawei.camerakit.api.CameraModeException;
import com.huawei.camerakit.api.ModeCharacteristicsInterface;
import com.huawei.camerakit.api.ModeConfigInterface;
import com.huawei.camerakit.api.ModeInterface;
import java.io.File;
import java.util.Map;

public final class Mode {
    private static final String INVALID_CAMERA_ID = "invalidCameraId";
    private static final String TAG = "CameraKit";
    private ModeInterface mode;
    private ModeCharacteristics modeCharacteristics;
    private ModeConfig$Builder modeConfigBuilder;

    public Mode() {
    }

    public Mode(ModeInterface modeInterface) {
        this.mode = modeInterface;
    }

    public void configure() {
        Object object = this.modeConfigBuilder;
        if (object != null) {
            Object object2;
            try {
                object = ((ModeConfig$Builder)object).build();
            }
            catch (CameraModeException cameraModeException) {
                String string2 = cameraModeException.getMessage();
                object2 = new IllegalArgumentException(string2);
                throw object2;
            }
            object = ((ModeConfig)object).get();
            object2 = this.mode;
            object2.configure((ModeConfigInterface)object);
            object2 = this.modeConfigBuilder;
            ((ModeConfig$Builder)object2).setConfig((ModeConfigInterface)object);
            return;
        }
        object = new IllegalArgumentException("ModeConfig.Builder should not be null");
        throw object;
    }

    public String getCameraId() {
        ModeInterface modeInterface = this.mode;
        if (modeInterface != null) {
            return modeInterface.getCameraId();
        }
        return INVALID_CAMERA_ID;
    }

    public ModeCharacteristics getModeCharacteristics() {
        ModeCharacteristics modeCharacteristics = this.modeCharacteristics;
        if (modeCharacteristics == null) {
            ModeCharacteristicsInterface modeCharacteristicsInterface = this.mode.getModeCharacteristics();
            this.modeCharacteristics = modeCharacteristics = new ModeCharacteristics(modeCharacteristicsInterface);
        }
        return this.modeCharacteristics;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ModeConfig$Builder getModeConfigBuilder() {
        ModeConfig$Builder modeConfig$Builder = this.modeConfigBuilder;
        if (modeConfig$Builder != null) {
            return modeConfig$Builder;
        }
        synchronized (this) {
            modeConfig$Builder = this.modeConfigBuilder;
            if (modeConfig$Builder == null) {
                this.modeConfigBuilder = modeConfig$Builder = ModeConfig$Builder.getInstance(this);
            }
            return this.modeConfigBuilder;
        }
    }

    public ModeInterface getModeImpl() {
        return this.mode;
    }

    public int getType() {
        ModeInterface modeInterface = this.mode;
        if (modeInterface != null) {
            return modeInterface.getType();
        }
        return 0;
    }

    public void pauseRecording() {
        ModeInterface modeInterface;
        try {
            modeInterface = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        modeInterface.pauseRecording();
    }

    public void release() {
        this.mode.release();
    }

    public void resumeRecording() {
        ModeInterface modeInterface;
        try {
            modeInterface = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        modeInterface.resumeRecording();
    }

    public int setBeauty(int n10, int n11) {
        return this.mode.setBeauty(n10, n11);
    }

    public int setColorMode(int n10) {
        return this.mode.setColorMode(n10);
    }

    public int setFaceDetection(int n10, boolean bl2) {
        return this.mode.setFaceDetection(n10, bl2);
    }

    public int setFlashMode(int n10) {
        return this.mode.setFlashMode(n10);
    }

    public int setFocus(int n10, Rect rect) {
        return this.mode.autoFocus(n10, rect);
    }

    public int setImageRotation(int n10) {
        return this.mode.setImageRotation(n10);
    }

    public int setLocation(Location location) {
        return this.mode.setLocation(location);
    }

    public int setParameter(CaptureRequest.Key key, Object object) {
        return this.mode.setParameter(key, object);
    }

    public int setParameters(Map map) {
        return this.mode.setParameters(map);
    }

    public int setSceneDetection(boolean bl2) {
        ModeInterface modeInterface = this.mode;
        Boolean bl3 = bl2;
        return modeInterface.setSceneDetection(bl3);
    }

    public int setZoom(float f10) {
        return this.mode.setZoom(f10);
    }

    public void startPreview() {
        ModeInterface modeInterface;
        try {
            modeInterface = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        modeInterface.startPreview();
    }

    public void startRecording() {
        ModeInterface modeInterface;
        try {
            modeInterface = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        modeInterface.startRecording();
    }

    public void startRecording(File file) {
        int n10;
        int n11 = CameraKit.getApiLevel();
        if (n11 >= (n10 = 1)) {
            Object object;
            try {
                object = this.mode;
            }
            catch (CameraModeException cameraModeException) {
                String string2 = cameraModeException.getReasonMessage();
                object = new IllegalStateException(string2);
                throw object;
            }
            object.startRecording(file);
        }
    }

    public void stopPicture() {
        Object object = this.mode;
        try {
            object.stopPicture();
        }
        catch (CameraModeException cameraModeException) {
            object = TAG;
            String string2 = "Ignore any exception when stop capture.";
            Log.d((String)object, (String)string2);
        }
    }

    public void stopPreview() {
        Object object = this.mode;
        try {
            object.stopPreview();
        }
        catch (CameraModeException cameraModeException) {
            object = TAG;
            String string2 = "Ignore any exception when stop preview.";
            Log.d((String)object, (String)string2);
        }
    }

    public void stopRecording() {
        ModeInterface modeInterface;
        try {
            modeInterface = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        modeInterface.stopRecording();
    }

    public void takePicture() {
        ModeInterface modeInterface;
        try {
            modeInterface = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        modeInterface.takePicture();
    }

    public void takePicture(File file) {
        Object object;
        try {
            object = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            object = new IllegalStateException(string2);
            throw object;
        }
        object.takePicture(file);
    }

    public void takePictureBurst() {
        ModeInterface modeInterface;
        try {
            modeInterface = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        modeInterface.takePictureBurst();
    }

    public void takePictureBurst(File file) {
        Object object;
        try {
            object = this.mode;
        }
        catch (CameraModeException cameraModeException) {
            String string2 = cameraModeException.getReasonMessage();
            object = new IllegalStateException(string2);
            throw object;
        }
        object.takePictureBurst(file);
    }
}

