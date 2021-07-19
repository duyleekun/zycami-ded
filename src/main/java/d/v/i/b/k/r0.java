/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.List;
import java.util.function.IntUnaryOperator;

public final class r0
implements IntUnaryOperator {
    public final /* synthetic */ List a;

    public /* synthetic */ r0(List list) {
        this.a = list;
    }

    public final int applyAsInt(int n10) {
        return WithdrawTemplateUseCase.v2(this.a, n10);
    }
}

