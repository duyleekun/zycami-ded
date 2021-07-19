/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import d.n.a.g0;
import e.a.v0.a;
import java.util.Map;
import java.util.Set;

public class g0$g
implements a {
    public final /* synthetic */ Set a;
    public final /* synthetic */ g0 b;

    public g0$g(g0 g02, Set set) {
        this.b = g02;
        this.a = set;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Map map = this.b.i;
        synchronized (map) {
            Object object = this.b;
            object = ((g0)object).i;
            Set set = this.a;
            object.remove(set);
            return;
        }
    }
}

