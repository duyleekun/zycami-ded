/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsBeatDetection$BeatDetectionCallback;
import com.meicam.sdk.NvsUtils;

public class NvsBeatDetection {
    private static final String TAG = "Meicam";
    private static NvsBeatDetection m_instance;
    private NvsBeatDetection$BeatDetectionCallback m_BeatDetectionCallback;

    private NvsBeatDetection() {
    }

    public static void close() {
        NvsBeatDetection nvsBeatDetection = m_instance;
        if (nvsBeatDetection == null) {
            return;
        }
        nvsBeatDetection.setBeatDetectionCallback(null);
        m_instance = null;
        NvsBeatDetection.nativeClose();
    }

    public static NvsBeatDetection getInstance() {
        NvsUtils.checkFunctionInMainThread();
        return m_instance;
    }

    public static NvsBeatDetection init(int n10) {
        NvsBeatDetection nvsBeatDetection;
        NvsBeatDetection nvsBeatDetection2 = m_instance;
        if (nvsBeatDetection2 != null) {
            return nvsBeatDetection2;
        }
        if ((n10 = (int)(NvsBeatDetection.nativeInit(n10) ? 1 : 0)) == 0) {
            return null;
        }
        m_instance = nvsBeatDetection = new NvsBeatDetection();
        return nvsBeatDetection;
    }

    private static native void nativeClose();

    private static native boolean nativeInit(int var0);

    private static native void nativeSetBeatDetectionCallback(NvsBeatDetection$BeatDetectionCallback var0);

    private static native boolean nativeStartDetect(String var0, int var1);

    public void setBeatDetectionCallback(NvsBeatDetection$BeatDetectionCallback nvsBeatDetection$BeatDetectionCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_BeatDetectionCallback = nvsBeatDetection$BeatDetectionCallback;
        NvsBeatDetection.nativeSetBeatDetectionCallback(nvsBeatDetection$BeatDetectionCallback);
    }

    public boolean startDetect(String string2, int n10) {
        return NvsBeatDetection.nativeStartDetect(string2, n10);
    }
}

