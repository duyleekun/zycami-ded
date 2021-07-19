/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.i;
import e.a.v0.c;
import e.a.v0.g;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableGenerate$GeneratorSubscription
extends AtomicLong
implements i,
e {
    private static final long serialVersionUID = 7565982551505011832L;
    public volatile boolean cancelled;
    public final g disposeState;
    public final d downstream;
    public final c generator;
    public boolean hasNext;
    public Object state;
    public boolean terminate;

    public FlowableGenerate$GeneratorSubscription(d d10, c c10, g g10, Object object) {
        this.downstream = d10;
        this.generator = c10;
        this.disposeState = g10;
        this.state = object;
    }

    private void a(Object object) {
        g g10 = this.disposeState;
        try {
            g10.accept(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
    }

    public void cancel() {
        Object object = this.cancelled;
        if (!object) {
            long l10;
            this.cancelled = true;
            long l11 = b.a(this, 1L);
            long l12 = l11 - (l10 = 0L);
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object) {
                Object object2 = this.state;
                this.state = null;
                this.a(object2);
            }
        }
    }

    public void onComplete() {
        boolean bl2 = this.terminate;
        if (!bl2) {
            this.terminate = bl2 = true;
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.terminate;
        if (bl2) {
            a.Y(throwable);
        } else {
            Object object;
            if (throwable == null) {
                object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                throwable = new NullPointerException((String)object);
            }
            this.terminate = bl2 = true;
            object = this.downstream;
            object.onError(throwable);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.terminate;
        if (!bl2) {
            bl2 = this.hasNext;
            if (bl2) {
                String string2 = "onNext already called in this generate turn";
                object = new IllegalStateException(string2);
                this.onError((Throwable)object);
            } else if (object == null) {
                String string3 = "onNext called with null. Null values are generally not allowed in 2.x operators and sources.";
                object = new NullPointerException(string3);
                this.onError((Throwable)object);
            } else {
                this.hasNext = bl2 = true;
                d d10 = this.downstream;
                d10.onNext(object);
            }
        }
    }

    public void request(long l10) {
        long l11;
        long l12;
        long l13;
        Object object = SubscriptionHelper.validate(l10);
        if (!object) {
            return;
        }
        long l14 = b.a(this, l10);
        long l15 = l14 - (l13 = 0L);
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object) {
            return;
        }
        Object object2 = this.state;
        c c10 = this.generator;
        do {
            long l16 = l13;
            while (true) {
                Object object3;
                if ((object3 = l16 == l10 ? 0 : (l16 < l10 ? -1 : 1)) != false) {
                    object3 = this.cancelled;
                    if (object3 != false) {
                        this.state = null;
                        this.a(object2);
                        return;
                    }
                    this.hasNext = false;
                    object3 = 1;
                    try {
                        object2 = c10.apply(object2, this);
                        boolean bl2 = this.terminate;
                        if (bl2) {
                            this.cancelled = object3;
                            this.state = null;
                            this.a(object2);
                            return;
                        }
                        long l17 = 1L;
                        l16 += l17;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        this.cancelled = object3;
                        this.state = null;
                        this.onError(throwable);
                        this.a(object2);
                        return;
                    }
                }
                l10 = this.get();
                long l18 = l16 - l10;
                object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object3 == false) break;
            }
            this.state = object2;
            l10 = -l16;
        } while ((l12 = (l11 = (l10 = this.addAndGet(l10)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false);
    }
}

