/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelUuid
 *  android.util.SparseArray
 */
package d.n.a.q0.v;

import android.os.ParcelUuid;
import android.util.SparseArray;
import d.n.a.r0.c;
import java.util.List;
import java.util.Map;

public class s
implements c {
    private final int a;
    private final List b;
    private final SparseArray c;
    private final Map d;
    private final int e;
    private final String f;
    private final byte[] g;

    public s(List list, SparseArray sparseArray, Map map, int n10, int n11, String string2, byte[] byArray) {
        this.b = list;
        this.c = sparseArray;
        this.d = map;
        this.f = string2;
        this.a = n10;
        this.e = n11;
        this.g = byArray;
    }

    public int a() {
        return this.a;
    }

    public byte[] b(int n10) {
        return (byte[])this.c.get(n10);
    }

    public SparseArray c() {
        return this.c;
    }

    public List d() {
        return this.b;
    }

    public Map e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public byte[] g() {
        return this.g;
    }

    public String h() {
        return this.f;
    }

    public byte[] i(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return (byte[])this.d.get(parcelUuid);
    }
}

