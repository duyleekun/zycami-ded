/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BubbleMetadata
 *  android.app.Notification$BubbleMetadata$Builder
 *  android.app.PendingIntent
 *  android.graphics.drawable.Icon
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import androidx.core.app.NotificationCompat$BubbleMetadata;
import androidx.core.app.NotificationCompat$BubbleMetadata$Builder;
import androidx.core.graphics.drawable.IconCompat;

public class NotificationCompat$BubbleMetadata$Api29Impl {
    private NotificationCompat$BubbleMetadata$Api29Impl() {
    }

    public static NotificationCompat$BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
        NotificationCompat$BubbleMetadata$Builder notificationCompat$BubbleMetadata$Builder = null;
        if (bubbleMetadata == null) {
            return null;
        }
        PendingIntent pendingIntent = bubbleMetadata.getIntent();
        if (pendingIntent == null) {
            return null;
        }
        pendingIntent = bubbleMetadata.getIntent();
        IconCompat iconCompat = IconCompat.createFromIcon(bubbleMetadata.getIcon());
        notificationCompat$BubbleMetadata$Builder = new NotificationCompat$BubbleMetadata$Builder(pendingIntent, iconCompat);
        int n10 = bubbleMetadata.getAutoExpandBubble();
        notificationCompat$BubbleMetadata$Builder = notificationCompat$BubbleMetadata$Builder.setAutoExpandBubble(n10 != 0);
        pendingIntent = bubbleMetadata.getDeleteIntent();
        notificationCompat$BubbleMetadata$Builder = notificationCompat$BubbleMetadata$Builder.setDeleteIntent(pendingIntent);
        n10 = bubbleMetadata.isNotificationSuppressed();
        notificationCompat$BubbleMetadata$Builder = notificationCompat$BubbleMetadata$Builder.setSuppressNotification(n10 != 0);
        n10 = bubbleMetadata.getDesiredHeight();
        if (n10 != 0) {
            n10 = bubbleMetadata.getDesiredHeight();
            notificationCompat$BubbleMetadata$Builder.setDesiredHeight(n10);
        }
        if ((n10 = bubbleMetadata.getDesiredHeightResId()) != 0) {
            int n11 = bubbleMetadata.getDesiredHeightResId();
            notificationCompat$BubbleMetadata$Builder.setDesiredHeightResId(n11);
        }
        return notificationCompat$BubbleMetadata$Builder.build();
    }

    public static Notification.BubbleMetadata toPlatform(NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata) {
        Notification.BubbleMetadata.Builder builder = null;
        if (notificationCompat$BubbleMetadata == null) {
            return null;
        }
        PendingIntent pendingIntent = notificationCompat$BubbleMetadata.getIntent();
        if (pendingIntent == null) {
            return null;
        }
        builder = new Notification.BubbleMetadata.Builder();
        pendingIntent = notificationCompat$BubbleMetadata.getIcon().toIcon();
        builder = builder.setIcon((Icon)pendingIntent);
        pendingIntent = notificationCompat$BubbleMetadata.getIntent();
        builder = builder.setIntent(pendingIntent);
        pendingIntent = notificationCompat$BubbleMetadata.getDeleteIntent();
        builder = builder.setDeleteIntent(pendingIntent);
        int n10 = notificationCompat$BubbleMetadata.getAutoExpandBubble();
        builder = builder.setAutoExpandBubble(n10 != 0);
        n10 = notificationCompat$BubbleMetadata.isNotificationSuppressed();
        builder = builder.setSuppressNotification(n10 != 0);
        n10 = notificationCompat$BubbleMetadata.getDesiredHeight();
        if (n10 != 0) {
            n10 = notificationCompat$BubbleMetadata.getDesiredHeight();
            builder.setDesiredHeight(n10);
        }
        if ((n10 = notificationCompat$BubbleMetadata.getDesiredHeightResId()) != 0) {
            int n11 = notificationCompat$BubbleMetadata.getDesiredHeightResId();
            builder.setDesiredHeightResId(n11);
        }
        return builder.build();
    }
}

