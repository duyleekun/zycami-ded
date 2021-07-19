/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import d.v.j.e.g.a0;
import java.util.function.Consumer;

public final class s
implements Consumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ a0 b;
    public final /* synthetic */ a0 c;

    public /* synthetic */ s(WithdrawTemplateUseCase withdrawTemplateUseCase, a0 a02, a0 a03) {
        this.a = withdrawTemplateUseCase;
        this.b = a02;
        this.c = a03;
    }

    public final void accept(Object object) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        a0 a02 = this.b;
        a0 a03 = this.c;
        object = (Integer)object;
        withdrawTemplateUseCase.p1(a02, a03, (Integer)object);
    }
}

