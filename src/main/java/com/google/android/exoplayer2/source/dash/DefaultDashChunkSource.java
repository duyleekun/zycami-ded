/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$RepresentationHolder;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$RepresentationSegmentIterator;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource
implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final PlayerEmsgHandler$PlayerTrackEmsgHandler playerTrackEmsgHandler;
    public final DefaultDashChunkSource$RepresentationHolder[] representationHolders;
    private ExoTrackSelection trackSelection;
    private final int trackType;

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int n10, int[] nArray, ExoTrackSelection exoTrackSelection, int n11, DataSource dataSource, long l10, int n12, boolean bl2, List list, PlayerEmsgHandler$PlayerTrackEmsgHandler playerEmsgHandler$PlayerTrackEmsgHandler) {
        DefaultDashChunkSource defaultDashChunkSource = this;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        Object object = loaderErrorThrower;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        object = dashManifest;
        this.manifest = dashManifest;
        this.adaptationSetIndices = nArray;
        this.trackSelection = exoTrackSelection;
        this.trackType = n11;
        this.dataSource = dataSource;
        this.periodIndex = n10;
        this.elapsedRealtimeOffsetMs = l10;
        this.maxSegmentsPerLoad = n12;
        this.playerTrackEmsgHandler = playerEmsgHandler$PlayerTrackEmsgHandler;
        long l11 = dashManifest.getPeriodDurationUs(n10);
        ArrayList arrayList = this.getRepresentations();
        object = new DefaultDashChunkSource$RepresentationHolder[exoTrackSelection.length()];
        this.representationHolders = object;
        int n13 = 0;
        object = null;
        for (int i10 = 0; i10 < (n13 = ((DefaultDashChunkSource$RepresentationHolder[])(object = defaultDashChunkSource.representationHolders)).length); ++i10) {
            DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder;
            n13 = exoTrackSelection2.getIndexInTrackGroup(i10);
            Object object2 = object = arrayList.get(n13);
            object2 = (Representation)object;
            Object object3 = defaultDashChunkSource.representationHolders;
            object = defaultDashChunkSource$RepresentationHolder;
            DefaultDashChunkSource$RepresentationHolder[] defaultDashChunkSource$RepresentationHolderArray = object3;
            object3 = playerEmsgHandler$PlayerTrackEmsgHandler;
            defaultDashChunkSource$RepresentationHolderArray[i10] = defaultDashChunkSource$RepresentationHolder = new DefaultDashChunkSource$RepresentationHolder(l11, n11, (Representation)object2, bl2, list, playerEmsgHandler$PlayerTrackEmsgHandler);
        }
    }

    private long getAvailableLiveDurationUs(long l10, long l11) {
        DashManifest dashManifest = this.manifest;
        boolean bl2 = dashManifest.dynamic;
        if (!bl2) {
            return -9223372036854775807L;
        }
        long l12 = this.representationHolders[0].getLastAvailableSegmentNum(l10);
        long l13 = this.representationHolders[0].getSegmentEndTimeUs(l12);
        l10 = Math.min(this.getNowPeriodTimeUs(l10), l13) - l11;
        return Math.max(0L, l10);
    }

    private long getNowPeriodTimeUs(long l10) {
        Object object = this.manifest;
        long l11 = ((DashManifest)object).availabilityStartTimeMs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 != false) {
            int n10 = this.periodIndex;
            object = ((DashManifest)object).getPeriod(n10);
            l12 = ((Period)object).startMs;
            long l14 = C.msToUs(l11 += l12);
            l12 = l10 - l14;
        }
        return l12;
    }

    private ArrayList getRepresentations() {
        Object object = this.manifest;
        int n10 = this.periodIndex;
        object = object.getPeriod((int)n10).adaptationSets;
        ArrayList arrayList = new ArrayList();
        for (int n11 : this.adaptationSetIndices) {
            List list = ((AdaptationSet)object.get((int)n11)).representations;
            arrayList.addAll(list);
        }
        return arrayList;
    }

    private long getSegmentNum(DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder, MediaChunk mediaChunk, long l10, long l11, long l12) {
        long l13;
        if (mediaChunk != null) {
            l13 = mediaChunk.getNextChunkIndex();
        } else {
            long l14 = defaultDashChunkSource$RepresentationHolder.getSegmentNum(l10);
            l13 = Util.constrainValue(l14, l11, l12);
        }
        return l13;
    }

    /*
     * Enabled aggressive block sorting
     */
    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        long l11;
        long l12;
        long l13;
        long l14 = l10;
        DefaultDashChunkSource$RepresentationHolder[] defaultDashChunkSource$RepresentationHolderArray = this.representationHolders;
        int n10 = defaultDashChunkSource$RepresentationHolderArray.length;
        int n11 = 0;
        while (true) {
            block5: {
                block6: {
                    long l15;
                    DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder;
                    block7: {
                        if (n11 >= n10) {
                            return l14;
                        }
                        defaultDashChunkSource$RepresentationHolder = defaultDashChunkSource$RepresentationHolderArray[n11];
                        DashSegmentIndex dashSegmentIndex = defaultDashChunkSource$RepresentationHolder.segmentIndex;
                        if (dashSegmentIndex == null) break block5;
                        l13 = defaultDashChunkSource$RepresentationHolder.getSegmentNum(l14);
                        l12 = defaultDashChunkSource$RepresentationHolder.getSegmentStartTimeUs(l13);
                        int n12 = defaultDashChunkSource$RepresentationHolder.getSegmentCount();
                        Object object = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1);
                        if (object >= 0) break block6;
                        int n13 = -1;
                        l15 = 1L;
                        if (n12 == n13) break block7;
                        long l16 = defaultDashChunkSource$RepresentationHolder.getFirstSegmentNum();
                        long l17 = n12;
                        long l18 = l13 - (l16 = l16 + l17 - l15);
                        if ((n12 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1))) >= 0) break block6;
                    }
                    l13 += l15;
                    l11 = l13 = defaultDashChunkSource$RepresentationHolder.getSegmentStartTimeUs(l13);
                    break;
                }
                l11 = l12;
                break;
            }
            ++n11;
        }
        SeekParameters seekParameters2 = seekParameters;
        l14 = l10;
        l13 = l12;
        return seekParameters.resolveSeekPositionUs(l10, l12, l11);
    }

    public void getNextChunk(long l10, long l11, List list, ChunkHolder chunkHolder) {
        long l12;
        long l13;
        long l14;
        float f10;
        boolean bl2;
        long l15;
        long l16;
        MediaChunkIterator[] mediaChunkIteratorArray;
        Object object;
        DefaultDashChunkSource$RepresentationHolder[] defaultDashChunkSource$RepresentationHolderArray;
        Object object2;
        int n10;
        DefaultDashChunkSource defaultDashChunkSource = this;
        long l17 = l10;
        ChunkHolder chunkHolder2 = chunkHolder;
        Object object3 = this.fatalError;
        if (object3 != null) {
            return;
        }
        long l18 = l11 - l10;
        object3 = this.manifest;
        long l19 = C.msToUs(((DashManifest)object3).availabilityStartTimeMs);
        Object object4 = this.manifest;
        int n11 = this.periodIndex;
        long l20 = C.msToUs(object4.getPeriod((int)n11).startMs);
        l19 = l19 + l20 + l11;
        object4 = this.playerTrackEmsgHandler;
        if (object4 != null && (n10 = object4.maybeRefreshManifestBeforeLoadingNextChunk(l19)) != 0) {
            return;
        }
        l19 = Util.getNowUnixTimeMs(defaultDashChunkSource.elapsedRealtimeOffsetMs);
        long l21 = C.msToUs(l19);
        long l22 = defaultDashChunkSource.getNowPeriodTimeUs(l21);
        n10 = list.isEmpty();
        int n12 = 1;
        if (n10 != 0) {
            object2 = list;
            defaultDashChunkSource$RepresentationHolderArray = null;
        } else {
            n10 = list.size() - n12;
            object2 = list;
            object3 = (MediaChunk)list.get(n10);
            defaultDashChunkSource$RepresentationHolderArray = object3;
        }
        object3 = defaultDashChunkSource.trackSelection;
        n11 = object3.length();
        Object object5 = new MediaChunkIterator[n11];
        int n13 = 0;
        object4 = null;
        while (n13 < n11) {
            long l23;
            int n14;
            int n15;
            object = defaultDashChunkSource.representationHolders[n13];
            object3 = ((DefaultDashChunkSource$RepresentationHolder)object).segmentIndex;
            if (object3 == null) {
                object5[n13] = object3 = MediaChunkIterator.EMPTY;
                n15 = n13;
                n14 = n11;
                mediaChunkIteratorArray = object5;
                l23 = l21;
            } else {
                l16 = ((DefaultDashChunkSource$RepresentationHolder)object).getFirstAvailableSegmentNum(l21);
                long l24 = ((DefaultDashChunkSource$RepresentationHolder)object).getLastAvailableSegmentNum(l21);
                object3 = this;
                n15 = n13;
                object4 = defaultDashChunkSource$RepresentationHolderArray;
                n14 = n11;
                mediaChunkIteratorArray = object5;
                l15 = l16;
                l23 = l21;
                l21 = l24;
                l19 = this.getSegmentNum((DefaultDashChunkSource$RepresentationHolder)object, (MediaChunk)defaultDashChunkSource$RepresentationHolderArray, l11, l16, l24);
                long l25 = l19 - l16;
                n13 = (int)(l25 == 0L ? 0 : (l25 < 0L ? -1 : 1));
                if (n13 < 0) {
                    object5[n15] = object3 = MediaChunkIterator.EMPTY;
                } else {
                    object4 = new DefaultDashChunkSource$RepresentationSegmentIterator((DefaultDashChunkSource$RepresentationHolder)object, l19, l24, l22);
                    object5[n15] = object4;
                }
            }
            n13 = n15 + 1;
            n12 = 1;
            object2 = list;
            l21 = l23;
            object5 = mediaChunkIteratorArray;
            n11 = n14;
            defaultDashChunkSource = this;
        }
        mediaChunkIteratorArray = object5;
        l15 = defaultDashChunkSource.getAvailableLiveDurationUs(l21, l17);
        object3 = defaultDashChunkSource.trackSelection;
        l17 = l21;
        Object object6 = list;
        object3.updateSelectedTrack(l10, l18, l15, list, (MediaChunkIterator[])object5);
        object3 = defaultDashChunkSource.representationHolders;
        object = defaultDashChunkSource.trackSelection;
        int n16 = object.getSelectedIndex();
        DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder = object3[n16];
        object3 = defaultDashChunkSource$RepresentationHolder.chunkExtractor;
        if (object3 != null) {
            object = defaultDashChunkSource$RepresentationHolder.representation;
            object2 = (object3 = object3.getSampleFormats()) == null ? (object3 = ((Representation)object).getInitializationUri()) : null;
            object3 = defaultDashChunkSource$RepresentationHolder.segmentIndex;
            if (object3 == null) {
                object6 = object3 = ((Representation)object).getIndexUri();
            } else {
                bl2 = false;
                f10 = 0.0f;
                object6 = null;
            }
            if (object2 != null || object6 != null) {
                object4 = defaultDashChunkSource.dataSource;
                Format format = defaultDashChunkSource.trackSelection.getSelectedFormat();
                int n17 = defaultDashChunkSource.trackSelection.getSelectionReason();
                Object object7 = defaultDashChunkSource.trackSelection.getSelectionData();
                object3 = this;
                object = defaultDashChunkSource$RepresentationHolder;
                chunkHolder2.chunk = object3 = this.newInitializationChunk(defaultDashChunkSource$RepresentationHolder, (DataSource)object4, format, n17, object7, (RangedUri)object2, (RangedUri)object6);
                return;
            }
        }
        if ((l14 = (l13 = (l12 = DefaultDashChunkSource$RepresentationHolder.access$000(defaultDashChunkSource$RepresentationHolder)) - (l16 = -9223372036854775807L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            object6 = null;
            f10 = 0.0f;
        }
        n10 = defaultDashChunkSource$RepresentationHolder.getSegmentCount();
        if (n10 == 0) {
            chunkHolder2.endOfStream = bl2;
            return;
        }
        long l26 = defaultDashChunkSource$RepresentationHolder.getFirstAvailableSegmentNum(l17);
        l17 = defaultDashChunkSource$RepresentationHolder.getLastAvailableSegmentNum(l17);
        object3 = this;
        object = defaultDashChunkSource$RepresentationHolder;
        object4 = defaultDashChunkSource$RepresentationHolderArray;
        l15 = l26;
        boolean bl3 = bl2;
        l21 = l17;
        l21 = this.getSegmentNum(defaultDashChunkSource$RepresentationHolder, (MediaChunk)defaultDashChunkSource$RepresentationHolderArray, l11, l26, l17);
        long l27 = l21 - l26;
        n10 = (int)(l27 == 0L ? 0 : (l27 < 0L ? -1 : 1));
        if (n10 < 0) {
            defaultDashChunkSource.fatalError = object3 = new BehindLiveWindowException();
            return;
        }
        n10 = (int)(l21 == l17 ? 0 : (l21 < l17 ? -1 : 1));
        if (n10 <= 0 && ((n16 = (int)(defaultDashChunkSource.missingLastSegment ? 1 : 0)) == 0 || n10 < 0)) {
            long l28;
            if (bl3 && (n10 = (int)((l28 = (l19 = defaultDashChunkSource$RepresentationHolder.getSegmentStartTimeUs(l21)) - l12) == 0L ? 0 : (l28 < 0L ? -1 : 1))) >= 0) {
                chunkHolder2 = chunkHolder;
                chunkHolder.endOfStream = true;
                return;
            }
            chunkHolder2 = chunkHolder;
            l19 = defaultDashChunkSource.maxSegmentsPerLoad;
            l17 -= l21;
            l20 = 1L;
            l19 = Math.min(l19, l17 += l20);
            if (l14 != false) {
                n16 = 1;
                for (n10 = (int)l19; n10 > n16; n10 += -1) {
                    long l29 = (long)n10 + l21 - l20;
                    long l30 = (l29 = defaultDashChunkSource$RepresentationHolder.getSegmentStartTimeUs(l29)) - l12;
                    Object object8 = l30 == 0L ? 0 : (l30 < 0L ? -1 : 1);
                    if (object8 < 0) break;
                }
            }
            int n18 = n10;
            n10 = (int)(list.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                l16 = l11;
            }
            object4 = defaultDashChunkSource.dataSource;
            n11 = defaultDashChunkSource.trackType;
            object5 = defaultDashChunkSource.trackSelection.getSelectedFormat();
            n12 = defaultDashChunkSource.trackSelection.getSelectionReason();
            object2 = defaultDashChunkSource.trackSelection.getSelectionData();
            object3 = this;
            object = defaultDashChunkSource$RepresentationHolder;
            l12 = l22;
            chunkHolder2.chunk = object3 = this.newMediaChunk(defaultDashChunkSource$RepresentationHolder, (DataSource)object4, n11, (Format)object5, n12, object2, l21, n18, l16, l22);
            return;
        }
        n10 = (int)(bl3 ? 1 : 0);
        chunkHolder2 = chunkHolder;
        chunkHolder.endOfStream = bl3;
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

    public void maybeThrowError() {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public Chunk newInitializationChunk(DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder, DataSource dataSource, Format format, int n10, Object object, RangedUri object2, RangedUri rangedUri) {
        Object object3;
        Representation representation = defaultDashChunkSource$RepresentationHolder.representation;
        if (object2 == null || (rangedUri = ((RangedUri)object2).attemptMerge(rangedUri, (String)(object3 = representation.baseUrl))) != null) {
            object2 = rangedUri;
        }
        DataSpec dataSpec = DashUtil.buildDataSpec(representation, (RangedUri)object2, 0);
        ChunkExtractor chunkExtractor = defaultDashChunkSource$RepresentationHolder.chunkExtractor;
        object3 = object2;
        object2 = new InitializationChunk(dataSource, dataSpec, format, n10, object, chunkExtractor);
        return object2;
    }

    public Chunk newMediaChunk(DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder, DataSource dataSource, int n10, Format format, int n11, Object object, long l10, int n12, long l11, long l12) {
        long l13;
        long l14;
        int n13;
        Object object2 = defaultDashChunkSource$RepresentationHolder;
        long l15 = l10;
        long l16 = l12;
        Object object3 = defaultDashChunkSource$RepresentationHolder.representation;
        long l17 = defaultDashChunkSource$RepresentationHolder.getSegmentStartTimeUs(l10);
        Object object4 = defaultDashChunkSource$RepresentationHolder.getSegmentUrl(l10);
        Object object5 = ((Representation)object3).baseUrl;
        Object object6 = defaultDashChunkSource$RepresentationHolder.chunkExtractor;
        if (object6 == null) {
            SingleSampleMediaChunk singleSampleMediaChunk;
            int n14;
            long l18 = defaultDashChunkSource$RepresentationHolder.getSegmentEndTimeUs(l10);
            boolean bl2 = defaultDashChunkSource$RepresentationHolder.isSegmentAvailableAtFullNetworkSpeed(l10, l12);
            if (bl2) {
                n14 = 0;
                Object var29_24 = null;
            } else {
                n14 = 8;
            }
            DataSpec dataSpec = DashUtil.buildDataSpec((Representation)object3, (RangedUri)object4, n14);
            object2 = singleSampleMediaChunk;
            object4 = format;
            object5 = object;
            int n15 = n10;
            singleSampleMediaChunk = new SingleSampleMediaChunk(dataSource, dataSpec, format, n11, object, l17, l18, l10, n10, format);
            return singleSampleMediaChunk;
        }
        int n16 = n12;
        int n17 = n13;
        for (n13 = 1; n13 < n16; ++n13) {
            l14 = (long)n13 + l15;
            RangedUri rangedUri = ((DefaultDashChunkSource$RepresentationHolder)object2).getSegmentUrl(l14);
            if ((rangedUri = ((RangedUri)object4).attemptMerge(rangedUri, (String)object5)) == null) break;
            ++n17;
            object4 = rangedUri;
        }
        long l19 = (long)n17 + l15 - 1L;
        l14 = ((DefaultDashChunkSource$RepresentationHolder)object2).getSegmentEndTimeUs(l19);
        long l20 = DefaultDashChunkSource$RepresentationHolder.access$000(defaultDashChunkSource$RepresentationHolder);
        long l21 = l20 - (l13 = -9223372036854775807L);
        n16 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
        long l22 = n16 != 0 && (n16 = (int)(l20 == l14 ? 0 : (l20 < l14 ? -1 : 1))) <= 0 ? l20 : l13;
        boolean bl3 = ((DefaultDashChunkSource$RepresentationHolder)object2).isSegmentAvailableAtFullNetworkSpeed(l19, l16);
        int n18 = bl3 ? 0 : 8;
        object4 = DashUtil.buildDataSpec((Representation)object3, (RangedUri)object4, n18);
        l16 = -((Representation)object3).presentationTimeOffsetUs;
        object2 = ((DefaultDashChunkSource$RepresentationHolder)object2).chunkExtractor;
        DataSource dataSource2 = dataSource;
        object3 = format;
        object6 = object;
        long l23 = l11;
        l15 = l22;
        int n19 = n17;
        ContainerMediaChunk containerMediaChunk = new ContainerMediaChunk(dataSource, (DataSpec)object4, format, n11, object, l17, l14, l11, l22, l10, n17, l16, (ChunkExtractor)object2);
        return containerMediaChunk;
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        Object object;
        int n10 = chunk instanceof InitializationChunk;
        if (n10 != 0) {
            object = chunk;
            object = (InitializationChunk)chunk;
            Object object2 = this.trackSelection;
            object = ((Chunk)object).trackFormat;
            n10 = object2.indexOf((Format)object);
            object2 = this.representationHolders[n10];
            Object object3 = ((DefaultDashChunkSource$RepresentationHolder)object2).segmentIndex;
            if (object3 == null && (object3 = ((DefaultDashChunkSource$RepresentationHolder)object2).chunkExtractor.getChunkIndex()) != null) {
                DefaultDashChunkSource$RepresentationHolder[] defaultDashChunkSource$RepresentationHolderArray = this.representationHolders;
                Representation representation = ((DefaultDashChunkSource$RepresentationHolder)object2).representation;
                long l10 = representation.presentationTimeOffsetUs;
                DashWrappingSegmentIndex dashWrappingSegmentIndex = new DashWrappingSegmentIndex((ChunkIndex)object3, l10);
                defaultDashChunkSource$RepresentationHolderArray[n10] = object2 = ((DefaultDashChunkSource$RepresentationHolder)object2).copyWithNewSegmentIndex(dashWrappingSegmentIndex);
            }
        }
        if ((object = this.playerTrackEmsgHandler) != null) {
            ((PlayerEmsgHandler$PlayerTrackEmsgHandler)object).onChunkLoadCompleted(chunk);
        }
    }

    public boolean onChunkLoadError(Chunk object, boolean n10, Exception object2, long l10) {
        long l11;
        long l12;
        boolean bl2 = false;
        if (n10 == 0) {
            return false;
        }
        Object object3 = this.playerTrackEmsgHandler;
        boolean bl3 = true;
        if (object3 != null && (n10 = ((PlayerEmsgHandler$PlayerTrackEmsgHandler)object3).onChunkLoadError((Chunk)object)) != 0) {
            return bl3;
        }
        object3 = this.manifest;
        n10 = ((DashManifest)object3).dynamic;
        if (n10 == 0 && (n10 = object instanceof MediaChunk) != 0 && (n10 = object2 instanceof HttpDataSource$InvalidResponseCodeException) != 0) {
            object2 = (HttpDataSource$InvalidResponseCodeException)object2;
            n10 = ((HttpDataSource$InvalidResponseCodeException)object2).responseCode;
            int n11 = 404;
            if (n10 == n11) {
                int n12;
                object3 = this.representationHolders;
                object2 = this.trackSelection;
                Format format = ((Chunk)object).trackFormat;
                n11 = object2.indexOf(format);
                if ((n11 = ((DefaultDashChunkSource$RepresentationHolder)(object3 = object3[n11])).getSegmentCount()) != (n12 = -1) && n11 != 0) {
                    long l13 = ((DefaultDashChunkSource$RepresentationHolder)object3).getFirstSegmentNum();
                    l12 = n11;
                    l13 = l13 + l12 - 1L;
                    object3 = object;
                    object3 = (MediaChunk)object;
                    l12 = ((MediaChunk)object3).getNextChunkIndex();
                    long l14 = l12 - l13;
                    n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                    if (n10 > 0) {
                        this.missingLastSegment = bl3;
                        return bl3;
                    }
                }
            }
        }
        if ((n10 = (l11 = l10 - (l12 = -9223372036854775807L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != 0) {
            object3 = this.trackSelection;
            object = ((Chunk)object).trackFormat;
            int n13 = object3.indexOf((Format)object);
            if ((n13 = (int)(object3.blacklist(n13, l10) ? 1 : 0)) != 0) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    public void release() {
        DefaultDashChunkSource$RepresentationHolder[] defaultDashChunkSource$RepresentationHolderArray = this.representationHolders;
        int n10 = defaultDashChunkSource$RepresentationHolderArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            ChunkExtractor chunkExtractor = defaultDashChunkSource$RepresentationHolderArray[i10].chunkExtractor;
            if (chunkExtractor == null) continue;
            chunkExtractor.release();
        }
    }

    public boolean shouldCancelLoad(long l10, Chunk chunk, List list) {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(l10, chunk, list);
    }

    public void updateManifest(DashManifest dashManifest, int n10) {
        int n11;
        ArrayList arrayList;
        this.manifest = dashManifest;
        this.periodIndex = n10;
        long l10 = dashManifest.getPeriodDurationUs(n10);
        try {
            arrayList = this.getRepresentations();
            n11 = 0;
        }
        catch (BehindLiveWindowException behindLiveWindowException) {
            this.fatalError = behindLiveWindowException;
        }
        while (true) {
            Object object = this.representationHolders;
            int n12 = ((DefaultDashChunkSource$RepresentationHolder[])object).length;
            if (n11 >= n12) break;
            object = this.trackSelection;
            n12 = object.getIndexInTrackGroup(n11);
            object = arrayList.get(n12);
            object = (Representation)object;
            DefaultDashChunkSource$RepresentationHolder[] defaultDashChunkSource$RepresentationHolderArray = this.representationHolders;
            DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder = defaultDashChunkSource$RepresentationHolderArray[n11];
            object = defaultDashChunkSource$RepresentationHolder.copyWithNewRepresentation(l10, (Representation)object);
            defaultDashChunkSource$RepresentationHolderArray[n11] = object;
            ++n11;
            continue;
            break;
        }
    }

    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }
}

