/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.google.android.exoplayer2.ui;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$1;

public final class PlayerNotificationManager$BitmapCallback {
    private final int notificationTag;
    public final /* synthetic */ PlayerNotificationManager this$0;

    private PlayerNotificationManager$BitmapCallback(PlayerNotificationManager playerNotificationManager, int n10) {
        this.this$0 = playerNotificationManager;
        this.notificationTag = n10;
    }

    public /* synthetic */ PlayerNotificationManager$BitmapCallback(PlayerNotificationManager playerNotificationManager, int n10, PlayerNotificationManager$1 playerNotificationManager$1) {
        this(playerNotificationManager, n10);
    }

    public void onBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            PlayerNotificationManager playerNotificationManager = this.this$0;
            int n10 = this.notificationTag;
            PlayerNotificationManager.access$000(playerNotificationManager, bitmap, n10);
        }
    }
}

