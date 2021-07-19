/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.f;

import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.j.f.g;

public final class e
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ TemplateData b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ e(g g10, TemplateData templateData, String string2, String string3, String string4) {
        this.a = g10;
        this.b = templateData;
        this.c = string2;
        this.d = string3;
        this.e = string4;
    }

    public final void run() {
        g g10 = this.a;
        TemplateData templateData = this.b;
        String string2 = this.c;
        String string3 = this.d;
        String string4 = this.e;
        g10.y(templateData, string2, string3, string4);
    }
}

