/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import e.a.w0.a.c;
import e.a.w0.e.e.d1;
import e.a.x0.a;
import e.a.z;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection;
import io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount
extends z {
    public final a a;
    public final int b;
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public ObservableRefCount$RefConnection f;

    public ObservableRefCount(a a10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this(a10, 1, 0L, timeUnit, null);
    }

    public ObservableRefCount(a a10, int n10, long l10, TimeUnit timeUnit, h0 h02) {
        this.a = a10;
        this.b = n10;
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void K5(g0 object) {
        boolean bl2;
        ObservableRefCount$RefConnection observableRefCount$RefConnection;
        synchronized (this) {
            long l10;
            long l11;
            long l12;
            b b10;
            long l13;
            long l14;
            long l15;
            long l16;
            observableRefCount$RefConnection = this.f;
            if (observableRefCount$RefConnection == null) {
                this.f = observableRefCount$RefConnection = new ObservableRefCount$RefConnection(this);
            }
            if ((l16 = (l15 = (l14 = observableRefCount$RefConnection.subscriberCount) - (l13 = 0L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false && (b10 = observableRefCount$RefConnection.timer) != null) {
                b10.dispose();
            }
            l13 = 1L;
            observableRefCount$RefConnection.subscriberCount = l14 += l13;
            l16 = (long)observableRefCount$RefConnection.connected;
            bl2 = true;
            if (l16 == false && (l12 = (l11 = l14 - (l10 = (long)(l16 = (long)this.b))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
                observableRefCount$RefConnection.connected = bl2;
            } else {
                bl2 = false;
            }
        }
        a a10 = this.a;
        ObservableRefCount$RefCountObserver observableRefCount$RefCountObserver = new ObservableRefCount$RefCountObserver((g0)object, this, observableRefCount$RefConnection);
        a10.subscribe(observableRefCount$RefCountObserver);
        if (bl2) {
            object = this.a;
            ((a)object).l8(observableRefCount$RefConnection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h8(ObservableRefCount$RefConnection object) {
        synchronized (this) {
            AtomicReference atomicReference = this.f;
            if (atomicReference != null && atomicReference == object) {
                long l10 = ((ObservableRefCount$RefConnection)object).subscriberCount;
                long l11 = 1L;
                ((ObservableRefCount$RefConnection)object).subscriberCount = l10 -= l11;
                l11 = 0L;
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 == false && (object2 = (Object)((ObservableRefCount$RefConnection)object).connected) != false) {
                    l10 = this.c;
                    long l13 = l10 - l11;
                    object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object2 == false) {
                        this.l8((ObservableRefCount$RefConnection)object);
                        return;
                    }
                    atomicReference = new SequentialDisposable();
                    ((ObservableRefCount$RefConnection)object).timer = atomicReference;
                    // MONITOREXIT @DISABLED, blocks:[4, 6, 7] lbl20 : MonitorExitStatement: MONITOREXIT : this
                    h0 h02 = this.e;
                    l11 = this.c;
                    TimeUnit timeUnit = this.d;
                    object = h02.f((Runnable)object, l11, timeUnit);
                    ((SequentialDisposable)atomicReference).replace((b)object);
                    return;
                }
                return;
            }
            return;
        }
    }

    public void i8(ObservableRefCount$RefConnection observableRefCount$RefConnection) {
        b b10 = observableRefCount$RefConnection.timer;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            observableRefCount$RefConnection.timer = null;
        }
    }

    public void j8(ObservableRefCount$RefConnection object) {
        Object object2 = this.a;
        boolean bl2 = object2 instanceof b;
        if (bl2) {
            object2 = (b)object2;
            object2.dispose();
        } else {
            bl2 = object2 instanceof c;
            if (bl2) {
                object2 = (c)object2;
                object = (b)((AtomicReference)object).get();
                object2.m((b)object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k8(ObservableRefCount$RefConnection observableRefCount$RefConnection) {
        synchronized (this) {
            Object object = this.a;
            Object object2 = object instanceof d1;
            long l10 = 0L;
            long l11 = 1L;
            if (object2) {
                long l12;
                object = this.f;
                if (object != null && object == observableRefCount$RefConnection) {
                    this.f = null;
                    this.i8(observableRefCount$RefConnection);
                }
                observableRefCount$RefConnection.subscriberCount = l12 = observableRefCount$RefConnection.subscriberCount - l11;
                object2 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                if (!object2) {
                    this.j8(observableRefCount$RefConnection);
                }
            } else {
                object = this.f;
                if (object != null && object == observableRefCount$RefConnection) {
                    long l13;
                    this.i8(observableRefCount$RefConnection);
                    observableRefCount$RefConnection.subscriberCount = l13 = observableRefCount$RefConnection.subscriberCount - l11;
                    object2 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
                    if (!object2) {
                        this.f = null;
                        this.j8(observableRefCount$RefConnection);
                    }
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l8(ObservableRefCount$RefConnection observableRefCount$RefConnection) {
        synchronized (this) {
            Object object;
            long l10 = observableRefCount$RefConnection.subscriberCount;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false && observableRefCount$RefConnection == (object = this.f)) {
                l12 = 0;
                object = null;
                this.f = null;
                object = observableRefCount$RefConnection.get();
                object = (b)object;
                DisposableHelper.dispose(observableRefCount$RefConnection);
                Object object2 = this.a;
                boolean bl2 = object2 instanceof b;
                if (bl2) {
                    object2 = (b)object2;
                    object2.dispose();
                } else {
                    bl2 = object2 instanceof c;
                    if (bl2) {
                        if (object == null) {
                            l12 = 1;
                            observableRefCount$RefConnection.disconnectedEarly = l12;
                        } else {
                            object2 = (c)object2;
                            object2.m((b)object);
                        }
                    }
                }
            }
            return;
        }
    }
}

