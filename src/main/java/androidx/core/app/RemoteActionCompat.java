/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.RemoteAction
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat
implements VersionedParcelable {
    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    public RemoteActionCompat() {
    }

    public RemoteActionCompat(RemoteActionCompat remoteActionCompat) {
        boolean bl2;
        boolean bl3;
        Preconditions.checkNotNull(remoteActionCompat);
        Object object = remoteActionCompat.mIcon;
        this.mIcon = object;
        this.mTitle = object = remoteActionCompat.mTitle;
        this.mContentDescription = object = remoteActionCompat.mContentDescription;
        object = remoteActionCompat.mActionIntent;
        this.mActionIntent = object;
        this.mEnabled = bl3 = remoteActionCompat.mEnabled;
        this.mShouldShowIcon = bl2 = remoteActionCompat.mShouldShowIcon;
    }

    public RemoteActionCompat(IconCompat object, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        boolean bl2;
        object = (IconCompat)Preconditions.checkNotNull(object);
        this.mIcon = object;
        this.mTitle = object = (CharSequence)Preconditions.checkNotNull(charSequence);
        this.mContentDescription = object = (CharSequence)Preconditions.checkNotNull(charSequence2);
        object = (PendingIntent)Preconditions.checkNotNull(pendingIntent);
        this.mActionIntent = object;
        this.mEnabled = bl2 = true;
        this.mShouldShowIcon = bl2;
    }

    public static RemoteActionCompat createFromRemoteAction(RemoteAction remoteAction) {
        Preconditions.checkNotNull(remoteAction);
        IconCompat iconCompat = IconCompat.createFromIcon(remoteAction.getIcon());
        CharSequence charSequence = remoteAction.getTitle();
        CharSequence charSequence2 = remoteAction.getContentDescription();
        PendingIntent pendingIntent = remoteAction.getActionIntent();
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(iconCompat, charSequence, charSequence2, pendingIntent);
        int n10 = remoteAction.isEnabled();
        remoteActionCompat.setEnabled(n10 != 0);
        n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            boolean bl2 = remoteAction.shouldShowIcon();
            remoteActionCompat.setShouldShowIcon(bl2);
        }
        return remoteActionCompat;
    }

    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean bl2) {
        this.mEnabled = bl2;
    }

    public void setShouldShowIcon(boolean bl2) {
        this.mShouldShowIcon = bl2;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    public RemoteAction toRemoteAction() {
        Icon icon = this.mIcon.toIcon();
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = this.mContentDescription;
        PendingIntent pendingIntent = this.mActionIntent;
        RemoteAction remoteAction = new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
        boolean bl2 = this.isEnabled();
        remoteAction.setEnabled(bl2);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            boolean bl3 = this.shouldShowIcon();
            remoteAction.setShouldShowIcon(bl3);
        }
        return remoteAction;
    }
}

