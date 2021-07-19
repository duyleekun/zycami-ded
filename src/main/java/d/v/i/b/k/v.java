/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.List;
import java.util.function.IntConsumer;

public final class v
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ List b;

    public /* synthetic */ v(WithdrawTemplateUseCase withdrawTemplateUseCase, List list) {
        this.a = withdrawTemplateUseCase;
        this.b = list;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        List list = this.b;
        withdrawTemplateUseCase.q2(list, n10);
    }
}

