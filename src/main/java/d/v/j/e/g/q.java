/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.j.e.g.y;
import java.util.function.Function;

public final class q
implements Function {
    public final /* synthetic */ y a;

    public /* synthetic */ q(y y10) {
        this.a = y10;
    }

    public final Object apply(Object object) {
        y y10 = this.a;
        object = (TemplateVideo)object;
        return y10.A((TemplateVideo)object);
    }
}

