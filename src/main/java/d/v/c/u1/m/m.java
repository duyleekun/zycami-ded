/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.e.g.a;
import java.util.function.Predicate;

public final class m
implements Predicate {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;

    public /* synthetic */ m(a a10, int n10) {
        this.a = a10;
        this.b = n10;
    }

    public final boolean test(Object object) {
        a a10 = this.a;
        int n10 = this.b;
        object = (TemplatePOJO)object;
        return AiUseCase.p(a10, n10, (TemplatePOJO)object);
    }
}

