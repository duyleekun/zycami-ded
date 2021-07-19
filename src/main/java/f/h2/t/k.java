/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.f1;
import java.util.NoSuchElementException;

public final class k
extends f1 {
    private int a;
    private final short[] b;

    public k(short[] sArray) {
        f0.p(sArray, "array");
        this.b = sArray;
    }

    public short c() {
        int n10;
        short[] sArray;
        try {
            sArray = this.b;
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
        return sArray[n10];
    }

    public boolean hasNext() {
        int n10 = this.a;
        short[] sArray = this.b;
        int n11 = sArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

