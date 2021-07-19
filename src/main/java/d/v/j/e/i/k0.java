/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.j.e.i.c1;

public final class k0
implements Runnable {
    public final /* synthetic */ c1 a;
    public final /* synthetic */ TemplateData b;

    public /* synthetic */ k0(c1 c12, TemplateData templateData) {
        this.a = c12;
        this.b = templateData;
    }

    public final void run() {
        c1 c12 = this.a;
        TemplateData templateData = this.b;
        c12.B(templateData);
    }
}

