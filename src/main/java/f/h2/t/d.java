/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.x1.b0;
import java.util.NoSuchElementException;

public final class d
extends b0 {
    private int a;
    private final double[] b;

    public d(double[] dArray) {
        f0.p(dArray, "array");
        this.b = dArray;
    }

    public double c() {
        int n10;
        double[] dArray;
        try {
            dArray = this.b;
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
        return dArray[n10];
    }

    public boolean hasNext() {
        int n10 = this.a;
        double[] dArray = this.b;
        int n11 = dArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }
}

