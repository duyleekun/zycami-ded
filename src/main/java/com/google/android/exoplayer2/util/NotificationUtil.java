/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.content.Context
 */
package com.google.android.exoplayer2.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class NotificationUtil {
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = 64536;

    private NotificationUtil() {
    }

    public static void createNotificationChannel(Context context, String string2, int n10, int n11) {
        NotificationUtil.createNotificationChannel(context, string2, n10, 0, n11);
    }

    public static void createNotificationChannel(Context object, String string2, int n10, int n11, int n12) {
        int n13 = Util.SDK_INT;
        int n14 = 26;
        if (n13 >= n14) {
            NotificationManager notificationManager = (NotificationManager)Assertions.checkNotNull((NotificationManager)object.getSystemService("notification"));
            String string3 = object.getString(n10);
            NotificationChannel notificationChannel = new NotificationChannel(string2, (CharSequence)string3, n12);
            if (n11 != 0) {
                object = object.getString(n11);
                notificationChannel.setDescription((String)object);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public static void setNotification(Context context, int n10, Notification notification) {
        String string2 = "notification";
        context = (NotificationManager)Assertions.checkNotNull((NotificationManager)context.getSystemService(string2));
        if (notification != null) {
            context.notify(n10, notification);
        } else {
            context.cancel(n10);
        }
    }
}

