/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.function.Predicate;

public final class q
implements Predicate {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;

    public /* synthetic */ q(long l10, long l11) {
        this.a = l10;
        this.b = l11;
    }

    public final boolean test(Object object) {
        long l10 = this.a;
        long l11 = this.b;
        object = (TemplatePOJO)object;
        return AiUseCase.m(l10, l11, (TemplatePOJO)object);
    }
}

