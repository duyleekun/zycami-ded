/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.api.entity.template.Slices;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import d.v.j.e.g.y;
import java.util.function.Consumer;

public final class a
implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ Slices b;

    public /* synthetic */ a(y y10, Slices slices) {
        this.a = y10;
        this.b = slices;
    }

    public final void accept(Object object) {
        y y10 = this.a;
        Slices slices = this.b;
        object = (TemplateEffect)object;
        y10.L(slices, (TemplateEffect)object);
    }
}

