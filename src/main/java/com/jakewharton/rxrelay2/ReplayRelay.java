/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.ReplayRelay$ReplayDisposable;
import com.jakewharton.rxrelay2.ReplayRelay$SizeAndTimeBoundReplayBuffer;
import com.jakewharton.rxrelay2.ReplayRelay$SizeBoundReplayBuffer;
import com.jakewharton.rxrelay2.ReplayRelay$UnboundedReplayBuffer;
import com.jakewharton.rxrelay2.ReplayRelay$a;
import d.k.b.c;
import e.a.g0;
import e.a.h0;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayRelay
extends c {
    public static final ReplayRelay$ReplayDisposable[] c = new ReplayRelay$ReplayDisposable[0];
    private static final Object[] d = new Object[0];
    public final ReplayRelay$a a;
    public final AtomicReference b;

    public ReplayRelay(ReplayRelay$a atomicReference) {
        this.a = atomicReference;
        ReplayRelay$ReplayDisposable[] replayRelay$ReplayDisposableArray = c;
        this.b = atomicReference = new AtomicReference<ReplayRelay$ReplayDisposable[]>(replayRelay$ReplayDisposableArray);
    }

    public static ReplayRelay l8() {
        ReplayRelay$UnboundedReplayBuffer replayRelay$UnboundedReplayBuffer = new ReplayRelay$UnboundedReplayBuffer(16);
        ReplayRelay replayRelay = new ReplayRelay(replayRelay$UnboundedReplayBuffer);
        return replayRelay;
    }

    public static ReplayRelay m8(int n10) {
        ReplayRelay$UnboundedReplayBuffer replayRelay$UnboundedReplayBuffer = new ReplayRelay$UnboundedReplayBuffer(n10);
        ReplayRelay replayRelay = new ReplayRelay(replayRelay$UnboundedReplayBuffer);
        return replayRelay;
    }

    public static ReplayRelay n8() {
        ReplayRelay$SizeBoundReplayBuffer replayRelay$SizeBoundReplayBuffer = new ReplayRelay$SizeBoundReplayBuffer(-1 >>> 1);
        ReplayRelay replayRelay = new ReplayRelay(replayRelay$SizeBoundReplayBuffer);
        return replayRelay;
    }

    public static ReplayRelay o8(int n10) {
        ReplayRelay$SizeBoundReplayBuffer replayRelay$SizeBoundReplayBuffer = new ReplayRelay$SizeBoundReplayBuffer(n10);
        ReplayRelay replayRelay = new ReplayRelay(replayRelay$SizeBoundReplayBuffer);
        return replayRelay;
    }

    public static ReplayRelay p8(long l10, TimeUnit timeUnit, h0 h02) {
        ReplayRelay$SizeAndTimeBoundReplayBuffer replayRelay$SizeAndTimeBoundReplayBuffer = new ReplayRelay$SizeAndTimeBoundReplayBuffer(-1 >>> 1, l10, timeUnit, h02);
        ReplayRelay replayRelay = new ReplayRelay(replayRelay$SizeAndTimeBoundReplayBuffer);
        return replayRelay;
    }

    public static ReplayRelay q8(long l10, TimeUnit timeUnit, h0 h02, int n10) {
        ReplayRelay$SizeAndTimeBoundReplayBuffer replayRelay$SizeAndTimeBoundReplayBuffer = new ReplayRelay$SizeAndTimeBoundReplayBuffer(n10, l10, timeUnit, h02);
        ReplayRelay replayRelay = new ReplayRelay(replayRelay$SizeAndTimeBoundReplayBuffer);
        return replayRelay;
    }

    public void K5(g0 object) {
        ReplayRelay$ReplayDisposable replayRelay$ReplayDisposable = new ReplayRelay$ReplayDisposable((g0)object, this);
        object.onSubscribe(replayRelay$ReplayDisposable);
        boolean bl2 = replayRelay$ReplayDisposable.cancelled;
        if (!bl2) {
            bl2 = this.j8(replayRelay$ReplayDisposable);
            if (bl2 && (bl2 = replayRelay$ReplayDisposable.cancelled)) {
                this.w8(replayRelay$ReplayDisposable);
                return;
            }
            object = this.a;
            object.replay(replayRelay$ReplayDisposable);
        }
    }

    public void accept(Object replayRelay$ReplayDisposableArray) {
        Objects.requireNonNull(replayRelay$ReplayDisposableArray, "value == null");
        ReplayRelay$a replayRelay$a = this.a;
        replayRelay$a.add(replayRelay$ReplayDisposableArray);
        for (ReplayRelay$ReplayDisposable replayRelay$ReplayDisposable : (ReplayRelay$ReplayDisposable[])this.b.get()) {
            replayRelay$a.replay(replayRelay$ReplayDisposable);
        }
    }

    public boolean h8() {
        ReplayRelay$ReplayDisposable[] replayRelay$ReplayDisposableArray = (ReplayRelay$ReplayDisposable[])this.b.get();
        boolean bl2 = replayRelay$ReplayDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            replayRelay$ReplayDisposableArray = null;
        }
        return bl2;
    }

    public boolean j8(ReplayRelay$ReplayDisposable replayRelay$ReplayDisposable) {
        ReplayRelay$ReplayDisposable[] replayRelay$ReplayDisposableArray;
        ReplayRelay$ReplayDisposable[] replayRelay$ReplayDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            replayRelay$ReplayDisposableArray2 = (ReplayRelay$ReplayDisposable[])this.b.get();
            int n10 = replayRelay$ReplayDisposableArray2.length;
            int n11 = n10 + 1;
            replayRelay$ReplayDisposableArray = new ReplayRelay$ReplayDisposable[n11];
            System.arraycopy(replayRelay$ReplayDisposableArray2, 0, replayRelay$ReplayDisposableArray, 0, n10);
            replayRelay$ReplayDisposableArray[n10] = replayRelay$ReplayDisposable;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(replayRelay$ReplayDisposableArray2, replayRelay$ReplayDisposableArray)));
        return true;
    }

    public void k8() {
        this.a.trimHead();
    }

    public Object r8() {
        return this.a.getValue();
    }

    public Object[] s8() {
        Object[] objectArray = d;
        Object[] objectArray2 = this.t8(objectArray);
        if (objectArray2 == objectArray) {
            return new Object[0];
        }
        return objectArray2;
    }

    public Object[] t8(Object[] objectArray) {
        return this.a.getValues(objectArray);
    }

    public boolean u8() {
        ReplayRelay$a replayRelay$a = this.a;
        int n10 = replayRelay$a.size();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            replayRelay$a = null;
        }
        return n10 != 0;
    }

    public int v8() {
        return ((ReplayRelay$ReplayDisposable[])this.b.get()).length;
    }

    public void w8(ReplayRelay$ReplayDisposable replayRelay$ReplayDisposable) {
        ReplayRelay$ReplayDisposable[] replayRelay$ReplayDisposableArray;
        ReplayRelay$ReplayDisposable[] replayRelay$ReplayDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            ReplayRelay$ReplayDisposable[] replayRelay$ReplayDisposableArray3;
            int n10;
            if ((replayRelay$ReplayDisposableArray2 = (ReplayRelay$ReplayDisposable[])this.b.get()) == (replayRelay$ReplayDisposableArray = c)) {
                return;
            }
            int n11 = replayRelay$ReplayDisposableArray2.length;
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                replayRelay$ReplayDisposableArray3 = replayRelay$ReplayDisposableArray2[n10];
                if (replayRelay$ReplayDisposableArray3 != replayRelay$ReplayDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                replayRelay$ReplayDisposableArray = c;
                continue;
            }
            int n14 = n11 + -1;
            replayRelay$ReplayDisposableArray3 = new ReplayRelay$ReplayDisposable[n14];
            System.arraycopy(replayRelay$ReplayDisposableArray2, 0, replayRelay$ReplayDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(replayRelay$ReplayDisposableArray2, n13, replayRelay$ReplayDisposableArray3, n12, n11);
            replayRelay$ReplayDisposableArray = replayRelay$ReplayDisposableArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(replayRelay$ReplayDisposableArray2, replayRelay$ReplayDisposableArray)));
    }

    public int x8() {
        return this.a.size();
    }
}

