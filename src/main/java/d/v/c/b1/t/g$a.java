/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1.t;

import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import com.zhiyun.editorsdk.template.TemplateUseCase;
import d.v.c.b1.t.g;
import d.v.h.e.b;

public class g$a
implements b {
    public final /* synthetic */ g a;

    public g$a(g g10) {
        this.a = g10;
    }

    public void m(boolean bl2) {
        if (bl2) {
            Object object = this.a;
            Object object2 = new WithdrawTemplateUseCase();
            g.l4((g)object, (WithdrawTemplateUseCase)object2);
            object = g.k4(this.a);
            object2 = g.m4(this.a);
            ((TemplateUseCase)object).h((MainUseCase)object2);
        }
    }
}

