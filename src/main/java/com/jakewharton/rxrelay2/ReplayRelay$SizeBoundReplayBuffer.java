/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.ReplayRelay$Node;
import com.jakewharton.rxrelay2.ReplayRelay$ReplayDisposable;
import com.jakewharton.rxrelay2.ReplayRelay$a;
import e.a.g0;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayRelay$SizeBoundReplayBuffer
extends AtomicReference
implements ReplayRelay$a {
    private static final long serialVersionUID = 1107649250281456395L;
    public volatile ReplayRelay$Node head;
    public final int maxSize;
    public int size;
    public ReplayRelay$Node tail;

    public ReplayRelay$SizeBoundReplayBuffer(int n10) {
        if (n10 > 0) {
            ReplayRelay$Node replayRelay$Node;
            this.maxSize = n10;
            this.tail = replayRelay$Node = new ReplayRelay$Node((Object)null);
            this.head = replayRelay$Node;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxSize > 0 required but it was ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void add(Object object) {
        int n10;
        ReplayRelay$Node replayRelay$Node = new ReplayRelay$Node(object);
        object = this.tail;
        this.tail = replayRelay$Node;
        this.size = n10 = this.size + 1;
        ((AtomicReference)object).set(replayRelay$Node);
        this.trim();
    }

    public Object getValue() {
        ReplayRelay$Node replayRelay$Node = this.head;
        ReplayRelay$Node replayRelay$Node2;
        while ((replayRelay$Node2 = (ReplayRelay$Node)replayRelay$Node.get()) != null) {
            replayRelay$Node = replayRelay$Node2;
        }
        return replayRelay$Node.value;
    }

    public Object[] getValues(Object[] objectArray) {
        ReplayRelay$Node replayRelay$Node = this.head;
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
                replayRelay$Node = (ReplayRelay$Node)replayRelay$Node.get();
                objectArray[n11] = object = replayRelay$Node.value;
                ++n11;
            }
            int n14 = objectArray.length;
            if (n14 > n10) {
                objectArray[n10] = null;
            }
        }
        return objectArray;
    }

    public void replay(ReplayRelay$ReplayDisposable replayRelay$ReplayDisposable) {
        int n10 = replayRelay$ReplayDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = 1;
        g0 g02 = replayRelay$ReplayDisposable.downstream;
        Object object = (ReplayRelay$Node)replayRelay$ReplayDisposable.index;
        if (object == null) {
            object = this.head;
        }
        while (true) {
            boolean bl2;
            if (bl2 = replayRelay$ReplayDisposable.cancelled) {
                replayRelay$ReplayDisposable.index = null;
                return;
            }
            ReplayRelay$Node replayRelay$Node = (ReplayRelay$Node)((AtomicReference)object).get();
            if (replayRelay$Node == null) {
                replayRelay$Node = ((AtomicReference)object).get();
                if (replayRelay$Node != null) continue;
                replayRelay$ReplayDisposable.index = object;
                n10 = -n10;
                if ((n10 = replayRelay$ReplayDisposable.addAndGet(n10)) != 0) continue;
                return;
            }
            object = replayRelay$Node.value;
            g02.onNext(object);
            object = replayRelay$Node;
        }
    }

    public int size() {
        int n10;
        int n11;
        ReplayRelay$Node replayRelay$Node = this.head;
        for (n11 = 0; n11 != (n10 = -1 >>> 1) && (replayRelay$Node = (ReplayRelay$Node)replayRelay$Node.get()) != null; ++n11) {
        }
        return n11;
    }

    public void trim() {
        int n10 = this.size;
        int n11 = this.maxSize;
        if (n10 > n11) {
            ReplayRelay$Node replayRelay$Node;
            this.size = n10 += -1;
            this.head = replayRelay$Node = (ReplayRelay$Node)this.head.get();
        }
    }

    public void trimHead() {
        ReplayRelay$Node replayRelay$Node = this.head;
        Object object = replayRelay$Node.value;
        if (object != null) {
            object = new ReplayRelay$Node((Object)null);
            replayRelay$Node = replayRelay$Node.get();
            ((AtomicReference)object).lazySet(replayRelay$Node);
            this.head = object;
        }
    }
}

