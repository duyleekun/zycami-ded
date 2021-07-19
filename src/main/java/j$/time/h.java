/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

class h {
    static final /* synthetic */ int[] a;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        int[] nArray;
        block6: {
            j$.time.q.h.values();
            int n12 = 30;
            nArray = new int[n12];
            a = nArray;
            try {
                // empty try
            }
            catch (NoSuchFieldError noSuchFieldError) {
                break block6;
            }
            n11 = 28;
            n10 = 1;
            {
                nArray[n11] = n10;
            }
        }
        try {
            nArray = a;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
        n11 = 29;
        n10 = 2;
        {
            nArray[n11] = n10;
            return;
        }
    }
}

