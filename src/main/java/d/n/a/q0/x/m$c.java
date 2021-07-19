/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import com.polidea.rxandroidble2.RxBleClient$State;
import d.n.a.e0$b;
import d.n.a.q0.x.m$c$a;
import e.a.v0.o;
import e.a.z;

public final class m$c
implements o {
    public final /* synthetic */ z a;

    public m$c(z z10) {
        this.a = z10;
    }

    public z a(e0$b object) {
        Object object2 = e0$b.c;
        if (object != object2) {
            return z.t3((Object)RxBleClient$State.BLUETOOTH_NOT_ENABLED);
        }
        object = this.a;
        object2 = new m$c$a(this);
        return ((z)object).H3((o)object2);
    }
}

