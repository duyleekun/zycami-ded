/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.smoothstreaming.offline;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.SegmentDownloader$Segment;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.p.c.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class SsDownloader
extends SegmentDownloader {
    public SsDownloader(Uri uri, List list, CacheDataSource$Factory cacheDataSource$Factory) {
        a a10 = a.a;
        this(uri, list, cacheDataSource$Factory, (Executor)a10);
    }

    public SsDownloader(Uri object, List list, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).setStreamKeys(list).build();
        this((MediaItem)object, cacheDataSource$Factory, executor);
    }

    public SsDownloader(MediaItem mediaItem, ParsingLoadable$Parser parsingLoadable$Parser, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        super(mediaItem, parsingLoadable$Parser, cacheDataSource$Factory, executor);
    }

    public SsDownloader(MediaItem mediaItem, CacheDataSource$Factory cacheDataSource$Factory) {
        a a10 = a.a;
        this(mediaItem, cacheDataSource$Factory, a10);
    }

    public SsDownloader(MediaItem mediaItem, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        Object object = mediaItem.buildUpon();
        mediaItem = Util.fixSmoothStreamingIsmManifestUri(((MediaItem$PlaybackProperties)Assertions.checkNotNull((Object)mediaItem.playbackProperties)).uri);
        mediaItem = ((MediaItem$Builder)object).setUri((Uri)mediaItem).build();
        object = new SsManifestParser();
        this(mediaItem, (ParsingLoadable$Parser)object, cacheDataSource$Factory, executor);
    }

    public List getSegments(DataSource arrayList, SsManifest ssManifest$StreamElementArray, boolean n10) {
        arrayList = new ArrayList<SegmentDownloader$Segment>();
        for (SsManifest$StreamElement ssManifest$StreamElement : ssManifest$StreamElementArray.streamElements) {
            Format[] formatArray;
            int n11;
            for (int i10 = 0; i10 < (n11 = (formatArray = ssManifest$StreamElement.formats).length); ++i10) {
                int n12;
                formatArray = null;
                for (n11 = 0; n11 < (n12 = ssManifest$StreamElement.chunkCount); ++n11) {
                    long l10 = ssManifest$StreamElement.getStartTimeUs(n11);
                    Uri uri = ssManifest$StreamElement.buildRequestUri(i10, n11);
                    DataSpec dataSpec = new DataSpec(uri);
                    SegmentDownloader$Segment segmentDownloader$Segment = new SegmentDownloader$Segment(l10, dataSpec);
                    arrayList.add(segmentDownloader$Segment);
                }
            }
        }
        return arrayList;
    }
}

