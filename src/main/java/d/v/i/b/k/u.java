/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.List;
import java.util.function.IntPredicate;

public final class u
implements IntPredicate {
    public final /* synthetic */ List a;

    public /* synthetic */ u(List list) {
        this.a = list;
    }

    public final boolean test(int n10) {
        return WithdrawTemplateUseCase.o2(this.a, n10);
    }
}

