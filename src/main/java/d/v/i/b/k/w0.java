/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.List;
import java.util.function.IntPredicate;

public final class w0
implements IntPredicate {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ List b;

    public /* synthetic */ w0(WithdrawTemplateUseCase withdrawTemplateUseCase, List list) {
        this.a = withdrawTemplateUseCase;
        this.b = list;
    }

    public final boolean test(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        List list = this.b;
        return withdrawTemplateUseCase.F1(list, n10);
    }
}

