/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.mediapipe.framework.GlSyncToken;

public final class GraphGlSyncToken
implements GlSyncToken {
    private long token;

    public GraphGlSyncToken(long l10) {
        this.token = l10;
    }

    private static native void nativeRelease(long var0);

    private static native void nativeWaitOnCpu(long var0);

    private static native void nativeWaitOnGpu(long var0);

    public void release() {
        long l10 = this.token;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            GraphGlSyncToken.nativeRelease(l10);
            this.token = l11;
        }
    }

    public void waitOnCpu() {
        long l10 = this.token;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            GraphGlSyncToken.nativeWaitOnCpu(l10);
        }
    }

    public void waitOnGpu() {
        long l10 = this.token;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            GraphGlSyncToken.nativeWaitOnGpu(l10);
        }
    }
}

