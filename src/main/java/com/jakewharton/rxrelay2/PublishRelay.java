/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.PublishRelay$PublishDisposable;
import d.k.b.c;
import e.a.g0;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishRelay
extends c {
    public static final PublishRelay$PublishDisposable[] b = new PublishRelay$PublishDisposable[0];
    public final AtomicReference a;

    public PublishRelay() {
        AtomicReference<PublishRelay$PublishDisposable[]> atomicReference;
        PublishRelay$PublishDisposable[] publishRelay$PublishDisposableArray = b;
        this.a = atomicReference = new AtomicReference<PublishRelay$PublishDisposable[]>(publishRelay$PublishDisposableArray);
    }

    public static PublishRelay k8() {
        PublishRelay publishRelay = new PublishRelay();
        return publishRelay;
    }

    public void K5(g0 g02) {
        PublishRelay$PublishDisposable publishRelay$PublishDisposable = new PublishRelay$PublishDisposable(g02, this);
        g02.onSubscribe(publishRelay$PublishDisposable);
        this.j8(publishRelay$PublishDisposable);
        boolean bl2 = publishRelay$PublishDisposable.isDisposed();
        if (bl2) {
            this.l8(publishRelay$PublishDisposable);
        }
    }

    public void accept(Object object) {
        Objects.requireNonNull(object, "value == null");
        for (PublishRelay$PublishDisposable publishRelay$PublishDisposable : (PublishRelay$PublishDisposable[])this.a.get()) {
            publishRelay$PublishDisposable.onNext(object);
        }
    }

    public boolean h8() {
        PublishRelay$PublishDisposable[] publishRelay$PublishDisposableArray = (PublishRelay$PublishDisposable[])this.a.get();
        boolean bl2 = publishRelay$PublishDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            publishRelay$PublishDisposableArray = null;
        }
        return bl2;
    }

    public void j8(PublishRelay$PublishDisposable publishRelay$PublishDisposable) {
        PublishRelay$PublishDisposable[] publishRelay$PublishDisposableArray;
        PublishRelay$PublishDisposable[] publishRelay$PublishDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            publishRelay$PublishDisposableArray2 = (PublishRelay$PublishDisposable[])this.a.get();
            int n10 = publishRelay$PublishDisposableArray2.length;
            int n11 = n10 + 1;
            publishRelay$PublishDisposableArray = new PublishRelay$PublishDisposable[n11];
            System.arraycopy(publishRelay$PublishDisposableArray2, 0, publishRelay$PublishDisposableArray, 0, n10);
            publishRelay$PublishDisposableArray[n10] = publishRelay$PublishDisposable;
        } while (!(bl2 = (atomicReference = this.a).compareAndSet(publishRelay$PublishDisposableArray2, publishRelay$PublishDisposableArray)));
    }

    public void l8(PublishRelay$PublishDisposable publishRelay$PublishDisposable) {
        PublishRelay$PublishDisposable[] publishRelay$PublishDisposableArray;
        PublishRelay$PublishDisposable[] publishRelay$PublishDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            PublishRelay$PublishDisposable[] publishRelay$PublishDisposableArray3;
            int n10;
            if ((publishRelay$PublishDisposableArray2 = (PublishRelay$PublishDisposable[])this.a.get()) == (publishRelay$PublishDisposableArray = b)) {
                return;
            }
            int n11 = publishRelay$PublishDisposableArray2.length;
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                publishRelay$PublishDisposableArray3 = publishRelay$PublishDisposableArray2[n10];
                if (publishRelay$PublishDisposableArray3 != publishRelay$PublishDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                publishRelay$PublishDisposableArray = b;
                continue;
            }
            int n14 = n11 + -1;
            publishRelay$PublishDisposableArray3 = new PublishRelay$PublishDisposable[n14];
            System.arraycopy(publishRelay$PublishDisposableArray2, 0, publishRelay$PublishDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(publishRelay$PublishDisposableArray2, n13, publishRelay$PublishDisposableArray3, n12, n11);
            publishRelay$PublishDisposableArray = publishRelay$PublishDisposableArray3;
        } while (!(bl2 = (atomicReference = this.a).compareAndSet(publishRelay$PublishDisposableArray2, publishRelay$PublishDisposableArray)));
    }
}

