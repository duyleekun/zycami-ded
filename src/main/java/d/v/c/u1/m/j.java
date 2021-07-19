/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import e.a.k0;
import e.a.m0;
import java.util.List;

public final class j
implements m0 {
    public final /* synthetic */ AiUseCase a;
    public final /* synthetic */ List b;

    public /* synthetic */ j(AiUseCase aiUseCase, List list) {
        this.a = aiUseCase;
        this.b = list;
    }

    public final void subscribe(k0 k02) {
        AiUseCase aiUseCase = this.a;
        List list = this.b;
        aiUseCase.u(list, k02);
    }
}

