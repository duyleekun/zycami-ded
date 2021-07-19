/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.api.entity.template.Slices;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import d.v.j.e.g.y;
import java.util.function.Consumer;

public final class d
implements Consumer {
    public final /* synthetic */ Slices a;

    public /* synthetic */ d(Slices slices) {
        this.a = slices;
    }

    public final void accept(Object object) {
        Slices slices = this.a;
        object = (TemplateTransition)object;
        y.M(slices, (TemplateTransition)object);
    }
}

