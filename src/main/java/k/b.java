/*
 * Decompiled with CFR 0.151.
 */
package k;

import k.f;
import k.i$b$a;
import k.r;

public final class b
implements Runnable {
    public final /* synthetic */ i$b$a a;
    public final /* synthetic */ f b;
    public final /* synthetic */ r c;

    public /* synthetic */ b(i$b$a i$b$a, f f10, r r10) {
        this.a = i$b$a;
        this.b = f10;
        this.c = r10;
    }

    public final void run() {
        i$b$a i$b$a = this.a;
        f f10 = this.b;
        r r10 = this.c;
        i$b$a.d(f10, r10);
    }
}

