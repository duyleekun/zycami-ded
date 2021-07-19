/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.p;
import d.n.a.q0.w.i;
import d.n.a.q0.w.j;
import java.util.concurrent.atomic.AtomicBoolean;

public class k
implements j,
i {
    private final AtomicBoolean a;

    public k() {
        AtomicBoolean atomicBoolean;
        this.a = atomicBoolean = new AtomicBoolean(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        synchronized (this) {
            AtomicBoolean atomicBoolean;
            boolean bl2;
            while (!(bl2 = (atomicBoolean = this.a).get())) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    Object object = this.a;
                    boolean bl3 = ((AtomicBoolean)object).get();
                    if (bl3) continue;
                    object = "Queue's awaitRelease() has been interrupted abruptly while it wasn't released by the release() method.";
                    Object[] objectArray = null;
                    objectArray = new Object[]{};
                    p.v(interruptedException, (String)object, objectArray);
                    continue;
                }
                break;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        synchronized (this) {
            AtomicBoolean atomicBoolean = this.a;
            boolean bl2 = true;
            boolean bl3 = atomicBoolean.compareAndSet(false, bl2);
            if (bl3) {
                this.notify();
            }
            return;
        }
    }
}

