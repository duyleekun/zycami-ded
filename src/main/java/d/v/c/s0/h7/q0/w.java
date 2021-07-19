/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.q0;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.s0.h7.q0.z;
import d.v.j.g.d0.d$a;

public final class w
implements d$a {
    public final /* synthetic */ z a;

    public /* synthetic */ w(z z10) {
        this.a = z10;
    }

    public final void a(Object object, Object object2, DownloadEvent downloadEvent) {
        z z10 = this.a;
        object = (Long)object;
        object2 = (TemplatePOJO)object2;
        z10.k((Long)object, (TemplatePOJO)object2, downloadEvent);
    }
}

