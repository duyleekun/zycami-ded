/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable;
import io.reactivex.internal.operators.observable.ObservableReplay$Node;
import io.reactivex.internal.operators.observable.ObservableReplay$e;
import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ObservableReplay$BoundedReplayBuffer
extends AtomicReference
implements ObservableReplay$e {
    private static final long serialVersionUID = 2346567790059478686L;
    public int size;
    public ObservableReplay$Node tail;

    public ObservableReplay$BoundedReplayBuffer() {
        ObservableReplay$Node observableReplay$Node;
        this.tail = observableReplay$Node = new ObservableReplay$Node((Object)null);
        this.set(observableReplay$Node);
    }

    public final void addLast(ObservableReplay$Node observableReplay$Node) {
        int n10;
        this.tail.set(observableReplay$Node);
        this.tail = observableReplay$Node;
        this.size = n10 = this.size + 1;
    }

    public final void collect(Collection collection) {
        ObservableReplay$Node observableReplay$Node = this.getHead();
        while ((observableReplay$Node = (ObservableReplay$Node)observableReplay$Node.get()) != null) {
            Object object = observableReplay$Node.value;
            boolean bl2 = NotificationLite.isComplete(object = this.leaveTransform(object));
            if (bl2 || (bl2 = NotificationLite.isError(object))) break;
            object = NotificationLite.getValue(object);
            collection.add(object);
        }
    }

    public final void complete() {
        Object object = NotificationLite.complete();
        object = this.enterTransform(object);
        ObservableReplay$Node observableReplay$Node = new ObservableReplay$Node(object);
        this.addLast(observableReplay$Node);
        this.truncateFinal();
    }

    public Object enterTransform(Object object) {
        return object;
    }

    public final void error(Throwable object) {
        object = NotificationLite.error((Throwable)object);
        object = this.enterTransform(object);
        ObservableReplay$Node observableReplay$Node = new ObservableReplay$Node(object);
        this.addLast(observableReplay$Node);
        this.truncateFinal();
    }

    public ObservableReplay$Node getHead() {
        return (ObservableReplay$Node)this.get();
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
        object = NotificationLite.next(object);
        object = this.enterTransform(object);
        ObservableReplay$Node observableReplay$Node = new ObservableReplay$Node(object);
        this.addLast(observableReplay$Node);
        this.truncate();
    }

    public final void removeFirst() {
        int n10;
        ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node)((ObservableReplay$Node)this.get()).get();
        this.size = n10 = this.size + -1;
        this.setFirst(observableReplay$Node);
    }

    public final void removeSome(int n10) {
        ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node)this.get();
        while (n10 > 0) {
            int n11;
            observableReplay$Node = (ObservableReplay$Node)observableReplay$Node.get();
            n10 += -1;
            this.size = n11 = this.size + -1;
        }
        this.setFirst(observableReplay$Node);
        ObservableReplay$Node observableReplay$Node2 = (ObservableReplay$Node)this.get();
        observableReplay$Node = observableReplay$Node2.get();
        if (observableReplay$Node == null) {
            this.tail = observableReplay$Node2;
        }
    }

    public final void replay(ObservableReplay$InnerDisposable observableReplay$InnerDisposable) {
        int n10 = observableReplay$InnerDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = 1;
        do {
            Object object;
            if ((object = (ObservableReplay$Node)observableReplay$InnerDisposable.index()) == null) {
                observableReplay$InnerDisposable.index = object = this.getHead();
            }
            while (true) {
                g0 g02;
                boolean bl2;
                if (bl2 = observableReplay$InnerDisposable.isDisposed()) {
                    observableReplay$InnerDisposable.index = null;
                    return;
                }
                ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node)((AtomicReference)object).get();
                if (observableReplay$Node == null) break;
                object = observableReplay$Node.value;
                boolean bl3 = NotificationLite.accept(object = this.leaveTransform(object), g02 = observableReplay$InnerDisposable.child);
                if (bl3) {
                    observableReplay$InnerDisposable.index = null;
                    return;
                }
                object = observableReplay$Node;
            }
            observableReplay$InnerDisposable.index = object;
            n10 = -n10;
        } while ((n10 = observableReplay$InnerDisposable.addAndGet(n10)) != 0);
    }

    public final void setFirst(ObservableReplay$Node observableReplay$Node) {
        this.set(observableReplay$Node);
    }

    public final void trimHead() {
        ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node)this.get();
        Object object = observableReplay$Node.value;
        if (object != null) {
            object = new ObservableReplay$Node((Object)null);
            observableReplay$Node = observableReplay$Node.get();
            ((AtomicReference)object).lazySet(observableReplay$Node);
            this.set(object);
        }
    }

    public abstract void truncate();

    public void truncateFinal() {
        this.trimHead();
    }
}

