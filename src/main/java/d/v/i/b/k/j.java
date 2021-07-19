/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import java.util.function.Predicate;

public final class j
implements Predicate {
    public final /* synthetic */ boolean a;

    public /* synthetic */ j(boolean bl2) {
        this.a = bl2;
    }

    public final boolean test(Object object) {
        boolean bl2 = this.a;
        object = (TemplateSticker)object;
        return WithdrawTemplateUseCase.m2(bl2, (TemplateSticker)object);
    }
}

