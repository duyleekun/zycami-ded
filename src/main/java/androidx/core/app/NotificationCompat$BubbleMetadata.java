/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BubbleMetadata
 *  android.app.PendingIntent
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import androidx.core.app.NotificationCompat$1;
import androidx.core.app.NotificationCompat$BubbleMetadata$Api29Impl;
import androidx.core.app.NotificationCompat$BubbleMetadata$Api30Impl;
import androidx.core.graphics.drawable.IconCompat;

public final class NotificationCompat$BubbleMetadata {
    private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
    private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
    private PendingIntent mDeleteIntent;
    private int mDesiredHeight;
    private int mDesiredHeightResId;
    private int mFlags;
    private IconCompat mIcon;
    private PendingIntent mPendingIntent;
    private String mShortcutId;

    private NotificationCompat$BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int n10, int n11, int n12, String string2) {
        this.mPendingIntent = pendingIntent;
        this.mIcon = iconCompat;
        this.mDesiredHeight = n10;
        this.mDesiredHeightResId = n11;
        this.mDeleteIntent = pendingIntent2;
        this.mFlags = n12;
        this.mShortcutId = string2;
    }

    public /* synthetic */ NotificationCompat$BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int n10, int n11, int n12, String string2, NotificationCompat$1 notificationCompat$1) {
        this(pendingIntent, pendingIntent2, iconCompat, n10, n11, n12, string2);
    }

    public static NotificationCompat$BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
        if (bubbleMetadata == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            return NotificationCompat$BubbleMetadata$Api30Impl.fromPlatform(bubbleMetadata);
        }
        n11 = 29;
        if (n10 == n11) {
            return NotificationCompat$BubbleMetadata$Api29Impl.fromPlatform(bubbleMetadata);
        }
        return null;
    }

    public static Notification.BubbleMetadata toPlatform(NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata) {
        if (notificationCompat$BubbleMetadata == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            return NotificationCompat$BubbleMetadata$Api30Impl.toPlatform(notificationCompat$BubbleMetadata);
        }
        n11 = 29;
        if (n10 == n11) {
            return NotificationCompat$BubbleMetadata$Api29Impl.toPlatform(notificationCompat$BubbleMetadata);
        }
        return null;
    }

    public boolean getAutoExpandBubble() {
        int n10 = this.mFlags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public PendingIntent getDeleteIntent() {
        return this.mDeleteIntent;
    }

    public int getDesiredHeight() {
        return this.mDesiredHeight;
    }

    public int getDesiredHeightResId() {
        return this.mDesiredHeightResId;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    public String getShortcutId() {
        return this.mShortcutId;
    }

    public boolean isNotificationSuppressed() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void setFlags(int n10) {
        this.mFlags = n10;
    }
}

