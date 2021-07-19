/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.observers;

import e.a.d;
import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import e.a.t;
import e.a.v0.g;
import e.a.w0.c.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import io.reactivex.observers.TestObserver$EmptyObserver;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver
extends BaseTestConsumer
implements g0,
b,
t,
l0,
d {
    private final g0 k;
    private final AtomicReference l;
    private j m;

    public TestObserver() {
        TestObserver$EmptyObserver testObserver$EmptyObserver = TestObserver$EmptyObserver.INSTANCE;
        this(testObserver$EmptyObserver);
    }

    public TestObserver(g0 g02) {
        AtomicReference atomicReference;
        this.l = atomicReference = new AtomicReference();
        this.k = g02;
    }

    public static TestObserver i0() {
        TestObserver testObserver = new TestObserver();
        return testObserver;
    }

    public static TestObserver j0(g0 g02) {
        TestObserver testObserver = new TestObserver(g02);
        return testObserver;
    }

    public static String k0(int n10) {
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

    public final TestObserver c0() {
        Object object = this.m;
        if (object != null) {
            return this;
        }
        object = new AssertionError((Object)"Upstream is not fuseable.");
        throw object;
    }

    public final void cancel() {
        this.dispose();
    }

    public final TestObserver d0(int n10) {
        int n11 = this.h;
        if (n11 != n10) {
            Object object = this.m;
            if (object != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fusion mode different. Expected: ");
                String string2 = TestObserver.k0(n10);
                stringBuilder.append(string2);
                stringBuilder.append(", actual: ");
                string2 = TestObserver.k0(n11);
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
        DisposableHelper.dispose(this.l);
    }

    public final TestObserver e0() {
        Object object = this.m;
        if (object == null) {
            return this;
        }
        object = new AssertionError((Object)"Upstream is fuseable.");
        throw object;
    }

    public final TestObserver f0() {
        Object object = this.l.get();
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

    public final TestObserver g0(g g10) {
        try {
            g10.accept(this);
            return this;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.f(throwable);
        }
    }

    public final TestObserver h0() {
        Object v10 = this.l.get();
        if (v10 != null) {
            return this;
        }
        throw this.T("Not subscribed!");
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.l.get());
    }

    public final boolean l0() {
        boolean bl2;
        Object v10 = this.l.get();
        if (v10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public final boolean m0() {
        return this.isDisposed();
    }

    public final TestObserver n0(int n10) {
        this.g = n10;
        return this;
    }

    public void onComplete() {
        Object object;
        boolean bl2 = this.f;
        if (!bl2) {
            this.f = bl2 = true;
            object = this.l.get();
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
            object = this.l.get();
            if (object == null) {
                object = this.c;
                string2 = "onSubscribe not called in proper order";
                runtimeException = new IllegalStateException(string2);
                object.add(runtimeException);
            }
        }
        try {
            object = Thread.currentThread();
            this.e = object;
            if (throwable == null) {
                object = this.c;
                string2 = "onError received a null Throwable";
                runtimeException = new NullPointerException(string2);
                object.add(runtimeException);
            } else {
                object = this.c;
                object.add(throwable);
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
            object2 = this.l.get();
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
                    object = this.m;
                    if ((object = object.poll()) == null) return;
                    object2 = this.b;
                    object2.add(object);
                }
            }
            catch (Throwable throwable) {
                object2 = this.c;
                object2.add(throwable);
                j j10 = this.m;
                j10.dispose();
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
    public void onSubscribe(b object) {
        Object object2 = Thread.currentThread();
        this.e = object2;
        if (object == null) {
            object = this.c;
            object2 = new NullPointerException("onSubscribe received a null Subscription");
            object.add(object2);
            return;
        }
        object2 = this.l;
        int n10 = 0;
        Object object3 = null;
        int n11 = ((AtomicReference)object2).compareAndSet(null, object);
        if (n11 == 0) {
            object.dispose();
            object2 = this.l.get();
            object3 = DisposableHelper.DISPOSED;
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
        if (n11 != 0 && (n10 = object instanceof j) != 0) {
            object3 = object;
            this.m = object3 = (j)object;
            this.h = n11 = object3.requestFusion(n11);
            n10 = 1;
            if (n11 == n10) {
                this.f = n10;
                this.e = object = Thread.currentThread();
                try {
                    while (true) {
                        object = this.m;
                        if ((object = object.poll()) == null) {
                            long l10 = this.d;
                            long l11 = 1L;
                            this.d = l10 += l11;
                            object = this.l;
                            object2 = DisposableHelper.DISPOSED;
                            ((AtomicReference)object).lazySet(object2);
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
        this.k.onSubscribe((b)object);
    }

    public void onSuccess(Object object) {
        this.onNext(object);
        this.onComplete();
    }
}

