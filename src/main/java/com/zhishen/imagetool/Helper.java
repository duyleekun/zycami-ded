/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package com.zhishen.imagetool;

import android.content.res.AssetManager;

public class Helper {
    public static native int Pano(long[] var0, String var1, double var2);

    public static void a() {
        System.loadLibrary("imageTool");
    }

    public static native void initResource(AssetManager var0);

    public native void kk3();

    public native String stringFromJNI();
}

