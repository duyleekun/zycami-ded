/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.p0;

import d.n.a.p0.b;
import e.a.i;
import e.a.v0.g;
import java.nio.Buffer;

public class b$a
implements g {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    public void a(i i10) {
        Object object = this.a.b;
        int n10 = ((Buffer)object).remaining();
        b b10 = this.a;
        int n11 = b10.c;
        if ((n10 = Math.min(n10, n11)) == 0) {
            i10.onComplete();
            return;
        }
        object = new byte[n10];
        this.a.b.get((byte[])object);
        i10.onNext(object);
    }
}

