/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.m;

import com.zhiyun.cama.template.edit.AiUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import e.a.k0;
import e.a.m0;
import java.util.List;

public final class l
implements m0 {
    public final /* synthetic */ AiUseCase a;
    public final /* synthetic */ List b;
    public final /* synthetic */ TemplatePOJO c;

    public /* synthetic */ l(AiUseCase aiUseCase, List list, TemplatePOJO templatePOJO) {
        this.a = aiUseCase;
        this.b = list;
        this.c = templatePOJO;
    }

    public final void subscribe(k0 k02) {
        AiUseCase aiUseCase = this.a;
        List list = this.b;
        TemplatePOJO templatePOJO = this.c;
        aiUseCase.w(list, templatePOJO, k02);
    }
}

