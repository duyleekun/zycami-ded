/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.graphics.Bitmap
 */
package com.google.android.exoplayer2.ui;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$BitmapCallback;

public interface PlayerNotificationManager$MediaDescriptionAdapter {
    public PendingIntent createCurrentContentIntent(Player var1);

    public CharSequence getCurrentContentText(Player var1);

    public CharSequence getCurrentContentTitle(Player var1);

    public Bitmap getCurrentLargeIcon(Player var1, PlayerNotificationManager$BitmapCallback var2);

    default public CharSequence getCurrentSubText(Player player) {
        return null;
    }
}

