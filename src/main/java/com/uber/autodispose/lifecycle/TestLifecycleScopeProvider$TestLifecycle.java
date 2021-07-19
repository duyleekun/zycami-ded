/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.lifecycle;

public final class TestLifecycleScopeProvider$TestLifecycle
extends Enum {
    public static final /* enum */ TestLifecycleScopeProvider$TestLifecycle STARTED;
    public static final /* enum */ TestLifecycleScopeProvider$TestLifecycle STOPPED;
    private static final /* synthetic */ TestLifecycleScopeProvider$TestLifecycle[] a;

    static {
        TestLifecycleScopeProvider$TestLifecycle testLifecycleScopeProvider$TestLifecycle;
        TestLifecycleScopeProvider$TestLifecycle testLifecycleScopeProvider$TestLifecycle2;
        STARTED = testLifecycleScopeProvider$TestLifecycle2 = new TestLifecycleScopeProvider$TestLifecycle("STARTED", 0);
        int n10 = 1;
        STOPPED = testLifecycleScopeProvider$TestLifecycle = new TestLifecycleScopeProvider$TestLifecycle("STOPPED", n10);
        TestLifecycleScopeProvider$TestLifecycle[] testLifecycleScopeProvider$TestLifecycleArray = new TestLifecycleScopeProvider$TestLifecycle[2];
        testLifecycleScopeProvider$TestLifecycleArray[0] = testLifecycleScopeProvider$TestLifecycle2;
        testLifecycleScopeProvider$TestLifecycleArray[n10] = testLifecycleScopeProvider$TestLifecycle;
        a = testLifecycleScopeProvider$TestLifecycleArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TestLifecycleScopeProvider$TestLifecycle() {
        void var2_-1;
        void var1_-1;
    }

    public static TestLifecycleScopeProvider$TestLifecycle valueOf(String string2) {
        return Enum.valueOf(TestLifecycleScopeProvider$TestLifecycle.class, string2);
    }

    public static TestLifecycleScopeProvider$TestLifecycle[] values() {
        return (TestLifecycleScopeProvider$TestLifecycle[])a.clone();
    }
}

