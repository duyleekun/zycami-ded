/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.arch.core.util.Function;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.j.g.x;

public final class g
implements Function {
    public final /* synthetic */ TemplatePOJO a;

    public /* synthetic */ g(TemplatePOJO templatePOJO) {
        this.a = templatePOJO;
    }

    public final Object apply(Object object) {
        TemplatePOJO templatePOJO = this.a;
        object = (TemplateVideo)object;
        return x.R(templatePOJO, (TemplateVideo)object);
    }
}

