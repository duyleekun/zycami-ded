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
import android.support.v4.media.session.PlaybackStateCompat;

public class PlaybackStateCompat$1
implements Parcelable.Creator {
    public PlaybackStateCompat createFromParcel(Parcel parcel) {
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(parcel);
        return playbackStateCompat;
    }

    public PlaybackStateCompat[] newArray(int n10) {
        return new PlaybackStateCompat[n10];
    }
}

