/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.function.Predicate;

public final class a
implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public final boolean test(Object object) {
        int n10 = this.a;
        int n11 = this.b;
        object = (TemplatePOJO)object;
        return AiUseCase.l(n10, n11, (TemplatePOJO)object);
    }
}

