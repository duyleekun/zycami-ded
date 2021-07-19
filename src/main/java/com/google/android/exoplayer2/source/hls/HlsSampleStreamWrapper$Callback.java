/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.source.SequenceableLoader$Callback;

public interface HlsSampleStreamWrapper$Callback
extends SequenceableLoader$Callback {
    public void onPlaylistRefreshRequired(Uri var1);

    public void onPrepared();
}

