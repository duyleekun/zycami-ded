/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationChannelCompat;

public class NotificationChannelCompat$Builder {
    private final NotificationChannelCompat mChannel;

    public NotificationChannelCompat$Builder(String string2, int n10) {
        NotificationChannelCompat notificationChannelCompat;
        this.mChannel = notificationChannelCompat = new NotificationChannelCompat(string2, n10);
    }

    public NotificationChannelCompat build() {
        return this.mChannel;
    }

    public NotificationChannelCompat$Builder setConversationId(String string2, String string3) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mParentId = string2;
            notificationChannelCompat.mConversationId = string3;
        }
        return this;
    }

    public NotificationChannelCompat$Builder setDescription(String string2) {
        this.mChannel.mDescription = string2;
        return this;
    }

    public NotificationChannelCompat$Builder setGroup(String string2) {
        this.mChannel.mGroupId = string2;
        return this;
    }

    public NotificationChannelCompat$Builder setImportance(int n10) {
        this.mChannel.mImportance = n10;
        return this;
    }

    public NotificationChannelCompat$Builder setLightColor(int n10) {
        this.mChannel.mLightColor = n10;
        return this;
    }

    public NotificationChannelCompat$Builder setLightsEnabled(boolean bl2) {
        this.mChannel.mLights = bl2;
        return this;
    }

    public NotificationChannelCompat$Builder setName(CharSequence charSequence) {
        this.mChannel.mName = charSequence;
        return this;
    }

    public NotificationChannelCompat$Builder setShowBadge(boolean bl2) {
        this.mChannel.mShowBadge = bl2;
        return this;
    }

    public NotificationChannelCompat$Builder setSound(Uri uri, AudioAttributes audioAttributes) {
        NotificationChannelCompat notificationChannelCompat = this.mChannel;
        notificationChannelCompat.mSound = uri;
        notificationChannelCompat.mAudioAttributes = audioAttributes;
        return this;
    }

    public NotificationChannelCompat$Builder setVibrationEnabled(boolean bl2) {
        this.mChannel.mVibrationEnabled = bl2;
        return this;
    }

    public NotificationChannelCompat$Builder setVibrationPattern(long[] lArray) {
        int n10;
        NotificationChannelCompat notificationChannelCompat = this.mChannel;
        n10 = lArray != null && (n10 = lArray.length) > 0 ? 1 : 0;
        notificationChannelCompat.mVibrationEnabled = n10;
        notificationChannelCompat.mVibrationPattern = lArray;
        return this;
    }
}

