/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.d;
import java.io.IOException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class e {
    public abstract int a();

    public abstract e a(b var1);

    public e a(byte[] byArray) {
        int n10 = byArray.length;
        return this.a(byArray, 0, n10);
    }

    public e a(byte[] object, int n10, int n11) {
        object = b.a((byte[])object, n10, n11);
        this.a((b)object);
        n10 = 0;
        try {
            ((b)object).a(0);
            return this;
        }
        catch (IOException iOException) {
            object = new RuntimeException;
            ((RuntimeException)object)("Reading from a byte array threw an IOException (should never happen).");
            throw object;
        }
        catch (d d10) {
            throw d10;
        }
    }

    public abstract void a(c var1);

    public void a(byte[] object, int n10, int n11) {
        try {
            object = c.a((byte[])object, n10, n11);
        }
        catch (IOException iOException) {
            object = new RuntimeException;
            ((RuntimeException)object)("Serializing to a byte array threw an IOException (should never happen).");
            throw object;
        }
        this.a((c)object);
        ((c)object).b();
    }

    public boolean a(b b10, int n10) {
        return b10.a(n10);
    }

    public byte[] a() {
        int n10 = this.b();
        byte[] byArray = new byte[n10];
        this.a(byArray, 0, n10);
        return byArray;
    }

    public abstract int b();
}

