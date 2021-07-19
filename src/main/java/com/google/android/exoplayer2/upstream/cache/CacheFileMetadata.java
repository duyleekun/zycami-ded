/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

public final class CacheFileMetadata {
    public final long lastTouchTimestamp;
    public final long length;

    public CacheFileMetadata(long l10, long l11) {
        this.length = l10;
        this.lastTouchTimestamp = l11;
    }
}

