/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.Downloader$ProgressListener;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.SegmentDownloader$1;
import com.google.android.exoplayer2.offline.SegmentDownloader$Segment;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.PriorityTaskManager$PriorityTooLowException;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public abstract class SegmentDownloader
implements Downloader {
    private static final int BUFFER_SIZE_BYTES = 131072;
    private static final long MAX_MERGED_SEGMENT_START_TIME_DIFF_US = 20000000L;
    private final ArrayList activeRunnables;
    private final Cache cache;
    private final CacheDataSource$Factory cacheDataSourceFactory;
    private final CacheKeyFactory cacheKeyFactory;
    private final Executor executor;
    private volatile boolean isCanceled;
    private final DataSpec manifestDataSpec;
    private final ParsingLoadable$Parser manifestParser;
    private final PriorityTaskManager priorityTaskManager;
    private final ArrayList streamKeys;

    public SegmentDownloader(MediaItem arrayList, ParsingLoadable$Parser arrayList2, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        DataSpec dataSpec;
        Assertions.checkNotNull(((MediaItem)arrayList).playbackProperties);
        this.manifestDataSpec = dataSpec = SegmentDownloader.getCompressibleDataSpec(arrayList.playbackProperties.uri);
        this.manifestParser = arrayList2;
        arrayList = arrayList.playbackProperties.streamKeys;
        this.streamKeys = arrayList2 = new ArrayList(arrayList);
        this.cacheDataSourceFactory = cacheDataSource$Factory;
        this.executor = executor;
        arrayList = (Cache)Assertions.checkNotNull(cacheDataSource$Factory.getCache());
        this.cache = arrayList;
        arrayList = cacheDataSource$Factory.getCacheKeyFactory();
        this.cacheKeyFactory = arrayList;
        arrayList = cacheDataSource$Factory.getUpstreamPriorityTaskManager();
        this.priorityTaskManager = arrayList;
        this.activeRunnables = arrayList = new ArrayList();
    }

    public static /* synthetic */ ParsingLoadable$Parser access$000(SegmentDownloader segmentDownloader) {
        return segmentDownloader.manifestParser;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void addActiveRunnable(RunnableFutureTask object) {
        ArrayList arrayList = this.activeRunnables;
        synchronized (arrayList) {
            boolean bl2 = this.isCanceled;
            if (!bl2) {
                ArrayList arrayList2 = this.activeRunnables;
                arrayList2.add(object);
                return;
            }
            object = new InterruptedException();
            throw object;
        }
    }

    private static boolean canMergeSegments(DataSpec object, DataSpec object2) {
        boolean bl2;
        int n10;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        Object object3 = ((DataSpec)object).uri;
        Object object4 = ((DataSpec)object2).uri;
        int n11 = object3.equals(object4);
        if (n11 != 0 && (l14 = (l13 = (l12 = ((DataSpec)object).length) - (l11 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false && (n11 = (l10 = (l11 = ((DataSpec)object).position + l12) - (l12 = ((DataSpec)object2).position)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == 0 && (n11 = Util.areEqual(object3 = ((DataSpec)object).key, object4 = ((DataSpec)object2).key)) != 0 && (n11 = ((DataSpec)object).flags) == (n10 = ((DataSpec)object2).flags) && (n11 = ((DataSpec)object).httpMethod) == (n10 = ((DataSpec)object2).httpMethod) && (bl2 = (object = ((DataSpec)object).httpRequestHeaders).equals(object2 = ((DataSpec)object2).httpRequestHeaders))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static DataSpec getCompressibleDataSpec(Uri uri) {
        DataSpec$Builder dataSpec$Builder = new DataSpec$Builder();
        return dataSpec$Builder.setUri(uri).setFlags(1).build();
    }

    private static void mergeSegments(List list, CacheKeyFactory cacheKeyFactory) {
        int n10;
        HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            SegmentDownloader$Segment segmentDownloader$Segment;
            int n12;
            Object object = (SegmentDownloader$Segment)list.get(i10);
            Object object2 = ((SegmentDownloader$Segment)object).dataSpec;
            Comparable<Integer> comparable = (Integer)hashMap.get(object2 = cacheKeyFactory.buildCacheKey((DataSpec)object2));
            if (comparable == null) {
                n12 = 0;
                segmentDownloader$Segment = null;
            } else {
                n12 = comparable;
                segmentDownloader$Segment = (SegmentDownloader$Segment)list.get(n12);
            }
            if (segmentDownloader$Segment != null) {
                DataSpec dataSpec;
                DataSpec dataSpec2;
                long l10 = ((SegmentDownloader$Segment)object).startTimeUs;
                long l11 = segmentDownloader$Segment.startTimeUs;
                long l12 = 20000000L;
                long l13 = l10 - (l11 += l12);
                Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object3 <= 0 && (object3 = (Object)SegmentDownloader.canMergeSegments(dataSpec2 = segmentDownloader$Segment.dataSpec, dataSpec = ((SegmentDownloader$Segment)object).dataSpec)) != false) {
                    object = ((SegmentDownloader$Segment)object).dataSpec;
                    long l14 = ((DataSpec)object).length;
                    l10 = -1;
                    long l15 = l14 - l10;
                    Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                    if (object4 != false) {
                        dataSpec2 = segmentDownloader$Segment.dataSpec;
                        l10 = dataSpec2.length + l14;
                    }
                    object = segmentDownloader$Segment.dataSpec;
                    l11 = 0L;
                    object = ((DataSpec)object).subrange(l11, l10);
                    object2 = (Integer)Assertions.checkNotNull(comparable);
                    int n13 = (Integer)object2;
                    long l16 = segmentDownloader$Segment.startTimeUs;
                    comparable = new SegmentDownloader$Segment(l16, (DataSpec)object);
                    list.set(n13, comparable);
                    continue;
                }
            }
            comparable = n11;
            hashMap.put(object2, (Integer)comparable);
            list.set(n11, object);
            ++n11;
        }
        int n14 = list.size();
        Util.removeRange(list, n11, n14);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void removeActiveRunnable(int n10) {
        ArrayList arrayList = this.activeRunnables;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.activeRunnables;
            arrayList2.remove(n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void removeActiveRunnable(RunnableFutureTask runnableFutureTask) {
        ArrayList arrayList = this.activeRunnables;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.activeRunnables;
            arrayList2.remove(runnableFutureTask);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancel() {
        ArrayList arrayList = this.activeRunnables;
        synchronized (arrayList) {
            boolean bl2;
            this.isCanceled = bl2 = true;
            int n10 = 0;
            Object object;
            int n11;
            while (n10 < (n11 = ((ArrayList)(object = this.activeRunnables)).size())) {
                object = this.activeRunnables;
                object = ((ArrayList)object).get(n10);
                object = (RunnableFutureTask)object;
                ((RunnableFutureTask)object).cancel(bl2);
                ++n10;
            }
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public final void download(Downloader$ProgressListener var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 27[TRYBLOCK] [29 : 455->458)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object execute(RunnableFutureTask var1_1, boolean var2_2) {
        if (var2_2) {
            var1_1.run();
            try {
                return var1_1.get();
            }
            catch (ExecutionException var3_3) {
                var4_7 = (Throwable)Assertions.checkNotNull(var3_3.getCause());
                var5_8 = var4_7 instanceof IOException;
                if (var5_8) {
                    throw (IOException)var4_7;
                }
                Util.sneakyThrow(var3_3);
            }
        }
        if (var2_2 = this.isCanceled) {
            var1_1 = new InterruptedException();
            throw var1_1;
        }
        var3_4 = this.priorityTaskManager;
        if (var3_4 != null) {
            var6_9 = -1000;
            var3_4.proceed(var6_9);
        }
        this.addActiveRunnable((RunnableFutureTask)var1_1);
        var3_4 = this.executor;
        var3_4.execute((Runnable)var1_1);
        var3_4 = var1_1.get();
        var1_1.blockUntilFinished();
        this.removeActiveRunnable((RunnableFutureTask)var1_1);
        return var3_4;
        {
            block13: {
                catch (ExecutionException var3_6) {}
                {
                    var4_7 = var3_6.getCause();
                    var4_7 = Assertions.checkNotNull(var4_7);
                    var4_7 = (Throwable)var4_7;
                }
                var5_8 = var4_7 instanceof PriorityTaskManager$PriorityTooLowException;
                if (var5_8) break block13;
                var5_8 = var4_7 instanceof IOException;
                if (var5_8) ** GOTO lbl-1000
                {
                    Util.sneakyThrow(var3_6);
                }
            }
            var1_1.blockUntilFinished();
            this.removeActiveRunnable((RunnableFutureTask)var1_1);
lbl-1000:
            // 1 sources

            {
                var4_7 = (IOException)var4_7;
                throw var4_7;
            }
        }
        ** finally { 
lbl41:
        // 1 sources

        var1_1.blockUntilFinished();
        this.removeActiveRunnable((RunnableFutureTask)var1_1);
        throw var3_5;
    }

    public final FilterableManifest getManifest(DataSource dataSource, DataSpec dataSpec, boolean bl2) {
        SegmentDownloader$1 segmentDownloader$1 = new SegmentDownloader$1(this, dataSource, dataSpec);
        return (FilterableManifest)this.execute(segmentDownloader$1, bl2);
    }

    public abstract List getSegments(DataSource var1, FilterableManifest var2, boolean var3);

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void remove() {
        Throwable throwable2222222;
        block6: {
            Object object;
            Object object2;
            Object object3;
            Object object4 = this.cacheDataSourceFactory.createDataSourceForRemovingDownload();
            Object object5 = this.manifestDataSpec;
            int n10 = 1;
            object5 = this.getManifest((DataSource)object4, (DataSpec)object5, n10 != 0);
            object4 = this.getSegments((DataSource)object4, (FilterableManifest)object5, n10 != 0);
            object5 = null;
            for (int n11 = 0; n11 < (n10 = object4.size()); object3 = object3.buildCacheKey((DataSpec)object2), ++n11) {
                object = this.cache;
                object3 = this.cacheKeyFactory;
                object2 = object4.get(n11);
                object2 = (SegmentDownloader$Segment)object2;
                object2 = ((SegmentDownloader$Segment)object2).dataSpec;
                object.removeResource((String)object3);
            }
            {
                catch (Throwable throwable2222222) {
                    break block6;
                }
                catch (Exception exception) {}
                catch (InterruptedException interruptedException) {}
                {
                    object4 = Thread.currentThread();
                    ((Thread)object4).interrupt();
                }
            }
            object4 = this.cache;
            object5 = this.cacheKeyFactory;
            object = this.manifestDataSpec;
            object5 = object5.buildCacheKey((DataSpec)object);
            object4.removeResource((String)object5);
            return;
        }
        Cache cache = this.cache;
        Object object = this.cacheKeyFactory;
        DataSpec dataSpec = this.manifestDataSpec;
        object = object.buildCacheKey(dataSpec);
        cache.removeResource((String)object);
        throw throwable2222222;
    }
}

