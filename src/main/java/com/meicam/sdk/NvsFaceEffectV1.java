/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsUtils;

public class NvsFaceEffectV1 {
    public static final int FUAITYPE_BACKGROUNDSEGMENTATION = 2;
    public static final int FUAITYPE_BACKGROUNDSEGMENTATION_GREEN = 512;
    public static final int FUAITYPE_FACELANDMARKS209 = 64;
    public static final int FUAITYPE_FACELANDMARKS239 = 128;
    public static final int FUAITYPE_FACELANDMARKS75 = 32;
    public static final int FUAITYPE_FACEPROCESSOR = 1024;
    public static final int FUAITYPE_HAIRSEGMENTATION = 4;
    public static final int FUAITYPE_HANDGESTURE = 8;
    public static final int FUAITYPE_HUMANPOSE2D = 256;
    public static final int FUAITYPE_TONGUETRACKING = 16;

    public static void done() {
        NvsUtils.checkFunctionInMainThread();
        NvsFaceEffectV1.nativeDone();
    }

    public static int isAIModelLoaded(int n10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsFaceEffectV1.nativeIsAIModelLoaded(n10);
    }

    public static void loadAiModule(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        NvsFaceEffectV1.nativeLoadAiModule(string2, n10);
    }

    private static native void nativeDone();

    private static native int nativeIsAIModelLoaded(int var0);

    private static native void nativeLoadAiModule(String var0, int var1);

    private static native int nativeReleaseAiModule(int var0);

    private static native void nativeSetMaxFaces(int var0);

    private static native void nativeSetup(String var0, byte[] var1);

    public static int releaseAiModule(int n10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsFaceEffectV1.nativeReleaseAiModule(n10);
    }

    public static void setMaxFaces(int n10) {
        NvsUtils.checkFunctionInMainThread();
        NvsFaceEffectV1.nativeSetMaxFaces(n10);
    }

    public static void setup(String string2, byte[] byArray) {
        NvsUtils.checkFunctionInMainThread();
        NvsFaceEffectV1.nativeSetup(string2, byArray);
    }
}

