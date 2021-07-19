/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsHumanDetectionHandle$DetectionConfig;
import com.meicam.sdk.NvsHumanDetectionHandle$HumanFeature;

public class NvsHumanDetectionHandle {
    public static final long HUMAN_DETECTION_AVATAR_EXPRESSION = 1L;
    public static final int HUMAN_DETECTION_CAMERA_FOVY = 0;
    public static final long HUMAN_DETECTION_FACE_ACTION_BROW_JUMP = 16L;
    public static final long HUMAN_DETECTION_FACE_ACTION_EYE_BLINK = 1L;
    public static final long HUMAN_DETECTION_FACE_ACTION_FULL = 31L;
    public static final long HUMAN_DETECTION_FACE_ACTION_LIPS_PART = 2L;
    public static final long HUMAN_DETECTION_FACE_ACTION_PITCH = 8L;
    public static final long HUMAN_DETECTION_FACE_ACTION_YAW = 4L;
    public static final int HUMAN_DETECTION_FACE_COUNT = 0;
    public static final long HUMAN_DETECTION_FACE_FEATURE_2D = 1L;
    public static final long HUMAN_DETECTION_FACE_FEATURE_3D = 2L;
    public static final long HUMAN_DETECTION_FACE_FEATURE_FULL = 3L;
    public static final long HUMAN_DETECTION_FEATURE_AVATAR_EXPRESSION = 4L;
    public static final long HUMAN_DETECTION_FEATURE_EXTRA = 128L;
    public static final long HUMAN_DETECTION_FEATURE_FACE_ACTION = 2L;
    public static final long HUMAN_DETECTION_FEATURE_FACE_LANDMARK = 1L;
    public static final long HUMAN_DETECTION_FEATURE_IMAGE_MODE = 16L;
    public static final long HUMAN_DETECTION_FEATURE_MULTI_THREAD = 32L;
    public static final long HUMAN_DETECTION_FEATURE_SINGLE_THREAD = 64L;
    public static final long HUMAN_DETECTION_FEATURE_VIDEO_MODE = 8L;
    public static final int HUMAN_DETECTION_FREQUENCY = 1;
    public static final int HUMAN_DETECTION_LANDMARKS_SMOOTH = 0;
    public static final int HUMAN_DETECTION_LANDMARKS_SMOOTH_THRESH = 1;
    public static final int HUMAN_DETECTION_MIN_RATIO = 4;
    public static final int HUMAN_DETECTION_PE_RIGID_SMOOTH = 1;
    public static final int HUMAN_DETECTION_PE_RIGID_SMOOTH_THRESH = 2;
    public static final int HUMAN_DETECTION_PE_RIGID_TRANSFORM = 2;
    public static final int HUMAN_DETECTION_RESET_TRACKING = 4;
    public static final int HUMAN_DETECTION_SNAP_MOUTH = 3;
    public static final int HUMAN_DETECTION_SNAP_MOUTH_THRESH = 3;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_BGR8 = 6;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_BGRA8 = 4;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_GRAY8 = 7;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_NV12 = 1;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_NV21 = 0;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_RGB8 = 5;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_RGBA8 = 3;
    public static final int HUMAN_DETECTION_VIDEO_FRAME_PIXEL_FORMAT_YUV420 = 2;
    private long m_handleInterface = 0L;

    private native NvsHumanDetectionHandle$HumanFeature nativeDetect(long var1, byte[] var3, int var4, int var5, int var6, int var7, int var8, NvsHumanDetectionHandle$DetectionConfig var9);

    private native void nativeSetDetectionBooleanParam(long var1, int var3, boolean var4);

    private native void nativeSetDetectionFloatParam(long var1, int var3, float var4);

    private native void nativeSetDetectionIntegerParam(long var1, int var3, int var4);

    public NvsHumanDetectionHandle$HumanFeature detect(byte[] byArray, int n10, int n11, int n12, int n13, int n14, NvsHumanDetectionHandle$DetectionConfig nvsHumanDetectionHandle$DetectionConfig) {
        long l10 = this.m_handleInterface;
        return this.nativeDetect(l10, byArray, n10, n11, n12, n13, n14, nvsHumanDetectionHandle$DetectionConfig);
    }

    public long getHandleInterface() {
        return this.m_handleInterface;
    }

    public void setDetectionBooleanParam(int n10, boolean bl2) {
        long l10 = this.m_handleInterface;
        this.nativeSetDetectionBooleanParam(l10, n10, bl2);
    }

    public void setDetectionFloatParam(int n10, float f10) {
        long l10 = this.m_handleInterface;
        this.nativeSetDetectionFloatParam(l10, n10, f10);
    }

    public void setDetectionIntegerParam(int n10, int n11) {
        long l10 = this.m_handleInterface;
        this.nativeSetDetectionIntegerParam(l10, n10, n11);
    }

    public void setHandleInterface(long l10) {
        this.m_handleInterface = l10;
    }
}

