/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import java.util.List;
import java.util.function.IntFunction;

public final class o
implements IntFunction {
    public final /* synthetic */ List a;

    public /* synthetic */ o(List list) {
        this.a = list;
    }

    public final Object apply(int n10) {
        return AiUseCase.H(this.a, n10);
    }
}

