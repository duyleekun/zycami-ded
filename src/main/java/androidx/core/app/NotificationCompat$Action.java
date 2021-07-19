/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;

public class NotificationCompat$Action {
    public static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
    public static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
    public static final int SEMANTIC_ACTION_ARCHIVE = 5;
    public static final int SEMANTIC_ACTION_CALL = 10;
    public static final int SEMANTIC_ACTION_DELETE = 4;
    public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
    public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
    public static final int SEMANTIC_ACTION_MUTE = 6;
    public static final int SEMANTIC_ACTION_NONE = 0;
    public static final int SEMANTIC_ACTION_REPLY = 1;
    public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
    public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
    public static final int SEMANTIC_ACTION_UNMUTE = 7;
    public PendingIntent actionIntent;
    public int icon;
    private boolean mAllowGeneratedReplies;
    private final RemoteInput[] mDataOnlyRemoteInputs;
    public final Bundle mExtras;
    private IconCompat mIcon;
    private final boolean mIsContextual;
    private final RemoteInput[] mRemoteInputs;
    private final int mSemanticAction;
    public boolean mShowsUserInterface;
    public CharSequence title;

    public NotificationCompat$Action(int n10, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat iconCompat = null;
        if (n10 != 0) {
            String string2 = "";
            iconCompat = IconCompat.createWithResource(null, string2, n10);
        }
        this(iconCompat, charSequence, pendingIntent);
    }

    public NotificationCompat$Action(int n10, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, RemoteInput[] remoteInputArray2, boolean bl2, int n11, boolean bl3, boolean bl4) {
        Object object;
        IconCompat iconCompat = null;
        if (n10 != 0) {
            object = "";
            iconCompat = IconCompat.createWithResource(null, (String)object, n10);
        }
        object = this;
        this(iconCompat, charSequence, pendingIntent, bundle, remoteInputArray, remoteInputArray2, bl2, n11, bl3, bl4);
    }

    public NotificationCompat$Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        this(iconCompat, charSequence, pendingIntent, bundle, null, null, true, 0, true, false);
    }

    public NotificationCompat$Action(IconCompat object, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, RemoteInput[] remoteInputArray2, boolean bl2, int n10, boolean bl3, boolean bl4) {
        int n11;
        int n12;
        this.mShowsUserInterface = n12 = 1;
        this.mIcon = object;
        if (object != null && (n12 = ((IconCompat)object).getType()) == (n11 = 2)) {
            int n13;
            this.icon = n13 = ((IconCompat)object).getResId();
        }
        this.title = object = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = pendingIntent;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.mExtras = bundle;
        this.mRemoteInputs = remoteInputArray;
        this.mDataOnlyRemoteInputs = remoteInputArray2;
        this.mAllowGeneratedReplies = bl2;
        this.mSemanticAction = n10;
        this.mShowsUserInterface = bl3;
        this.mIsContextual = bl4;
    }

    public PendingIntent getActionIntent() {
        return this.actionIntent;
    }

    public boolean getAllowGeneratedReplies() {
        return this.mAllowGeneratedReplies;
    }

    public RemoteInput[] getDataOnlyRemoteInputs() {
        return this.mDataOnlyRemoteInputs;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getIcon() {
        return this.icon;
    }

    public IconCompat getIconCompat() {
        int n10;
        IconCompat iconCompat = this.mIcon;
        if (iconCompat == null && (n10 = this.icon) != 0) {
            String string2 = "";
            this.mIcon = iconCompat = IconCompat.createWithResource(null, string2, n10);
        }
        return this.mIcon;
    }

    public RemoteInput[] getRemoteInputs() {
        return this.mRemoteInputs;
    }

    public int getSemanticAction() {
        return this.mSemanticAction;
    }

    public boolean getShowsUserInterface() {
        return this.mShowsUserInterface;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public boolean isContextual() {
        return this.mIsContextual;
    }
}

