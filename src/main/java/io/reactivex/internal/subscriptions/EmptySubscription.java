/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import e.a.w0.c.l;
import i.g.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class EmptySubscription
extends Enum
implements l {
    public static final /* enum */ EmptySubscription INSTANCE;
    private static final /* synthetic */ EmptySubscription[] a;

    static {
        EmptySubscription emptySubscription;
        INSTANCE = emptySubscription = new EmptySubscription("INSTANCE", 0);
        EmptySubscription[] emptySubscriptionArray = new EmptySubscription[]{emptySubscription};
        a = emptySubscriptionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EmptySubscription() {
        void var2_-1;
        void var1_-1;
    }

    public static void complete(d d10) {
        EmptySubscription emptySubscription = INSTANCE;
        d10.onSubscribe(emptySubscription);
        d10.onComplete();
    }

    public static void error(Throwable throwable, d d10) {
        EmptySubscription emptySubscription = INSTANCE;
        d10.onSubscribe(emptySubscription);
        d10.onError(throwable);
    }

    public static EmptySubscription valueOf(String string2) {
        return Enum.valueOf(EmptySubscription.class, string2);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[])a.clone();
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public Object poll() {
        return null;
    }

    public void request(long l10) {
        SubscriptionHelper.validate(l10);
    }

    public int requestFusion(int n10) {
        return n10 & 2;
    }

    public String toString() {
        return "EmptySubscription";
    }
}

