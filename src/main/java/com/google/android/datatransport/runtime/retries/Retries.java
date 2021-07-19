/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.retries;

import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

public final class Retries {
    private Retries() {
    }

    public static Object retry(int n10, Object object, Function function, RetryStrategy retryStrategy) {
        Object object2;
        int n11 = 1;
        if (n10 < n11) {
            return function.apply(object);
        }
        while ((object = retryStrategy.shouldRetry(object, object2 = function.apply(object))) != null && (n10 += -1) >= n11) {
        }
        return object2;
    }
}

