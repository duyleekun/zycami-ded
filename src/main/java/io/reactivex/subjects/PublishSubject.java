/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.d1.c;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.b.a;
import io.reactivex.subjects.PublishSubject$PublishDisposable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject
extends c {
    public static final PublishSubject$PublishDisposable[] c = new PublishSubject$PublishDisposable[0];
    public static final PublishSubject$PublishDisposable[] d = new PublishSubject$PublishDisposable[0];
    public final AtomicReference a;
    public Throwable b;

    public PublishSubject() {
        AtomicReference<PublishSubject$PublishDisposable[]> atomicReference;
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray = d;
        this.a = atomicReference = new AtomicReference<PublishSubject$PublishDisposable[]>(publishSubject$PublishDisposableArray);
    }

    public static PublishSubject n8() {
        PublishSubject publishSubject = new PublishSubject();
        return publishSubject;
    }

    public void K5(g0 g02) {
        Serializable serializable = new PublishSubject$PublishDisposable(g02, this);
        g02.onSubscribe((b)((Object)serializable));
        boolean bl2 = this.m8((PublishSubject$PublishDisposable)serializable);
        if (bl2) {
            boolean bl3 = serializable.isDisposed();
            if (bl3) {
                this.o8((PublishSubject$PublishDisposable)serializable);
            }
        } else {
            serializable = this.b;
            if (serializable != null) {
                g02.onError((Throwable)serializable);
            } else {
                g02.onComplete();
            }
        }
    }

    public Throwable h8() {
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (publishSubject$PublishDisposableArray = c)) {
            return this.b;
        }
        return null;
    }

    public boolean i8() {
        boolean bl2;
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray;
        Object object = this.a.get();
        if (object == (publishSubject$PublishDisposableArray = c) && (object = this.b) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean j8() {
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray = (PublishSubject$PublishDisposable[])this.a.get();
        boolean bl2 = publishSubject$PublishDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            publishSubject$PublishDisposableArray = null;
        }
        return bl2;
    }

    public boolean k8() {
        boolean bl2;
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray;
        Object object = this.a.get();
        if (object == (publishSubject$PublishDisposableArray = c) && (object = this.b) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean m8(PublishSubject$PublishDisposable publishSubject$PublishDisposable) {
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray;
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((publishSubject$PublishDisposableArray2 = (PublishSubject$PublishDisposable[])this.a.get()) == (object = c)) {
                return false;
            }
            int n10 = publishSubject$PublishDisposableArray2.length;
            int n11 = n10 + 1;
            publishSubject$PublishDisposableArray = new PublishSubject$PublishDisposable[n11];
            System.arraycopy(publishSubject$PublishDisposableArray2, 0, publishSubject$PublishDisposableArray, 0, n10);
            publishSubject$PublishDisposableArray[n10] = publishSubject$PublishDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.a)).compareAndSet(publishSubject$PublishDisposableArray2, publishSubject$PublishDisposableArray)));
        return true;
    }

    public void o8(PublishSubject$PublishDisposable publishSubject$PublishDisposable) {
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray;
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray2;
        while ((publishSubject$PublishDisposableArray2 = (PublishSubject$PublishDisposable[])this.a.get()) != (publishSubject$PublishDisposableArray = c) && publishSubject$PublishDisposableArray2 != (publishSubject$PublishDisposableArray = d)) {
            AtomicReference atomicReference;
            boolean bl2;
            PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray3;
            int n10;
            int n11 = publishSubject$PublishDisposableArray2.length;
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                publishSubject$PublishDisposableArray3 = publishSubject$PublishDisposableArray2[n10];
                if (publishSubject$PublishDisposableArray3 != publishSubject$PublishDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                publishSubject$PublishDisposableArray = d;
            } else {
                int n14 = n11 + -1;
                publishSubject$PublishDisposableArray3 = new PublishSubject$PublishDisposable[n14];
                System.arraycopy(publishSubject$PublishDisposableArray2, 0, publishSubject$PublishDisposableArray3, 0, n12);
                n13 = n12 + 1;
                n11 = n11 - n12 - n10;
                System.arraycopy(publishSubject$PublishDisposableArray2, n13, publishSubject$PublishDisposableArray3, n12, n11);
                publishSubject$PublishDisposableArray = publishSubject$PublishDisposableArray3;
            }
            if (!(bl2 = (atomicReference = this.a).compareAndSet(publishSubject$PublishDisposableArray2, publishSubject$PublishDisposableArray))) continue;
        }
    }

    public void onComplete() {
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray;
        Object object = this.a.get();
        if (object == (publishSubject$PublishDisposableArray = c)) {
            return;
        }
        for (PublishSubject$PublishDisposable publishSubject$PublishDisposable : this.a.getAndSet(publishSubject$PublishDisposableArray)) {
            publishSubject$PublishDisposable.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object object = this.a.get();
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray = c;
        if (object == publishSubject$PublishDisposableArray) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.b = throwable;
        for (PublishSubject$PublishDisposable publishSubject$PublishDisposable : this.a.getAndSet(publishSubject$PublishDisposableArray)) {
            publishSubject$PublishDisposable.onError(throwable);
        }
    }

    public void onNext(Object object) {
        e.a.w0.b.a.g(object, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishSubject$PublishDisposable publishSubject$PublishDisposable : (PublishSubject$PublishDisposable[])this.a.get()) {
            publishSubject$PublishDisposable.onNext(object);
        }
    }

    public void onSubscribe(b b10) {
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (publishSubject$PublishDisposableArray = c)) {
            b10.dispose();
        }
    }
}

