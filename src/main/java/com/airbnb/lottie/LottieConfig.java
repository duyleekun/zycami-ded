/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieConfig$1;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;

public class LottieConfig {
    public final LottieNetworkCacheProvider cacheProvider;
    public final boolean enableSystraceMarkers;
    public final LottieNetworkFetcher networkFetcher;

    private LottieConfig(LottieNetworkFetcher lottieNetworkFetcher, LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean bl2) {
        this.networkFetcher = lottieNetworkFetcher;
        this.cacheProvider = lottieNetworkCacheProvider;
        this.enableSystraceMarkers = bl2;
    }

    public /* synthetic */ LottieConfig(LottieNetworkFetcher lottieNetworkFetcher, LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean bl2, LottieConfig$1 lottieConfig$1) {
        this(lottieNetworkFetcher, lottieNetworkCacheProvider, bl2);
    }
}

