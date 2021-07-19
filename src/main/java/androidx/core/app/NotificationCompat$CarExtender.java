/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.app.RemoteInput
 *  android.app.RemoteInput$Builder
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$CarExtender$UnreadConversation;
import androidx.core.app.NotificationCompat$Extender;
import androidx.core.app.RemoteInput;

public final class NotificationCompat$CarExtender
implements NotificationCompat$Extender {
    public static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";
    public static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";
    private int mColor;
    private Bitmap mLargeIcon;
    private NotificationCompat$CarExtender$UnreadConversation mUnreadConversation;

    public NotificationCompat$CarExtender() {
        this.mColor = 0;
    }

    public NotificationCompat$CarExtender(Notification object) {
        int n10 = 0;
        String string2 = null;
        this.mColor = 0;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 < n12) {
            return;
        }
        Object object2 = NotificationCompat.getExtras(object);
        if (object2 == null) {
            object = null;
        } else {
            object = NotificationCompat.getExtras(object);
            object2 = EXTRA_CAR_EXTENDER;
            object = object.getBundle((String)object2);
        }
        if (object != null) {
            object2 = (Bitmap)object.getParcelable(EXTRA_LARGE_ICON);
            this.mLargeIcon = object2;
            object2 = EXTRA_COLOR;
            this.mColor = n10 = object.getInt((String)object2, 0);
            string2 = EXTRA_CONVERSATION;
            object = NotificationCompat$CarExtender.getUnreadConversationFromBundle(object.getBundle(string2));
            this.mUnreadConversation = object;
        }
    }

    private static Bundle getBundleForUnreadConversation(NotificationCompat$CarExtender$UnreadConversation notificationCompat$CarExtender$UnreadConversation) {
        int n10;
        int n11;
        Bundle bundle = new Bundle();
        Bundle bundle2 = notificationCompat$CarExtender$UnreadConversation.getParticipants();
        int n12 = 0;
        Object object = null;
        if (bundle2 != null && (n11 = ((String[])(bundle2 = notificationCompat$CarExtender$UnreadConversation.getParticipants())).length) > (n10 = 1)) {
            bundle2 = notificationCompat$CarExtender$UnreadConversation.getParticipants()[0];
        } else {
            n11 = 0;
            bundle2 = null;
        }
        CharSequence[] charSequenceArray = notificationCompat$CarExtender$UnreadConversation.getMessages();
        n10 = charSequenceArray.length;
        Parcelable[] parcelableArray = new Parcelable[n10];
        while (n12 < n10) {
            Bundle bundle3 = new Bundle();
            String string2 = notificationCompat$CarExtender$UnreadConversation.getMessages()[n12];
            String string3 = KEY_TEXT;
            bundle3.putString(string3, string2);
            string2 = KEY_AUTHOR;
            bundle3.putString(string2, (String)bundle2);
            parcelableArray[n12] = bundle3;
            n12 += 1;
        }
        bundle.putParcelableArray(KEY_MESSAGES, parcelableArray);
        bundle2 = notificationCompat$CarExtender$UnreadConversation.getRemoteInput();
        if (bundle2 != null) {
            charSequenceArray = bundle2.getResultKey();
            object = new RemoteInput.Builder((String)charSequenceArray);
            charSequenceArray = bundle2.getLabel();
            object = object.setLabel((CharSequence)charSequenceArray);
            charSequenceArray = bundle2.getChoices();
            object = object.setChoices(charSequenceArray);
            n10 = (int)(bundle2.getAllowFreeFormInput() ? 1 : 0);
            object = object.setAllowFreeFormInput(n10 != 0);
            bundle2 = bundle2.getExtras();
            bundle2 = object.addExtras(bundle2).build();
            object = KEY_REMOTE_INPUT;
            bundle.putParcelable((String)object, (Parcelable)bundle2);
        }
        bundle2 = notificationCompat$CarExtender$UnreadConversation.getReplyPendingIntent();
        bundle.putParcelable(KEY_ON_REPLY, (Parcelable)bundle2);
        bundle2 = notificationCompat$CarExtender$UnreadConversation.getReadPendingIntent();
        bundle.putParcelable(KEY_ON_READ, (Parcelable)bundle2);
        bundle2 = notificationCompat$CarExtender$UnreadConversation.getParticipants();
        bundle.putStringArray(KEY_PARTICIPANTS, (String[])bundle2);
        long l10 = notificationCompat$CarExtender$UnreadConversation.getLatestTimestamp();
        bundle.putLong(KEY_TIMESTAMP, l10);
        return bundle;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static NotificationCompat$CarExtender$UnreadConversation getUnreadConversationFromBundle(Bundle bundle) {
        void var9_22;
        Parcelable parcelable;
        Parcelable parcelable2;
        Object object;
        int n10;
        Bundle bundle2 = bundle;
        Object object2 = null;
        if (bundle == null) {
            return null;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_MESSAGES);
        int n11 = 1;
        int n12 = 0;
        if (parcelableArray == null) {
            boolean bl2 = false;
            Object var9_21 = null;
        } else {
            int n13;
            String[] stringArray;
            block8: {
                n10 = parcelableArray.length;
                stringArray = new String[n10];
                for (int i10 = 0; i10 < n10; ++i10) {
                    Parcelable parcelable3 = parcelableArray[i10];
                    boolean bl3 = parcelable3 instanceof Bundle;
                    if (bl3) {
                        String string2;
                        Bundle bundle3 = (Bundle)parcelableArray[i10];
                        object = KEY_TEXT;
                        stringArray[i10] = string2 = bundle3.getString((String)object);
                        String string3 = stringArray[i10];
                        if (string3 != null) continue;
                    }
                    n13 = 0;
                    Object var3_4 = null;
                    break block8;
                }
                n13 = n11;
            }
            if (n13 == 0) return null;
            String[] stringArray2 = stringArray;
        }
        Parcelable parcelable4 = parcelable2 = bundle2.getParcelable(KEY_ON_READ);
        parcelable4 = (PendingIntent)parcelable2;
        Parcelable parcelable5 = parcelable = bundle2.getParcelable(KEY_ON_REPLY);
        parcelable5 = (PendingIntent)parcelable;
        android.app.RemoteInput remoteInput = (android.app.RemoteInput)bundle2.getParcelable(KEY_REMOTE_INPUT);
        String string4 = KEY_PARTICIPANTS;
        String[] stringArray = bundle2.getStringArray(string4);
        if (stringArray == null) return object2;
        n10 = stringArray.length;
        if (n10 != n11) {
            return object2;
        }
        if (remoteInput != null) {
            String string5 = remoteInput.getResultKey();
            CharSequence charSequence = remoteInput.getLabel();
            CharSequence[] charSequenceArray = remoteInput.getChoices();
            boolean bl4 = remoteInput.getAllowFreeFormInput();
            n11 = Build.VERSION.SDK_INT;
            n10 = 29;
            if (n11 >= n10) {
                n12 = remoteInput.getEditChoicesBeforeSending();
            }
            Bundle bundle4 = remoteInput.getExtras();
            object2 = new RemoteInput(string5, charSequence, charSequenceArray, bl4, n12, bundle4, null);
        }
        object = object2;
        String string6 = KEY_TIMESTAMP;
        long l10 = bundle2.getLong(string6);
        return new NotificationCompat$CarExtender$UnreadConversation((String[])var9_22, (RemoteInput)object, (PendingIntent)parcelable5, (PendingIntent)parcelable4, stringArray, l10);
    }

    public NotificationCompat$Builder extend(NotificationCompat$Builder notificationCompat$Builder) {
        String string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            return notificationCompat$Builder;
        }
        Bundle bundle = new Bundle();
        Object object = this.mLargeIcon;
        if (object != null) {
            string2 = EXTRA_LARGE_ICON;
            bundle.putParcelable(string2, (Parcelable)object);
        }
        if ((n11 = this.mColor) != 0) {
            string2 = EXTRA_COLOR;
            bundle.putInt(string2, n11);
        }
        if ((object = this.mUnreadConversation) != null) {
            object = NotificationCompat$CarExtender.getBundleForUnreadConversation((NotificationCompat$CarExtender$UnreadConversation)object);
            string2 = EXTRA_CONVERSATION;
            bundle.putBundle(string2, (Bundle)object);
        }
        notificationCompat$Builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
        return notificationCompat$Builder;
    }

    public int getColor() {
        return this.mColor;
    }

    public Bitmap getLargeIcon() {
        return this.mLargeIcon;
    }

    public NotificationCompat$CarExtender$UnreadConversation getUnreadConversation() {
        return this.mUnreadConversation;
    }

    public NotificationCompat$CarExtender setColor(int n10) {
        this.mColor = n10;
        return this;
    }

    public NotificationCompat$CarExtender setLargeIcon(Bitmap bitmap) {
        this.mLargeIcon = bitmap;
        return this;
    }

    public NotificationCompat$CarExtender setUnreadConversation(NotificationCompat$CarExtender$UnreadConversation notificationCompat$CarExtender$UnreadConversation) {
        this.mUnreadConversation = notificationCompat$CarExtender$UnreadConversation;
        return this;
    }
}

