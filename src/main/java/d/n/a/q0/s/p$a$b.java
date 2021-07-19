/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import d.n.a.q0.s.n;
import d.n.a.q0.s.p$a;
import e.a.s0.b;
import e.a.v0.g;
import java.util.Set;

public class p$a$b
implements g {
    public final /* synthetic */ Set a;
    public final /* synthetic */ p$a b;

    public p$a$b(p$a p$a, Set set) {
        this.b = p$a;
        this.a = set;
    }

    public void a(b object) {
        boolean bl2;
        object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            n n10 = (n)object.next();
            n10.c();
        }
    }
}

