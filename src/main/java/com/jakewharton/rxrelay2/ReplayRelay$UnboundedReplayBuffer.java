/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.ReplayRelay$ReplayDisposable;
import com.jakewharton.rxrelay2.ReplayRelay$a;
import e.a.g0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayRelay$UnboundedReplayBuffer
extends AtomicReference
implements ReplayRelay$a {
    private static final long serialVersionUID = -733876083048047795L;
    public final List buffer;
    public volatile int size;

    public ReplayRelay$UnboundedReplayBuffer(int n10) {
        if (n10 > 0) {
            ArrayList arrayList;
            this.buffer = arrayList = new ArrayList(n10);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("capacityHint <= 0");
        throw illegalArgumentException;
    }

    public void add(Object object) {
        int n10;
        this.buffer.add(object);
        this.size = n10 = this.size + 1;
    }

    public Object getValue() {
        int n10 = this.size;
        if (n10 != 0) {
            List list = this.buffer;
            return list.get(n10 += -1);
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
        int n12 = objectArray.length;
        if (n12 < n10) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n10);
        }
        List list = this.buffer;
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

    public void replay(ReplayRelay$ReplayDisposable replayRelay$ReplayDisposable) {
        int n10 = replayRelay$ReplayDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        List list = this.buffer;
        g0 g02 = replayRelay$ReplayDisposable.downstream;
        Integer n11 = (Integer)replayRelay$ReplayDisposable.index;
        int n12 = 0;
        int n13 = 1;
        if (n11 != null) {
            n12 = n11;
        } else {
            n11 = 0;
            replayRelay$ReplayDisposable.index = n11;
        }
        while (true) {
            int n14;
            if ((n14 = replayRelay$ReplayDisposable.cancelled) != 0) {
                replayRelay$ReplayDisposable.index = null;
                return;
            }
            n14 = this.size;
            while (n14 != n12) {
                boolean bl2 = replayRelay$ReplayDisposable.cancelled;
                if (bl2) {
                    replayRelay$ReplayDisposable.index = null;
                    return;
                }
                Object e10 = list.get(n12);
                g02.onNext(e10);
                ++n12;
            }
            n14 = this.size;
            if (n12 != n14) continue;
            n11 = n12;
            replayRelay$ReplayDisposable.index = n11;
            n14 = -n13;
            if ((n13 = replayRelay$ReplayDisposable.addAndGet(n14)) == 0) break;
        }
    }

    public int size() {
        return this.size;
    }

    public void trimHead() {
    }
}

