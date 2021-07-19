/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.d0;
import java.util.NoSuchElementException;

public final class e
extends d0 {
    private int a;
    private final float[] b;

    public e(float[] fArray) {
        f0.p(fArray, "array");
        this.b = fArray;
    }

    public float c() {
        int n10;
        float[] fArray;
        try {
            fArray = this.b;
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
        return fArray[n10];
    }

    public boolean hasNext() {
        int n10 = this.a;
        float[] fArray = this.b;
        int n11 = fArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

