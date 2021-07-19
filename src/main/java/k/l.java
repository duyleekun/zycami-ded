/*
 * Decompiled with CFR 0.151.
 */
package k;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.c0;
import g.c0$a;
import g.d0;
import g.e;
import g.e$a;
import g.v;
import h.o0;
import java.io.IOException;
import java.util.Objects;
import k.d;
import k.f;
import k.h;
import k.l$a;
import k.l$b;
import k.l$c;
import k.q;
import k.r;
import k.w;

public final class l
implements d {
    private final q a;
    private final Object[] b;
    private final e$a c;
    private final h d;
    private volatile boolean e;
    private e f;
    private Throwable g;
    private boolean h;

    public l(q q10, Object[] objectArray, e$a e$a, h h10) {
        this.a = q10;
        this.b = objectArray;
        this.c = e$a;
        this.d = h10;
    }

    private e b() {
        Object object = this.c;
        Object object2 = this.a;
        Object[] objectArray = this.b;
        object2 = ((q)object2).a(objectArray);
        object = object.a((a0)object2);
        Objects.requireNonNull(object, "Call.Factory returned null.");
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private e c() {
        void var1_5;
        Object object = this.f;
        if (object != null) {
            return object;
        }
        object = this.g;
        if (object != null) {
            boolean bl2 = object instanceof IOException;
            if (!bl2) {
                bl2 = object instanceof RuntimeException;
                if (bl2) {
                    throw (RuntimeException)object;
                }
                throw (Error)object;
            }
            throw (IOException)object;
        }
        object = this.b();
        try {
            this.f = object;
            return object;
        }
        catch (IOException iOException) {
        }
        catch (Error error) {
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        w.s((Throwable)var1_5);
        this.g = var1_5;
        throw var1_5;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public a0 C() {
        synchronized (this) {
            Throwable throwable22222;
            e e10 = this.c();
            return e10.C();
            {
                catch (Throwable throwable22222) {
                }
                catch (IOException iOException) {}
                {
                    String string2 = "Unable to create request.";
                    RuntimeException runtimeException = new RuntimeException(string2, iOException);
                    throw runtimeException;
                }
            }
            throw throwable22222;
        }
    }

    public boolean D() {
        synchronized (this) {
            boolean bl2 = this.h;
            return bl2;
        }
    }

    public l a() {
        q q10 = this.a;
        Object[] objectArray = this.b;
        e$a e$a = this.c;
        h h10 = this.d;
        l l10 = new l(q10, objectArray, e$a, h10);
        return l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void cancel() {
        boolean bl2;
        this.e = bl2 = true;
        // MONITORENTER : this
        e e10 = this.f;
        // MONITOREXIT : this
        if (e10 == null) return;
        e10.cancel();
    }

    public r d(c0 object) {
        int n10;
        long l10;
        Object object2 = ((c0)object).r0();
        object = ((c0)object).G0();
        v v10 = ((d0)object2).contentType();
        d0 d02 = new l$c(v10, l10 = ((d0)object2).contentLength());
        int n11 = ((c0)(object = ((c0$a)object).b(d02).c())).v0();
        if (n11 >= (n10 = 200) && n11 < (n10 = 300)) {
            n10 = 204;
            if (n11 != n10 && n11 != (n10 = 205)) {
                d02 = new l$b((d0)object2);
                try {
                    object2 = this.d;
                }
                catch (RuntimeException runtimeException) {
                    ((l$b)d02).a();
                    throw runtimeException;
                }
                object2 = object2.convert(d02);
                return r.m(object2, (c0)object);
            }
            ((d0)object2).close();
            return r.m(null, (c0)object);
        }
        try {
            d02 = w.a((d0)object2);
            object = r.d(d02, (c0)object);
            return object;
        }
        finally {
            ((d0)object2).close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public r execute() {
        Object object;
        synchronized (this) {
            boolean bl2 = this.h;
            if (bl2) {
                String string2 = "Already executed.";
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            this.h = bl2 = true;
            object = this.c();
        }
        boolean bl3 = this.e;
        if (bl3) {
            object.cancel();
        }
        object = FirebasePerfOkHttpClient.execute((e)object);
        return this.d((c0)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void h(f object) {
        Object object2 = "callback == null";
        Objects.requireNonNull(object, (String)object2);
        // MONITORENTER : this
        boolean bl2 = this.h;
        if (bl2) {
            object2 = "Already executed.";
            object = new IllegalStateException((String)object2);
            throw object;
        }
        this.h = bl2 = true;
        object2 = this.f;
        Object object3 = this.g;
        if (object2 == null && object3 == null) {
            try {
                e e10;
                this.f = e10 = this.b();
                object2 = e10;
            }
            catch (Throwable throwable) {
                w.s(throwable);
                this.g = throwable;
            }
        }
        // MONITOREXIT : this
        if (object3 != null) {
            object.onFailure(this, (Throwable)object3);
            return;
        }
        boolean bl3 = this.e;
        if (bl3) {
            object2.cancel();
        }
        object3 = new l$a(this, (f)object);
        FirebasePerfOkHttpClient.enqueue((e)object2, (g.f)object3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCanceled() {
        boolean bl2 = this.e;
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        synchronized (this) {
            e e10 = this.f;
            if (e10 == null) return false;
            bl2 = e10.isCanceled();
            if (!bl2) return false;
            return bl3;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public o0 timeout() {
        synchronized (this) {
            Throwable throwable22222;
            e e10 = this.c();
            return e10.timeout();
            {
                catch (Throwable throwable22222) {
                }
                catch (IOException iOException) {}
                {
                    String string2 = "Unable to create call.";
                    RuntimeException runtimeException = new RuntimeException(string2, iOException);
                    throw runtimeException;
                }
            }
            throw throwable22222;
        }
    }
}

