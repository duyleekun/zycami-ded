/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package d.t.a.g;

import android.os.Parcel;
import android.os.Parcelable;
import d.t.a.g.a$a;

public class a
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final String a;
    private final float b;
    private final float c;

    static {
        a$a a$a = new a$a();
        CREATOR = a$a;
    }

    public a(Parcel parcel) {
        float f10;
        float f11;
        String string2;
        this.a = string2 = parcel.readString();
        this.b = f11 = parcel.readFloat();
        this.c = f10 = parcel.readFloat();
    }

    public a(String string2, float f10, float f11) {
        this.a = string2;
        this.b = f10;
        this.c = f11;
    }

    public String a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public float c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.a;
        parcel.writeString(string2);
        float f10 = this.b;
        parcel.writeFloat(f10);
        f10 = this.c;
        parcel.writeFloat(f10);
    }
}

