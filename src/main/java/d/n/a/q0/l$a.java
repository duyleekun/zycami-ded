/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0;

import com.polidea.rxandroidble2.exceptions.BleAlreadyConnectedException;
import d.n.a.q0.l;
import d.n.a.q0.l$a$a;
import d.n.a.z;
import e.a.e0;
import e.a.v0.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class l$a
implements Callable {
    public final /* synthetic */ z a;
    public final /* synthetic */ l b;

    public l$a(l l10, z z10) {
        this.b = l10;
        this.a = z10;
    }

    public e0 a() {
        Object object = this.b.d;
        Object object2 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.b.b;
            object2 = this.a;
            object = object.a((z)object2);
            object2 = new l$a$a(this);
            return ((e.a.z)object).X1((a)object2);
        }
        object2 = this.b.a.getAddress();
        object = new BleAlreadyConnectedException((String)object2);
        return e.a.z.m2((Throwable)object);
    }
}

