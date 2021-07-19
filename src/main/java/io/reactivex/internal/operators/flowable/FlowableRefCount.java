/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.s0.b;
import e.a.u0.a;
import e.a.w0.a.c;
import e.a.w0.e.b.s0;
import i.g.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableRefCount$RefConnection;
import io.reactivex.internal.operators.flowable.FlowableRefCount$RefCountSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableRefCount
extends j {
    public final a b;
    public final int c;
    public final long d;
    public final TimeUnit e;
    public final h0 f;
    public FlowableRefCount$RefConnection g;

    public FlowableRefCount(a a10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this(a10, 1, 0L, timeUnit, null);
    }

    public FlowableRefCount(a a10, int n10, long l10, TimeUnit timeUnit, h0 h02) {
        this.b = a10;
        this.c = n10;
        this.d = l10;
        this.e = timeUnit;
        this.f = h02;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void K8(FlowableRefCount$RefConnection object) {
        synchronized (this) {
            AtomicReference atomicReference = this.g;
            if (atomicReference != null && atomicReference == object) {
                long l10 = ((FlowableRefCount$RefConnection)object).subscriberCount;
                long l11 = 1L;
                ((FlowableRefCount$RefConnection)object).subscriberCount = l10 -= l11;
                l11 = 0L;
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 == false && (object2 = (Object)((FlowableRefCount$RefConnection)object).connected) != false) {
                    l10 = this.d;
                    long l13 = l10 - l11;
                    object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object2 == false) {
                        this.O8((FlowableRefCount$RefConnection)object);
                        return;
                    }
                    atomicReference = new SequentialDisposable();
                    ((FlowableRefCount$RefConnection)object).timer = atomicReference;
                    // MONITOREXIT @DISABLED, blocks:[4, 6, 7] lbl20 : MonitorExitStatement: MONITOREXIT : this
                    h0 h02 = this.f;
                    l11 = this.d;
                    TimeUnit timeUnit = this.e;
                    object = h02.f((Runnable)object, l11, timeUnit);
                    ((SequentialDisposable)atomicReference).replace((b)object);
                    return;
                }
                return;
            }
            return;
        }
    }

    public void L8(FlowableRefCount$RefConnection flowableRefCount$RefConnection) {
        b b10 = flowableRefCount$RefConnection.timer;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            flowableRefCount$RefConnection.timer = null;
        }
    }

    public void M8(FlowableRefCount$RefConnection object) {
        Object object2 = this.b;
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
    public void N8(FlowableRefCount$RefConnection flowableRefCount$RefConnection) {
        synchronized (this) {
            Object object = this.b;
            Object object2 = object instanceof s0;
            long l10 = 0L;
            long l11 = 1L;
            if (object2) {
                long l12;
                object = this.g;
                if (object != null && object == flowableRefCount$RefConnection) {
                    this.g = null;
                    this.L8(flowableRefCount$RefConnection);
                }
                flowableRefCount$RefConnection.subscriberCount = l12 = flowableRefCount$RefConnection.subscriberCount - l11;
                object2 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                if (!object2) {
                    this.M8(flowableRefCount$RefConnection);
                }
            } else {
                object = this.g;
                if (object != null && object == flowableRefCount$RefConnection) {
                    long l13;
                    this.L8(flowableRefCount$RefConnection);
                    flowableRefCount$RefConnection.subscriberCount = l13 = flowableRefCount$RefConnection.subscriberCount - l11;
                    object2 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
                    if (!object2) {
                        this.g = null;
                        this.M8(flowableRefCount$RefConnection);
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
    public void O8(FlowableRefCount$RefConnection flowableRefCount$RefConnection) {
        synchronized (this) {
            Object object;
            long l10 = flowableRefCount$RefConnection.subscriberCount;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false && flowableRefCount$RefConnection == (object = this.g)) {
                l12 = 0;
                object = null;
                this.g = null;
                object = flowableRefCount$RefConnection.get();
                object = (b)object;
                DisposableHelper.dispose(flowableRefCount$RefConnection);
                Object object2 = this.b;
                boolean bl2 = object2 instanceof b;
                if (bl2) {
                    object2 = (b)object2;
                    object2.dispose();
                } else {
                    bl2 = object2 instanceof c;
                    if (bl2) {
                        if (object == null) {
                            l12 = 1;
                            flowableRefCount$RefConnection.disconnectedEarly = l12;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m6(d object) {
        boolean bl2;
        FlowableRefCount$RefConnection flowableRefCount$RefConnection;
        synchronized (this) {
            long l10;
            long l11;
            long l12;
            b b10;
            long l13;
            long l14;
            long l15;
            long l16;
            flowableRefCount$RefConnection = this.g;
            if (flowableRefCount$RefConnection == null) {
                this.g = flowableRefCount$RefConnection = new FlowableRefCount$RefConnection(this);
            }
            if ((l16 = (l15 = (l14 = flowableRefCount$RefConnection.subscriberCount) - (l13 = 0L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false && (b10 = flowableRefCount$RefConnection.timer) != null) {
                b10.dispose();
            }
            l13 = 1L;
            flowableRefCount$RefConnection.subscriberCount = l14 += l13;
            l16 = (long)flowableRefCount$RefConnection.connected;
            bl2 = true;
            if (l16 == false && (l12 = (l11 = l14 - (l10 = (long)(l16 = (long)this.c))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
                flowableRefCount$RefConnection.connected = bl2;
            } else {
                bl2 = false;
            }
        }
        a a10 = this.b;
        FlowableRefCount$RefCountSubscriber flowableRefCount$RefCountSubscriber = new FlowableRefCount$RefCountSubscriber((d)object, this, flowableRefCount$RefConnection);
        a10.l6(flowableRefCount$RefCountSubscriber);
        if (bl2) {
            object = this.b;
            ((a)object).O8(flowableRefCount$RefConnection);
        }
    }
}

