/*
 * Decompiled with CFR 0.151.
 */
package f.o2.a;

import f.n2.m;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;

public final class a$e
implements Supplier {
    public final /* synthetic */ m a;

    public a$e(m m10) {
        this.a = m10;
    }

    public final Spliterator a() {
        return Spliterators.spliteratorUnknownSize(this.a.iterator(), 16);
    }
}

