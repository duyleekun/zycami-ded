/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.x0.a;
import java.util.Enumeration;
import java.util.Iterator;

public final class v$a
implements Iterator,
a {
    public final /* synthetic */ Enumeration a;

    public v$a(Enumeration enumeration) {
        this.a = enumeration;
    }

    public boolean hasNext() {
        return this.a.hasMoreElements();
    }

    public Object next() {
        return this.a.nextElement();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

