/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.airbnb.lottie;

import android.content.Context;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.L$1;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;

public class L {
    public static boolean DBG = false;
    private static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    private static LottieNetworkCacheProvider cacheProvider;
    private static int depthPastMaxDepth = 0;
    private static LottieNetworkFetcher fetcher;
    private static volatile NetworkCache networkCache;
    private static volatile NetworkFetcher networkFetcher;
    private static String[] sections;
    private static long[] startTimeNs;
    private static int traceDepth = 0;
    private static boolean traceEnabled = false;

    private L() {
    }

    public static void beginSection(String string2) {
        long l10;
        int n10 = traceEnabled;
        if (n10 == 0) {
            return;
        }
        int n11 = 20;
        if ((n10 = traceDepth++) == n11) {
            ++depthPastMaxDepth;
            return;
        }
        L.sections[n10] = string2;
        long[] lArray = startTimeNs;
        lArray[n10] = l10 = System.nanoTime();
        TraceCompat.beginSection(string2);
    }

    public static float endSection(String object) {
        int n10 = depthPastMaxDepth;
        int n11 = 0;
        Object object2 = null;
        if (n10 > 0) {
            depthPastMaxDepth = n10 + -1;
            return 0.0f;
        }
        n10 = (int)(traceEnabled ? 1 : 0);
        if (n10 == 0) {
            return 0.0f;
        }
        traceDepth = n10 = traceDepth + -1;
        n11 = -1;
        if (n10 != n11) {
            object2 = sections;
            Object object3 = object2[n10];
            if ((n10 = (int)(object.equals(object3) ? 1 : 0)) != 0) {
                TraceCompat.endSection();
                long l10 = System.nanoTime();
                object = startTimeNs;
                int n12 = traceDepth;
                Object object4 = object[n12];
                return (float)(l10 - object4) / 1000000.0f;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unbalanced trace call ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(". Expected ");
            object = sections;
            int n13 = traceDepth;
            object = object[n13];
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(".");
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
        object = new IllegalStateException("Can't end trace section. There are none.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NetworkCache networkCache(Context context) {
        NetworkCache networkCache = L.networkCache;
        if (networkCache != null) return networkCache;
        Class<NetworkCache> clazz = NetworkCache.class;
        synchronized (clazz) {
            networkCache = L.networkCache;
            if (networkCache != null) return networkCache;
            LottieNetworkCacheProvider lottieNetworkCacheProvider = cacheProvider;
            if (lottieNetworkCacheProvider == null) {
                lottieNetworkCacheProvider = new L$1(context);
            }
            L.networkCache = networkCache = new NetworkCache(lottieNetworkCacheProvider);
            return networkCache;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NetworkFetcher networkFetcher(Context object) {
        NetworkFetcher networkFetcher = L.networkFetcher;
        if (networkFetcher != null) return networkFetcher;
        Class<NetworkFetcher> clazz = NetworkFetcher.class;
        synchronized (clazz) {
            networkFetcher = L.networkFetcher;
            if (networkFetcher != null) return networkFetcher;
            object = L.networkCache(object);
            LottieNetworkFetcher lottieNetworkFetcher = fetcher;
            if (lottieNetworkFetcher == null) {
                lottieNetworkFetcher = new DefaultLottieNetworkFetcher();
            }
            L.networkFetcher = networkFetcher = new NetworkFetcher((NetworkCache)object, lottieNetworkFetcher);
            return networkFetcher;
        }
    }

    public static void setCacheProvider(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        cacheProvider = lottieNetworkCacheProvider;
    }

    public static void setFetcher(LottieNetworkFetcher lottieNetworkFetcher) {
        fetcher = lottieNetworkFetcher;
    }

    public static void setTraceEnabled(boolean bl2) {
        boolean bl3 = traceEnabled;
        if (bl3 == bl2) {
            return;
        }
        traceEnabled = bl2;
        if (bl2) {
            int n10 = 20;
            String[] stringArray = new String[n10];
            sections = stringArray;
            long[] lArray = new long[n10];
            startTimeNs = lArray;
        }
    }
}

