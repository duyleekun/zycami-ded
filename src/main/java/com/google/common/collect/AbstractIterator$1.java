/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator$State;

public class AbstractIterator$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$AbstractIterator$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        AbstractIterator$State abstractIterator$State;
        int n12 = AbstractIterator$State.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$common$collect$AbstractIterator$State = nArray;
        try {
            abstractIterator$State = AbstractIterator$State.DONE;
            n11 = abstractIterator$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$collect$AbstractIterator$State;
            abstractIterator$State = AbstractIterator$State.READY;
            n11 = abstractIterator$State.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

