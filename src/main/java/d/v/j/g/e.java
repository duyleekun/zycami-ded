/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.arch.core.util.Function;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import d.v.j.g.x;

public final class e
implements Function {
    public final /* synthetic */ TemplateGlobal a;

    public /* synthetic */ e(TemplateGlobal templateGlobal) {
        this.a = templateGlobal;
    }

    public final Object apply(Object object) {
        TemplateGlobal templateGlobal = this.a;
        object = (TemplateSticker)object;
        return x.S(templateGlobal, (TemplateSticker)object);
    }
}

