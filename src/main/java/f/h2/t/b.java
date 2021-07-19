/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.q;
import java.util.NoSuchElementException;

public final class b
extends q {
    private int a;
    private final byte[] b;

    public b(byte[] byArray) {
        f0.p(byArray, "array");
        this.b = byArray;
    }

    public boolean hasNext() {
        int n10 = this.a;
        byte[] byArray = this.b;
        int n11 = byArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public byte nextByte() {
        int n10;
        byte[] byArray;
        try {
            byArray = this.b;
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
        return byArray[n10];
    }
}

