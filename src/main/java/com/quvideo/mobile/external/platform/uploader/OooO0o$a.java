/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.uploader.OooO0o;
import d.o.a.a.b.c.c;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class OooO0o$a
implements Iterator {
    public final Object[] a;
    public int b;
    public int c = -1;
    public final /* synthetic */ OooO0o d;

    public OooO0o$a(OooO0o oooO0o, Object[] objectArray) {
        this.d = oooO0o;
        this.a = objectArray;
    }

    public c a() {
        int n10 = this.b;
        Object[] objectArray = this.a;
        int n11 = objectArray.length;
        if (n10 < n11) {
            this.c = n10;
            this.b = n11 = n10 + 1;
            return (c)objectArray[n10];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public boolean hasNext() {
        int n10 = this.b;
        Object[] objectArray = this.a;
        int n11 = objectArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public void remove() {
        int n10 = this.c;
        if (n10 >= 0) {
            OooO0o oooO0o = this.d;
            Object object = this.a[n10];
            oooO0o.remove(object);
            this.c = -1;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

