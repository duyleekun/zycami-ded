/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.j;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import d.c.a.o.j.e;
import d.c.a.o.j.m$b;

public final class m
implements e {
    private final m$b a;

    public m(ParcelFileDescriptor parcelFileDescriptor) {
        m$b m$b;
        this.a = m$b = new m$b(parcelFileDescriptor);
    }

    public static boolean c() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public void b() {
    }

    public ParcelFileDescriptor d() {
        return this.a.a();
    }
}

