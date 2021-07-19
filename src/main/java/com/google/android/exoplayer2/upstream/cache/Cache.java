/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache$Listener;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import java.io.File;
import java.util.NavigableSet;
import java.util.Set;

public interface Cache {
    public static final long UID_UNSET = 255L;

    public NavigableSet addListener(String var1, Cache$Listener var2);

    public void applyContentMetadataMutations(String var1, ContentMetadataMutations var2);

    public void commitFile(File var1, long var2);

    public long getCacheSpace();

    public long getCachedBytes(String var1, long var2, long var4);

    public long getCachedLength(String var1, long var2, long var4);

    public NavigableSet getCachedSpans(String var1);

    public ContentMetadata getContentMetadata(String var1);

    public Set getKeys();

    public long getUid();

    public boolean isCached(String var1, long var2, long var4);

    public void release();

    public void releaseHoleSpan(CacheSpan var1);

    public void removeListener(String var1, Cache$Listener var2);

    public void removeResource(String var1);

    public void removeSpan(CacheSpan var1);

    public File startFile(String var1, long var2, long var4);

    public CacheSpan startReadWrite(String var1, long var2, long var4);

    public CacheSpan startReadWriteNonBlocking(String var1, long var2, long var4);
}

