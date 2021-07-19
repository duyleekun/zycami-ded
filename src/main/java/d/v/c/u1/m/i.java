/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import d.v.h.e.a;
import java.util.function.IntFunction;

public final class i
implements IntFunction {
    public final /* synthetic */ a a;

    public /* synthetic */ i(a a10) {
        this.a = a10;
    }

    public final Object apply(int n10) {
        return AiUseCase.i(this.a, n10);
    }
}

