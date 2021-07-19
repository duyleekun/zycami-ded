/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.a1.a;
import e.a.d1.c;
import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.ReplaySubject$ReplayDisposable;
import io.reactivex.subjects.ReplaySubject$SizeAndTimeBoundReplayBuffer;
import io.reactivex.subjects.ReplaySubject$SizeBoundReplayBuffer;
import io.reactivex.subjects.ReplaySubject$UnboundedReplayBuffer;
import io.reactivex.subjects.ReplaySubject$a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject
extends c {
    public static final ReplaySubject$ReplayDisposable[] d = new ReplaySubject$ReplayDisposable[0];
    public static final ReplaySubject$ReplayDisposable[] e = new ReplaySubject$ReplayDisposable[0];
    private static final Object[] f = new Object[0];
    public final ReplaySubject$a a;
    public final AtomicReference b;
    public boolean c;

    public ReplaySubject(ReplaySubject$a atomicReference) {
        this.a = atomicReference;
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray = d;
        this.b = atomicReference = new AtomicReference<ReplaySubject$ReplayDisposable[]>(replaySubject$ReplayDisposableArray);
    }

    public static ReplaySubject o8() {
        ReplaySubject$UnboundedReplayBuffer replaySubject$UnboundedReplayBuffer = new ReplaySubject$UnboundedReplayBuffer(16);
        ReplaySubject replaySubject = new ReplaySubject(replaySubject$UnboundedReplayBuffer);
        return replaySubject;
    }

    public static ReplaySubject p8(int n10) {
        ReplaySubject$UnboundedReplayBuffer replaySubject$UnboundedReplayBuffer = new ReplaySubject$UnboundedReplayBuffer(n10);
        ReplaySubject replaySubject = new ReplaySubject(replaySubject$UnboundedReplayBuffer);
        return replaySubject;
    }

    public static ReplaySubject q8() {
        ReplaySubject$SizeBoundReplayBuffer replaySubject$SizeBoundReplayBuffer = new ReplaySubject$SizeBoundReplayBuffer(-1 >>> 1);
        ReplaySubject replaySubject = new ReplaySubject(replaySubject$SizeBoundReplayBuffer);
        return replaySubject;
    }

    public static ReplaySubject r8(int n10) {
        ReplaySubject$SizeBoundReplayBuffer replaySubject$SizeBoundReplayBuffer = new ReplaySubject$SizeBoundReplayBuffer(n10);
        ReplaySubject replaySubject = new ReplaySubject(replaySubject$SizeBoundReplayBuffer);
        return replaySubject;
    }

    public static ReplaySubject s8(long l10, TimeUnit timeUnit, h0 h02) {
        ReplaySubject$SizeAndTimeBoundReplayBuffer replaySubject$SizeAndTimeBoundReplayBuffer = new ReplaySubject$SizeAndTimeBoundReplayBuffer(-1 >>> 1, l10, timeUnit, h02);
        ReplaySubject replaySubject = new ReplaySubject(replaySubject$SizeAndTimeBoundReplayBuffer);
        return replaySubject;
    }

    public static ReplaySubject t8(long l10, TimeUnit timeUnit, h0 h02, int n10) {
        ReplaySubject$SizeAndTimeBoundReplayBuffer replaySubject$SizeAndTimeBoundReplayBuffer = new ReplaySubject$SizeAndTimeBoundReplayBuffer(n10, l10, timeUnit, h02);
        ReplaySubject replaySubject = new ReplaySubject(replaySubject$SizeAndTimeBoundReplayBuffer);
        return replaySubject;
    }

    public int A8() {
        return this.a.size();
    }

    public ReplaySubject$ReplayDisposable[] B8(Object object) {
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray = this.a;
        boolean bl2 = replaySubject$ReplayDisposableArray.compareAndSet(null, object);
        if (bl2) {
            object = this.b;
            replaySubject$ReplayDisposableArray = e;
            return ((AtomicReference)object).getAndSet(replaySubject$ReplayDisposableArray);
        }
        return e;
    }

    public void K5(g0 object) {
        ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable = new ReplaySubject$ReplayDisposable((g0)object, this);
        object.onSubscribe(replaySubject$ReplayDisposable);
        boolean bl2 = replaySubject$ReplayDisposable.cancelled;
        if (!bl2) {
            bl2 = this.m8(replaySubject$ReplayDisposable);
            if (bl2 && (bl2 = replaySubject$ReplayDisposable.cancelled)) {
                this.z8(replaySubject$ReplayDisposable);
                return;
            }
            object = this.a;
            object.replay(replaySubject$ReplayDisposable);
        }
    }

    public Throwable h8() {
        Object object = this.a.get();
        boolean bl2 = NotificationLite.isError(object);
        if (bl2) {
            return NotificationLite.getError(object);
        }
        return null;
    }

    public boolean i8() {
        return NotificationLite.isComplete(this.a.get());
    }

    public boolean j8() {
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray = (ReplaySubject$ReplayDisposable[])this.b.get();
        boolean bl2 = replaySubject$ReplayDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            replaySubject$ReplayDisposableArray = null;
        }
        return bl2;
    }

    public boolean k8() {
        return NotificationLite.isError(this.a.get());
    }

    public boolean m8(ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable) {
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray;
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((replaySubject$ReplayDisposableArray2 = (ReplaySubject$ReplayDisposable[])this.b.get()) == (object = e)) {
                return false;
            }
            int n10 = replaySubject$ReplayDisposableArray2.length;
            int n11 = n10 + 1;
            replaySubject$ReplayDisposableArray = new ReplaySubject$ReplayDisposable[n11];
            System.arraycopy(replaySubject$ReplayDisposableArray2, 0, replaySubject$ReplayDisposableArray, 0, n10);
            replaySubject$ReplayDisposableArray[n10] = replaySubject$ReplayDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(replaySubject$ReplayDisposableArray2, replaySubject$ReplayDisposableArray)));
        return true;
    }

    public void n8() {
        this.a.trimHead();
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = bl2 = true;
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray = NotificationLite.complete();
        ReplaySubject$a replaySubject$a = this.a;
        replaySubject$a.addFinal(replaySubject$ReplayDisposableArray);
        for (ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable : this.B8(replaySubject$ReplayDisposableArray)) {
            replaySubject$a.replay(replaySubject$ReplayDisposable);
        }
    }

    public void onError(Throwable replaySubject$ReplayDisposableArray) {
        Object object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(replaySubject$ReplayDisposableArray, (String)object);
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y((Throwable)replaySubject$ReplayDisposableArray);
            return;
        }
        this.c = bl2 = true;
        replaySubject$ReplayDisposableArray = NotificationLite.error((Throwable)replaySubject$ReplayDisposableArray);
        object = this.a;
        object.addFinal(replaySubject$ReplayDisposableArray);
        for (ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable : this.B8(replaySubject$ReplayDisposableArray)) {
            object.replay(replaySubject$ReplayDisposable);
        }
    }

    public void onNext(Object replaySubject$ReplayDisposableArray) {
        Object object = "onNext called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(replaySubject$ReplayDisposableArray, (String)object);
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        object = this.a;
        object.add(replaySubject$ReplayDisposableArray);
        for (ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable : (ReplaySubject$ReplayDisposable[])this.b.get()) {
            object.replay(replaySubject$ReplayDisposable);
        }
    }

    public void onSubscribe(b b10) {
        boolean bl2 = this.c;
        if (bl2) {
            b10.dispose();
        }
    }

    public Object u8() {
        return this.a.getValue();
    }

    public Object[] v8() {
        Object[] objectArray = f;
        Object[] objectArray2 = this.w8(objectArray);
        if (objectArray2 == objectArray) {
            return new Object[0];
        }
        return objectArray2;
    }

    public Object[] w8(Object[] objectArray) {
        return this.a.getValues(objectArray);
    }

    public boolean x8() {
        ReplaySubject$a replaySubject$a = this.a;
        int n10 = replaySubject$a.size();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            replaySubject$a = null;
        }
        return n10 != 0;
    }

    public int y8() {
        return ((ReplaySubject$ReplayDisposable[])this.b.get()).length;
    }

    public void z8(ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable) {
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray;
        ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray2;
        while ((replaySubject$ReplayDisposableArray2 = (ReplaySubject$ReplayDisposable[])this.b.get()) != (replaySubject$ReplayDisposableArray = e) && replaySubject$ReplayDisposableArray2 != (replaySubject$ReplayDisposableArray = d)) {
            AtomicReference atomicReference;
            boolean bl2;
            ReplaySubject$ReplayDisposable[] replaySubject$ReplayDisposableArray3;
            int n10;
            int n11 = replaySubject$ReplayDisposableArray2.length;
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                replaySubject$ReplayDisposableArray3 = replaySubject$ReplayDisposableArray2[n10];
                if (replaySubject$ReplayDisposableArray3 != replaySubject$ReplayDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                replaySubject$ReplayDisposableArray = d;
            } else {
                int n14 = n11 + -1;
                replaySubject$ReplayDisposableArray3 = new ReplaySubject$ReplayDisposable[n14];
                System.arraycopy(replaySubject$ReplayDisposableArray2, 0, replaySubject$ReplayDisposableArray3, 0, n12);
                n13 = n12 + 1;
                n11 = n11 - n12 - n10;
                System.arraycopy(replaySubject$ReplayDisposableArray2, n13, replaySubject$ReplayDisposableArray3, n12, n11);
                replaySubject$ReplayDisposableArray = replaySubject$ReplayDisposableArray3;
            }
            if (!(bl2 = (atomicReference = this.b).compareAndSet(replaySubject$ReplayDisposableArray2, replaySubject$ReplayDisposableArray))) continue;
        }
    }
}

