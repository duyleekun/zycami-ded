/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.network;

import com.airbnb.lottie.network.DefaultLottieFetchResult;
import com.airbnb.lottie.network.LottieFetchResult;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DefaultLottieNetworkFetcher
implements LottieNetworkFetcher {
    public LottieFetchResult fetchSync(String object) {
        Object object2 = new URL((String)object);
        object = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object2).openConnection()));
        ((HttpURLConnection)object).setRequestMethod("GET");
        ((URLConnection)object).connect();
        object2 = new DefaultLottieFetchResult((HttpURLConnection)object);
        return object2;
    }
}

