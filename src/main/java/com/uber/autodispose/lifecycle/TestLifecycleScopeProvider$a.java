/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle;

public class TestLifecycleScopeProvider$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        TestLifecycleScopeProvider$TestLifecycle testLifecycleScopeProvider$TestLifecycle;
        int n12 = TestLifecycleScopeProvider$TestLifecycle.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            testLifecycleScopeProvider$TestLifecycle = TestLifecycleScopeProvider$TestLifecycle.STARTED;
            n11 = testLifecycleScopeProvider$TestLifecycle.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            testLifecycleScopeProvider$TestLifecycle = TestLifecycleScopeProvider$TestLifecycle.STOPPED;
            n11 = testLifecycleScopeProvider$TestLifecycle.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

