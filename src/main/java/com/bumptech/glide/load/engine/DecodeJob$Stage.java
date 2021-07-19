/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

public final class DecodeJob$Stage
extends Enum {
    public static final /* enum */ DecodeJob$Stage DATA_CACHE;
    public static final /* enum */ DecodeJob$Stage ENCODE;
    public static final /* enum */ DecodeJob$Stage FINISHED;
    public static final /* enum */ DecodeJob$Stage INITIALIZE;
    public static final /* enum */ DecodeJob$Stage RESOURCE_CACHE;
    public static final /* enum */ DecodeJob$Stage SOURCE;
    private static final /* synthetic */ DecodeJob$Stage[] a;

    static {
        DecodeJob$Stage decodeJob$Stage;
        DecodeJob$Stage decodeJob$Stage2;
        DecodeJob$Stage decodeJob$Stage3;
        DecodeJob$Stage decodeJob$Stage4;
        DecodeJob$Stage decodeJob$Stage5;
        DecodeJob$Stage decodeJob$Stage6;
        INITIALIZE = decodeJob$Stage6 = new DecodeJob$Stage("INITIALIZE", 0);
        int n10 = 1;
        RESOURCE_CACHE = decodeJob$Stage5 = new DecodeJob$Stage("RESOURCE_CACHE", n10);
        int n11 = 2;
        DATA_CACHE = decodeJob$Stage4 = new DecodeJob$Stage("DATA_CACHE", n11);
        int n12 = 3;
        SOURCE = decodeJob$Stage3 = new DecodeJob$Stage("SOURCE", n12);
        int n13 = 4;
        ENCODE = decodeJob$Stage2 = new DecodeJob$Stage("ENCODE", n13);
        int n14 = 5;
        FINISHED = decodeJob$Stage = new DecodeJob$Stage("FINISHED", n14);
        DecodeJob$Stage[] decodeJob$StageArray = new DecodeJob$Stage[6];
        decodeJob$StageArray[0] = decodeJob$Stage6;
        decodeJob$StageArray[n10] = decodeJob$Stage5;
        decodeJob$StageArray[n11] = decodeJob$Stage4;
        decodeJob$StageArray[n12] = decodeJob$Stage3;
        decodeJob$StageArray[n13] = decodeJob$Stage2;
        decodeJob$StageArray[n14] = decodeJob$Stage;
        a = decodeJob$StageArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DecodeJob$Stage() {
        void var2_-1;
        void var1_-1;
    }

    public static DecodeJob$Stage valueOf(String string2) {
        return Enum.valueOf(DecodeJob$Stage.class, string2);
    }

    public static DecodeJob$Stage[] values() {
        return (DecodeJob$Stage[])a.clone();
    }
}

