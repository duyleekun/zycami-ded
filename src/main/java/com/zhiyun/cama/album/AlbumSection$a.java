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
import com.zhiyun.cama.album.AlbumSection;

public final class AlbumSection$a
implements Parcelable.Creator {
    public AlbumSection a(Parcel parcel) {
        AlbumSection albumSection = new AlbumSection(parcel);
        return albumSection;
    }

    public AlbumSection[] b(int n10) {
        return new AlbumSection[n10];
    }
}

