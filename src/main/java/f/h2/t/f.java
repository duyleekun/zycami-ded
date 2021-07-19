/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.l0;
import java.util.NoSuchElementException;

public final class f
extends l0 {
    private int a;
    private final int[] b;

    public f(int[] nArray) {
        f0.p(nArray, "array");
        this.b = nArray;
    }

    public int c() {
        int n10;
        int[] nArray;
        try {
            nArray = this.b;
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
        return nArray[n10];
    }

    public boolean hasNext() {
        int n10 = this.a;
        int[] nArray = this.b;
        int n11 = nArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

