/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.e;

import com.zhiyun.protocol.constants.Model;
import d.v.e0.ce;
import d.v.g.b;
import d.v.g.e.q$a;
import d.v.g.e.q$b;
import d.v.g.e.q$c;

public final class q {
    private Model[] a;

    private q() {
        Model[] modelArray = q.a();
        this.a = modelArray;
    }

    public /* synthetic */ q(q$a q$a) {
        this();
    }

    private static Model[] a() {
        Model[] modelArray = b.a();
        int n10 = modelArray.d();
        if (n10 != 0) {
            modelArray = Model.values();
        } else {
            Model model;
            n10 = 5;
            modelArray = new Model[n10];
            modelArray[0] = model = Model.SMOOTHX;
            modelArray[1] = model = Model.SMOOTHXS;
            modelArray[2] = model = Model.SMOOTHQ3;
            modelArray[3] = model;
            int n11 = 4;
            modelArray[n11] = model = Model.SMOOTHXS_HI;
        }
        return modelArray;
    }

    public static q b() {
        return q$c.a;
    }

    public void c(long l10, q$b q$b) {
        ce ce2 = ce.E0();
        Model[] modelArray = this.a;
        ce2.q7(q$b, l10, false, modelArray);
    }

    public void d() {
        ce.E0().C7();
    }
}

