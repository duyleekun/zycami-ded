/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.r;
import java.util.NoSuchElementException;

public final class c
extends r {
    private int a;
    private final char[] b;

    public c(char[] cArray) {
        f0.p(cArray, "array");
        this.b = cArray;
    }

    public char c() {
        int n10;
        char[] cArray;
        try {
            cArray = this.b;
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
        return cArray[n10];
    }

    public boolean hasNext() {
        int n10 = this.a;
        char[] cArray = this.b;
        int n11 = cArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

