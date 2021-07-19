/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2;

public final class NotificationSetupMode
extends Enum {
    public static final /* enum */ NotificationSetupMode COMPAT;
    public static final /* enum */ NotificationSetupMode DEFAULT;
    public static final /* enum */ NotificationSetupMode QUICK_SETUP;
    private static final /* synthetic */ NotificationSetupMode[] a;

    static {
        NotificationSetupMode notificationSetupMode;
        NotificationSetupMode notificationSetupMode2;
        NotificationSetupMode notificationSetupMode3;
        DEFAULT = notificationSetupMode3 = new NotificationSetupMode("DEFAULT", 0);
        int n10 = 1;
        COMPAT = notificationSetupMode2 = new NotificationSetupMode("COMPAT", n10);
        int n11 = 2;
        QUICK_SETUP = notificationSetupMode = new NotificationSetupMode("QUICK_SETUP", n11);
        NotificationSetupMode[] notificationSetupModeArray = new NotificationSetupMode[3];
        notificationSetupModeArray[0] = notificationSetupMode3;
        notificationSetupModeArray[n10] = notificationSetupMode2;
        notificationSetupModeArray[n11] = notificationSetupMode;
        a = notificationSetupModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NotificationSetupMode() {
        void var2_-1;
        void var1_-1;
    }

    public static NotificationSetupMode valueOf(String string2) {
        return Enum.valueOf(NotificationSetupMode.class, string2);
    }

    public static NotificationSetupMode[] values() {
        return (NotificationSetupMode[])a.clone();
    }
}

