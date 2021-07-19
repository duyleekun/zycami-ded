/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.meicam.sdk;

import android.graphics.Bitmap;
import com.meicam.sdk.NvsIconGenerator$IconCallback;
import com.meicam.sdk.NvsUtils;

public class NvsIconGenerator {
    public static final int GET_ICON_FLAGS_KEY_FRAME = 1;
    private final String TAG;
    private NvsIconGenerator$IconCallback m_iconCallback;
    private long m_iconGenerator = 0L;

    public NvsIconGenerator() {
        long l10;
        this.TAG = "Meicam";
        NvsUtils.checkFunctionInMainThread();
        this.m_iconGenerator = l10 = this.nativeInit();
    }

    private native void nativeCancelTask(long var1, long var3);

    private native void nativeClose(long var1);

    private native long nativeGetIcon(long var1, String var3, long var4, int var6);

    private native Bitmap nativeGetIconFromCache(long var1, String var3, long var4, int var6);

    private native long nativeInit();

    public void cancelTask(long l10) {
        NvsUtils.checkFunctionInMainThread();
        boolean bl2 = this.isReleased();
        if (!bl2) {
            long l11 = this.m_iconGenerator;
            this.nativeCancelTask(l11, l10);
        }
    }

    public long getIcon(String string2, long l10, int n10) {
        NvsUtils.checkFunctionInMainThread();
        boolean bl2 = this.isReleased();
        if (bl2) {
            return 0L;
        }
        long l11 = this.m_iconGenerator;
        return this.nativeGetIcon(l11, string2, l10, n10);
    }

    public Bitmap getIconFromCache(String string2, long l10, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_iconGenerator;
        return this.nativeGetIconFromCache(l11, string2, l10, n10);
    }

    public boolean isReleased() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_iconGenerator;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 == false ? (long)1 : (long)0;
        return (boolean)l12;
    }

    public void notifyIconReady(Bitmap bitmap, long l10, long l11) {
        NvsIconGenerator$IconCallback nvsIconGenerator$IconCallback = this.m_iconCallback;
        if (nvsIconGenerator$IconCallback != null) {
            nvsIconGenerator$IconCallback.onIconReady(bitmap, l10, l11);
        }
    }

    public void release() {
        NvsUtils.checkFunctionInMainThread();
        boolean bl2 = this.isReleased();
        if (bl2) {
            return;
        }
        this.m_iconCallback = null;
        long l10 = this.m_iconGenerator;
        this.nativeClose(l10);
        this.m_iconGenerator = 0L;
    }

    public void setIconCallback(NvsIconGenerator$IconCallback nvsIconGenerator$IconCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_iconCallback = nvsIconGenerator$IconCallback;
    }
}

