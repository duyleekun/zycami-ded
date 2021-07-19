/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

public final class RoomDatabase$JournalMode
extends Enum {
    private static final /* synthetic */ RoomDatabase$JournalMode[] $VALUES;
    public static final /* enum */ RoomDatabase$JournalMode AUTOMATIC;
    public static final /* enum */ RoomDatabase$JournalMode TRUNCATE;
    public static final /* enum */ RoomDatabase$JournalMode WRITE_AHEAD_LOGGING;

    static {
        RoomDatabase$JournalMode roomDatabase$JournalMode;
        RoomDatabase$JournalMode roomDatabase$JournalMode2;
        RoomDatabase$JournalMode roomDatabase$JournalMode3;
        AUTOMATIC = roomDatabase$JournalMode3 = new RoomDatabase$JournalMode("AUTOMATIC", 0);
        int n10 = 1;
        TRUNCATE = roomDatabase$JournalMode2 = new RoomDatabase$JournalMode("TRUNCATE", n10);
        int n11 = 2;
        WRITE_AHEAD_LOGGING = roomDatabase$JournalMode = new RoomDatabase$JournalMode("WRITE_AHEAD_LOGGING", n11);
        RoomDatabase$JournalMode[] roomDatabase$JournalModeArray = new RoomDatabase$JournalMode[3];
        roomDatabase$JournalModeArray[0] = roomDatabase$JournalMode3;
        roomDatabase$JournalModeArray[n10] = roomDatabase$JournalMode2;
        roomDatabase$JournalModeArray[n11] = roomDatabase$JournalMode;
        $VALUES = roomDatabase$JournalModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RoomDatabase$JournalMode() {
        void var2_-1;
        void var1_-1;
    }

    private static boolean isLowRamDevice(ActivityManager activityManager) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return activityManager.isLowRamDevice();
        }
        return false;
    }

    public static RoomDatabase$JournalMode valueOf(String string2) {
        return Enum.valueOf(RoomDatabase$JournalMode.class, string2);
    }

    public static RoomDatabase$JournalMode[] values() {
        return (RoomDatabase$JournalMode[])$VALUES.clone();
    }

    public RoomDatabase$JournalMode resolve(Context context) {
        boolean bl2;
        Object object = AUTOMATIC;
        if (this != object) {
            return this;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11 && (context = (ActivityManager)context.getSystemService((String)(object = "activity"))) != null && !(bl2 = RoomDatabase$JournalMode.isLowRamDevice((ActivityManager)context))) {
            return WRITE_AHEAD_LOGGING;
        }
        return TRUNCATE;
    }
}

