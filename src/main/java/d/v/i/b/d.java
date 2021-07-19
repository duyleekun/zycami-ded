/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b;

import com.zhiyun.editorsdk.draft.DraftUseCase;
import d.v.h.d.c;
import java.util.function.Function;

public final class d
implements Function {
    public final /* synthetic */ DraftUseCase a;

    public /* synthetic */ d(DraftUseCase draftUseCase) {
        this.a = draftUseCase;
    }

    public final Object apply(Object object) {
        DraftUseCase draftUseCase = this.a;
        object = (c)object;
        return draftUseCase.l((c)object);
    }
}

