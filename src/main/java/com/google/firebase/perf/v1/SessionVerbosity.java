/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.SessionVerbosity$1;
import com.google.firebase.perf.v1.SessionVerbosity$SessionVerbosityVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class SessionVerbosity
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ SessionVerbosity[] $VALUES;
    public static final /* enum */ SessionVerbosity GAUGES_AND_SYSTEM_EVENTS;
    public static final int GAUGES_AND_SYSTEM_EVENTS_VALUE = 1;
    public static final /* enum */ SessionVerbosity SESSION_VERBOSITY_NONE;
    public static final int SESSION_VERBOSITY_NONE_VALUE;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        SessionVerbosity sessionVerbosity;
        Object object = new SessionVerbosity("SESSION_VERBOSITY_NONE", 0, 0);
        SESSION_VERBOSITY_NONE = object;
        int n10 = 1;
        GAUGES_AND_SYSTEM_EVENTS = sessionVerbosity = new SessionVerbosity("GAUGES_AND_SYSTEM_EVENTS", n10, n10);
        SessionVerbosity[] sessionVerbosityArray = new SessionVerbosity[2];
        sessionVerbosityArray[0] = object;
        sessionVerbosityArray[n10] = sessionVerbosity;
        $VALUES = sessionVerbosityArray;
        internalValueMap = object = new SessionVerbosity$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SessionVerbosity() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static SessionVerbosity forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return null;
            }
            return GAUGES_AND_SYSTEM_EVENTS;
        }
        return SESSION_VERBOSITY_NONE;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return SessionVerbosity$SessionVerbosityVerifier.INSTANCE;
    }

    public static SessionVerbosity valueOf(int n10) {
        return SessionVerbosity.forNumber(n10);
    }

    public static SessionVerbosity valueOf(String string2) {
        return Enum.valueOf(SessionVerbosity.class, string2);
    }

    public static SessionVerbosity[] values() {
        return (SessionVerbosity[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

