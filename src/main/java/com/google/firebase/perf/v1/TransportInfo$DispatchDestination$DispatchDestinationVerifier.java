/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.TransportInfo$DispatchDestination;
import com.google.protobuf.Internal$EnumVerifier;

public final class TransportInfo$DispatchDestination$DispatchDestinationVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        TransportInfo$DispatchDestination$DispatchDestinationVerifier transportInfo$DispatchDestination$DispatchDestinationVerifier = new TransportInfo$DispatchDestination$DispatchDestinationVerifier();
        INSTANCE = transportInfo$DispatchDestination$DispatchDestinationVerifier;
    }

    private TransportInfo$DispatchDestination$DispatchDestinationVerifier() {
    }

    public boolean isInRange(int n10) {
        TransportInfo$DispatchDestination transportInfo$DispatchDestination = TransportInfo$DispatchDestination.forNumber(n10);
        if (transportInfo$DispatchDestination != null) {
            n10 = 1;
        } else {
            n10 = 0;
            transportInfo$DispatchDestination = null;
        }
        return n10 != 0;
    }
}

