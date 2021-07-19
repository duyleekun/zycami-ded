/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public final class t
implements Function {
    public final /* synthetic */ WithdrawTemplateUseCase a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ AtomicInteger c;

    public /* synthetic */ t(WithdrawTemplateUseCase withdrawTemplateUseCase, String[] stringArray, AtomicInteger atomicInteger) {
        this.a = withdrawTemplateUseCase;
        this.b = stringArray;
        this.c = atomicInteger;
    }

    public final Object apply(Object object) {
        WithdrawTemplateUseCase withdrawTemplateUseCase = this.a;
        String[] stringArray = this.b;
        AtomicInteger atomicInteger = this.c;
        object = (String)object;
        return withdrawTemplateUseCase.h2(stringArray, atomicInteger, (String)object);
    }
}

