/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.f;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.j.f.g;
import d.v.j.g.d0.d$a;

public final class c
implements d$a {
    public final /* synthetic */ g a;

    public /* synthetic */ c(g g10) {
        this.a = g10;
    }

    public final void a(Object object, Object object2, DownloadEvent downloadEvent) {
        g g10 = this.a;
        object = (Long)object;
        object2 = (TemplatePOJO)object2;
        g10.s((Long)object, (TemplatePOJO)object2, downloadEvent);
    }
}

