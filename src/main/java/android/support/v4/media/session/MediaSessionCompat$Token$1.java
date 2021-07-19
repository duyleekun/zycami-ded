/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;

public class MediaSessionCompat$Token$1
implements Parcelable.Creator {
    public MediaSessionCompat$Token createFromParcel(Parcel parcel) {
        MediaSessionCompat$Token mediaSessionCompat$Token;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = 0;
            mediaSessionCompat$Token = null;
            parcel = parcel.readParcelable(null);
        } else {
            parcel = parcel.readStrongBinder();
        }
        mediaSessionCompat$Token = new MediaSessionCompat$Token(parcel);
        return mediaSessionCompat$Token;
    }

    public MediaSessionCompat$Token[] newArray(int n10) {
        return new MediaSessionCompat$Token[n10];
    }
}

