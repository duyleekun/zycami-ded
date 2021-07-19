/*
 * Decompiled with CFR 0.151.
 */
package e.a.y0;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;

public final class l
implements g0,
b {
    public static final int g = 4;
    public final g0 a;
    public final boolean b;
    public b c;
    public boolean d;
    public e.a.w0.i.a e;
    public volatile boolean f;

    public l(g0 g02) {
        this(g02, false);
    }

    public l(g0 g02, boolean bl2) {
        this.a = g02;
        this.b = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        g0 g02;
        e.a.w0.i.a a10;
        boolean bl2;
        do {
            synchronized (this) {
                a10 = this.e;
                if (a10 == null) {
                    bl2 = false;
                    a10 = null;
                    this.d = false;
                    return;
                }
                g02 = null;
                this.e = null;
            }
        } while (!(bl2 = a10.a(g02 = this.a)));
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        synchronized (this) {
            bl2 = this.f;
            if (bl2) {
                return;
            }
            bl2 = this.d;
            if (!bl2) {
                this.f = bl2 = true;
                this.d = bl2;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl13 : MonitorExitStatement: MONITOREXIT : this
                this.a.onComplete();
                return;
            }
            e.a.w0.i.a a10 = this.e;
            if (a10 == null) {
                int n10 = 4;
                this.e = a10 = new e.a.w0.i.a(n10);
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
        boolean bl2 = this.f;
        if (bl2) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        // MONITORENTER : this
        bl2 = this.f;
        int n10 = 1;
        if (!bl2) {
            bl2 = this.d;
            if (bl2) {
                this.f = n10;
                e.a.w0.i.a a10 = this.e;
                if (a10 == null) {
                    n10 = 4;
                    this.e = a10 = new e.a.w0.i.a(n10);
                }
                object = NotificationLite.error((Throwable)object);
                n10 = (int)(this.b ? 1 : 0);
                if (n10 != 0) {
                    a10.c(object);
                    return;
                }
                a10.f(object);
                // MONITOREXIT : this
                return;
            }
            this.f = n10;
            this.d = n10;
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
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        if (object == null) {
            this.c.dispose();
            object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            this.onError((Throwable)object);
            return;
        }
        synchronized (this) {
            bl2 = this.f;
            if (bl2) {
                return;
            }
            bl2 = this.d;
            if (!bl2) {
                this.d = bl2 = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl17 : MonitorExitStatement: MONITOREXIT : this
                this.a.onNext(object);
                this.a();
                return;
            }
            e.a.w0.i.a a10 = this.e;
            if (a10 == null) {
                int n10 = 4;
                this.e = a10 = new e.a.w0.i.a(n10);
            }
            object = NotificationLite.next(object);
            a10.c(object);
            return;
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

