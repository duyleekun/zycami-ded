/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CaptureRequest$Key
 */
package com.huawei.camera.camerakit;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import com.huawei.camera.camerakit.KeyGenerator;

public final class RequestKey {
    public static final CaptureRequest.Key HW_AI_MOVIE;
    public static final CaptureRequest.Key HW_APERTURE;
    public static final CaptureRequest.Key HW_EXPOSURE_COMPENSATION_VALUE;
    public static final CaptureRequest.Key HW_FILTER_EFFECT;
    public static final CaptureRequest.Key HW_FILTER_LEVEL;
    public static final CaptureRequest.Key HW_MIRROR;
    public static final CaptureRequest.Key HW_PORTRAIT_FAIRLIGHT;
    public static final CaptureRequest.Key HW_PORTRAIT_SPOTS_BOKEH;
    public static final CaptureRequest.Key HW_PRO_AWB_TYPE;
    public static final CaptureRequest.Key HW_PRO_EXPOSURE_HINT;
    public static final CaptureRequest.Key HW_PRO_FOCUS_DISTANCE_VALUE;
    public static final CaptureRequest.Key HW_PRO_MANUAL_WB_VALUE;
    public static final CaptureRequest.Key HW_PRO_METERING_VALUE;
    public static final CaptureRequest.Key HW_PRO_SENSOR_EXPOSURE_TIME_VALUE;
    public static final CaptureRequest.Key HW_PRO_SENSOR_ISO_VALUE;
    public static final CaptureRequest.Key HW_SCENE_EFFECT_ENABLE;
    public static final CaptureRequest.Key HW_SENSOR_HDR;
    public static final CaptureRequest.Key HW_SUPER_NIGHT_EXPOSURE;
    public static final CaptureRequest.Key HW_SUPER_NIGHT_ISO;
    public static final CaptureRequest.Key HW_SUPER_SLOW_CHECK_AREA;
    public static final CaptureRequest.Key HW_VIDEO_STABILIZATION;

    static {
        Class clazz = Long.class;
        Class clazz2 = Byte.class;
        Class<Float> clazz3 = Float.TYPE;
        HW_APERTURE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwApertureValue", clazz3);
        HW_PORTRAIT_FAIRLIGHT = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwFairlightValue", clazz2);
        HW_PORTRAIT_SPOTS_BOKEH = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwBokehSpotValue", clazz2);
        Class<Boolean> clazz4 = Boolean.TYPE;
        HW_SENSOR_HDR = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwSensorHdrValue", clazz4);
        HW_MIRROR = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwMirrorValue", clazz4);
        HW_AI_MOVIE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwAiMovieValue", clazz2);
        clazz2 = Byte.TYPE;
        HW_FILTER_EFFECT = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwFilterEffectValue", clazz2);
        clazz2 = Integer.TYPE;
        HW_FILTER_LEVEL = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwFilterLevelValue", clazz2);
        HW_SUPER_NIGHT_ISO = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwManualIsoValue", clazz);
        HW_SUPER_NIGHT_EXPOSURE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwManualExposureValue", clazz);
        HW_SUPER_SLOW_CHECK_AREA = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwSuperSlowCheckArea", Rect.class);
        HW_SCENE_EFFECT_ENABLE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwSceneEffectEnable", clazz4);
        HW_VIDEO_STABILIZATION = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwVideoStabilizationValue", clazz4);
        clazz = Byte.TYPE;
        HW_PRO_METERING_VALUE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwMeteringMode", clazz);
        HW_PRO_SENSOR_ISO_VALUE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwSensorIso", clazz2);
        HW_PRO_SENSOR_EXPOSURE_TIME_VALUE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwProSensorExposureTime", clazz2);
        HW_EXPOSURE_COMPENSATION_VALUE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwExposureCompValue", clazz3);
        HW_PRO_FOCUS_DISTANCE_VALUE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwLenFocusDistanceValue", clazz3);
        HW_PRO_AWB_TYPE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwProAwbValue", clazz2);
        HW_PRO_MANUAL_WB_VALUE = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwSensorWbValue", clazz2);
        HW_PRO_EXPOSURE_HINT = KeyGenerator.generateCaptureRequestKey("com.huawei.camerakit.hwExposureHintValue", clazz4);
    }

    private RequestKey() {
    }
}

