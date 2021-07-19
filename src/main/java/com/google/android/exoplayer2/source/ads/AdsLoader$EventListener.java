/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$AdLoadException;
import com.google.android.exoplayer2.upstream.DataSpec;

public interface AdsLoader$EventListener {
    default public void onAdClicked() {
    }

    default public void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
    }

    default public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
    }

    default public void onAdTapped() {
    }
}

