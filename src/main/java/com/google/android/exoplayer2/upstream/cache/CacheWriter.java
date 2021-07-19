/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter$ProgressListener;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class CacheWriter {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    private final boolean allowShortContent;
    private long bytesCached;
    private final Cache cache;
    private final String cacheKey;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private long endPosition;
    private boolean initialized;
    private volatile boolean isCanceled;
    private long nextPosition;
    private final CacheWriter$ProgressListener progressListener;
    private final byte[] temporaryBuffer;

    /*
     * WARNING - void declaration
     */
    public CacheWriter(CacheDataSource object, DataSpec dataSpec, boolean bl2, byte[] byArray, CacheWriter$ProgressListener cacheWriter$ProgressListener) {
        long l10;
        void var5_6;
        byte[] byArray2;
        Cache cache;
        this.dataSource = object;
        this.cache = cache = ((CacheDataSource)object).getCache();
        this.dataSpec = dataSpec;
        this.allowShortContent = bl2;
        if (byArray2 == null) {
            int n10 = 131072;
            byArray2 = new byte[n10];
        }
        this.temporaryBuffer = byArray2;
        this.progressListener = var5_6;
        this.cacheKey = object = ((CacheDataSource)object).getCacheKeyFactory().buildCacheKey(dataSpec);
        this.nextPosition = l10 = dataSpec.position;
    }

    private long getLength() {
        long l10 = this.endPosition;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            DataSpec dataSpec = this.dataSpec;
            l11 = dataSpec.position;
            l11 = l10 - l11;
        }
        return l11;
    }

    private void onNewBytesCached(long l10) {
        long l11;
        this.bytesCached = l11 = this.bytesCached + l10;
        CacheWriter$ProgressListener cacheWriter$ProgressListener = this.progressListener;
        if (cacheWriter$ProgressListener != null) {
            long l12 = this.getLength();
            long l13 = this.bytesCached;
            cacheWriter$ProgressListener.onProgress(l12, l13, l10);
        }
    }

    private void onRequestEndPosition(long l10) {
        long l11 = this.endPosition;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        this.endPosition = l10;
        CacheWriter$ProgressListener cacheWriter$ProgressListener = this.progressListener;
        if (cacheWriter$ProgressListener != null) {
            long l13 = this.getLength();
            long l14 = this.bytesCached;
            long l15 = 0L;
            cacheWriter$ProgressListener.onProgress(l13, l14, l15);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long readBlockToCache(long l10, long l11) {
        int n10;
        block13: {
            Throwable throwable2;
            block12: {
                CacheDataSource cacheDataSource;
                Object object;
                long l12;
                int n11;
                long l13;
                long l14;
                block10: {
                    block11: {
                        l14 = l10 + l11;
                        long l15 = this.endPosition;
                        l13 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
                        n11 = 1;
                        l12 = -1;
                        l13 = l13 != false && (l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) != false ? (long)0 : (long)n11;
                        long l16 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                        if (l16 != false) {
                            try {
                                try {
                                    Object object2 = this.dataSpec;
                                    object2 = ((DataSpec)object2).buildUpon();
                                    object2 = ((DataSpec$Builder)object2).setPosition(l10);
                                    object = ((DataSpec$Builder)object2).setLength(l11);
                                    object = ((DataSpec$Builder)object).build();
                                    cacheDataSource = this.dataSource;
                                    l11 = cacheDataSource.open((DataSpec)object);
                                    break block10;
                                }
                                catch (IOException iOException) {
                                    n10 = this.allowShortContent;
                                    if (n10 != 0 && l13 != false && (n10 = DataSourceException.isCausedByPositionOutOfRange(iOException)) != 0) {
                                        object = this.dataSource;
                                        Util.closeQuietly((DataSource)object);
                                        break block11;
                                    }
                                    throw iOException;
                                }
                            }
                            catch (Throwable throwable2) {
                                break block12;
                            }
                        }
                    }
                    n11 = 0;
                    l11 = l12;
                }
                if (n11 == 0) {
                    this.throwIfCanceled();
                    object = this.dataSpec;
                    object = ((DataSpec)object).buildUpon();
                    object = ((DataSpec$Builder)object).setPosition(l10);
                    object = ((DataSpec$Builder)object).setLength(l12);
                    object = ((DataSpec$Builder)object).build();
                    cacheDataSource = this.dataSource;
                    l11 = cacheDataSource.open((DataSpec)object);
                }
                if (l13 != false && (n11 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1))) != 0) {
                    this.onRequestEndPosition(l11 += l10);
                }
                int n12 = 0;
                object = null;
                n10 = 0;
                cacheDataSource = null;
                while (n12 != (n11 = -1)) {
                    this.throwIfCanceled();
                    object = this.dataSource;
                    byte[] byArray = this.temporaryBuffer;
                    int n13 = byArray.length;
                    n12 = ((CacheDataSource)object).read(byArray, 0, n13);
                    if (n12 == n11) continue;
                    l12 = n12;
                    this.onNewBytesCached(l12);
                    n10 += n12;
                }
                if (l13 != false) {
                    l14 = n10;
                    this.onRequestEndPosition(l10 += l14);
                }
                break block13;
            }
            Util.closeQuietly(this.dataSource);
            throw throwable2;
        }
        l10 = n10;
        Util.closeQuietly(this.dataSource);
        return l10;
    }

    private void throwIfCanceled() {
        boolean bl2 = this.isCanceled;
        if (!bl2) {
            return;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException();
        throw interruptedIOException;
    }

    public void cache() {
        long l10;
        long l11;
        long l12;
        long l13;
        this.throwIfCanceled();
        int n10 = this.initialized;
        long l14 = -1;
        if (n10 == 0) {
            Object object = this.dataSpec;
            l13 = ((DataSpec)object).length;
            long l15 = l13 - l14;
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 != false) {
                this.endPosition = l12 = ((DataSpec)object).position + l13;
            } else {
                object = this.cache;
                String string2 = this.cacheKey;
                l13 = ContentMetadata.getContentLength((ContentMetadata)(object = object.getContentMetadata(string2)));
                long l16 = l13 - l14;
                n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                if (n10 == 0) {
                    l13 = l14;
                }
                this.endPosition = l13;
            }
            Object object3 = this.cache;
            String string3 = this.cacheKey;
            object = this.dataSpec;
            l11 = ((DataSpec)object).position;
            l10 = ((DataSpec)object).length;
            this.bytesCached = l13 = object3.getCachedBytes(string3, l11, l10);
            object3 = this.progressListener;
            if (object3 != null) {
                long l17 = this.getLength();
                long l18 = this.bytesCached;
                long l19 = 0L;
                object3.onProgress(l17, l18, l19);
            }
            n10 = 1;
            this.initialized = n10;
        }
        long l20;
        long l21;
        while ((n10 = (l21 = (l13 = this.endPosition) - l14) == 0L ? 0 : (l21 < 0L ? -1 : 1)) == 0 || (n10 = (l20 = (l12 = this.nextPosition) - l13) == 0L ? 0 : (l20 < 0L ? -1 : 1)) < 0) {
            long l22;
            this.throwIfCanceled();
            l13 = this.endPosition;
            n10 = (int)(l13 == l14 ? 0 : (l13 < l14 ? -1 : 1));
            l12 = Long.MAX_VALUE;
            if (n10 == 0) {
                l22 = l12;
            } else {
                l11 = this.nextPosition;
                l22 = l13 -= l11;
            }
            Cache cache = this.cache;
            String string4 = this.cacheKey;
            l10 = this.nextPosition;
            l13 = cache.getCachedLength(string4, l10, l22);
            l11 = 0L;
            n10 = (int)(l13 == l11 ? 0 : (l13 < l11 ? -1 : 1));
            if (n10 > 0) {
                this.nextPosition = l12 = this.nextPosition + l13;
                continue;
            }
            long l23 = (l13 = -l13) - l12;
            n10 = (int)(l23 == 0L ? 0 : (l23 < 0L ? -1 : 1));
            if (n10 == 0) {
                l13 = l14;
            }
            l12 = this.nextPosition;
            l13 = this.readBlockToCache(l12, l13);
            this.nextPosition = l12 += l13;
        }
        return;
    }

    public void cancel() {
        this.isCanceled = true;
    }
}

