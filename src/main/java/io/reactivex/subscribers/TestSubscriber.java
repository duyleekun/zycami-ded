/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subscribers;

import e.a.o;
import e.a.s0.b;
import e.a.v0.g;
import e.a.w0.c.l;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import io.reactivex.subscribers.TestSubscriber$EmptySubscriber;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TestSubscriber
extends BaseTestConsumer
implements o,
e,
b {
    private final d k;
    private volatile boolean l;
    private final AtomicReference m;
    private final AtomicLong n;
    private l o;

    public TestSubscriber() {
        TestSubscriber$EmptySubscriber testSubscriber$EmptySubscriber = TestSubscriber$EmptySubscriber.INSTANCE;
        this(testSubscriber$EmptySubscriber, Long.MAX_VALUE);
    }

    public TestSubscriber(long l10) {
        TestSubscriber$EmptySubscriber testSubscriber$EmptySubscriber = TestSubscriber$EmptySubscriber.INSTANCE;
        this(testSubscriber$EmptySubscriber, l10);
    }

    public TestSubscriber(d d10) {
        this(d10, Long.MAX_VALUE);
    }

    public TestSubscriber(d serializable, long l10) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            this.k = serializable;
            this.m = serializable = new Serializable();
            super(l10);
            this.n = serializable;
            return;
        }
        serializable = new Serializable("Negative initial request not allowed");
        throw serializable;
    }

    public static TestSubscriber i0() {
        TestSubscriber testSubscriber = new TestSubscriber();
        return testSubscriber;
    }

    public static TestSubscriber j0(long l10) {
        TestSubscriber testSubscriber = new TestSubscriber(l10);
        return testSubscriber;
    }

    public static TestSubscriber k0(d d10) {
        TestSubscriber testSubscriber = new TestSubscriber(d10);
        return testSubscriber;
    }

    public static String l0(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown(");
                    stringBuilder.append(n10);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
                return "ASYNC";
            }
            return "SYNC";
        }
        return "NONE";
    }

    public final TestSubscriber c0() {
        Object object = this.o;
        if (object != null) {
            return this;
        }
        object = new AssertionError((Object)"Upstream is not fuseable.");
        throw object;
    }

    public final void cancel() {
        boolean bl2 = this.l;
        if (!bl2) {
            this.l = bl2 = true;
            AtomicReference atomicReference = this.m;
            SubscriptionHelper.cancel(atomicReference);
        }
    }

    public final TestSubscriber d0(int n10) {
        int n11 = this.h;
        if (n11 != n10) {
            Object object = this.o;
            if (object != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fusion mode different. Expected: ");
                String string2 = TestSubscriber.l0(n10);
                stringBuilder.append(string2);
                stringBuilder.append(", actual: ");
                string2 = TestSubscriber.l0(n11);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                object = new AssertionError((Object)string2);
                throw object;
            }
            throw this.T("Upstream is not fuseable");
        }
        return this;
    }

    public final void dispose() {
        this.cancel();
    }

    public final TestSubscriber e0() {
        Object object = this.o;
        if (object == null) {
            return this;
        }
        object = new AssertionError((Object)"Upstream is fuseable.");
        throw object;
    }

    public final TestSubscriber f0() {
        Object object = this.m.get();
        if (object == null) {
            object = this.c;
            boolean bl2 = object.isEmpty();
            if (bl2) {
                return this;
            }
            throw this.T("Not subscribed but errors found");
        }
        throw this.T("Subscribed!");
    }

    public final TestSubscriber g0(g g10) {
        try {
            g10.accept(this);
            return this;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.f(throwable);
        }
    }

    public final TestSubscriber h0() {
        Object v10 = this.m.get();
        if (v10 != null) {
            return this;
        }
        throw this.T("Not subscribed!");
    }

    public final boolean isDisposed() {
        return this.l;
    }

    public final boolean m0() {
        boolean bl2;
        Object v10 = this.m.get();
        if (v10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public final boolean n0() {
        return this.l;
    }

    public void o0() {
    }

    public void onComplete() {
        Object object;
        boolean bl2 = this.f;
        if (!bl2) {
            this.f = bl2 = true;
            object = this.m.get();
            if (object == null) {
                object = this.c;
                String string2 = "onSubscribe not called in proper order";
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                object.add(illegalStateException);
            }
        }
        object = Thread.currentThread();
        this.e = object;
        long l10 = this.d;
        long l11 = 1L;
        l10 += l11;
        try {
            this.d = l10;
            object = this.k;
            object.onComplete();
            return;
        }
        finally {
            this.a.countDown();
        }
    }

    public void onError(Throwable throwable) {
        RuntimeException runtimeException;
        String string2;
        Object object;
        boolean bl2 = this.f;
        if (!bl2) {
            this.f = bl2 = true;
            object = this.m.get();
            if (object == null) {
                object = this.c;
                string2 = "onSubscribe not called in proper order";
                runtimeException = new NullPointerException(string2);
                object.add(runtimeException);
            }
        }
        try {
            object = Thread.currentThread();
            this.e = object;
            object = this.c;
            object.add(throwable);
            if (throwable == null) {
                object = this.c;
                string2 = "onError received a null Throwable";
                runtimeException = new IllegalStateException(string2);
                object.add(runtimeException);
            }
            object = this.k;
            object.onError(throwable);
            return;
        }
        finally {
            this.a.countDown();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        RuntimeException runtimeException;
        String string2;
        Object object2;
        int n10 = this.f;
        if (n10 == 0) {
            this.f = n10 = 1;
            object2 = this.m.get();
            if (object2 == null) {
                object2 = this.c;
                string2 = "onSubscribe not called in proper order";
                runtimeException = new IllegalStateException(string2);
                object2.add(runtimeException);
            }
        }
        object2 = Thread.currentThread();
        this.e = object2;
        n10 = this.h;
        int n11 = 2;
        if (n10 == n11) {
            try {
                while (true) {
                    object = this.o;
                    if ((object = object.poll()) == null) return;
                    object2 = this.b;
                    object2.add(object);
                }
            }
            catch (Throwable throwable) {
                object2 = this.c;
                object2.add(throwable);
                l l10 = this.o;
                l10.cancel();
            }
            return;
        }
        object2 = this.b;
        object2.add(object);
        if (object == null) {
            object2 = this.c;
            string2 = "onNext received a null value";
            runtimeException = new NullPointerException(string2);
            object2.add(runtimeException);
        }
        this.k.onNext(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSubscribe(e object) {
        Object object2 = Thread.currentThread();
        this.e = object2;
        if (object == null) {
            object = this.c;
            object2 = new NullPointerException("onSubscribe received a null Subscription");
            object.add(object2);
            return;
        }
        object2 = this.m;
        int n10 = 0;
        Object object3 = null;
        int n11 = ((AtomicReference)object2).compareAndSet(null, object);
        if (n11 == 0) {
            object.cancel();
            object2 = this.m.get();
            object3 = SubscriptionHelper.CANCELLED;
            if (object2 == object3) return;
            object2 = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "onSubscribe received multiple subscriptions: ";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object3 = new IllegalStateException((String)object);
            object2.add(object3);
            return;
        }
        n11 = this.g;
        if (n11 != 0 && (n10 = object instanceof l) != 0) {
            object3 = object;
            this.o = object3 = (l)object;
            this.h = n11 = object3.requestFusion(n11);
            n10 = 1;
            if (n11 == n10) {
                this.f = n10;
                this.e = object = Thread.currentThread();
                try {
                    while (true) {
                        object = this.o;
                        if ((object = object.poll()) == null) {
                            long l10 = this.d;
                            long l11 = 1L;
                            this.d = l10 += l11;
                            return;
                        }
                        object2 = this.b;
                        object2.add(object);
                    }
                }
                catch (Throwable throwable) {
                    object2 = this.c;
                    object2.add(throwable);
                }
                return;
            }
        }
        this.k.onSubscribe((e)object);
        object2 = this.n;
        long l12 = 0L;
        long l13 = ((AtomicLong)object2).getAndSet(l12);
        n11 = (int)(l13 == l12 ? 0 : (l13 < l12 ? -1 : 1));
        if (n11 != 0) {
            ((e)object).request(l13);
        }
        this.o0();
    }

    public final TestSubscriber p0(long l10) {
        this.request(l10);
        return this;
    }

    public final TestSubscriber q0(int n10) {
        this.g = n10;
        return this;
    }

    public final void request(long l10) {
        AtomicReference atomicReference = this.m;
        AtomicLong atomicLong = this.n;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }
}

