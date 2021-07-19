/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.api.entity.template.Slices;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import d.v.j.e.g.y;
import java.util.function.Consumer;

public final class v
implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ Slices b;

    public /* synthetic */ v(y y10, Slices slices) {
        this.a = y10;
        this.b = slices;
    }

    public final void accept(Object object) {
        y y10 = this.a;
        Slices slices = this.b;
        object = (TemplateFilter)object;
        y10.J(slices, (TemplateFilter)object);
    }
}

