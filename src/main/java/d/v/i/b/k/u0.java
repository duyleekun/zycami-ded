/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.List;
import java.util.function.IntConsumer;

public final class u0
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ u0(WithdrawTemplateUseCase withdrawTemplateUseCase, List list, boolean bl2) {
        this.a = withdrawTemplateUseCase;
        this.b = list;
        this.c = bl2;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        List list = this.b;
        boolean bl2 = this.c;
        withdrawTemplateUseCase.u2(list, bl2, n10);
    }
}

