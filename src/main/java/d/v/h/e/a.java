/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package d.v.h.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.h.b;
import d.v.h.e.a$a;
import java.util.UUID;

public class a
extends b
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String b;
    private String c;
    private MediaType d;
    private long e;
    private boolean f;
    private String g;

    static {
        a$a a$a = new a$a();
        CREATOR = a$a;
    }

    public a() {
    }

    public a(Parcel object) {
        long l10;
        MediaType[] mediaTypeArray;
        Object object2;
        this.b = object2 = object.readString();
        this.c = object2 = object.readString();
        int n10 = object.readInt();
        int n11 = -1;
        if (n10 == n11) {
            n10 = 0;
            object2 = null;
        } else {
            mediaTypeArray = MediaType.values();
            object2 = mediaTypeArray[n10];
        }
        this.d = object2;
        this.e = l10 = object.readLong();
        n10 = object.readInt();
        n11 = 1;
        if (n10 != n11) {
            n11 = 0;
            mediaTypeArray = null;
        }
        this.f = n11;
        object = object.readString();
        this.g = object;
    }

    public a c() {
        a a10 = new a();
        Object object = this.c;
        a10 = a10.l((String)object);
        long l10 = this.e;
        a10 = a10.k(l10);
        object = this.d;
        a10 = a10.m((MediaType)((Object)object));
        object = this.b;
        a10 = a10.p((String)object);
        boolean bl2 = this.f;
        a10 = a10.n(bl2);
        object = this.g;
        a10 = a10.o((String)object);
        object = UUID.randomUUID().toString();
        return (a)a10.b((String)object);
    }

    public long d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.c;
    }

    public MediaType f() {
        return this.d;
    }

    public String g() {
        return this.g;
    }

    public String i() {
        return this.b;
    }

    public boolean j() {
        return this.f;
    }

    public a k(long l10) {
        this.e = l10;
        return this;
    }

    public a l(String string2) {
        this.c = string2;
        return this;
    }

    public a m(MediaType mediaType) {
        this.d = mediaType;
        return this;
    }

    public a n(boolean bl2) {
        this.f = bl2;
        return this;
    }

    public a o(String string2) {
        this.g = string2;
        return this;
    }

    public a p(String string2) {
        this.b = string2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.b;
        parcel.writeString((String)object);
        object = this.c;
        parcel.writeString((String)object);
        object = this.d;
        n10 = object == null ? -1 : ((Enum)object).ordinal();
        parcel.writeInt(n10);
        long l10 = this.e;
        parcel.writeLong(l10);
        n10 = (int)(this.f ? 1 : 0);
        parcel.writeInt(n10);
        object = this.g;
        parcel.writeString((String)object);
    }
}

