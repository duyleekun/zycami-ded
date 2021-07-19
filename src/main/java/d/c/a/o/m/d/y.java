/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.m.d;

import android.os.ParcelFileDescriptor;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.m.d.o;

public final class y
implements g {
    private final o a;

    public y(o o10) {
        this.a = o10;
    }

    public s c(ParcelFileDescriptor parcelFileDescriptor, int n10, int n11, f f10) {
        return this.a.d(parcelFileDescriptor, n10, n11, f10);
    }

    public boolean d(ParcelFileDescriptor parcelFileDescriptor, f f10) {
        return this.a.o(parcelFileDescriptor);
    }
}

