/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.g0;
import e.a.w0.b.a;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.ReplaySubject$Node;
import io.reactivex.subjects.ReplaySubject$ReplayDisposable;
import io.reactivex.subjects.ReplaySubject$a;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject$SizeBoundReplayBuffer
extends AtomicReference
implements ReplaySubject$a {
    private static final long serialVersionUID = 1107649250281456395L;
    public volatile boolean done;
    public volatile ReplaySubject$Node head;
    public final int maxSize;
    public int size;
    public ReplaySubject$Node tail;

    public ReplaySubject$SizeBoundReplayBuffer(int n10) {
        ReplaySubject$Node replaySubject$Node;
        this.maxSize = n10 = a.h(n10, "maxSize");
        this.tail = replaySubject$Node = new ReplaySubject$Node((Object)null);
        this.head = replaySubject$Node;
    }

    public void add(Object object) {
        int n10;
        ReplaySubject$Node replaySubject$Node = new ReplaySubject$Node(object);
        object = this.tail;
        this.tail = replaySubject$Node;
        this.size = n10 = this.size + 1;
        ((AtomicReference)object).set(replaySubject$Node);
        this.trim();
    }

    public void addFinal(Object object) {
        ReplaySubject$Node replaySubject$Node = new ReplaySubject$Node(object);
        object = this.tail;
        this.tail = replaySubject$Node;
        int n10 = this.size;
        int n11 = 1;
        this.size = n10 += n11;
        ((AtomicReference)object).lazySet(replaySubject$Node);
        this.trimHead();
        this.done = n11;
    }

    public Object getValue() {
        Object object = this.head;
        boolean bl2 = false;
        ReplaySubject$Node replaySubject$Node = null;
        while (true) {
            ReplaySubject$Node replaySubject$Node2;
            if ((replaySubject$Node2 = (ReplaySubject$Node)((AtomicReference)object).get()) == null) {
                object = ((ReplaySubject$Node)object).value;
                if (object == null) {
                    return null;
                }
                bl2 = NotificationLite.isComplete(object);
                if (!bl2 && !(bl2 = NotificationLite.isError(object))) {
                    return object;
                }
                return replaySubject$Node.value;
            }
            replaySubject$Node = object;
            object = replaySubject$Node2;
        }
    }

    public Object[] getValues(Object[] objectArray) {
        ReplaySubject$Node replaySubject$Node = this.head;
        int n10 = this.size();
        int n11 = 0;
        if (n10 == 0) {
            int n12 = objectArray.length;
            if (n12 != 0) {
                objectArray[0] = null;
            }
        } else {
            int n13 = objectArray.length;
            if (n13 < n10) {
                objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n10);
            }
            while (n11 != n10) {
                Object object;
                replaySubject$Node = (ReplaySubject$Node)replaySubject$Node.get();
                objectArray[n11] = object = replaySubject$Node.value;
                ++n11;
            }
            int n14 = objectArray.length;
            if (n14 > n10) {
                objectArray[n10] = null;
            }
        }
        return objectArray;
    }

    public void replay(ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable) {
        int n10 = replaySubject$ReplayDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        g0 g02 = replaySubject$ReplayDisposable.downstream;
        Object object = (ReplaySubject$Node)replaySubject$ReplayDisposable.index;
        int n11 = 1;
        if (object == null) {
            object = this.head;
        }
        int n12 = n11;
        while (true) {
            Object v10;
            boolean bl2;
            if (bl2 = replaySubject$ReplayDisposable.cancelled) {
                replaySubject$ReplayDisposable.index = null;
                return;
            }
            ReplaySubject$Node replaySubject$Node = (ReplaySubject$Node)((AtomicReference)object).get();
            if (replaySubject$Node == null) {
                replaySubject$Node = ((AtomicReference)object).get();
                if (replaySubject$Node != null) continue;
                replaySubject$ReplayDisposable.index = object;
                n12 = -n12;
                if ((n12 = replaySubject$ReplayDisposable.addAndGet(n12)) != 0) continue;
                return;
            }
            object = replaySubject$Node.value;
            boolean bl3 = this.done;
            if (bl3 && (v10 = replaySubject$Node.get()) == null) {
                n12 = (int)(NotificationLite.isComplete(object) ? 1 : 0);
                if (n12 != 0) {
                    g02.onComplete();
                } else {
                    object = NotificationLite.getError(object);
                    g02.onError((Throwable)object);
                }
                replaySubject$ReplayDisposable.index = null;
                replaySubject$ReplayDisposable.cancelled = n11;
                return;
            }
            g02.onNext(object);
            object = replaySubject$Node;
        }
    }

    public int size() {
        int n10;
        int n11;
        Object object = this.head;
        for (n11 = 0; n11 != (n10 = -1 >>> 1); ++n11) {
            ReplaySubject$Node replaySubject$Node = (ReplaySubject$Node)((AtomicReference)object).get();
            if (replaySubject$Node == null) {
                boolean bl2;
                object = ((ReplaySubject$Node)object).value;
                n10 = (int)(NotificationLite.isComplete(object) ? 1 : 0);
                if (n10 == 0 && !(bl2 = NotificationLite.isError(object))) break;
                n11 += -1;
                break;
            }
            object = replaySubject$Node;
        }
        return n11;
    }

    public void trim() {
        int n10 = this.size;
        int n11 = this.maxSize;
        if (n10 > n11) {
            ReplaySubject$Node replaySubject$Node;
            this.size = n10 += -1;
            this.head = replaySubject$Node = (ReplaySubject$Node)this.head.get();
        }
    }

    public void trimHead() {
        ReplaySubject$Node replaySubject$Node = this.head;
        Object object = replaySubject$Node.value;
        if (object != null) {
            object = new ReplaySubject$Node((Object)null);
            replaySubject$Node = replaySubject$Node.get();
            ((AtomicReference)object).lazySet(replaySubject$Node);
            this.head = object;
        }
    }
}

