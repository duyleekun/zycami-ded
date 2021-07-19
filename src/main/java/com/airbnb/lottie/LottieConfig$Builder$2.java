/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieConfig$Builder;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import java.io.File;
import java.io.Serializable;

public class LottieConfig$Builder$2
implements LottieNetworkCacheProvider {
    public final /* synthetic */ LottieConfig$Builder this$0;
    public final /* synthetic */ LottieNetworkCacheProvider val$fileCacheProvider;

    public LottieConfig$Builder$2(LottieConfig$Builder lottieConfig$Builder, LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.this$0 = lottieConfig$Builder;
        this.val$fileCacheProvider = lottieNetworkCacheProvider;
    }

    public File getCacheDir() {
        Serializable serializable = this.val$fileCacheProvider.getCacheDir();
        boolean bl2 = serializable.isDirectory();
        if (bl2) {
            return serializable;
        }
        serializable = new IllegalArgumentException("cache file must be a directory");
        throw serializable;
    }
}

