/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.q0.p;
import d.n.a.q0.s.n;
import d.n.a.q0.s.y;
import d.n.a.q0.t.b;
import d.n.a.q0.w.d;
import d.n.a.q0.w.e$a;
import d.n.a.q0.w.e$b;
import d.n.a.q0.w.e$c;
import d.n.a.q0.w.g;
import d.n.a.q0.w.h;
import e.a.h0;
import e.a.z;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class e
implements d,
n {
    private final String a;
    private final y b;
    private e.a.y0.d c;
    public final h d;
    private final Future e;
    public volatile boolean f;
    private BleException g;

    public e(String object, y object2, ExecutorService executorService, h0 h02) {
        h h10;
        this.d = h10 = new h();
        this.f = true;
        this.g = null;
        this.a = object;
        this.b = object2;
        object2 = new e$a(this, h02, (String)object);
        this.e = object = executorService.submit((Runnable)object2);
    }

    public void a(BleException object) {
        synchronized (this) {
            Object object2;
            block11: {
                object2 = this.g;
                if (object2 == null) break block11;
                return;
            }
            object2 = "Connection operations queue to be terminated (%s)";
            boolean bl2 = true;
            Object[] objectArray = new Object[bl2];
            String string2 = this.a;
            string2 = d.n.a.q0.t.b.d(string2);
            objectArray[0] = string2;
            p.c((Throwable)object, (String)object2, objectArray);
            this.f = false;
            this.g = object;
            object = this.e;
            object.cancel(bl2);
            return;
        }
    }

    public void b() {
        this.c.dispose();
        this.c = null;
        String string2 = this.a;
        BleDisconnectedException bleDisconnectedException = new BleDisconnectedException(string2, -1);
        this.a(bleDisconnectedException);
    }

    public void c() {
        Object object = this.b.d();
        e$c e$c = new e$c(this);
        this.c = object = (e.a.y0.d)((z)object).i(e$c);
    }

    public z d(d.n.a.q0.u.p object) {
        synchronized (this) {
            boolean bl2 = this.f;
            if (!bl2) {
                object = this.g;
                object = z.m2((Throwable)object);
                return object;
            }
            e$b e$b = new e$b(this, (d.n.a.q0.u.p)object);
            object = z.y1(e$b);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        synchronized (this) {
            Object object;
            boolean bl2;
            while (!(bl2 = ((h)(object = this.d)).b())) {
                object = this.d;
                object = ((h)object).e();
                object = ((g)object).c;
                BleException bleException = this.g;
                object.tryOnError(bleException);
            }
            return;
        }
    }
}

