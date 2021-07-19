/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.u;
import f.x1.c;
import h.c0$a;
import java.util.RandomAccess;
import okio.ByteString;

public final class c0
extends c
implements RandomAccess {
    public static final c0$a d;
    private final ByteString[] b;
    private final int[] c;

    static {
        c0$a c0$a;
        d = c0$a = new c0$a(null);
    }

    private c0(ByteString[] byteStringArray, int[] nArray) {
        this.b = byteStringArray;
        this.c = nArray;
    }

    public /* synthetic */ c0(ByteString[] byteStringArray, int[] nArray, u u10) {
        this(byteStringArray, nArray);
    }

    public static final c0 j(ByteString ... byteStringArray) {
        return d.d(byteStringArray);
    }

    public int b() {
        return this.b.length;
    }

    public ByteString e(int n10) {
        return this.b[n10];
    }

    public final ByteString[] f() {
        return this.b;
    }

    public final int[] g() {
        return this.c;
    }
}

