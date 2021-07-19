/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.Downloader$ProgressListener;
import com.google.android.exoplayer2.offline.ProgressiveDownloader$1;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.PriorityTaskManager$PriorityTooLowException;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.k0.m;
import d.h.a.a.k0.n;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class ProgressiveDownloader
implements Downloader {
    private final CacheWriter cacheWriter;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private volatile RunnableFutureTask downloadRunnable;
    private final Executor executor;
    private volatile boolean isCanceled;
    private final PriorityTaskManager priorityTaskManager;
    private Downloader$ProgressListener progressListener;

    public ProgressiveDownloader(Uri uri, String string2, CacheDataSource$Factory cacheDataSource$Factory) {
        m m10 = m.a;
        this(uri, string2, cacheDataSource$Factory, m10);
    }

    public ProgressiveDownloader(Uri object, String string2, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).setCustomCacheKey(string2).build();
        this((MediaItem)object, cacheDataSource$Factory, executor);
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource$Factory cacheDataSource$Factory) {
        m m10 = m.a;
        this(mediaItem, cacheDataSource$Factory, m10);
    }

    public ProgressiveDownloader(MediaItem object, CacheDataSource$Factory cacheDataSource$Factory, Executor object2) {
        CacheDataSource cacheDataSource;
        DataSpec dataSpec;
        object2 = (Executor)Assertions.checkNotNull(object2);
        this.executor = object2;
        Assertions.checkNotNull(((MediaItem)object).playbackProperties);
        object2 = new DataSpec$Builder();
        Object object3 = object.playbackProperties.uri;
        object2 = ((DataSpec$Builder)object2).setUri((Uri)object3);
        object = object.playbackProperties.customCacheKey;
        this.dataSpec = dataSpec = ((DataSpec$Builder)object2).setKey((String)object).setFlags(4).build();
        this.dataSource = cacheDataSource = cacheDataSource$Factory.createDataSourceForDownloading();
        n n10 = new n(this);
        object3 = object;
        this.cacheWriter = object = new CacheWriter(cacheDataSource, dataSpec, false, null, n10);
        this.priorityTaskManager = object = cacheDataSource$Factory.getUpstreamPriorityTaskManager();
    }

    public static /* synthetic */ void a(ProgressiveDownloader progressiveDownloader, long l10, long l11, long l12) {
        progressiveDownloader.onProgress(l10, l11, l12);
    }

    public static /* synthetic */ CacheWriter access$000(ProgressiveDownloader progressiveDownloader) {
        return progressiveDownloader.cacheWriter;
    }

    private void onProgress(long l10, long l11, long l12) {
        float f10;
        long l13;
        Downloader$ProgressListener downloader$ProgressListener = this.progressListener;
        if (downloader$ProgressListener == null) {
            return;
        }
        l12 = -1;
        long l14 = l10 - l12;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false && (object = (l13 = l10 - (l12 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            f10 = (float)l11 * 100.0f;
            float f11 = l10;
            f10 /= f11;
        } else {
            object = -1082130432;
            f10 = -1.0f;
        }
        downloader$ProgressListener.onProgress(l10, l11, f10);
    }

    public void cancel() {
        boolean bl2;
        this.isCanceled = bl2 = true;
        RunnableFutureTask runnableFutureTask = this.downloadRunnable;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(bl2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void download(Downloader$ProgressListener var1_1) {
        this.progressListener = var1_1;
        this.downloadRunnable = var1_1 = new ProgressiveDownloader$1(this);
        var1_1 = this.priorityTaskManager;
        var2_3 = -1000;
        if (var1_1 != null) {
            var1_1.add(var2_3);
        }
        var3_4 = false;
        var1_1 = null;
        while (!var3_4) {
            var4_5 = this.isCanceled;
            if (var4_5) break;
            var5_6 = this.priorityTaskManager;
            if (var5_6 != null) {
                var5_6.proceed(var2_3);
            }
            var5_6 = this.executor;
            var6_8 = this.downloadRunnable;
            var5_6.execute(var6_8);
            try {
                var5_6 = this.downloadRunnable;
                var5_6.get();
                var3_4 = true;
            }
            catch (ExecutionException var5_7) {
                var5_6 = var5_7.getCause();
                var5_6 = Assertions.checkNotNull(var5_6);
                var7_9 = (var5_6 = (Throwable)var5_6) instanceof PriorityTaskManager$PriorityTooLowException;
                if (var7_9) continue;
                var7_9 = var5_6 instanceof IOException;
                if (var7_9) ** GOTO lbl35
                try {
                    Util.sneakyThrow((Throwable)var5_6);
                    continue;
lbl35:
                    // 1 sources

                    var5_6 = (IOException)var5_6;
                    throw var5_6;
                }
                catch (Throwable var1_2) {
                    this.downloadRunnable.blockUntilFinished();
                    var5_6 = this.priorityTaskManager;
                    if (var5_6 != null) {
                        var5_6.remove(var2_3);
                    }
                    throw var1_2;
                }
            }
        }
        this.downloadRunnable.blockUntilFinished();
        var1_1 = this.priorityTaskManager;
        if (var1_1 != null) {
            var1_1.remove(var2_3);
        }
    }

    public void remove() {
        Cache cache = this.dataSource.getCache();
        Object object = this.dataSource.getCacheKeyFactory();
        DataSpec dataSpec = this.dataSpec;
        object = object.buildCacheKey(dataSpec);
        cache.removeResource((String)object);
    }
}

