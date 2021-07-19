/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import java.util.List;
import java.util.function.IntPredicate;

public final class k
implements IntPredicate {
    public final /* synthetic */ List a;
    public final /* synthetic */ List b;

    public /* synthetic */ k(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    public final boolean test(int n10) {
        List list = this.a;
        List list2 = this.b;
        return AiUseCase.A(list, list2, n10);
    }
}

