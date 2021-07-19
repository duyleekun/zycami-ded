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
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.ui.R$string;
import java.util.List;

public final class DownloadNotificationHelper {
    private static final int NULL_STRING_ID;
    private final NotificationCompat$Builder notificationBuilder;

    public DownloadNotificationHelper(Context context, String string2) {
        NotificationCompat$Builder notificationCompat$Builder;
        context = context.getApplicationContext();
        this.notificationBuilder = notificationCompat$Builder = new NotificationCompat$Builder(context, string2);
    }

    private Notification buildEndStateNotification(Context context, int n10, PendingIntent pendingIntent, String string2, int n11) {
        return this.buildNotification(context, n10, pendingIntent, string2, n11, 0, 0, false, false, true);
    }

    private Notification buildNotification(Context object, int n10, PendingIntent pendingIntent, String string2, int n11, int n12, int n13, boolean bl2, boolean bl3, boolean bl4) {
        this.notificationBuilder.setSmallIcon(n10);
        Object object2 = this.notificationBuilder;
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = null;
        object = n11 == 0 ? null : object.getResources().getString(n11);
        ((NotificationCompat$Builder)object2).setContentTitle((CharSequence)object);
        this.notificationBuilder.setContentIntent(pendingIntent);
        object = this.notificationBuilder;
        if (string2 != null) {
            object2 = new NotificationCompat$BigTextStyle();
            notificationCompat$BigTextStyle = ((NotificationCompat$BigTextStyle)object2).bigText(string2);
        }
        ((NotificationCompat$Builder)object).setStyle(notificationCompat$BigTextStyle);
        this.notificationBuilder.setProgress(n12, n13, bl2);
        this.notificationBuilder.setOngoing(bl3);
        this.notificationBuilder.setShowWhen(bl4);
        return this.notificationBuilder.build();
    }

    public Notification buildDownloadCompletedNotification(Context context, int n10, PendingIntent pendingIntent, String string2) {
        int n11 = R$string.exo_download_completed;
        return this.buildEndStateNotification(context, n10, pendingIntent, string2, n11);
    }

    public Notification buildDownloadFailedNotification(Context context, int n10, PendingIntent pendingIntent, String string2) {
        int n11 = R$string.exo_download_failed;
        return this.buildEndStateNotification(context, n10, pendingIntent, string2, n11);
    }

    /*
     * Unable to fully structure code
     */
    public Notification buildProgressNotification(Context var1_1, int var2_2, PendingIntent var3_3, String var4_4, List var5_5) {
        var6_6 = 1;
        var7_7 = 1.4E-45f;
        var8_8 = 0;
        var9_9 = 0.0f;
        var10_10 = var6_6;
        var12_12 = 0.0f;
        var13_13 = 0;
        var14_14 = 0.0f;
        var15_15 = 0;
        var16_16 = 0;
        var17_17 = 0;
        for (var11_11 = 0; var11_11 < (var18_18 = var5_5.size()); ++var11_11) {
            var19_19 = (Download)var5_5.get(var11_11);
            var20_20 = var19_19.state;
            var21_21 = 5;
            if (var20_20 == var21_21) {
                var15_15 = var6_6;
                continue;
            }
            var21_21 = 7;
            if (var20_20 != var21_21 && var20_20 != (var21_21 = 2)) continue;
            var14_14 = var19_19.getPercentDownloaded();
            cfr_temp_0 = var14_14 - (var22_22 = -1.0f);
            var20_20 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
            if (var20_20 != 0) {
                var9_9 += var14_14;
                var10_10 = 0;
            }
            if ((var13_13 = (cfr_temp_1 = (var23_23 = var19_19.getBytesDownloaded()) - (var25_24 = 0L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) > 0) {
                var13_13 = var6_6;
                var14_14 = var7_7;
            } else {
                var13_13 = 0;
                var14_14 = 0.0f;
            }
            var17_17 |= var13_13;
            ++var16_16;
            var13_13 = var6_6;
            var14_14 = var7_7;
        }
        if (var13_13 != 0) {
            var11_11 = R$string.exo_download_downloading;
lbl40:
            // 2 sources

            while (true) {
                var27_25 = var11_11;
                break;
            }
        } else {
            if (var15_15 != 0) {
                var11_11 = R$string.exo_download_removing;
                ** continue;
            }
            var27_25 = 0;
        }
        if (var13_13 != 0) {
            var12_12 = var16_16;
            var8_8 = (int)(var9_9 /= var12_12);
            if (var10_10 == 0 || var17_17 == 0) {
                var6_6 = 0;
                var7_7 = 0.0f;
            }
            var28_26 = var6_6;
            var29_27 = var8_8;
        } else {
            var28_26 = var6_6;
            var29_27 = 0;
        }
        var19_19 = var1_1;
        var20_20 = var2_2;
        return this.buildNotification(var1_1, var2_2, var3_3, var4_4, var27_25, 100, var29_27, (boolean)var28_26, true, false);
    }
}

