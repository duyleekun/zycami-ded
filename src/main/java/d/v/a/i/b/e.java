/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package d.v.a.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import d.v.a.i.b.e$a;

public class e
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final String f = "CountryInfo";
    public static final int g = 16;
    public static final int h = 32;
    private String a;
    private int b;
    private String c;
    private String d;
    private String e;

    static {
        e$a e$a = new e$a();
        CREATOR = e$a;
    }

    public e() {
        String string2;
        this.a = string2 = "";
        this.d = string2;
        this.e = string2;
    }

    public e(Parcel object) {
        int n10;
        String string2;
        this.a = string2 = "";
        this.d = string2;
        this.e = string2;
        this.a = string2 = object.readString();
        this.b = n10 = object.readInt();
        this.c = string2 = object.readString();
        this.d = string2 = object.readString();
        object = object.readString();
        this.e = object;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.b;
    }

    public void f(String string2) {
        this.d = string2;
    }

    public void g(String string2) {
        this.a = string2;
    }

    public void h(String string2) {
        this.e = string2;
    }

    public void i(String string2) {
        this.c = string2;
    }

    public void j(int n10) {
        this.b = n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.a;
        parcel.writeString(string2);
        n10 = this.b;
        parcel.writeInt(n10);
        string2 = this.c;
        parcel.writeString(string2);
        string2 = this.d;
        parcel.writeString(string2);
        string2 = this.e;
        parcel.writeString(string2);
    }
}

