/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.sign;

import android.content.Context;

public class NativeSignHelper {
    static {
        System.loadLibrary("leancloud-core");
    }

    public static native String generateRequestAuth();

    public static native void initialize(Context var0);

    public static native String version();
}

