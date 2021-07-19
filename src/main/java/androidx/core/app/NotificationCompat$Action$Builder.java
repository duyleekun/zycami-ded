/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Action
 *  android.app.PendingIntent
 *  android.app.RemoteInput
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Action$Extender;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public final class NotificationCompat$Action$Builder {
    private boolean mAllowGeneratedReplies;
    private final Bundle mExtras;
    private final IconCompat mIcon;
    private final PendingIntent mIntent;
    private boolean mIsContextual;
    private ArrayList mRemoteInputs;
    private int mSemanticAction;
    private boolean mShowsUserInterface;
    private final CharSequence mTitle;

    public NotificationCompat$Action$Builder(int n10, CharSequence charSequence, PendingIntent pendingIntent) {
        Object object;
        IconCompat iconCompat = null;
        if (n10 != 0) {
            object = "";
            iconCompat = IconCompat.createWithResource(null, (String)object, n10);
        }
        Bundle bundle = new Bundle();
        object = this;
        this(iconCompat, charSequence, pendingIntent, bundle, null, true, 0, true, false);
    }

    public NotificationCompat$Action$Builder(NotificationCompat$Action notificationCompat$Action) {
        IconCompat iconCompat = notificationCompat$Action.getIconCompat();
        CharSequence charSequence = notificationCompat$Action.title;
        PendingIntent pendingIntent = notificationCompat$Action.actionIntent;
        Object object = notificationCompat$Action.mExtras;
        Bundle bundle = new Bundle(object);
        RemoteInput[] remoteInputArray = notificationCompat$Action.getRemoteInputs();
        boolean bl2 = notificationCompat$Action.getAllowGeneratedReplies();
        int n10 = notificationCompat$Action.getSemanticAction();
        boolean bl3 = notificationCompat$Action.mShowsUserInterface;
        boolean bl4 = notificationCompat$Action.isContextual();
        object = this;
        this(iconCompat, charSequence, pendingIntent, bundle, remoteInputArray, bl2, n10, bl3, bl4);
    }

    public NotificationCompat$Action$Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        this(iconCompat, charSequence, pendingIntent, bundle, null, true, 0, true, false);
    }

    private NotificationCompat$Action$Builder(IconCompat arrayList, CharSequence object, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArray, boolean bl2, int n10, boolean bl3, boolean bl4) {
        boolean bl5;
        this.mAllowGeneratedReplies = bl5 = true;
        this.mShowsUserInterface = bl5;
        this.mIcon = arrayList;
        arrayList = NotificationCompat$Builder.limitCharSequenceLength((CharSequence)object);
        this.mTitle = arrayList;
        this.mIntent = pendingIntent;
        this.mExtras = bundle;
        if (remoteInputArray == null) {
            arrayList = null;
        } else {
            object = Arrays.asList(remoteInputArray);
            arrayList = new ArrayList(object);
        }
        this.mRemoteInputs = arrayList;
        this.mAllowGeneratedReplies = bl2;
        this.mSemanticAction = n10;
        this.mShowsUserInterface = bl3;
        this.mIsContextual = bl4;
    }

    private void checkContextualActionNullFields() {
        boolean bl2 = this.mIsContextual;
        if (!bl2) {
            return;
        }
        Objects.requireNonNull(this.mIntent, "Contextual Actions must contain a valid PendingIntent");
    }

    public static NotificationCompat$Action$Builder fromAndroidAction(Notification.Action action) {
        int n10;
        NotificationCompat$Action$Builder notificationCompat$Action$Builder;
        PendingIntent pendingIntent;
        CharSequence charSequence;
        android.app.RemoteInput[] remoteInputArray;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12 && (remoteInputArray = action.getIcon()) != null) {
            remoteInputArray = IconCompat.createFromIcon(action.getIcon());
            charSequence = action.title;
            pendingIntent = action.actionIntent;
            notificationCompat$Action$Builder = new NotificationCompat$Action$Builder((IconCompat)remoteInputArray, charSequence, pendingIntent);
        } else {
            n12 = action.icon;
            charSequence = action.title;
            pendingIntent = action.actionIntent;
            notificationCompat$Action$Builder = new NotificationCompat$Action$Builder(n12, charSequence, pendingIntent);
        }
        n12 = 20;
        if (n11 >= n12 && (remoteInputArray = action.getRemoteInputs()) != null && (n10 = remoteInputArray.length) != 0) {
            n10 = remoteInputArray.length;
            pendingIntent = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                RemoteInput remoteInput = RemoteInput.fromPlatform(remoteInputArray[i10]);
                notificationCompat$Action$Builder.addRemoteInput(remoteInput);
            }
        }
        if (n11 >= (n12 = 24)) {
            n12 = (int)(action.getAllowGeneratedReplies() ? 1 : 0);
            notificationCompat$Action$Builder.mAllowGeneratedReplies = n12;
        }
        if (n11 >= (n12 = 28)) {
            n12 = action.getSemanticAction();
            notificationCompat$Action$Builder.setSemanticAction(n12);
        }
        if (n11 >= (n12 = 29)) {
            boolean bl2 = action.isContextual();
            notificationCompat$Action$Builder.setContextual(bl2);
        }
        return notificationCompat$Action$Builder;
    }

    public NotificationCompat$Action$Builder addExtras(Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = this.mExtras;
            bundle2.putAll(bundle);
        }
        return this;
    }

    public NotificationCompat$Action$Builder addRemoteInput(RemoteInput remoteInput) {
        ArrayList arrayList = this.mRemoteInputs;
        if (arrayList == null) {
            this.mRemoteInputs = arrayList = new ArrayList();
        }
        if (remoteInput != null) {
            arrayList = this.mRemoteInputs;
            arrayList.add(remoteInput);
        }
        return this;
    }

    public NotificationCompat$Action build() {
        RemoteInput[] remoteInputArray;
        RemoteInput[] remoteInputArray2;
        boolean bl2;
        this.checkContextualActionNullFields();
        RemoteInput[] remoteInputArray3 = new ArrayList();
        ArrayList<RemoteInput[]> arrayList = new ArrayList<RemoteInput[]>();
        RemoteInput[] remoteInputArray4 = this.mRemoteInputs;
        if (remoteInputArray4 != null) {
            remoteInputArray4 = remoteInputArray4.iterator();
            while (bl2 = remoteInputArray4.hasNext()) {
                remoteInputArray2 = (RemoteInput[])remoteInputArray4.next();
                boolean bl3 = remoteInputArray2.isDataOnly();
                if (bl3) {
                    remoteInputArray3.add(remoteInputArray2);
                    continue;
                }
                arrayList.add(remoteInputArray2);
            }
        }
        int n10 = remoteInputArray3.isEmpty();
        bl2 = false;
        remoteInputArray2 = null;
        if (n10 != 0) {
            remoteInputArray = null;
        } else {
            n10 = remoteInputArray3.size();
            remoteInputArray4 = new RemoteInput[n10];
            remoteInputArray = remoteInputArray3 = remoteInputArray3.toArray(remoteInputArray4);
        }
        int n11 = arrayList.isEmpty();
        if (n11 == 0) {
            n11 = arrayList.size();
            remoteInputArray3 = new RemoteInput[n11];
            remoteInputArray2 = remoteInputArray3 = arrayList.toArray(remoteInputArray3);
            remoteInputArray2 = remoteInputArray3;
        }
        IconCompat iconCompat = this.mIcon;
        CharSequence charSequence = this.mTitle;
        PendingIntent pendingIntent = this.mIntent;
        Bundle bundle = this.mExtras;
        boolean bl4 = this.mAllowGeneratedReplies;
        int n12 = this.mSemanticAction;
        boolean bl5 = this.mShowsUserInterface;
        boolean bl6 = this.mIsContextual;
        remoteInputArray3 = new NotificationCompat$Action(iconCompat, charSequence, pendingIntent, bundle, remoteInputArray2, remoteInputArray, bl4, n12, bl5, bl6);
        return remoteInputArray3;
    }

    public NotificationCompat$Action$Builder extend(NotificationCompat$Action$Extender notificationCompat$Action$Extender) {
        notificationCompat$Action$Extender.extend(this);
        return this;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public NotificationCompat$Action$Builder setAllowGeneratedReplies(boolean bl2) {
        this.mAllowGeneratedReplies = bl2;
        return this;
    }

    public NotificationCompat$Action$Builder setContextual(boolean bl2) {
        this.mIsContextual = bl2;
        return this;
    }

    public NotificationCompat$Action$Builder setSemanticAction(int n10) {
        this.mSemanticAction = n10;
        return this;
    }

    public NotificationCompat$Action$Builder setShowsUserInterface(boolean bl2) {
        this.mShowsUserInterface = bl2;
        return this;
    }
}

