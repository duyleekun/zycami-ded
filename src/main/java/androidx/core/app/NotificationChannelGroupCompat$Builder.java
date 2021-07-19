/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.app;

import androidx.core.app.NotificationChannelGroupCompat;

public class NotificationChannelGroupCompat$Builder {
    public final NotificationChannelGroupCompat mGroup;

    public NotificationChannelGroupCompat$Builder(String string2) {
        NotificationChannelGroupCompat notificationChannelGroupCompat;
        this.mGroup = notificationChannelGroupCompat = new NotificationChannelGroupCompat(string2);
    }

    public NotificationChannelGroupCompat build() {
        return this.mGroup;
    }

    public NotificationChannelGroupCompat$Builder setDescription(String string2) {
        this.mGroup.mDescription = string2;
        return this;
    }

    public NotificationChannelGroupCompat$Builder setName(CharSequence charSequence) {
        this.mGroup.mName = charSequence;
        return this;
    }
}

