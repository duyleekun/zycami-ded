/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.List;

public interface DashChunkSource$Factory {
    public DashChunkSource createDashChunkSource(LoaderErrorThrower var1, DashManifest var2, int var3, int[] var4, ExoTrackSelection var5, int var6, long var7, boolean var9, List var10, PlayerEmsgHandler.PlayerTrackEmsgHandler var11, TransferListener var12);
}

