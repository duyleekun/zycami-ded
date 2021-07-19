/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.f;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.f.g;

public final class a
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ TemplatePOJO b;

    public /* synthetic */ a(g g10, TemplatePOJO templatePOJO) {
        this.a = g10;
        this.b = templatePOJO;
    }

    public final void run() {
        g g10 = this.a;
        TemplatePOJO templatePOJO = this.b;
        g10.p(templatePOJO);
    }
}

