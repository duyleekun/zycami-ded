/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache$1;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedHashMap;

public final class FullSegmentEncryptionKeyCache {
    private final LinkedHashMap backingMap;

    public FullSegmentEncryptionKeyCache(int n10) {
        int n11 = n10 + 1;
        FullSegmentEncryptionKeyCache$1 fullSegmentEncryptionKeyCache$1 = new FullSegmentEncryptionKeyCache$1(this, n11, 1.0f, false, n10);
        this.backingMap = fullSegmentEncryptionKeyCache$1;
    }

    public boolean containsUri(Uri object) {
        LinkedHashMap linkedHashMap = this.backingMap;
        object = Assertions.checkNotNull(object);
        return linkedHashMap.containsKey(object);
    }

    public byte[] get(Uri uri) {
        if (uri == null) {
            return null;
        }
        return (byte[])this.backingMap.get(uri);
    }

    public byte[] put(Uri uri, byte[] byArray) {
        LinkedHashMap linkedHashMap = this.backingMap;
        uri = (Uri)Assertions.checkNotNull(uri);
        byArray = (byte[])Assertions.checkNotNull(byArray);
        return linkedHashMap.put(uri, byArray);
    }

    public byte[] remove(Uri object) {
        LinkedHashMap linkedHashMap = this.backingMap;
        object = Assertions.checkNotNull(object);
        return (byte[])linkedHashMap.remove(object);
    }
}

