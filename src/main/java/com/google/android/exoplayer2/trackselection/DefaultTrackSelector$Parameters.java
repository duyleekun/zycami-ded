/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 */
package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters$1;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DefaultTrackSelector$Parameters
extends TrackSelectionParameters {
    public static final Parcelable.Creator CREATOR;
    public static final DefaultTrackSelector$Parameters DEFAULT_WITHOUT_CONTEXT;
    public final boolean allowAudioMixedChannelCountAdaptiveness;
    public final boolean allowAudioMixedMimeTypeAdaptiveness;
    public final boolean allowAudioMixedSampleRateAdaptiveness;
    public final boolean allowMultipleAdaptiveSelections;
    public final boolean allowVideoMixedMimeTypeAdaptiveness;
    public final boolean allowVideoNonSeamlessAdaptiveness;
    public final boolean exceedAudioConstraintsIfNecessary;
    public final boolean exceedRendererCapabilitiesIfNecessary;
    public final boolean exceedVideoConstraintsIfNecessary;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final ImmutableList preferredAudioMimeTypes;
    public final ImmutableList preferredVideoMimeTypes;
    private final SparseBooleanArray rendererDisabledFlags;
    private final SparseArray selectionOverrides;
    public final boolean tunnelingEnabled;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    static {
        Object object = new DefaultTrackSelector$ParametersBuilder();
        DEFAULT_WITHOUT_CONTEXT = ((DefaultTrackSelector$ParametersBuilder)object).build();
        object = new DefaultTrackSelector$Parameters$1();
        CREATOR = object;
    }

    public DefaultTrackSelector$Parameters(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, boolean bl2, boolean bl3, boolean bl4, int n18, int n19, boolean bl5, ImmutableList immutableList, ImmutableList immutableList2, int n20, int n21, int n22, boolean bl6, boolean bl7, boolean bl8, boolean bl9, ImmutableList immutableList3, ImmutableList immutableList4, int n23, boolean bl10, int n24, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, SparseArray sparseArray, SparseBooleanArray sparseBooleanArray) {
        super(immutableList2, n20, immutableList4, n23, bl10, n24);
        this.maxVideoWidth = n10;
        this.maxVideoHeight = n11;
        this.maxVideoFrameRate = n12;
        this.maxVideoBitrate = n13;
        this.minVideoWidth = n14;
        this.minVideoHeight = n15;
        this.minVideoFrameRate = n16;
        this.minVideoBitrate = n17;
        this.exceedVideoConstraintsIfNecessary = bl2;
        this.allowVideoMixedMimeTypeAdaptiveness = bl3;
        this.allowVideoNonSeamlessAdaptiveness = bl4;
        this.viewportWidth = n18;
        this.viewportHeight = n19;
        this.viewportOrientationMayChange = bl5;
        this.preferredVideoMimeTypes = immutableList;
        this.maxAudioChannelCount = n21;
        this.maxAudioBitrate = n22;
        this.exceedAudioConstraintsIfNecessary = bl6;
        this.allowAudioMixedMimeTypeAdaptiveness = bl7;
        this.allowAudioMixedSampleRateAdaptiveness = bl8;
        this.allowAudioMixedChannelCountAdaptiveness = bl9;
        this.preferredAudioMimeTypes = immutableList3;
        this.forceLowestBitrate = bl11;
        this.forceHighestSupportedBitrate = bl12;
        this.exceedRendererCapabilitiesIfNecessary = bl13;
        this.tunnelingEnabled = bl14;
        this.allowMultipleAdaptiveSelections = bl15;
        this.selectionOverrides = sparseArray;
        this.rendererDisabledFlags = sparseBooleanArray;
    }

    public DefaultTrackSelector$Parameters(Parcel parcel) {
        super(parcel);
        int n10;
        this.maxVideoWidth = n10 = parcel.readInt();
        this.maxVideoHeight = n10 = parcel.readInt();
        this.maxVideoFrameRate = n10 = parcel.readInt();
        this.maxVideoBitrate = n10 = parcel.readInt();
        this.minVideoWidth = n10 = parcel.readInt();
        this.minVideoHeight = n10 = parcel.readInt();
        this.minVideoFrameRate = n10 = parcel.readInt();
        this.minVideoBitrate = n10 = parcel.readInt();
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.exceedVideoConstraintsIfNecessary = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.allowVideoMixedMimeTypeAdaptiveness = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.allowVideoNonSeamlessAdaptiveness = n10;
        this.viewportWidth = n10 = parcel.readInt();
        this.viewportHeight = n10 = parcel.readInt();
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.viewportOrientationMayChange = n10;
        SparseArray sparseArray = new ArrayList();
        parcel.readList(sparseArray, null);
        sparseArray = ImmutableList.copyOf(sparseArray);
        this.preferredVideoMimeTypes = sparseArray;
        this.maxAudioChannelCount = n10 = parcel.readInt();
        this.maxAudioBitrate = n10 = parcel.readInt();
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.exceedAudioConstraintsIfNecessary = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.allowAudioMixedMimeTypeAdaptiveness = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.allowAudioMixedSampleRateAdaptiveness = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.allowAudioMixedChannelCountAdaptiveness = n10;
        sparseArray = new ArrayList();
        parcel.readList(sparseArray, null);
        sparseArray = ImmutableList.copyOf(sparseArray);
        this.preferredAudioMimeTypes = sparseArray;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.forceLowestBitrate = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.forceHighestSupportedBitrate = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.exceedRendererCapabilitiesIfNecessary = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.tunnelingEnabled = n10;
        n10 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.allowMultipleAdaptiveSelections = n10;
        this.selectionOverrides = sparseArray = DefaultTrackSelector$Parameters.readSelectionOverrides(parcel);
        parcel = (SparseBooleanArray)Util.castNonNull(parcel.readSparseBooleanArray());
        this.rendererDisabledFlags = parcel;
    }

    public static /* synthetic */ SparseArray access$000(DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        return defaultTrackSelector$Parameters.selectionOverrides;
    }

    public static /* synthetic */ SparseBooleanArray access$100(DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        return defaultTrackSelector$Parameters.rendererDisabledFlags;
    }

    private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int n10 = sparseBooleanArray.size();
        int n11 = sparseBooleanArray2.size();
        if (n11 != n10) {
            return false;
        }
        for (n11 = 0; n11 < n10; ++n11) {
            int n12 = sparseBooleanArray.keyAt(n11);
            if ((n12 = sparseBooleanArray2.indexOfKey(n12)) >= 0) continue;
            return false;
        }
        return true;
    }

    private static boolean areSelectionOverridesEqual(SparseArray sparseArray, SparseArray sparseArray2) {
        int n10 = sparseArray.size();
        int n11 = sparseArray2.size();
        if (n11 != n10) {
            return false;
        }
        for (n11 = 0; n11 < n10; ++n11) {
            Map map;
            Map map2;
            int n12 = sparseArray.keyAt(n11);
            if ((n12 = sparseArray2.indexOfKey(n12)) >= 0 && (n12 = (int)(DefaultTrackSelector$Parameters.areSelectionOverridesEqual(map2 = (Map)sparseArray.valueAt(n11), map = (Map)sparseArray2.valueAt(n12)) ? 1 : 0)) != 0) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static boolean areSelectionOverridesEqual(Map object, Map map) {
        int n10 = object.size();
        int n11 = map.size();
        if (n11 != n10) {
            return false;
        }
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            TrackGroupArray trackGroupArray = (TrackGroupArray)entry.getKey();
            boolean bl2 = map.containsKey(trackGroupArray);
            if (bl2 && (n10 = (int)(Util.areEqual(entry = entry.getValue(), trackGroupArray = map.get(trackGroupArray)) ? 1 : 0)) != 0) continue;
            return false;
        }
        return true;
    }

    public static DefaultTrackSelector$Parameters getDefaults(Context context) {
        DefaultTrackSelector$ParametersBuilder defaultTrackSelector$ParametersBuilder = new DefaultTrackSelector$ParametersBuilder(context);
        return defaultTrackSelector$ParametersBuilder.build();
    }

    private static SparseArray readSelectionOverrides(Parcel parcel) {
        int n10 = parcel.readInt();
        SparseArray sparseArray = new SparseArray(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = parcel.readInt();
            int n12 = parcel.readInt();
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>(n12);
            for (int i11 = 0; i11 < n12; ++i11) {
                Object object = TrackGroupArray.class.getClassLoader();
                object = (TrackGroupArray)Assertions.checkNotNull((TrackGroupArray)parcel.readParcelable((ClassLoader)object));
                Object object2 = DefaultTrackSelector$SelectionOverride.class.getClassLoader();
                object2 = (DefaultTrackSelector$SelectionOverride)parcel.readParcelable((ClassLoader)object2);
                hashMap.put(object, object2);
            }
            sparseArray.put(n11, hashMap);
        }
        return sparseArray;
    }

    private static void writeSelectionOverridesToParcel(Parcel parcel, SparseArray sparseArray) {
        int n10 = sparseArray.size();
        parcel.writeInt(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            int n11 = sparseArray.keyAt(i10);
            Object object = (Map)sparseArray.valueAt(i10);
            int n12 = object.size();
            parcel.writeInt(n11);
            parcel.writeInt(n12);
            Iterator iterator2 = object.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
                Parcelable parcelable = (Parcelable)object.getKey();
                parcel.writeParcelable(parcelable, 0);
                object = (Parcelable)object.getValue();
                parcel.writeParcelable((Parcelable)object, 0);
            }
        }
    }

    public DefaultTrackSelector$ParametersBuilder buildUpon() {
        DefaultTrackSelector$ParametersBuilder defaultTrackSelector$ParametersBuilder = new DefaultTrackSelector$ParametersBuilder(this, null);
        return defaultTrackSelector$ParametersBuilder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        SparseBooleanArray sparseBooleanArray;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = DefaultTrackSelector$Parameters.class) == (sparseBooleanArray = object.getClass())) {
            int n10;
            object2 = object;
            object2 = (DefaultTrackSelector$Parameters)object;
            int n11 = super.equals(object);
            if (n11 == 0 || (n11 = this.maxVideoWidth) != (n10 = ((DefaultTrackSelector$Parameters)object2).maxVideoWidth) || (n11 = this.maxVideoHeight) != (n10 = ((DefaultTrackSelector$Parameters)object2).maxVideoHeight) || (n11 = this.maxVideoFrameRate) != (n10 = ((DefaultTrackSelector$Parameters)object2).maxVideoFrameRate) || (n11 = this.maxVideoBitrate) != (n10 = ((DefaultTrackSelector$Parameters)object2).maxVideoBitrate) || (n11 = this.minVideoWidth) != (n10 = ((DefaultTrackSelector$Parameters)object2).minVideoWidth) || (n11 = this.minVideoHeight) != (n10 = ((DefaultTrackSelector$Parameters)object2).minVideoHeight) || (n11 = this.minVideoFrameRate) != (n10 = ((DefaultTrackSelector$Parameters)object2).minVideoFrameRate) || (n11 = this.minVideoBitrate) != (n10 = ((DefaultTrackSelector$Parameters)object2).minVideoBitrate) || (n11 = (int)(this.exceedVideoConstraintsIfNecessary ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).exceedVideoConstraintsIfNecessary ? 1 : 0)) || (n11 = (int)(this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) || (n11 = (int)(this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).allowVideoNonSeamlessAdaptiveness ? 1 : 0)) || (n11 = (int)(this.viewportOrientationMayChange ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).viewportOrientationMayChange ? 1 : 0)) || (n11 = this.viewportWidth) != (n10 = ((DefaultTrackSelector$Parameters)object2).viewportWidth) || (n11 = this.viewportHeight) != (n10 = ((DefaultTrackSelector$Parameters)object2).viewportHeight) || (n11 = (int)(((ImmutableList)(object = this.preferredVideoMimeTypes)).equals(sparseBooleanArray = ((DefaultTrackSelector$Parameters)object2).preferredVideoMimeTypes) ? 1 : 0)) == 0 || (n11 = this.maxAudioChannelCount) != (n10 = ((DefaultTrackSelector$Parameters)object2).maxAudioChannelCount) || (n11 = this.maxAudioBitrate) != (n10 = ((DefaultTrackSelector$Parameters)object2).maxAudioBitrate) || (n11 = (int)(this.exceedAudioConstraintsIfNecessary ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).exceedAudioConstraintsIfNecessary ? 1 : 0)) || (n11 = (int)(this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) || (n11 = (int)(this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) || (n11 = (int)(this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) || (n11 = (int)(((ImmutableList)(object = this.preferredAudioMimeTypes)).equals(sparseBooleanArray = ((DefaultTrackSelector$Parameters)object2).preferredAudioMimeTypes) ? 1 : 0)) == 0 || (n11 = (int)(this.forceLowestBitrate ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).forceLowestBitrate ? 1 : 0)) || (n11 = (int)(this.forceHighestSupportedBitrate ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).forceHighestSupportedBitrate ? 1 : 0)) || (n11 = (int)(this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).exceedRendererCapabilitiesIfNecessary ? 1 : 0)) || (n11 = (int)(this.tunnelingEnabled ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).tunnelingEnabled ? 1 : 0)) || (n11 = (int)(this.allowMultipleAdaptiveSelections ? 1 : 0)) != (n10 = (int)(((DefaultTrackSelector$Parameters)object2).allowMultipleAdaptiveSelections ? 1 : 0)) || (n11 = (int)(DefaultTrackSelector$Parameters.areRendererDisabledFlagsEqual((SparseBooleanArray)(object = this.rendererDisabledFlags), sparseBooleanArray = ((DefaultTrackSelector$Parameters)object2).rendererDisabledFlags) ? 1 : 0)) == 0 || (n11 = (int)(DefaultTrackSelector$Parameters.areSelectionOverridesEqual((SparseArray)(object = this.selectionOverrides), (SparseArray)(object2 = ((DefaultTrackSelector$Parameters)object2).selectionOverrides)) ? 1 : 0)) == 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public final boolean getRendererDisabled(int n10) {
        return this.rendererDisabledFlags.get(n10);
    }

    public final DefaultTrackSelector$SelectionOverride getSelectionOverride(int n10, TrackGroupArray trackGroupArray) {
        SparseArray sparseArray = this.selectionOverrides;
        Object object = (Map)sparseArray.get(n10);
        if (object != null) {
            object = (DefaultTrackSelector$SelectionOverride)object.get(trackGroupArray);
        } else {
            n10 = 0;
            object = null;
        }
        return object;
    }

    public final boolean hasSelectionOverride(int n10, TrackGroupArray trackGroupArray) {
        SparseArray sparseArray = this.selectionOverrides;
        Map map = (Map)sparseArray.get(n10);
        if (map != null && (n10 = (int)(map.containsKey(trackGroupArray) ? 1 : 0)) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            map = null;
        }
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = super.hashCode() * 31;
        int n11 = this.maxVideoWidth;
        n10 = (n10 + n11) * 31;
        n11 = this.maxVideoHeight;
        n10 = (n10 + n11) * 31;
        n11 = this.maxVideoFrameRate;
        n10 = (n10 + n11) * 31;
        n11 = this.maxVideoBitrate;
        n10 = (n10 + n11) * 31;
        n11 = this.minVideoWidth;
        n10 = (n10 + n11) * 31;
        n11 = this.minVideoHeight;
        n10 = (n10 + n11) * 31;
        n11 = this.minVideoFrameRate;
        n10 = (n10 + n11) * 31;
        n11 = this.minVideoBitrate;
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.exceedVideoConstraintsIfNecessary ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.allowVideoNonSeamlessAdaptiveness ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.viewportOrientationMayChange ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = this.viewportWidth;
        n10 = (n10 + n11) * 31;
        n11 = this.viewportHeight;
        n10 = (n10 + n11) * 31;
        n11 = this.preferredVideoMimeTypes.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.maxAudioChannelCount;
        n10 = (n10 + n11) * 31;
        n11 = this.maxAudioBitrate;
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.exceedAudioConstraintsIfNecessary ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = this.preferredAudioMimeTypes.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.forceLowestBitrate ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.forceHighestSupportedBitrate ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.exceedRendererCapabilitiesIfNecessary ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.tunnelingEnabled ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.allowMultipleAdaptiveSelections ? 1 : 0);
        return n10 + n11;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = this.maxVideoWidth;
        parcel.writeInt(n10);
        n10 = this.maxVideoHeight;
        parcel.writeInt(n10);
        n10 = this.maxVideoFrameRate;
        parcel.writeInt(n10);
        n10 = this.maxVideoBitrate;
        parcel.writeInt(n10);
        n10 = this.minVideoWidth;
        parcel.writeInt(n10);
        n10 = this.minVideoHeight;
        parcel.writeInt(n10);
        n10 = this.minVideoFrameRate;
        parcel.writeInt(n10);
        n10 = this.minVideoBitrate;
        parcel.writeInt(n10);
        n10 = (int)(this.exceedVideoConstraintsIfNecessary ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.allowVideoNonSeamlessAdaptiveness ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = this.viewportWidth;
        parcel.writeInt(n10);
        n10 = this.viewportHeight;
        parcel.writeInt(n10);
        n10 = (int)(this.viewportOrientationMayChange ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        ImmutableList immutableList = this.preferredVideoMimeTypes;
        parcel.writeList((List)immutableList);
        n10 = this.maxAudioChannelCount;
        parcel.writeInt(n10);
        n10 = this.maxAudioBitrate;
        parcel.writeInt(n10);
        n10 = (int)(this.exceedAudioConstraintsIfNecessary ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        immutableList = this.preferredAudioMimeTypes;
        parcel.writeList((List)immutableList);
        n10 = (int)(this.forceLowestBitrate ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.forceHighestSupportedBitrate ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.exceedRendererCapabilitiesIfNecessary ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.tunnelingEnabled ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = (int)(this.allowMultipleAdaptiveSelections ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        immutableList = this.selectionOverrides;
        DefaultTrackSelector$Parameters.writeSelectionOverridesToParcel(parcel, (SparseArray)immutableList);
        immutableList = this.rendererDisabledFlags;
        parcel.writeSparseBooleanArray((SparseBooleanArray)immutableList);
    }
}

