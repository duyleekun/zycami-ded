/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import java.util.List;
import java.util.function.IntUnaryOperator;

public final class f
implements IntUnaryOperator {
    public final /* synthetic */ List a;
    public final /* synthetic */ long b;

    public /* synthetic */ f(List list, long l10) {
        this.a = list;
        this.b = l10;
    }

    public final int applyAsInt(int n10) {
        List list = this.a;
        long l10 = this.b;
        return AiUseCase.j(list, l10, n10);
    }
}

