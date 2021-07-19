/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import androidx.core.util.Pair;
import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import d.v.j.e.g.a0;
import java.util.function.IntConsumer;

public final class z
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ Pair b;
    public final /* synthetic */ String[] c;
    public final /* synthetic */ a0 d;

    public /* synthetic */ z(WithdrawTemplateUseCase withdrawTemplateUseCase, Pair pair, String[] stringArray, a0 a02) {
        this.a = withdrawTemplateUseCase;
        this.b = pair;
        this.c = stringArray;
        this.d = a02;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        Pair pair = this.b;
        String[] stringArray = this.c;
        a0 a02 = this.d;
        withdrawTemplateUseCase.W0(pair, stringArray, a02, n10);
    }
}

