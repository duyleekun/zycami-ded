/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservablePublishSelector$TargetObserver;
import io.reactivex.internal.operators.observable.ObservablePublishSelector$a;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector
extends a {
    public final o b;

    public ObservablePublishSelector(e0 e02, o o10) {
        super(e02);
        this.b = o10;
    }

    public void K5(g0 object) {
        Object object2;
        PublishSubject publishSubject = PublishSubject.n8();
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, (g0)object);
            return;
        }
        object2 = object2.apply(publishSubject);
        Object object3 = "The selector returned a null ObservableSource";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        object2 = (e0)object2;
        object3 = new ObservablePublishSelector$TargetObserver((g0)object);
        object2.subscribe((g0)object3);
        object = this.a;
        object2 = new ObservablePublishSelector$a(publishSubject, (AtomicReference)object3);
        object.subscribe((g0)object2);
    }
}

