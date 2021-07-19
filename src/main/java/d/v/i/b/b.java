/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b;

import com.zhiyun.editorsdk.draft.DraftUseCase;
import java.util.function.Function;

public final class b
implements Function {
    public final /* synthetic */ DraftUseCase a;

    public /* synthetic */ b(DraftUseCase draftUseCase) {
        this.a = draftUseCase;
    }

    public final Object apply(Object object) {
        DraftUseCase draftUseCase = this.a;
        object = (d.v.h.h.b)object;
        return draftUseCase.j((d.v.h.h.b)object);
    }
}

