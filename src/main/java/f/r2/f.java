/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import java.util.concurrent.TimeUnit;

public final class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] nArray = new int[TimeUnit.values().length];
        a = nArray;
        int n10 = TimeUnit.NANOSECONDS.ordinal();
        nArray[n10] = 1;
        n10 = TimeUnit.MICROSECONDS.ordinal();
        nArray[n10] = 2;
        n10 = TimeUnit.MILLISECONDS.ordinal();
        nArray[n10] = 3;
        n10 = TimeUnit.SECONDS.ordinal();
        nArray[n10] = 4;
        n10 = TimeUnit.MINUTES.ordinal();
        nArray[n10] = 5;
        n10 = TimeUnit.HOURS.ordinal();
        nArray[n10] = 6;
        n10 = TimeUnit.DAYS.ordinal();
        nArray[n10] = 7;
    }
}

