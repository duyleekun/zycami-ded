/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.DummyDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.Cache$CacheException;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$1;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$EventListener;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

public final class CacheDataSource
implements DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    private static final int CACHE_NOT_IGNORED = 255;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final long MIN_READ_BEFORE_CHECKING_CACHE = 102400L;
    private Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private long checkCachePosition;
    private DataSource currentDataSource;
    private boolean currentDataSpecLengthUnset;
    private CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;
    private final CacheDataSource$EventListener eventListener;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private long readPosition;
    private DataSpec requestDataSpec;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;

    public CacheDataSource(Cache cache, DataSource dataSource) {
        this(cache, dataSource, 0);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, int n10) {
        FileDataSource fileDataSource = new FileDataSource();
        CacheDataSink cacheDataSink = new CacheDataSink(cache, 0x500000L);
        this(cache, dataSource, fileDataSource, cacheDataSink, n10, null);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int n10, CacheDataSource$EventListener cacheDataSource$EventListener) {
        this(cache, dataSource, dataSource2, dataSink, n10, cacheDataSource$EventListener, null);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int n10, CacheDataSource$EventListener cacheDataSource$EventListener, CacheKeyFactory cacheKeyFactory) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, n10, null, 0, cacheDataSource$EventListener);
    }

    private CacheDataSource(Cache object, DataSource dataSource, DataSource dataSource2, DataSink dataSink, CacheKeyFactory cacheKeyFactory, int n10, PriorityTaskManager priorityTaskManager, int n11, CacheDataSource$EventListener cacheDataSource$EventListener) {
        this.cache = object;
        this.cacheReadDataSource = dataSource2;
        if (cacheKeyFactory == null) {
            cacheKeyFactory = CacheKeyFactory.DEFAULT;
        }
        this.cacheKeyFactory = cacheKeyFactory;
        int n12 = n10 & 1;
        int n13 = 0;
        dataSource2 = null;
        int n14 = 1;
        if (n12 != 0) {
            n12 = n14;
        } else {
            n12 = 0;
            object = null;
        }
        this.blockOnCache = n12;
        n12 = n10 & 2;
        if (n12 != 0) {
            n12 = n14;
        } else {
            n12 = 0;
            object = null;
        }
        this.ignoreCacheOnError = n12;
        n12 = n10 & 4;
        if (n12 != 0) {
            n13 = n14;
        }
        this.ignoreCacheForUnsetLengthRequests = n13;
        n12 = 0;
        object = null;
        if (dataSource != null) {
            if (priorityTaskManager != null) {
                super(dataSource, priorityTaskManager, n11);
                dataSource = dataSource2;
            }
            this.upstreamDataSource = dataSource;
            if (dataSink != null) {
                object = new TeeDataSource(dataSource, dataSink);
            }
            this.cacheWriteDataSource = object;
        } else {
            this.upstreamDataSource = dataSource = DummyDataSource.INSTANCE;
            this.cacheWriteDataSource = null;
        }
        this.eventListener = cacheDataSource$EventListener;
    }

    public /* synthetic */ CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, CacheKeyFactory cacheKeyFactory, int n10, PriorityTaskManager priorityTaskManager, int n11, CacheDataSource$EventListener cacheDataSource$EventListener, CacheDataSource$1 cacheDataSource$1) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, n10, priorityTaskManager, n11, cacheDataSource$EventListener);
    }

    private void closeCurrentSource() {
        Object object = this.currentDataSource;
        if (object == null) {
            return;
        }
        Object object2 = null;
        try {
            object.close();
            return;
        }
        finally {
            this.currentDataSource = null;
            this.currentDataSpecLengthUnset = false;
            object = this.currentHoleSpan;
            if (object != null) {
                object2 = this.cache;
                object2.releaseHoleSpan((CacheSpan)object);
                this.currentHoleSpan = null;
            }
        }
    }

    private static Uri getRedirectedUriOrDefault(Cache cache, String string2, Uri object) {
        if ((cache = ContentMetadata.getRedirectedUri(cache.getContentMetadata(string2))) != null) {
            object = cache;
        }
        return object;
    }

    private void handleBeforeThrow(Throwable throwable) {
        boolean bl2;
        boolean bl3 = this.isReadingFromCache();
        if (bl3 || (bl2 = throwable instanceof Cache$CacheException)) {
            this.seenCacheError = bl2 = true;
        }
    }

    private boolean isBypassingCache() {
        boolean bl2;
        DataSource dataSource = this.currentDataSource;
        DataSource dataSource2 = this.upstreamDataSource;
        if (dataSource == dataSource2) {
            bl2 = true;
        } else {
            bl2 = false;
            dataSource = null;
        }
        return bl2;
    }

    private boolean isReadingFromCache() {
        boolean bl2;
        DataSource dataSource = this.currentDataSource;
        DataSource dataSource2 = this.cacheReadDataSource;
        if (dataSource == dataSource2) {
            bl2 = true;
        } else {
            bl2 = false;
            dataSource = null;
        }
        return bl2;
    }

    private boolean isReadingFromUpstream() {
        return this.isReadingFromCache() ^ true;
    }

    private boolean isWritingToCache() {
        boolean bl2;
        DataSource dataSource = this.currentDataSource;
        DataSource dataSource2 = this.cacheWriteDataSource;
        if (dataSource == dataSource2) {
            bl2 = true;
        } else {
            bl2 = false;
            dataSource = null;
        }
        return bl2;
    }

    private void notifyBytesRead() {
        long l10;
        long l11;
        long l12;
        long l13;
        CacheDataSource$EventListener cacheDataSource$EventListener = this.eventListener;
        if (cacheDataSource$EventListener != null && (l13 = (l12 = (l11 = this.totalCachedBytesRead) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            Cache cache = this.cache;
            l11 = cache.getCacheSpace();
            long l14 = this.totalCachedBytesRead;
            cacheDataSource$EventListener.onCachedBytesRead(l11, l14);
            this.totalCachedBytesRead = l10;
        }
    }

    private void notifyCacheIgnored(int n10) {
        CacheDataSource$EventListener cacheDataSource$EventListener = this.eventListener;
        if (cacheDataSource$EventListener != null) {
            cacheDataSource$EventListener.onCacheIgnored(n10);
        }
    }

    private void openNextSource(DataSpec dataSpec, boolean bl2) {
        int n10;
        boolean bl3;
        Object object;
        Object object2;
        long l10;
        long l11;
        Object object3;
        DataSource dataSource;
        String string2;
        long l12;
        Object object4;
        CacheDataSource cacheDataSource = this;
        Object object5 = dataSpec;
        String string3 = (String)Util.castNonNull(dataSpec.key);
        boolean bl4 = this.currentRequestIgnoresCache;
        Uri uri = null;
        if (bl4) {
            bl4 = false;
            object4 = null;
        } else {
            bl4 = this.blockOnCache;
            if (bl4) {
                try {
                    object4 = this.cache;
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    object5 = new InterruptedIOException();
                    throw object5;
                }
                long l13 = this.readPosition;
                l12 = this.bytesRemaining;
                string2 = string3;
                object4 = object4.startReadWrite(string3, l13, l12);
            } else {
                object4 = this.cache;
                long l14 = this.readPosition;
                l12 = this.bytesRemaining;
                string2 = string3;
                object4 = object4.startReadWriteNonBlocking(string3, l14, l12);
            }
        }
        long l15 = -1;
        if (object4 == null) {
            dataSource = cacheDataSource.upstreamDataSource;
            object3 = dataSpec.buildUpon();
            l11 = cacheDataSource.readPosition;
            object3 = ((DataSpec$Builder)object3).setPosition(l11);
            l11 = cacheDataSource.bytesRemaining;
            object3 = ((DataSpec$Builder)object3).setLength(l11).build();
        } else {
            boolean bl5 = ((CacheSpan)object4).isCached;
            if (bl5) {
                dataSource = Uri.fromFile((File)((File)Util.castNonNull(((CacheSpan)object4).file)));
                l12 = ((CacheSpan)object4).position;
                l11 = cacheDataSource.readPosition - l12;
                l10 = ((CacheSpan)object4).length - l11;
                long l16 = cacheDataSource.bytesRemaining;
                long l17 = l16 - l15;
                Object object6 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object6 != false) {
                    l10 = Math.min(l10, l16);
                }
                DataSpec$Builder dataSpec$Builder = dataSpec.buildUpon();
                object3 = dataSpec$Builder.setUri((Uri)dataSource).setUriPositionOffset(l12).setPosition(l11).setLength(l10).build();
                dataSource = cacheDataSource.cacheReadDataSource;
            } else {
                long l18;
                bl5 = ((CacheSpan)object4).isOpenEnded();
                if (bl5) {
                    l18 = cacheDataSource.bytesRemaining;
                } else {
                    l18 = ((CacheSpan)object4).length;
                    l11 = cacheDataSource.bytesRemaining;
                    long l19 = l11 - l15;
                    object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                    if (object2 != false) {
                        l18 = Math.min(l18, l11);
                    }
                }
                object = dataSpec.buildUpon();
                l11 = cacheDataSource.readPosition;
                object = ((DataSpec$Builder)object).setPosition(l11);
                object3 = ((DataSpec$Builder)object).setLength(l18).build();
                dataSource = cacheDataSource.cacheWriteDataSource;
                if (dataSource == null) {
                    dataSource = cacheDataSource.upstreamDataSource;
                    object = cacheDataSource.cache;
                    object.releaseHoleSpan((CacheSpan)object4);
                    bl4 = false;
                    object4 = null;
                }
            }
        }
        object2 = cacheDataSource.currentRequestIgnoresCache;
        if (object2 == false && dataSource == (object = cacheDataSource.upstreamDataSource)) {
            l11 = cacheDataSource.readPosition;
            l10 = 102400L;
            l11 += l10;
        } else {
            l11 = Long.MAX_VALUE;
        }
        cacheDataSource.checkCachePosition = l11;
        if (bl2) {
            object2 = this.isBypassingCache();
            Assertions.checkState((boolean)object2);
            object = cacheDataSource.upstreamDataSource;
            if (dataSource == object) {
                return;
            }
            try {
                this.closeCurrentSource();
            }
            catch (Throwable throwable) {
                object5 = (CacheSpan)Util.castNonNull(object4);
                boolean bl6 = ((CacheSpan)object5).isHoleSpan();
                if (bl6) {
                    object5 = cacheDataSource.cache;
                    object5.releaseHoleSpan((CacheSpan)object4);
                }
                throw throwable;
            }
        }
        if (object4 != null && (object2 = (Object)((CacheSpan)object4).isHoleSpan()) != false) {
            cacheDataSource.currentHoleSpan = object4;
        }
        cacheDataSource.currentDataSource = dataSource;
        l11 = ((DataSpec)object3).length;
        bl4 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1);
        object2 = 1;
        if (!bl4) {
            bl4 = object2;
        } else {
            bl4 = false;
            object4 = null;
        }
        cacheDataSource.currentDataSpecLengthUnset = bl4;
        l11 = dataSource.open((DataSpec)object3);
        object4 = new ContentMetadataMutations();
        boolean bl7 = cacheDataSource.currentDataSpecLengthUnset;
        if (bl7 && (bl3 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1))) {
            cacheDataSource.bytesRemaining = l11;
            l15 = cacheDataSource.readPosition + l11;
            ContentMetadataMutations.setContentLength((ContentMetadataMutations)object4, l15);
        }
        if (bl3 = this.isReadingFromUpstream()) {
            string2 = dataSource.getUri();
            cacheDataSource.actualUri = string2;
            object5 = ((DataSpec)object5).uri;
            n10 = object5.equals((Object)string2) ^ object2;
            if (n10 != 0) {
                uri = cacheDataSource.actualUri;
            }
            ContentMetadataMutations.setRedirectedUri((ContentMetadataMutations)object4, uri);
        }
        if ((n10 = this.isWritingToCache()) != 0) {
            object5 = cacheDataSource.cache;
            object5.applyContentMetadataMutations(string3, (ContentMetadataMutations)object4);
        }
    }

    private void setNoBytesRemainingAndMaybeStoreLength(String string2) {
        long l10;
        this.bytesRemaining = l10 = 0L;
        boolean bl2 = this.isWritingToCache();
        if (bl2) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            long l11 = this.readPosition;
            ContentMetadataMutations.setContentLength(contentMetadataMutations, l11);
            Cache cache = this.cache;
            cache.applyContentMetadataMutations(string2, contentMetadataMutations);
        }
    }

    private int shouldIgnoreCacheForRequest(DataSpec dataSpec) {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2 = this.ignoreCacheOnError;
        if (bl2 && (bl2 = this.seenCacheError)) {
            return 0;
        }
        bl2 = this.ignoreCacheForUnsetLengthRequests;
        if (bl2 && (l13 = (l12 = (l11 = dataSpec.length) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            return 1;
        }
        return -1;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.cacheReadDataSource.addTransferListener(transferListener);
        this.upstreamDataSource.addTransferListener(transferListener);
    }

    public void close() {
        long l10;
        Object var1_1 = null;
        this.requestDataSpec = null;
        this.actualUri = null;
        this.readPosition = l10 = 0L;
        this.notifyBytesRead();
        try {
            this.closeCurrentSource();
            return;
        }
        catch (Throwable throwable) {
            this.handleBeforeThrow(throwable);
            throw throwable;
        }
    }

    public Cache getCache() {
        return this.cache;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    public Map getResponseHeaders() {
        boolean bl2 = this.isReadingFromUpstream();
        Map map = bl2 ? this.upstreamDataSource.getResponseHeaders() : Collections.emptyMap();
        return map;
    }

    public Uri getUri() {
        return this.actualUri;
    }

    public long open(DataSpec object) {
        Object object2;
        block30: {
            long l10;
            block29: {
                long l11;
                long l12;
                long l13;
                Cache cache;
                Object object3;
                block28: {
                    int n10;
                    int n11;
                    block27: {
                        try {
                            object3 = this.cacheKeyFactory;
                        }
                        catch (Throwable throwable) {
                            this.handleBeforeThrow(throwable);
                            throw throwable;
                        }
                        object3 = object3.buildCacheKey((DataSpec)object);
                        object2 = ((DataSpec)object).buildUpon();
                        object2 = ((DataSpec$Builder)object2).setKey((String)object3);
                        object2 = ((DataSpec$Builder)object2).build();
                        this.requestDataSpec = object2;
                        cache = this.cache;
                        Uri uri = ((DataSpec)object2).uri;
                        cache = CacheDataSource.getRedirectedUriOrDefault(cache, (String)object3, uri);
                        this.actualUri = cache;
                        l10 = ((DataSpec)object).position;
                        this.readPosition = l10;
                        n11 = this.shouldIgnoreCacheForRequest((DataSpec)object);
                        n10 = -1;
                        if (n11 != n10) {
                            n10 = 1;
                            break block27;
                        }
                        n10 = 0;
                        uri = null;
                    }
                    this.currentRequestIgnoresCache = n10;
                    if (n10 == 0) break block28;
                    this.notifyCacheIgnored(n11);
                }
                if ((l13 = (l12 = (l10 = ((DataSpec)object).length) - (l11 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                    l13 = (long)this.currentRequestIgnoresCache;
                    if (l13 != false) break block29;
                    cache = this.cache;
                    object3 = cache.getContentMetadata((String)object3);
                    l10 = ContentMetadata.getContentLength((ContentMetadata)object3);
                    this.bytesRemaining = l10;
                    long l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (l14 == false) break block30;
                    l11 = ((DataSpec)object).position;
                    l10 -= l11;
                    this.bytesRemaining = l10;
                    l11 = 0L;
                    long l15 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (l15 > 0) break block30;
                    object = new DataSourceException(0);
                    throw object;
                }
            }
            this.bytesRemaining = l10;
        }
        this.openNextSource((DataSpec)object2, false);
        return this.bytesRemaining;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read(byte[] object, int n10, int n11) {
        int n12;
        Object object2;
        DataSpec dataSpec = (DataSpec)Assertions.checkNotNull(this.requestDataSpec);
        if (object2 == false) {
            return 0;
        }
        long l10 = this.bytesRemaining;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n13 = -1;
        if (l12 == false) {
            return n13;
        }
        try {
            long l13 = this.readPosition;
            long l14 = this.checkCachePosition;
            l12 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
            if (l12 >= 0) {
                l12 = 1;
                this.openNextSource(dataSpec, (boolean)l12);
            }
            Object object3 = this.currentDataSource;
            object3 = Assertions.checkNotNull(object3);
            object3 = (DataSource)object3;
            l12 = object3.read((byte[])object, n12, (int)object2);
            l13 = -1;
            if (l12 != n13) {
                long l15;
                boolean bl2 = this.isReadingFromCache();
                if (bl2) {
                    l15 = this.totalCachedBytesRead;
                    l11 = l12;
                    this.totalCachedBytesRead = l15 += l11;
                }
                l15 = this.readPosition;
                l11 = l12;
                this.readPosition = l15 += l11;
                l15 = this.bytesRemaining;
                long l16 = l15 - l13;
                object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object2 == false) return (int)l12;
                this.bytesRemaining = l15 -= l11;
                return (int)l12;
            }
            boolean bl3 = this.currentDataSpecLengthUnset;
            if (bl3) {
                String string2 = dataSpec.key;
                Object object4 = Util.castNonNull(string2);
                String string3 = (String)object4;
                this.setNoBytesRemainingAndMaybeStoreLength(string3);
                return (int)l12;
            }
            l14 = this.bytesRemaining;
            long l17 = l14 - l11;
            Object object5 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object5 <= 0) {
                Object object6 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1);
                if (object6 != false) return (int)l12;
            }
            this.closeCurrentSource();
            this.openNextSource(dataSpec, false);
            return this.read((byte[])object, n12, (int)object2);
        }
        catch (Throwable throwable) {
            this.handleBeforeThrow(throwable);
            throw throwable;
        }
        catch (IOException iOException) {
            n12 = this.currentDataSpecLengthUnset;
            if (n12 != 0 && (n12 = DataSourceException.isCausedByPositionOutOfRange(iOException)) != 0) {
                String string4 = (String)Util.castNonNull(dataSpec.key);
                this.setNoBytesRemainingAndMaybeStoreLength(string4);
                return n13;
            }
            this.handleBeforeThrow(iOException);
            throw iOException;
        }
    }
}

