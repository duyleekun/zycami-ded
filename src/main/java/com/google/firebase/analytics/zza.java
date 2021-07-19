/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zza
extends ThreadPoolExecutor {
    public zza(FirebaseAnalytics firebaseAnalytics, int n10, int n11, long l10, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30, timeUnit, blockingQueue);
    }
}

