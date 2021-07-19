/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.source.chunk.Chunk;

public final class HlsChunkSource$HlsChunkHolder {
    public Chunk chunk;
    public boolean endOfStream;
    public Uri playlistUrl;

    public HlsChunkSource$HlsChunkHolder() {
        this.clear();
    }

    public void clear() {
        this.chunk = null;
        this.endOfStream = false;
        this.playlistUrl = null;
    }
}

