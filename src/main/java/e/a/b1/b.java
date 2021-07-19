/*
 * Decompiled with CFR 0.151.
 */
package e.a.b1;

import e.a.b1.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.util.NotificationLite;

public final class b
extends a {
    public final a b;
    public boolean c;
    public e.a.w0.i.a d;
    public volatile boolean e;

    public b(a a10) {
        this.b = a10;
    }

    public Throwable K8() {
        return this.b.K8();
    }

    public boolean L8() {
        return this.b.L8();
    }

    public boolean M8() {
        return this.b.M8();
    }

    public boolean N8() {
        return this.b.N8();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void P8() {
        while (true) {
            a a10;
            e.a.w0.i.a a11;
            synchronized (this) {
                a11 = this.d;
                if (a11 == null) {
                    a11 = null;
                    this.c = false;
                    return;
                }
                a10 = null;
                this.d = null;
            }
            a10 = this.b;
            a11.b(a10);
        }
    }

    public void m6(d d10) {
        this.b.subscribe(d10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.e;
            if (bl2) {
                return;
            }
            this.e = bl2 = true;
            int n10 = this.c;
            if (n10 == 0) {
                this.c = bl2;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl13 : MonitorExitStatement: MONITOREXIT : this
                this.b.onComplete();
                return;
            }
            e.a.w0.i.a a10 = this.d;
            if (a10 == null) {
                n10 = 4;
                this.d = a10 = new e.a.w0.i.a(n10);
            }
            Object object = NotificationLite.complete();
            a10.c(object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onError(Throwable object) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        // MONITORENTER : this
        bl2 = this.e;
        int n10 = 1;
        if (!bl2) {
            this.e = n10;
            bl2 = this.c;
            if (bl2) {
                e.a.w0.i.a a10 = this.d;
                if (a10 == null) {
                    n10 = 4;
                    this.d = a10 = new e.a.w0.i.a(n10);
                }
                object = NotificationLite.error((Throwable)object);
                a10.f(object);
                // MONITOREXIT : this
                return;
            }
            bl2 = false;
            Object var4_5 = null;
            this.c = n10;
            n10 = 0;
        }
        // MONITOREXIT : this
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        this.b.onError((Throwable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.e;
            if (bl2) {
                return;
            }
            bl2 = this.c;
            if (!bl2) {
                this.c = bl2 = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl12 : MonitorExitStatement: MONITOREXIT : this
                this.b.onNext(object);
                this.P8();
                return;
            }
            e.a.w0.i.a a10 = this.d;
            if (a10 == null) {
                int n10 = 4;
                this.d = a10 = new e.a.w0.i.a(n10);
            }
            object = NotificationLite.next(object);
            a10.c(object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSubscribe(e object) {
        a a10;
        boolean bl2 = this.e;
        int n10 = 1;
        if (!bl2) {
            synchronized (this) {
                bl2 = this.e;
                if (!bl2) {
                    bl2 = this.c;
                    if (bl2) {
                        e.a.w0.i.a a11 = this.d;
                        if (a11 == null) {
                            n10 = 4;
                            this.d = a11 = new e.a.w0.i.a(n10);
                        }
                        object = NotificationLite.subscription((e)object);
                        a11.c(object);
                        return;
                    }
                    this.c = n10;
                    bl2 = false;
                    a10 = null;
                    n10 = 0;
                }
            }
        }
        if (n10 != 0) {
            object.cancel();
            return;
        }
        a10 = this.b;
        a10.onSubscribe((e)object);
        this.P8();
    }
}

