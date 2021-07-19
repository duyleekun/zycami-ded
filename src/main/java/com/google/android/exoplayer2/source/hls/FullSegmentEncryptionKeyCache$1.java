/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache;
import java.util.LinkedHashMap;
import java.util.Map;

public class FullSegmentEncryptionKeyCache$1
extends LinkedHashMap {
    public final /* synthetic */ int val$maxSize;

    public FullSegmentEncryptionKeyCache$1(FullSegmentEncryptionKeyCache fullSegmentEncryptionKeyCache, int n10, float f10, boolean bl2, int n11) {
        this.val$maxSize = n11;
        super(n10, f10, bl2);
    }

    public boolean removeEldestEntry(Map.Entry entry) {
        int n10;
        int n11 = this.size();
        n11 = n11 > (n10 = this.val$maxSize) ? 1 : 0;
        return n11 != 0;
    }
}

