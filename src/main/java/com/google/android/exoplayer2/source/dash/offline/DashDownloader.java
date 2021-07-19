/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.DownloadException;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.SegmentDownloader$Segment;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.offline.DashDownloader$1;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import d.h.a.a.m0.n.d.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class DashDownloader
extends SegmentDownloader {
    public DashDownloader(Uri uri, List list, CacheDataSource$Factory cacheDataSource$Factory) {
        a a10 = a.a;
        this(uri, list, cacheDataSource$Factory, (Executor)a10);
    }

    public DashDownloader(Uri object, List list, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).setStreamKeys(list).build();
        this((MediaItem)object, cacheDataSource$Factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable$Parser parsingLoadable$Parser, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        super(mediaItem, parsingLoadable$Parser, cacheDataSource$Factory, executor);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource$Factory cacheDataSource$Factory) {
        a a10 = a.a;
        this(mediaItem, cacheDataSource$Factory, a10);
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        DashManifestParser dashManifestParser = new DashManifestParser();
        this(mediaItem, dashManifestParser, cacheDataSource$Factory, executor);
    }

    private static void addSegment(long l10, String object, RangedUri rangedUri, ArrayList arrayList) {
        Uri uri = rangedUri.resolveUri((String)object);
        long l11 = rangedUri.start;
        long l12 = rangedUri.length;
        DataSpec dataSpec = new DataSpec(uri, l11, l12);
        object = new SegmentDownloader$Segment(l10, dataSpec);
        arrayList.add(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void addSegmentsForAdaptationSet(DataSource dataSource, AdaptationSet adaptationSet, long l10, long l11, boolean bl2, ArrayList arrayList) {
        Object object = adaptationSet;
        long l12 = l10;
        boolean bl3 = bl2;
        ArrayList arrayList2 = arrayList;
        int n10 = 0;
        Object object2 = null;
        int i10 = 0;
        while (true) {
            block15: {
                block11: {
                    block12: {
                        block13: {
                            String string2;
                            int n11;
                            DashSegmentIndex dashSegmentIndex;
                            block14: {
                                RangedUri rangedUri;
                                int n13;
                                if (i10 >= (n10 = (object2 = ((AdaptationSet)object).representations).size())) {
                                    return;
                                }
                                object2 = (Representation)((AdaptationSet)object).representations.get(i10);
                                try {
                                    n13 = ((AdaptationSet)object).type;
                                }
                                catch (IOException iOException) {
                                    // empty catch block
                                    break block11;
                                }
                                try {
                                    int n12;
                                    dashSegmentIndex = this.getSegmentIndex(dataSource, n13, (Representation)object2, bl3);
                                    if (dashSegmentIndex == null) break block12;
                                    n11 = dashSegmentIndex.getSegmentCount(l11);
                                    if (n11 == (n12 = -1)) break block13;
                                    string2 = ((Representation)object2).baseUrl;
                                    rangedUri = ((Representation)object2).getInitializationUri();
                                    if (rangedUri == null) break block14;
                                }
                                catch (IOException iOException) {
                                    break block11;
                                }
                                DashDownloader.addSegment(l12, string2, rangedUri, arrayList2);
                            }
                            if ((object2 = ((Representation)object2).getIndexUri()) != null) {
                                DashDownloader.addSegment(l12, string2, (RangedUri)object2, arrayList2);
                            }
                            long l13 = dashSegmentIndex.getFirstSegmentNum();
                            long l14 = (long)n11 + l13;
                            long l15 = 1L;
                            l14 -= l15;
                            while ((n11 = (int)(l13 == l14 ? 0 : (l13 < l14 ? -1 : 1))) <= 0) {
                                long l16 = dashSegmentIndex.getTimeUs(l13);
                                long l17 = l14;
                                l14 = l12 + l16;
                                RangedUri rangedUri = dashSegmentIndex.getSegmentUrl(l13);
                                DashDownloader.addSegment(l14, string2, rangedUri, arrayList2);
                                l13 += l15;
                                l14 = l17;
                            }
                            break block15;
                        }
                        object2 = new DownloadException("Unbounded segment index");
                        throw object2;
                    }
                    try {
                        object = "Missing segment index";
                        object2 = new DownloadException((String)object);
                        throw object2;
                    }
                    catch (IOException iOException) {}
                }
                if (!bl3) {
                    throw object2;
                }
            }
            ++i10;
            object = adaptationSet;
        }
    }

    private DashSegmentIndex getSegmentIndex(DataSource object, int n10, Representation representation, boolean bl2) {
        Object object2 = representation.getIndex();
        if (object2 != null) {
            return object2;
        }
        object2 = new DashDownloader$1(this, (DataSource)object, n10, representation);
        if ((object = (ChunkIndex)this.execute((RunnableFutureTask)object2, bl2)) == null) {
            object = null;
        } else {
            long l10 = representation.presentationTimeOffsetUs;
            DashWrappingSegmentIndex dashWrappingSegmentIndex = new DashWrappingSegmentIndex((ChunkIndex)object, l10);
            object = dashWrappingSegmentIndex;
        }
        return object;
    }

    public List getSegments(DataSource dataSource, DashManifest dashManifest, boolean bl2) {
        int n10;
        DashManifest dashManifest2 = dashManifest;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < (n10 = dashManifest.getPeriodCount()); ++i10) {
            Object object = dashManifest2.getPeriod(i10);
            long l10 = ((Period)object).startMs;
            long l11 = C.msToUs(l10);
            long l12 = dashManifest2.getPeriodDurationUs(i10);
            ArrayList arrayList2 = ((Period)object).adaptationSets;
            int n11 = 0;
            while (n11 < (n10 = arrayList2.size())) {
                Object object2 = object = arrayList2.get(n11);
                object2 = (AdaptationSet)object;
                object = this;
                int n12 = n11;
                n11 = (int)(bl2 ? 1 : 0);
                ArrayList arrayList3 = arrayList2;
                arrayList2 = arrayList;
                this.addSegmentsForAdaptationSet(dataSource, (AdaptationSet)object2, l11, l12, bl2, arrayList);
                n11 = n12 + 1;
                arrayList2 = arrayList3;
            }
        }
        return arrayList;
    }
}

