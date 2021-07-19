/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.b$a;

public class b
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public String a;
    public Bundle b = null;
    private int c = 1;
    private Bundle d = null;

    static {
        b$a b$a = new b$a();
        CREATOR = b$a;
    }

    public b() {
    }

    private b(Parcel parcel) {
        this.a(parcel);
    }

    public /* synthetic */ b(Parcel parcel, b$a b$a) {
        this(parcel);
    }

    public b(String string2, int n10) {
        this.a = string2;
        this.c = n10;
    }

    private static ClassLoader a(Class clazz) {
        return clazz.getClassLoader();
    }

    private void a(Parcel parcel) {
        int n10;
        this.c = n10 = parcel.readInt();
        Object object = parcel.readString();
        this.a = object;
        object = com.huawei.hms.core.aidl.b.a(Bundle.class);
        object = parcel.readBundle((ClassLoader)object);
        this.b = object;
        object = com.huawei.hms.core.aidl.b.a(Bundle.class);
        parcel = parcel.readBundle((ClassLoader)object);
        this.d = parcel;
    }

    public Bundle a() {
        return this.d;
    }

    public b a(Bundle bundle) {
        this.d = bundle;
        return this;
    }

    public int b() {
        int n10;
        Bundle bundle = this.d;
        if (bundle == null) {
            n10 = 0;
            bundle = null;
        } else {
            n10 = 1;
        }
        return n10;
    }

    public int c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.c;
        parcel.writeInt(n10);
        String string2 = this.a;
        parcel.writeString(string2);
        string2 = this.b;
        parcel.writeBundle((Bundle)string2);
        string2 = this.d;
        parcel.writeBundle((Bundle)string2);
    }
}

