/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.n$a;
import f.h2.t.f0;
import f.n2.m;
import java.io.BufferedReader;
import java.util.Iterator;

public final class n
implements m {
    private final BufferedReader a;

    public n(BufferedReader bufferedReader) {
        f0.p(bufferedReader, "reader");
        this.a = bufferedReader;
    }

    public static final /* synthetic */ BufferedReader c(n n10) {
        return n10.a;
    }

    public Iterator iterator() {
        n$a n$a = new n$a(this);
        return n$a;
    }
}

