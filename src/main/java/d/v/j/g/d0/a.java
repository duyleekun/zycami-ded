/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g.d0;

import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.j.g.d0.f;

public final class a
implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ EditorProtocol b;
    public final /* synthetic */ TemplatePOJO c;
    public final /* synthetic */ DownLoadHelper$CancelControl d;

    public /* synthetic */ a(f f10, EditorProtocol editorProtocol, TemplatePOJO templatePOJO, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.a = f10;
        this.b = editorProtocol;
        this.c = templatePOJO;
        this.d = downLoadHelper$CancelControl;
    }

    public final void run() {
        f f10 = this.a;
        EditorProtocol editorProtocol = this.b;
        TemplatePOJO templatePOJO = this.c;
        DownLoadHelper$CancelControl downLoadHelper$CancelControl = this.d;
        f10.J(editorProtocol, templatePOJO, downLoadHelper$CancelControl);
    }
}

