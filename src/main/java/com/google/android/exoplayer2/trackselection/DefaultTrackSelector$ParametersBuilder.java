/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 */
package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$1;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;

public final class DefaultTrackSelector$ParametersBuilder
extends TrackSelectionParameters$Builder {
    private boolean allowAudioMixedChannelCountAdaptiveness;
    private boolean allowAudioMixedMimeTypeAdaptiveness;
    private boolean allowAudioMixedSampleRateAdaptiveness;
    private boolean allowMultipleAdaptiveSelections;
    private boolean allowVideoMixedMimeTypeAdaptiveness;
    private boolean allowVideoNonSeamlessAdaptiveness;
    private boolean exceedAudioConstraintsIfNecessary;
    private boolean exceedRendererCapabilitiesIfNecessary;
    private boolean exceedVideoConstraintsIfNecessary;
    private boolean forceHighestSupportedBitrate;
    private boolean forceLowestBitrate;
    private int maxAudioBitrate;
    private int maxAudioChannelCount;
    private int maxVideoBitrate;
    private int maxVideoFrameRate;
    private int maxVideoHeight;
    private int maxVideoWidth;
    private int minVideoBitrate;
    private int minVideoFrameRate;
    private int minVideoHeight;
    private int minVideoWidth;
    private ImmutableList preferredAudioMimeTypes;
    private ImmutableList preferredVideoMimeTypes;
    private final SparseBooleanArray rendererDisabledFlags;
    private final SparseArray selectionOverrides;
    private boolean tunnelingEnabled;
    private int viewportHeight;
    private boolean viewportOrientationMayChange;
    private int viewportWidth;

    public DefaultTrackSelector$ParametersBuilder() {
        SparseArray sparseArray;
        this.setInitialValuesWithoutContext();
        this.selectionOverrides = sparseArray = new SparseArray();
        this.rendererDisabledFlags = sparseArray;
    }

    public DefaultTrackSelector$ParametersBuilder(Context context) {
        super(context);
        SparseArray sparseArray;
        this.setInitialValuesWithoutContext();
        this.selectionOverrides = sparseArray = new SparseArray();
        super();
        this.rendererDisabledFlags = sparseArray;
        this.setViewportSizeToPhysicalDisplaySize(context, true);
    }

    private DefaultTrackSelector$ParametersBuilder(DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        super(defaultTrackSelector$Parameters);
        ImmutableList immutableList;
        int n10;
        this.maxVideoWidth = n10 = defaultTrackSelector$Parameters.maxVideoWidth;
        this.maxVideoHeight = n10 = defaultTrackSelector$Parameters.maxVideoHeight;
        this.maxVideoFrameRate = n10 = defaultTrackSelector$Parameters.maxVideoFrameRate;
        this.maxVideoBitrate = n10 = defaultTrackSelector$Parameters.maxVideoBitrate;
        this.minVideoWidth = n10 = defaultTrackSelector$Parameters.minVideoWidth;
        this.minVideoHeight = n10 = defaultTrackSelector$Parameters.minVideoHeight;
        this.minVideoFrameRate = n10 = defaultTrackSelector$Parameters.minVideoFrameRate;
        this.minVideoBitrate = n10 = defaultTrackSelector$Parameters.minVideoBitrate;
        n10 = (int)(defaultTrackSelector$Parameters.exceedVideoConstraintsIfNecessary ? 1 : 0);
        this.exceedVideoConstraintsIfNecessary = n10;
        n10 = (int)(defaultTrackSelector$Parameters.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0);
        this.allowVideoMixedMimeTypeAdaptiveness = n10;
        n10 = (int)(defaultTrackSelector$Parameters.allowVideoNonSeamlessAdaptiveness ? 1 : 0);
        this.allowVideoNonSeamlessAdaptiveness = n10;
        this.viewportWidth = n10 = defaultTrackSelector$Parameters.viewportWidth;
        this.viewportHeight = n10 = defaultTrackSelector$Parameters.viewportHeight;
        n10 = (int)(defaultTrackSelector$Parameters.viewportOrientationMayChange ? 1 : 0);
        this.viewportOrientationMayChange = n10;
        this.preferredVideoMimeTypes = immutableList = defaultTrackSelector$Parameters.preferredVideoMimeTypes;
        this.maxAudioChannelCount = n10 = defaultTrackSelector$Parameters.maxAudioChannelCount;
        this.maxAudioBitrate = n10 = defaultTrackSelector$Parameters.maxAudioBitrate;
        n10 = (int)(defaultTrackSelector$Parameters.exceedAudioConstraintsIfNecessary ? 1 : 0);
        this.exceedAudioConstraintsIfNecessary = n10;
        n10 = (int)(defaultTrackSelector$Parameters.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0);
        this.allowAudioMixedMimeTypeAdaptiveness = n10;
        n10 = (int)(defaultTrackSelector$Parameters.allowAudioMixedSampleRateAdaptiveness ? 1 : 0);
        this.allowAudioMixedSampleRateAdaptiveness = n10;
        n10 = (int)(defaultTrackSelector$Parameters.allowAudioMixedChannelCountAdaptiveness ? 1 : 0);
        this.allowAudioMixedChannelCountAdaptiveness = n10;
        this.preferredAudioMimeTypes = immutableList = defaultTrackSelector$Parameters.preferredAudioMimeTypes;
        n10 = (int)(defaultTrackSelector$Parameters.forceLowestBitrate ? 1 : 0);
        this.forceLowestBitrate = n10;
        n10 = (int)(defaultTrackSelector$Parameters.forceHighestSupportedBitrate ? 1 : 0);
        this.forceHighestSupportedBitrate = n10;
        n10 = (int)(defaultTrackSelector$Parameters.exceedRendererCapabilitiesIfNecessary ? 1 : 0);
        this.exceedRendererCapabilitiesIfNecessary = n10;
        n10 = (int)(defaultTrackSelector$Parameters.tunnelingEnabled ? 1 : 0);
        this.tunnelingEnabled = n10;
        n10 = (int)(defaultTrackSelector$Parameters.allowMultipleAdaptiveSelections ? 1 : 0);
        this.allowMultipleAdaptiveSelections = n10;
        immutableList = DefaultTrackSelector$ParametersBuilder.cloneSelectionOverrides(DefaultTrackSelector$Parameters.access$000(defaultTrackSelector$Parameters));
        this.selectionOverrides = immutableList;
        defaultTrackSelector$Parameters = DefaultTrackSelector$Parameters.access$100(defaultTrackSelector$Parameters).clone();
        this.rendererDisabledFlags = defaultTrackSelector$Parameters;
    }

    public /* synthetic */ DefaultTrackSelector$ParametersBuilder(DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, DefaultTrackSelector$1 defaultTrackSelector$1) {
        this(defaultTrackSelector$Parameters);
    }

    private static SparseArray cloneSelectionOverrides(SparseArray sparseArray) {
        int n10;
        SparseArray sparseArray2 = new SparseArray();
        for (int i10 = 0; i10 < (n10 = sparseArray.size()); ++i10) {
            n10 = sparseArray.keyAt(i10);
            Map map = (Map)sparseArray.valueAt(i10);
            HashMap hashMap = new HashMap(map);
            sparseArray2.put(n10, hashMap);
        }
        return sparseArray2;
    }

    private void setInitialValuesWithoutContext() {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        boolean bl2;
        int n10;
        this.maxVideoWidth = n10 = -1 >>> 1;
        this.maxVideoHeight = n10;
        this.maxVideoFrameRate = n10;
        this.maxVideoBitrate = n10;
        this.exceedVideoConstraintsIfNecessary = bl2 = true;
        this.allowVideoMixedMimeTypeAdaptiveness = false;
        this.allowVideoNonSeamlessAdaptiveness = bl2;
        this.viewportWidth = n10;
        this.viewportHeight = n10;
        this.viewportOrientationMayChange = bl2;
        this.preferredVideoMimeTypes = immutableList2 = ImmutableList.of();
        this.maxAudioChannelCount = n10;
        this.maxAudioBitrate = n10;
        this.exceedAudioConstraintsIfNecessary = bl2;
        this.allowAudioMixedMimeTypeAdaptiveness = false;
        this.allowAudioMixedSampleRateAdaptiveness = false;
        this.allowAudioMixedChannelCountAdaptiveness = false;
        this.preferredAudioMimeTypes = immutableList = ImmutableList.of();
        this.forceLowestBitrate = false;
        this.forceHighestSupportedBitrate = false;
        this.exceedRendererCapabilitiesIfNecessary = bl2;
        this.tunnelingEnabled = false;
        this.allowMultipleAdaptiveSelections = bl2;
    }

    public DefaultTrackSelector$Parameters build() {
        int n10 = this.maxVideoWidth;
        int n11 = this.maxVideoHeight;
        int n12 = this.maxVideoFrameRate;
        int n13 = this.maxVideoBitrate;
        int n14 = this.minVideoWidth;
        int n15 = this.minVideoHeight;
        int n16 = this.minVideoFrameRate;
        int n17 = this.minVideoBitrate;
        boolean bl2 = this.exceedVideoConstraintsIfNecessary;
        boolean bl3 = this.allowVideoMixedMimeTypeAdaptiveness;
        boolean bl4 = this.allowVideoNonSeamlessAdaptiveness;
        int n18 = this.viewportWidth;
        int n19 = this.viewportHeight;
        boolean bl5 = this.viewportOrientationMayChange;
        ImmutableList immutableList = this.preferredVideoMimeTypes;
        ImmutableList immutableList2 = this.preferredAudioLanguages;
        int n20 = this.preferredAudioRoleFlags;
        int n21 = this.maxAudioChannelCount;
        int n22 = this.maxAudioBitrate;
        boolean bl6 = this.exceedAudioConstraintsIfNecessary;
        boolean bl7 = this.allowAudioMixedMimeTypeAdaptiveness;
        boolean bl8 = this.allowAudioMixedSampleRateAdaptiveness;
        boolean bl9 = this.allowAudioMixedChannelCountAdaptiveness;
        ImmutableList immutableList3 = this.preferredAudioMimeTypes;
        ImmutableList immutableList4 = this.preferredTextLanguages;
        int n23 = this.preferredTextRoleFlags;
        boolean bl10 = this.selectUndeterminedTextLanguage;
        int n24 = this.disabledTextTrackSelectionFlags;
        boolean bl11 = this.forceLowestBitrate;
        boolean bl12 = this.forceHighestSupportedBitrate;
        boolean bl13 = this.exceedRendererCapabilitiesIfNecessary;
        boolean bl14 = this.tunnelingEnabled;
        boolean bl15 = this.allowMultipleAdaptiveSelections;
        SparseArray sparseArray = this.selectionOverrides;
        SparseBooleanArray sparseBooleanArray = this.rendererDisabledFlags;
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = new DefaultTrackSelector$Parameters(n10, n11, n12, n13, n14, n15, n16, n17, bl2, bl3, bl4, n18, n19, bl5, immutableList, immutableList2, n20, n21, n22, bl6, bl7, bl8, bl9, immutableList3, immutableList4, n23, bl10, n24, bl11, bl12, bl13, bl14, bl15, sparseArray, sparseBooleanArray);
        return defaultTrackSelector$Parameters;
    }

    public final DefaultTrackSelector$ParametersBuilder clearSelectionOverride(int n10, TrackGroupArray trackGroupArray) {
        boolean bl2;
        Map map = (Map)this.selectionOverrides.get(n10);
        if (map != null && (bl2 = map.containsKey(trackGroupArray))) {
            map.remove(trackGroupArray);
            boolean bl3 = map.isEmpty();
            if (bl3) {
                trackGroupArray = this.selectionOverrides;
                trackGroupArray.remove(n10);
            }
        }
        return this;
    }

    public final DefaultTrackSelector$ParametersBuilder clearSelectionOverrides() {
        SparseArray sparseArray = this.selectionOverrides;
        int n10 = sparseArray.size();
        if (n10 == 0) {
            return this;
        }
        this.selectionOverrides.clear();
        return this;
    }

    public final DefaultTrackSelector$ParametersBuilder clearSelectionOverrides(int n10) {
        boolean bl2;
        Map map = (Map)this.selectionOverrides.get(n10);
        if (map != null && !(bl2 = map.isEmpty())) {
            map = this.selectionOverrides;
            map.remove(n10);
        }
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder clearVideoSizeConstraints() {
        int n10 = -1 >>> 1;
        return this.setMaxVideoSize(n10, n10);
    }

    public DefaultTrackSelector$ParametersBuilder clearViewportSizeConstraints() {
        int n10 = -1 >>> 1;
        return this.setViewportSize(n10, n10, true);
    }

    public DefaultTrackSelector$ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean bl2) {
        this.allowAudioMixedChannelCountAdaptiveness = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean bl2) {
        this.allowAudioMixedMimeTypeAdaptiveness = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean bl2) {
        this.allowAudioMixedSampleRateAdaptiveness = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setAllowMultipleAdaptiveSelections(boolean bl2) {
        this.allowMultipleAdaptiveSelections = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean bl2) {
        this.allowVideoMixedMimeTypeAdaptiveness = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean bl2) {
        this.allowVideoNonSeamlessAdaptiveness = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setDisabledTextTrackSelectionFlags(int n10) {
        super.setDisabledTextTrackSelectionFlags(n10);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean bl2) {
        this.exceedAudioConstraintsIfNecessary = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean bl2) {
        this.exceedRendererCapabilitiesIfNecessary = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean bl2) {
        this.exceedVideoConstraintsIfNecessary = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setForceHighestSupportedBitrate(boolean bl2) {
        this.forceHighestSupportedBitrate = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setForceLowestBitrate(boolean bl2) {
        this.forceLowestBitrate = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMaxAudioBitrate(int n10) {
        this.maxAudioBitrate = n10;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMaxAudioChannelCount(int n10) {
        this.maxAudioChannelCount = n10;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMaxVideoBitrate(int n10) {
        this.maxVideoBitrate = n10;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMaxVideoFrameRate(int n10) {
        this.maxVideoFrameRate = n10;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMaxVideoSize(int n10, int n11) {
        this.maxVideoWidth = n10;
        this.maxVideoHeight = n11;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMaxVideoSizeSd() {
        return this.setMaxVideoSize(1279, 719);
    }

    public DefaultTrackSelector$ParametersBuilder setMinVideoBitrate(int n10) {
        this.minVideoBitrate = n10;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMinVideoFrameRate(int n10) {
        this.minVideoFrameRate = n10;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setMinVideoSize(int n10, int n11) {
        this.minVideoWidth = n10;
        this.minVideoHeight = n11;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredAudioLanguage(String string2) {
        super.setPreferredAudioLanguage(string2);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredAudioLanguages(String ... stringArray) {
        super.setPreferredAudioLanguages(stringArray);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredAudioMimeType(String object) {
        if (object == null) {
            object = new String[]{};
            object = this.setPreferredAudioMimeTypes((String)object);
        } else {
            int n10 = 1;
            String[] stringArray = new String[n10];
            stringArray[0] = object;
            object = this.setPreferredAudioMimeTypes(stringArray);
        }
        return object;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredAudioMimeTypes(String ... object) {
        this.preferredAudioMimeTypes = object = ImmutableList.copyOf(object);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredAudioRoleFlags(int n10) {
        super.setPreferredAudioRoleFlags(n10);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredTextLanguage(String string2) {
        super.setPreferredTextLanguage(string2);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
        super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredTextLanguages(String ... stringArray) {
        super.setPreferredTextLanguages(stringArray);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredTextRoleFlags(int n10) {
        super.setPreferredTextRoleFlags(n10);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredVideoMimeType(String object) {
        if (object == null) {
            object = new String[]{};
            object = this.setPreferredVideoMimeTypes((String)object);
        } else {
            int n10 = 1;
            String[] stringArray = new String[n10];
            stringArray[0] = object;
            object = this.setPreferredVideoMimeTypes(stringArray);
        }
        return object;
    }

    public DefaultTrackSelector$ParametersBuilder setPreferredVideoMimeTypes(String ... object) {
        this.preferredVideoMimeTypes = object = ImmutableList.copyOf(object);
        return this;
    }

    public final DefaultTrackSelector$ParametersBuilder setRendererDisabled(int n10, boolean bl2) {
        SparseBooleanArray sparseBooleanArray = this.rendererDisabledFlags;
        boolean bl3 = sparseBooleanArray.get(n10);
        if (bl3 == bl2) {
            return this;
        }
        if (bl2) {
            SparseBooleanArray sparseBooleanArray2 = this.rendererDisabledFlags;
            bl3 = true;
            sparseBooleanArray2.put(n10, bl3);
        } else {
            SparseBooleanArray sparseBooleanArray3 = this.rendererDisabledFlags;
            sparseBooleanArray3.delete(n10);
        }
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setSelectUndeterminedTextLanguage(boolean bl2) {
        super.setSelectUndeterminedTextLanguage(bl2);
        return this;
    }

    public final DefaultTrackSelector$ParametersBuilder setSelectionOverride(int n10, TrackGroupArray trackGroupArray, DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride) {
        Object v10;
        HashMap<TrackGroupArray, DefaultTrackSelector$SelectionOverride> hashMap = (HashMap<TrackGroupArray, DefaultTrackSelector$SelectionOverride>)this.selectionOverrides.get(n10);
        if (hashMap == null) {
            hashMap = new HashMap<TrackGroupArray, DefaultTrackSelector$SelectionOverride>();
            SparseArray sparseArray = this.selectionOverrides;
            sparseArray.put(n10, hashMap);
        }
        if ((n10 = (int)(hashMap.containsKey(trackGroupArray) ? 1 : 0)) != 0 && (n10 = (int)(Util.areEqual(v10 = hashMap.get(trackGroupArray), defaultTrackSelector$SelectionOverride) ? 1 : 0)) != 0) {
            return this;
        }
        hashMap.put(trackGroupArray, defaultTrackSelector$SelectionOverride);
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setTunnelingEnabled(boolean bl2) {
        this.tunnelingEnabled = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setViewportSize(int n10, int n11, boolean bl2) {
        this.viewportWidth = n10;
        this.viewportHeight = n11;
        this.viewportOrientationMayChange = bl2;
        return this;
    }

    public DefaultTrackSelector$ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean bl2) {
        context = Util.getCurrentDisplayModeSize(context);
        int n10 = context.x;
        int n11 = context.y;
        return this.setViewportSize(n10, n11, bl2);
    }
}

