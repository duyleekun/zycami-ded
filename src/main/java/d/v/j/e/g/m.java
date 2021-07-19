/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.e.g.y;
import java.util.function.Function;

public final class m
implements Function {
    public final /* synthetic */ y a;

    public /* synthetic */ m(y y10) {
        this.a = y10;
    }

    public final Object apply(Object object) {
        y y10 = this.a;
        object = (TemplatePOJO)object;
        return y10.V((TemplatePOJO)object);
    }
}

