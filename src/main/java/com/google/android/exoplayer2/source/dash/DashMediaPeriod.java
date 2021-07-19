/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 */
package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.SequenceableLoader$Callback;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream$EmbeddedSampleStream;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream$ReleaseCallback;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashChunkSource$Factory;
import com.google.android.exoplayer2.source.dash.DashMediaPeriod$TrackGroupInfo;
import com.google.android.exoplayer2.source.dash.EventSampleStream;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerEmsgCallback;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DashMediaPeriod
implements MediaPeriod,
SequenceableLoader$Callback,
ChunkSampleStream$ReleaseCallback {
    private static final Pattern CEA608_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern CEA708_SERVICE_DESCRIPTOR_REGEX = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    private final Allocator allocator;
    private MediaPeriod$Callback callback;
    private final DashChunkSource$Factory chunkSourceFactory;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealtimeOffsetMs;
    private EventSampleStream[] eventSampleStreams;
    private List eventStreams;
    public final int id;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    private int periodIndex;
    private final PlayerEmsgHandler playerEmsgHandler;
    private ChunkSampleStream[] sampleStreams;
    private final IdentityHashMap trackEmsgHandlerBySampleStream;
    private final DashMediaPeriod$TrackGroupInfo[] trackGroupInfos;
    private final TrackGroupArray trackGroups;
    private final TransferListener transferListener;

    public DashMediaPeriod(int n10, DashManifest object, int n11, DashChunkSource$Factory chunkSampleStreamArray, TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, long l10, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler$PlayerEmsgCallback playerEmsgHandler$PlayerEmsgCallback) {
        this.id = n10;
        this.manifest = object;
        this.periodIndex = n11;
        this.chunkSourceFactory = chunkSampleStreamArray;
        this.transferListener = transferListener;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = drmSessionEventListener$EventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.mediaSourceEventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.elapsedRealtimeOffsetMs = l10;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        Object[] objectArray = new PlayerEmsgHandler((DashManifest)object, playerEmsgHandler$PlayerEmsgCallback, allocator);
        this.playerEmsgHandler = objectArray;
        chunkSampleStreamArray = DashMediaPeriod.newSampleStreamArray(0);
        this.sampleStreams = chunkSampleStreamArray;
        objectArray = new EventSampleStream[]{};
        this.eventSampleStreams = objectArray;
        this.trackEmsgHandlerBySampleStream = objectArray;
        objectArray = this.sampleStreams;
        objectArray = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader((SequenceableLoader[])objectArray);
        this.compositeSequenceableLoader = objectArray;
        objectArray = ((DashManifest)object).getPeriod(n11);
        this.eventStreams = object = objectArray.eventStreams;
        objectArray = objectArray.adaptationSets;
        objectArray = DashMediaPeriod.buildTrackGroups(drmSessionManager, (List)objectArray, (List)object);
        this.trackGroups = object = (TrackGroupArray)objectArray.first;
        objectArray = (DashMediaPeriod$TrackGroupInfo[])objectArray.second;
        this.trackGroupInfos = objectArray;
    }

    private static void buildManifestEventTrackGroupInfos(List list, TrackGroup[] trackGroupArray, DashMediaPeriod$TrackGroupInfo[] dashMediaPeriod$TrackGroupInfoArray, int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object object = (EventStream)list.get(i10);
            Object object2 = new Format$Builder();
            object = ((EventStream)object).id();
            object = ((Format$Builder)object2).setId((String)object).setSampleMimeType("application/x-emsg").build();
            int n12 = 1;
            Format[] formatArray = new Format[n12];
            formatArray[0] = object;
            trackGroupArray[n10] = object2 = new TrackGroup(formatArray);
            n11 = n10 + 1;
            dashMediaPeriod$TrackGroupInfoArray[n10] = object2 = DashMediaPeriod$TrackGroupInfo.mpdEventTrack(i10);
            n10 = n11;
        }
    }

    private static int buildPrimaryAndEmbeddedTrackGroupInfos(DrmSessionManager drmSessionManager, List list, int[][] nArray, int n10, boolean[] blArray, Format[][] formatArray, TrackGroup[] trackGroupArray, DashMediaPeriod$TrackGroupInfo[] dashMediaPeriod$TrackGroupInfoArray) {
        List list2 = list;
        int n11 = n10;
        int n12 = 0;
        DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            Format[] formatArray2;
            List list3;
            int n13;
            int n14;
            int[] nArray2 = nArray[i10];
            Object object = new ArrayList();
            int n15 = nArray2.length;
            Object object2 = null;
            for (n14 = 0; n14 < n15; ++n14) {
                n13 = nArray2[n14];
                list3 = ((AdaptationSet)list2.get((int)n13)).representations;
                object.addAll(list3);
            }
            n15 = object.size();
            object2 = new Format[n15];
            list3 = null;
            for (n13 = 0; n13 < n15; ++n13) {
                Format format = ((Representation)object.get((int)n13)).format;
                formatArray2 = drmSessionManager.getExoMediaCryptoType(format);
                object2[n13] = format = format.copyWithExoMediaCryptoType((Class)formatArray2);
            }
            int n16 = nArray2[0];
            object = (AdaptationSet)list2.get(n16);
            n15 = n12 + 1;
            n13 = blArray[i10];
            int n17 = -1;
            if (n13 != 0) {
                n13 = n15 + 1;
            } else {
                n13 = n15;
                n15 = n17;
            }
            formatArray2 = formatArray[i10];
            int n18 = formatArray2.length;
            if (n18 != 0) {
                n18 = n13 + 1;
            } else {
                n18 = n13;
                n13 = n17;
            }
            Format[] formatArray3 = new TrackGroup((Format[])object2);
            trackGroupArray[n12] = formatArray3;
            n14 = ((AdaptationSet)object).type;
            object2 = DashMediaPeriod$TrackGroupInfo.primaryTrack(n14, nArray2, n12, n15, n13);
            dashMediaPeriod$TrackGroupInfoArray[n12] = object2;
            if (n15 != n17) {
                object2 = new Format$Builder();
                n16 = ((AdaptationSet)object).id;
                StringBuilder stringBuilder = new StringBuilder(16);
                stringBuilder.append(n16);
                stringBuilder.append(":emsg");
                object = stringBuilder.toString();
                object = ((Format$Builder)object2).setId((String)object).setSampleMimeType("application/x-emsg").build();
                int n19 = 1;
                formatArray3 = new Format[n19];
                formatArray3[0] = object;
                trackGroupArray[n15] = object2 = new TrackGroup(formatArray3);
                dashMediaPeriod$TrackGroupInfoArray[n15] = object = DashMediaPeriod$TrackGroupInfo.embeddedEmsgTrack(nArray2, n12);
            }
            if (n13 != n17) {
                Format[] formatArray4 = formatArray[i10];
                trackGroupArray[n13] = object = new TrackGroup(formatArray4);
                dashMediaPeriod$TrackGroupInfoArray[n13] = dashMediaPeriod$TrackGroupInfo = DashMediaPeriod$TrackGroupInfo.embeddedClosedCaptionTrack(nArray2, n12);
            }
            n12 = n18;
        }
        return n12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ChunkSampleStream buildSampleStream(DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo, ExoTrackSelection object, long l10) {
        Object object2;
        Format[] formatArray;
        Object object3;
        int n10;
        Object object4;
        Object object5;
        DashMediaPeriod dashMediaPeriod = this;
        Object object6 = dashMediaPeriod$TrackGroupInfo;
        int n11 = dashMediaPeriod$TrackGroupInfo.embeddedEventMessageTrackGroupIndex;
        int n12 = -1;
        int n13 = 1;
        int n14 = 0;
        Object[] objectArray = null;
        int n15 = n11 != n12 ? n13 : 0;
        int n16 = 0;
        Object object7 = null;
        if (n15 != 0) {
            object5 = dashMediaPeriod.trackGroups;
            object4 = ((TrackGroupArray)object5).get(n11);
            n10 = n13;
        } else {
            n10 = 0;
            object5 = null;
            n11 = 0;
            object4 = null;
        }
        int n17 = ((DashMediaPeriod$TrackGroupInfo)object6).embeddedClosedCaptionTrackGroupIndex;
        if (n17 != n12) {
            n12 = n13;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 != 0) {
            formatArray = dashMediaPeriod.trackGroups;
            object2 = formatArray.get(n17);
            int n18 = ((TrackGroup)object2).length;
            n10 += n18;
        } else {
            n17 = 0;
            object2 = null;
        }
        formatArray = new Format[n10];
        object5 = new int[n10];
        if (n15 != 0) {
            object4 = ((TrackGroup)object4).getFormat(0);
            formatArray[0] = object4;
            object5[0] = 5;
            n11 = n13;
        } else {
            n11 = 0;
            object4 = null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (n12 != 0) {
            while (n14 < (n12 = ((TrackGroup)object2).length)) {
                object3 = ((TrackGroup)object2).getFormat(n14);
                formatArray[n11] = object3;
                n12 = 3;
                object5[n11] = n12;
                object3 = formatArray[n11];
                arrayList.add(object3);
                n11 += n13;
                ++n14;
            }
        }
        object4 = dashMediaPeriod.manifest;
        n11 = (int)(((DashManifest)object4).dynamic ? 1 : 0);
        if (n11 != 0 && n15 != 0) {
            object4 = dashMediaPeriod.playerEmsgHandler;
            object7 = ((PlayerEmsgHandler)object4).newPlayerTrackEmsgHandler();
        }
        Object object8 = object7;
        Object object9 = dashMediaPeriod.chunkSourceFactory;
        object4 = dashMediaPeriod.manifestLoaderErrorThrower;
        object3 = dashMediaPeriod.manifest;
        n13 = dashMediaPeriod.periodIndex;
        objectArray = ((DashMediaPeriod$TrackGroupInfo)object6).adaptationSetIndices;
        n16 = ((DashMediaPeriod$TrackGroupInfo)object6).trackType;
        long l11 = dashMediaPeriod.elapsedRealtimeOffsetMs;
        object2 = dashMediaPeriod.transferListener;
        PlayerEmsgHandler$PlayerTrackEmsgHandler playerEmsgHandler$PlayerTrackEmsgHandler = object7;
        object7 = object9.createDashChunkSource((LoaderErrorThrower)object4, (DashManifest)object3, n13, (int[])objectArray, (ExoTrackSelection)object, n16, l11, n15 != 0, arrayList, (PlayerEmsgHandler$PlayerTrackEmsgHandler)object7, (TransferListener)object2);
        n12 = ((DashMediaPeriod$TrackGroupInfo)object6).trackType;
        object2 = dashMediaPeriod.allocator;
        DrmSessionManager drmSessionManager = dashMediaPeriod.drmSessionManager;
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = dashMediaPeriod.drmEventDispatcher;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = dashMediaPeriod.loadErrorHandlingPolicy;
        object6 = dashMediaPeriod.mediaSourceEventDispatcher;
        object4 = object9;
        Object object10 = object5;
        objectArray = formatArray;
        object5 = this;
        object = object9;
        object9 = object8;
        object8 = object6;
        ((ChunkSampleStream)object4)(n12, (int[])object10, formatArray, (ChunkSource)object7, this, (Allocator)object2, l10, drmSessionManager, drmSessionEventListener$EventDispatcher, loadErrorHandlingPolicy, (MediaSourceEventListener$EventDispatcher)object6);
        synchronized (this) {
            object6 = dashMediaPeriod.trackEmsgHandlerBySampleStream;
            ((IdentityHashMap)object6).put(object4, playerEmsgHandler$PlayerTrackEmsgHandler);
            return object4;
        }
    }

    private static Pair buildTrackGroups(DrmSessionManager object, List list, List list2) {
        int[][] nArray = DashMediaPeriod.getGroupedAdaptationSetIndices(list);
        int n10 = nArray.length;
        boolean[] blArray = new boolean[n10];
        Format[][] formatArray = new Format[n10][];
        int n11 = DashMediaPeriod.identifyEmbeddedTracks(n10, list, nArray, blArray, formatArray) + n10;
        int n12 = list2.size();
        TrackGroup[] trackGroupArray = new TrackGroup[n11 += n12];
        DashMediaPeriod$TrackGroupInfo[] dashMediaPeriod$TrackGroupInfoArray = new DashMediaPeriod$TrackGroupInfo[n11];
        int n13 = DashMediaPeriod.buildPrimaryAndEmbeddedTrackGroupInfos((DrmSessionManager)object, list, nArray, n10, blArray, formatArray, trackGroupArray, dashMediaPeriod$TrackGroupInfoArray);
        DashMediaPeriod.buildManifestEventTrackGroupInfos(list2, trackGroupArray, dashMediaPeriod$TrackGroupInfoArray, n13);
        object = new TrackGroupArray(trackGroupArray);
        return Pair.create((Object)object, (Object)dashMediaPeriod$TrackGroupInfoArray);
    }

    private static Descriptor findAdaptationSetSwitchingProperty(List list) {
        return DashMediaPeriod.findDescriptor(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static Descriptor findDescriptor(List list, String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Descriptor descriptor = (Descriptor)list.get(i10);
            String string3 = descriptor.schemeIdUri;
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return descriptor;
        }
        return null;
    }

    private static Descriptor findTrickPlayProperty(List list) {
        return DashMediaPeriod.findDescriptor(list, "http://dashif.org/guidelines/trickmode");
    }

    private static Format[] getClosedCaptionTrackFormats(List object, int[] object2) {
        int n10 = ((int[])object2).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12 = object2[i10];
            AdaptationSet adaptationSet = (AdaptationSet)object.get(n12);
            List list = ((AdaptationSet)object.get((int)n12)).accessibilityDescriptors;
            for (int i11 = 0; i11 < (n11 = list.size()); ++i11) {
                Descriptor descriptor = (Descriptor)list.get(i11);
                String string2 = descriptor.schemeIdUri;
                String string3 = "urn:scte:dash:cc:cea-608:2015";
                boolean bl2 = string3.equals(string2);
                int n13 = 18;
                if (bl2) {
                    object = new Format$Builder();
                    object = ((Format$Builder)object).setSampleMimeType("application/cea-608");
                    int n14 = adaptationSet.id;
                    StringBuilder stringBuilder = new StringBuilder(n13);
                    stringBuilder.append(n14);
                    stringBuilder.append(":cea608");
                    object2 = stringBuilder.toString();
                    object = ((Format$Builder)object).setId((String)object2).build();
                    object2 = CEA608_SERVICE_DESCRIPTOR_REGEX;
                    return DashMediaPeriod.parseClosedCaptionDescriptor(descriptor, (Pattern)object2, (Format)object);
                }
                String string4 = "urn:scte:dash:cc:cea-708:2015";
                string2 = descriptor.schemeIdUri;
                bl2 = string4.equals(string2);
                if (!bl2) continue;
                object = new Format$Builder();
                object = ((Format$Builder)object).setSampleMimeType("application/cea-708");
                int n15 = adaptationSet.id;
                StringBuilder stringBuilder = new StringBuilder(n13);
                stringBuilder.append(n15);
                stringBuilder.append(":cea708");
                object2 = stringBuilder.toString();
                object = ((Format$Builder)object).setId((String)object2).build();
                object2 = CEA708_SERVICE_DESCRIPTOR_REGEX;
                return DashMediaPeriod.parseClosedCaptionDescriptor(descriptor, (Pattern)object2, (Format)object);
            }
        }
        return new Format[0];
    }

    private static int[][] getGroupedAdaptationSetIndices(List list) {
        Object object;
        String[] stringArray;
        int n10;
        int n11 = list.size();
        Object object2 = new SparseIntArray(n11);
        ArrayList<ArrayList<Object>> arrayList = new ArrayList<ArrayList<Object>>(n11);
        SparseArray sparseArray = new SparseArray(n11);
        int n12 = 0;
        for (n10 = 0; n10 < n11; ++n10) {
            int n13 = ((AdaptationSet)list.get((int)n10)).id;
            object2.put(n13, n10);
            stringArray = new ArrayList();
            object = n10;
            stringArray.add(object);
            arrayList.add((ArrayList<Object>)stringArray);
            sparseArray.put(n10, stringArray);
        }
        for (n10 = 0; n10 < n11; ++n10) {
            int n14;
            int n15;
            block10: {
                block9: {
                    stringArray = (AdaptationSet)list.get(n10);
                    object = DashMediaPeriod.findTrickPlayProperty(stringArray.essentialProperties);
                    if (object == null) {
                        object = DashMediaPeriod.findTrickPlayProperty(stringArray.supplementalProperties);
                    }
                    n15 = -1;
                    if (object == null) break block9;
                    object = ((Descriptor)object).value;
                    n14 = Integer.parseInt((String)object);
                    if ((n14 = object2.get(n14, n15)) != n15) break block10;
                }
                n14 = n10;
            }
            if (n14 == n10 && (stringArray = DashMediaPeriod.findAdaptationSetSwitchingProperty(stringArray.supplementalProperties)) != null) {
                stringArray = stringArray.value;
                String string2 = ",";
                for (String string3 : Util.split((String)stringArray, string2)) {
                    int n16 = Integer.parseInt(string3);
                    if ((n16 = object2.get(n16, n15)) == n15) continue;
                    n14 = Math.min(n14, n16);
                }
            }
            if (n14 == n10) continue;
            stringArray = (List)sparseArray.get(n10);
            object = (List)sparseArray.get(n14);
            object.addAll(stringArray);
            sparseArray.put(n10, object);
            arrayList.remove(stringArray);
        }
        int n17 = arrayList.size();
        int[][] nArrayArray = new int[n17][];
        while (n12 < n17) {
            object2 = Ints.toArray((Collection)arrayList.get(n12));
            nArrayArray[n12] = (int[])object2;
            object2 = nArrayArray[n12];
            Arrays.sort((int[])object2);
            ++n12;
        }
        return nArrayArray;
    }

    private int getPrimaryStreamIndex(int n10, int[] nArray) {
        int n11;
        int n12 = -1;
        if ((n10 = nArray[n10]) == n12) {
            return n12;
        }
        DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo = this.trackGroupInfos[n10];
        n10 = dashMediaPeriod$TrackGroupInfo.primaryTrackGroupIndex;
        for (int i10 = 0; i10 < (n11 = nArray.length); ++i10) {
            n11 = nArray[i10];
            if (n11 != n10) continue;
            DashMediaPeriod$TrackGroupInfo[] dashMediaPeriod$TrackGroupInfoArray = this.trackGroupInfos;
            DashMediaPeriod$TrackGroupInfo dashMediaPeriod$TrackGroupInfo2 = dashMediaPeriod$TrackGroupInfoArray[n11];
            n11 = dashMediaPeriod$TrackGroupInfo2.trackGroupCategory;
            if (n11 != 0) continue;
            return i10;
        }
        return n12;
    }

    private int[] getStreamIndexToTrackGroupIndex(ExoTrackSelection[] exoTrackSelectionArray) {
        int n10;
        int n11 = exoTrackSelectionArray.length;
        int[] nArray = new int[n11];
        for (int i10 = 0; i10 < (n10 = exoTrackSelectionArray.length); ++i10) {
            Object object = exoTrackSelectionArray[i10];
            if (object != null) {
                object = this.trackGroups;
                TrackGroup trackGroup = exoTrackSelectionArray[i10].getTrackGroup();
                nArray[i10] = n10 = ((TrackGroupArray)object).indexOf(trackGroup);
                continue;
            }
            nArray[i10] = n10 = -1;
        }
        return nArray;
    }

    private static boolean hasEventMessageTrack(List list, int[] nArray) {
        for (int n10 : nArray) {
            int n11;
            List list2 = ((AdaptationSet)list.get((int)n10)).representations;
            for (int i10 = 0; i10 < (n11 = list2.size()); ++i10) {
                List list3 = ((Representation)list2.get((int)i10)).inbandEventStreams;
                n11 = (int)(list3.isEmpty() ? 1 : 0);
                if (n11 != 0) continue;
                return true;
            }
        }
        return false;
    }

    private static int identifyEmbeddedTracks(int n10, List list, int[][] nArray, boolean[] blArray, Format[][] formatArray) {
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object[] objectArray = nArray[i10];
            int n12 = DashMediaPeriod.hasEventMessageTrack(list, objectArray);
            if (n12 != 0) {
                blArray[i10] = n12 = 1;
                ++n11;
            }
            objectArray = nArray[i10];
            objectArray = DashMediaPeriod.getClosedCaptionTrackFormats(list, objectArray);
            formatArray[i10] = (Format[])objectArray;
            objectArray = formatArray[i10];
            n12 = objectArray.length;
            if (n12 == 0) continue;
            ++n11;
        }
        return n11;
    }

    private static ChunkSampleStream[] newSampleStreamArray(int n10) {
        return new ChunkSampleStream[n10];
    }

    private static Format[] parseClosedCaptionDescriptor(Descriptor objectArray, Pattern pattern, Format format) {
        int n10;
        objectArray = objectArray.value;
        int n11 = 1;
        if (objectArray == null) {
            objectArray = new Format[n11];
            objectArray[0] = format;
            return objectArray;
        }
        objectArray = Util.split((String)objectArray, ";");
        int n12 = ((Object[])objectArray).length;
        Format[] formatArray = new Format[n12];
        for (int i10 = 0; i10 < (n10 = ((Object[])objectArray).length); ++i10) {
            Object object = objectArray[i10];
            int n13 = ((Matcher)(object = pattern.matcher((CharSequence)object))).matches();
            if (n13 == 0) {
                objectArray = new Format[n11];
                objectArray[0] = format;
                return objectArray;
            }
            n13 = Integer.parseInt(((Matcher)object).group(n11));
            Format$Builder format$Builder = format.buildUpon();
            String string2 = format.id;
            String string3 = String.valueOf(string2);
            int n14 = string3.length() + 12;
            StringBuilder stringBuilder = new StringBuilder(n14);
            stringBuilder.append(string2);
            stringBuilder.append(":");
            stringBuilder.append(n13);
            string2 = stringBuilder.toString();
            format$Builder = format$Builder.setId(string2);
            Format$Builder format$Builder2 = format$Builder.setAccessibilityChannel(n13);
            int n15 = 2;
            object = ((Matcher)object).group(n15);
            formatArray[i10] = object = format$Builder2.setLanguage((String)object).build();
        }
        return formatArray;
    }

    private void releaseDisabledStreams(ExoTrackSelection[] exoTrackSelectionArray, boolean[] blArray, SampleStream[] sampleStreamArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = exoTrackSelectionArray.length); ++i10) {
            Object object = exoTrackSelectionArray[i10];
            if (object != null && (n10 = blArray[i10]) != 0) continue;
            object = sampleStreamArray[i10];
            n10 = object instanceof ChunkSampleStream;
            if (n10 != 0) {
                object = (ChunkSampleStream)sampleStreamArray[i10];
                ((ChunkSampleStream)object).release(this);
            } else {
                object = sampleStreamArray[i10];
                n10 = object instanceof ChunkSampleStream$EmbeddedSampleStream;
                if (n10 != 0) {
                    object = (ChunkSampleStream$EmbeddedSampleStream)sampleStreamArray[i10];
                    ((ChunkSampleStream$EmbeddedSampleStream)object).release();
                }
            }
            n10 = 0;
            object = null;
            sampleStreamArray[i10] = null;
        }
    }

    private void releaseOrphanEmbeddedStreams(ExoTrackSelection[] exoTrackSelectionArray, SampleStream[] sampleStreamArray, int[] nArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = exoTrackSelectionArray.length); ++i10) {
            int n11;
            SampleStream sampleStream = sampleStreamArray[i10];
            n10 = sampleStream instanceof EmptySampleStream;
            if (n10 == 0 && (n10 = (sampleStream = sampleStreamArray[i10]) instanceof ChunkSampleStream$EmbeddedSampleStream) == 0) continue;
            n10 = this.getPrimaryStreamIndex(i10, nArray);
            if (n10 == (n11 = -1)) {
                sampleStream = sampleStreamArray[i10];
                n10 = sampleStream instanceof EmptySampleStream;
            } else {
                SampleStream sampleStream2 = sampleStreamArray[i10];
                n11 = sampleStream2 instanceof ChunkSampleStream$EmbeddedSampleStream;
                if (n11 != 0 && (sampleStream2 = ((ChunkSampleStream$EmbeddedSampleStream)sampleStreamArray[i10]).parent) == (sampleStream = sampleStreamArray[n10])) {
                    n10 = 1;
                } else {
                    n10 = 0;
                    sampleStream = null;
                }
            }
            if (n10 != 0) continue;
            sampleStream = sampleStreamArray[i10];
            n10 = sampleStream instanceof ChunkSampleStream$EmbeddedSampleStream;
            if (n10 != 0) {
                sampleStream = (ChunkSampleStream$EmbeddedSampleStream)sampleStreamArray[i10];
                ((ChunkSampleStream$EmbeddedSampleStream)sampleStream).release();
            }
            n10 = 0;
            sampleStream = null;
            sampleStreamArray[i10] = null;
        }
    }

    private void selectNewStreams(ExoTrackSelection[] exoTrackSelectionArray, SampleStream[] sampleStreamArray, boolean[] object, long l10, int[] nArray) {
        int n10;
        int n11;
        int n12;
        int n13 = 0;
        int n14 = 0;
        Object object2 = null;
        while (true) {
            n12 = exoTrackSelectionArray.length;
            n11 = 1;
            if (n14 >= n12) break;
            Object object3 = exoTrackSelectionArray[n14];
            if (object3 != null) {
                Object object4;
                Object object5 = sampleStreamArray[n14];
                if (object5 == null) {
                    object[n14] = n11;
                    n11 = nArray[n14];
                    object5 = this.trackGroupInfos;
                    object4 = object5[n11];
                    int n15 = ((DashMediaPeriod$TrackGroupInfo)object4).trackGroupCategory;
                    if (!n15) {
                        sampleStreamArray[n14] = object3 = this.buildSampleStream((DashMediaPeriod$TrackGroupInfo)object4, (ExoTrackSelection)object3, l10);
                    } else {
                        int n16 = 2;
                        if (n15 == n16) {
                            object5 = this.eventStreams;
                            n11 = ((DashMediaPeriod$TrackGroupInfo)object4).eventStreamGroupIndex;
                            object4 = (EventStream)object5.get(n11);
                            object3 = object3.getTrackGroup().getFormat(0);
                            DashManifest dashManifest = this.manifest;
                            n16 = (int)(dashManifest.dynamic ? 1 : 0);
                            sampleStreamArray[n14] = object5 = new EventSampleStream((EventStream)object4, (Format)object3, n16 != 0);
                        }
                    }
                } else {
                    object4 = sampleStreamArray[n14];
                    n11 = object4 instanceof ChunkSampleStream;
                    if (n11 != 0) {
                        object4 = (DashChunkSource)((ChunkSampleStream)sampleStreamArray[n14]).getChunkSource();
                        object4.updateTrackSelection((ExoTrackSelection)object3);
                    }
                }
            }
            ++n14;
        }
        while (n13 < (n10 = exoTrackSelectionArray.length)) {
            object = sampleStreamArray[n13];
            if (object == null && (object = (Object)exoTrackSelectionArray[n13]) != null) {
                n10 = nArray[n13];
                object2 = this.trackGroupInfos;
                object = object2[n10];
                n14 = object.trackGroupCategory;
                if (n14 == n11) {
                    n14 = this.getPrimaryStreamIndex(n13, nArray);
                    if (n14 == (n12 = -1)) {
                        object = new EmptySampleStream;
                        object();
                        sampleStreamArray[n13] = object;
                    } else {
                        object2 = (ChunkSampleStream)sampleStreamArray[n14];
                        n10 = object.trackType;
                        object = ((ChunkSampleStream)object2).selectEmbeddedTrack(l10, n10);
                        sampleStreamArray[n13] = object;
                    }
                }
            }
            ++n13;
        }
    }

    public boolean continueLoading(long l10) {
        return this.compositeSequenceableLoader.continueLoading(l10);
    }

    public void discardBuffer(long l10, boolean bl2) {
        for (ChunkSampleStream chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.discardBuffer(l10, bl2);
        }
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        for (ChunkSampleStream chunkSampleStream : this.sampleStreams) {
            int n10 = chunkSampleStream.primaryTrackType;
            int n11 = 2;
            if (n10 != n11) continue;
            return chunkSampleStream.getAdjustedSeekPositionUs(l10, seekParameters);
        }
        return l10;
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public List getStreamKeys(List object) {
        int n10;
        Object object2 = this.manifest;
        int n11 = this.periodIndex;
        object2 = object2.getPeriod((int)n11).adaptationSets;
        ArrayList<StreamKey> arrayList = new ArrayList<StreamKey>();
        object = object.iterator();
        while ((n10 = object.hasNext()) != false) {
            int n12;
            int n13;
            Object object3 = (ExoTrackSelection)object.next();
            Object object4 = this.trackGroups;
            DashMediaPeriod$TrackGroupInfo[] dashMediaPeriod$TrackGroupInfoArray = object3.getTrackGroup();
            int n14 = ((TrackGroupArray)object4).indexOf((TrackGroup)dashMediaPeriod$TrackGroupInfoArray);
            dashMediaPeriod$TrackGroupInfoArray = this.trackGroupInfos;
            object4 = dashMediaPeriod$TrackGroupInfoArray[n14];
            int n15 = ((DashMediaPeriod$TrackGroupInfo)object4).trackGroupCategory;
            if (n15 != 0) continue;
            object4 = ((DashMediaPeriod$TrackGroupInfo)object4).adaptationSetIndices;
            n15 = object3.length();
            int[] nArray = new int[n15];
            int n16 = 0;
            for (n13 = 0; n13 < (n12 = object3.length()); ++n13) {
                nArray[n13] = n12 = object3.getIndexInTrackGroup(n13);
            }
            Arrays.sort(nArray);
            n10 = object4[0];
            object3 = ((AdaptationSet)object2.get((int)n10)).representations;
            n10 = object3.size();
            n13 = 0;
            n12 = 0;
            while (n16 < n15) {
                int n17;
                int n18 = nArray[n16];
                while (n18 >= (n17 = n12 + n10)) {
                    n10 = object4[++n13];
                    object3 = ((AdaptationSet)object2.get((int)n10)).representations;
                    n10 = object3.size();
                    n12 = n17;
                }
                int n19 = this.periodIndex;
                Object object5 = object4[n13];
                StreamKey streamKey = new StreamKey(n19, (int)object5, n18 -= n12);
                arrayList.add(streamKey);
                ++n16;
            }
        }
        return arrayList;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public void onContinueLoadingRequested(ChunkSampleStream chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSampleStreamReleased(ChunkSampleStream object) {
        synchronized (this) {
            IdentityHashMap identityHashMap = this.trackEmsgHandlerBySampleStream;
            object = identityHashMap.remove(object);
            object = (PlayerEmsgHandler$PlayerTrackEmsgHandler)object;
            if (object != null) {
                ((PlayerEmsgHandler$PlayerTrackEmsgHandler)object).release();
            }
            return;
        }
    }

    public void prepare(MediaPeriod$Callback mediaPeriod$Callback, long l10) {
        this.callback = mediaPeriod$Callback;
        mediaPeriod$Callback.onPrepared(this);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long l10) {
        this.compositeSequenceableLoader.reevaluateBuffer(l10);
    }

    public void release() {
        this.playerEmsgHandler.release();
        for (ChunkSampleStream chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.release(this);
        }
        this.callback = null;
    }

    public long seekToUs(long l10) {
        SampleStream[] sampleStreamArray = this.sampleStreams;
        int n10 = sampleStreamArray.length;
        int n11 = 0;
        SampleStream sampleStream = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            ChunkSampleStream chunkSampleStream = sampleStreamArray[i10];
            chunkSampleStream.seekToUs(l10);
        }
        sampleStreamArray = this.eventSampleStreams;
        n10 = sampleStreamArray.length;
        while (n11 < n10) {
            sampleStream = sampleStreamArray[n11];
            ((EventSampleStream)sampleStream).seekToUs(l10);
            ++n11;
        }
        return l10;
    }

    public long selectTracks(ExoTrackSelection[] object, boolean[] object2, SampleStream[] sampleStreamArray, boolean[] blArray, long l10) {
        int[] nArray = this.getStreamIndexToTrackGroupIndex((ExoTrackSelection[])object);
        this.releaseDisabledStreams((ExoTrackSelection[])object, (boolean[])object2, sampleStreamArray);
        this.releaseOrphanEmbeddedStreams((ExoTrackSelection[])object, sampleStreamArray, nArray);
        Object object32 = object;
        this.selectNewStreams((ExoTrackSelection[])object, sampleStreamArray, blArray, l10, nArray);
        object = new ArrayList();
        object2 = new ArrayList();
        for (SampleStream sampleStream : sampleStreamArray) {
            boolean bl2 = sampleStream instanceof ChunkSampleStream;
            if (bl2) {
                ChunkSampleStream chunkSampleStream = (ChunkSampleStream)sampleStream;
                ((ArrayList)object).add(chunkSampleStream);
                continue;
            }
            bl2 = sampleStream instanceof EventSampleStream;
            if (!bl2) continue;
            EventSampleStream eventSampleStream = (EventSampleStream)sampleStream;
            ((ArrayList)object2).add(eventSampleStream);
        }
        sampleStreamArray = DashMediaPeriod.newSampleStreamArray(((ArrayList)object).size());
        this.sampleStreams = sampleStreamArray;
        ((ArrayList)object).toArray(sampleStreamArray);
        object = new EventSampleStream[((ArrayList)object2).size()];
        this.eventSampleStreams = object;
        ((ArrayList)object2).toArray((T[])object);
        object = this.compositeSequenceableLoaderFactory;
        object2 = this.sampleStreams;
        this.compositeSequenceableLoader = object = object.createCompositeSequenceableLoader((SequenceableLoader[])object2);
        return l10;
    }

    public void updateManifest(DashManifest dashManifest, int n10) {
        this.manifest = dashManifest;
        this.periodIndex = n10;
        this.playerEmsgHandler.updateManifest(dashManifest);
        Object object = this.sampleStreams;
        if (object != null) {
            int n11 = ((ChunkSampleStream[])object).length;
            for (int i10 = 0; i10 < n11; ++i10) {
                DashChunkSource object2 = (DashChunkSource)object[i10].getChunkSource();
                object2.updateManifest(dashManifest, n10);
            }
            object = this.callback;
            object.onContinueLoadingRequested(this);
        }
        object = dashManifest.getPeriod((int)n10).eventStreams;
        this.eventStreams = object;
        block1: for (EventSampleStream eventSampleStream : this.eventSampleStreams) {
            boolean bl2;
            Iterator iterator2 = this.eventStreams.iterator();
            while (bl2 = iterator2.hasNext()) {
                String string2;
                EventStream eventStream = (EventStream)iterator2.next();
                String string3 = eventStream.id();
                int n11 = (int)(string3.equals(string2 = eventSampleStream.eventStreamId()) ? 1 : 0);
                if (n11 == 0) continue;
                int n12 = dashManifest.getPeriodCount();
                n11 = 1;
                boolean bl3 = dashManifest.dynamic;
                if (!bl3 || n10 != (n12 -= n11)) {
                    n11 = 0;
                    string3 = null;
                }
                eventSampleStream.updateEventStream(eventStream, n11 != 0);
                continue block1;
            }
        }
    }
}

