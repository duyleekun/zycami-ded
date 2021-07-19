/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.List;
import java.util.function.IntPredicate;

public final class l
implements IntPredicate {
    public final /* synthetic */ List a;
    public final /* synthetic */ List b;

    public /* synthetic */ l(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    public final boolean test(int n10) {
        List list = this.a;
        List list2 = this.b;
        return WithdrawTemplateUseCase.i2(list, list2, n10);
    }
}

