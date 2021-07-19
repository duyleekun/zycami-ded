/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.ApplicationProcessState$1;
import com.google.firebase.perf.v1.ApplicationProcessState$ApplicationProcessStateVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class ApplicationProcessState
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ ApplicationProcessState[] $VALUES;
    public static final /* enum */ ApplicationProcessState APPLICATION_PROCESS_STATE_UNKNOWN;
    public static final int APPLICATION_PROCESS_STATE_UNKNOWN_VALUE = 0;
    public static final /* enum */ ApplicationProcessState BACKGROUND;
    public static final int BACKGROUND_VALUE = 2;
    public static final /* enum */ ApplicationProcessState FOREGROUND;
    public static final /* enum */ ApplicationProcessState FOREGROUND_BACKGROUND;
    public static final int FOREGROUND_BACKGROUND_VALUE = 3;
    public static final int FOREGROUND_VALUE = 1;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        ApplicationProcessState applicationProcessState;
        ApplicationProcessState applicationProcessState2;
        ApplicationProcessState applicationProcessState3;
        Object object = new ApplicationProcessState("APPLICATION_PROCESS_STATE_UNKNOWN", 0, 0);
        APPLICATION_PROCESS_STATE_UNKNOWN = object;
        int n10 = 1;
        FOREGROUND = applicationProcessState3 = new ApplicationProcessState("FOREGROUND", n10, n10);
        int n11 = 2;
        BACKGROUND = applicationProcessState2 = new ApplicationProcessState("BACKGROUND", n11, n11);
        int n12 = 3;
        FOREGROUND_BACKGROUND = applicationProcessState = new ApplicationProcessState("FOREGROUND_BACKGROUND", n12, n12);
        ApplicationProcessState[] applicationProcessStateArray = new ApplicationProcessState[4];
        applicationProcessStateArray[0] = object;
        applicationProcessStateArray[n10] = applicationProcessState3;
        applicationProcessStateArray[n11] = applicationProcessState2;
        applicationProcessStateArray[n12] = applicationProcessState;
        $VALUES = applicationProcessStateArray;
        internalValueMap = object = new ApplicationProcessState$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ApplicationProcessState() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static ApplicationProcessState forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return FOREGROUND_BACKGROUND;
                }
                return BACKGROUND;
            }
            return FOREGROUND;
        }
        return APPLICATION_PROCESS_STATE_UNKNOWN;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return ApplicationProcessState$ApplicationProcessStateVerifier.INSTANCE;
    }

    public static ApplicationProcessState valueOf(int n10) {
        return ApplicationProcessState.forNumber(n10);
    }

    public static ApplicationProcessState valueOf(String string2) {
        return Enum.valueOf(ApplicationProcessState.class, string2);
    }

    public static ApplicationProcessState[] values() {
        return (ApplicationProcessState[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

