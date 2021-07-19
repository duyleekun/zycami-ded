/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.q.p;

class j {
    static final /* synthetic */ int[] a;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int[] nArray;
        int n10;
        block6: {
            p.values();
            n10 = 2;
            nArray = new int[n10];
            a = nArray;
            int n11 = 1;
            try {
                // empty try
            }
            catch (NoSuchFieldError noSuchFieldError) {
                break block6;
            }
            {
                nArray[0] = n11;
            }
        }
        try {
            nArray = a;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
        {
            nArray[n11] = n10;
            return;
        }
    }
}

