/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.x0.a;
import java.util.Iterator;

public abstract class m0
implements Iterator,
a {
    public final Long b() {
        return this.c();
    }

    public abstract long c();

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

