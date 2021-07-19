/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.api.entity.template.Render;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import d.v.j.e.g.y;
import java.util.function.Consumer;

public final class l
implements Consumer {
    public final /* synthetic */ TemplateGlobal a;

    public /* synthetic */ l(TemplateGlobal templateGlobal) {
        this.a = templateGlobal;
    }

    public final void accept(Object object) {
        TemplateGlobal templateGlobal = this.a;
        object = (Render)object;
        y.v(templateGlobal, (Render)object);
    }
}

