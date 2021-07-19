/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.api.entity.template.Global;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import d.v.j.e.g.y;
import java.util.function.Consumer;

public final class k
implements Consumer {
    public final /* synthetic */ Global a;

    public /* synthetic */ k(Global global) {
        this.a = global;
    }

    public final void accept(Object object) {
        Global global = this.a;
        object = (TemplateRotate)object;
        y.r(global, (TemplateRotate)object);
    }
}

