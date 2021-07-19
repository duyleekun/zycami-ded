/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.lang.constant.Constable;
import java.util.AbstractCollection;

public final class DefaultTrackSelector$TextTrackScore
implements Comparable {
    private final boolean hasCaptionRoleFlags;
    private final boolean isDefault;
    private final boolean isForced;
    public final boolean isWithinConstraints;
    private final boolean isWithinRendererCapabilities;
    private final int preferredLanguageIndex;
    private final int preferredLanguageScore;
    private final int preferredRoleFlagsScore;
    private final int selectedAudioLanguageScore;

    public DefaultTrackSelector$TextTrackScore(Format format, DefaultTrackSelector$Parameters object, int n10, String string2) {
        boolean bl2;
        int n11;
        int n12;
        Object object2;
        int n13;
        int n14;
        int n15;
        block8: {
            String string3;
            n15 = 0;
            n10 = (int)(DefaultTrackSelector.isSupported(n10, false) ? 1 : 0);
            this.isWithinRendererCapabilities = n10;
            n10 = format.selectionFlags;
            n14 = ~((TrackSelectionParameters)object).disabledTextTrackSelectionFlags;
            n10 &= n14;
            n14 = n10 & 1;
            n13 = 1;
            if (n14 != 0) {
                n14 = n13;
            } else {
                n14 = 0;
                object2 = null;
            }
            this.isDefault = n14;
            n10 = (n10 &= 2) != 0 ? n13 : 0;
            this.isForced = n10;
            n10 = -1 >>> 1;
            object2 = ((TrackSelectionParameters)object).preferredTextLanguages;
            n14 = (int)(((AbstractCollection)object2).isEmpty() ? 1 : 0);
            object2 = n14 != 0 ? ImmutableList.of("") : ((TrackSelectionParameters)object).preferredTextLanguages;
            for (int i10 = 0; i10 < (n12 = ((AbstractCollection)object2).size()); ++i10) {
                boolean bl3;
                string3 = (String)object2.get(i10);
                n12 = DefaultTrackSelector.getFormatLanguageScore(format, string3, bl3 = ((TrackSelectionParameters)object).selectUndeterminedTextLanguage);
                if (n12 <= 0) continue;
                n10 = i10;
                break block8;
            }
            n12 = 0;
            string3 = null;
        }
        this.preferredLanguageIndex = n10;
        this.preferredLanguageScore = n12;
        n10 = format.roleFlags;
        n14 = ((TrackSelectionParameters)object).preferredTextRoleFlags;
        this.preferredRoleFlagsScore = n10 = Integer.bitCount(n10 & n14);
        n14 = format.roleFlags & 0x440;
        if (n14 != 0) {
            n14 = n13;
        } else {
            n14 = 0;
            object2 = null;
        }
        this.hasCaptionRoleFlags = n14;
        object2 = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(string2);
        if (object2 == null) {
            n14 = n13;
        } else {
            n14 = 0;
            object2 = null;
        }
        this.selectedAudioLanguageScore = n11 = DefaultTrackSelector.getFormatLanguageScore(format, string2, n14 != 0);
        if (n12 > 0 || (bl2 = ((AbstractCollection)(object = ((TrackSelectionParameters)object).preferredTextLanguages)).isEmpty()) && n10 > 0 || (bl2 = this.isDefault) || (bl2 = this.isForced) && n11 > 0) {
            n15 = n13;
        }
        this.isWithinConstraints = n15;
    }

    public int compareTo(DefaultTrackSelector$TextTrackScore defaultTrackSelector$TextTrackScore) {
        ComparisonChain comparisonChain = ComparisonChain.start();
        boolean bl2 = this.isWithinRendererCapabilities;
        int n10 = defaultTrackSelector$TextTrackScore.isWithinRendererCapabilities;
        comparisonChain = comparisonChain.compareFalseFirst(bl2, n10 != 0);
        Constable constable = this.preferredLanguageIndex;
        Constable constable2 = defaultTrackSelector$TextTrackScore.preferredLanguageIndex;
        Ordering ordering = Ordering.natural().reverse();
        comparisonChain = comparisonChain.compare(constable, constable2, ordering);
        int n11 = this.preferredLanguageScore;
        n10 = defaultTrackSelector$TextTrackScore.preferredLanguageScore;
        comparisonChain = comparisonChain.compare(n11, n10);
        int n12 = this.preferredRoleFlagsScore;
        n10 = defaultTrackSelector$TextTrackScore.preferredRoleFlagsScore;
        comparisonChain = comparisonChain.compare(n12, n10);
        boolean bl3 = this.isDefault;
        n10 = (int)(defaultTrackSelector$TextTrackScore.isDefault ? 1 : 0);
        comparisonChain = comparisonChain.compareFalseFirst(bl3, n10 != 0);
        boolean bl4 = this.isForced;
        constable = Boolean.valueOf(bl4);
        n10 = defaultTrackSelector$TextTrackScore.isForced;
        constable2 = Boolean.valueOf(n10 != 0);
        int n13 = this.preferredLanguageScore;
        ordering = n13 == 0 ? Ordering.natural() : Ordering.natural().reverse();
        comparisonChain = comparisonChain.compare(constable, constable2, ordering);
        int n14 = this.selectedAudioLanguageScore;
        n10 = defaultTrackSelector$TextTrackScore.selectedAudioLanguageScore;
        comparisonChain = comparisonChain.compare(n14, n10);
        int n15 = this.preferredRoleFlagsScore;
        if (n15 == 0) {
            boolean bl5 = this.hasCaptionRoleFlags;
            boolean bl6 = defaultTrackSelector$TextTrackScore.hasCaptionRoleFlags;
            comparisonChain = comparisonChain.compareTrueFirst(bl5, bl6);
        }
        return comparisonChain.result();
    }
}

