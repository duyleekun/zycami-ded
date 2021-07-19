/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Action$Builder;
import androidx.core.app.NotificationCompat$Action$Extender;

public final class NotificationCompat$Action$WearableExtender
implements NotificationCompat$Action$Extender {
    private static final int DEFAULT_FLAGS = 1;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_DISPLAY_INLINE = 4;
    private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
    private static final String KEY_CANCEL_LABEL = "cancelLabel";
    private static final String KEY_CONFIRM_LABEL = "confirmLabel";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
    private CharSequence mCancelLabel;
    private CharSequence mConfirmLabel;
    private int mFlags;
    private CharSequence mInProgressLabel;

    public NotificationCompat$Action$WearableExtender() {
        this.mFlags = 1;
    }

    public NotificationCompat$Action$WearableExtender(NotificationCompat$Action object) {
        int n10;
        this.mFlags = n10 = 1;
        object = ((NotificationCompat$Action)object).getExtras();
        String string2 = EXTRA_WEARABLE_EXTENSIONS;
        object = object.getBundle(string2);
        if (object != null) {
            CharSequence charSequence;
            string2 = KEY_FLAGS;
            this.mFlags = n10 = object.getInt(string2, n10);
            this.mInProgressLabel = charSequence = object.getCharSequence(KEY_IN_PROGRESS_LABEL);
            this.mConfirmLabel = charSequence = object.getCharSequence(KEY_CONFIRM_LABEL);
            charSequence = KEY_CANCEL_LABEL;
            this.mCancelLabel = object = object.getCharSequence((String)charSequence);
        }
    }

    private void setFlag(int n10, boolean bl2) {
        if (bl2) {
            int n11 = this.mFlags;
            this.mFlags = n10 |= n11;
        } else {
            int n12 = this.mFlags;
            this.mFlags = n10 = ~n10 & n12;
        }
    }

    public NotificationCompat$Action$WearableExtender clone() {
        CharSequence charSequence;
        int n10;
        NotificationCompat$Action$WearableExtender notificationCompat$Action$WearableExtender = new NotificationCompat$Action$WearableExtender();
        notificationCompat$Action$WearableExtender.mFlags = n10 = this.mFlags;
        notificationCompat$Action$WearableExtender.mInProgressLabel = charSequence = this.mInProgressLabel;
        notificationCompat$Action$WearableExtender.mConfirmLabel = charSequence = this.mConfirmLabel;
        notificationCompat$Action$WearableExtender.mCancelLabel = charSequence = this.mCancelLabel;
        return notificationCompat$Action$WearableExtender;
    }

    public NotificationCompat$Action$Builder extend(NotificationCompat$Action$Builder notificationCompat$Action$Builder) {
        CharSequence charSequence;
        String string2;
        Bundle bundle = new Bundle();
        int n10 = this.mFlags;
        int n11 = 1;
        if (n10 != n11) {
            string2 = KEY_FLAGS;
            bundle.putInt(string2, n10);
        }
        if ((charSequence = this.mInProgressLabel) != null) {
            string2 = KEY_IN_PROGRESS_LABEL;
            bundle.putCharSequence(string2, charSequence);
        }
        if ((charSequence = this.mConfirmLabel) != null) {
            string2 = KEY_CONFIRM_LABEL;
            bundle.putCharSequence(string2, charSequence);
        }
        if ((charSequence = this.mCancelLabel) != null) {
            string2 = KEY_CANCEL_LABEL;
            bundle.putCharSequence(string2, charSequence);
        }
        notificationCompat$Action$Builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
        return notificationCompat$Action$Builder;
    }

    public CharSequence getCancelLabel() {
        return this.mCancelLabel;
    }

    public CharSequence getConfirmLabel() {
        return this.mConfirmLabel;
    }

    public boolean getHintDisplayActionInline() {
        int n10 = this.mFlags & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean getHintLaunchesActivity() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public CharSequence getInProgressLabel() {
        return this.mInProgressLabel;
    }

    public boolean isAvailableOffline() {
        int n10 = this.mFlags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public NotificationCompat$Action$WearableExtender setAvailableOffline(boolean bl2) {
        this.setFlag(1, bl2);
        return this;
    }

    public NotificationCompat$Action$WearableExtender setCancelLabel(CharSequence charSequence) {
        this.mCancelLabel = charSequence;
        return this;
    }

    public NotificationCompat$Action$WearableExtender setConfirmLabel(CharSequence charSequence) {
        this.mConfirmLabel = charSequence;
        return this;
    }

    public NotificationCompat$Action$WearableExtender setHintDisplayActionInline(boolean bl2) {
        this.setFlag(4, bl2);
        return this;
    }

    public NotificationCompat$Action$WearableExtender setHintLaunchesActivity(boolean bl2) {
        this.setFlag(2, bl2);
        return this;
    }

    public NotificationCompat$Action$WearableExtender setInProgressLabel(CharSequence charSequence) {
        this.mInProgressLabel = charSequence;
        return this;
    }
}

