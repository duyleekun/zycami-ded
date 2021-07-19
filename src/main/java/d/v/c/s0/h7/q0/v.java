/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.q0;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.s0.h7.q0.z;

public final class v
implements Runnable {
    public final /* synthetic */ z a;
    public final /* synthetic */ TemplatePOJO b;
    public final /* synthetic */ DownloadEvent c;

    public /* synthetic */ v(z z10, TemplatePOJO templatePOJO, DownloadEvent downloadEvent) {
        this.a = z10;
        this.b = templatePOJO;
        this.c = downloadEvent;
    }

    public final void run() {
        z z10 = this.a;
        TemplatePOJO templatePOJO = this.b;
        DownloadEvent downloadEvent = this.c;
        z10.o(templatePOJO, downloadEvent);
    }
}

