/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.s0;

import d.n.a.s0.a$a;
import e.a.e0;
import e.a.f0;
import e.a.z;
import java.util.concurrent.atomic.AtomicReference;

public class a
implements f0 {
    public final AtomicReference a;

    public a() {
        AtomicReference atomicReference;
        this.a = atomicReference = new AtomicReference();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public e0 a(z z10) {
        AtomicReference atomicReference = this.a;
        synchronized (atomicReference) {
            Object object = this.a;
            object = ((AtomicReference)object).get();
            object = (z)object;
            if (object != null) {
                return object;
            }
            object = new a$a(this);
            z10 = z10.X1((e.a.v0.a)object);
            int n10 = 1;
            z10 = z10.M4(n10);
            z10 = ((e.a.x0.a)z10).n8();
            object = this.a;
            ((AtomicReference)object).set(z10);
            return z10;
        }
    }
}

