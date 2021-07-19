/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric$NetworkClientErrorReason;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        NetworkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier networkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier = new NetworkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier();
        INSTANCE = networkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier;
    }

    private NetworkRequestMetric$NetworkClientErrorReason$NetworkClientErrorReasonVerifier() {
    }

    public boolean isInRange(int n10) {
        NetworkRequestMetric$NetworkClientErrorReason networkRequestMetric$NetworkClientErrorReason = NetworkRequestMetric$NetworkClientErrorReason.forNumber(n10);
        if (networkRequestMetric$NetworkClientErrorReason != null) {
            n10 = 1;
        } else {
            n10 = 0;
            networkRequestMetric$NetworkClientErrorReason = null;
        }
        return n10 != 0;
    }
}

