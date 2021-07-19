/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.album;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.JSectionEntity;
import com.google.common.base.Objects;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumSection$a;

public class AlbumSection
extends JSectionEntity
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private Album album;
    private boolean isHeader;

    static {
        AlbumSection$a albumSection$a = new AlbumSection$a();
        CREATOR = albumSection$a;
    }

    public AlbumSection(Parcel object) {
        ClassLoader classLoader;
        byte by2 = object.readByte();
        if (by2 != 0) {
            by2 = 1;
        } else {
            by2 = 0;
            classLoader = null;
        }
        this.isHeader = by2;
        classLoader = Album.class.getClassLoader();
        object = (Album)object.readParcelable(classLoader);
        this.album = object;
    }

    public AlbumSection(boolean bl2, Album album) {
        this.isHeader = bl2;
        this.album = album;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Album album;
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof AlbumSection;
        if (!bl4) {
            return false;
        }
        object = (AlbumSection)object;
        bl4 = this.isHeader;
        boolean bl5 = ((AlbumSection)object).isHeader;
        if (bl4 != bl5 || !(bl2 = Objects.equal(album = this.album, object = ((AlbumSection)object).album))) {
            bl3 = false;
        }
        return bl3;
    }

    public Album getAlbum() {
        return this.album;
    }

    public int hashCode() {
        Object object = this.isHeader;
        Object[] objectArray = new Object[]{object, object = this.album};
        return Objects.hashCode(objectArray);
    }

    public boolean isHeader() {
        return this.isHeader;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        byte by2 = (byte)(this.isHeader ? 1 : 0);
        parcel.writeByte(by2);
        Album album = this.album;
        parcel.writeParcelable((Parcelable)album, n10);
    }
}

