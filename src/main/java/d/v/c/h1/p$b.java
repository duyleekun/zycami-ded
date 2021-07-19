/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import com.zhiyun.cama.data.PagingRequestHelper$Status;

public class p$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PagingRequestHelper$Status pagingRequestHelper$Status;
        int n12 = PagingRequestHelper$Status.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            pagingRequestHelper$Status = PagingRequestHelper$Status.RUNNING;
            n11 = pagingRequestHelper$Status.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            pagingRequestHelper$Status = PagingRequestHelper$Status.SUCCESS;
            n11 = pagingRequestHelper$Status.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            pagingRequestHelper$Status = PagingRequestHelper$Status.FAILED;
            n11 = pagingRequestHelper$Status.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

