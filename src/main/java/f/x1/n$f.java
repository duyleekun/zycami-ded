/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;

public final class n$f
extends c
implements RandomAccess {
    public final /* synthetic */ double[] b;

    public n$f(double[] dArray) {
        this.b = dArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(double d10) {
        double[] dArray = this.b;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 0;
        while (true) {
            long l10;
            int n13 = 1;
            if (n12 >= n10) break;
            double d11 = dArray[n12];
            long l11 = Double.doubleToLongBits(d11);
            long l12 = l11 - (l10 = Double.doubleToLongBits(d10));
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            object = object == false ? (Object)n13 : (Object)0;
            if (object != false) {
                n11 = n13;
                break;
            }
            ++n12;
        }
        return n11 != 0;
    }

    public Double e(int n10) {
        return this.b[n10];
    }

    public int f(double d10) {
        int n10;
        block2: {
            double[] dArray = this.b;
            int n11 = dArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10;
                double d11 = dArray[n10];
                long l11 = Double.doubleToLongBits(d11);
                long l12 = l11 - (l10 = Double.doubleToLongBits(d10));
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                object = object == false ? (Object)1 : (Object)0;
                if (object == false) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    public int g(double d10) {
        double[] dArray = this.b;
        int n10 = dArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            long l10;
            double d11 = dArray[n10];
            long l11 = Double.doubleToLongBits(d11);
            long l12 = l11 - (l10 = Double.doubleToLongBits(d10));
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            object = object == false ? (Object)1 : (Object)0;
            if (object != false) {
                n11 = n10;
                break;
            }
            n10 += -1;
        }
        return n11;
    }

    public boolean isEmpty() {
        double[] dArray = this.b;
        boolean bl2 = dArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            dArray = null;
        }
        return bl2;
    }
}

