/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

public interface GlSyncToken {
    public void release();

    public void waitOnCpu();

    public void waitOnGpu();
}

