/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.x0.a;
import java.util.Iterator;

public abstract class q
implements Iterator,
a {
    public final Byte b() {
        return this.nextByte();
    }

    public abstract byte nextByte();

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

