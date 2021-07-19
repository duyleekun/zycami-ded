/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.List;
import java.util.function.Function;

public final class c
implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;

    public /* synthetic */ c(int n10, List list) {
        this.a = n10;
        this.b = list;
    }

    public final Object apply(Object object) {
        int n10 = this.a;
        List list = this.b;
        object = (TemplatePOJO)object;
        return AiUseCase.o(n10, list, (TemplatePOJO)object);
    }
}

