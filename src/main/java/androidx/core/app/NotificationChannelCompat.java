/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.Settings$System
 */
package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.NotificationChannelCompat$Builder;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    public AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    public String mConversationId;
    public String mDescription;
    public String mGroupId;
    public final String mId;
    public int mImportance;
    private boolean mImportantConversation;
    public int mLightColor;
    public boolean mLights;
    private int mLockscreenVisibility;
    public CharSequence mName;
    public String mParentId;
    public boolean mShowBadge;
    public Uri mSound;
    public boolean mVibrationEnabled;
    public long[] mVibrationPattern;

    public NotificationChannelCompat(NotificationChannel notificationChannel) {
        int n10;
        int n11;
        Object object = notificationChannel.getId();
        int n12 = notificationChannel.getImportance();
        this((String)object, n12);
        object = notificationChannel.getName();
        this.mName = object;
        object = notificationChannel.getDescription();
        this.mDescription = object;
        object = notificationChannel.getGroup();
        this.mGroupId = object;
        this.mShowBadge = n11 = notificationChannel.canShowBadge();
        object = notificationChannel.getSound();
        this.mSound = object;
        object = notificationChannel.getAudioAttributes();
        this.mAudioAttributes = object;
        this.mLights = n11 = notificationChannel.shouldShowLights();
        this.mLightColor = n11 = notificationChannel.getLightColor();
        n11 = (int)(notificationChannel.shouldVibrate() ? 1 : 0);
        this.mVibrationEnabled = n11;
        object = notificationChannel.getVibrationPattern();
        this.mVibrationPattern = (long[])object;
        n11 = Build.VERSION.SDK_INT;
        n12 = 30;
        if (n11 >= n12) {
            String string2;
            this.mParentId = string2 = notificationChannel.getParentChannelId();
            this.mConversationId = string2 = notificationChannel.getConversationId();
        }
        this.mBypassDnd = n10 = notificationChannel.canBypassDnd();
        this.mLockscreenVisibility = n10 = notificationChannel.getLockscreenVisibility();
        n10 = 29;
        if (n11 >= n10) {
            n10 = (int)(notificationChannel.canBubble() ? 1 : 0);
            this.mCanBubble = n10;
        }
        if (n11 >= n12) {
            boolean bl2;
            this.mImportantConversation = bl2 = notificationChannel.isImportantConversation();
        }
    }

    public NotificationChannelCompat(String string2, int n10) {
        Uri uri;
        this.mShowBadge = true;
        this.mSound = uri = Settings.System.DEFAULT_NOTIFICATION_URI;
        uri = null;
        this.mLightColor = 0;
        this.mId = string2 = (String)Preconditions.checkNotNull(string2);
        this.mImportance = n10;
        int n11 = Build.VERSION.SDK_INT;
        n10 = 21;
        if (n11 >= n10) {
            string2 = Notification.AUDIO_ATTRIBUTES_DEFAULT;
            this.mAudioAttributes = string2;
        }
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public NotificationChannel getNotificationChannel() {
        String string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return null;
        }
        Object object = this.mId;
        CharSequence charSequence = this.mName;
        int n12 = this.mImportance;
        NotificationChannel notificationChannel = new NotificationChannel((String)object, charSequence, n12);
        object = this.mDescription;
        notificationChannel.setDescription((String)object);
        object = this.mGroupId;
        notificationChannel.setGroup((String)object);
        int n13 = this.mShowBadge;
        notificationChannel.setShowBadge(n13 != 0);
        object = this.mSound;
        charSequence = this.mAudioAttributes;
        notificationChannel.setSound((Uri)object, (AudioAttributes)charSequence);
        n13 = this.mLights;
        notificationChannel.enableLights(n13 != 0);
        n13 = this.mLightColor;
        notificationChannel.setLightColor(n13);
        object = this.mVibrationPattern;
        notificationChannel.setVibrationPattern((long[])object);
        n13 = (int)(this.mVibrationEnabled ? 1 : 0);
        notificationChannel.enableVibration(n13 != 0);
        n13 = 30;
        if (n10 >= n13 && (string2 = this.mParentId) != null && (object = this.mConversationId) != null) {
            notificationChannel.setConversationId(string2, (String)object);
        }
        return notificationChannel;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public NotificationChannelCompat$Builder toBuilder() {
        Object object = this.mId;
        int n10 = this.mImportance;
        NotificationChannelCompat$Builder notificationChannelCompat$Builder = new NotificationChannelCompat$Builder((String)object, n10);
        object = this.mName;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setName((CharSequence)object);
        object = this.mDescription;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setDescription((String)object);
        object = this.mGroupId;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setGroup((String)object);
        boolean bl2 = this.mShowBadge;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setShowBadge(bl2);
        object = this.mSound;
        Object object2 = this.mAudioAttributes;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setSound((Uri)object, (AudioAttributes)object2);
        boolean bl3 = this.mLights;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setLightsEnabled(bl3);
        int n11 = this.mLightColor;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setLightColor(n11);
        boolean bl4 = this.mVibrationEnabled;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setVibrationEnabled(bl4);
        object = this.mVibrationPattern;
        notificationChannelCompat$Builder = notificationChannelCompat$Builder.setVibrationPattern((long[])object);
        object = this.mParentId;
        object2 = this.mConversationId;
        return notificationChannelCompat$Builder.setConversationId((String)object, (String)object2);
    }
}

