/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.w0.b.a;
import i.g.d;
import io.reactivex.processors.ReplayProcessor$ReplaySubscription;
import io.reactivex.processors.ReplayProcessor$a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class ReplayProcessor$d
implements ReplayProcessor$a {
    public final List a;
    public Throwable b;
    public volatile boolean c;
    public volatile int d;

    public ReplayProcessor$d(int n10) {
        ArrayList arrayList;
        n10 = e.a.w0.b.a.h(n10, "capacityHint");
        this.a = arrayList = new ArrayList(n10);
    }

    public void a(ReplayProcessor$ReplaySubscription serializable) {
        int n10;
        int n11 = serializable.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        List list = this.a;
        d d10 = serializable.downstream;
        Integer n12 = (Integer)serializable.index;
        int n13 = 0;
        if (n12 != null) {
            n13 = n12;
        } else {
            n12 = 0;
            serializable.index = n12;
        }
        long l10 = serializable.emitted;
        int n14 = n10 = 1;
        do {
            long l11;
            Number number = serializable.requested;
            long l12 = number.get();
            while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) != false) {
                boolean bl2 = serializable.cancelled;
                if (bl2) {
                    serializable.index = null;
                    return;
                }
                bl2 = this.c;
                int n15 = this.d;
                if (bl2 && n13 == n15) {
                    serializable.index = null;
                    serializable.cancelled = n10;
                    serializable = this.b;
                    if (serializable == null) {
                        d10.onComplete();
                    } else {
                        d10.onError((Throwable)serializable);
                    }
                    return;
                }
                if (n13 == n15) break;
                Object e10 = list.get(n13);
                d10.onNext(e10);
                ++n13;
                long l13 = 1L;
                l10 += l13;
            }
            if (l11 == false) {
                boolean bl3 = serializable.cancelled;
                if (bl3) {
                    serializable.index = null;
                    return;
                }
                bl3 = this.c;
                int n16 = this.d;
                if (bl3 && n13 == n16) {
                    serializable.index = null;
                    serializable.cancelled = n10;
                    serializable = this.b;
                    if (serializable == null) {
                        d10.onComplete();
                    } else {
                        d10.onError((Throwable)serializable);
                    }
                    return;
                }
            }
            number = n13;
            serializable.index = number;
            serializable.emitted = l10;
            n14 = -n14;
        } while ((n14 = serializable.addAndGet(n14)) != 0);
    }

    public void complete() {
        this.c = true;
    }

    public void error(Throwable throwable) {
        this.b = throwable;
        this.c = true;
    }

    public Throwable getError() {
        return this.b;
    }

    public Object getValue() {
        int n10 = this.d;
        if (n10 == 0) {
            return null;
        }
        List list = this.a;
        return list.get(n10 += -1);
    }

    public Object[] getValues(Object[] objectArray) {
        int n10 = this.d;
        int n11 = 0;
        if (n10 == 0) {
            n10 = objectArray.length;
            if (n10 != 0) {
                objectArray[0] = null;
            }
            return objectArray;
        }
        List list = this.a;
        int n12 = objectArray.length;
        if (n12 < n10) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n10);
        }
        while (n11 < n10) {
            Object e10 = list.get(n11);
            objectArray[n11] = e10;
            ++n11;
        }
        n11 = objectArray.length;
        if (n11 > n10) {
            objectArray[n10] = null;
        }
        return objectArray;
    }

    public boolean isDone() {
        return this.c;
    }

    public void next(Object object) {
        int n10;
        this.a.add(object);
        this.d = n10 = this.d + 1;
    }

    public int size() {
        return this.d;
    }

    public void trimHead() {
    }
}

