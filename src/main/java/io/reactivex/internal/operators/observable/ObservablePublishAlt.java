/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.g;
import e.a.w0.a.c;
import e.a.x0.a;
import io.reactivex.internal.operators.observable.ObservablePublishAlt$InnerDisposable;
import io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishAlt
extends a
implements e.a.w0.c.g,
c {
    public final e0 a;
    public final AtomicReference b;

    public ObservablePublishAlt(e0 atomicReference) {
        this.a = atomicReference;
        this.b = atomicReference = new AtomicReference();
    }

    public void K5(g0 g02) {
        AtomicReference atomicReference;
        Serializable serializable;
        while ((serializable = (ObservablePublishAlt$PublishConnection)this.b.get()) == null) {
            AtomicReference atomicReference2 = this.b;
            atomicReference2 = this.b;
            atomicReference = new ObservablePublishAlt$PublishConnection(atomicReference2);
            boolean bl2 = atomicReference2.compareAndSet(serializable, atomicReference);
            if (!bl2) continue;
            serializable = atomicReference;
            break;
        }
        atomicReference = new ObservablePublishAlt$InnerDisposable(g02, (ObservablePublishAlt$PublishConnection)serializable);
        g02.onSubscribe((b)((Object)atomicReference));
        boolean bl3 = ((ObservablePublishAlt$PublishConnection)serializable).add((ObservablePublishAlt$InnerDisposable)atomicReference);
        if (bl3) {
            boolean bl4 = ((ObservablePublishAlt$InnerDisposable)atomicReference).isDisposed();
            if (bl4) {
                ((ObservablePublishAlt$PublishConnection)serializable).remove((ObservablePublishAlt$InnerDisposable)atomicReference);
            }
            return;
        }
        serializable = ((ObservablePublishAlt$PublishConnection)serializable).error;
        if (serializable != null) {
            g02.onError((Throwable)serializable);
        } else {
            g02.onComplete();
        }
    }

    public void l8(g object) {
        Serializable serializable;
        AtomicReference atomicReference;
        boolean bl2;
        Serializable serializable2;
        while ((serializable2 = (ObservablePublishAlt$PublishConnection)this.b.get()) == null || (bl2 = serializable2.isDisposed())) {
            atomicReference = this.b;
            atomicReference = this.b;
            serializable = new ObservablePublishAlt$PublishConnection(atomicReference);
            boolean bl3 = atomicReference.compareAndSet(serializable2, serializable);
            if (!bl3) continue;
            serializable2 = serializable;
            break;
        }
        serializable = serializable2.connect;
        bl2 = ((AtomicBoolean)serializable).get();
        boolean bl4 = true;
        if (bl2 || !(bl2 = ((AtomicBoolean)(serializable = serializable2.connect)).compareAndSet(false, bl4))) {
            bl4 = false;
            atomicReference = null;
        }
        try {
            object.accept(serializable2);
            if (bl4) {
                object = this.a;
                object.subscribe((g0)((Object)serializable2));
            }
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
    }

    public void m(b b10) {
        AtomicReference atomicReference = this.b;
        b10 = (ObservablePublishAlt$PublishConnection)b10;
        atomicReference.compareAndSet(b10, null);
    }

    public e0 source() {
        return this.a;
    }
}

