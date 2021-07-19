/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$Action$Builder
 *  android.app.PendingIntent
 *  android.app.RemoteInput
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Extender;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class NotificationCompat$WearableExtender
implements NotificationCompat$Extender {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 0x800005;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";
    public static final int SCREEN_TIMEOUT_LONG = 255;
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = 255;
    private ArrayList mActions;
    private Bitmap mBackground;
    private String mBridgeTag;
    private int mContentActionIndex;
    private int mContentIcon;
    private int mContentIconGravity;
    private int mCustomContentHeight;
    private int mCustomSizePreset;
    private String mDismissalId;
    private PendingIntent mDisplayIntent;
    private int mFlags;
    private int mGravity;
    private int mHintScreenTimeout;
    private ArrayList mPages;

    public NotificationCompat$WearableExtender() {
        ArrayList arrayList;
        this.mActions = arrayList = new ArrayList();
        this.mFlags = 1;
        this.mPages = arrayList = new ArrayList();
        this.mContentIconGravity = 0x800005;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
    }

    public NotificationCompat$WearableExtender(Notification object) {
        Object object2;
        int n10;
        int n11;
        int n12;
        ArrayList arrayList;
        int n13;
        ArrayList arrayList2;
        int n14 = Build.VERSION.SDK_INT;
        this.mActions = arrayList2 = new ArrayList();
        this.mFlags = n13 = 1;
        this.mPages = arrayList = new ArrayList();
        this.mContentIconGravity = n12 = 0x800005;
        this.mContentActionIndex = n11 = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = n10 = 80;
        object = NotificationCompat.getExtras(object);
        if (object != null) {
            object2 = EXTRA_WEARABLE_EXTENSIONS;
            object = object.getBundle((String)object2);
        } else {
            object = null;
        }
        if (object != null) {
            Object object3;
            object2 = object.getParcelableArrayList(KEY_ACTIONS);
            int n15 = 16;
            if (n14 >= n15 && object2 != null) {
                int n16 = ((ArrayList)object2).size();
                NotificationCompat$Action[] notificationCompat$ActionArray = new NotificationCompat$Action[n16];
                for (int i10 = 0; i10 < n16; ++i10) {
                    NotificationCompat$Action notificationCompat$Action;
                    int n17 = 20;
                    if (n14 >= n17) {
                        notificationCompat$ActionArray[i10] = notificationCompat$Action = NotificationCompat.getActionCompatFromAction((Notification.Action)((ArrayList)object2).get(i10));
                        continue;
                    }
                    if (n14 < n15) continue;
                    notificationCompat$ActionArray[i10] = notificationCompat$Action = NotificationCompatJellybean.getActionFromBundle((Bundle)((ArrayList)object2).get(i10));
                }
                object3 = this.mActions;
                Collections.addAll(object3, notificationCompat$ActionArray);
            }
            this.mFlags = n14 = object.getInt(KEY_FLAGS, n13);
            object3 = (PendingIntent)object.getParcelable(KEY_DISPLAY_INTENT);
            this.mDisplayIntent = object3;
            object3 = NotificationCompat.getNotificationArrayFromBundle((Bundle)object, KEY_PAGES);
            if (object3 != null) {
                arrayList2 = this.mPages;
                Collections.addAll(arrayList2, object3);
            }
            this.mBackground = object3 = (Bitmap)object.getParcelable(KEY_BACKGROUND);
            this.mContentIcon = n14 = object.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = n14 = object.getInt(KEY_CONTENT_ICON_GRAVITY, n12);
            this.mContentActionIndex = n14 = object.getInt(KEY_CONTENT_ACTION_INDEX, n11);
            this.mCustomSizePreset = n14 = object.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = n14 = object.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = n14 = object.getInt(KEY_GRAVITY, n10);
            this.mHintScreenTimeout = n14 = object.getInt(KEY_HINT_SCREEN_TIMEOUT);
            object3 = object.getString(KEY_DISMISSAL_ID);
            this.mDismissalId = object3;
            object3 = KEY_BRIDGE_TAG;
            object = object.getString((String)object3);
            this.mBridgeTag = object;
        }
    }

    private static Notification.Action getActionFromActionCompat(NotificationCompat$Action remoteInputArray) {
        int n10;
        Notification.Action.Builder builder;
        Object object;
        CharSequence charSequence;
        Object object2;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 0;
        int n13 = 23;
        if (n11 >= n13) {
            object2 = remoteInputArray.getIconCompat();
            if (object2 == null) {
                n13 = 0;
                object2 = null;
            } else {
                object2 = ((IconCompat)object2).toIcon();
            }
            charSequence = remoteInputArray.getTitle();
            object = remoteInputArray.getActionIntent();
            builder = new Notification.Action.Builder((Icon)object2, charSequence, object);
        } else {
            int n14;
            object2 = remoteInputArray.getIconCompat();
            if (object2 != null && (n14 = ((IconCompat)object2).getType()) == (n10 = 2)) {
                n13 = ((IconCompat)object2).getResId();
            } else {
                n13 = 0;
                object2 = null;
            }
            charSequence = remoteInputArray.getTitle();
            object = remoteInputArray.getActionIntent();
            builder = new Notification.Action.Builder(n13, charSequence, object);
        }
        object2 = remoteInputArray.getExtras();
        if (object2 != null) {
            charSequence = remoteInputArray.getExtras();
            object2 = new Bundle((Bundle)charSequence);
        } else {
            object2 = new Bundle();
        }
        n10 = (int)(remoteInputArray.getAllowGeneratedReplies() ? 1 : 0);
        object = "android.support.allowGeneratedReplies";
        object2.putBoolean((String)object, n10 != 0);
        n10 = 24;
        if (n11 >= n10) {
            n11 = (int)(remoteInputArray.getAllowGeneratedReplies() ? 1 : 0);
            builder.setAllowGeneratedReplies(n11 != 0);
        }
        builder.addExtras((Bundle)object2);
        remoteInputArray = remoteInputArray.getRemoteInputs();
        if (remoteInputArray != null) {
            remoteInputArray = RemoteInput.fromCompat(remoteInputArray);
            n11 = remoteInputArray.length;
            while (n12 < n11) {
                object2 = remoteInputArray[n12];
                builder.addRemoteInput((android.app.RemoteInput)object2);
                ++n12;
            }
        }
        return builder.build();
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

    public NotificationCompat$WearableExtender addAction(NotificationCompat$Action notificationCompat$Action) {
        this.mActions.add(notificationCompat$Action);
        return this;
    }

    public NotificationCompat$WearableExtender addActions(List list) {
        this.mActions.addAll(list);
        return this;
    }

    public NotificationCompat$WearableExtender addPage(Notification notification) {
        this.mPages.add(notification);
        return this;
    }

    public NotificationCompat$WearableExtender addPages(List list) {
        this.mPages.addAll(list);
        return this;
    }

    public NotificationCompat$WearableExtender clearActions() {
        this.mActions.clear();
        return this;
    }

    public NotificationCompat$WearableExtender clearPages() {
        this.mPages.clear();
        return this;
    }

    public NotificationCompat$WearableExtender clone() {
        int n10;
        Object object;
        NotificationCompat$WearableExtender notificationCompat$WearableExtender = new NotificationCompat$WearableExtender();
        ArrayList arrayList = this.mActions;
        notificationCompat$WearableExtender.mActions = object = new ArrayList(arrayList);
        notificationCompat$WearableExtender.mFlags = n10 = this.mFlags;
        notificationCompat$WearableExtender.mDisplayIntent = object = this.mDisplayIntent;
        arrayList = this.mPages;
        object = new ArrayList(arrayList);
        notificationCompat$WearableExtender.mPages = object;
        object = this.mBackground;
        notificationCompat$WearableExtender.mBackground = object;
        notificationCompat$WearableExtender.mContentIcon = n10 = this.mContentIcon;
        notificationCompat$WearableExtender.mContentIconGravity = n10 = this.mContentIconGravity;
        notificationCompat$WearableExtender.mContentActionIndex = n10 = this.mContentActionIndex;
        notificationCompat$WearableExtender.mCustomSizePreset = n10 = this.mCustomSizePreset;
        notificationCompat$WearableExtender.mCustomContentHeight = n10 = this.mCustomContentHeight;
        notificationCompat$WearableExtender.mGravity = n10 = this.mGravity;
        notificationCompat$WearableExtender.mHintScreenTimeout = n10 = this.mHintScreenTimeout;
        object = this.mDismissalId;
        notificationCompat$WearableExtender.mDismissalId = object;
        object = this.mBridgeTag;
        notificationCompat$WearableExtender.mBridgeTag = object;
        return notificationCompat$WearableExtender;
    }

    public NotificationCompat$Builder extend(NotificationCompat$Builder notificationCompat$Builder) {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        Bundle bundle = new Bundle();
        Object object2 = this.mActions;
        int n11 = object2.isEmpty();
        if (n11 == 0) {
            object2 = KEY_ACTIONS;
            int n12 = 16;
            if (n10 >= n12) {
                boolean bl2;
                int n13 = this.mActions.size();
                ArrayList<NotificationCompat$Action> arrayList = new ArrayList<NotificationCompat$Action>(n13);
                Iterator iterator2 = this.mActions.iterator();
                while (bl2 = iterator2.hasNext()) {
                    NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action)iterator2.next();
                    int n14 = 20;
                    if (n10 >= n14) {
                        notificationCompat$Action = NotificationCompat$WearableExtender.getActionFromActionCompat(notificationCompat$Action);
                        arrayList.add(notificationCompat$Action);
                        continue;
                    }
                    if (n10 < n12) continue;
                    notificationCompat$Action = NotificationCompatJellybean.getBundleForAction(notificationCompat$Action);
                    arrayList.add(notificationCompat$Action);
                }
                bundle.putParcelableArrayList((String)object2, arrayList);
            } else {
                n10 = 0;
                object = null;
                bundle.putParcelableArrayList((String)object2, null);
            }
        }
        if ((n10 = this.mFlags) != (n11 = 1)) {
            object2 = KEY_FLAGS;
            bundle.putInt((String)object2, n10);
        }
        if ((object = this.mDisplayIntent) != null) {
            object2 = KEY_DISPLAY_INTENT;
            bundle.putParcelable((String)object2, (Parcelable)object);
        }
        if ((n10 = (int)(((ArrayList)(object = this.mPages)).isEmpty() ? 1 : 0)) == 0) {
            object = this.mPages;
            n11 = ((ArrayList)object).size();
            object2 = new Notification[n11];
            object = (Parcelable[])((ArrayList)object).toArray((T[])object2);
            object2 = KEY_PAGES;
            bundle.putParcelableArray((String)object2, (Parcelable[])object);
        }
        if ((object = this.mBackground) != null) {
            object2 = KEY_BACKGROUND;
            bundle.putParcelable((String)object2, (Parcelable)object);
        }
        if ((n10 = this.mContentIcon) != 0) {
            object2 = KEY_CONTENT_ICON;
            bundle.putInt((String)object2, n10);
        }
        if ((n10 = this.mContentIconGravity) != (n11 = 0x800005)) {
            object2 = KEY_CONTENT_ICON_GRAVITY;
            bundle.putInt((String)object2, n10);
        }
        if ((n10 = this.mContentActionIndex) != (n11 = -1)) {
            object2 = KEY_CONTENT_ACTION_INDEX;
            bundle.putInt((String)object2, n10);
        }
        if ((n10 = this.mCustomSizePreset) != 0) {
            object2 = KEY_CUSTOM_SIZE_PRESET;
            bundle.putInt((String)object2, n10);
        }
        if ((n10 = this.mCustomContentHeight) != 0) {
            object2 = KEY_CUSTOM_CONTENT_HEIGHT;
            bundle.putInt((String)object2, n10);
        }
        if ((n10 = this.mGravity) != (n11 = 80)) {
            object2 = KEY_GRAVITY;
            bundle.putInt((String)object2, n10);
        }
        if ((n10 = this.mHintScreenTimeout) != 0) {
            object2 = KEY_HINT_SCREEN_TIMEOUT;
            bundle.putInt((String)object2, n10);
        }
        if ((object = this.mDismissalId) != null) {
            object2 = KEY_DISMISSAL_ID;
            bundle.putString((String)object2, (String)object);
        }
        if ((object = this.mBridgeTag) != null) {
            object2 = KEY_BRIDGE_TAG;
            bundle.putString((String)object2, (String)object);
        }
        notificationCompat$Builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
        return notificationCompat$Builder;
    }

    public List getActions() {
        return this.mActions;
    }

    public Bitmap getBackground() {
        return this.mBackground;
    }

    public String getBridgeTag() {
        return this.mBridgeTag;
    }

    public int getContentAction() {
        return this.mContentActionIndex;
    }

    public int getContentIcon() {
        return this.mContentIcon;
    }

    public int getContentIconGravity() {
        return this.mContentIconGravity;
    }

    public boolean getContentIntentAvailableOffline() {
        int n10 = this.mFlags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int getCustomContentHeight() {
        return this.mCustomContentHeight;
    }

    public int getCustomSizePreset() {
        return this.mCustomSizePreset;
    }

    public String getDismissalId() {
        return this.mDismissalId;
    }

    public PendingIntent getDisplayIntent() {
        return this.mDisplayIntent;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public boolean getHintAmbientBigPicture() {
        int n10 = this.mFlags & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean getHintAvoidBackgroundClipping() {
        int n10 = this.mFlags & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean getHintContentIntentLaunchesActivity() {
        int n10 = this.mFlags & 0x40;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean getHintHideIcon() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int getHintScreenTimeout() {
        return this.mHintScreenTimeout;
    }

    public boolean getHintShowBackgroundOnly() {
        int n10 = this.mFlags & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public List getPages() {
        return this.mPages;
    }

    public boolean getStartScrollBottom() {
        int n10 = this.mFlags & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public NotificationCompat$WearableExtender setBackground(Bitmap bitmap) {
        this.mBackground = bitmap;
        return this;
    }

    public NotificationCompat$WearableExtender setBridgeTag(String string2) {
        this.mBridgeTag = string2;
        return this;
    }

    public NotificationCompat$WearableExtender setContentAction(int n10) {
        this.mContentActionIndex = n10;
        return this;
    }

    public NotificationCompat$WearableExtender setContentIcon(int n10) {
        this.mContentIcon = n10;
        return this;
    }

    public NotificationCompat$WearableExtender setContentIconGravity(int n10) {
        this.mContentIconGravity = n10;
        return this;
    }

    public NotificationCompat$WearableExtender setContentIntentAvailableOffline(boolean bl2) {
        this.setFlag(1, bl2);
        return this;
    }

    public NotificationCompat$WearableExtender setCustomContentHeight(int n10) {
        this.mCustomContentHeight = n10;
        return this;
    }

    public NotificationCompat$WearableExtender setCustomSizePreset(int n10) {
        this.mCustomSizePreset = n10;
        return this;
    }

    public NotificationCompat$WearableExtender setDismissalId(String string2) {
        this.mDismissalId = string2;
        return this;
    }

    public NotificationCompat$WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
        this.mDisplayIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$WearableExtender setGravity(int n10) {
        this.mGravity = n10;
        return this;
    }

    public NotificationCompat$WearableExtender setHintAmbientBigPicture(boolean bl2) {
        this.setFlag(32, bl2);
        return this;
    }

    public NotificationCompat$WearableExtender setHintAvoidBackgroundClipping(boolean bl2) {
        this.setFlag(16, bl2);
        return this;
    }

    public NotificationCompat$WearableExtender setHintContentIntentLaunchesActivity(boolean bl2) {
        this.setFlag(64, bl2);
        return this;
    }

    public NotificationCompat$WearableExtender setHintHideIcon(boolean bl2) {
        this.setFlag(2, bl2);
        return this;
    }

    public NotificationCompat$WearableExtender setHintScreenTimeout(int n10) {
        this.mHintScreenTimeout = n10;
        return this;
    }

    public NotificationCompat$WearableExtender setHintShowBackgroundOnly(boolean bl2) {
        this.setFlag(4, bl2);
        return this;
    }

    public NotificationCompat$WearableExtender setStartScrollBottom(boolean bl2) {
        this.setFlag(8, bl2);
        return this;
    }
}

