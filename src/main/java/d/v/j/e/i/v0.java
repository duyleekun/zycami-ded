/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import d.v.j.e.i.z0;
import java.util.function.Consumer;

public final class v0
implements Consumer {
    public final /* synthetic */ z0 a;

    public /* synthetic */ v0(z0 z02) {
        this.a = z02;
    }

    public final void accept(Object object) {
        z0 z02 = this.a;
        object = (TemplateGlobal)object;
        z02.h((TemplateGlobal)object);
    }
}

