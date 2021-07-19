/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

public final class DefaultDrmSession$RequestTask {
    public final boolean allowRetry;
    public int errorCount;
    public final Object request;
    public final long startTimeMs;
    public final long taskId;

    public DefaultDrmSession$RequestTask(long l10, boolean bl2, long l11, Object object) {
        this.taskId = l10;
        this.allowRetry = bl2;
        this.startTimeMs = l11;
        this.request = object;
    }
}

