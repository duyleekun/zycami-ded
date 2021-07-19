/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsARSceneManipulate$NvsARSceneManipulateCallback;

public class NvsARSceneManipulate {
    public NvsARSceneManipulate$NvsARSceneManipulateCallback m_callback = null;
    private long m_contextInterface;

    private native void nativeCleanup(long var1);

    private native void nativeResetSkinColor(long var1);

    private native void nativeResetTracking(long var1);

    private native void nativeSetARSceneManipulateCallback(long var1, NvsARSceneManipulate$NvsARSceneManipulateCallback var3);

    private native void nativeSetDetectionAutoProbe(long var1, boolean var3);

    private native void nativeSetDetectionMode(long var1, int var3);

    public void finalize() {
        this.release();
        super.finalize();
    }

    public void release() {
        this.m_callback = null;
        long l10 = this.m_contextInterface;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeCleanup(l10);
            this.m_contextInterface = l11;
        }
    }

    public void resetSkinColor() {
        long l10 = this.m_contextInterface;
        this.nativeResetSkinColor(l10);
    }

    public void resetTracking() {
        long l10 = this.m_contextInterface;
        this.nativeResetTracking(l10);
    }

    public void setARSceneCallback(NvsARSceneManipulate$NvsARSceneManipulateCallback nvsARSceneManipulate$NvsARSceneManipulateCallback) {
        this.m_callback = nvsARSceneManipulate$NvsARSceneManipulateCallback;
        long l10 = this.m_contextInterface;
        this.nativeSetARSceneManipulateCallback(l10, nvsARSceneManipulate$NvsARSceneManipulateCallback);
    }

    public void setContextInterface(long l10) {
        this.m_contextInterface = l10;
    }

    public void setDetectionAutoProbe(boolean bl2) {
        long l10 = this.m_contextInterface;
        this.nativeSetDetectionAutoProbe(l10, bl2);
    }

    public void setDetectionMode(int n10) {
        long l10 = this.m_contextInterface;
        this.nativeSetDetectionMode(l10, n10);
    }
}

