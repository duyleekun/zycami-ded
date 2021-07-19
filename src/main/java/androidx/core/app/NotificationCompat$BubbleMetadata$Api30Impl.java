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

public class NotificationCompat$BubbleMetadata$Api30Impl {
    private NotificationCompat$BubbleMetadata$Api30Impl() {
    }

    public static NotificationCompat$BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
        IconCompat iconCompat;
        Object object;
        if (bubbleMetadata == null) {
            return null;
        }
        Object object2 = bubbleMetadata.getShortcutId();
        if (object2 != null) {
            object = bubbleMetadata.getShortcutId();
            object2 = new NotificationCompat$BubbleMetadata$Builder((String)object);
        } else {
            object = bubbleMetadata.getIntent();
            iconCompat = IconCompat.createFromIcon(bubbleMetadata.getIcon());
            object2 = new NotificationCompat$BubbleMetadata$Builder((PendingIntent)object, iconCompat);
        }
        int n10 = bubbleMetadata.getAutoExpandBubble();
        object = ((NotificationCompat$BubbleMetadata$Builder)object2).setAutoExpandBubble(n10 != 0);
        iconCompat = bubbleMetadata.getDeleteIntent();
        object = ((NotificationCompat$BubbleMetadata$Builder)object).setDeleteIntent((PendingIntent)iconCompat);
        boolean bl2 = bubbleMetadata.isNotificationSuppressed();
        ((NotificationCompat$BubbleMetadata$Builder)object).setSuppressNotification(bl2);
        n10 = bubbleMetadata.getDesiredHeight();
        if (n10 != 0) {
            n10 = bubbleMetadata.getDesiredHeight();
            ((NotificationCompat$BubbleMetadata$Builder)object2).setDesiredHeight(n10);
        }
        if ((n10 = bubbleMetadata.getDesiredHeightResId()) != 0) {
            int n11 = bubbleMetadata.getDesiredHeightResId();
            ((NotificationCompat$BubbleMetadata$Builder)object2).setDesiredHeightResId(n11);
        }
        return ((NotificationCompat$BubbleMetadata$Builder)object2).build();
    }

    public static Notification.BubbleMetadata toPlatform(NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata) {
        String string2;
        if (notificationCompat$BubbleMetadata == null) {
            return null;
        }
        String string3 = notificationCompat$BubbleMetadata.getShortcutId();
        if (string3 != null) {
            string2 = notificationCompat$BubbleMetadata.getShortcutId();
            string3 = new Notification.BubbleMetadata.Builder(string2);
        } else {
            string2 = notificationCompat$BubbleMetadata.getIntent();
            Icon icon = notificationCompat$BubbleMetadata.getIcon().toIcon();
            string3 = new Notification.BubbleMetadata.Builder((PendingIntent)string2, icon);
        }
        string2 = notificationCompat$BubbleMetadata.getDeleteIntent();
        string2 = string3.setDeleteIntent((PendingIntent)string2);
        boolean bl2 = notificationCompat$BubbleMetadata.getAutoExpandBubble();
        string2 = string2.setAutoExpandBubble(bl2);
        bl2 = notificationCompat$BubbleMetadata.isNotificationSuppressed();
        string2.setSuppressNotification(bl2);
        int n10 = notificationCompat$BubbleMetadata.getDesiredHeight();
        if (n10 != 0) {
            n10 = notificationCompat$BubbleMetadata.getDesiredHeight();
            string3.setDesiredHeight(n10);
        }
        if ((n10 = notificationCompat$BubbleMetadata.getDesiredHeightResId()) != 0) {
            int n11 = notificationCompat$BubbleMetadata.getDesiredHeightResId();
            string3.setDesiredHeightResId(n11);
        }
        return string3.build();
    }
}

