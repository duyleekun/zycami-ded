/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import d.v.j.e.g.a0;
import java.util.function.Consumer;

public final class m
implements Consumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ a0 b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ a0 d;

    public /* synthetic */ m(WithdrawTemplateUseCase withdrawTemplateUseCase, a0 a02, boolean bl2, a0 a03) {
        this.a = withdrawTemplateUseCase;
        this.b = a02;
        this.c = bl2;
        this.d = a03;
    }

    public final void accept(Object object) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        a0 a02 = this.b;
        boolean bl2 = this.c;
        a0 a03 = this.d;
        object = (Integer)object;
        withdrawTemplateUseCase.U1(a02, bl2, a03, (Integer)object);
    }
}

