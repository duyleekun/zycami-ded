/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigPictureStyle
 *  android.graphics.drawable.Icon
 */
package androidx.core.app;

import android.app.Notification;
import android.graphics.drawable.Icon;

public class NotificationCompat$BigPictureStyle$Api23Impl {
    private NotificationCompat$BigPictureStyle$Api23Impl() {
    }

    public static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
        bigPictureStyle.bigLargeIcon(icon);
    }
}

