/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.b2.v.b;
import d.v.c.i1.i2;
import d.v.c.x0.b.o;
import d.v.c.x0.b.p;
import d.v.c.x0.b.q;
import d.v.c.x0.b.s;
import d.v.h.d.c;
import d.v.h.e.e;

public class p$a
implements e {
    public final /* synthetic */ p a;

    public p$a(p p10) {
        this.a = p10;
    }

    public void a() {
        p.z(this.a).dismiss();
    }

    public void b() {
        Object object = p.y(this.a);
        Object object2 = p.x(this.a).W0();
        ((q)object).r((c)object2);
        p.z(this.a).dismiss();
        object = p.A(this.a);
        object2 = DecorationType.IMAGE_PASTER;
        boolean bl2 = true;
        ((i2)object).F3((DecorationType)((Object)object2), bl2, false);
        object = p.y(this.a);
        int n10 = ((b)object).e();
        int n11 = -1;
        if (n10 != n11) {
            object2 = p.y(this.a);
            object = ((q)object2).t(n10);
            if (object == null) {
                return;
            }
            object2 = p.B(this.a);
            ((s)object2).k((o)object);
        }
    }
}

