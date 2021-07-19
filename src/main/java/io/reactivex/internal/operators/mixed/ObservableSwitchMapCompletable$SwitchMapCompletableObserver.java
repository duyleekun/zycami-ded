/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a1.a;
import e.a.d;
import e.a.g;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapCompletable$SwitchMapCompletableObserver
implements g0,
b {
    public static final ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver h;
    public final d a;
    public final o b;
    public final boolean c;
    public final AtomicThrowable d;
    public final AtomicReference e;
    public volatile boolean f;
    public b g;

    static {
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver;
        h = observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver = new ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(null);
    }

    public ObservableSwitchMapCompletable$SwitchMapCompletableObserver(d atomicReference, o o10, boolean bl2) {
        this.a = atomicReference;
        this.b = o10;
        this.c = bl2;
        atomicReference = new AtomicReference();
        this.d = atomicReference;
        this.e = atomicReference = new AtomicReference();
    }

    public void a() {
        AtomicReference atomicReference = this.e;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver = h;
        if ((atomicReference = atomicReference.getAndSet(observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver)) != null && atomicReference != observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) {
            ((ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver)atomicReference).dispose();
        }
    }

    public void b(ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver object) {
        Object object2 = this.e;
        boolean bl2 = ((AtomicReference)object2).compareAndSet(object, null);
        if (bl2 && (bl2 = this.f)) {
            object = this.d.terminate();
            if (object == null) {
                object = this.a;
                object.onComplete();
            } else {
                object2 = this.a;
                object2.onError((Throwable)object);
            }
        }
    }

    public void c(ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver serializable, Throwable object) {
        AtomicReference atomicReference = this.e;
        boolean bl2 = atomicReference.compareAndSet(serializable, null);
        if (bl2 && (bl2 = ((AtomicThrowable)(serializable = this.d)).addThrowable((Throwable)object))) {
            bl2 = this.c;
            if (bl2) {
                bl2 = this.f;
                if (bl2) {
                    serializable = this.d.terminate();
                    object = this.a;
                    object.onError((Throwable)serializable);
                }
            } else {
                this.dispose();
                serializable = this.d.terminate();
                object = ExceptionHelper.a;
                if (serializable != object) {
                    object = this.a;
                    object.onError((Throwable)serializable);
                }
            }
            return;
        }
        e.a.a1.a.Y((Throwable)object);
    }

    public void dispose() {
        this.g.dispose();
        this.a();
    }

    public boolean isDisposed() {
        boolean bl2;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver;
        Object v10 = this.e.get();
        if (v10 == (observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver = h)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        boolean bl2;
        this.f = bl2 = true;
        Object object = this.e.get();
        if (object == null) {
            object = this.d.terminate();
            if (object == null) {
                object = this.a;
                object.onComplete();
            } else {
                d d10 = this.a;
                d10.onError((Throwable)object);
            }
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.d;
        boolean bl2 = ((AtomicThrowable)object).addThrowable(throwable);
        if (bl2) {
            boolean bl3 = this.c;
            if (bl3) {
                this.onComplete();
            } else {
                this.a();
                throwable = this.d.terminate();
                object = ExceptionHelper.a;
                if (throwable != object) {
                    object = this.a;
                    object.onError(throwable);
                }
            }
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        AtomicReference atomicReference;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver;
        Object object2 = this.b;
        object = object2.apply(object);
        object2 = "The mapper returned a null CompletableSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (g)object;
            object2 = new ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(this);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.g.dispose();
            this.onError(throwable);
            return;
        }
        while ((observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver = (ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver)this.e.get()) != (atomicReference = h)) {
            atomicReference = this.e;
            boolean bl2 = atomicReference.compareAndSet(observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver, object2);
            if (!bl2) continue;
            if (observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver != null) {
                observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver.dispose();
            }
            object.f((d)object2);
            break;
        }
        return;
    }

    public void onSubscribe(b object) {
        b b10 = this.g;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.g = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

