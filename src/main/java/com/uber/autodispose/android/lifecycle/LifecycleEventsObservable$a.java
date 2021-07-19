/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle$State;

public class LifecycleEventsObservable$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Lifecycle$State lifecycle$State;
        int n12 = Lifecycle$State.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            lifecycle$State = Lifecycle$State.INITIALIZED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$State = Lifecycle$State.CREATED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$State = Lifecycle$State.STARTED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$State = Lifecycle$State.RESUMED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$State = Lifecycle$State.DESTROYED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

