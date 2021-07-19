/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.dialog;

public final class PrimeGetDialogViewModel$PrimeShowType
extends Enum {
    public static final /* enum */ PrimeGetDialogViewModel$PrimeShowType PRIME_SHOW_TYPE_OFFICIAL;
    public static final /* enum */ PrimeGetDialogViewModel$PrimeShowType PRIME_SHOW_TYPE_VISITOR;
    public static final /* enum */ PrimeGetDialogViewModel$PrimeShowType PRIME_SHOW_WEB_VIEW;
    private static final /* synthetic */ PrimeGetDialogViewModel$PrimeShowType[] a;
    public int id;

    static {
        PrimeGetDialogViewModel$PrimeShowType primeGetDialogViewModel$PrimeShowType;
        PrimeGetDialogViewModel$PrimeShowType primeGetDialogViewModel$PrimeShowType2;
        PrimeGetDialogViewModel$PrimeShowType primeGetDialogViewModel$PrimeShowType3;
        PRIME_SHOW_TYPE_OFFICIAL = primeGetDialogViewModel$PrimeShowType3 = new PrimeGetDialogViewModel$PrimeShowType("PRIME_SHOW_TYPE_OFFICIAL", 0, 0);
        int n10 = 1;
        PRIME_SHOW_TYPE_VISITOR = primeGetDialogViewModel$PrimeShowType2 = new PrimeGetDialogViewModel$PrimeShowType("PRIME_SHOW_TYPE_VISITOR", n10, n10);
        int n11 = 2;
        int n12 = 3;
        PRIME_SHOW_WEB_VIEW = primeGetDialogViewModel$PrimeShowType = new PrimeGetDialogViewModel$PrimeShowType("PRIME_SHOW_WEB_VIEW", n11, n12);
        PrimeGetDialogViewModel$PrimeShowType[] primeGetDialogViewModel$PrimeShowTypeArray = new PrimeGetDialogViewModel$PrimeShowType[n12];
        primeGetDialogViewModel$PrimeShowTypeArray[0] = primeGetDialogViewModel$PrimeShowType3;
        primeGetDialogViewModel$PrimeShowTypeArray[n10] = primeGetDialogViewModel$PrimeShowType2;
        primeGetDialogViewModel$PrimeShowTypeArray[n11] = primeGetDialogViewModel$PrimeShowType;
        a = primeGetDialogViewModel$PrimeShowTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PrimeGetDialogViewModel$PrimeShowType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.id = var3_1;
    }

    public static PrimeGetDialogViewModel$PrimeShowType fromId(int n10) {
        for (PrimeGetDialogViewModel$PrimeShowType primeGetDialogViewModel$PrimeShowType : PrimeGetDialogViewModel$PrimeShowType.values()) {
            int n11 = primeGetDialogViewModel$PrimeShowType.getId();
            if (n10 != n11) continue;
            return primeGetDialogViewModel$PrimeShowType;
        }
        return PRIME_SHOW_TYPE_OFFICIAL;
    }

    public static PrimeGetDialogViewModel$PrimeShowType valueOf(String string2) {
        return Enum.valueOf(PrimeGetDialogViewModel$PrimeShowType.class, string2);
    }

    public static PrimeGetDialogViewModel$PrimeShowType[] values() {
        return (PrimeGetDialogViewModel$PrimeShowType[])a.clone();
    }

    public int getId() {
        return this.id;
    }
}

