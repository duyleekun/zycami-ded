/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import java.io.File;

public class L$1
implements LottieNetworkCacheProvider {
    public final /* synthetic */ Context val$context;

    public L$1(Context context) {
        this.val$context = context;
    }

    public File getCacheDir() {
        File file = this.val$context.getCacheDir();
        File file2 = new File(file, "lottie_network_cache");
        return file2;
    }
}

