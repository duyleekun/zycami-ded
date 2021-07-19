/*
 * Decompiled with CFR 0.151.
 */
package e.a.d1;

import e.a.a1.a;
import e.a.d1.c;
import e.a.g0;
import e.a.w0.i.a$a;
import io.reactivex.internal.util.NotificationLite;

public final class b
extends c
implements a$a {
    public final c a;
    public boolean b;
    public e.a.w0.i.a c;
    public volatile boolean d;

    public b(c c10) {
        this.a = c10;
    }

    public void K5(g0 g02) {
        this.a.subscribe(g02);
    }

    public Throwable h8() {
        return this.a.h8();
    }

    public boolean i8() {
        return this.a.i8();
    }

    public boolean j8() {
        return this.a.j8();
    }

    public boolean k8() {
        return this.a.k8();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m8() {
        while (true) {
            e.a.w0.i.a a10;
            synchronized (this) {
                a10 = this.c;
                if (a10 == null) {
                    a10 = null;
                    this.b = false;
                    return;
                }
                this.c = null;
            }
            a10.d(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.d;
            if (bl2) {
                return;
            }
            this.d = bl2 = true;
            int n10 = this.b;
            if (n10 == 0) {
                this.b = bl2;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl13 : MonitorExitStatement: MONITOREXIT : this
                this.a.onComplete();
                return;
            }
            e.a.w0.i.a a10 = this.c;
            if (a10 == null) {
                n10 = 4;
                this.c = a10 = new e.a.w0.i.a(n10);
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
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        // MONITORENTER : this
        bl2 = this.d;
        int n10 = 1;
        if (!bl2) {
            this.d = n10;
            bl2 = this.b;
            if (bl2) {
                e.a.w0.i.a a10 = this.c;
                if (a10 == null) {
                    n10 = 4;
                    this.c = a10 = new e.a.w0.i.a(n10);
                }
                object = NotificationLite.error((Throwable)object);
                a10.f(object);
                // MONITOREXIT : this
                return;
            }
            bl2 = false;
            Object var4_5 = null;
            this.b = n10;
            n10 = 0;
        }
        // MONITOREXIT : this
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        this.a.onError((Throwable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.d;
            if (bl2) {
                return;
            }
            bl2 = this.b;
            if (!bl2) {
                this.b = bl2 = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl12 : MonitorExitStatement: MONITOREXIT : this
                this.a.onNext(object);
                this.m8();
                return;
            }
            e.a.w0.i.a a10 = this.c;
            if (a10 == null) {
                int n10 = 4;
                this.c = a10 = new e.a.w0.i.a(n10);
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
    public void onSubscribe(e.a.s0.b object) {
        c c10;
        boolean bl2 = this.d;
        int n10 = 1;
        if (!bl2) {
            synchronized (this) {
                bl2 = this.d;
                if (!bl2) {
                    bl2 = this.b;
                    if (bl2) {
                        e.a.w0.i.a a10 = this.c;
                        if (a10 == null) {
                            n10 = 4;
                            this.c = a10 = new e.a.w0.i.a(n10);
                        }
                        object = NotificationLite.disposable((e.a.s0.b)object);
                        a10.c(object);
                        return;
                    }
                    this.b = n10;
                    bl2 = false;
                    c10 = null;
                    n10 = 0;
                }
            }
        }
        if (n10 != 0) {
            object.dispose();
            return;
        }
        c10 = this.a;
        c10.onSubscribe((e.a.s0.b)object);
        this.m8();
    }

    public boolean test(Object object) {
        c c10 = this.a;
        return NotificationLite.acceptFull(object, c10);
    }
}

