/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.g0;
import e.a.w0.b.a;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.ReplaySubject$ReplayDisposable;
import io.reactivex.subjects.ReplaySubject$a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject$UnboundedReplayBuffer
extends AtomicReference
implements ReplaySubject$a {
    private static final long serialVersionUID = -733876083048047795L;
    public final List buffer;
    public volatile boolean done;
    public volatile int size;

    public ReplaySubject$UnboundedReplayBuffer(int n10) {
        ArrayList arrayList;
        n10 = a.h(n10, "capacityHint");
        this.buffer = arrayList = new ArrayList(n10);
    }

    public void add(Object object) {
        int n10;
        this.buffer.add(object);
        this.size = n10 = this.size + 1;
    }

    public void addFinal(Object object) {
        this.buffer.add(object);
        this.trimHead();
        int n10 = this.size;
        int n11 = 1;
        this.size = n10 += n11;
        this.done = n11;
    }

    public Object getValue() {
        int n10 = this.size;
        if (n10 != 0) {
            List list = this.buffer;
            int n11 = n10 + -1;
            Object e10 = list.get(n11);
            boolean bl2 = NotificationLite.isComplete(e10);
            if (!bl2 && !(bl2 = NotificationLite.isError(e10))) {
                return e10;
            }
            n11 = 1;
            if (n10 == n11) {
                return null;
            }
            return list.get(n10 += -2);
        }
        return null;
    }

    public Object[] getValues(Object[] objectArray) {
        int n10 = this.size;
        int n11 = 0;
        if (n10 == 0) {
            n10 = objectArray.length;
            if (n10 != 0) {
                objectArray[0] = null;
            }
            return objectArray;
        }
        List list = this.buffer;
        int n12 = n10 + -1;
        Object e10 = list.get(n12);
        boolean bl2 = NotificationLite.isComplete(e10);
        if ((bl2 || (n12 = (int)(NotificationLite.isError(e10) ? 1 : 0)) != 0) && (n10 += -1) == 0) {
            n10 = objectArray.length;
            if (n10 != 0) {
                objectArray[0] = null;
            }
            return objectArray;
        }
        n12 = objectArray.length;
        if (n12 < n10) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n10);
        }
        while (n11 < n10) {
            e10 = list.get(n11);
            objectArray[n11] = e10;
            ++n11;
        }
        n11 = objectArray.length;
        if (n11 > n10) {
            objectArray[n10] = null;
        }
        return objectArray;
    }

    public void replay(ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable) {
        int n10 = replaySubject$ReplayDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        Object object = this.buffer;
        g0 g02 = replaySubject$ReplayDisposable.downstream;
        Integer n11 = (Integer)replaySubject$ReplayDisposable.index;
        int n12 = 0;
        int n13 = 1;
        if (n11 != null) {
            n12 = n11;
        } else {
            n11 = 0;
            replaySubject$ReplayDisposable.index = n11;
        }
        int n14 = n13;
        while (true) {
            int n15;
            if ((n15 = replaySubject$ReplayDisposable.cancelled) != 0) {
                replaySubject$ReplayDisposable.index = null;
                return;
            }
            n15 = this.size;
            while (n15 != n12) {
                boolean bl2 = replaySubject$ReplayDisposable.cancelled;
                if (bl2) {
                    replaySubject$ReplayDisposable.index = null;
                    return;
                }
                Object e10 = object.get(n12);
                int n16 = this.done;
                if (n16 != 0 && (n16 = n12 + 1) == n15 && n16 == (n15 = this.size)) {
                    n10 = (int)(NotificationLite.isComplete(e10) ? 1 : 0);
                    if (n10 != 0) {
                        g02.onComplete();
                    } else {
                        object = NotificationLite.getError(e10);
                        g02.onError((Throwable)object);
                    }
                    replaySubject$ReplayDisposable.index = null;
                    replaySubject$ReplayDisposable.cancelled = n13;
                    return;
                }
                g02.onNext(e10);
                ++n12;
            }
            n15 = this.size;
            if (n12 != n15) continue;
            Integer n17 = n12;
            replaySubject$ReplayDisposable.index = n17;
            n14 = -n14;
            if ((n14 = replaySubject$ReplayDisposable.addAndGet(n14)) == 0) break;
        }
    }

    public int size() {
        int n10 = this.size;
        if (n10 != 0) {
            boolean bl2;
            List list = this.buffer;
            int n11 = n10 + -1;
            boolean bl3 = NotificationLite.isComplete(list = list.get(n11));
            if (!bl3 && !(bl2 = NotificationLite.isError(list))) {
                return n10;
            }
            return n11;
        }
        return 0;
    }

    public void trimHead() {
    }
}

