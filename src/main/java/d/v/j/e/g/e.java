/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.g;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.e.g.y;
import e.a.v0.g;
import java.util.Optional;

public final class e
implements g {
    public final /* synthetic */ y a;
    public final /* synthetic */ Optional b;

    public /* synthetic */ e(y y10, Optional optional) {
        this.a = y10;
        this.b = optional;
    }

    public final void accept(Object object) {
        y y10 = this.a;
        Optional optional = this.b;
        object = (TemplatePOJO)object;
        y10.S(optional, (TemplatePOJO)object);
    }
}

