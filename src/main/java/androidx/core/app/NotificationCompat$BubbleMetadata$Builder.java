/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.text.TextUtils
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$BubbleMetadata;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

public final class NotificationCompat$BubbleMetadata$Builder {
    private PendingIntent mDeleteIntent;
    private int mDesiredHeight;
    private int mDesiredHeightResId;
    private int mFlags;
    private IconCompat mIcon;
    private PendingIntent mPendingIntent;
    private String mShortcutId;

    public NotificationCompat$BubbleMetadata$Builder() {
    }

    public NotificationCompat$BubbleMetadata$Builder(PendingIntent pendingIntent, IconCompat iconCompat) {
        Objects.requireNonNull(pendingIntent, "Bubble requires non-null pending intent");
        Objects.requireNonNull(iconCompat, "Bubbles require non-null icon");
        this.mPendingIntent = pendingIntent;
        this.mIcon = iconCompat;
    }

    public NotificationCompat$BubbleMetadata$Builder(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.mShortcutId = object;
            return;
        }
        object = new NullPointerException("Bubble requires a non-null shortcut id");
        throw object;
    }

    private NotificationCompat$BubbleMetadata$Builder setFlag(int n10, boolean bl2) {
        if (bl2) {
            int n11 = this.mFlags;
            this.mFlags = n10 |= n11;
        } else {
            int n12 = this.mFlags;
            this.mFlags = n10 = ~n10 & n12;
        }
        return this;
    }

    public NotificationCompat$BubbleMetadata build() {
        NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata;
        String string2;
        Object object;
        String string3 = this.mShortcutId;
        if (string3 == null) {
            object = this.mPendingIntent;
            string2 = "Must supply pending intent or shortcut to bubble";
            Objects.requireNonNull(object, string2);
        }
        if (string3 == null) {
            object = this.mIcon;
            string2 = "Must supply an icon or shortcut for the bubble";
            Objects.requireNonNull(object, string2);
        }
        string2 = this.mPendingIntent;
        PendingIntent pendingIntent = this.mDeleteIntent;
        IconCompat iconCompat = this.mIcon;
        int n10 = this.mDesiredHeight;
        int n11 = this.mDesiredHeightResId;
        int n12 = this.mFlags;
        object = notificationCompat$BubbleMetadata;
        notificationCompat$BubbleMetadata = new NotificationCompat$BubbleMetadata((PendingIntent)string2, pendingIntent, iconCompat, n10, n11, n12, string3, null);
        int n13 = this.mFlags;
        notificationCompat$BubbleMetadata.setFlags(n13);
        return notificationCompat$BubbleMetadata;
    }

    public NotificationCompat$BubbleMetadata$Builder setAutoExpandBubble(boolean bl2) {
        this.setFlag(1, bl2);
        return this;
    }

    public NotificationCompat$BubbleMetadata$Builder setDeleteIntent(PendingIntent pendingIntent) {
        this.mDeleteIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$BubbleMetadata$Builder setDesiredHeight(int n10) {
        this.mDesiredHeight = n10 = Math.max(n10, 0);
        this.mDesiredHeightResId = 0;
        return this;
    }

    public NotificationCompat$BubbleMetadata$Builder setDesiredHeightResId(int n10) {
        this.mDesiredHeightResId = n10;
        this.mDesiredHeight = 0;
        return this;
    }

    public NotificationCompat$BubbleMetadata$Builder setIcon(IconCompat object) {
        String string2 = this.mShortcutId;
        if (string2 == null) {
            Objects.requireNonNull(object, "Bubbles require non-null icon");
            this.mIcon = object;
            return this;
        }
        object = new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
        throw object;
    }

    public NotificationCompat$BubbleMetadata$Builder setIntent(PendingIntent object) {
        String string2 = this.mShortcutId;
        if (string2 == null) {
            Objects.requireNonNull(object, "Bubble requires non-null pending intent");
            this.mPendingIntent = object;
            return this;
        }
        object = new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
        throw object;
    }

    public NotificationCompat$BubbleMetadata$Builder setSuppressNotification(boolean bl2) {
        this.setFlag(2, bl2);
        return this;
    }
}

