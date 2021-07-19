/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.function.IntConsumer;

public final class t0
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ t0(WithdrawTemplateUseCase withdrawTemplateUseCase, boolean bl2) {
        this.a = withdrawTemplateUseCase;
        this.b = bl2;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        boolean bl2 = this.b;
        withdrawTemplateUseCase.Y1(bl2, n10);
    }
}

