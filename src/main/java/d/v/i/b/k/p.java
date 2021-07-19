/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import d.v.j.e.g.a0;
import java.util.function.IntConsumer;

public final class p
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ a0 b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ p(WithdrawTemplateUseCase withdrawTemplateUseCase, a0 a02, boolean bl2) {
        this.a = withdrawTemplateUseCase;
        this.b = a02;
        this.c = bl2;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        a0 a02 = this.b;
        boolean bl2 = this.c;
        withdrawTemplateUseCase.W1(a02, bl2, n10);
    }
}

