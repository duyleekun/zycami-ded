/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.engine.faceunity;

public final class FaceUnityPlatform$Key
extends Enum {
    public static final /* enum */ FaceUnityPlatform$Key KEY_FACE_AI;
    public static final /* enum */ FaceUnityPlatform$Key KEY_FACE_BEAUTIFUL;
    private static final /* synthetic */ FaceUnityPlatform$Key[] a;

    static {
        FaceUnityPlatform$Key faceUnityPlatform$Key;
        FaceUnityPlatform$Key faceUnityPlatform$Key2;
        KEY_FACE_AI = faceUnityPlatform$Key2 = new FaceUnityPlatform$Key("KEY_FACE_AI", 0);
        int n10 = 1;
        KEY_FACE_BEAUTIFUL = faceUnityPlatform$Key = new FaceUnityPlatform$Key("KEY_FACE_BEAUTIFUL", n10);
        FaceUnityPlatform$Key[] faceUnityPlatform$KeyArray = new FaceUnityPlatform$Key[2];
        faceUnityPlatform$KeyArray[0] = faceUnityPlatform$Key2;
        faceUnityPlatform$KeyArray[n10] = faceUnityPlatform$Key;
        a = faceUnityPlatform$KeyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FaceUnityPlatform$Key() {
        void var2_-1;
        void var1_-1;
    }

    public static FaceUnityPlatform$Key valueOf(String string2) {
        return Enum.valueOf(FaceUnityPlatform$Key.class, string2);
    }

    public static FaceUnityPlatform$Key[] values() {
        return (FaceUnityPlatform$Key[])a.clone();
    }
}

