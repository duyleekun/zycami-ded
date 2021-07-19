/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import e.a.a1.a;
import e.a.d;
import e.a.g0;
import e.a.l0;
import e.a.o;
import e.a.s0.b;
import e.a.t;
import i.g.e;

public final class EmptyComponent
extends Enum
implements o,
g0,
t,
l0,
d,
e,
b {
    public static final /* enum */ EmptyComponent INSTANCE;
    private static final /* synthetic */ EmptyComponent[] a;

    static {
        EmptyComponent emptyComponent;
        INSTANCE = emptyComponent = new EmptyComponent("INSTANCE", 0);
        EmptyComponent[] emptyComponentArray = new EmptyComponent[]{emptyComponent};
        a = emptyComponentArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EmptyComponent() {
        void var2_-1;
        void var1_-1;
    }

    public static g0 asObserver() {
        return INSTANCE;
    }

    public static i.g.d asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String string2) {
        return Enum.valueOf(EmptyComponent.class, string2);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[])a.clone();
    }

    public void cancel() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        e.a.a1.a.Y(throwable);
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(b b10) {
        b10.dispose();
    }

    public void onSubscribe(e e10) {
        e10.cancel();
    }

    public void onSuccess(Object object) {
    }

    public void request(long l10) {
    }
}

