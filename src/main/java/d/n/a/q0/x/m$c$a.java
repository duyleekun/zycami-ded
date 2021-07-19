/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import com.polidea.rxandroidble2.RxBleClient$State;
import d.n.a.q0.x.m$c;
import e.a.v0.o;

public class m$c$a
implements o {
    public final /* synthetic */ m.c a;

    public m$c$a(m.c c10) {
        this.a = c10;
    }

    public RxBleClient$State a(Boolean object) {
        boolean bl2 = object;
        object = bl2 ? RxBleClient$State.READY : RxBleClient$State.LOCATION_SERVICES_NOT_ENABLED;
        return object;
    }
}

