/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

public final class ClippingMediaPeriod
implements MediaPeriod,
MediaPeriod$Callback {
    private MediaPeriod$Callback callback;
    public long endUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingMediaPeriod$ClippingSampleStream[] sampleStreams;
    public long startUs;

    public ClippingMediaPeriod(MediaPeriod clippingMediaPeriod$ClippingSampleStreamArray, boolean bl2, long l10, long l11) {
        this.mediaPeriod = clippingMediaPeriod$ClippingSampleStreamArray;
        clippingMediaPeriod$ClippingSampleStreamArray = new ClippingMediaPeriod$ClippingSampleStream[]{};
        this.sampleStreams = clippingMediaPeriod$ClippingSampleStreamArray;
        long l12 = bl2 ? l10 : -9223372036854775807L;
        this.pendingInitialDiscontinuityPositionUs = l12;
        this.startUs = l10;
        this.endUs = l11;
    }

    private SeekParameters clipSeekParameters(long l10, SeekParameters seekParameters) {
        long l11;
        long l12 = seekParameters.toleranceBeforeUs;
        long l13 = this.startUs;
        long l14 = l10 - l13;
        l12 = Util.constrainValue(l12, 0L, l14);
        l13 = seekParameters.toleranceAfterUs;
        l14 = this.endUs;
        long l15 = Long.MIN_VALUE;
        long l16 = l14 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        l15 = object == false ? (l10 = Long.MAX_VALUE) : (l14 -= l10);
        l14 = 0L;
        l10 = Util.constrainValue(l13, l14, l15);
        l13 = seekParameters.toleranceBeforeUs;
        long l17 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l17 == false && (l17 = (l11 = l10 - (l13 = seekParameters.toleranceAfterUs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
            return seekParameters;
        }
        seekParameters = new SeekParameters(l12, l10);
        return seekParameters;
    }

    private static boolean shouldKeepInitialDiscontinuity(long l10, ExoTrackSelection[] exoTrackSelectionArray) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArray) {
                if (exoTrackSelection == null) continue;
                Format format = exoTrackSelection.getSelectedFormat();
                String string2 = format.sampleMimeType;
                String string3 = format.codecs;
                boolean bl2 = MimeTypes.allSamplesAreSyncSamples(string2, string3);
                if (bl2) continue;
                return true;
            }
        }
        return false;
    }

    public boolean continueLoading(long l10) {
        return this.mediaPeriod.continueLoading(l10);
    }

    public void discardBuffer(long l10, boolean bl2) {
        this.mediaPeriod.discardBuffer(l10, bl2);
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        long l11 = this.startUs;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return l11;
        }
        seekParameters = this.clipSeekParameters(l10, seekParameters);
        return this.mediaPeriod.getAdjustedSeekPositionUs(l10, seekParameters);
    }

    public long getBufferedPositionUs() {
        long l10;
        long l11;
        long l12;
        long l13;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l14 = mediaPeriod.getBufferedPositionUs();
        long l15 = l14 - (l13 = Long.MIN_VALUE);
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object != false && ((l12 = (l11 = (l10 = this.endUs) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false || (object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) < 0)) {
            return l14;
        }
        return l13;
    }

    public long getNextLoadPositionUs() {
        long l10;
        long l11;
        long l12;
        long l13;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l14 = mediaPeriod.getNextLoadPositionUs();
        long l15 = l14 - (l13 = Long.MIN_VALUE);
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object != false && ((l12 = (l11 = (l10 = this.endUs) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false || (object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) < 0)) {
            return l14;
        }
        return l13;
    }

    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    public boolean isPendingInitialDiscontinuity() {
        long l10 = this.pendingInitialDiscontinuityPositionUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void maybeThrowPrepareError() {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod$Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        ((MediaPeriod$Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    public void prepare(MediaPeriod$Callback mediaPeriod$Callback, long l10) {
        this.callback = mediaPeriod$Callback;
        this.mediaPeriod.prepare(this, l10);
    }

    public long readDiscontinuity() {
        Object object = this.isPendingInitialDiscontinuity();
        long l10 = -9223372036854775807L;
        if (object != 0) {
            long l11 = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = l10;
            long l12 = this.readDiscontinuity();
            long l13 = l12 - l10;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object != 0) {
                l11 = l12;
            }
            return l11;
        }
        MediaPeriod mediaPeriod = this.mediaPeriod;
        long l14 = mediaPeriod.readDiscontinuity();
        long l15 = l14 - l10;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == 0) {
            return l10;
        }
        long l16 = this.startUs;
        object = l14 == l16 ? 0 : (l14 < l16 ? -1 : 1);
        int n10 = 1;
        if (object >= 0) {
            object = n10;
        } else {
            object = 0;
            mediaPeriod = null;
        }
        Assertions.checkState((boolean)object);
        long l17 = this.endUs;
        long l18 = Long.MIN_VALUE;
        object = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
        if (object != 0 && (object = l14 == l17 ? 0 : (l14 < l17 ? -1 : 1)) > 0) {
            n10 = 0;
        }
        Assertions.checkState(n10 != 0);
        return l14;
    }

    public void reevaluateBuffer(long l10) {
        this.mediaPeriod.reevaluateBuffer(l10);
    }

    public long seekToUs(long l10) {
        long l11;
        long l12;
        long l13;
        int n10;
        long l14;
        this.pendingInitialDiscontinuityPositionUs = l14 = -9223372036854775807L;
        Object object = this.sampleStreams;
        int n11 = ((ClippingMediaPeriod$ClippingSampleStream[])object).length;
        boolean bl2 = false;
        for (n10 = 0; n10 < n11; ++n10) {
            ClippingMediaPeriod$ClippingSampleStream clippingMediaPeriod$ClippingSampleStream = object[n10];
            if (clippingMediaPeriod$ClippingSampleStream == null) continue;
            clippingMediaPeriod$ClippingSampleStream.clearSentEos();
        }
        object = this.mediaPeriod;
        l14 = object.seekToUs(l10);
        long l15 = l14 - l10;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 == false || (object2 = (l13 = l14 - (l10 = this.startUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0 && ((n10 = (int)((l12 = (l10 = this.endUs) - (l11 = Long.MIN_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0 || (object2 = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) <= 0)) {
            bl2 = true;
        }
        Assertions.checkState(bl2);
        return l14;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public long selectTracks(ExoTrackSelection[] var1_1, boolean[] var2_2, SampleStream[] var3_3, boolean[] var4_4, long var5_5) {
        var7_6 = this;
        var8_7 = var3_3;
        var9_8 = new ClippingMediaPeriod$ClippingSampleStream[var3_3.length];
        this.sampleStreams = var9_8;
        var10_9 = new SampleStream[var3_3.length];
        var11_10 = 0;
        var12_11 = 0;
        var9_8 = null;
        while (true) {
            var13_12 = var8_7.length;
            var14_13 = null;
            if (var12_11 >= var13_12) break;
            var15_14 /* !! */  = var7_6.sampleStreams;
            var16_15 /* !! */  = (boolean[])((ClippingMediaPeriod$ClippingSampleStream)var8_7[var12_11]);
            var15_14 /* !! */ [var12_11] = var16_15 /* !! */ ;
            var16_15 /* !! */  = (boolean[])var15_14 /* !! */ [var12_11];
            if (var16_15 /* !! */  != null) {
                var15_14 /* !! */  = var15_14 /* !! */ [var12_11];
                var14_13 = var15_14 /* !! */ .childStream;
            }
            var10_9[var12_11] = var14_13;
            ++var12_11;
        }
        var9_8 = var7_6.mediaPeriod;
        var15_14 /* !! */  = var1_1;
        var16_15 /* !! */  = var2_2;
        var17_16 /* !! */  = var10_9;
        var18_17 /* !! */  = var4_4;
        var19_18 = var9_8.selectTracks(var1_1, var2_2, var10_9, var4_4, var5_5);
        var21_19 = this.isPendingInitialDiscontinuity();
        if (var21_19 == 0 || (var24_21 = (cfr_temp_0 = var5_5 - (var22_20 = var7_6.startUs)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) ** GOTO lbl-1000
        var18_17 /* !! */  = (boolean[])var1_1;
        var21_19 = ClippingMediaPeriod.shouldKeepInitialDiscontinuity(var22_20, var1_1);
        if (var21_19 != 0) {
            var22_20 = var19_18;
        } else lbl-1000:
        // 2 sources

        {
            var22_20 = -9223372036854775807L;
        }
        var7_6.pendingInitialDiscontinuityPositionUs = var22_20;
        var21_19 = var19_18 == var5_5 ? 0 : (var19_18 < var5_5 ? -1 : 1);
        if (var21_19 != 0 && ((var21_19 = (cfr_temp_1 = var19_18 - (var22_20 = var7_6.startUs)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) < 0 || (var24_21 = (cfr_temp_2 = (var22_20 = var7_6.endUs) - (var25_22 = -9223372036854775808L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false && (var21_19 = (int)(var19_18 == var22_20 ? 0 : (var19_18 < var22_20 ? -1 : 1))) > 0)) {
            var21_19 = 0;
            var16_15 /* !! */  = null;
        } else {
            var21_19 = 1;
        }
        Assertions.checkState((boolean)var21_19);
        while (var11_10 < (var21_19 = var8_7.length)) {
            var16_15 /* !! */  = (boolean[])var10_9[var11_10];
            if (var16_15 /* !! */  == null) {
                var16_15 /* !! */  = (boolean[])var7_6.sampleStreams;
                var16_15 /* !! */ [var11_10] = null;
            } else {
                var16_15 /* !! */  = (boolean[])var7_6.sampleStreams;
                var17_16 /* !! */  = (SampleStream[])var16_15 /* !! */ [var11_10];
                if (var17_16 /* !! */  == null || (var17_16 /* !! */  = var16_15 /* !! */ [var11_10].childStream) != (var18_17 /* !! */  = (boolean[])var10_9[var11_10])) {
                    var18_17 /* !! */  = (boolean[])var10_9[var11_10];
                    var17_16 /* !! */  = new ClippingMediaPeriod$ClippingSampleStream(this, (SampleStream)var18_17 /* !! */ );
                    var16_15 /* !! */ [var11_10] = var17_16 /* !! */ ;
                }
            }
            var16_15 /* !! */  = (boolean[])var7_6.sampleStreams[var11_10];
            var8_7[var11_10] = var16_15 /* !! */ ;
            ++var11_10;
        }
        return var19_18;
    }

    public void updateClipping(long l10, long l11) {
        this.startUs = l10;
        this.endUs = l11;
    }
}

