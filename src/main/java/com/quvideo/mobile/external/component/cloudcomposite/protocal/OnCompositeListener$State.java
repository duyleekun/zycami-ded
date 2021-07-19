/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.protocal;

public final class OnCompositeListener$State
extends Enum {
    private static final /* synthetic */ OnCompositeListener$State[] $VALUES;
    public static final /* enum */ OnCompositeListener$State CANCEL;
    public static final /* enum */ OnCompositeListener$State COMPOSITE;
    public static final /* enum */ OnCompositeListener$State FAILURE;
    public static final /* enum */ OnCompositeListener$State FAILURE_FORCEMAKE;
    public static final /* enum */ OnCompositeListener$State IDEL;
    public static final /* enum */ OnCompositeListener$State QUERY;
    public static final /* enum */ OnCompositeListener$State RELEASE;
    public static final /* enum */ OnCompositeListener$State SUCCESS;
    public static final /* enum */ OnCompositeListener$State TIMEOUT;
    public static final /* enum */ OnCompositeListener$State UPLOAD;

    static {
        OnCompositeListener$State onCompositeListener$State;
        OnCompositeListener$State onCompositeListener$State2;
        OnCompositeListener$State onCompositeListener$State3;
        OnCompositeListener$State onCompositeListener$State4;
        OnCompositeListener$State onCompositeListener$State5;
        OnCompositeListener$State onCompositeListener$State6;
        OnCompositeListener$State onCompositeListener$State7;
        OnCompositeListener$State onCompositeListener$State8;
        OnCompositeListener$State onCompositeListener$State9;
        OnCompositeListener$State onCompositeListener$State10;
        IDEL = onCompositeListener$State10 = new OnCompositeListener$State("IDEL", 0);
        int n10 = 1;
        UPLOAD = onCompositeListener$State9 = new OnCompositeListener$State("UPLOAD", n10);
        int n11 = 2;
        COMPOSITE = onCompositeListener$State8 = new OnCompositeListener$State("COMPOSITE", n11);
        int n12 = 3;
        QUERY = onCompositeListener$State7 = new OnCompositeListener$State("QUERY", n12);
        TIMEOUT = onCompositeListener$State6 = new OnCompositeListener$State("TIMEOUT", 4);
        SUCCESS = onCompositeListener$State5 = new OnCompositeListener$State("SUCCESS", 5);
        FAILURE = onCompositeListener$State4 = new OnCompositeListener$State("FAILURE", 6);
        FAILURE_FORCEMAKE = onCompositeListener$State3 = new OnCompositeListener$State("FAILURE_FORCEMAKE", 7);
        CANCEL = onCompositeListener$State2 = new OnCompositeListener$State("CANCEL", 8);
        int n13 = 9;
        RELEASE = onCompositeListener$State = new OnCompositeListener$State("RELEASE", n13);
        OnCompositeListener$State[] onCompositeListener$StateArray = new OnCompositeListener$State[10];
        onCompositeListener$StateArray[0] = onCompositeListener$State10;
        onCompositeListener$StateArray[n10] = onCompositeListener$State9;
        onCompositeListener$StateArray[n11] = onCompositeListener$State8;
        onCompositeListener$StateArray[n12] = onCompositeListener$State7;
        onCompositeListener$StateArray[4] = onCompositeListener$State6;
        onCompositeListener$StateArray[5] = onCompositeListener$State5;
        onCompositeListener$StateArray[6] = onCompositeListener$State4;
        onCompositeListener$StateArray[7] = onCompositeListener$State3;
        onCompositeListener$StateArray[8] = onCompositeListener$State2;
        onCompositeListener$StateArray[n13] = onCompositeListener$State;
        $VALUES = onCompositeListener$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OnCompositeListener$State() {
        void var2_-1;
        void var1_-1;
    }

    public static OnCompositeListener$State valueOf(String string2) {
        return Enum.valueOf(OnCompositeListener$State.class, string2);
    }

    public static OnCompositeListener$State[] values() {
        return (OnCompositeListener$State[])$VALUES.clone();
    }
}

