/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.album;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.BaseObservableField;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import com.google.common.base.Objects;
import com.zhiyun.cama.album.Album$a;
import java.io.Serializable;

public class Album
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public long addDate;
    public ObservableField addTimeDay;
    public String displayName;
    public long duration;
    public ObservableBoolean favorite;
    public int height;
    public int id;
    public ObservableBoolean isChecked;
    public boolean isVideo;
    public String mime;
    public int orientation;
    public String path;
    public ObservableInt playedSec;
    public ObservableBoolean playing;
    public ObservableInt progress;
    public String storyName;
    public Uri uri;
    public int width;

    static {
        Album$a album$a = new Album$a();
        CREATOR = album$a;
    }

    public Album() {
        BaseObservableField baseObservableField;
        this.isChecked = baseObservableField = new ObservableBoolean();
        this.addTimeDay = baseObservableField;
        this.favorite = baseObservableField = new ObservableBoolean();
        this.playing = baseObservableField = new ObservableBoolean();
        super();
        this.playedSec = baseObservableField;
        super();
        this.progress = baseObservableField;
    }

    public Album(Parcel parcel) {
        long l10;
        int n10;
        Object object = new ObservableBoolean();
        this.isChecked = object;
        this.addTimeDay = object;
        object = new ObservableBoolean();
        this.favorite = object;
        object = new ObservableBoolean();
        this.playing = object;
        super();
        this.playedSec = object;
        super();
        this.progress = object;
        this.id = n10 = parcel.readInt();
        this.addDate = l10 = parcel.readLong();
        this.path = object = parcel.readString();
        this.width = n10 = parcel.readInt();
        this.height = n10 = parcel.readInt();
        this.mime = object = parcel.readString();
        this.duration = l10 = parcel.readLong();
        this.displayName = object = parcel.readString();
        this.orientation = n10 = parcel.readInt();
        n10 = parcel.readByte();
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        this.isVideo = n10;
        object = ObservableBoolean.class.getClassLoader();
        this.isChecked = object = (ObservableBoolean)parcel.readParcelable((ClassLoader)object);
        this.addTimeDay = object = (ObservableField)parcel.readSerializable();
        this.storyName = object = parcel.readString();
        object = ObservableBoolean.class.getClassLoader();
        this.favorite = object = (ObservableBoolean)parcel.readParcelable((ClassLoader)object);
        object = ObservableBoolean.class.getClassLoader();
        this.playing = object = (ObservableBoolean)parcel.readParcelable((ClassLoader)object);
        object = ObservableInt.class.getClassLoader();
        this.playedSec = object = (ObservableInt)parcel.readParcelable((ClassLoader)object);
        object = ObservableInt.class.getClassLoader();
        this.progress = object = (ObservableInt)parcel.readParcelable((ClassLoader)object);
        object = Uri.class.getClassLoader();
        parcel = (Uri)parcel.readParcelable((ClassLoader)object);
        this.uri = parcel;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof Album;
        if (n10 == 0) {
            return false;
        }
        object = (Album)object;
        n10 = this.id;
        int n11 = ((Album)object).id;
        if (n10 != n11 || (n10 = (int)((l13 = (l12 = this.addDate) - (l11 = ((Album)object).addDate)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0 || (n10 = this.width) != (n11 = ((Album)object).width) || (n10 = this.height) != (n11 = ((Album)object).height) || (n10 = (int)((l10 = (l12 = this.duration) - (l11 = ((Album)object).duration)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (n10 = this.orientation) != (n11 = ((Album)object).orientation) || (n10 = (int)(this.isVideo ? 1 : 0)) != (n11 = (int)(((Album)object).isVideo ? 1 : 0)) || (object3 = this.isChecked) != (object2 = ((Album)object).isChecked) || (object3 = this.favorite) != (object2 = ((Album)object).favorite) || (n10 = (int)(Objects.equal(object3 = this.path, object2 = ((Album)object).path) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equal(object3 = this.mime, object2 = ((Album)object).mime) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equal(object3 = this.displayName, object2 = ((Album)object).displayName) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equal(object3 = this.addTimeDay, object2 = ((Album)object).addTimeDay) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equal(object3 = this.playing, object2 = ((Album)object).playing) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equal(object3 = this.playedSec, object2 = ((Album)object).playedSec) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equal(object3 = this.progress, object2 = ((Album)object).progress) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equal(object3 = this.storyName, object2 = ((Album)object).storyName) ? 1 : 0)) == 0 || (object3 = this.uri) != (object = ((Album)object).uri)) {
            bl2 = false;
        }
        return bl2;
    }

    public int getDurationSec() {
        return Math.round((float)this.duration / 1000.0f);
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.addDate), object = this.path, object = Integer.valueOf(this.width), object = Integer.valueOf(this.height), object = this.mime, object = Long.valueOf(this.duration), object = this.displayName, object = Integer.valueOf(this.orientation), object = Boolean.valueOf(this.isVideo), object = this.isChecked, object = this.addTimeDay, object = this.favorite, object = this.playing, object = this.playedSec, object = this.progress, object = this.storyName, object = this.uri};
        return Objects.hashCode(objectArray);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int by2 = this.id;
        parcel.writeInt(by2);
        long l10 = this.addDate;
        parcel.writeLong(l10);
        Object object = this.path;
        parcel.writeString((String)object);
        int n11 = this.width;
        parcel.writeInt(n11);
        int n12 = this.height;
        parcel.writeInt(n12);
        object = this.mime;
        parcel.writeString((String)object);
        l10 = this.duration;
        parcel.writeLong(l10);
        object = this.displayName;
        parcel.writeString((String)object);
        int n13 = this.orientation;
        parcel.writeInt(n13);
        byte by3 = this.isVideo;
        parcel.writeByte(by3);
        object = this.isChecked;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.addTimeDay;
        parcel.writeSerializable((Serializable)object);
        object = this.storyName;
        parcel.writeString((String)object);
        object = this.favorite;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.playing;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.playedSec;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.progress;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.uri;
        parcel.writeParcelable((Parcelable)object, n10);
    }
}

