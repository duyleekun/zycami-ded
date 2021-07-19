/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.x0.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class g
implements Iterator,
a {
    private int a;
    private final Object[] b;

    public g(Object[] objectArray) {
        f0.p(objectArray, "array");
        this.b = objectArray;
    }

    public final Object[] b() {
        return this.b;
    }

    public boolean hasNext() {
        int n10 = this.a;
        Object[] objectArray = this.b;
        int n11 = objectArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        int n10;
        Object[] objectArray;
        try {
            objectArray = this.b;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.a = n10 = this.a + -1;
            String string2 = arrayIndexOutOfBoundsException.getMessage();
            NoSuchElementException noSuchElementException = new NoSuchElementException(string2);
            throw noSuchElementException;
        }
        n10 = this.a;
        int n11 = n10 + 1;
        this.a = n11;
        return objectArray[n10];
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

