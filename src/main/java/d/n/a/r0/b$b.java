/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.os.ParcelUuid
 */
package d.n.a.r0;

import android.bluetooth.BluetoothAdapter;
import android.os.ParcelUuid;
import d.n.a.r0.b;

public final class b$b {
    private String a;
    private String b;
    private ParcelUuid c;
    private ParcelUuid d;
    private ParcelUuid e;
    private byte[] f;
    private byte[] g;
    private int h = -1;
    private byte[] i;
    private byte[] j;

    public b a() {
        String string2 = this.a;
        String string3 = this.b;
        ParcelUuid parcelUuid = this.c;
        ParcelUuid parcelUuid2 = this.d;
        ParcelUuid parcelUuid3 = this.e;
        byte[] byArray = this.f;
        byte[] byArray2 = this.g;
        int n10 = this.h;
        byte[] byArray3 = this.i;
        byte[] byArray4 = this.j;
        b b10 = new b(string2, string3, parcelUuid, parcelUuid2, parcelUuid3, byArray, byArray2, n10, byArray3, byArray4);
        return b10;
    }

    public b$b b(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = BluetoothAdapter.checkBluetoothAddress((String)string2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid device address ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        this.b = string2;
        return this;
    }

    public b$b c(String string2) {
        this.a = string2;
        return this;
    }

    public b$b d(int n10, byte[] byArray) {
        if (byArray != null && n10 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid manufacture id");
            throw illegalArgumentException;
        }
        this.h = n10;
        this.i = byArray;
        this.j = null;
        return this;
    }

    public b$b e(int n10, byte[] byArray, byte[] byArray2) {
        if (byArray != null && n10 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid manufacture id");
            throw illegalArgumentException;
        }
        byte[] byArray3 = this.j;
        if (byArray3 != null) {
            byte[] byArray4 = this.i;
            if (byArray4 != null) {
                int n11 = byArray4.length;
                int n12 = byArray3.length;
                if (n11 != n12) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    throw illegalArgumentException;
                }
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                throw illegalArgumentException;
            }
        }
        this.h = n10;
        this.i = byArray;
        this.j = byArray2;
        return this;
    }

    public b$b f(ParcelUuid object, byte[] byArray) {
        if (object != null) {
            this.e = object;
            this.f = byArray;
            this.g = null;
            return this;
        }
        object = new IllegalArgumentException("serviceDataUuid is null");
        throw object;
    }

    public b$b g(ParcelUuid object, byte[] byArray, byte[] byArray2) {
        if (object != null) {
            byte[] byArray3 = this.g;
            if (byArray3 != null) {
                byte[] byArray4 = this.f;
                if (byArray4 != null) {
                    int n10 = byArray4.length;
                    int n11 = byArray3.length;
                    if (n10 != n11) {
                        object = new IllegalArgumentException("size mismatch for service data and service data mask");
                        throw object;
                    }
                } else {
                    object = new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    throw object;
                }
            }
            this.e = object;
            this.f = byArray;
            this.g = byArray2;
            return this;
        }
        object = new IllegalArgumentException("serviceDataUuid is null");
        throw object;
    }

    public b$b h(ParcelUuid parcelUuid) {
        this.c = parcelUuid;
        this.d = null;
        return this;
    }

    public b$b i(ParcelUuid object, ParcelUuid parcelUuid) {
        ParcelUuid parcelUuid2 = this.d;
        if (parcelUuid2 != null && (parcelUuid2 = this.c) == null) {
            object = new IllegalArgumentException("uuid is null while uuidMask is not null!");
            throw object;
        }
        this.c = object;
        this.d = parcelUuid;
        return this;
    }
}

