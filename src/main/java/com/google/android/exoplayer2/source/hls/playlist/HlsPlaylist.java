/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

public abstract class HlsPlaylist
implements FilterableManifest {
    public final String baseUri;
    public final boolean hasIndependentSegments;
    public final List tags;

    public HlsPlaylist(String object, List list, boolean bl2) {
        this.baseUri = object;
        this.tags = object = Collections.unmodifiableList(list);
        this.hasIndependentSegments = bl2;
    }
}

