/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service$State;

public class AbstractService$6 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Service$State service$State;
        int n12 = Service$State.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$common$util$concurrent$Service$State = nArray;
        try {
            service$State = Service$State.NEW;
            n11 = service$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$util$concurrent$Service$State;
            service$State = Service$State.STARTING;
            n11 = service$State.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$util$concurrent$Service$State;
            service$State = Service$State.RUNNING;
            n11 = service$State.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$util$concurrent$Service$State;
            service$State = Service$State.STOPPING;
            n11 = service$State.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$util$concurrent$Service$State;
            service$State = Service$State.TERMINATED;
            n11 = service$State.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$util$concurrent$Service$State;
            service$State = Service$State.FAILED;
            n11 = service$State.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

