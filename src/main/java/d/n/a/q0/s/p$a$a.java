/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import d.n.a.q0.s.n;
import d.n.a.q0.s.p$a;
import e.a.v0.a;
import java.util.Iterator;
import java.util.Set;

public class p$a$a
implements a {
    public final /* synthetic */ Set a;
    public final /* synthetic */ p$a b;

    public p$a$a(p$a p$a, Set set) {
        this.b = p$a;
        this.a = set;
    }

    public void run() {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            n n10 = (n)iterator2.next();
            n10.b();
        }
    }
}

