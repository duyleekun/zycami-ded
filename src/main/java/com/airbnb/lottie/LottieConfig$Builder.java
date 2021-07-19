/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieConfig;
import com.airbnb.lottie.LottieConfig$Builder$1;
import com.airbnb.lottie.LottieConfig$Builder$2;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

public final class LottieConfig$Builder {
    private LottieNetworkCacheProvider cacheProvider;
    private boolean enableSystraceMarkers = false;
    private LottieNetworkFetcher networkFetcher;

    public LottieConfig build() {
        LottieNetworkFetcher lottieNetworkFetcher = this.networkFetcher;
        LottieNetworkCacheProvider lottieNetworkCacheProvider = this.cacheProvider;
        boolean bl2 = this.enableSystraceMarkers;
        LottieConfig lottieConfig = new LottieConfig(lottieNetworkFetcher, lottieNetworkCacheProvider, bl2, null);
        return lottieConfig;
    }

    public LottieConfig$Builder setEnableSystraceMarkers(boolean bl2) {
        this.enableSystraceMarkers = bl2;
        return this;
    }

    public LottieConfig$Builder setNetworkCacheDir(File serializable) {
        LottieNetworkCacheProvider lottieNetworkCacheProvider = this.cacheProvider;
        if (lottieNetworkCacheProvider == null) {
            this.cacheProvider = lottieNetworkCacheProvider = new LottieConfig$Builder$1(this, (File)serializable);
            return this;
        }
        serializable = new IllegalStateException("There is already a cache provider!");
        throw serializable;
    }

    public LottieConfig$Builder setNetworkCacheProvider(LottieNetworkCacheProvider object) {
        LottieNetworkCacheProvider lottieNetworkCacheProvider = this.cacheProvider;
        if (lottieNetworkCacheProvider == null) {
            this.cacheProvider = lottieNetworkCacheProvider = new LottieConfig$Builder$2(this, (LottieNetworkCacheProvider)object);
            return this;
        }
        object = new IllegalStateException("There is already a cache provider!");
        throw object;
    }

    public LottieConfig$Builder setNetworkFetcher(LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkFetcher = lottieNetworkFetcher;
        return this;
    }
}

