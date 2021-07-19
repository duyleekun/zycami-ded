/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.arch.core.util.Function;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.j.g.x;

public final class j
implements Function {
    public final /* synthetic */ TemplateData a;

    public /* synthetic */ j(TemplateData templateData) {
        this.a = templateData;
    }

    public final Object apply(Object object) {
        TemplateData templateData = this.a;
        object = (TemplateVideo)object;
        return x.U(templateData, (TemplateVideo)object);
    }
}

