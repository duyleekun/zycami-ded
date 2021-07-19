/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package d.c.a.s;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import d.c.a.s.c;
import d.c.a.s.d;
import d.c.a.s.e$a;
import d.c.a.s.f;
import d.c.a.s.j.o;
import d.c.a.s.j.p;
import d.c.a.u.m;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class e
implements c,
f {
    private static final e$a k;
    private final int a;
    private final int b;
    private final boolean c;
    private final e$a d;
    private Object e;
    private d f;
    private boolean g;
    private boolean h;
    private boolean i;
    private GlideException j;

    static {
        e$a e$a;
        k = e$a = new e$a();
    }

    public e(int n10, int n11) {
        e$a e$a = k;
        this(n10, n11, true, e$a);
    }

    public e(int n10, int n11, boolean bl2, e$a e$a) {
        this.a = n10;
        this.b = n11;
        this.c = bl2;
        this.d = e$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object d(Long object) {
        synchronized (this) {
            int n10;
            boolean bl2;
            boolean bl3;
            boolean bl4 = this.c;
            if (bl4 && !(bl3 = this.isDone())) {
                m.a();
            }
            if (bl2 = this.g) {
                object = new CancellationException();
                throw object;
            }
            boolean bl5 = this.i;
            if (bl5) {
                GlideException glideException = this.j;
                object = new ExecutionException(glideException);
                throw object;
            }
            boolean bl6 = this.h;
            if (bl6) {
                return this.e;
            }
            long l10 = 0L;
            if (object == null) {
                object = this.d;
                ((e$a)object).b(this, l10);
            } else {
                long l11 = (Long)object;
                long l12 = l11 - l10;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 > 0) {
                    l10 = System.currentTimeMillis();
                    l11 = (Long)object + l10;
                    while ((n10 = this.isDone()) == 0 && (n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) < 0) {
                        object = this.d;
                        l10 = l11 - l10;
                        ((e$a)object).b(this, l10);
                        l10 = System.currentTimeMillis();
                    }
                }
            }
            n10 = Thread.interrupted();
            if (n10 != 0) {
                object = new InterruptedException();
                throw object;
            }
            n10 = this.i;
            if (n10 != 0) {
                GlideException glideException = this.j;
                object = new ExecutionException(glideException);
                throw object;
            }
            n10 = this.g;
            if (n10 != 0) {
                object = new CancellationException();
                throw object;
            }
            n10 = this.h;
            if (n10 != 0) {
                return this.e;
            }
            object = new TimeoutException();
            throw object;
        }
    }

    public void a(o o10) {
    }

    public boolean b(GlideException object, Object object2, p p10, boolean bl2) {
        synchronized (this) {
            boolean bl3 = true;
            this.i = bl3;
            this.j = object;
            object = this.d;
            ((e$a)object).a(this);
            return false;
        }
    }

    public boolean c(Object object, Object object2, p p10, DataSource dataSource, boolean bl2) {
        synchronized (this) {
            boolean bl3 = true;
            this.h = bl3;
            this.e = object;
            object = this.d;
            ((e$a)object).a(this);
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean cancel(boolean bl2) {
        // MONITORENTER : this
        boolean bl3 = this.isDone();
        if (bl3) {
            bl2 = false;
            Object var3_3 = null;
            // MONITOREXIT : this
            return false;
        }
        this.g = bl3 = true;
        Object object = this.d;
        ((e$a)object).a(this);
        object = null;
        if (bl2) {
            d d10 = this.f;
            this.f = null;
            object = d10;
        }
        // MONITOREXIT : this
        if (object == null) return bl3;
        object.clear();
        return bl3;
    }

    public void g(Drawable drawable2) {
    }

    public Object get() {
        Object var1_1 = null;
        try {
            return this.d(null);
        }
        catch (TimeoutException timeoutException) {
            AssertionError assertionError = new AssertionError((Object)timeoutException);
            throw assertionError;
        }
    }

    public Object get(long l10, TimeUnit timeUnit) {
        Long l11 = timeUnit.toMillis(l10);
        return this.d(l11);
    }

    public d h() {
        synchronized (this) {
            d d10 = this.f;
            return d10;
        }
    }

    public void i(Drawable drawable2) {
    }

    public boolean isCancelled() {
        synchronized (this) {
            boolean bl2 = this.g;
            return bl2;
        }
    }

    public boolean isDone() {
        synchronized (this) {
            boolean bl2;
            block6: {
                block5: {
                    bl2 = this.g;
                    if (bl2) break block5;
                    bl2 = this.h;
                    if (bl2) break block5;
                    bl2 = this.i;
                    if (bl2) break block5;
                    bl2 = false;
                    Object var2_2 = null;
                    break block6;
                }
                bl2 = true;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void j(Object object, d.c.a.s.k.f f10) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public void l(d d10) {
        synchronized (this) {
            this.f = d10;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void m(Drawable drawable2) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void p(o o10) {
        int n10 = this.a;
        int n11 = this.b;
        o10.d(n10, n11);
    }
}

