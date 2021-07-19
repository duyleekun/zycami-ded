/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b;

import com.zhiyun.editorsdk.draft.DraftUseCase;
import d.v.h.e.d;
import java.util.function.Function;

public final class c
implements Function {
    public final /* synthetic */ DraftUseCase a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ c(DraftUseCase draftUseCase, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.a = draftUseCase;
        this.b = bl2;
        this.c = bl3;
        this.d = bl4;
        this.e = bl5;
        this.f = bl6;
    }

    public final Object apply(Object object) {
        DraftUseCase draftUseCase = this.a;
        boolean bl2 = this.b;
        boolean bl3 = this.c;
        boolean bl4 = this.d;
        boolean bl5 = this.e;
        boolean bl6 = this.f;
        Object object2 = object;
        object2 = (d)object;
        return draftUseCase.p(bl2, bl3, bl4, bl5, bl6, (d)object2);
    }
}

