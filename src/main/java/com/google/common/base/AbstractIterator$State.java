/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

public final class AbstractIterator$State
extends Enum {
    private static final /* synthetic */ AbstractIterator$State[] $VALUES;
    public static final /* enum */ AbstractIterator$State DONE;
    public static final /* enum */ AbstractIterator$State FAILED;
    public static final /* enum */ AbstractIterator$State NOT_READY;
    public static final /* enum */ AbstractIterator$State READY;

    static {
        AbstractIterator$State abstractIterator$State;
        AbstractIterator$State abstractIterator$State2;
        AbstractIterator$State abstractIterator$State3;
        AbstractIterator$State abstractIterator$State4;
        READY = abstractIterator$State4 = new AbstractIterator$State("READY", 0);
        int n10 = 1;
        NOT_READY = abstractIterator$State3 = new AbstractIterator$State("NOT_READY", n10);
        int n11 = 2;
        DONE = abstractIterator$State2 = new AbstractIterator$State("DONE", n11);
        int n12 = 3;
        FAILED = abstractIterator$State = new AbstractIterator$State("FAILED", n12);
        AbstractIterator$State[] abstractIterator$StateArray = new AbstractIterator$State[4];
        abstractIterator$StateArray[0] = abstractIterator$State4;
        abstractIterator$StateArray[n10] = abstractIterator$State3;
        abstractIterator$StateArray[n11] = abstractIterator$State2;
        abstractIterator$StateArray[n12] = abstractIterator$State;
        $VALUES = abstractIterator$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AbstractIterator$State() {
        void var2_-1;
        void var1_-1;
    }

    public static AbstractIterator$State valueOf(String string2) {
        return Enum.valueOf(AbstractIterator$State.class, string2);
    }

    public static AbstractIterator$State[] values() {
        return (AbstractIterator$State[])$VALUES.clone();
    }
}

