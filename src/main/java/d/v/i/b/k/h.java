/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import d.v.j.e.g.a0;
import java.util.function.Consumer;

public final class h
implements Consumer {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ a0 b;

    public /* synthetic */ h(WithdrawTemplateUseCase withdrawTemplateUseCase, a0 a02) {
        this.a = withdrawTemplateUseCase;
        this.b = a02;
    }

    public final void accept(Object object) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        a0 a02 = this.b;
        object = (Integer)object;
        withdrawTemplateUseCase.m1(a02, (Integer)object);
    }
}

