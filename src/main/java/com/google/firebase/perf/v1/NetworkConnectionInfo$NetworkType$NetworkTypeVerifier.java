/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo$NetworkType;
import com.google.protobuf.Internal$EnumVerifier;

public final class NetworkConnectionInfo$NetworkType$NetworkTypeVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        NetworkConnectionInfo$NetworkType$NetworkTypeVerifier networkConnectionInfo$NetworkType$NetworkTypeVerifier = new NetworkConnectionInfo$NetworkType$NetworkTypeVerifier();
        INSTANCE = networkConnectionInfo$NetworkType$NetworkTypeVerifier;
    }

    private NetworkConnectionInfo$NetworkType$NetworkTypeVerifier() {
    }

    public boolean isInRange(int n10) {
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType = NetworkConnectionInfo$NetworkType.forNumber(n10);
        if (networkConnectionInfo$NetworkType != null) {
            n10 = 1;
        } else {
            n10 = 0;
            networkConnectionInfo$NetworkType = null;
        }
        return n10 != 0;
    }
}

