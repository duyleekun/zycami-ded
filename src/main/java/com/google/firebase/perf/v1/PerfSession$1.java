/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.protobuf.Internal$ListAdapter$Converter;

public class PerfSession$1
implements Internal$ListAdapter$Converter {
    public SessionVerbosity convert(Integer object) {
        int n10 = (Integer)object;
        if ((object = SessionVerbosity.forNumber(n10)) == null) {
            object = SessionVerbosity.SESSION_VERBOSITY_NONE;
        }
        return object;
    }
}

