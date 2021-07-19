/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$Callback;
import com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistEventListener;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class HlsMediaPeriod
implements MediaPeriod,
HlsSampleStreamWrapper$Callback,
HlsPlaylistTracker$PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private MediaPeriod$Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers;
    private final MediaSourceEventListener$EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private int[][] manifestUrlIndicesPerWrapper;
    private final TransferListener mediaTransferListener;
    private final int metadataType;
    private int pendingPrepareCount;
    private final HlsPlaylistTracker playlistTracker;
    private HlsSampleStreamWrapper[] sampleStreamWrappers;
    private final IdentityHashMap streamWrapperIndices;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private TrackGroupArray trackGroups;
    private final boolean useSessionKeys;

    public HlsMediaPeriod(HlsExtractorFactory object, HlsPlaylistTracker object2, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean bl2, int n10, boolean bl3) {
        this.extractorFactory = object;
        this.playlistTracker = object2;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.mediaTransferListener = transferListener;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = drmSessionEventListener$EventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.allowChunklessPreparation = bl2;
        this.metadataType = n10;
        this.useSessionKeys = bl3;
        object2 = new SequenceableLoader[]{};
        this.compositeSequenceableLoader = object2 = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader((SequenceableLoader)object2);
        this.streamWrapperIndices = object2;
        super();
        this.timestampAdjusterProvider = object2;
        object2 = new HlsSampleStreamWrapper[]{};
        this.sampleStreamWrappers = object2;
        object2 = new HlsSampleStreamWrapper[]{};
        this.enabledSampleStreamWrappers = object2;
        object = new int[0][];
        this.manifestUrlIndicesPerWrapper = (int[][])object;
    }

    private void buildAndPrepareAudioSampleStreamWrappers(long l10, List list, List list2, List list3, Map map) {
        Object object;
        int n10;
        List list4 = list;
        int n11 = list.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        int n12 = list.size();
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n12);
        int n13 = list.size();
        ArrayList<Object> arrayList3 = new ArrayList<Object>(n13);
        HashSet<Uri[]> hashSet = new HashSet<Uri[]>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            int n14;
            Object object2;
            Object object3;
            Object object4 = ((HlsMasterPlaylist$Rendition)list4.get((int)i10)).name;
            int n15 = (int)(hashSet.add((Uri[])object4) ? 1 : 0);
            if (n15 == 0) {
                object = this;
                object3 = list2;
                object2 = list3;
                continue;
            }
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
            n15 = 1;
            object3 = null;
            int n16 = n15;
            for (int i11 = 0; i11 < (n14 = list.size()); ++i11) {
                object2 = ((HlsMasterPlaylist$Rendition)list4.get((int)i11)).name;
                n14 = (int)(Util.areEqual(object4, object2) ? 1 : 0);
                if (n14 == 0) continue;
                object2 = (HlsMasterPlaylist$Rendition)list4.get(i11);
                object = i11;
                arrayList3.add(object);
                object = ((HlsMasterPlaylist$Rendition)object2).url;
                arrayList.add(object);
                object = ((HlsMasterPlaylist$Rendition)object2).format;
                arrayList2.add(object);
                object2 = object2.format.codecs;
                n14 = Util.getCodecCountOfType((String)object2, n15);
                if (n14 == n15) {
                    n14 = n15;
                } else {
                    n14 = 0;
                    object2 = null;
                }
                n16 &= n14;
            }
            int n17 = 1;
            object4 = (Uri[])Util.castNonNullTypeArray(new Uri[0]);
            object4 = arrayList.toArray((T[])object4);
            Object object5 = object4;
            object5 = object4;
            object4 = new Format[]{};
            object4 = arrayList2.toArray((T[])object4);
            Object[] objectArray = object4;
            objectArray = (Format[])object4;
            List list5 = Collections.emptyList();
            object2 = this;
            object4 = this.buildSampleStreamWrapper(n17, (Uri[])object5, (Format[])objectArray, null, list5, map, l10);
            object3 = Ints.toArray(arrayList3);
            object2 = list3;
            list3.add(object3);
            object3 = list2;
            list2.add(object4);
            object = this;
            boolean bl2 = this.allowChunklessPreparation;
            if (!bl2 || n16 == 0) continue;
            Object[] objectArray2 = new Format[]{};
            objectArray2 = arrayList2.toArray(objectArray2);
            TrackGroup[] trackGroupArray = new TrackGroup[n15];
            trackGroupArray[0] = object5 = new TrackGroup((Format[])objectArray2);
            objectArray2 = new int[0];
            ((HlsSampleStreamWrapper)object4).prepareWithMasterPlaylistInfo(trackGroupArray, 0, (int[])objectArray2);
        }
        object = this;
    }

    private void buildAndPrepareMainSampleStreamWrapper(HlsMasterPlaylist hlsMasterPlaylist, long l10, List list, List list2, Map map) {
        Object object;
        Format[] formatArray;
        int n10;
        Object object2;
        int n11;
        int n12;
        int n13;
        Object object3;
        Object object4 = hlsMasterPlaylist;
        Object object5 = hlsMasterPlaylist.variants;
        int n14 = object5.size();
        Object object6 = new int[n14];
        int n15 = 0;
        Format[] formatArray2 = null;
        int n16 = 0;
        ArrayList<Object> arrayList = null;
        int n17 = 0;
        Object object7 = null;
        while (true) {
            object3 = ((HlsMasterPlaylist)object4).variants;
            int n18 = object3.size();
            n13 = 2;
            n12 = 1;
            if (n15 >= n18) break;
            object3 = ((HlsMasterPlaylist$Variant)object4.variants.get((int)n15)).format;
            n11 = ((Format)object3).height;
            if (n11 <= 0 && (object2 = Util.getCodecsOfType(((Format)object3).codecs, n13)) == null) {
                object3 = Util.getCodecsOfType(((Format)object3).codecs, n12);
                if (object3 != null) {
                    object6[n15] = n12;
                    ++n17;
                } else {
                    object6[n15] = n18 = -1;
                }
            } else {
                object6[n15] = n13;
                ++n16;
            }
            ++n15;
        }
        if (n16 > 0) {
            n14 = n16;
            n15 = n12;
            n16 = 0;
            arrayList = null;
        } else if (n17 < n14) {
            n14 -= n17;
            n15 = 0;
            formatArray2 = null;
            n16 = n12;
        } else {
            n15 = 0;
            formatArray2 = null;
            n16 = 0;
            arrayList = null;
        }
        Uri[] uriArray = new Uri[n14];
        object7 = new Format[n14];
        object3 = new int[n14];
        object2 = null;
        int n19 = 0;
        Format format = null;
        for (n11 = 0; n11 < (n10 = (formatArray = ((HlsMasterPlaylist)object4).variants).size()); ++n11) {
            if (n15 != 0 && (n10 = object6[n11]) != n13 || n16 != 0 && (n10 = object6[n11]) == n12) continue;
            formatArray = (HlsMasterPlaylist$Variant)((HlsMasterPlaylist)object4).variants.get(n11);
            uriArray[n19] = object = formatArray.url;
            formatArray = formatArray.format;
            object7[n19] = formatArray;
            n10 = n19 + 1;
            object3[n19] = n11;
            n19 = n10;
        }
        object6 = object7[0].codecs;
        n15 = Util.getCodecCountOfType((String)object6, n13);
        int n20 = Util.getCodecCountOfType((String)object6, n12);
        if (n20 <= n12 && n15 <= n12 && (n16 = n20 + n15) > 0) {
            n16 = n12;
        } else {
            n16 = 0;
            arrayList = null;
        }
        n19 = 0;
        format = null;
        object = ((HlsMasterPlaylist)object4).muxedAudioFormat;
        List list3 = ((HlsMasterPlaylist)object4).muxedCaptionFormats;
        object2 = this;
        formatArray = object7;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.buildSampleStreamWrapper(0, uriArray, (Format[])object7, (Format)object, list3, map, l10);
        object2 = list;
        list.add(hlsSampleStreamWrapper);
        object2 = list2;
        list2.add(object3);
        object3 = this;
        n11 = (int)(this.allowChunklessPreparation ? 1 : 0);
        if (n11 != 0 && n16 != 0) {
            int n21;
            arrayList = new ArrayList<Object>();
            if (n15 > 0) {
                formatArray2 = new Format[n14];
                object2 = null;
                for (n11 = 0; n11 < n14; ++n11) {
                    formatArray2[n11] = format = HlsMediaPeriod.deriveVideoFormat(object7[n11]);
                }
                object5 = new TrackGroup(formatArray2);
                arrayList.add(object5);
                if (n20 > 0 && ((object5 = ((HlsMasterPlaylist)object4).muxedAudioFormat) != null || (n14 = (int)((object5 = ((HlsMasterPlaylist)object4).audios).isEmpty() ? 1 : 0)) != 0)) {
                    object6 = new Format[n12];
                    formatArray2 = object7[0];
                    object7 = ((HlsMasterPlaylist)object4).muxedAudioFormat;
                    object6[0] = formatArray2 = HlsMediaPeriod.deriveAudioFormat((Format)formatArray2, (Format)object7, false);
                    object5 = new TrackGroup((Format[])object6);
                    arrayList.add(object5);
                }
                if ((object4 = ((HlsMasterPlaylist)object4).muxedCaptionFormats) != null) {
                    object5 = null;
                    for (n14 = 0; n14 < (n20 = object4.size()); ++n14) {
                        formatArray2 = new Format[n12];
                        formatArray2[0] = object7 = (Format)object4.get(n14);
                        object6 = new TrackGroup(formatArray2);
                        arrayList.add(object6);
                    }
                }
            } else {
                object6 = new Format[n14];
                formatArray2 = null;
                for (n15 = 0; n15 < n14; ++n15) {
                    object2 = object7[n15];
                    format = ((HlsMasterPlaylist)object4).muxedAudioFormat;
                    object2 = HlsMediaPeriod.deriveAudioFormat((Format)object2, format, n12 != 0);
                    object6[n15] = (int)object2;
                }
                object4 = new TrackGroup((Format[])object6);
                arrayList.add(object4);
            }
            object5 = new Format[n12];
            object6 = new Format$Builder;
            object6 = new Format$Builder();
            object6 = object6.setId("ID3");
            formatArray2 = "application/id3";
            object6 = object6.setSampleMimeType((String)formatArray2).build();
            object5[0] = object6;
            object4 = new TrackGroup((Format[])object5);
            arrayList.add(object4);
            object5 = new TrackGroup[]{};
            object5 = (TrackGroup[])arrayList.toArray((T[])object5);
            object6 = new int[n12];
            object6[0] = n21 = arrayList.indexOf(object4);
            hlsSampleStreamWrapper.prepareWithMasterPlaylistInfo((TrackGroup[])object5, 0, (int)object6);
        }
    }

    private void buildAndPrepareSampleStreamWrappers(long l10) {
        Object object;
        int n10;
        List<Object> list;
        Object object2;
        HlsMediaPeriod hlsMediaPeriod = this;
        Object object3 = Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist());
        TrackGroup[] trackGroupArray = object3;
        trackGroupArray = (HlsMasterPlaylist)object3;
        int n11 = this.useSessionKeys;
        object3 = n11 != 0 ? HlsMediaPeriod.deriveOverridingDrmInitData(trackGroupArray.sessionKeyDrmInitData) : Collections.emptyMap();
        Map map = object3;
        object3 = trackGroupArray.variants;
        n11 = object3.isEmpty();
        int n12 = 1;
        Format[] formatArray = trackGroupArray.audios;
        List list2 = trackGroupArray.subtitles;
        int n13 = 0;
        hlsMediaPeriod.pendingPrepareCount = 0;
        Object object4 = new ArrayList();
        ArrayList<TrackGroup[]> arrayList = new ArrayList<TrackGroup[]>();
        if ((n11 ^= n12) != 0) {
            object3 = this;
            object2 = object4;
            list = arrayList;
            this.buildAndPrepareMainSampleStreamWrapper((HlsMasterPlaylist)trackGroupArray, l10, (List)object4, arrayList, map);
        }
        object3 = this;
        Format[] formatArray2 = formatArray;
        object2 = object4;
        list = arrayList;
        this.buildAndPrepareAudioSampleStreamWrappers(l10, (List)formatArray, (List)object4, arrayList, map);
        formatArray = null;
        for (int i10 = 0; i10 < (n11 = list2.size()); ++i10) {
            object3 = list2.get(i10);
            Object object5 = object3;
            object5 = (HlsMasterPlaylist$Rendition)object3;
            n10 = 3;
            object = new Uri[n12];
            object3 = object5.url;
            object[0] = object3;
            formatArray2 = new Format[n12];
            object3 = object5.format;
            formatArray2[0] = object3;
            list = Collections.emptyList();
            object3 = this;
            object3 = this.buildSampleStreamWrapper(n10, (Uri[])object, formatArray2, null, list, map, l10);
            trackGroupArray = (TrackGroup[])new int[n12];
            trackGroupArray[0] = i10;
            arrayList.add(trackGroupArray);
            object4.add(object3);
            trackGroupArray = new TrackGroup[n12];
            formatArray2 = new Format[n12];
            object2 = object5;
            formatArray2[0] = object2 = object5.format;
            object = new TrackGroup(formatArray2);
            trackGroupArray[0] = object;
            object = new int[0];
            ((HlsSampleStreamWrapper)object3).prepareWithMasterPlaylistInfo(trackGroupArray, 0, (int[])object);
        }
        object3 = new HlsSampleStreamWrapper[]{};
        object3 = object4.toArray((T[])object3);
        hlsMediaPeriod.sampleStreamWrappers = object3;
        object3 = new int[0][];
        object3 = (int[][])arrayList.toArray((T[])object3);
        hlsMediaPeriod.manifestUrlIndicesPerWrapper = (int[][])object3;
        object3 = hlsMediaPeriod.sampleStreamWrappers;
        hlsMediaPeriod.pendingPrepareCount = n10 = ((HlsSampleStreamWrapper[])object3).length;
        object3[0].setIsTimestampMaster(n12 != 0);
        object3 = hlsMediaPeriod.sampleStreamWrappers;
        n10 = ((HlsSampleStreamWrapper[])object3).length;
        while (n13 < n10) {
            object = object3[n13];
            object.continuePreparing();
            ++n13;
        }
        object3 = hlsMediaPeriod.sampleStreamWrappers;
        hlsMediaPeriod.enabledSampleStreamWrappers = object3;
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(int n10, Uri[] uriArray, Format[] formatArray, Format format, List list, Map map, long l10) {
        HlsExtractorFactory hlsExtractorFactory = this.extractorFactory;
        Object object = this.playlistTracker;
        Object object2 = this.dataSourceFactory;
        TransferListener transferListener = this.mediaTransferListener;
        TimestampAdjusterProvider timestampAdjusterProvider = this.timestampAdjusterProvider;
        Object object3 = uriArray;
        Object object4 = new HlsChunkSource(hlsExtractorFactory, (HlsPlaylistTracker)object, uriArray, formatArray, (HlsDataSourceFactory)object2, transferListener, timestampAdjusterProvider, list);
        object2 = this.allocator;
        Object object5 = this.drmSessionManager;
        Object object6 = this.drmEventDispatcher;
        Object object7 = this.loadErrorHandlingPolicy;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.eventDispatcher;
        int n11 = this.metadataType;
        object = this;
        object3 = object4;
        object4 = object5;
        object5 = object6;
        object6 = object7;
        object7 = mediaSourceEventListener$EventDispatcher;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = new HlsSampleStreamWrapper(n10, this, (HlsChunkSource)object3, map, (Allocator)object2, l10, format, (DrmSessionManager)object4, (DrmSessionEventListener$EventDispatcher)object5, (LoadErrorHandlingPolicy)object6, mediaSourceEventListener$EventDispatcher, n11);
        return hlsSampleStreamWrapper;
    }

    private static Format deriveAudioFormat(Format object, Format object2, boolean bl2) {
        String string2;
        int n10;
        int n11;
        int n12;
        int n13 = 0;
        Object object3 = null;
        int n14 = 0;
        Metadata metadata = null;
        int n15 = -1;
        if (object2 != null) {
            object3 = ((Format)object2).codecs;
            metadata = ((Format)object2).metadata;
            n12 = ((Format)object2).channelCount;
            n11 = ((Format)object2).selectionFlags;
            int n16 = ((Format)object2).roleFlags;
            String string3 = ((Format)object2).language;
            object2 = ((Format)object2).label;
            n10 = n12;
            n12 = n16;
            string2 = string3;
        } else {
            object2 = ((Format)object).codecs;
            n12 = 1;
            object2 = Util.getCodecsOfType((String)object2, n12);
            Metadata metadata2 = ((Format)object).metadata;
            if (bl2) {
                n13 = ((Format)object).channelCount;
                n14 = ((Format)object).selectionFlags;
                n11 = ((Format)object).roleFlags;
                string2 = ((Format)object).language;
                String string4 = ((Format)object).label;
                object3 = object2;
                object2 = string4;
                n10 = n13;
                int n17 = n11;
                n11 = n14;
                metadata = metadata2;
                n12 = n17;
            } else {
                boolean bl3 = false;
                string2 = null;
                n11 = 0;
                n10 = n15;
                object3 = object2;
                object2 = null;
                metadata = metadata2;
                n12 = 0;
                metadata2 = null;
            }
        }
        String string5 = MimeTypes.getMediaMimeType((String)object3);
        int n18 = bl2 ? ((Format)object).averageBitrate : n15;
        if (bl2) {
            n15 = ((Format)object).peakBitrate;
        }
        Format$Builder format$Builder = new Format$Builder();
        String string6 = ((Format)object).id;
        object2 = format$Builder.setId(string6).setLabel((String)object2);
        object = ((Format)object).containerMimeType;
        return ((Format$Builder)object2).setContainerMimeType((String)object).setSampleMimeType(string5).setCodecs((String)object3).setMetadata(metadata).setAverageBitrate(n18).setPeakBitrate(n15).setChannelCount(n10).setSelectionFlags(n11).setRoleFlags(n12).setLanguage(string2).build();
    }

    private static Map deriveOverridingDrmInitData(List list) {
        int n10;
        ArrayList arrayList = new ArrayList(list);
        HashMap<String, DrmInitData> hashMap = new HashMap<String, DrmInitData>();
        int n11 = 0;
        while (n11 < (n10 = arrayList.size())) {
            int n12;
            DrmInitData drmInitData = (DrmInitData)list.get(n11);
            String string2 = drmInitData.schemeType;
            int n13 = ++n11;
            while (n13 < (n12 = arrayList.size())) {
                DrmInitData drmInitData2 = (DrmInitData)arrayList.get(n13);
                String string3 = drmInitData2.schemeType;
                boolean bl2 = TextUtils.equals((CharSequence)string3, (CharSequence)string2);
                if (bl2) {
                    drmInitData = drmInitData.merge(drmInitData2);
                    arrayList.remove(n13);
                    continue;
                }
                ++n13;
            }
            hashMap.put(string2, drmInitData);
        }
        return hashMap;
    }

    private static Format deriveVideoFormat(Format format) {
        Object object = Util.getCodecsOfType(format.codecs, 2);
        Object object2 = MimeTypes.getMediaMimeType((String)object);
        Format$Builder format$Builder = new Format$Builder();
        String string2 = format.id;
        format$Builder = format$Builder.setId(string2);
        string2 = format.label;
        format$Builder = format$Builder.setLabel(string2);
        string2 = format.containerMimeType;
        object = format$Builder.setContainerMimeType(string2).setSampleMimeType((String)object2).setCodecs((String)object);
        object2 = format.metadata;
        object = ((Format$Builder)object).setMetadata((Metadata)object2);
        int n10 = format.averageBitrate;
        object = ((Format$Builder)object).setAverageBitrate(n10);
        n10 = format.peakBitrate;
        object = ((Format$Builder)object).setPeakBitrate(n10);
        n10 = format.width;
        object = ((Format$Builder)object).setWidth(n10);
        n10 = format.height;
        object = ((Format$Builder)object).setHeight(n10);
        float f10 = format.frameRate;
        object = ((Format$Builder)object).setFrameRate(f10);
        n10 = format.selectionFlags;
        object = ((Format$Builder)object).setSelectionFlags(n10);
        int n11 = format.roleFlags;
        return ((Format$Builder)object).setRoleFlags(n11).build();
    }

    public boolean continueLoading(long l10) {
        TrackGroupArray trackGroupArray = this.trackGroups;
        if (trackGroupArray == null) {
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArray = this.sampleStreamWrappers;
            int n10 = hlsSampleStreamWrapperArray.length;
            trackGroupArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsSampleStreamWrapperArray[i10];
                hlsSampleStreamWrapper.continuePreparing();
            }
            return false;
        }
        return this.compositeSequenceableLoader.continueLoading(l10);
    }

    public void discardBuffer(long l10, boolean bl2) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            hlsSampleStreamWrapper.discardBuffer(l10, bl2);
        }
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        return l10;
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public List getStreamKeys(List list) {
        Object object;
        boolean bl2;
        int n10;
        TrackGroupArray trackGroupArray;
        int[] nArray;
        HlsSampleStreamWrapper hlsSampleStreamWrapper;
        Object object2 = this;
        HlsMasterPlaylist hlsMasterPlaylist = (HlsMasterPlaylist)Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist());
        List list2 = hlsMasterPlaylist.variants;
        int n11 = list2.isEmpty();
        int n12 = 1;
        Object object3 = this.sampleStreamWrappers;
        int n13 = ((HlsSampleStreamWrapper[])object3).length;
        int n14 = hlsMasterPlaylist.subtitles.size();
        n13 -= n14;
        n14 = 0;
        Object[] objectArray = null;
        if ((n11 ^= n12) != 0) {
            hlsSampleStreamWrapper = this.sampleStreamWrappers[0];
            nArray = this.manifestUrlIndicesPerWrapper[0];
            trackGroupArray = hlsSampleStreamWrapper.getTrackGroups();
            n10 = hlsSampleStreamWrapper.getPrimaryTrackGroupIndex();
        } else {
            nArray = new int[]{};
            trackGroupArray = TrackGroupArray.EMPTY;
            n10 = 0;
            hlsSampleStreamWrapper = null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = list.iterator();
        boolean bl3 = false;
        int n15 = 0;
        while (bl2 = iterator2.hasNext()) {
            ExoTrackSelection exoTrackSelection = (ExoTrackSelection)iterator2.next();
            Object object4 = exoTrackSelection.getTrackGroup();
            Object object5 = trackGroupArray.indexOf((TrackGroup)object4);
            if (object5 != (n12 = -1)) {
                if (object5 == n10) {
                    object = null;
                    for (n12 = 0; n12 < (n15 = exoTrackSelection.length()); ++n12) {
                        n15 = exoTrackSelection.getIndexInTrackGroup(n12);
                        n15 = nArray[n15];
                        object4 = new StreamKey(0, n15);
                        arrayList.add(object4);
                    }
                    n15 = 1;
                } else {
                    bl3 = true;
                }
            } else {
                for (object5 = n11; object5 < (n12 = (objectArray = ((HlsMediaPeriod)object2).sampleStreamWrappers).length); ++object5) {
                    object = objectArray[object5].getTrackGroups();
                    n12 = ((TrackGroupArray)object).indexOf((TrackGroup)object4);
                    if (n12 != (n14 = -1)) {
                        n12 = object5 < n13 ? 1 : 2;
                        objectArray = ((HlsMediaPeriod)object2).manifestUrlIndicesPerWrapper[object5];
                        object4 = null;
                        for (int i10 = 0; i10 < (object5 = exoTrackSelection.length()); ++i10) {
                            object5 = exoTrackSelection.getIndexInTrackGroup(i10);
                            object5 = objectArray[object5];
                            object2 = new StreamKey(n12, (int)object5);
                            arrayList.add(object2);
                            object2 = this;
                        }
                        break;
                    }
                    object2 = this;
                    n12 = n14;
                }
            }
            object2 = this;
            n12 = 1;
            n14 = 0;
            objectArray = null;
        }
        if (bl3 && n15 == 0) {
            n11 = nArray[0];
            object = hlsMasterPlaylist.variants;
            n13 = nArray[0];
            object2 = ((HlsMasterPlaylist$Variant)object.get((int)n13)).format;
            int n16 = ((Format)object2).bitrate;
            for (n12 = 1; n12 < (n13 = nArray.length); ++n12) {
                object3 = hlsMasterPlaylist.variants;
                n14 = nArray[n12];
                object3 = ((HlsMasterPlaylist$Variant)object3.get((int)n14)).format;
                n13 = ((Format)object3).bitrate;
                if (n13 >= n16) continue;
                n11 = nArray[n12];
                n16 = n13;
            }
            hlsMasterPlaylist = null;
            object2 = new StreamKey(0, n11);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray)Assertions.checkNotNull(this.trackGroups);
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.maybeThrowPrepareError();
        }
    }

    public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.callback.onContinueLoadingRequested(this);
    }

    public void onPlaylistChanged() {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.onPlaylistUpdated();
        }
        this.callback.onContinueLoadingRequested(this);
    }

    public boolean onPlaylistError(Uri uri, long l10) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArray = this.sampleStreamWrappers;
        int n10 = hlsSampleStreamWrapperArray.length;
        boolean bl2 = true;
        for (int i10 = 0; i10 < n10; ++i10) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsSampleStreamWrapperArray[i10];
            boolean bl3 = hlsSampleStreamWrapper.onPlaylistError(uri, l10);
            bl2 &= bl3;
        }
        this.callback.onContinueLoadingRequested(this);
        return bl2;
    }

    public void onPlaylistRefreshRequired(Uri uri) {
        this.playlistTracker.refreshPlaylist(uri);
    }

    public void onPrepared() {
        int n10;
        TrackGroupArray trackGroupArray;
        int n11;
        int n12;
        this.pendingPrepareCount = n12 = this.pendingPrepareCount + -1;
        if (n12 > 0) {
            return;
        }
        Object[] objectArray = this.sampleStreamWrappers;
        int n13 = objectArray.length;
        int n14 = 0;
        for (n11 = 0; n11 < n13; ++n11) {
            trackGroupArray = objectArray[n11].getTrackGroups();
            n10 = trackGroupArray.length;
            n14 += n10;
        }
        objectArray = new TrackGroup[n14];
        Object object = this.sampleStreamWrappers;
        n11 = ((HlsSampleStreamWrapper[])object).length;
        n10 = 0;
        trackGroupArray = null;
        for (n14 = 0; n14 < n11; ++n14) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = object[n14];
            TrackGroupArray trackGroupArray2 = hlsSampleStreamWrapper.getTrackGroups();
            int n15 = trackGroupArray2.length;
            for (int i10 = 0; i10 < n15; ++i10) {
                int n16 = n10 + 1;
                TrackGroup trackGroup = hlsSampleStreamWrapper.getTrackGroups().get(i10);
                objectArray[n10] = trackGroup;
                n10 = n16;
            }
        }
        this.trackGroups = object = new TrackGroupArray((TrackGroup[])objectArray);
        this.callback.onPrepared(this);
    }

    public void prepare(MediaPeriod$Callback mediaPeriod$Callback, long l10) {
        this.callback = mediaPeriod$Callback;
        this.playlistTracker.addListener(this);
        this.buildAndPrepareSampleStreamWrappers(l10);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long l10) {
        this.compositeSequenceableLoader.reevaluateBuffer(l10);
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.release();
        }
        this.callback = null;
    }

    public long seekToUs(long l10) {
        Object object = this.enabledSampleStreamWrappers;
        int n10 = ((HlsSampleStreamWrapper[])object).length;
        if (n10 > 0) {
            Object object2;
            int n11;
            object = object[0];
            boolean bl2 = ((HlsSampleStreamWrapper)object).seekToUs(l10, false);
            for (n10 = 1; n10 < (n11 = ((HlsSampleStreamWrapper[])(object2 = this.enabledSampleStreamWrappers)).length); ++n10) {
                object2 = object2[n10];
                ((HlsSampleStreamWrapper)object2).seekToUs(l10, bl2);
            }
            if (bl2) {
                object = this.timestampAdjusterProvider;
                ((TimestampAdjusterProvider)object).reset();
            }
        }
        return l10;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArray, boolean[] blArray, SampleStream[] sampleStreamArray, boolean[] blArray2, long l10) {
        Object object;
        int n10;
        Object object2;
        int n11;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14;
        int n15;
        HlsMediaPeriod hlsMediaPeriod = this;
        Object object5 = exoTrackSelectionArray;
        Object[] objectArray = sampleStreamArray;
        int n16 = exoTrackSelectionArray.length;
        int[] nArray = new int[n16];
        int n17 = exoTrackSelectionArray.length;
        int[] nArray2 = new int[n17];
        IdentityHashMap identityHashMap = null;
        block0: for (n15 = 0; n15 < (n14 = ((ExoTrackSelection[])object5).length); ++n15) {
            object4 = objectArray[n15];
            n13 = -1;
            if (object4 == null) {
                n14 = n13;
            } else {
                object4 = hlsMediaPeriod.streamWrapperIndices;
                object3 = objectArray[n15];
                object4 = (Integer)((IdentityHashMap)object4).get(object3);
                n14 = (Integer)object4;
            }
            nArray[n15] = n14;
            nArray2[n15] = n13;
            object4 = object5[n15];
            if (object4 == null) continue;
            object4 = object5[n15].getTrackGroup();
            object3 = null;
            for (n12 = 0; n12 < (n11 = ((HlsSampleStreamWrapper[])(object2 = hlsMediaPeriod.sampleStreamWrappers)).length); ++n12) {
                n10 = ((TrackGroupArray)(object2 = object2[n12].getTrackGroups())).indexOf((TrackGroup)object4);
                if (n10 == n13) continue;
                nArray2[n15] = n12;
                continue block0;
            }
        }
        identityHashMap = hlsMediaPeriod.streamWrapperIndices;
        identityHashMap.clear();
        n15 = ((ExoTrackSelection[])object5).length;
        object4 = new SampleStream[n15];
        n13 = ((ExoTrackSelection[])object5).length;
        SampleStream[] sampleStreamArray2 = new SampleStream[n13];
        Object object6 = new ExoTrackSelection[((ExoTrackSelection[])object5).length];
        object3 = hlsMediaPeriod.sampleStreamWrappers;
        n12 = ((HlsSampleStreamWrapper[])object3).length;
        Object[] objectArray2 = new HlsSampleStreamWrapper[n12];
        int n18 = 0;
        Object object7 = null;
        int n19 = 0;
        float f10 = 0.0f;
        int n20 = 0;
        while (n19 < (n12 = ((HlsSampleStreamWrapper[])(object3 = hlsMediaPeriod.sampleStreamWrappers)).length)) {
            ExoTrackSelection[] exoTrackSelectionArray2;
            int n21;
            block17: {
                int n22;
                block14: {
                    block15: {
                        block18: {
                            block16: {
                                Object object8;
                                object3 = null;
                                for (n12 = 0; n12 < (n10 = ((ExoTrackSelection[])object5).length); ++n12) {
                                    n10 = nArray[n12];
                                    n11 = 0;
                                    object8 = null;
                                    if (n10 == n19) {
                                        object2 = objectArray[n12];
                                    } else {
                                        n10 = 0;
                                        object2 = null;
                                    }
                                    sampleStreamArray2[n12] = object2;
                                    n10 = nArray2[n12];
                                    if (n10 == n19) {
                                        object8 = object5[n12];
                                    }
                                    object6[n12] = object8;
                                }
                                object3 = object8 = hlsMediaPeriod.sampleStreamWrappers[n19];
                                object2 = object6;
                                object = object8;
                                object8 = blArray;
                                object7 = sampleStreamArray2;
                                n21 = n15;
                                n15 = n19;
                                n22 = n18;
                                exoTrackSelectionArray2 = object6;
                                objectArray = objectArray2;
                                n12 = (int)(((HlsSampleStreamWrapper)object3).selectTracks((ExoTrackSelection[])object6, blArray, sampleStreamArray2, blArray2, l10, n20 != 0) ? 1 : 0);
                                n10 = 0;
                                object2 = null;
                                n11 = 0;
                                object8 = null;
                                while (true) {
                                    n18 = ((Object[])object5).length;
                                    n19 = 1;
                                    f10 = Float.MIN_VALUE;
                                    if (n10 >= n18) break;
                                    object7 = sampleStreamArray2[n10];
                                    int n23 = nArray2[n10];
                                    if (n23 == n15) {
                                        Assertions.checkNotNull(object7);
                                        object4[n10] = object7;
                                        object8 = hlsMediaPeriod.streamWrapperIndices;
                                        object6 = n15;
                                        ((IdentityHashMap)object8).put(object7, object6);
                                        n11 = n19;
                                    } else {
                                        n23 = nArray[n10];
                                        if (n23 == n15) {
                                            if (object7 != null) {
                                                n19 = 0;
                                                f10 = 0.0f;
                                            }
                                            Assertions.checkState(n19 != 0);
                                        }
                                    }
                                    ++n10;
                                }
                                if (n11 == 0) break block14;
                                objectArray[n22] = object;
                                n18 = n22 + 1;
                                if (n22 != 0) break block15;
                                ((HlsSampleStreamWrapper)object).setIsTimestampMaster(n19 != 0);
                                if (n12 != 0 || (n10 = ((Object)(object3 = hlsMediaPeriod.enabledSampleStreamWrappers)).length) == 0) break block16;
                                n10 = 0;
                                object2 = null;
                                if (object == (object3 = object3[0])) break block17;
                                break block18;
                            }
                            n10 = 0;
                            object2 = null;
                        }
                        object = hlsMediaPeriod.timestampAdjusterProvider;
                        ((TimestampAdjusterProvider)object).reset();
                        n20 = n19;
                        break block17;
                    }
                    n10 = 0;
                    object2 = null;
                    ((HlsSampleStreamWrapper)object).setIsTimestampMaster(false);
                    break block17;
                }
                n10 = 0;
                object2 = null;
                n18 = n22;
            }
            n19 = n15 + 1;
            objectArray2 = objectArray;
            n15 = n21;
            object6 = exoTrackSelectionArray2;
            objectArray = sampleStreamArray;
        }
        object = objectArray;
        objectArray = objectArray2;
        System.arraycopy(object4, 0, object, 0, n15);
        object5 = (HlsSampleStreamWrapper[])Util.nullSafeArrayCopy(objectArray2, n18);
        hlsMediaPeriod.enabledSampleStreamWrappers = object5;
        hlsMediaPeriod.compositeSequenceableLoader = object5 = hlsMediaPeriod.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader((SequenceableLoader[])object5);
        return l10;
    }
}

