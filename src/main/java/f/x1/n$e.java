/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;

public final class n$e
extends c
implements RandomAccess {
    public final /* synthetic */ float[] b;

    public n$e(float[] fArray) {
        this.b = fArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(float f10) {
        float[] fArray = this.b;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 0;
        while (true) {
            int n13;
            int n14 = 1;
            float f11 = Float.MIN_VALUE;
            if (n12 >= n10) break;
            float f12 = fArray[n12];
            int n15 = Float.floatToIntBits(f12);
            if (n15 == (n13 = Float.floatToIntBits(f10))) {
                n15 = n14;
                f12 = f11;
            } else {
                n15 = 0;
                f12 = 0.0f;
            }
            if (n15 != 0) {
                n11 = n14;
                break;
            }
            ++n12;
        }
        return n11 != 0;
    }

    public Float e(int n10) {
        return Float.valueOf(this.b[n10]);
    }

    public int f(float f10) {
        int n10;
        block4: {
            float[] fArray = this.b;
            int n11 = fArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                int n12;
                float f11 = fArray[n10];
                int n13 = Float.floatToIntBits(f11);
                if (n13 == (n12 = Float.floatToIntBits(f10))) {
                    n13 = 1;
                    f11 = Float.MIN_VALUE;
                } else {
                    n13 = 0;
                    f11 = 0.0f;
                }
                if (n13 == 0) {
                    continue;
                }
                break block4;
            }
            n10 = -1;
        }
        return n10;
    }

    public int g(float f10) {
        float[] fArray = this.b;
        int n10 = fArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            int n12;
            float f11 = fArray[n10];
            int n13 = Float.floatToIntBits(f11);
            if (n13 == (n12 = Float.floatToIntBits(f10))) {
                n13 = 1;
                f11 = Float.MIN_VALUE;
            } else {
                n13 = 0;
                f11 = 0.0f;
            }
            if (n13 != 0) {
                n11 = n10;
                break;
            }
            n10 += -1;
        }
        return n11;
    }

    public boolean isEmpty() {
        float[] fArray = this.b;
        boolean bl2 = fArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            fArray = null;
        }
        return bl2;
    }
}

