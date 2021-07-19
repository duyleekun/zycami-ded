/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.u0;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.u0.l;

public final class i
implements Runnable {
    public final /* synthetic */ l a;
    public final /* synthetic */ TemplatePOJO b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ i(l l10, TemplatePOJO templatePOJO, String string2, String string3) {
        this.a = l10;
        this.b = templatePOJO;
        this.c = string2;
        this.d = string3;
    }

    public final void run() {
        l l10 = this.a;
        TemplatePOJO templatePOJO = this.b;
        String string2 = this.c;
        String string3 = this.d;
        l10.w(templatePOJO, string2, string3);
    }
}

