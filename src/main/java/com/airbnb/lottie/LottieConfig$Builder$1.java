/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieConfig$Builder;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import java.io.File;
import java.io.Serializable;

public class LottieConfig$Builder$1
implements LottieNetworkCacheProvider {
    public final /* synthetic */ LottieConfig$Builder this$0;
    public final /* synthetic */ File val$file;

    public LottieConfig$Builder$1(LottieConfig$Builder lottieConfig$Builder, File file) {
        this.this$0 = lottieConfig$Builder;
        this.val$file = file;
    }

    public File getCacheDir() {
        Serializable serializable = this.val$file;
        boolean bl2 = serializable.isDirectory();
        if (bl2) {
            return this.val$file;
        }
        serializable = new IllegalArgumentException("cache file must be a directory");
        throw serializable;
    }
}

