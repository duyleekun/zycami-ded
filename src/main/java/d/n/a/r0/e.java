/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package d.n.a.r0;

import android.os.Parcel;
import android.os.Parcelable;
import d.n.a.q0.v.f;
import d.n.a.r0.e$a;

public class e
implements Parcelable,
f {
    public static final Parcelable.Creator CREATOR;
    public static final int g = 255;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 4;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    public static final int q = 1;
    public static final int r = 2;
    private int a;
    private int b;
    private long c;
    private int d;
    private int e;
    private boolean f;

    static {
        e$a e$a = new e$a();
        CREATOR = e$a;
    }

    public e(int n10, int n11, long l10, int n12, int n13, boolean bl2) {
        this.a = n10;
        this.b = n11;
        this.c = l10;
        this.e = n13;
        this.d = n12;
        this.f = bl2;
    }

    public e(Parcel parcel) {
        long l10;
        int n10;
        this.a = n10 = parcel.readInt();
        this.b = n10 = parcel.readInt();
        this.c = l10 = parcel.readLong();
        this.d = n10 = parcel.readInt();
        this.e = n10 = parcel.readInt();
        int n11 = parcel.readInt();
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            parcel = null;
        }
        this.f = n11;
    }

    public boolean a() {
        return this.f;
    }

    public e c(int n10) {
        int n11 = this.a;
        long l10 = this.c;
        int n12 = this.d;
        int n13 = this.e;
        boolean bl2 = this.f;
        e e10 = new e(n11, n10, l10, n12, n13, bl2);
        return e10;
    }

    public int d() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public long g() {
        return this.c;
    }

    public int h() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.a;
        parcel.writeInt(n10);
        n10 = this.b;
        parcel.writeInt(n10);
        long l10 = this.c;
        parcel.writeLong(l10);
        n10 = this.d;
        parcel.writeInt(n10);
        n10 = this.e;
        parcel.writeInt(n10);
        n10 = (int)(this.f ? 1 : 0);
        parcel.writeInt(n10);
    }
}

