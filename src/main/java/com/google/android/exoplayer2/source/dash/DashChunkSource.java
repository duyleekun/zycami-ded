/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;

public interface DashChunkSource
extends ChunkSource {
    public void updateManifest(DashManifest var1, int var2);

    public void updateTrackSelection(ExoTrackSelection var1);
}

