/*
 * Decompiled with CFR 0.151.
 */
package f.o2.a;

import f.h2.t.f0;
import f.n2.m;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public final class a$b
implements m {
    public final /* synthetic */ IntStream a;

    public a$b(IntStream intStream) {
        this.a = intStream;
    }

    public Iterator iterator() {
        PrimitiveIterator.OfInt ofInt = this.a.iterator();
        f0.o(ofInt, "iterator()");
        return ofInt;
    }
}

