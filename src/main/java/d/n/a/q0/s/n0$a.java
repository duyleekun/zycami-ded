/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.n.a.o0.a;
import d.n.a.q0.s.n0;
import e.a.v0.r;

public class n0$a
implements r {
    public final /* synthetic */ n0 a;

    public n0$a(n0 n02) {
        this.a = n02;
    }

    public boolean a(Throwable object) {
        boolean bl2;
        a a10;
        boolean bl3 = object instanceof BleGattException;
        if (bl3 && (object = ((BleGattException)object).getBleGattOperationType()) == (a10 = d.n.a.o0.a.l)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

