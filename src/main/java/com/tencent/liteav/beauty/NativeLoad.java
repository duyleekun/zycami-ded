/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.beauty;

import android.util.Log;
import com.tencent.liteav.basic.util.g;
import java.nio.ByteBuffer;

public class NativeLoad {
    private static final String TAG = "NativeLoad";

    static {
        g.f();
        NativeLoad.OnLoadBeauty();
        Log.i((String)TAG, (String)"NativeLoad: load jni");
    }

    private NativeLoad() {
    }

    public static native void OnLoadBeauty();

    public static native void nativeClearQueue();

    public static native void nativeDeleteYuv2Yuv();

    public static native void nativeGlMapBufferToQueue(int var0, int var1, ByteBuffer var2);

    public static native void nativeGlReadPixs(int var0, int var1, byte[] var2);

    public static native boolean nativeGlReadPixsFromQueue(int var0, int var1, byte[] var2);

    public static native void nativeGlReadPixsToQueue(int var0, int var1);

    public static native int nativeLoadGLProgram(int var0);

    public static native void nativeglTexImage2D(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, byte[] var8, int var9);
}

