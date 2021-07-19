/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class SessionConfig$SessionError
extends Enum {
    private static final /* synthetic */ SessionConfig$SessionError[] $VALUES;
    public static final /* enum */ SessionConfig$SessionError SESSION_ERROR_SURFACE_NEEDS_RESET;
    public static final /* enum */ SessionConfig$SessionError SESSION_ERROR_UNKNOWN;

    static {
        SessionConfig$SessionError sessionConfig$SessionError;
        SessionConfig$SessionError sessionConfig$SessionError2;
        SESSION_ERROR_SURFACE_NEEDS_RESET = sessionConfig$SessionError2 = new SessionConfig$SessionError("SESSION_ERROR_SURFACE_NEEDS_RESET", 0);
        int n10 = 1;
        SESSION_ERROR_UNKNOWN = sessionConfig$SessionError = new SessionConfig$SessionError("SESSION_ERROR_UNKNOWN", n10);
        SessionConfig$SessionError[] sessionConfig$SessionErrorArray = new SessionConfig$SessionError[2];
        sessionConfig$SessionErrorArray[0] = sessionConfig$SessionError2;
        sessionConfig$SessionErrorArray[n10] = sessionConfig$SessionError;
        $VALUES = sessionConfig$SessionErrorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SessionConfig$SessionError() {
        void var2_-1;
        void var1_-1;
    }

    public static SessionConfig$SessionError valueOf(String string2) {
        return Enum.valueOf(SessionConfig$SessionError.class, string2);
    }

    public static SessionConfig$SessionError[] values() {
        return (SessionConfig$SessionError[])$VALUES.clone();
    }
}

