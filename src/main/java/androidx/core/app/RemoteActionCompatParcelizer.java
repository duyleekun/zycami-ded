/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcelable
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.app.RemoteActionCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelable;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        boolean bl2;
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object object = remoteActionCompat.mIcon;
        object = (IconCompat)versionedParcel.readVersionedParcelable((VersionedParcelable)object, 1);
        remoteActionCompat.mIcon = object;
        object = remoteActionCompat.mTitle;
        remoteActionCompat.mTitle = object = versionedParcel.readCharSequence((CharSequence)object, 2);
        object = remoteActionCompat.mContentDescription;
        remoteActionCompat.mContentDescription = object = versionedParcel.readCharSequence((CharSequence)object, 3);
        object = remoteActionCompat.mActionIntent;
        object = (PendingIntent)versionedParcel.readParcelable((Parcelable)object, 4);
        remoteActionCompat.mActionIntent = object;
        boolean bl3 = remoteActionCompat.mEnabled;
        remoteActionCompat.mEnabled = bl3 = versionedParcel.readBoolean(bl3, 5);
        bl3 = remoteActionCompat.mShouldShowIcon;
        remoteActionCompat.mShouldShowIcon = bl2 = versionedParcel.readBoolean(bl3, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        Object object = remoteActionCompat.mIcon;
        versionedParcel.writeVersionedParcelable((VersionedParcelable)object, 1);
        object = remoteActionCompat.mTitle;
        versionedParcel.writeCharSequence((CharSequence)object, 2);
        object = remoteActionCompat.mContentDescription;
        versionedParcel.writeCharSequence((CharSequence)object, 3);
        object = remoteActionCompat.mActionIntent;
        versionedParcel.writeParcelable((Parcelable)object, 4);
        boolean bl2 = remoteActionCompat.mEnabled;
        versionedParcel.writeBoolean(bl2, 5);
        boolean bl3 = remoteActionCompat.mShouldShowIcon;
        versionedParcel.writeBoolean(bl3, 6);
    }
}

