/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.m0;
import java.util.NoSuchElementException;

public final class j
extends m0 {
    private int a;
    private final long[] b;

    public j(long[] lArray) {
        f0.p(lArray, "array");
        this.b = lArray;
    }

    public long c() {
        int n10;
        long[] lArray;
        try {
            lArray = this.b;
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
        return lArray[n10];
    }

    public boolean hasNext() {
        int n10 = this.a;
        long[] lArray = this.b;
        int n11 = lArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

