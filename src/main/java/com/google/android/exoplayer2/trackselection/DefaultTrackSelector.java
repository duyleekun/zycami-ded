/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.text.TextUtils
 *  android.util.Pair
 */
package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection$Factory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$AudioTrackScore;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$OtherTrackScore;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TextTrackScore;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$VideoTrackScore;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Factory;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import d.h.a.a.o0.b;
import d.h.a.a.o0.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector
extends MappingTrackSelector {
    private static final Ordering FORMAT_VALUE_ORDERING;
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    private static final Ordering NO_ORDER;
    private static final int[] NO_TRACKS;
    private final AtomicReference parametersReference;
    private final ExoTrackSelection$Factory trackSelectionFactory;

    static {
        NO_TRACKS = new int[0];
        FORMAT_VALUE_ORDERING = Ordering.from(c.a);
        NO_ORDER = Ordering.from(b.a);
    }

    public DefaultTrackSelector() {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = DefaultTrackSelector$Parameters.DEFAULT_WITHOUT_CONTEXT;
        AdaptiveTrackSelection$Factory adaptiveTrackSelection$Factory = new AdaptiveTrackSelection$Factory();
        this(defaultTrackSelector$Parameters, (ExoTrackSelection$Factory)adaptiveTrackSelection$Factory);
    }

    public DefaultTrackSelector(Context context) {
        AdaptiveTrackSelection$Factory adaptiveTrackSelection$Factory = new AdaptiveTrackSelection$Factory();
        this(context, (ExoTrackSelection$Factory)adaptiveTrackSelection$Factory);
    }

    public DefaultTrackSelector(Context object, ExoTrackSelection$Factory exoTrackSelection$Factory) {
        object = DefaultTrackSelector$Parameters.getDefaults(object);
        this((DefaultTrackSelector$Parameters)object, exoTrackSelection$Factory);
    }

    public DefaultTrackSelector(DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, ExoTrackSelection$Factory atomicReference) {
        this.trackSelectionFactory = atomicReference;
        this.parametersReference = atomicReference = new AtomicReference<DefaultTrackSelector$Parameters>(defaultTrackSelector$Parameters);
    }

    public DefaultTrackSelector(ExoTrackSelection$Factory exoTrackSelection$Factory) {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = DefaultTrackSelector$Parameters.DEFAULT_WITHOUT_CONTEXT;
        this(defaultTrackSelector$Parameters, exoTrackSelection$Factory);
    }

    public static /* synthetic */ int a(Integer n10, Integer n11) {
        int n12;
        int n13 = n10;
        if (n13 == (n12 = -1)) {
            int n14 = n11;
            if (n14 == n12) {
                n12 = 0;
            }
        } else {
            n13 = n11;
            if (n13 == n12) {
                n12 = 1;
            } else {
                int n15 = n10;
                int n16 = n11;
                n12 = n15 - n16;
            }
        }
        return n12;
    }

    public static /* synthetic */ Ordering access$300() {
        return FORMAT_VALUE_ORDERING;
    }

    public static /* synthetic */ Ordering access$400() {
        return NO_ORDER;
    }

    public static /* synthetic */ int b(Integer n10, Integer n11) {
        return 0;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] nArray, int n10, String string2, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, List list) {
        List list2 = list;
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            int n19;
            Integer n20 = (Integer)list2.get(i10);
            int n21 = n20;
            Format format = trackGroup.getFormat(n21);
            if ((n21 = (int)(DefaultTrackSelector.isSupportedAdaptiveVideoTrack(format, string2, n19 = nArray[n21], n10, n11, n12, n13, n14, n15, n16, n17, n18) ? 1 : 0)) != 0) continue;
            list2.remove(i10);
        }
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] nArray, int n10, int n11, boolean bl2, boolean bl3, boolean bl4) {
        TrackGroup trackGroup2 = trackGroup;
        int n12 = n10;
        Format format = trackGroup.getFormat(n10);
        int[] nArray2 = new int[trackGroup.length];
        int n13 = 0;
        Format format2 = null;
        int n14 = 0;
        for (int i10 = 0; i10 < (n13 = trackGroup2.length); ++i10) {
            int n15;
            if (i10 != n12 && (n13 = (int)(DefaultTrackSelector.isSupportedAdaptiveAudioTrack(format2 = trackGroup.getFormat(i10), n15 = nArray[i10], format, n11, bl2, bl3, bl4) ? 1 : 0)) == 0) continue;
            n13 = n14 + 1;
            nArray2[n14] = i10;
            n14 = n13;
        }
        return Arrays.copyOf(nArray2, n14);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] nArray, int n10, String string2, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, List list) {
        int n19;
        int n20 = 0;
        for (int i10 = 0; i10 < (n19 = list.size()); ++i10) {
            int n21;
            Integer n22 = (Integer)list.get(i10);
            int n23 = n22;
            Format format = trackGroup.getFormat(n23);
            if ((n23 = (int)(DefaultTrackSelector.isSupportedAdaptiveVideoTrack(format, string2, n21 = nArray[n23], n10, n11, n12, n13, n14, n15, n16, n17, n18) ? 1 : 0)) == 0) continue;
            ++n20;
        }
        return n20;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] nArray, boolean bl2, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20, boolean bl3) {
        String string2;
        int n21;
        int n22;
        Collection<String> collection;
        Object object;
        List list;
        int n23;
        int n24;
        block7: {
            block3: {
                TrackGroup trackGroup2 = trackGroup;
                n24 = trackGroup.length;
                int n25 = 2;
                if (n24 < n25) {
                    return NO_TRACKS;
                }
                n24 = n19;
                n23 = n20;
                list = DefaultTrackSelector.getViewportFilteredTrackIndices(trackGroup, n19, n20, bl3);
                n24 = list.size();
                if (n24 < n25) {
                    return NO_TRACKS;
                }
                n24 = 0;
                object = null;
                if (bl2) break block3;
                collection = new Collection<String>();
                n23 = 0;
                String string3 = null;
                n22 = 0;
                n21 = 0;
                while (n21 < (n24 = list.size())) {
                    Collection<String> collection2;
                    int n26;
                    block6: {
                        block5: {
                            block4: {
                                n24 = (Integer)list.get(n21);
                                object = trackGroup2.getFormat(n24);
                                String string4 = ((Format)object).sampleMimeType;
                                n24 = (int)(((HashSet)collection).add(string4) ? 1 : 0);
                                if (n24 == 0) break block4;
                                object = trackGroup;
                                string2 = string4;
                                n25 = n22;
                                n22 = n17;
                                n26 = n21;
                                n21 = n18;
                                collection2 = collection;
                                collection = list;
                                n24 = DefaultTrackSelector.getAdaptiveVideoTrackCountForMimeType(trackGroup, nArray, n10, string4, n11, n12, n13, n14, n15, n16, n17, n18, list);
                                if (n24 <= n25) break block5;
                                n22 = n24;
                                string3 = string4;
                                break block6;
                            }
                            n25 = n22;
                            n26 = n21;
                            collection2 = collection;
                        }
                        n22 = n25;
                    }
                    n21 = n26 + 1;
                    collection = collection2;
                    n25 = 2;
                }
                string2 = string3;
                break block7;
            }
            string2 = null;
        }
        object = trackGroup;
        n22 = n17;
        n21 = n18;
        collection = list;
        DefaultTrackSelector.filterAdaptiveVideoTrackCountForMimeType(trackGroup, nArray, n10, string2, n11, n12, n13, n14, n15, n16, n17, n18, list);
        n24 = list.size();
        n23 = 2;
        object = n24 < n23 ? (Object)NO_TRACKS : (Object)Ints.toArray(list);
        return object;
    }

    public static int getFormatLanguageScore(Format object, String string2, boolean bl2) {
        String string3;
        int n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 == 0 && (n10 = string2.equals(string3 = ((Format)object).language)) != 0) {
            return 4;
        }
        string2 = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(string2);
        object = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(((Format)object).language);
        n10 = 0;
        string3 = null;
        if (object != null && string2 != null) {
            bl2 = ((String)object).startsWith(string2);
            if (!bl2 && !(bl2 = string2.startsWith((String)object))) {
                String string4 = "-";
                boolean bl3 = ((String)(object = Util.splitAtFirst((String)object, string4)[0])).equals(string2 = Util.splitAtFirst(string2, string4)[0]);
                if (bl3) {
                    return 2;
                }
                return 0;
            }
            return 3;
        }
        if (bl2 && object == null) {
            n10 = 1;
        }
        return n10;
    }

    private static Point getMaxVideoSizeInViewport(boolean n10, int n11, int n12, int n13, int n14) {
        Point point;
        int n15;
        block6: {
            block5: {
                if (n10 == 0) break block5;
                n10 = 1;
                n15 = 0;
                int n16 = n13 > n14 ? n10 : 0;
                if (n11 <= n12) {
                    n10 = 0;
                    point = null;
                }
                if (n16 != n10) break block6;
            }
            int n17 = n12;
            n12 = n11;
            n11 = n17;
        }
        n10 = n13 * n11;
        n15 = n14 * n12;
        if (n10 >= n15) {
            n11 = Util.ceilDivide(n15, n13);
            point = new Point(n12, n11);
            return point;
        }
        n10 = Util.ceilDivide(n10, n14);
        Point point2 = new Point(n10, n11);
        return point2;
    }

    private static List getViewportFilteredTrackIndices(TrackGroup trackGroup, int n10, int n11, boolean n12) {
        int n13;
        int n14;
        int n15 = trackGroup.length;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n15);
        n15 = 0;
        for (n14 = 0; n14 < (n13 = trackGroup.length); ++n14) {
            Integer n16 = n14;
            arrayList.add(n16);
        }
        n14 = -1 >>> 1;
        if (n10 != n14 && n11 != n14) {
            int n17;
            n13 = n14;
            while (n15 < (n17 = trackGroup.length)) {
                int n18;
                Format format = trackGroup.getFormat(n15);
                int n19 = format.width;
                if (n19 > 0 && (n18 = format.height) > 0) {
                    float f10;
                    Point point = DefaultTrackSelector.getMaxVideoSizeInViewport(n12 != 0, n10, n11, n19, n18);
                    n18 = format.width;
                    n17 = format.height;
                    int n20 = n18 * n17;
                    float f11 = point.x;
                    float f12 = 0.98f;
                    int n21 = (int)(f11 *= f12);
                    if (n18 >= n21 && n17 >= (n19 = (int)(f10 = (float)point.y * f12)) && n20 < n13) {
                        n13 = n20;
                    }
                }
                ++n15;
            }
            if (n13 != n14) {
                for (n10 = arrayList.size() + -1; n10 >= 0; n10 += -1) {
                    n11 = (Integer)arrayList.get(n10);
                    Format format = trackGroup.getFormat(n11);
                    if ((n11 = format.getPixelCount()) != (n12 = -1) && n11 <= n13) continue;
                    arrayList.remove(n10);
                }
            }
        }
        return arrayList;
    }

    public static boolean isSupported(int n10, boolean n11) {
        int n12;
        n10 = (n10 = RendererCapabilities.getFormatSupport(n10)) != (n12 = 4) && (n11 == 0 || n10 != (n11 = 3)) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int n10, Format format2, int n11, boolean bl2, boolean bl3, boolean bl4) {
        int n12;
        String string2;
        String string3;
        int n13;
        boolean bl5 = false;
        if ((n10 = (int)(DefaultTrackSelector.isSupported(n10, false) ? 1 : 0)) != 0 && (n10 = format.bitrate) != (n13 = -1) && n10 <= n11 && (bl4 || (n10 = format.channelCount) != n13 && n10 == (n11 = format2.channelCount)) && (bl2 || (string3 = format.sampleMimeType) != null && (n10 = (int)(TextUtils.equals((CharSequence)string3, (CharSequence)(string2 = format2.sampleMimeType)) ? 1 : 0)) != 0) && (bl3 || (n12 = format.sampleRate) != n13 && n12 == (n10 = format2.sampleRate))) {
            bl5 = true;
        }
        return bl5;
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String string2, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19) {
        int n20;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        String string3;
        int n21;
        int n22 = format.roleFlags & 0x4000;
        boolean bl2 = false;
        if (n22 != 0) {
            return false;
        }
        n22 = (int)(DefaultTrackSelector.isSupported(n10, false) ? 1 : 0);
        if (n22 != 0 && (n10 &= n11) != 0 && (string2 == null || (n21 = (int)(Util.areEqual(string3 = format.sampleMimeType, string2) ? 1 : 0)) != 0) && ((n21 = format.width) == (n10 = -1) || n16 <= n21 && n21 <= n12) && ((n21 = format.height) == n10 || n17 <= n21 && n21 <= n13) && ((n11 = (int)((f14 = (f13 = format.frameRate) - (f12 = -1.0f)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1))) == 0 || (n11 = (int)((f11 = (f12 = (float)n18) - f13) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1))) <= 0 && (n21 = (int)((f10 = f13 - (f12 = (float)n14)) == 0.0f ? 0 : (f10 < 0.0f ? -1 : 1))) <= 0) && ((n20 = format.bitrate) == n10 || n19 <= n20 && n20 <= n15)) {
            bl2 = true;
        }
        return bl2;
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector$MappedTrackInfo object, int[][][] nArray, RendererConfiguration[] rendererConfigurationArray, ExoTrackSelection[] exoTrackSelectionArray) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        block4: {
            int n15;
            n14 = 0;
            n13 = -1;
            int n16 = 0;
            n12 = n13;
            n11 = n13;
            while (true) {
                block5: {
                    block8: {
                        block7: {
                            block6: {
                                TrackGroupArray trackGroupArray;
                                int[][] nArray2;
                                boolean bl2;
                                int n17;
                                int n18 = ((MappingTrackSelector$MappedTrackInfo)object).getRendererCount();
                                n10 = 1;
                                if (n16 >= n18) break;
                                n18 = ((MappingTrackSelector$MappedTrackInfo)object).getRendererType(n16);
                                ExoTrackSelection exoTrackSelection = exoTrackSelectionArray[n16];
                                if (n18 != n10 && n18 != (n17 = 2) || exoTrackSelection == null || !(bl2 = DefaultTrackSelector.rendererSupportsTunneling(nArray2 = nArray[n16], trackGroupArray = ((MappingTrackSelector$MappedTrackInfo)object).getTrackGroups(n16), exoTrackSelection))) break block5;
                                if (n18 != n10) break block6;
                                if (n11 != n13) break block7;
                                n11 = n16;
                                break block5;
                            }
                            if (n12 == n13) break block8;
                        }
                        n15 = 0;
                        object = null;
                        break block4;
                    }
                    n12 = n16;
                }
                ++n16;
            }
            n15 = n10;
        }
        if (n11 != n13 && n12 != n13) {
            n14 = n10;
        }
        if ((n15 &= n14) != 0) {
            rendererConfigurationArray[n11] = object = new RendererConfiguration(n10 != 0);
            rendererConfigurationArray[n12] = object;
        }
    }

    public static String normalizeUndeterminedLanguageToNull(String string2) {
        String string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 || (bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)(string3 = "und")))) {
            string2 = null;
        }
        return string2;
    }

    private static boolean rendererSupportsTunneling(int[][] nArray, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        int n10;
        if (exoTrackSelection == null) {
            return false;
        }
        TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
        int n11 = trackGroupArray.indexOf(trackGroup);
        trackGroup = null;
        for (int i10 = 0; i10 < (n10 = exoTrackSelection.length()); ++i10) {
            int[] nArray2 = nArray[n11];
            int n12 = exoTrackSelection.getIndexInTrackGroup(i10);
            n10 = RendererCapabilities.getTunnelingSupport(nArray2[n12]);
            if (n10 == (n12 = 32)) continue;
            return false;
        }
        return true;
    }

    private static ExoTrackSelection$Definition selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray, int[][] nArray, int n10, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        int n11;
        Object object = trackGroupArray;
        Object object2 = defaultTrackSelector$Parameters;
        int n12 = defaultTrackSelector$Parameters.allowVideoNonSeamlessAdaptiveness;
        n12 = n12 != 0 ? 24 : 16;
        int n13 = object2.allowVideoMixedMimeTypeAdaptiveness;
        int[] nArray2 = null;
        if (n13 != 0 && (n13 = n10 & n12) != 0) {
            n13 = 1;
            float f10 = Float.MIN_VALUE;
            n11 = n13;
        } else {
            n11 = 0;
        }
        int n14 = 0;
        while (n14 < (n13 = ((TrackGroupArray)object).length)) {
            TrackGroup trackGroup = ((TrackGroupArray)object).get(n14);
            nArray2 = nArray[n14];
            int n15 = object2.maxVideoWidth;
            int n16 = object2.maxVideoHeight;
            int n17 = object2.maxVideoFrameRate;
            int n18 = object2.maxVideoBitrate;
            int n19 = object2.minVideoWidth;
            int n20 = object2.minVideoHeight;
            int n21 = object2.minVideoFrameRate;
            int n22 = object2.minVideoBitrate;
            int n23 = object2.viewportWidth;
            n13 = object2.viewportHeight;
            boolean bl2 = object2.viewportOrientationMayChange;
            int n24 = n23;
            n23 = n11;
            int n25 = n22;
            n22 = n12;
            object2 = trackGroup;
            int n26 = n25;
            n25 = n14;
            n14 = n24;
            n24 = (int)(bl2 ? 1 : 0);
            object = DefaultTrackSelector.getAdaptiveVideoTracksForGroup(trackGroup, nArray2, n11 != 0, n12, n15, n16, n17, n18, n19, n20, n21, n26, n14, n13, bl2);
            if ((n13 = ((Object)object).length) > 0) {
                ExoTrackSelection$Definition exoTrackSelection$Definition = new ExoTrackSelection$Definition(trackGroup, (int[])object);
                return exoTrackSelection$Definition;
            }
            n14 = n25 + 1;
            object = trackGroupArray;
            object2 = defaultTrackSelector$Parameters;
        }
        return null;
    }

    private static ExoTrackSelection$Definition selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] nArray, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        int n10;
        Object object = trackGroupArray;
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters2 = defaultTrackSelector$Parameters;
        ExoTrackSelection$Definition exoTrackSelection$Definition = null;
        int n11 = -1;
        TrackGroup trackGroup = null;
        DefaultTrackSelector$VideoTrackScore defaultTrackSelector$VideoTrackScore = null;
        for (int i10 = 0; i10 < (n10 = ((TrackGroupArray)object).length); ++i10) {
            int n12;
            TrackGroup trackGroup2 = ((TrackGroupArray)object).get(i10);
            int n13 = defaultTrackSelector$Parameters2.viewportWidth;
            int n14 = defaultTrackSelector$Parameters2.viewportHeight;
            int n15 = defaultTrackSelector$Parameters2.viewportOrientationMayChange;
            List list = DefaultTrackSelector.getViewportFilteredTrackIndices(trackGroup2, n13, n14, n15 != 0);
            int[] nArray2 = nArray[i10];
            for (n15 = 0; n15 < (n12 = trackGroup2.length); ++n15) {
                Format format = trackGroup2.getFormat(n15);
                int n16 = format.roleFlags & 0x4000;
                if (n16 != 0) continue;
                n16 = nArray2[n15];
                int n17 = defaultTrackSelector$Parameters2.exceedRendererCapabilitiesIfNecessary;
                if ((n16 = (int)(DefaultTrackSelector.isSupported(n16, n17 != 0) ? 1 : 0)) == 0) continue;
                n17 = nArray2[n15];
                Integer n18 = n15;
                boolean bl2 = list.contains(n18);
                DefaultTrackSelector$VideoTrackScore defaultTrackSelector$VideoTrackScore2 = new DefaultTrackSelector$VideoTrackScore(format, defaultTrackSelector$Parameters2, n17, bl2);
                n12 = (int)(defaultTrackSelector$VideoTrackScore2.isWithinMaxConstraints ? 1 : 0);
                if (n12 == 0 && (n12 = (int)(defaultTrackSelector$Parameters2.exceedVideoConstraintsIfNecessary ? 1 : 0)) == 0 || defaultTrackSelector$VideoTrackScore != null && (n12 = defaultTrackSelector$VideoTrackScore2.compareTo(defaultTrackSelector$VideoTrackScore)) <= 0) continue;
                trackGroup = trackGroup2;
                n11 = n15;
                defaultTrackSelector$VideoTrackScore = defaultTrackSelector$VideoTrackScore2;
            }
        }
        if (trackGroup != null) {
            int n19 = 1;
            object = new int[n19];
            object[0] = n11;
            exoTrackSelection$Definition = new ExoTrackSelection$Definition(trackGroup, (int[])object);
        }
        return exoTrackSelection$Definition;
    }

    public DefaultTrackSelector$ParametersBuilder buildUponParameters() {
        return this.getParameters().buildUpon();
    }

    public DefaultTrackSelector$Parameters getParameters() {
        return (DefaultTrackSelector$Parameters)this.parametersReference.get();
    }

    /*
     * Unable to fully structure code
     */
    public ExoTrackSelection$Definition[] selectAllTracks(MappingTrackSelector$MappedTrackInfo var1_1, int[][][] var2_2, int[] var3_3, DefaultTrackSelector$Parameters var4_4) {
        var5_5 = this;
        var6_6 = var1_1;
        var7_7 = var4_4;
        var8_8 = var1_1.getRendererCount();
        var9_9 = new ExoTrackSelection$Definition[var8_8];
        var10_10 = 0;
        var11_11 = 0;
        var12_12 = null;
        var13_13 = 0;
        var14_14 = false;
        var15_15 = null;
        while (true) {
            var16_16 = 2;
            var17_17 = 1;
            var18_18 = 1.4E-45f;
            if (var13_13 >= var8_8) break;
            var19_19 = var6_6.getRendererType(var13_13);
            if (var16_16 == var19_19) {
                if (!var11_11) {
                    var20_20 = var6_6.getTrackGroups(var13_13);
                    var21_21 = var2_2[var13_13];
                    var22_22 = var3_3[var13_13];
                    var23_23 = 1;
                    var12_12 = this;
                    var24_24 = var4_4;
                    var9_9[var13_13] = var12_12 = this.selectVideoTrack((TrackGroupArray)var20_20, (int[][])var21_21, var22_22, var4_4, (boolean)var23_23);
                    var12_12 = var9_9[var13_13];
                    if (var12_12 != null) {
                        var11_11 = var17_17;
                    } else {
                        var11_11 = 0;
                        var12_12 = null;
                    }
                }
                var20_20 = var6_6.getTrackGroups(var13_13);
                var19_19 = var20_20.length;
                if (var19_19 <= 0) {
                    var17_17 = 0;
                    var25_25 = null;
                    var18_18 = 0.0f;
                }
                var14_14 |= var17_17;
            }
            ++var13_13;
        }
        var13_13 = -1;
        var23_23 = 0;
        var26_26 = null;
        var27_27 = var13_13;
        var22_22 = 0;
        var28_28 = null;
        var29_29 = 0;
        var24_24 = null;
        while (var23_23 < var8_8) {
            block15: {
                block14: {
                    block13: {
                        var11_11 = var6_6.getRendererType(var23_23);
                        if (var17_17 != var11_11) break block13;
                        var11_11 = (int)var7_7.allowMultipleAdaptiveSelections;
                        var30_30 = !var11_11 && var14_14 ? 0 : var17_17;
                        var20_20 = var6_6.getTrackGroups(var23_23);
                        var31_31 = var2_2[var23_23];
                        var32_32 = var3_3[var23_23];
                        var12_12 = this;
                        var16_16 = var27_27;
                        var21_21 = var31_31;
                        var25_25 = var28_28;
                        var22_22 = var32_32;
                        var33_33 = var24_24;
                        var24_24 = var4_4;
                        var32_32 = var23_23;
                        var23_23 = var30_30;
                        var12_12 = this.selectAudioTrack((TrackGroupArray)var20_20, var31_31, var22_22, var4_4, (boolean)var30_30);
                        if (var12_12 == null || var28_28 != null && (var19_19 = (var20_20 = (DefaultTrackSelector$AudioTrackScore)var12_12.second).compareTo((DefaultTrackSelector$AudioTrackScore)var28_28)) <= 0) break block14;
                        if (var16_16 != var13_13) {
                            var9_9[var16_16] = null;
                        }
                        var9_9[var32_32] = var20_20 = (ExoTrackSelection$Definition)var12_12.first;
                        var21_21 = var20_20.group;
                        var19_19 = var20_20.tracks[0];
                        var20_20 = var21_21.getFormat(var19_19);
                        var24_24 = var20_20.language;
                        var28_28 = var12_12 = var12_12.second;
                        var28_28 = (DefaultTrackSelector$AudioTrackScore)var12_12;
                        var27_27 = var32_32;
                        break block15;
                    }
                    var16_16 = var27_27;
                    var25_25 = var28_28;
                    var33_33 = var24_24;
                    var32_32 = var23_23;
                }
                var27_27 = var16_16;
                var28_28 = var25_25;
                var24_24 = var33_33;
            }
            var23_23 = var32_32 + 1;
            var16_16 = 2;
            var17_17 = 1;
            var18_18 = 1.4E-45f;
        }
        var33_33 = var24_24;
        var19_19 = var13_13;
        var11_11 = 0;
        var12_12 = null;
        while (var10_10 < var8_8) {
            block17: {
                block16: {
                    var27_27 = var6_6.getRendererType(var10_10);
                    if (var27_27 == (var22_22 = 1)) break block16;
                    var29_29 = 2;
                    if (var27_27 == var29_29) ** GOTO lbl120
                    var23_23 = 3;
                    if (var27_27 == var23_23) {
                        var21_21 = var6_6.getTrackGroups(var10_10);
                        var26_26 = var2_2[var10_10];
                        var15_15 = var33_33;
                        if ((var21_21 = (Object)var5_5.selectTextTrack((TrackGroupArray)var21_21, (int[][])var26_26, var7_7, (String)var33_33)) != null && (var12_12 == null || (var23_23 = (var26_26 = (DefaultTrackSelector$TextTrackScore)var21_21.second).compareTo((DefaultTrackSelector$TextTrackScore)var12_12)) > 0)) {
                            if (var19_19 != var13_13) {
                                var9_9[var19_19] = null;
                            }
                            var9_9[var10_10] = var12_12 = (ExoTrackSelection$Definition)var21_21.first;
                            var12_12 = (DefaultTrackSelector$TextTrackScore)var21_21.second;
                            var19_19 = var10_10;
                        }
                    } else {
                        var26_26 = var6_6.getTrackGroups(var10_10);
                        var15_15 = var2_2[var10_10];
                        var21_21 = var5_5.selectOtherTrack(var27_27, (TrackGroupArray)var26_26, (int[][])var15_15, var7_7);
                        var9_9[var10_10] = var21_21;
lbl120:
                        // 2 sources

                        var15_15 = var33_33;
                    }
                    break block17;
                }
                var15_15 = var33_33;
                var29_29 = 2;
            }
            ++var10_10;
            var33_33 = var15_15;
        }
        return var9_9;
    }

    public Pair selectAudioTrack(TrackGroupArray trackGroupArray, int[][] nArray, int n10, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, boolean bl2) {
        boolean bl3;
        boolean bl4;
        int n11;
        int n12;
        int[] nArray2;
        Object object;
        int n13;
        int n14;
        Object object2 = trackGroupArray;
        Object object3 = defaultTrackSelector$Parameters;
        ExoTrackSelection$Definition exoTrackSelection$Definition = null;
        int n15 = -1;
        DefaultTrackSelector$AudioTrackScore defaultTrackSelector$AudioTrackScore = null;
        int n16 = n15;
        int n17 = n15;
        for (n14 = 0; n14 < (n13 = ((TrackGroupArray)object2).length); ++n14) {
            object = ((TrackGroupArray)object2).get(n14);
            nArray2 = nArray[n14];
            for (n12 = 0; n12 < (n11 = ((TrackGroup)object).length); ++n12) {
                n11 = nArray2[n12];
                bl4 = ((DefaultTrackSelector$Parameters)object3).exceedRendererCapabilitiesIfNecessary;
                if ((n11 = (int)(DefaultTrackSelector.isSupported(n11, bl4) ? 1 : 0)) == 0) continue;
                Format format = ((TrackGroup)object).getFormat(n12);
                bl3 = nArray2[n12];
                DefaultTrackSelector$AudioTrackScore defaultTrackSelector$AudioTrackScore2 = new DefaultTrackSelector$AudioTrackScore(format, (DefaultTrackSelector$Parameters)object3, (int)(bl3 ? 1 : 0));
                n11 = (int)(defaultTrackSelector$AudioTrackScore2.isWithinConstraints ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(((DefaultTrackSelector$Parameters)object3).exceedAudioConstraintsIfNecessary ? 1 : 0)) == 0 || defaultTrackSelector$AudioTrackScore != null && (n11 = defaultTrackSelector$AudioTrackScore2.compareTo(defaultTrackSelector$AudioTrackScore)) <= 0) continue;
                n16 = n14;
                n17 = n12;
                defaultTrackSelector$AudioTrackScore = defaultTrackSelector$AudioTrackScore2;
            }
        }
        if (n16 == n15) {
            return null;
        }
        object2 = ((TrackGroupArray)object2).get(n16);
        n15 = (int)(((DefaultTrackSelector$Parameters)object3).forceHighestSupportedBitrate ? 1 : 0);
        n14 = 1;
        if (n15 == 0 && (n15 = (int)(((DefaultTrackSelector$Parameters)object3).forceLowestBitrate ? 1 : 0)) == 0 && bl2) {
            nArray2 = nArray[n16];
            n11 = ((DefaultTrackSelector$Parameters)object3).maxAudioBitrate;
            bl4 = ((DefaultTrackSelector$Parameters)object3).allowAudioMixedMimeTypeAdaptiveness;
            bl3 = ((DefaultTrackSelector$Parameters)object3).allowAudioMixedSampleRateAdaptiveness;
            boolean bl5 = ((DefaultTrackSelector$Parameters)object3).allowAudioMixedChannelCountAdaptiveness;
            object = object2;
            n12 = n17;
            object3 = DefaultTrackSelector.getAdaptiveAudioTracks((TrackGroup)object2, nArray2, n17, n11, bl4, bl3, bl5);
            n15 = ((Object)object3).length;
            if (n15 > n14) {
                exoTrackSelection$Definition = new ExoTrackSelection$Definition((TrackGroup)object2, (int[])object3);
            }
        }
        if (exoTrackSelection$Definition == null) {
            object3 = new int[n14];
            object3[0] = n17;
            exoTrackSelection$Definition = new ExoTrackSelection$Definition((TrackGroup)object2, (int[])object3);
        }
        object2 = (DefaultTrackSelector$AudioTrackScore)Assertions.checkNotNull(defaultTrackSelector$AudioTrackScore);
        return Pair.create((Object)exoTrackSelection$Definition, (Object)object2);
    }

    public ExoTrackSelection$Definition selectOtherTrack(int n10, TrackGroupArray object, int[][] nArray, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        int n11;
        ExoTrackSelection$Definition exoTrackSelection$Definition = null;
        TrackGroup trackGroup = null;
        DefaultTrackSelector$OtherTrackScore defaultTrackSelector$OtherTrackScore = null;
        int n12 = 0;
        for (int i10 = 0; i10 < (n11 = ((TrackGroupArray)object).length); ++i10) {
            int n13;
            TrackGroup trackGroup2 = ((TrackGroupArray)object).get(i10);
            int[] nArray2 = nArray[i10];
            for (int i11 = 0; i11 < (n13 = trackGroup2.length); ++i11) {
                n13 = nArray2[i11];
                boolean bl2 = defaultTrackSelector$Parameters.exceedRendererCapabilitiesIfNecessary;
                if ((n13 = (int)(DefaultTrackSelector.isSupported(n13, bl2) ? 1 : 0)) == 0) continue;
                Format format = trackGroup2.getFormat(i11);
                int n14 = nArray2[i11];
                DefaultTrackSelector$OtherTrackScore defaultTrackSelector$OtherTrackScore2 = new DefaultTrackSelector$OtherTrackScore(format, n14);
                if (defaultTrackSelector$OtherTrackScore != null && (n13 = defaultTrackSelector$OtherTrackScore2.compareTo(defaultTrackSelector$OtherTrackScore)) <= 0) continue;
                trackGroup = trackGroup2;
                n12 = i11;
                defaultTrackSelector$OtherTrackScore = defaultTrackSelector$OtherTrackScore2;
            }
        }
        if (trackGroup != null) {
            int n15 = 1;
            object = new int[n15];
            object[0] = n12;
            exoTrackSelection$Definition = new ExoTrackSelection$Definition(trackGroup, (int[])object);
        }
        return exoTrackSelection$Definition;
    }

    public Pair selectTextTrack(TrackGroupArray trackGroupArray, int[][] nArray, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, String string2) {
        int n10;
        Object object = trackGroupArray;
        Object object2 = defaultTrackSelector$Parameters;
        Pair pair = null;
        int n11 = -1;
        TrackGroup trackGroup = null;
        DefaultTrackSelector$TextTrackScore defaultTrackSelector$TextTrackScore = null;
        for (int i10 = 0; i10 < (n10 = ((TrackGroupArray)object).length); ++i10) {
            int n12;
            TrackGroup trackGroup2 = ((TrackGroupArray)object).get(i10);
            int[] nArray2 = nArray[i10];
            for (int i11 = 0; i11 < (n12 = trackGroup2.length); ++i11) {
                n12 = nArray2[i11];
                boolean bl2 = ((DefaultTrackSelector$Parameters)object2).exceedRendererCapabilitiesIfNecessary;
                if ((n12 = (int)(DefaultTrackSelector.isSupported(n12, bl2) ? 1 : 0)) == 0) continue;
                Format format = trackGroup2.getFormat(i11);
                int n13 = nArray2[i11];
                DefaultTrackSelector$TextTrackScore defaultTrackSelector$TextTrackScore2 = new DefaultTrackSelector$TextTrackScore(format, (DefaultTrackSelector$Parameters)object2, n13, string2);
                n12 = (int)(defaultTrackSelector$TextTrackScore2.isWithinConstraints ? 1 : 0);
                if (n12 == 0 || defaultTrackSelector$TextTrackScore != null && (n12 = defaultTrackSelector$TextTrackScore2.compareTo(defaultTrackSelector$TextTrackScore)) <= 0) continue;
                trackGroup = trackGroup2;
                n11 = i11;
                defaultTrackSelector$TextTrackScore = defaultTrackSelector$TextTrackScore2;
            }
        }
        if (trackGroup != null) {
            int n14 = 1;
            object2 = new int[n14];
            object2[0] = n11;
            object = new ExoTrackSelection$Definition(trackGroup, (int[])object2);
            object2 = (DefaultTrackSelector$TextTrackScore)Assertions.checkNotNull(defaultTrackSelector$TextTrackScore);
            pair = Pair.create((Object)object, (Object)object2);
        }
        return pair;
    }

    public final Pair selectTracks(MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo, int[][][] nArray, int[] objectArray, MediaSource$MediaPeriodId rendererConfigurationArray, Timeline timeline) {
        int n10;
        Object object;
        int n11;
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = (DefaultTrackSelector$Parameters)this.parametersReference.get();
        int n12 = mappingTrackSelector$MappedTrackInfo.getRendererCount();
        objectArray = this.selectAllTracks(mappingTrackSelector$MappedTrackInfo, nArray, (int[])objectArray, defaultTrackSelector$Parameters);
        int n13 = 0;
        Object object2 = null;
        while (true) {
            ExoTrackSelection$Definition exoTrackSelection$Definition = null;
            if (n13 >= n12) break;
            n11 = defaultTrackSelector$Parameters.getRendererDisabled(n13);
            if (n11 != 0) {
                objectArray[n13] = (int)null;
            } else {
                object = mappingTrackSelector$MappedTrackInfo.getTrackGroups(n13);
                int n14 = defaultTrackSelector$Parameters.hasSelectionOverride(n13, (TrackGroupArray)object);
                if (n14 != 0) {
                    Object object3 = defaultTrackSelector$Parameters.getSelectionOverride(n13, (TrackGroupArray)object);
                    if (object3 != null) {
                        int n15 = ((DefaultTrackSelector$SelectionOverride)object3).groupIndex;
                        object = ((TrackGroupArray)object).get(n15);
                        int[] nArray2 = ((DefaultTrackSelector$SelectionOverride)object3).tracks;
                        int n16 = ((DefaultTrackSelector$SelectionOverride)object3).reason;
                        n14 = ((DefaultTrackSelector$SelectionOverride)object3).data;
                        object3 = n14;
                        exoTrackSelection$Definition = new ExoTrackSelection$Definition((TrackGroup)object, nArray2, n16, object3);
                    }
                    objectArray[n13] = (int)exoTrackSelection$Definition;
                }
            }
            ++n13;
        }
        object2 = this.trackSelectionFactory;
        object = this.getBandwidthMeter();
        objectArray = object2.createTrackSelections((ExoTrackSelection$Definition[])objectArray, (BandwidthMeter)object, (MediaSource$MediaPeriodId)rendererConfigurationArray, timeline);
        rendererConfigurationArray = new RendererConfiguration[n12];
        timeline = null;
        for (n10 = 0; n10 < n12; ++n10) {
            n13 = (int)(defaultTrackSelector$Parameters.getRendererDisabled(n10) ? 1 : 0);
            if (n13 == 0 && ((n13 = mappingTrackSelector$MappedTrackInfo.getRendererType(n10)) == (n11 = 7) || (object2 = (Object)objectArray[n10]) != null)) {
                n13 = 1;
            } else {
                n13 = 0;
                object2 = null;
            }
            if (n13 != 0) {
                object2 = RendererConfiguration.DEFAULT;
            } else {
                n13 = 0;
                object2 = null;
            }
            rendererConfigurationArray[n10] = object2;
        }
        n10 = (int)(defaultTrackSelector$Parameters.tunnelingEnabled ? 1 : 0);
        if (n10 != 0) {
            DefaultTrackSelector.maybeConfigureRenderersForTunneling(mappingTrackSelector$MappedTrackInfo, nArray, rendererConfigurationArray, (ExoTrackSelection[])objectArray);
        }
        return Pair.create((Object)rendererConfigurationArray, (Object)objectArray);
    }

    public ExoTrackSelection$Definition selectVideoTrack(TrackGroupArray trackGroupArray, int[][] nArray, int n10, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, boolean bl2) {
        ExoTrackSelection$Definition exoTrackSelection$Definition;
        boolean bl3 = defaultTrackSelector$Parameters.forceHighestSupportedBitrate;
        if (!bl3 && !(bl3 = defaultTrackSelector$Parameters.forceLowestBitrate) && bl2) {
            exoTrackSelection$Definition = DefaultTrackSelector.selectAdaptiveVideoTrack(trackGroupArray, nArray, n10, defaultTrackSelector$Parameters);
        } else {
            n10 = 0;
            exoTrackSelection$Definition = null;
        }
        if (exoTrackSelection$Definition == null) {
            exoTrackSelection$Definition = DefaultTrackSelector.selectFixedVideoTrack(trackGroupArray, nArray, defaultTrackSelector$Parameters);
        }
        return exoTrackSelection$Definition;
    }

    public void setParameters(DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        Assertions.checkNotNull(defaultTrackSelector$Parameters);
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters2 = this.parametersReference.getAndSet(defaultTrackSelector$Parameters);
        boolean bl2 = defaultTrackSelector$Parameters2.equals(defaultTrackSelector$Parameters);
        if (!bl2) {
            this.invalidate();
        }
    }

    public void setParameters(DefaultTrackSelector$ParametersBuilder object) {
        object = ((DefaultTrackSelector$ParametersBuilder)object).build();
        this.setParameters((DefaultTrackSelector$Parameters)object);
    }
}

