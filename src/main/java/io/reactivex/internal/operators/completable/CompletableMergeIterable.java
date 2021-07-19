/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import io.reactivex.internal.operators.completable.CompletableMergeIterable$MergeCompletableObserver;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable
extends a {
    public final Iterable a;

    public CompletableMergeIterable(Iterable iterable) {
        this.a = iterable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void L0(d object) {
        CompletableMergeIterable$MergeCompletableObserver completableMergeIterable$MergeCompletableObserver;
        Object object2;
        Object object3;
        e.a.s0.a a10 = new e.a.s0.a();
        object.onSubscribe(a10);
        try {
            object3 = this.a;
            object3 = object3.iterator();
            object2 = "The source iterator returned is null";
            object3 = e.a.w0.b.a.g(object3, (String)object2);
            object3 = (Iterator)object3;
            int n10 = 1;
            object2 = new AtomicInteger(n10);
            completableMergeIterable$MergeCompletableObserver = new CompletableMergeIterable$MergeCompletableObserver((d)object, a10, (AtomicInteger)object2);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object.onError(throwable);
            return;
        }
        while (true) {
            boolean bl2;
            if (bl2 = a10.isDisposed()) {
                return;
            }
            try {
                bl2 = object3.hasNext();
                if (!bl2) {
                    completableMergeIterable$MergeCompletableObserver.onComplete();
                    return;
                }
                bl2 = a10.isDisposed();
                if (bl2) {
                    return;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                a10.dispose();
                completableMergeIterable$MergeCompletableObserver.onError(throwable);
                return;
            }
            try {
                object = object3.next();
                String string2 = "The iterator returned a null CompletableSource";
                object = e.a.w0.b.a.g(object, string2);
                object = (g)object;
                boolean bl3 = a10.isDisposed();
                if (bl3) {
                    return;
                }
                ((AtomicInteger)object2).getAndIncrement();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                a10.dispose();
                completableMergeIterable$MergeCompletableObserver.onError(throwable);
                return;
            }
            object.f(completableMergeIterable$MergeCompletableObserver);
        }
    }
}

