/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MergingMediaPeriod$TimeOffsetMediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

public final class MergingMediaPeriod
implements MediaPeriod,
MediaPeriod$Callback {
    private MediaPeriod$Callback callback;
    private final ArrayList childrenPendingPreparation;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    private final MediaPeriod[] periods;
    private final IdentityHashMap streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory mediaPeriodArray, long[] lArray, MediaPeriod ... mediaPeriodArray2) {
        int n10;
        ArrayList arrayList;
        this.compositeSequenceableLoaderFactory = mediaPeriodArray;
        this.periods = mediaPeriodArray2;
        this.childrenPendingPreparation = arrayList = new ArrayList();
        arrayList = null;
        Object object = new SequenceableLoader[]{};
        mediaPeriodArray = mediaPeriodArray.createCompositeSequenceableLoader((SequenceableLoader)object);
        this.compositeSequenceableLoader = mediaPeriodArray;
        this.streamPeriodIndices = mediaPeriodArray = new IdentityHashMap();
        mediaPeriodArray = new MediaPeriod[]{};
        this.enabledPeriods = mediaPeriodArray;
        for (int i10 = 0; i10 < (n10 = mediaPeriodArray2.length); ++i10) {
            long l10 = lArray[i10];
            long l11 = 0L;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 == 0) continue;
            mediaPeriodArray = this.periods;
            MediaPeriod mediaPeriod = mediaPeriodArray2[i10];
            l11 = lArray[i10];
            super(mediaPeriod, l11);
            mediaPeriodArray[i10] = object;
        }
    }

    public boolean continueLoading(long l10) {
        ArrayList arrayList = this.childrenPendingPreparation;
        int n10 = arrayList.isEmpty();
        if (n10 == 0) {
            arrayList = this.childrenPendingPreparation;
            n10 = arrayList.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                MediaPeriod mediaPeriod = (MediaPeriod)this.childrenPendingPreparation.get(i10);
                mediaPeriod.continueLoading(l10);
            }
            return false;
        }
        return this.compositeSequenceableLoader.continueLoading(l10);
    }

    public void discardBuffer(long l10, boolean bl2) {
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            mediaPeriod.discardBuffer(l10, bl2);
        }
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        Object object = this.enabledPeriods;
        int n10 = ((MediaPeriod[])object).length;
        object = n10 > 0 ? object[0] : this.periods[0];
        return object.getAdjustedSeekPositionUs(l10, seekParameters);
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public MediaPeriod getChildPeriod(int n10) {
        MediaPeriod[] mediaPeriodArray = this.periods;
        MediaPeriod mediaPeriod = mediaPeriodArray[n10];
        boolean bl2 = mediaPeriod instanceof MergingMediaPeriod$TimeOffsetMediaPeriod;
        MediaPeriod mediaPeriod2 = bl2 ? MergingMediaPeriod$TimeOffsetMediaPeriod.access$000((MergingMediaPeriod$TimeOffsetMediaPeriod)mediaPeriodArray[n10]) : mediaPeriodArray[n10];
        return mediaPeriod2;
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray)Assertions.checkNotNull(this.trackGroups);
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() {
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod$Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void onPrepared(MediaPeriod objectArray) {
        int n10;
        TrackGroupArray trackGroupArray;
        int n11;
        Object object = this.childrenPendingPreparation;
        object.remove(objectArray);
        objectArray = this.childrenPendingPreparation;
        boolean bl2 = objectArray.isEmpty();
        if (!bl2) {
            return;
        }
        objectArray = this.periods;
        int n12 = objectArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            trackGroupArray = objectArray[n11].getTrackGroups();
            n10 = trackGroupArray.length;
            n13 += n10;
        }
        objectArray = new TrackGroup[n13];
        object = this.periods;
        n11 = ((MediaPeriod[])object).length;
        n10 = 0;
        trackGroupArray = null;
        for (n13 = 0; n13 < n11; ++n13) {
            TrackGroupArray trackGroupArray2 = object[n13].getTrackGroups();
            int n14 = trackGroupArray2.length;
            for (int i10 = 0; i10 < n14; ++i10) {
                int n15 = n10 + 1;
                TrackGroup trackGroup = trackGroupArray2.get(i10);
                objectArray[n10] = trackGroup;
                n10 = n15;
            }
        }
        this.trackGroups = object = new TrackGroupArray((TrackGroup[])objectArray);
        ((MediaPeriod$Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    public void prepare(MediaPeriod$Callback mediaPeriodArray, long l10) {
        this.callback = mediaPeriodArray;
        mediaPeriodArray = this.childrenPendingPreparation;
        MediaPeriod[] mediaPeriodArray2 = this.periods;
        Collections.addAll(mediaPeriodArray, mediaPeriodArray2);
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.prepare(this, l10);
        }
    }

    public long readDiscontinuity() {
        Object object = this.enabledPeriods;
        int n10 = ((MediaPeriod[])object).length;
        long l10 = -9223372036854775807L;
        long l11 = l10;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l12;
            long l13;
            Object object2;
            MediaPeriod mediaPeriod = object[i10];
            long l14 = mediaPeriod.readDiscontinuity();
            Object object3 = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1);
            String string2 = "Unexpected child seekToUs result.";
            if (object3 != false) {
                object3 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (object3 == false) {
                    MediaPeriod mediaPeriod2;
                    MediaPeriod[] mediaPeriodArray = this.enabledPeriods;
                    int n11 = mediaPeriodArray.length;
                    for (object3 = (Object)0; object3 < n11 && (mediaPeriod2 = mediaPeriodArray[object3]) != mediaPeriod; ++object3) {
                        long l15 = mediaPeriod2.seekToUs(l14);
                        long l16 = l15 - l14;
                        Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object4 == false) {
                            continue;
                        }
                        object = new IllegalStateException(string2);
                        throw object;
                    }
                    l11 = l14;
                    continue;
                }
                object2 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
                if (object2 == false) continue;
                object = new IllegalStateException("Conflicting discontinuities.");
                throw object;
            }
            Object object5 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object5 == false || (object2 = (l13 = (l12 = mediaPeriod.seekToUs(l11)) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) continue;
            object = new IllegalStateException(string2);
            throw object;
        }
        return l11;
    }

    public void reevaluateBuffer(long l10) {
        this.compositeSequenceableLoader.reevaluateBuffer(l10);
    }

    public long seekToUs(long l10) {
        int n10;
        Object object = this.enabledPeriods;
        Object object2 = false;
        Object object3 = null;
        object = object[0];
        l10 = object.seekToUs(l10);
        for (int i10 = 1; i10 < (n10 = ((MediaPeriod[])(object3 = this.enabledPeriods)).length); ++i10) {
            long l11 = (object3 = object3[i10]).seekToUs(l10);
            long l12 = l11 - l10;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object2) {
                continue;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected child seekToUs result.");
            throw illegalStateException;
        }
        return l10;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArray, boolean[] blArray, SampleStream[] sampleStreamArray, boolean[] blArray2, long l10) {
        ArrayList<Object> arrayList;
        int n10;
        Object object;
        int n11;
        int n12;
        SampleStream[] sampleStreamArray2;
        int n13;
        Object object2;
        int n14;
        int n15;
        MergingMediaPeriod mergingMediaPeriod = this;
        Object object3 = exoTrackSelectionArray;
        SampleStream[] sampleStreamArray3 = sampleStreamArray;
        int n16 = exoTrackSelectionArray.length;
        int[] nArray = new int[n16];
        int n17 = exoTrackSelectionArray.length;
        int[] nArray2 = new int[n17];
        IdentityHashMap identityHashMap = null;
        block0: for (n15 = 0; n15 < (n14 = ((ExoTrackSelection[])object3).length); ++n15) {
            Object object4;
            object2 = sampleStreamArray3[n15];
            if (object2 == null) {
                n13 = 0;
                object4 = null;
            } else {
                object2 = mergingMediaPeriod.streamPeriodIndices;
                object4 = sampleStreamArray3[n15];
                object4 = object2 = object2.get(object4);
                object4 = (Integer)object2;
            }
            n14 = -1;
            n13 = object4 == null ? n14 : object4.intValue();
            nArray[n15] = n13;
            nArray2[n15] = n14;
            object4 = object3[n15];
            if (object4 == null) continue;
            object4 = object3[n15].getTrackGroup();
            sampleStreamArray2 = null;
            for (n12 = 0; n12 < (n11 = ((MediaPeriod[])(object = mergingMediaPeriod.periods)).length); ++n12) {
                n10 = ((TrackGroupArray)(object = object[n12].getTrackGroups())).indexOf((TrackGroup)object4);
                if (n10 == n14) continue;
                nArray2[n15] = n12;
                continue block0;
            }
        }
        identityHashMap = mergingMediaPeriod.streamPeriodIndices;
        identityHashMap.clear();
        n15 = ((ExoTrackSelection[])object3).length;
        object2 = new SampleStream[n15];
        n12 = ((ExoTrackSelection[])object3).length;
        sampleStreamArray2 = new SampleStream[n12];
        ExoTrackSelection[] exoTrackSelectionArray2 = new ExoTrackSelection[((ExoTrackSelection[])object3).length];
        object = mergingMediaPeriod.periods;
        n10 = ((MediaPeriod[])object).length;
        Serializable serializable = new Serializable(n10);
        long l11 = l10;
        int n18 = 0;
        while (n18 < (n10 = ((MediaPeriod[])(object = mergingMediaPeriod.periods)).length)) {
            block19: {
                int n19;
                ExoTrackSelection[] exoTrackSelectionArray3;
                Object object5;
                Object object6;
                block18: {
                    long l12;
                    block17: {
                        object = null;
                        for (n10 = 0; n10 < (n11 = ((ExoTrackSelection[])object3).length); ++n10) {
                            n11 = nArray[n10];
                            if (n11 == n18) {
                                object6 = sampleStreamArray3[n10];
                            } else {
                                n11 = 0;
                                object6 = null;
                            }
                            sampleStreamArray2[n10] = object6;
                            n11 = nArray2[n10];
                            if (n11 == n18) {
                                object6 = object3[n10];
                            } else {
                                n11 = 0;
                                object6 = null;
                            }
                            exoTrackSelectionArray2[n10] = object6;
                        }
                        object = mergingMediaPeriod.periods[n18];
                        object6 = exoTrackSelectionArray2;
                        object5 = blArray;
                        n13 = n18;
                        arrayList = serializable;
                        serializable = (Serializable)blArray2;
                        exoTrackSelectionArray3 = exoTrackSelectionArray2;
                        l12 = object.selectTracks(exoTrackSelectionArray2, blArray, sampleStreamArray2, blArray2, l11);
                        if (n18 != 0) break block17;
                        l11 = l12;
                        break block18;
                    }
                    n10 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
                    if (n10 != 0) break block19;
                }
                object = null;
                n11 = 0;
                object6 = null;
                for (n10 = 0; n10 < (n19 = ((Object[])object3).length); ++n10) {
                    n19 = nArray2[n10];
                    n18 = 1;
                    if (n19 == n13) {
                        object6 = (SampleStream)Assertions.checkNotNull(sampleStreamArray2[n10]);
                        object5 = sampleStreamArray2[n10];
                        object2[n10] = object5;
                        object5 = mergingMediaPeriod.streamPeriodIndices;
                        serializable = n13;
                        ((IdentityHashMap)object5).put(object6, serializable);
                        n11 = n18;
                        continue;
                    }
                    n19 = nArray[n10];
                    if (n19 != n13) continue;
                    object5 = sampleStreamArray2[n10];
                    if (object5 != null) {
                        n18 = 0;
                    }
                    Assertions.checkState(n18 != 0);
                }
                if (n11 != 0) {
                    object = mergingMediaPeriod.periods[n13];
                    arrayList.add(object);
                }
                n18 = n13 + 1;
                serializable = arrayList;
                exoTrackSelectionArray2 = exoTrackSelectionArray3;
                continue;
            }
            object3 = new IllegalStateException("Children enabled at different positions.");
            throw object3;
        }
        arrayList = serializable;
        System.arraycopy(object2, 0, sampleStreamArray3, 0, n15);
        object3 = new MediaPeriod[]{};
        object3 = (MediaPeriod[])serializable.toArray((T[])object3);
        mergingMediaPeriod.enabledPeriods = object3;
        mergingMediaPeriod.compositeSequenceableLoader = object3 = mergingMediaPeriod.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader((SequenceableLoader[])object3);
        return l11;
    }
}

