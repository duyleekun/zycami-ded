/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subscribers;

import e.a.o;
import i.g.e;

public final class TestSubscriber$EmptySubscriber
extends Enum
implements o {
    public static final /* enum */ TestSubscriber$EmptySubscriber INSTANCE;
    private static final /* synthetic */ TestSubscriber$EmptySubscriber[] a;

    static {
        TestSubscriber$EmptySubscriber testSubscriber$EmptySubscriber;
        INSTANCE = testSubscriber$EmptySubscriber = new TestSubscriber$EmptySubscriber("INSTANCE", 0);
        TestSubscriber$EmptySubscriber[] testSubscriber$EmptySubscriberArray = new TestSubscriber$EmptySubscriber[]{testSubscriber$EmptySubscriber};
        a = testSubscriber$EmptySubscriberArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TestSubscriber$EmptySubscriber() {
        void var2_-1;
        void var1_-1;
    }

    public static TestSubscriber$EmptySubscriber valueOf(String string2) {
        return Enum.valueOf(TestSubscriber$EmptySubscriber.class, string2);
    }

    public static TestSubscriber$EmptySubscriber[] values() {
        return (TestSubscriber$EmptySubscriber[])a.clone();
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(e e10) {
    }
}

