/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import java.util.List;

public interface ChunkSource {
    public long getAdjustedSeekPositionUs(long var1, SeekParameters var3);

    public void getNextChunk(long var1, long var3, List var5, ChunkHolder var6);

    public int getPreferredQueueSize(long var1, List var3);

    public void maybeThrowError();

    public void onChunkLoadCompleted(Chunk var1);

    public boolean onChunkLoadError(Chunk var1, boolean var2, Exception var3, long var4);

    public void release();

    public boolean shouldCancelLoad(long var1, Chunk var3, List var4);
}

