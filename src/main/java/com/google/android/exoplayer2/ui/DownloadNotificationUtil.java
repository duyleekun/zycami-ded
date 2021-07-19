/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.content.Context
 */
package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.exoplayer2.ui.DownloadNotificationHelper;
import java.util.List;

public final class DownloadNotificationUtil {
    private DownloadNotificationUtil() {
    }

    public static Notification buildDownloadCompletedNotification(Context context, int n10, String string2, PendingIntent pendingIntent, String string3) {
        DownloadNotificationHelper downloadNotificationHelper = new DownloadNotificationHelper(context, string2);
        return downloadNotificationHelper.buildDownloadCompletedNotification(context, n10, pendingIntent, string3);
    }

    public static Notification buildDownloadFailedNotification(Context context, int n10, String string2, PendingIntent pendingIntent, String string3) {
        DownloadNotificationHelper downloadNotificationHelper = new DownloadNotificationHelper(context, string2);
        return downloadNotificationHelper.buildDownloadFailedNotification(context, n10, pendingIntent, string3);
    }

    public static Notification buildProgressNotification(Context context, int n10, String string2, PendingIntent pendingIntent, String string3, List list) {
        DownloadNotificationHelper downloadNotificationHelper = new DownloadNotificationHelper(context, string2);
        return downloadNotificationHelper.buildProgressNotification(context, n10, pendingIntent, string3, list);
    }
}

