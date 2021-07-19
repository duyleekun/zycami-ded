/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.x0.a;
import java.util.Iterator;
import java.util.Map;

public final class AbstractMap$c$a
implements Iterator,
a {
    public final /* synthetic */ Iterator a;

    public AbstractMap$c$a(Iterator iterator2) {
        this.a = iterator2;
    }

    public boolean hasNext() {
        return this.a.hasNext();
    }

    public Object next() {
        return ((Map.Entry)this.a.next()).getValue();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

