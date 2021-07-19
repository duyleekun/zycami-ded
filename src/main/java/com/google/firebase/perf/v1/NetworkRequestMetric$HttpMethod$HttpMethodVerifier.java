/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkRequestMetric$HttpMethod$HttpMethodVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        NetworkRequestMetric$HttpMethod$HttpMethodVerifier networkRequestMetric$HttpMethod$HttpMethodVerifier = new NetworkRequestMetric$HttpMethod$HttpMethodVerifier();
        INSTANCE = networkRequestMetric$HttpMethod$HttpMethodVerifier;
    }

    private NetworkRequestMetric$HttpMethod$HttpMethodVerifier() {
    }

    public boolean isInRange(int n10) {
        NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.forNumber(n10);
        if (networkRequestMetric$HttpMethod != null) {
            n10 = 1;
        } else {
            n10 = 0;
            networkRequestMetric$HttpMethod = null;
        }
        return n10 != 0;
    }
}

