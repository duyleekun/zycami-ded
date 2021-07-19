/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.protobuf.Internal$EnumVerifier;

public final class ApplicationProcessState$ApplicationProcessStateVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        ApplicationProcessState$ApplicationProcessStateVerifier applicationProcessState$ApplicationProcessStateVerifier = new ApplicationProcessState$ApplicationProcessStateVerifier();
        INSTANCE = applicationProcessState$ApplicationProcessStateVerifier;
    }

    private ApplicationProcessState$ApplicationProcessStateVerifier() {
    }

    public boolean isInRange(int n10) {
        ApplicationProcessState applicationProcessState = ApplicationProcessState.forNumber(n10);
        if (applicationProcessState != null) {
            n10 = 1;
        } else {
            n10 = 0;
            applicationProcessState = null;
        }
        return n10 != 0;
    }
}

