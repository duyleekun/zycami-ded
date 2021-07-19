/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import d.v.j.e.g.a0;
import java.util.function.IntConsumer;

public final class j0
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ a0 b;

    public /* synthetic */ j0(WithdrawTemplateUseCase withdrawTemplateUseCase, a0 a02) {
        this.a = withdrawTemplateUseCase;
        this.b = a02;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        a0 a02 = this.b;
        withdrawTemplateUseCase.r1(a02, n10);
    }
}

