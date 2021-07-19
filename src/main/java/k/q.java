/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.a0;
import g.a0$a;
import g.t;
import g.v;
import java.lang.reflect.Method;
import java.util.ArrayList;
import k.k;
import k.n;
import k.p;
import k.q$a;
import k.s;

public final class q {
    private final Method a;
    private final t b;
    public final String c;
    private final String d;
    private final g.s e;
    private final v f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final n[] j;
    public final boolean k;

    public q(q$a q$a) {
        boolean bl2;
        boolean bl3;
        n[] nArray = q$a.b;
        this.a = nArray;
        nArray = q$a.a.c;
        this.b = nArray;
        nArray = q$a.n;
        this.c = nArray;
        nArray = q$a.r;
        this.d = nArray;
        nArray = q$a.s;
        this.e = nArray;
        nArray = q$a.t;
        this.f = nArray;
        this.g = bl3 = q$a.o;
        this.h = bl3 = q$a.p;
        this.i = bl3 = q$a.q;
        nArray = q$a.v;
        this.j = nArray;
        this.k = bl2 = q$a.w;
    }

    public static q b(s s10, Method method) {
        q$a q$a = new q$a(s10, method);
        return q$a.b();
    }

    public a0 a(Object[] object) {
        int n10 = ((Object[])object).length;
        Object object2 = this.j;
        int n11 = ((n[])object2).length;
        if (n10 == n11) {
            Object object3;
            String string2 = this.c;
            Object object4 = this.b;
            Object object5 = this.d;
            g.s s10 = this.e;
            v v10 = this.f;
            boolean bl2 = this.g;
            boolean bl3 = this.h;
            boolean bl4 = this.i;
            ArrayList<Object> arrayList = object3;
            object3 = new p(string2, (t)object4, (String)object5, s10, v10, bl2, bl3, bl4);
            boolean bl5 = this.k;
            if (bl5) {
                n10 += -1;
            }
            arrayList = new ArrayList<Object>(n10);
            string2 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                object4 = object[i10];
                arrayList.add(object4);
                object4 = object2[i10];
                object5 = object[i10];
                ((n)object4).a((p)object3, object5);
            }
            object = ((p)object3).k();
            object3 = this.a;
            k k10 = new k((Method)object3, arrayList);
            return ((a0$a)object).z(k.class, k10).b();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Argument count (");
        stringBuilder.append(n10);
        stringBuilder.append(") doesn't match expected count (");
        int n12 = ((n[])object2).length;
        stringBuilder.append(n12);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }
}

