/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.AbstractCollection;
import java.util.Comparator;

public final class DefaultTrackSelector$AudioTrackScore
implements Comparable {
    private final int bitrate;
    private final int channelCount;
    private final boolean isDefaultSelectionFlag;
    public final boolean isWithinConstraints;
    private final boolean isWithinRendererCapabilities;
    private final String language;
    private final int localeLanguageMatchIndex;
    private final int localeLanguageScore;
    private final DefaultTrackSelector$Parameters parameters;
    private final int preferredLanguageIndex;
    private final int preferredLanguageScore;
    private final int preferredMimeTypeMatchIndex;
    private final int preferredRoleFlagsScore;
    private final int sampleRate;

    public DefaultTrackSelector$AudioTrackScore(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int n10) {
        int n11;
        int n12;
        int n13;
        Object object;
        Object object2;
        int n14;
        block10: {
            String string2;
            int n15;
            block9: {
                String string3;
                this.parameters = defaultTrackSelector$Parameters;
                this.language = string3 = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
                n14 = 0;
                string3 = null;
                n10 = (int)(DefaultTrackSelector.isSupported(n10, false) ? 1 : 0);
                this.isWithinRendererCapabilities = n10;
                n10 = 0;
                object2 = null;
                while (true) {
                    object = defaultTrackSelector$Parameters.preferredAudioLanguages;
                    n13 = ((AbstractCollection)object).size();
                    n12 = -1 >>> 1;
                    float f10 = 0.0f / 0.0f;
                    if (n10 >= n13) break;
                    object = (String)defaultTrackSelector$Parameters.preferredAudioLanguages.get(n10);
                    n13 = DefaultTrackSelector.getFormatLanguageScore(format, (String)object, false);
                    if (n13 <= 0) {
                        ++n10;
                        continue;
                    }
                    break block9;
                    break;
                }
                n13 = 0;
                object = null;
                n10 = n12;
            }
            this.preferredLanguageIndex = n10;
            this.preferredLanguageScore = n13;
            n10 = format.roleFlags;
            n13 = defaultTrackSelector$Parameters.preferredAudioRoleFlags;
            this.preferredRoleFlagsScore = n10 = Integer.bitCount(n10 & n13);
            n10 = format.selectionFlags;
            n13 = 1;
            if ((n10 &= n13) != 0) {
                n10 = n13;
            } else {
                n10 = 0;
                object2 = null;
            }
            this.isDefaultSelectionFlag = n10;
            this.channelCount = n10 = format.channelCount;
            this.sampleRate = n11 = format.sampleRate;
            this.bitrate = n11 = format.bitrate;
            int n16 = -1;
            if (n11 != n16 && n11 > (n15 = defaultTrackSelector$Parameters.maxAudioBitrate) || n10 != n16 && n10 > (n11 = defaultTrackSelector$Parameters.maxAudioChannelCount)) {
                n13 = 0;
                object = null;
            }
            this.isWithinConstraints = n13;
            object2 = Util.getSystemLanguageCodes();
            object = null;
            for (n13 = 0; n13 < (n11 = ((String[])object2).length); ++n13) {
                string2 = object2[n13];
                n11 = DefaultTrackSelector.getFormatLanguageScore(format, string2, false);
                if (n11 <= 0) {
                    continue;
                }
                break block10;
            }
            n11 = 0;
            string2 = null;
            n13 = n12;
        }
        this.localeLanguageMatchIndex = n13;
        this.localeLanguageScore = n11;
        while (n14 < (n10 = ((AbstractCollection)(object2 = defaultTrackSelector$Parameters.preferredAudioMimeTypes)).size())) {
            object2 = format.sampleMimeType;
            if (object2 != null && (n10 = (int)(((String)object2).equals(object = defaultTrackSelector$Parameters.preferredAudioMimeTypes.get(n14)) ? 1 : 0)) != 0) {
                n12 = n14;
                break;
            }
            ++n14;
        }
        this.preferredMimeTypeMatchIndex = n12;
    }

    public int compareTo(DefaultTrackSelector$AudioTrackScore object) {
        boolean bl2 = this.isWithinConstraints;
        Ordering ordering = bl2 && (bl2 = this.isWithinRendererCapabilities) ? DefaultTrackSelector.access$300() : DefaultTrackSelector.access$300().reverse();
        ComparisonChain comparisonChain = ComparisonChain.start();
        int n10 = this.isWithinRendererCapabilities;
        int n11 = ((DefaultTrackSelector$AudioTrackScore)object).isWithinRendererCapabilities;
        comparisonChain = comparisonChain.compareFalseFirst(n10 != 0, n11 != 0);
        Integer n12 = this.preferredLanguageIndex;
        Integer n13 = ((DefaultTrackSelector$AudioTrackScore)object).preferredLanguageIndex;
        Object object2 = Ordering.natural().reverse();
        comparisonChain = comparisonChain.compare(n12, n13, (Comparator)object2);
        n10 = this.preferredLanguageScore;
        n11 = ((DefaultTrackSelector$AudioTrackScore)object).preferredLanguageScore;
        comparisonChain = comparisonChain.compare(n10, n11);
        n10 = this.preferredRoleFlagsScore;
        n11 = ((DefaultTrackSelector$AudioTrackScore)object).preferredRoleFlagsScore;
        comparisonChain = comparisonChain.compare(n10, n11);
        n10 = (int)(this.isWithinConstraints ? 1 : 0);
        n11 = (int)(((DefaultTrackSelector$AudioTrackScore)object).isWithinConstraints ? 1 : 0);
        comparisonChain = comparisonChain.compareFalseFirst(n10 != 0, n11 != 0);
        n12 = this.preferredMimeTypeMatchIndex;
        n13 = ((DefaultTrackSelector$AudioTrackScore)object).preferredMimeTypeMatchIndex;
        object2 = Ordering.natural().reverse();
        comparisonChain = comparisonChain.compare(n12, n13, (Comparator)object2);
        n10 = this.bitrate;
        n12 = n10;
        n11 = ((DefaultTrackSelector$AudioTrackScore)object).bitrate;
        n13 = n11;
        object2 = this.parameters;
        boolean bl3 = ((DefaultTrackSelector$Parameters)object2).forceLowestBitrate;
        object2 = bl3 ? DefaultTrackSelector.access$300().reverse() : DefaultTrackSelector.access$400();
        comparisonChain = comparisonChain.compare(n12, n13, (Comparator)object2);
        n10 = (int)(this.isDefaultSelectionFlag ? 1 : 0);
        n11 = (int)(((DefaultTrackSelector$AudioTrackScore)object).isDefaultSelectionFlag ? 1 : 0);
        comparisonChain = comparisonChain.compareFalseFirst(n10 != 0, n11 != 0);
        n12 = this.localeLanguageMatchIndex;
        n13 = ((DefaultTrackSelector$AudioTrackScore)object).localeLanguageMatchIndex;
        object2 = Ordering.natural().reverse();
        comparisonChain = comparisonChain.compare(n12, n13, (Comparator)object2);
        n10 = this.localeLanguageScore;
        n11 = ((DefaultTrackSelector$AudioTrackScore)object).localeLanguageScore;
        comparisonChain = comparisonChain.compare(n10, n11);
        n12 = this.channelCount;
        n13 = ((DefaultTrackSelector$AudioTrackScore)object).channelCount;
        comparisonChain = comparisonChain.compare(n12, n13, ordering);
        n12 = this.sampleRate;
        n13 = ((DefaultTrackSelector$AudioTrackScore)object).sampleRate;
        comparisonChain = comparisonChain.compare(n12, n13, ordering);
        n10 = this.bitrate;
        n12 = n10;
        n11 = ((DefaultTrackSelector$AudioTrackScore)object).bitrate;
        n13 = n11;
        object2 = this.language;
        object = ((DefaultTrackSelector$AudioTrackScore)object).language;
        boolean bl4 = Util.areEqual(object2, object);
        if (!bl4) {
            ordering = DefaultTrackSelector.access$400();
        }
        return comparisonChain.compare(n12, n13, ordering).result();
    }
}

