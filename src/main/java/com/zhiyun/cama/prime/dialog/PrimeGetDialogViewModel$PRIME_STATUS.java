/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.dialog;

public final class PrimeGetDialogViewModel$PRIME_STATUS
extends Enum {
    public static final /* enum */ PrimeGetDialogViewModel$PRIME_STATUS PRIME_STATUS_FAIL;
    public static final /* enum */ PrimeGetDialogViewModel$PRIME_STATUS PRIME_STATUS_PENDING;
    public static final /* enum */ PrimeGetDialogViewModel$PRIME_STATUS PRIME_STATUS_RECEIVING;
    public static final /* enum */ PrimeGetDialogViewModel$PRIME_STATUS PRIME_STATUS_SUCCESS;
    private static final /* synthetic */ PrimeGetDialogViewModel$PRIME_STATUS[] a;

    static {
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS;
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS2;
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS3;
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS4;
        PRIME_STATUS_PENDING = primeGetDialogViewModel$PRIME_STATUS4 = new PrimeGetDialogViewModel$PRIME_STATUS("PRIME_STATUS_PENDING", 0);
        int n10 = 1;
        PRIME_STATUS_RECEIVING = primeGetDialogViewModel$PRIME_STATUS3 = new PrimeGetDialogViewModel$PRIME_STATUS("PRIME_STATUS_RECEIVING", n10);
        int n11 = 2;
        PRIME_STATUS_SUCCESS = primeGetDialogViewModel$PRIME_STATUS2 = new PrimeGetDialogViewModel$PRIME_STATUS("PRIME_STATUS_SUCCESS", n11);
        int n12 = 3;
        PRIME_STATUS_FAIL = primeGetDialogViewModel$PRIME_STATUS = new PrimeGetDialogViewModel$PRIME_STATUS("PRIME_STATUS_FAIL", n12);
        PrimeGetDialogViewModel$PRIME_STATUS[] primeGetDialogViewModel$PRIME_STATUSArray = new PrimeGetDialogViewModel$PRIME_STATUS[4];
        primeGetDialogViewModel$PRIME_STATUSArray[0] = primeGetDialogViewModel$PRIME_STATUS4;
        primeGetDialogViewModel$PRIME_STATUSArray[n10] = primeGetDialogViewModel$PRIME_STATUS3;
        primeGetDialogViewModel$PRIME_STATUSArray[n11] = primeGetDialogViewModel$PRIME_STATUS2;
        primeGetDialogViewModel$PRIME_STATUSArray[n12] = primeGetDialogViewModel$PRIME_STATUS;
        a = primeGetDialogViewModel$PRIME_STATUSArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PrimeGetDialogViewModel$PRIME_STATUS() {
        void var2_-1;
        void var1_-1;
    }

    public static PrimeGetDialogViewModel$PRIME_STATUS valueOf(String string2) {
        return Enum.valueOf(PrimeGetDialogViewModel$PRIME_STATUS.class, string2);
    }

    public static PrimeGetDialogViewModel$PRIME_STATUS[] values() {
        return (PrimeGetDialogViewModel$PRIME_STATUS[])a.clone();
    }
}

