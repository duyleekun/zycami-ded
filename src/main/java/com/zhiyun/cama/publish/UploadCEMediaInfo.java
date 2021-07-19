/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.publish;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.ObservableBoolean;
import com.zhiyun.cama.publish.UploadCEMediaInfo$a;
import d.v.h.e.a;

public class UploadCEMediaInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private a a;
    private Uri b;
    private ObservableBoolean c;

    static {
        UploadCEMediaInfo$a uploadCEMediaInfo$a = new UploadCEMediaInfo$a();
        CREATOR = uploadCEMediaInfo$a;
    }

    public UploadCEMediaInfo(Parcel object) {
        Object object2 = new ObservableBoolean();
        this.c = object2;
        object2 = a.class.getClassLoader();
        this.a = object2 = (a)object.readParcelable((ClassLoader)object2);
        object2 = ObservableBoolean.class.getClassLoader();
        object = (ObservableBoolean)object.readParcelable((ClassLoader)object2);
        this.c = object;
    }

    public UploadCEMediaInfo(a a10) {
        ObservableBoolean observableBoolean;
        this.c = observableBoolean = new ObservableBoolean();
        this.a = a10;
        long l10 = a10.d() / 1000L;
        a10.k(l10);
    }

    public a a() {
        return this.a;
    }

    public int b() {
        return Math.round((float)this.a.d() / 1000.0f);
    }

    public boolean c() {
        return this.c.get();
    }

    public Uri d() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void e(boolean bl2) {
        this.c.set(bl2);
    }

    public UploadCEMediaInfo f(Uri uri) {
        this.b = uri;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.a;
        parcel.writeParcelable((Parcelable)object, n10);
        object = this.c;
        parcel.writeParcelable((Parcelable)object, n10);
    }
}

