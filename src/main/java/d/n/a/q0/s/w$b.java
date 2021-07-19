/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.q0.p;
import d.n.a.q0.s.w;
import e.a.v0.g;

public class w$b
implements g {
    public final /* synthetic */ w a;

    public w$b(w w10) {
        this.a = w10;
    }

    public void a(BleException objectArray) {
        objectArray = new Object[]{};
        p.s("An exception received, indicating that the adapter has became unusable.", objectArray);
    }
}

