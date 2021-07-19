/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.protobuf.Internal$EnumVerifier;

public final class SessionVerbosity$SessionVerbosityVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        SessionVerbosity$SessionVerbosityVerifier sessionVerbosity$SessionVerbosityVerifier = new SessionVerbosity$SessionVerbosityVerifier();
        INSTANCE = sessionVerbosity$SessionVerbosityVerifier;
    }

    private SessionVerbosity$SessionVerbosityVerifier() {
    }

    public boolean isInRange(int n10) {
        SessionVerbosity sessionVerbosity = SessionVerbosity.forNumber(n10);
        if (sessionVerbosity != null) {
            n10 = 1;
        } else {
            n10 = 0;
            sessionVerbosity = null;
        }
        return n10 != 0;
    }
}

