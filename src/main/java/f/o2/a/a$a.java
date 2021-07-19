/*
 * Decompiled with CFR 0.151.
 */
package f.o2.a;

import f.h2.t.f0;
import f.n2.m;
import java.util.Iterator;
import java.util.stream.Stream;

public final class a$a
implements m {
    public final /* synthetic */ Stream a;

    public a$a(Stream stream) {
        this.a = stream;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.a.iterator();
        f0.o(iterator2, "iterator()");
        return iterator2;
    }
}

