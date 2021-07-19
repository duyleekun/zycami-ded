/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.dialog;

import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PRIME_STATUS;

public class PrimeGetDialogViewModel$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS;
        int n12 = PrimeGetDialogViewModel$PRIME_STATUS.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_PENDING;
            n11 = primeGetDialogViewModel$PRIME_STATUS.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_RECEIVING;
            n11 = primeGetDialogViewModel$PRIME_STATUS.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_FAIL;
            n11 = primeGetDialogViewModel$PRIME_STATUS.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_SUCCESS;
            n11 = primeGetDialogViewModel$PRIME_STATUS.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

