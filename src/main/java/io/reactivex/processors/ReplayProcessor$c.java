/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.w0.b.a;
import i.g.d;
import io.reactivex.processors.ReplayProcessor$Node;
import io.reactivex.processors.ReplayProcessor$ReplaySubscription;
import io.reactivex.processors.ReplayProcessor$a;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayProcessor$c
implements ReplayProcessor$a {
    public final int a;
    public int b;
    public volatile ReplayProcessor$Node c;
    public ReplayProcessor$Node d;
    public Throwable e;
    public volatile boolean f;

    public ReplayProcessor$c(int n10) {
        ReplayProcessor$Node replayProcessor$Node;
        this.a = n10 = e.a.w0.b.a.h(n10, "maxSize");
        this.d = replayProcessor$Node = new ReplayProcessor$Node((Object)null);
        this.c = replayProcessor$Node;
    }

    public void a(ReplayProcessor$ReplaySubscription serializable) {
        int n10;
        int n11 = serializable.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        d d10 = serializable.downstream;
        Object object = (ReplayProcessor$Node)serializable.index;
        if (object == null) {
            object = this.c;
        }
        long l10 = serializable.emitted;
        int n12 = n10 = 1;
        do {
            long l11;
            AtomicLong atomicLong = serializable.requested;
            long l12 = atomicLong.get();
            while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) != false) {
                boolean bl2 = serializable.cancelled;
                if (bl2) {
                    serializable.index = null;
                    return;
                }
                bl2 = this.f;
                ReplayProcessor$Node replayProcessor$Node = (ReplayProcessor$Node)((AtomicReference)object).get();
                int n13 = replayProcessor$Node == null ? n10 : 0;
                if (bl2 && n13 != 0) {
                    serializable.index = null;
                    serializable.cancelled = n10;
                    serializable = this.e;
                    if (serializable == null) {
                        d10.onComplete();
                    } else {
                        d10.onError((Throwable)serializable);
                    }
                    return;
                }
                if (n13 != 0) break;
                object = replayProcessor$Node.value;
                d10.onNext(object);
                long l13 = 1L;
                l10 += l13;
                object = replayProcessor$Node;
            }
            if (l11 == false) {
                boolean bl3 = serializable.cancelled;
                if (bl3) {
                    serializable.index = null;
                    return;
                }
                bl3 = this.f;
                if (bl3 && (atomicLong = ((AtomicReference)object).get()) == null) {
                    serializable.index = null;
                    serializable.cancelled = n10;
                    serializable = this.e;
                    if (serializable == null) {
                        d10.onComplete();
                    } else {
                        d10.onError((Throwable)serializable);
                    }
                    return;
                }
            }
            serializable.index = object;
            serializable.emitted = l10;
            n12 = -n12;
        } while ((n12 = serializable.addAndGet(n12)) != 0);
    }

    public void b() {
        int n10 = this.b;
        int n11 = this.a;
        if (n10 > n11) {
            ReplayProcessor$Node replayProcessor$Node;
            this.b = n10 += -1;
            this.c = replayProcessor$Node = (ReplayProcessor$Node)this.c.get();
        }
    }

    public void complete() {
        this.trimHead();
        this.f = true;
    }

    public void error(Throwable throwable) {
        this.e = throwable;
        this.trimHead();
        this.f = true;
    }

    public Throwable getError() {
        return this.e;
    }

    public Object getValue() {
        ReplayProcessor$Node replayProcessor$Node = this.c;
        ReplayProcessor$Node replayProcessor$Node2;
        while ((replayProcessor$Node2 = (ReplayProcessor$Node)replayProcessor$Node.get()) != null) {
            replayProcessor$Node = replayProcessor$Node2;
        }
        return replayProcessor$Node.value;
    }

    public Object[] getValues(Object[] objectArray) {
        ReplayProcessor$Node replayProcessor$Node = this.c;
        int n10 = 0;
        Object object = replayProcessor$Node;
        int n11 = 0;
        while (true) {
            if ((object = (ReplayProcessor$Node)((AtomicReference)object).get()) == null) {
                int n12 = objectArray.length;
                if (n12 < n11) {
                    objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n11);
                }
                while (n10 < n11) {
                    replayProcessor$Node = (ReplayProcessor$Node)replayProcessor$Node.get();
                    objectArray[n10] = object = replayProcessor$Node.value;
                    ++n10;
                }
                int n13 = objectArray.length;
                if (n13 > n11) {
                    n13 = 0;
                    replayProcessor$Node = null;
                    objectArray[n11] = null;
                }
                return objectArray;
            }
            ++n11;
        }
    }

    public boolean isDone() {
        return this.f;
    }

    public void next(Object object) {
        int n10;
        ReplayProcessor$Node replayProcessor$Node = new ReplayProcessor$Node(object);
        object = this.d;
        this.d = replayProcessor$Node;
        this.b = n10 = this.b + 1;
        ((AtomicReference)object).set(replayProcessor$Node);
        this.b();
    }

    public int size() {
        int n10;
        int n11;
        ReplayProcessor$Node replayProcessor$Node = this.c;
        for (n11 = 0; n11 != (n10 = -1 >>> 1) && (replayProcessor$Node = (ReplayProcessor$Node)replayProcessor$Node.get()) != null; ++n11) {
        }
        return n11;
    }

    public void trimHead() {
        Object object = this.c.value;
        if (object != null) {
            object = new ReplayProcessor$Node((Object)null);
            Object v10 = this.c.get();
            ((AtomicReference)object).lazySet(v10);
            this.c = object;
        }
    }
}

