/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;

public class MediaSessionCompat$ResultReceiverWrapper$1
implements Parcelable.Creator {
    public MediaSessionCompat$ResultReceiverWrapper createFromParcel(Parcel parcel) {
        MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper(parcel);
        return mediaSessionCompat$ResultReceiverWrapper;
    }

    public MediaSessionCompat$ResultReceiverWrapper[] newArray(int n10) {
        return new MediaSessionCompat$ResultReceiverWrapper[n10];
    }
}

