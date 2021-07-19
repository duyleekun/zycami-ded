/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.w0.f.a;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject$UnicastQueueDisposable
extends BasicIntQueueDisposable {
    private static final long serialVersionUID = 7926949470189395511L;
    public final /* synthetic */ UnicastSubject this$0;

    public UnicastSubject$UnicastQueueDisposable(UnicastSubject unicastSubject) {
        this.this$0 = unicastSubject;
    }

    public void clear() {
        this.this$0.a.clear();
    }

    public void dispose() {
        Object object = this.this$0;
        int n10 = ((UnicastSubject)object).e;
        if (n10 == 0) {
            this.this$0.e = true;
            this.this$0.r8();
            object = this.this$0.b;
            boolean bl2 = false;
            ((AtomicReference)object).lazySet(null);
            object = this.this$0.i;
            n10 = ((AtomicInteger)object).getAndIncrement();
            if (n10 == 0) {
                this.this$0.b.lazySet(null);
                object = this.this$0;
                bl2 = ((UnicastSubject)object).j;
                if (!bl2) {
                    object = ((UnicastSubject)object).a;
                    ((a)object).clear();
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.this$0.e;
    }

    public boolean isEmpty() {
        return this.this$0.a.isEmpty();
    }

    public Object poll() {
        return this.this$0.a.poll();
    }

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.this$0.j = true;
            return n11;
        }
        return 0;
    }
}

