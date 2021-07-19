/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.List;
import java.util.function.IntConsumer;

public final class k
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;

    public /* synthetic */ k(WithdrawTemplateUseCase withdrawTemplateUseCase, List list, List list2) {
        this.a = withdrawTemplateUseCase;
        this.b = list;
        this.c = list2;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        List list = this.b;
        List list2 = this.c;
        withdrawTemplateUseCase.b1(list, list2, n10);
    }
}

