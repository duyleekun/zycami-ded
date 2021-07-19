/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import io.reactivex.internal.operators.single.SingleInternalHelper$b;
import java.util.Iterator;

public final class SingleInternalHelper$a
implements Iterable {
    private final Iterable a;

    public SingleInternalHelper$a(Iterable iterable) {
        this.a = iterable;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.a.iterator();
        SingleInternalHelper$b singleInternalHelper$b = new SingleInternalHelper$b(iterator2);
        return singleInternalHelper$b;
    }
}

