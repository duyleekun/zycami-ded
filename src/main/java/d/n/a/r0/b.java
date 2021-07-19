/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.ParcelUuid
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package d.n.a.r0;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import d.n.a.q0.v.k;
import d.n.a.q0.v.m;
import d.n.a.r0.b$a;
import d.n.a.r0.b$b;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class b
implements Parcelable,
m {
    public static final Parcelable.Creator CREATOR;
    private static final b k;
    private final String a;
    private final String b;
    private final ParcelUuid c;
    private final ParcelUuid d;
    private final ParcelUuid e;
    private final byte[] f;
    private final byte[] g;
    private final int h;
    private final byte[] i;
    private final byte[] j;

    static {
        Object object = new b$b();
        k = ((b$b)object).a();
        object = new b$a();
        CREATOR = object;
    }

    public b(String string2, String string3, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] byArray, byte[] byArray2, int n10, byte[] byArray3, byte[] byArray4) {
        this.a = string2;
        this.c = parcelUuid;
        this.d = parcelUuid2;
        this.b = string3;
        this.e = parcelUuid3;
        this.f = byArray;
        this.g = byArray2;
        this.h = n10;
        this.i = byArray3;
        this.j = byArray4;
    }

    private static boolean c(byte[] byArray, byte[] byArray2) {
        boolean bl2;
        if (!(byArray == byArray2 || byArray != null && byArray2 != null && (bl2 = Arrays.equals(byArray, byArray2)))) {
            bl2 = false;
            byArray = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static b d() {
        b$b b$b = new b$b();
        return b$b.a();
    }

    private static boolean e(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean p(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        int n10;
        int n11;
        if (byArray3 != null && (n11 = byArray3.length) >= (n10 = byArray.length)) {
            int n12;
            n11 = 1;
            if (byArray2 == null) {
                byArray2 = null;
                for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
                    n10 = byArray3[i10];
                    byte by2 = byArray[i10];
                    if (n10 == by2) continue;
                    return false;
                }
                return n11 != 0;
            }
            for (n10 = 0; n10 < (n12 = byArray.length); ++n10) {
                n12 = byArray2[n10];
                int n13 = byArray3[n10];
                n12 &= n13;
                n13 = byArray2[n10];
                byte by3 = byArray[n10];
                if (n12 == (n13 &= by3)) continue;
                return false;
            }
            return n11 != 0;
        }
        return false;
    }

    private static boolean q(UUID uUID, UUID uUID2, UUID uUID3) {
        if (uUID2 == null) {
            return uUID.equals(uUID3);
        }
        long l10 = uUID.getLeastSignificantBits();
        long l11 = uUID2.getLeastSignificantBits();
        l10 &= l11;
        l11 = uUID3.getLeastSignificantBits();
        long l12 = uUID2.getLeastSignificantBits();
        long l13 = l10 - (l11 &= l12);
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        boolean bl2 = false;
        if (l14 != false) {
            return false;
        }
        l11 = uUID.getMostSignificantBits();
        l12 = uUID2.getMostSignificantBits();
        l11 &= l12;
        l12 = uUID3.getMostSignificantBits();
        long l15 = uUID2.getMostSignificantBits() & l12;
        long l16 = l11 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false) {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean r(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List object) {
        boolean bl2;
        boolean bl3 = true;
        if (parcelUuid == null) {
            return bl3;
        }
        if (object == null) {
            return false;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (ParcelUuid)object.next();
            UUID uUID = parcelUuid2 == null ? null : parcelUuid2.getUuid();
            UUID uUID2 = parcelUuid.getUuid();
            bl2 = d.n.a.r0.b.q(uUID2, uUID, (UUID)(object2 = object2.getUuid()));
            if (!bl2) continue;
            return bl3;
        }
        return false;
    }

    public boolean a(k object) {
        boolean bl2;
        int n10;
        Object object2;
        boolean bl3;
        if (object == null) {
            return false;
        }
        Object object3 = ((k)object).a();
        Object object4 = this.b;
        if (!(object4 == null || object3 != null && (bl3 = ((String)object4).equals(object2 = object3.getAddress())))) {
            return false;
        }
        if ((object = ((k)object).d()) == null && ((object4 = this.a) != null || (object4 = this.c) != null || (object4 = (Object)this.i) != null || (object4 = (Object)this.f) != null)) {
            return false;
        }
        object4 = this.a;
        if (object4 != null && !(bl3 = ((String)object4).equals(object2 = object.h())) && (n10 = (int)(((String)(object4 = this.a)).equals(object3 = object3.getName()) ? 1 : 0)) == 0) {
            return false;
        }
        object3 = this.c;
        if (object3 != null && (n10 = (int)(d.n.a.r0.b.r((ParcelUuid)object3, (ParcelUuid)(object4 = this.d), (List)(object2 = object.d())) ? 1 : 0)) == 0) {
            return false;
        }
        object3 = this.e;
        if (object3 != null && (n10 = (int)(d.n.a.r0.b.p((byte[])(object4 = (Object)this.f), (byte[])(object2 = (Object)this.g), (byte[])(object3 = (Object)object.i((ParcelUuid)object3))) ? 1 : 0)) == 0) {
            return false;
        }
        n10 = this.h;
        return n10 < 0 || (bl2 = d.n.a.r0.b.p((byte[])(object4 = (Object)this.i), (byte[])(object2 = (Object)this.j), (byte[])(object = (Object)object.b(n10))));
    }

    public boolean b() {
        b b10 = k;
        return this.equals(b10);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            int n10;
            object = (b)object;
            object3 = this.a;
            object2 = ((b)object).a;
            int n11 = d.n.a.r0.b.e(object3, object2);
            if (n11 == 0 || (n11 = d.n.a.r0.b.e(object3 = this.b, object2 = ((b)object).b)) == 0 || (n11 = this.h) != (n10 = ((b)object).h) || (n11 = (int)(d.n.a.r0.b.c((byte[])(object3 = (Object)this.i), (byte[])(object2 = (Object)((b)object).i)) ? 1 : 0)) == 0 || (n11 = (int)(d.n.a.r0.b.c((byte[])(object3 = (Object)this.j), (byte[])(object2 = (Object)((b)object).j)) ? 1 : 0)) == 0 || (n11 = (int)(d.n.a.r0.b.e(object3 = this.e, object2 = ((b)object).e) ? 1 : 0)) == 0 || (n11 = (int)(d.n.a.r0.b.c((byte[])(object3 = (Object)this.f), (byte[])(object2 = (Object)((b)object).f)) ? 1 : 0)) == 0 || (n11 = (int)(d.n.a.r0.b.c((byte[])(object3 = (Object)this.g), (byte[])(object2 = (Object)((b)object).g)) ? 1 : 0)) == 0 || (n11 = (int)(d.n.a.r0.b.e(object3 = this.c, object2 = ((b)object).c) ? 1 : 0)) == 0 || !(bl3 = d.n.a.r0.b.e(object3 = this.d, object = ((b)object).d))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.a;
    }

    public byte[] h() {
        return this.i;
    }

    public int hashCode() {
        Object object = this.a;
        object = this.b;
        object = this.h;
        Object[] objectArray = new Object[]{object, object, object, object = Integer.valueOf(Arrays.hashCode(this.i)), object = Integer.valueOf(Arrays.hashCode(this.j)), object = this.e, object = Integer.valueOf(Arrays.hashCode(this.f)), object = Integer.valueOf(Arrays.hashCode(this.g)), object = this.c, object = this.d};
        return Arrays.hashCode(objectArray);
    }

    public byte[] i() {
        return this.j;
    }

    public int j() {
        return this.h;
    }

    public byte[] k() {
        return this.f;
    }

    public byte[] l() {
        return this.g;
    }

    public ParcelUuid m() {
        return this.e;
    }

    public ParcelUuid n() {
        return this.c;
    }

    public ParcelUuid o() {
        return this.d;
    }

    public String toString() {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothLeScanFilter [mDeviceName=");
        Object object = this.a;
        stringBuilder.append((String)object);
        stringBuilder.append(", ");
        object = d.n.a.q0.t.b.d(this.b);
        stringBuilder.append((String)object);
        stringBuilder.append(", mUuid=");
        object = this.c;
        String string2 = null;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = d.n.a.q0.t.b.h(object.getUuid());
        }
        stringBuilder.append((String)object);
        stringBuilder.append(", mUuidMask=");
        object = this.d;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = d.n.a.q0.t.b.h(object.getUuid());
        }
        stringBuilder.append((String)object);
        stringBuilder.append(", mServiceDataUuid=");
        object = this.e;
        if (object != null) {
            object = object.getUuid();
            string2 = d.n.a.q0.t.b.h((UUID)object);
        }
        stringBuilder.append(string2);
        stringBuilder.append(", mServiceData=");
        object = Arrays.toString(this.f);
        stringBuilder.append((String)object);
        stringBuilder.append(", mServiceDataMask=");
        object = Arrays.toString(this.g);
        stringBuilder.append((String)object);
        stringBuilder.append(", mManufacturerId=");
        n10 = this.h;
        stringBuilder.append(n10);
        stringBuilder.append(", mManufacturerData=");
        object = Arrays.toString(this.i);
        stringBuilder.append((String)object);
        stringBuilder.append(", mManufacturerDataMask=");
        object = Arrays.toString(this.j);
        stringBuilder.append((String)object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        byte[] byArray;
        int n11;
        String string2 = this.a;
        int n12 = 0;
        int n13 = 1;
        if (string2 == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = n13;
        }
        parcel.writeInt(n11);
        string2 = this.a;
        if (string2 != null) {
            parcel.writeString(string2);
        }
        if ((string2 = this.b) == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = n13;
        }
        parcel.writeInt(n11);
        string2 = this.b;
        if (string2 != null) {
            parcel.writeString(string2);
        }
        if ((string2 = this.c) == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = n13;
        }
        parcel.writeInt(n11);
        string2 = this.c;
        if (string2 != null) {
            parcel.writeParcelable((Parcelable)string2, n10);
            string2 = this.d;
            if (string2 == null) {
                n11 = 0;
                string2 = null;
            } else {
                n11 = n13;
            }
            parcel.writeInt(n11);
            string2 = this.d;
            if (string2 != null) {
                parcel.writeParcelable((Parcelable)string2, n10);
            }
        }
        if ((string2 = this.e) == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = n13;
        }
        parcel.writeInt(n11);
        string2 = this.e;
        if (string2 != null) {
            parcel.writeParcelable((Parcelable)string2, n10);
            byArray = this.f;
            if (byArray == null) {
                n10 = 0;
                byArray = null;
            } else {
                n10 = n13;
            }
            parcel.writeInt(n10);
            byArray = this.f;
            if (byArray != null) {
                n10 = byArray.length;
                parcel.writeInt(n10);
                byArray = this.f;
                parcel.writeByteArray(byArray);
                byArray = this.g;
                if (byArray == null) {
                    n10 = 0;
                    byArray = null;
                } else {
                    n10 = n13;
                }
                parcel.writeInt(n10);
                byArray = this.g;
                if (byArray != null) {
                    n10 = byArray.length;
                    parcel.writeInt(n10);
                    byArray = this.g;
                    parcel.writeByteArray(byArray);
                }
            }
        }
        n10 = this.h;
        parcel.writeInt(n10);
        byArray = this.i;
        if (byArray == null) {
            n10 = 0;
            byArray = null;
        } else {
            n10 = n13;
        }
        parcel.writeInt(n10);
        byArray = this.i;
        if (byArray != null) {
            n10 = byArray.length;
            parcel.writeInt(n10);
            byArray = this.i;
            parcel.writeByteArray(byArray);
            byArray = this.j;
            if (byArray != null) {
                n12 = n13;
            }
            parcel.writeInt(n12);
            byArray = this.j;
            if (byArray != null) {
                n10 = byArray.length;
                parcel.writeInt(n10);
                byArray = this.j;
                parcel.writeByteArray(byArray);
            }
        }
    }
}

