/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo$MobileSubtype;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkConnectionInfo$MobileSubtype$MobileSubtypeVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        NetworkConnectionInfo$MobileSubtype$MobileSubtypeVerifier networkConnectionInfo$MobileSubtype$MobileSubtypeVerifier = new NetworkConnectionInfo$MobileSubtype$MobileSubtypeVerifier();
        INSTANCE = networkConnectionInfo$MobileSubtype$MobileSubtypeVerifier;
    }

    private NetworkConnectionInfo$MobileSubtype$MobileSubtypeVerifier() {
    }

    public boolean isInRange(int n10) {
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype = NetworkConnectionInfo$MobileSubtype.forNumber(n10);
        if (networkConnectionInfo$MobileSubtype != null) {
            n10 = 1;
        } else {
            n10 = 0;
            networkConnectionInfo$MobileSubtype = null;
        }
        return n10 != 0;
    }
}

