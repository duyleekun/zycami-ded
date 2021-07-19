/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.ParcelUuid
 *  android.os.Parcelable$Creator
 */
package d.n.a.r0;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import d.n.a.r0.b;
import d.n.a.r0.b$b;

public final class b$a
implements Parcelable.Creator {
    public b a(Parcel parcel) {
        Object object;
        int n10;
        Object object2;
        int n11;
        b$b b$b = new b$b();
        int n12 = parcel.readInt();
        if (n12 == (n11 = 1)) {
            object2 = parcel.readString();
            b$b.c((String)object2);
        }
        if ((n12 = parcel.readInt()) == n11) {
            object2 = parcel.readString();
            b$b.b((String)object2);
        }
        if ((n12 = parcel.readInt()) == n11) {
            object2 = ParcelUuid.class.getClassLoader();
            object2 = (ParcelUuid)parcel.readParcelable((ClassLoader)object2);
            b$b.h((ParcelUuid)object2);
            n10 = parcel.readInt();
            if (n10 == n11) {
                object = ParcelUuid.class.getClassLoader();
                object = (ParcelUuid)parcel.readParcelable((ClassLoader)object);
                b$b.i((ParcelUuid)object2, (ParcelUuid)object);
            }
        }
        if ((n12 = parcel.readInt()) == n11) {
            object2 = ParcelUuid.class.getClassLoader();
            object2 = (ParcelUuid)parcel.readParcelable((ClassLoader)object2);
            n10 = parcel.readInt();
            if (n10 == n11) {
                n10 = parcel.readInt();
                object = new byte[n10];
                parcel.readByteArray((byte[])object);
                int n13 = parcel.readInt();
                if (n13 == 0) {
                    b$b.f((ParcelUuid)object2, (byte[])object);
                } else {
                    n13 = parcel.readInt();
                    byte[] byArray = new byte[n13];
                    parcel.readByteArray(byArray);
                    b$b.g((ParcelUuid)object2, (byte[])object, byArray);
                }
            }
        }
        n12 = parcel.readInt();
        n10 = parcel.readInt();
        if (n10 == n11) {
            n11 = parcel.readInt();
            byte[] byArray = new byte[n11];
            parcel.readByteArray(byArray);
            n10 = parcel.readInt();
            if (n10 == 0) {
                b$b.d(n12, byArray);
            } else {
                n10 = parcel.readInt();
                object = new byte[n10];
                parcel.readByteArray((byte[])object);
                b$b.e(n12, byArray, (byte[])object);
            }
        }
        return b$b.a();
    }

    public b[] b(int n10) {
        return new b[n10];
    }
}

