/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.h2.t.f0;
import java.io.ByteArrayOutputStream;

public final class f
extends ByteArrayOutputStream {
    public f(int n10) {
        super(n10);
    }

    public final byte[] a() {
        byte[] byArray = this.buf;
        f0.o(byArray, "buf");
        return byArray;
    }
}

