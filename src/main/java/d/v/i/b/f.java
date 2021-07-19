/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b;

import com.zhiyun.editorsdk.draft.DraftUseCase;
import d.v.h.h.b;
import java.util.function.Function;

public final class f
implements Function {
    public final /* synthetic */ DraftUseCase a;

    public /* synthetic */ f(DraftUseCase draftUseCase) {
        this.a = draftUseCase;
    }

    public final Object apply(Object object) {
        DraftUseCase draftUseCase = this.a;
        object = (b)object;
        return draftUseCase.h((b)object);
    }
}

