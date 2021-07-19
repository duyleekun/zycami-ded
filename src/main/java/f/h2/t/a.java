/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.p;
import java.util.NoSuchElementException;

public final class a
extends p {
    private int a;
    private final boolean[] b;

    public a(boolean[] blArray) {
        f0.p(blArray, "array");
        this.b = blArray;
    }

    public boolean c() {
        int n10;
        boolean[] blArray;
        try {
            blArray = this.b;
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
        return blArray[n10];
    }

    public boolean hasNext() {
        int n10 = this.a;
        boolean[] blArray = this.b;
        int n11 = blArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

