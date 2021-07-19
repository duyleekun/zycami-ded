/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b;

import com.zhiyun.editorsdk.draft.DraftUseCase;
import d.v.h.d.d;
import java.util.function.Function;

public final class g
implements Function {
    public final /* synthetic */ DraftUseCase a;

    public /* synthetic */ g(DraftUseCase draftUseCase) {
        this.a = draftUseCase;
    }

    public final Object apply(Object object) {
        DraftUseCase draftUseCase = this.a;
        object = (d)object;
        return draftUseCase.n((d)object);
    }
}

