/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.function.IntConsumer;

public final class c0
implements IntConsumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ String[][] c;

    public /* synthetic */ c0(WithdrawTemplateUseCase withdrawTemplateUseCase, String[] stringArray, String[][] stringArray2) {
        this.a = withdrawTemplateUseCase;
        this.b = stringArray;
        this.c = stringArray2;
    }

    public final void accept(int n10) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        String[] stringArray = this.b;
        String[][] stringArray2 = this.c;
        withdrawTemplateUseCase.x1(stringArray, stringArray2, n10);
    }
}

