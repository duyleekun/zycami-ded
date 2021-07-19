/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.album;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.album.Album;

public final class Album$a
implements Parcelable.Creator {
    public Album a(Parcel parcel) {
        Album album = new Album(parcel);
        return album;
    }

    public Album[] b(int n10) {
        return new Album[n10];
    }
}

