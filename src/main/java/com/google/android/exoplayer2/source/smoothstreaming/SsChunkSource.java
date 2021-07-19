/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;

public interface SsChunkSource
extends ChunkSource {
    public void updateManifest(SsManifest var1);

    public void updateTrackSelection(ExoTrackSelection var1);
}

