/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.x1.q;
import java.io.BufferedInputStream;
import java.util.NoSuchElementException;

public final class a$a
extends q {
    private int a = -1;
    private boolean b;
    private boolean c;
    public final /* synthetic */ BufferedInputStream d;

    public a$a(BufferedInputStream bufferedInputStream) {
        this.d = bufferedInputStream;
    }

    private final void g() {
        int n10 = this.b;
        if (n10 == 0 && (n10 = this.c) == 0) {
            boolean bl2;
            BufferedInputStream bufferedInputStream = this.d;
            this.a = n10 = bufferedInputStream.read();
            this.b = bl2 = true;
            int n11 = -1;
            if (n10 != n11) {
                bl2 = false;
            }
            this.c = bl2;
        }
    }

    public final boolean c() {
        return this.c;
    }

    public final int e() {
        return this.a;
    }

    public final boolean f() {
        return this.b;
    }

    public final void h(boolean bl2) {
        this.c = bl2;
    }

    public boolean hasNext() {
        this.g();
        return this.c ^ true;
    }

    public final void i(int n10) {
        this.a = n10;
    }

    public final void j(boolean bl2) {
        this.b = bl2;
    }

    public byte nextByte() {
        this.g();
        byte by2 = this.c;
        if (by2 == 0) {
            by2 = (byte)this.a;
            this.b = false;
            return by2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Input stream is over.");
        throw noSuchElementException;
    }
}

