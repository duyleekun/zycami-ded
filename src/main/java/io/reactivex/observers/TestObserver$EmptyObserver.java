/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.observers;

import e.a.g0;
import e.a.s0.b;

public final class TestObserver$EmptyObserver
extends Enum
implements g0 {
    public static final /* enum */ TestObserver$EmptyObserver INSTANCE;
    private static final /* synthetic */ TestObserver$EmptyObserver[] a;

    static {
        TestObserver$EmptyObserver testObserver$EmptyObserver;
        INSTANCE = testObserver$EmptyObserver = new TestObserver$EmptyObserver("INSTANCE", 0);
        TestObserver$EmptyObserver[] testObserver$EmptyObserverArray = new TestObserver$EmptyObserver[]{testObserver$EmptyObserver};
        a = testObserver$EmptyObserverArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TestObserver$EmptyObserver() {
        void var2_-1;
        void var1_-1;
    }

    public static TestObserver$EmptyObserver valueOf(String string2) {
        return Enum.valueOf(TestObserver$EmptyObserver.class, string2);
    }

    public static TestObserver$EmptyObserver[] values() {
        return (TestObserver$EmptyObserver[])a.clone();
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(b b10) {
    }
}

