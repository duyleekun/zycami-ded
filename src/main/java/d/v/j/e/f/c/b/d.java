/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.c.b;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import java.util.List;
import java.util.function.Consumer;

public final class d
implements Consumer {
    public final /* synthetic */ TemplatePOJO a;
    public final /* synthetic */ TemplatePOJO b;

    public /* synthetic */ d(TemplatePOJO templatePOJO, TemplatePOJO templatePOJO2) {
        this.a = templatePOJO;
        this.b = templatePOJO2;
    }

    public final void accept(Object object) {
        TemplatePOJO templatePOJO = this.a;
        TemplatePOJO templatePOJO2 = this.b;
        object = (List)object;
        templatePOJO.f(templatePOJO2, (List)object);
    }
}

