/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import d.v.a0.f0;
import d.v.a0.g0;
import d.v.a0.h0;
import d.v.a0.h1;
import d.v.a0.i1;
import d.v.a0.i1$f;
import d.v.a0.n1.c;
import d.v.a0.n1.e;
import d.v.k0.g.d;
import d.v.z.l.f;
import d.v.z.l.i;
import d.v.z.n.h;

public class i1$a
implements e {
    public final /* synthetic */ i1 a;

    public i1$a(i1 i12) {
        this.a = i12;
    }

    private /* synthetic */ void f(h1 h12) {
        c c10 = i1.B(this.a);
        f f10 = (f)((d.v.z.n.d)h12.b()).getData();
        c10.a(h12, f10);
    }

    private /* synthetic */ void h(h1 h12, i i10) {
        i1.C(this.a).a(h12, i10);
    }

    private /* synthetic */ void j(h1 h12, i i10) {
        i1.C(this.a).b(h12, i10);
    }

    public void a(h1 object) {
        Object object2 = this.a;
        String string2 = ((h1)object).a();
        boolean bl2 = ((i1)object2).a(string2);
        if (!bl2) {
            return;
        }
        object2 = i1.B(this.a);
        if (object2 != null) {
            object2 = new g0(this, (h1)object);
            object = i1.B(this.a);
            d.j((Runnable)object2, object);
        }
    }

    public void b(h1 h12) {
    }

    public void c(h1 object) {
        block2: {
            Object object2;
            block5: {
                Object object3;
                block6: {
                    block3: {
                        block4: {
                            object2 = this.a;
                            object3 = ((h1)object).a();
                            boolean bl2 = ((i1)object2).a((String)object3);
                            if (!bl2) {
                                return;
                            }
                            object2 = i1.C(this.a);
                            if (object2 == null) break block2;
                            object2 = (i)((h)((h1)object).b()).getData();
                            object3 = i1$f.a;
                            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction = ((i)object2).D();
                            int n10 = zYEnumDefine$EventTypeAction.ordinal();
                            Object object4 = object3[n10];
                            if (object4 == (n10 = 1)) break block3;
                            n10 = 2;
                            if (object4 == n10) break block4;
                            object = null;
                            break block5;
                        }
                        object3 = new f0(this, (h1)object, (i)object2);
                        break block6;
                    }
                    object3 = new h0(this, (h1)object, (i)object2);
                }
                object = object3;
            }
            if (object != null) {
                object2 = i1.C(this.a);
                d.j((Runnable)object, object2);
            }
        }
    }

    public void d(h1 h12) {
    }

    public void e(h1 h12) {
        i1.D(this.a, h12, true);
    }

    public /* synthetic */ void g(h1 h12) {
        this.f(h12);
    }

    public /* synthetic */ void i(h1 h12, i i10) {
        this.h(h12, i10);
    }

    public /* synthetic */ void k(h1 h12, i i10) {
        this.j(h12, i10);
    }
}

