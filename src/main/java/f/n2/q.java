/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.b2.c;
import f.h2.s.p;
import f.h2.t.f0;
import f.n2.m;
import f.n2.n;
import f.n2.q$a;
import f.n2.q$b;
import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

public class q {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;

    public static /* synthetic */ void a() {
    }

    private static final Iterator b(p p10) {
        return q.d(p10);
    }

    private static final m c(p p10) {
        q$a q$a = new q$a(p10);
        return q$a;
    }

    public static final Iterator d(p object) {
        f0.p(object, "block");
        n n10 = new n();
        object = IntrinsicsKt__IntrinsicsJvmKt.c((p)object, n10, n10);
        n10.j((c)object);
        return n10;
    }

    public static final m e(p p10) {
        f0.p(p10, "block");
        q$b q$b = new q$b(p10);
        return q$b;
    }
}

