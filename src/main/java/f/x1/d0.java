/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.x0.a;
import java.util.Iterator;

public abstract class d0
implements Iterator,
a {
    public final Float b() {
        return Float.valueOf(this.c());
    }

    public abstract float c();

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

