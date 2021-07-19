/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.u0;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.s0.h7.u0.l;

public final class h
implements Runnable {
    public final /* synthetic */ TemplatePOJO a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ h(TemplatePOJO templatePOJO, String string2, String string3) {
        this.a = templatePOJO;
        this.b = string2;
        this.c = string3;
    }

    public final void run() {
        TemplatePOJO templatePOJO = this.a;
        String string2 = this.b;
        String string3 = this.c;
        l.u(templatePOJO, string2, string3);
    }
}

