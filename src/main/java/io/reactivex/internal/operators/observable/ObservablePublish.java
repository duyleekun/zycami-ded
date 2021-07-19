/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.v0.g;
import e.a.w0.e.e.d1;
import io.reactivex.internal.operators.observable.ObservablePublish$a;
import io.reactivex.internal.operators.observable.ObservablePublish$b;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish
extends e.a.x0.a
implements e.a.w0.c.g,
d1 {
    public final e0 a;
    public final AtomicReference b;
    public final e0 c;

    private ObservablePublish(e0 e02, e0 e03, AtomicReference atomicReference) {
        this.c = e02;
        this.a = e03;
        this.b = atomicReference;
    }

    public static e.a.x0.a t8(e0 e02) {
        AtomicReference atomicReference = new AtomicReference();
        ObservablePublish$b observablePublish$b = new ObservablePublish$b(atomicReference);
        ObservablePublish observablePublish = new ObservablePublish(observablePublish$b, e02, atomicReference);
        return e.a.a1.a.U(observablePublish);
    }

    public void K5(g0 g02) {
        this.c.subscribe(g02);
    }

    public e0 g() {
        return this.a;
    }

    public void l8(g object) {
        Object object2;
        AtomicReference atomicReference;
        boolean bl2;
        Object object3;
        while ((object3 = (ObservablePublish$a)this.b.get()) == null || (bl2 = ((ObservablePublish$a)object3).isDisposed())) {
            atomicReference = this.b;
            atomicReference = this.b;
            object2 = new ObservablePublish$a(atomicReference);
            boolean bl3 = atomicReference.compareAndSet(object3, object2);
            if (!bl3) continue;
            object3 = object2;
            break;
        }
        object2 = ((ObservablePublish$a)object3).c;
        bl2 = ((AtomicBoolean)object2).get();
        boolean bl4 = true;
        if (bl2 || !(bl2 = ((AtomicBoolean)(object2 = ((ObservablePublish$a)object3).c)).compareAndSet(false, bl4))) {
            bl4 = false;
            atomicReference = null;
        }
        try {
            object.accept(object3);
            if (bl4) {
                object = this.a;
                object.subscribe((g0)object3);
            }
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
    }

    public e0 source() {
        return this.a;
    }
}

