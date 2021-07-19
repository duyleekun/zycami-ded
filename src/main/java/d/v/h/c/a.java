/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package d.v.h.c;

import android.os.Parcel;
import android.os.Parcelable;
import d.v.h.c.a$a;

public class a
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String a;
    private int b;
    private int c;

    static {
        a$a a$a = new a$a();
        CREATOR = a$a;
    }

    public a() {
    }

    public a(Parcel parcel) {
        int n10;
        int n11;
        String string2;
        this.a = string2 = parcel.readString();
        this.b = n11 = parcel.readInt();
        this.c = n10 = parcel.readInt();
    }

    public String a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public a d(String string2) {
        this.a = string2;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public a e(int n10) {
        this.c = n10;
        return this;
    }

    public a f(int n10) {
        this.b = n10;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.a;
        parcel.writeString(string2);
        n10 = this.b;
        parcel.writeInt(n10);
        n10 = this.c;
        parcel.writeInt(n10);
    }
}

