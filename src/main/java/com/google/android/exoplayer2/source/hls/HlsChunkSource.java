/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Pair
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$EncryptionKeyChunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$HlsChunkHolder;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$HlsMediaPlaylistSegmentIterator;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$InitializationTrackSelection;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$SegmentBaseHolder;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaChunk;
import com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HlsChunkSource {
    public static final int CHUNK_PUBLICATION_STATE_PRELOAD = 0;
    public static final int CHUNK_PUBLICATION_STATE_PUBLISHED = 1;
    public static final int CHUNK_PUBLICATION_STATE_REMOVED = 2;
    private static final int KEY_CACHE_SIZE = 4;
    private final DataSource encryptionDataSource;
    private Uri expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private final FullSegmentEncryptionKeyCache keyCache;
    private long liveEdgeInPeriodTimeUs;
    private final DataSource mediaDataSource;
    private final List muxedCaptionFormats;
    private final Format[] playlistFormats;
    private final HlsPlaylistTracker playlistTracker;
    private final Uri[] playlistUrls;
    private byte[] scratchSpace;
    private boolean seenExpectedPlaylistError;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private ExoTrackSelection trackSelection;

    public HlsChunkSource(HlsExtractorFactory object, HlsPlaylistTracker object2, Uri[] object3, Format[] formatArray, HlsDataSourceFactory object4, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, List list) {
        int n10;
        long l10;
        this.extractorFactory = object;
        this.playlistTracker = object2;
        this.playlistUrls = object3;
        this.playlistFormats = formatArray;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.muxedCaptionFormats = list;
        int n11 = 4;
        this.keyCache = object = new FullSegmentEncryptionKeyCache(n11);
        object = Util.EMPTY_BYTE_ARRAY;
        this.scratchSpace = (byte[])object;
        this.liveEdgeInPeriodTimeUs = l10 = -9223372036854775807L;
        int n12 = 1;
        this.mediaDataSource = object = object4.createDataSource(n12);
        if (transferListener != null) {
            object.addTransferListener(transferListener);
        }
        n12 = 3;
        this.encryptionDataSource = object = object4.createDataSource(n12);
        this.trackGroup = object = new TrackGroup(formatArray);
        object = new ArrayList();
        object2 = null;
        for (n11 = 0; n11 < (n10 = ((Uri[])object3).length); ++n11) {
            object4 = formatArray[n11];
            n10 = ((Format)object4).roleFlags & 0x4000;
            if (n10 != 0) continue;
            object4 = n11;
            ((ArrayList)object).add(object4);
        }
        object3 = this.trackGroup;
        object = Ints.toArray(object);
        this.trackSelection = object2 = new HlsChunkSource$InitializationTrackSelection((TrackGroup)object3, (int[])object);
    }

    private static Uri getFullEncryptionKeyUri(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist$SegmentBase object) {
        if (object != null && (object = ((HlsMediaPlaylist$SegmentBase)object).fullSegmentEncryptionKeyUri) != null) {
            return UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, (String)object);
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private Pair getNextMediaSequenceAndPartIndex(HlsMediaChunk object, boolean n10, HlsMediaPlaylist object2, long l10, long l11) {
        int n11;
        void var2_6;
        boolean bl2;
        long l12;
        boolean bl3;
        long l13;
        Number number;
        int n12 = 1;
        int n13 = -1;
        if (object != null && n10 == 0) {
            Pair pair;
            boolean bl4 = ((HlsMediaChunk)object).isLoadCompleted();
            if (bl4) {
                int n14 = ((HlsMediaChunk)object).partIndex;
                long l14 = n14 == n13 ? ((MediaChunk)object).getNextChunkIndex() : ((MediaChunk)object).chunkIndex;
                number = l14;
                int n15 = ((HlsMediaChunk)object).partIndex;
                if (n15 != n13) {
                    n13 = n15 + 1;
                }
                object = n13;
                pair = new Pair((Object)number, object);
            } else {
                long l15 = ((MediaChunk)object).chunkIndex;
                number = l15;
                int n16 = ((HlsMediaChunk)object).partIndex;
                object = n16;
                pair = new Pair((Object)number, object);
            }
            return pair;
        }
        long l16 = ((HlsMediaPlaylist)number).durationUs + l13;
        if (object != null && !(bl3 = this.independentSegments)) {
            l12 = ((Chunk)object).startTimeUs;
        }
        if (!(bl2 = ((HlsMediaPlaylist)number).hasEndTag) && (var2_6 = l12 == l16 ? 0 : (l12 < l16 ? -1 : 1)) >= 0) {
            l13 = ((HlsMediaPlaylist)number).mediaSequence;
            long l17 = ((HlsMediaPlaylist)number).segments.size();
            Long l18 = l13 + l17;
            number = n13;
            object = new Pair((Object)l18, (Object)number);
            return object;
        }
        Object object3 = ((HlsMediaPlaylist)number).segments;
        Long l19 = l12 -= l13;
        HlsPlaylistTracker hlsPlaylistTracker = this.playlistTracker;
        boolean bl5 = hlsPlaylistTracker.isLive();
        int n17 = 0;
        if (bl5 && object != null) {
            n11 = 0;
            object = null;
        } else {
            n11 = n12;
        }
        n11 = Util.binarySearchFloor((List)object3, l19, n12 != 0, n11 != 0);
        l13 = n11;
        long l20 = ((HlsMediaPlaylist)number).mediaSequence;
        l13 += l20;
        if (n11 >= 0) {
            int n18;
            object3 = ((HlsMediaPlaylist)number).segments;
            object = (HlsMediaPlaylist$Segment)object3.get(n11);
            l20 = ((HlsMediaPlaylist$SegmentBase)object).relativeStartTimeUs;
            long l21 = ((HlsMediaPlaylist$SegmentBase)object).durationUs;
            long l22 = l12 - (l20 += l21);
            Object object4 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
            object = object4 < 0 ? ((HlsMediaPlaylist$Segment)object).parts : ((HlsMediaPlaylist)number).trailingParts;
            while (n17 < (n18 = object.size())) {
                object3 = (HlsMediaPlaylist$Part)object.get(n17);
                l20 = ((HlsMediaPlaylist$SegmentBase)object3).relativeStartTimeUs;
                l21 = ((HlsMediaPlaylist$SegmentBase)object3).durationUs;
                long l23 = l12 - (l20 += l21);
                n12 = (int)(l23 == 0L ? 0 : (l23 < 0L ? -1 : 1));
                if (n12 < 0) {
                    boolean bl6 = ((HlsMediaPlaylist$Part)object3).isIndependent;
                    if (!bl6) break;
                    object3 = ((HlsMediaPlaylist)number).trailingParts;
                    long l24 = object == object3 ? 1L : 0L;
                    l13 += l24;
                    n13 = n17;
                    break;
                }
                ++n17;
            }
        }
        object3 = l13;
        number = n13;
        object = new Pair(object3, (Object)number);
        return object;
    }

    private static HlsChunkSource$SegmentBaseHolder getNextSegmentHolder(HlsMediaPlaylist object, long l10, int n10) {
        long l11 = ((HlsMediaPlaylist)object).mediaSequence;
        l11 = l10 - l11;
        int n11 = (int)l11;
        Object object2 = ((HlsMediaPlaylist)object).segments;
        int n12 = object2.size();
        HlsChunkSource$SegmentBaseHolder hlsChunkSource$SegmentBaseHolder = null;
        int n13 = -1;
        if (n11 == n12) {
            if (n10 == n13) {
                n10 = 0;
                Object var11_9 = null;
            }
            List list = ((HlsMediaPlaylist)object).trailingParts;
            n11 = list.size();
            if (n10 < n11) {
                object = (HlsMediaPlaylist$SegmentBase)((HlsMediaPlaylist)object).trailingParts.get(n10);
                hlsChunkSource$SegmentBaseHolder = new HlsChunkSource$SegmentBaseHolder((HlsMediaPlaylist$SegmentBase)object, l10, n10);
            }
            return hlsChunkSource$SegmentBaseHolder;
        }
        object2 = (HlsMediaPlaylist$Segment)((HlsMediaPlaylist)object).segments.get(n11);
        if (n10 == n13) {
            object = new HlsChunkSource$SegmentBaseHolder((HlsMediaPlaylist$SegmentBase)object2, l10, n13);
            return object;
        }
        List list = ((HlsMediaPlaylist$Segment)object2).parts;
        int n14 = list.size();
        if (n10 < n14) {
            HlsMediaPlaylist$SegmentBase hlsMediaPlaylist$SegmentBase = (HlsMediaPlaylist$SegmentBase)((HlsMediaPlaylist$Segment)object2).parts.get(n10);
            object = new HlsChunkSource$SegmentBaseHolder(hlsMediaPlaylist$SegmentBase, l10, n10);
            return object;
        }
        Object object3 = ((HlsMediaPlaylist)object).segments;
        n10 = object3.size();
        long l12 = 1L;
        if (++n11 < n10) {
            object = (HlsMediaPlaylist$SegmentBase)((HlsMediaPlaylist)object).segments.get(n11);
            object3 = new HlsChunkSource$SegmentBaseHolder((HlsMediaPlaylist$SegmentBase)object, l10 += l12, n13);
            return object3;
        }
        object3 = ((HlsMediaPlaylist)object).trailingParts;
        n10 = (int)(object3.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            object = (HlsMediaPlaylist$SegmentBase)((HlsMediaPlaylist)object).trailingParts.get(0);
            object3 = new HlsChunkSource$SegmentBaseHolder((HlsMediaPlaylist$SegmentBase)object, l10 += l12, 0);
            return object3;
        }
        return null;
    }

    public static List getSegmentBaseList(HlsMediaPlaylist list, long l10, int n10) {
        ArrayList<Object> arrayList;
        int n11;
        long l11 = ((HlsMediaPlaylist)list).mediaSequence;
        int n12 = (int)(l10 -= l11);
        if (n12 >= 0 && (n11 = (arrayList = ((HlsMediaPlaylist)list).segments).size()) >= n12) {
            long l12;
            long l13;
            long l14;
            List list2;
            arrayList = new ArrayList<Object>();
            Object object = ((HlsMediaPlaylist)list).segments;
            int n13 = object.size();
            int n14 = 0;
            int n15 = -1;
            if (n12 < n13) {
                List list3;
                if (n10 != n15) {
                    object = (HlsMediaPlaylist$Segment)((HlsMediaPlaylist)list).segments.get(n12);
                    if (n10 == 0) {
                        arrayList.add(object);
                    } else {
                        List list4 = ((HlsMediaPlaylist$Segment)object).parts;
                        int n16 = list4.size();
                        if (n10 < n16) {
                            object = ((HlsMediaPlaylist$Segment)object).parts;
                            n16 = object.size();
                            list3 = object.subList(n10, n16);
                            arrayList.addAll(list3);
                        }
                    }
                    ++n12;
                }
                list3 = ((HlsMediaPlaylist)list).segments;
                n13 = list3.size();
                list2 = list3.subList(n12, n13);
                arrayList.addAll(list2);
                n10 = 0;
                list3 = null;
            }
            if ((n12 = (int)((l14 = (l13 = ((HlsMediaPlaylist)list).partTargetDurationUs) - (l12 = -9223372036854775807L)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
                if (n10 != n15) {
                    n14 = n10;
                }
                list2 = ((HlsMediaPlaylist)list).trailingParts;
                n12 = list2.size();
                if (n14 < n12) {
                    list = ((HlsMediaPlaylist)list).trailingParts;
                    n12 = list.size();
                    list = list.subList(n14, n12);
                    arrayList.addAll(list);
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return ImmutableList.of();
    }

    private Chunk maybeCreateEncryptionChunkFor(Uri object, int n10) {
        DataSpec$Builder dataSpec$Builder = null;
        if (object == null) {
            return null;
        }
        Object object2 = this.keyCache.remove((Uri)object);
        if (object2 != null) {
            this.keyCache.put((Uri)object, (byte[])object2);
            return null;
        }
        dataSpec$Builder = new DataSpec$Builder();
        DataSpec dataSpec = dataSpec$Builder.setUri((Uri)object).setFlags(1).build();
        object2 = this.encryptionDataSource;
        Format format = this.playlistFormats[n10];
        int n11 = this.trackSelection.getSelectionReason();
        Object object3 = this.trackSelection.getSelectionData();
        byte[] byArray = this.scratchSpace;
        dataSpec$Builder = object;
        object = new HlsChunkSource$EncryptionKeyChunk((DataSource)object2, dataSpec, format, n11, object3, byArray);
        return object;
    }

    private long resolveTimeToLiveEdgeUs(long l10) {
        long l11 = this.liveEdgeInPeriodTimeUs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        if (object != false) {
            l12 = l11 - l10;
        }
        return l12;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist object) {
        long l10;
        boolean bl2 = ((HlsMediaPlaylist)object).hasEndTag;
        if (bl2) {
            l10 = -9223372036854775807L;
        } else {
            l10 = ((HlsMediaPlaylist)object).getEndTimeUs();
            object = this.playlistTracker;
            long l11 = object.getInitialStartTimeUs();
            l10 -= l11;
        }
        this.liveEdgeInPeriodTimeUs = l10;
    }

    public MediaChunkIterator[] createMediaChunkIterators(HlsMediaChunk hlsMediaChunk, long l10) {
        Object object;
        Object object2;
        int n10;
        HlsChunkSource hlsChunkSource = this;
        if (hlsMediaChunk == null) {
            n10 = -1;
        } else {
            object2 = this.trackGroup;
            object = hlsMediaChunk.trackFormat;
            n10 = ((TrackGroup)object2).indexOf((Format)object);
        }
        int n11 = n10;
        object2 = hlsChunkSource.trackSelection;
        int n12 = object2.length();
        MediaChunkIterator[] mediaChunkIteratorArray = new MediaChunkIterator[n12];
        int n13 = 0;
        while (n13 < n12) {
            int n14;
            HlsPlaylistTracker hlsPlaylistTracker = hlsChunkSource.playlistTracker;
            object2 = hlsChunkSource.trackSelection;
            n10 = object2.getIndexInTrackGroup(n13);
            object = hlsChunkSource.playlistUrls[n10];
            int n15 = hlsPlaylistTracker.isSnapshotValid((Uri)object);
            if (n15 == 0) {
                mediaChunkIteratorArray[n13] = object2 = MediaChunkIterator.EMPTY;
                n14 = n13;
            } else {
                hlsPlaylistTracker = hlsChunkSource.playlistTracker;
                HlsMediaPlaylist hlsMediaPlaylist = hlsPlaylistTracker.getPlaylistSnapshot((Uri)object, false);
                Assertions.checkNotNull(hlsMediaPlaylist);
                long l11 = hlsMediaPlaylist.startTimeUs;
                Object object3 = hlsChunkSource.playlistTracker;
                long l12 = object3.getInitialStartTimeUs();
                long l13 = l11 - l12;
                if (n10 != n11) {
                    n15 = n10 = 1;
                } else {
                    n15 = 0;
                    hlsPlaylistTracker = null;
                }
                object2 = this;
                object = hlsMediaChunk;
                object3 = hlsMediaPlaylist;
                long l14 = l13;
                n14 = n13;
                l13 = l10;
                object2 = this.getNextMediaSequenceAndPartIndex(hlsMediaChunk, n15 != 0, hlsMediaPlaylist, l14, l10);
                object = (Long)((Pair)object2).first;
                l11 = (Long)object;
                n10 = (Integer)((Pair)object2).second;
                String string2 = hlsMediaPlaylist.baseUri;
                object2 = HlsChunkSource.getSegmentBaseList(hlsMediaPlaylist, l11, n10);
                mediaChunkIteratorArray[n13] = object3 = new HlsChunkSource$HlsMediaPlaylistSegmentIterator(string2, l14, (List)object2);
            }
            n13 = n14 + 1;
        }
        return mediaChunkIteratorArray;
    }

    public int getChunkPublicationState(HlsMediaChunk hlsMediaChunk) {
        int n10 = hlsMediaChunk.partIndex;
        int n11 = 1;
        int n12 = -1;
        if (n10 == n12) {
            return n11;
        }
        Object object = this.playlistUrls;
        Object object2 = this.trackGroup;
        Format format = hlsMediaChunk.trackFormat;
        n12 = ((TrackGroup)object2).indexOf(format);
        object = object[n12];
        object2 = this.playlistTracker;
        format = null;
        object = (HlsMediaPlaylist)Assertions.checkNotNull(object2.getPlaylistSnapshot((Uri)object, false));
        long l10 = hlsMediaChunk.chunkIndex;
        long l11 = object.mediaSequence;
        n12 = (int)(l10 -= l11);
        if (n12 < 0) {
            return n11;
        }
        List list = object.segments;
        int n13 = list.size();
        if (n12 < n13) {
            list = object.segments;
            object2 = ((HlsMediaPlaylist$Segment)list.get((int)n12)).parts;
        } else {
            object2 = object.trailingParts;
        }
        n13 = hlsMediaChunk.partIndex;
        int n14 = object2.size();
        int n15 = 2;
        if (n13 >= n14) {
            return n15;
        }
        n13 = hlsMediaChunk.partIndex;
        object2 = (HlsMediaPlaylist$Part)object2.get(n13);
        n13 = (int)(((HlsMediaPlaylist$Part)object2).isPreload ? 1 : 0);
        if (n13 != 0) {
            return 0;
        }
        object = object.baseUri;
        object2 = ((HlsMediaPlaylist$SegmentBase)object2).url;
        boolean bl2 = Util.areEqual(object = Uri.parse((String)UriUtil.resolve((String)object, (String)object2)), hlsMediaChunk = hlsMediaChunk.dataSpec.uri);
        if (!bl2) {
            n11 = n15;
        }
        return n11;
    }

    public void getNextChunk(long l10, long l11, List list, boolean bl2, HlsChunkSource$HlsChunkHolder hlsChunkSource$HlsChunkHolder) {
        Uri uri;
        Object object;
        Object object2;
        long l12;
        long l13;
        long l14;
        boolean bl3;
        Object object3;
        int n10;
        Object object4;
        HlsMediaChunk hlsMediaChunk;
        HlsChunkSource hlsChunkSource = this;
        long l15 = l11;
        HlsChunkSource$HlsChunkHolder hlsChunkSource$HlsChunkHolder2 = hlsChunkSource$HlsChunkHolder;
        int n11 = list.isEmpty();
        if (n11 != 0) {
            hlsMediaChunk = null;
        } else {
            object4 = (HlsMediaChunk)Iterables.getLast(list);
            hlsMediaChunk = object4;
        }
        int n12 = -1;
        if (hlsMediaChunk == null) {
            n10 = n12;
        } else {
            object4 = hlsChunkSource.trackGroup;
            object3 = hlsMediaChunk.trackFormat;
            n10 = n11 = ((TrackGroup)object4).indexOf((Format)object3);
        }
        long l16 = l15 - l10;
        long l17 = this.resolveTimeToLiveEdgeUs(l10);
        if (hlsMediaChunk != null && !(bl3 = hlsChunkSource.independentSegments)) {
            l14 = hlsMediaChunk.getDurationUs();
            l16 -= l14;
            l13 = 0L;
            l16 = Math.max(l13, l16);
            l12 = -9223372036854775807L;
            long l18 = l17 - l12;
            object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object2 != false) {
                l17 -= l14;
                l17 = Math.max(l13, l17);
            }
        }
        MediaChunkIterator[] mediaChunkIteratorArray = hlsChunkSource.createMediaChunkIterators(hlsMediaChunk, l15);
        object4 = hlsChunkSource.trackSelection;
        long l19 = l10;
        Object object5 = list;
        object4.updateSelectedTrack(l10, l16, l17, list, mediaChunkIteratorArray);
        object4 = hlsChunkSource.trackSelection;
        int n13 = object4.getSelectedIndexInTrackGroup();
        Object object6 = null;
        bl3 = true;
        float f10 = Float.MIN_VALUE;
        object2 = n10 != n13 ? (Object)bl3 : (Object)0;
        Object object7 = hlsChunkSource.playlistUrls[n13];
        object4 = hlsChunkSource.playlistTracker;
        n11 = (int)(object4.isSnapshotValid((Uri)object7) ? 1 : 0);
        if (n11 == 0) {
            hlsChunkSource$HlsChunkHolder2.playlistUrl = object7;
            n11 = (int)(hlsChunkSource.seenExpectedPlaylistError ? 1 : 0);
            object3 = hlsChunkSource.expectedPlaylistUrl;
            int n14 = object7.equals(object3);
            hlsChunkSource.seenExpectedPlaylistError = n11 &= n14;
            hlsChunkSource.expectedPlaylistUrl = object7;
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylist = hlsChunkSource.playlistTracker.getPlaylistSnapshot((Uri)object7, bl3);
        Assertions.checkNotNull(hlsMediaPlaylist);
        n11 = (int)(hlsMediaPlaylist.hasIndependentSegments ? 1 : 0);
        hlsChunkSource.independentSegments = n11;
        hlsChunkSource.updateLiveEdgeTimeUs(hlsMediaPlaylist);
        l16 = hlsMediaPlaylist.startTimeUs;
        Object object8 = hlsChunkSource.playlistTracker;
        l19 = object8.getInitialStartTimeUs();
        l19 = l16 - l19;
        object4 = this;
        object3 = hlsMediaChunk;
        long l20 = object2;
        boolean bl4 = bl3;
        Object object9 = object7;
        l14 = l19;
        int n15 = n13;
        l13 = l11;
        object4 = this.getNextMediaSequenceAndPartIndex(hlsMediaChunk, (boolean)object2, hlsMediaPlaylist, l19, l11);
        object3 = (Long)((Pair)object4).first;
        long l21 = (Long)object3;
        object4 = (Integer)((Pair)object4).second;
        n11 = (Integer)object4;
        l14 = hlsMediaPlaylist.mediaSequence;
        bl3 = l21 == l14 ? 0 : (l21 < l14 ? -1 : 1);
        if (bl3 < false && hlsMediaChunk != null && object2 != false) {
            object = hlsChunkSource.playlistUrls[n10];
            object6 = hlsChunkSource.playlistTracker.getPlaylistSnapshot((Uri)object, bl4);
            Assertions.checkNotNull(object6);
            l16 = ((HlsMediaPlaylist)object6).startTimeUs;
            l17 = hlsChunkSource.playlistTracker.getInitialStartTimeUs();
            l12 = l16 - l17;
            l20 = 0;
            object8 = null;
            object4 = this;
            object3 = hlsMediaChunk;
            hlsMediaPlaylist = object6;
            l14 = l12;
            object9 = object6;
            object4 = this.getNextMediaSequenceAndPartIndex(hlsMediaChunk, false, (HlsMediaPlaylist)object6, l12, l11);
            object3 = (Long)((Pair)object4).first;
            l21 = (Long)object3;
            object4 = (Integer)((Pair)object4).second;
            n11 = (Integer)object4;
            uri = object;
        } else {
            l12 = l19;
            uri = object9;
            n10 = n15;
        }
        long l22 = hlsMediaPlaylist.mediaSequence;
        long l23 = l21 == l22 ? 0 : (l21 < l22 ? -1 : 1);
        if (l23 < 0) {
            hlsChunkSource.fatalError = object4 = new BehindLiveWindowException();
            return;
        }
        object4 = HlsChunkSource.getNextSegmentHolder(hlsMediaPlaylist, l21, n11);
        if (object4 == null) {
            n11 = (int)(hlsMediaPlaylist.hasEndTag ? 1 : 0);
            if (n11 == 0) {
                hlsChunkSource$HlsChunkHolder2.playlistUrl = uri;
                n11 = (int)(hlsChunkSource.seenExpectedPlaylistError ? 1 : 0);
                object3 = hlsChunkSource.expectedPlaylistUrl;
                int n16 = uri.equals(object3);
                hlsChunkSource.seenExpectedPlaylistError = n11 &= n16;
                hlsChunkSource.expectedPlaylistUrl = uri;
                return;
            }
            if (!bl2 && (n11 = (int)((object4 = hlsMediaPlaylist.segments).isEmpty() ? 1 : 0)) == 0) {
                object3 = (HlsMediaPlaylist$SegmentBase)Iterables.getLast(hlsMediaPlaylist.segments);
                l22 = hlsMediaPlaylist.mediaSequence;
                object8 = hlsMediaPlaylist.segments;
                l20 = object8.size();
                l15 = l20;
                l22 += l15;
                l15 = 1L;
                object4 = new HlsChunkSource$SegmentBaseHolder((HlsMediaPlaylist$SegmentBase)object3, l22 -= l15, n12);
            } else {
                hlsChunkSource$HlsChunkHolder2.endOfStream = bl4;
                return;
            }
        }
        hlsChunkSource.seenExpectedPlaylistError = false;
        boolean bl5 = false;
        hlsChunkSource.expectedPlaylistUrl = null;
        object3 = object4.segmentBase.initializationSegment;
        object3 = HlsChunkSource.getFullEncryptionKeyUri(hlsMediaPlaylist, (HlsMediaPlaylist$SegmentBase)object3);
        hlsChunkSource$HlsChunkHolder2.chunk = object8 = hlsChunkSource.maybeCreateEncryptionChunkFor((Uri)object3, n10);
        if (object8 != null) {
            return;
        }
        object8 = ((HlsChunkSource$SegmentBaseHolder)object4).segmentBase;
        object8 = HlsChunkSource.getFullEncryptionKeyUri(hlsMediaPlaylist, (HlsMediaPlaylist$SegmentBase)object8);
        object7 = hlsChunkSource.maybeCreateEncryptionChunkFor((Uri)object8, n10);
        hlsChunkSource$HlsChunkHolder2.chunk = object7;
        if (object7 != null) {
            return;
        }
        HlsExtractorFactory hlsExtractorFactory = hlsChunkSource.extractorFactory;
        object7 = hlsChunkSource.mediaDataSource;
        object = hlsChunkSource.playlistFormats[n10];
        object6 = hlsChunkSource.muxedCaptionFormats;
        int n17 = hlsChunkSource.trackSelection.getSelectionReason();
        object5 = hlsChunkSource.trackSelection.getSelectionData();
        boolean bl6 = hlsChunkSource.isTimestampMaster;
        TimestampAdjusterProvider timestampAdjusterProvider = hlsChunkSource.timestampAdjusterProvider;
        byte[] byArray = hlsChunkSource.keyCache.get((Uri)object8);
        byte[] byArray2 = hlsChunkSource.keyCache.get((Uri)object3);
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        hlsMediaChunk = object;
        object9 = object4;
        hlsChunkSource$HlsChunkHolder2.chunk = object4 = HlsMediaChunk.createInstance(hlsExtractorFactory, (DataSource)object7, (Format)object, l12, hlsMediaPlaylist, (HlsChunkSource$SegmentBaseHolder)object4, uri, (List)object6, n17, object5, bl6, timestampAdjusterProvider, hlsMediaChunk2, byArray, byArray2);
    }

    public int getPreferredQueueSize(long l10, List list) {
        int n10;
        int n11;
        Object object = this.fatalError;
        if (object == null && (n11 = (object = this.trackSelection).length()) >= (n10 = 2)) {
            return this.trackSelection.evaluateQueueSize(l10, list);
        }
        return list.size();
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public ExoTrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public boolean maybeExcludeTrack(Chunk object, long l10) {
        ExoTrackSelection exoTrackSelection = this.trackSelection;
        TrackGroup trackGroup = this.trackGroup;
        object = ((Chunk)object).trackFormat;
        int n10 = trackGroup.indexOf((Format)object);
        n10 = exoTrackSelection.indexOf(n10);
        return exoTrackSelection.blacklist(n10, l10);
    }

    public void maybeThrowError() {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            boolean bl2;
            iOException = this.expectedPlaylistUrl;
            if (iOException != null && (bl2 = this.seenExpectedPlaylistError)) {
                HlsPlaylistTracker hlsPlaylistTracker = this.playlistTracker;
                hlsPlaylistTracker.maybeThrowPlaylistRefreshError((Uri)iOException);
            }
            return;
        }
        throw iOException;
    }

    public void onChunkLoadCompleted(Chunk object) {
        boolean bl2 = object instanceof HlsChunkSource$EncryptionKeyChunk;
        if (bl2) {
            object = (HlsChunkSource$EncryptionKeyChunk)object;
            Object object2 = ((DataChunk)object).getDataHolder();
            this.scratchSpace = object2;
            object2 = this.keyCache;
            Uri uri = object.dataSpec.uri;
            object = (byte[])Assertions.checkNotNull(((HlsChunkSource$EncryptionKeyChunk)object).getResult());
            ((FullSegmentEncryptionKeyCache)object2).put(uri, (byte[])object);
        }
    }

    public boolean onPlaylistError(Uri object, long l10) {
        boolean bl2;
        int n10;
        int n11;
        int n12;
        boolean bl3;
        block5: {
            bl3 = false;
            n12 = 0;
            while (true) {
                Uri uri = this.playlistUrls;
                n11 = ((Uri[])uri).length;
                n10 = -1;
                if (n12 >= n11) break;
                bl2 = (uri = uri[n12]).equals(object);
                if (!bl2) {
                    ++n12;
                    continue;
                }
                break block5;
                break;
            }
            n12 = n10;
        }
        bl2 = true;
        if (n12 == n10) {
            return bl2;
        }
        ExoTrackSelection exoTrackSelection = this.trackSelection;
        if ((n12 = exoTrackSelection.indexOf(n12)) == n10) {
            return bl2;
        }
        n11 = (int)(this.seenExpectedPlaylistError ? 1 : 0);
        Uri uri = this.expectedPlaylistUrl;
        int n13 = object.equals((Object)uri) | n11;
        this.seenExpectedPlaylistError = n13;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        n13 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n13 == 0 || (n13 = (int)((object = this.trackSelection).blacklist(n12, l10) ? 1 : 0)) != 0) {
            bl3 = bl2;
        }
        return bl3;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void setIsTimestampMaster(boolean bl2) {
        this.isTimestampMaster = bl2;
    }

    public void setTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }

    public boolean shouldCancelLoad(long l10, Chunk chunk, List list) {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(l10, chunk, list);
    }
}

