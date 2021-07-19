/*
 * Decompiled with CFR 0.151.
 */
package f.o2.a;

import f.h2.t.f0;
import f.n2.m;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.LongStream;

public final class a$c
implements m {
    public final /* synthetic */ LongStream a;

    public a$c(LongStream longStream) {
        this.a = longStream;
    }

    public Iterator iterator() {
        PrimitiveIterator.OfLong ofLong = this.a.iterator();
        f0.o(ofLong, "iterator()");
        return ofLong;
    }
}

