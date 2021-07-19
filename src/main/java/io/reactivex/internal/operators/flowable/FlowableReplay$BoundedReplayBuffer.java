/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.t0.a;
import e.a.w0.i.b;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription;
import io.reactivex.internal.operators.flowable.FlowableReplay$Node;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import io.reactivex.internal.util.NotificationLite;
import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class FlowableReplay$BoundedReplayBuffer
extends AtomicReference
implements FlowableReplay$d {
    private static final long serialVersionUID = 2346567790059478686L;
    public long index;
    public int size;
    public FlowableReplay$Node tail;

    public FlowableReplay$BoundedReplayBuffer() {
        FlowableReplay$Node flowableReplay$Node;
        this.tail = flowableReplay$Node = new FlowableReplay$Node(null, 0L);
        this.set(flowableReplay$Node);
    }

    public final void addLast(FlowableReplay$Node flowableReplay$Node) {
        int n10;
        this.tail.set(flowableReplay$Node);
        this.tail = flowableReplay$Node;
        this.size = n10 = this.size + 1;
    }

    public final void collect(Collection collection) {
        FlowableReplay$Node flowableReplay$Node = this.getHead();
        while ((flowableReplay$Node = (FlowableReplay$Node)flowableReplay$Node.get()) != null) {
            Object object = flowableReplay$Node.value;
            boolean bl2 = NotificationLite.isComplete(object = this.leaveTransform(object));
            if (bl2 || (bl2 = NotificationLite.isError(object))) break;
            object = NotificationLite.getValue(object);
            collection.add(object);
        }
    }

    public final void complete() {
        long l10;
        Object object = NotificationLite.complete();
        object = this.enterTransform(object);
        this.index = l10 = this.index + 1L;
        FlowableReplay$Node flowableReplay$Node = new FlowableReplay$Node(object, l10);
        this.addLast(flowableReplay$Node);
        this.truncateFinal();
    }

    public Object enterTransform(Object object) {
        return object;
    }

    public final void error(Throwable object) {
        long l10;
        object = NotificationLite.error((Throwable)object);
        object = this.enterTransform(object);
        this.index = l10 = this.index + 1L;
        FlowableReplay$Node flowableReplay$Node = new FlowableReplay$Node(object, l10);
        this.addLast(flowableReplay$Node);
        this.truncateFinal();
    }

    public FlowableReplay$Node getHead() {
        return (FlowableReplay$Node)this.get();
    }

    public boolean hasCompleted() {
        boolean bl2;
        Object object = this.tail.value;
        if (object != null && (bl2 = NotificationLite.isComplete(object = this.leaveTransform(object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean hasError() {
        boolean bl2;
        Object object = this.tail.value;
        if (object != null && (bl2 = NotificationLite.isError(object = this.leaveTransform(object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Object leaveTransform(Object object) {
        return object;
    }

    public final void next(Object object) {
        long l10;
        object = NotificationLite.next(object);
        object = this.enterTransform(object);
        this.index = l10 = this.index + 1L;
        FlowableReplay$Node flowableReplay$Node = new FlowableReplay$Node(object, l10);
        this.addLast(flowableReplay$Node);
        this.truncate();
    }

    public final void removeFirst() {
        Serializable serializable = (FlowableReplay$Node)((FlowableReplay$Node)this.get()).get();
        if (serializable != null) {
            int n10;
            this.size = n10 = this.size + -1;
            this.setFirst((FlowableReplay$Node)serializable);
            return;
        }
        serializable = new IllegalStateException("Empty list!");
        throw serializable;
    }

    public final void removeSome(int n10) {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node)this.get();
        while (n10 > 0) {
            int n11;
            flowableReplay$Node = (FlowableReplay$Node)flowableReplay$Node.get();
            n10 += -1;
            this.size = n11 = this.size + -1;
        }
        this.setFirst(flowableReplay$Node);
        FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node)this.get();
        flowableReplay$Node = flowableReplay$Node2.get();
        if (flowableReplay$Node == null) {
            this.tail = flowableReplay$Node2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void replay(FlowableReplay$InnerSubscription object) {
        boolean bl2;
        Object object2;
        synchronized (object) {
            object2 = ((FlowableReplay$InnerSubscription)object).emitting;
            bl2 = true;
            if (object2) {
                ((FlowableReplay$InnerSubscription)object).missed = bl2;
                return;
            }
            ((FlowableReplay$InnerSubscription)object).emitting = bl2;
        }
        while (true) {
            FlowableReplay$Node flowableReplay$Node;
            long l10;
            long l11;
            object2 = ((FlowableReplay$InnerSubscription)object).isDisposed();
            Object object3 = false;
            if (object2) {
                ((FlowableReplay$InnerSubscription)object).index = null;
                return;
            }
            long l12 = ((AtomicLong)object).get();
            long l13 = l12 - (l11 = Long.MAX_VALUE);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (!object2) {
                object2 = bl2;
            } else {
                object2 = false;
                Object var9_7 = null;
            }
            Object object4 = (FlowableReplay$Node)((FlowableReplay$InnerSubscription)object).index();
            long l14 = 0L;
            if (object4 == null) {
                ((FlowableReplay$InnerSubscription)object).index = object4 = this.getHead();
                AtomicLong atomicLong = ((FlowableReplay$InnerSubscription)object).totalRequested;
                long l15 = ((FlowableReplay$Node)object4).index;
                b.a(atomicLong, l15);
            }
            long l16 = l14;
            while ((l10 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1)) != false && (flowableReplay$Node = (FlowableReplay$Node)((AtomicReference)object4).get()) != null) {
                object4 = flowableReplay$Node.value;
                object4 = this.leaveTransform(object4);
                try {
                    d d10 = ((FlowableReplay$InnerSubscription)object).child;
                    boolean bl3 = NotificationLite.accept(object4, d10);
                    if (bl3) {
                        ((FlowableReplay$InnerSubscription)object).index = null;
                        return;
                    }
                    long l17 = 1L;
                    l16 += l17;
                    l12 -= l17;
                    boolean bl4 = ((FlowableReplay$InnerSubscription)object).isDisposed();
                    if (bl4) {
                        ((FlowableReplay$InnerSubscription)object).index = null;
                        return;
                    }
                    object4 = flowableReplay$Node;
                }
                catch (Throwable throwable) {
                    a.b(throwable);
                    ((FlowableReplay$InnerSubscription)object).index = null;
                    ((FlowableReplay$InnerSubscription)object).dispose();
                    bl2 = NotificationLite.isError(object4);
                    if (!bl2 && !(bl2 = NotificationLite.isComplete(object4))) {
                        object = ((FlowableReplay$InnerSubscription)object).child;
                        object.onError(throwable);
                    }
                    return;
                }
            }
            object3 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1);
            if (object3) {
                ((FlowableReplay$InnerSubscription)object).index = object4;
                if (!object2) {
                    ((FlowableReplay$InnerSubscription)object).produced(l16);
                }
            }
            synchronized (object) {
                object2 = ((FlowableReplay$InnerSubscription)object).missed;
                if (!object2) {
                    ((FlowableReplay$InnerSubscription)object).emitting = false;
                    return;
                }
                ((FlowableReplay$InnerSubscription)object).missed = false;
            }
        }
    }

    public final void setFirst(FlowableReplay$Node flowableReplay$Node) {
        this.set(flowableReplay$Node);
    }

    public final void trimHead() {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node)this.get();
        Object object = flowableReplay$Node.value;
        if (object != null) {
            long l10 = 0L;
            object = new FlowableReplay$Node(null, l10);
            flowableReplay$Node = flowableReplay$Node.get();
            ((AtomicReference)object).lazySet(flowableReplay$Node);
            this.set(object);
        }
    }

    public void truncate() {
    }

    public void truncateFinal() {
        this.trimHead();
    }
}

