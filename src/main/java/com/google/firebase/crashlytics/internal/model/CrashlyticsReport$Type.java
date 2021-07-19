/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

public final class CrashlyticsReport$Type
extends Enum {
    private static final /* synthetic */ CrashlyticsReport$Type[] $VALUES;
    public static final /* enum */ CrashlyticsReport$Type INCOMPLETE;
    public static final /* enum */ CrashlyticsReport$Type JAVA;
    public static final /* enum */ CrashlyticsReport$Type NATIVE;

    static {
        CrashlyticsReport$Type crashlyticsReport$Type;
        CrashlyticsReport$Type crashlyticsReport$Type2;
        CrashlyticsReport$Type crashlyticsReport$Type3;
        INCOMPLETE = crashlyticsReport$Type3 = new CrashlyticsReport$Type("INCOMPLETE", 0);
        int n10 = 1;
        JAVA = crashlyticsReport$Type2 = new CrashlyticsReport$Type("JAVA", n10);
        int n11 = 2;
        NATIVE = crashlyticsReport$Type = new CrashlyticsReport$Type("NATIVE", n11);
        CrashlyticsReport$Type[] crashlyticsReport$TypeArray = new CrashlyticsReport$Type[3];
        crashlyticsReport$TypeArray[0] = crashlyticsReport$Type3;
        crashlyticsReport$TypeArray[n10] = crashlyticsReport$Type2;
        crashlyticsReport$TypeArray[n11] = crashlyticsReport$Type;
        $VALUES = crashlyticsReport$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CrashlyticsReport$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static CrashlyticsReport$Type valueOf(String string2) {
        return Enum.valueOf(CrashlyticsReport$Type.class, string2);
    }

    public static CrashlyticsReport$Type[] values() {
        return (CrashlyticsReport$Type[])$VALUES.clone();
    }
}

