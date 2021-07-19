/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.api.entity.template.Global;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import d.v.j.e.g.y;
import java.util.function.Consumer;

public final class o
implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ Global b;

    public /* synthetic */ o(y y10, Global global) {
        this.a = y10;
        this.b = global;
    }

    public final void accept(Object object) {
        y y10 = this.a;
        Global global = this.b;
        object = (TemplateFilter)object;
        y10.x(global, (TemplateFilter)object);
    }
}

