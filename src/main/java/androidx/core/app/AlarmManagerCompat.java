/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.AlarmManager$AlarmClockInfo
 *  android.app.PendingIntent
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;

public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(AlarmManager alarmManager, long l10, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(l10, pendingIntent);
            alarmManager.setAlarmClock(alarmClockInfo, pendingIntent2);
        } else {
            pendingIntent = null;
            AlarmManagerCompat.setExact(alarmManager, 0, l10, pendingIntent2);
        }
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int n10, long l10, PendingIntent pendingIntent) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            alarmManager.setAndAllowWhileIdle(n10, l10, pendingIntent);
        } else {
            alarmManager.set(n10, l10, pendingIntent);
        }
    }

    public static void setExact(AlarmManager alarmManager, int n10, long l10, PendingIntent pendingIntent) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            alarmManager.setExact(n10, l10, pendingIntent);
        } else {
            alarmManager.set(n10, l10, pendingIntent);
        }
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int n10, long l10, PendingIntent pendingIntent) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            alarmManager.setExactAndAllowWhileIdle(n10, l10, pendingIntent);
        } else {
            AlarmManagerCompat.setExact(alarmManager, n10, l10, pendingIntent);
        }
    }
}

