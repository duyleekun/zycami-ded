/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.q0.s.w;
import e.a.v0.o;

public class w$c
implements o {
    public final /* synthetic */ String a;
    public final /* synthetic */ w b;

    public w$c(w w10, String string2) {
        this.b = w10;
        this.a = string2;
    }

    public BleException a(Boolean bl2) {
        return BleDisconnectedException.adapterDisabled(this.a);
    }
}

