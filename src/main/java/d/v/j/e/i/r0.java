/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.e.i.d1;
import java.util.concurrent.Callable;

public final class r0
implements Callable {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ TemplatePOJO b;
    public final /* synthetic */ long c;

    public /* synthetic */ r0(d1 d12, TemplatePOJO templatePOJO, long l10) {
        this.a = d12;
        this.b = templatePOJO;
        this.c = l10;
    }

    public final Object call() {
        d1 d12 = this.a;
        TemplatePOJO templatePOJO = this.b;
        long l10 = this.c;
        return d12.S(templatePOJO, l10);
    }
}

