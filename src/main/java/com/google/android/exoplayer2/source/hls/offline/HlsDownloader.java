/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls.offline;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.offline.SegmentDownloader$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory;
import com.google.android.exoplayer2.util.UriUtil;
import d.h.a.a.m0.o.f.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;

public final class HlsDownloader
extends SegmentDownloader {
    public HlsDownloader(Uri uri, List list, CacheDataSource$Factory cacheDataSource$Factory) {
        a a10 = a.a;
        this(uri, list, cacheDataSource$Factory, (Executor)a10);
    }

    public HlsDownloader(Uri object, List list, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).setStreamKeys(list).build();
        this((MediaItem)object, cacheDataSource$Factory, executor);
    }

    public HlsDownloader(MediaItem mediaItem, ParsingLoadable$Parser parsingLoadable$Parser, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        super(mediaItem, parsingLoadable$Parser, cacheDataSource$Factory, executor);
    }

    public HlsDownloader(MediaItem mediaItem, CacheDataSource$Factory cacheDataSource$Factory) {
        a a10 = a.a;
        this(mediaItem, cacheDataSource$Factory, a10);
    }

    public HlsDownloader(MediaItem mediaItem, CacheDataSource$Factory cacheDataSource$Factory, Executor executor) {
        HlsPlaylistParser hlsPlaylistParser = new HlsPlaylistParser();
        this(mediaItem, hlsPlaylistParser, cacheDataSource$Factory, executor);
    }

    private void addMediaPlaylistDataSpecs(List list, List list2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            DataSpec dataSpec = SegmentDownloader.getCompressibleDataSpec((Uri)list.get(i10));
            list2.add(dataSpec);
        }
    }

    private void addSegment(HlsMediaPlaylist object, HlsMediaPlaylist$Segment comparable, HashSet object2, ArrayList arrayList) {
        boolean bl2;
        String string2 = ((HlsPlaylist)object).baseUri;
        long l10 = ((HlsMediaPlaylist)object).startTimeUs;
        long l11 = comparable.relativeStartTimeUs;
        l10 += l11;
        object = comparable.fullSegmentEncryptionKeyUri;
        if (object != null && (bl2 = ((HashSet)object2).add(object = UriUtil.resolveToUri(string2, (String)object)))) {
            object = SegmentDownloader.getCompressibleDataSpec((Uri)object);
            object2 = new SegmentDownloader$Segment(l10, (DataSpec)object);
            arrayList.add(object2);
        }
        object = comparable.url;
        Uri uri = UriUtil.resolveToUri(string2, (String)object);
        long l12 = comparable.byteRangeOffset;
        long l13 = comparable.byteRangeLength;
        object = new DataSpec(uri, l12, l13);
        comparable = new SegmentDownloader$Segment(l10, (DataSpec)object);
        arrayList.add(comparable);
    }

    public List getSegments(DataSource dataSource, HlsPlaylist arrayList, boolean bl2) {
        boolean bl3;
        Object object = new ArrayList();
        boolean bl4 = arrayList instanceof HlsMasterPlaylist;
        if (bl4) {
            arrayList = ((HlsMasterPlaylist)arrayList).mediaPlaylistUrls;
            this.addMediaPlaylistDataSpecs(arrayList, (List)object);
        } else {
            arrayList = SegmentDownloader.getCompressibleDataSpec(Uri.parse((String)((HlsPlaylist)arrayList).baseUri));
            ((ArrayList)object).add(arrayList);
        }
        arrayList = new ArrayList<SegmentDownloader$Segment>();
        HashSet hashSet = new HashSet();
        object = ((ArrayList)object).iterator();
        while (bl3 = object.hasNext()) {
            int n10;
            List list;
            Object object2 = (DataSpec)object.next();
            long l10 = 0L;
            Comparable comparable = new SegmentDownloader$Segment(l10, (DataSpec)object2);
            arrayList.add((SegmentDownloader$Segment)comparable);
            object2 = this.getManifest(dataSource, (DataSpec)object2, bl2);
            try {
                object2 = (HlsMediaPlaylist)object2;
                comparable = null;
                list = ((HlsMediaPlaylist)object2).segments;
            }
            catch (IOException iOException) {
                if (bl2) continue;
                throw iOException;
            }
            for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
                HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment = (HlsMediaPlaylist$Segment)list.get(i10);
                HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment2 = hlsMediaPlaylist$Segment.initializationSegment;
                if (hlsMediaPlaylist$Segment2 != null && hlsMediaPlaylist$Segment2 != comparable) {
                    this.addSegment((HlsMediaPlaylist)object2, hlsMediaPlaylist$Segment2, hashSet, arrayList);
                    comparable = hlsMediaPlaylist$Segment2;
                }
                this.addSegment((HlsMediaPlaylist)object2, hlsMediaPlaylist$Segment, hashSet, arrayList);
            }
        }
        return arrayList;
    }
}

