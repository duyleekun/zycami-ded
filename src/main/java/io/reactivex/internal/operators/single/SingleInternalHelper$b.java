/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.j;
import e.a.o0;
import io.reactivex.internal.operators.single.SingleToFlowable;
import java.util.Iterator;

public final class SingleInternalHelper$b
implements Iterator {
    private final Iterator a;

    public SingleInternalHelper$b(Iterator iterator2) {
        this.a = iterator2;
    }

    public j a() {
        o0 o02 = (o0)this.a.next();
        SingleToFlowable singleToFlowable = new SingleToFlowable(o02);
        return singleToFlowable;
    }

    public boolean hasNext() {
        return this.a.hasNext();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

