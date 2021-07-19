/*
 * Decompiled with CFR 0.151.
 */
package f.o2.a;

import f.h2.t.f0;
import f.n2.m;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.DoubleStream;

public final class a$d
implements m {
    public final /* synthetic */ DoubleStream a;

    public a$d(DoubleStream doubleStream) {
        this.a = doubleStream;
    }

    public Iterator iterator() {
        PrimitiveIterator.OfDouble ofDouble = this.a.iterator();
        f0.o(ofDouble, "iterator()");
        return ofDouble;
    }
}

