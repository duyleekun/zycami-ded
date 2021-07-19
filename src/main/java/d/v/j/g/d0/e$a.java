/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g.d0;

import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.editortemplate.data.api.entity.track.TrackListBean;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.j.g.d0.d;
import d.v.j.g.d0.e;
import d.v.j.g.d0.f;
import k.r;
import m.a.a;

public class e$a
implements k.f {
    public final /* synthetic */ TemplatePOJO a;
    public final /* synthetic */ DownLoadHelper$CancelControl b;
    public final /* synthetic */ e c;

    public e$a(e e10, TemplatePOJO templatePOJO, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.c = e10;
        this.a = templatePOJO;
        this.b = downLoadHelper$CancelControl;
    }

    public void onFailure(k.d object, Throwable object2) {
        ((Throwable)object2).printStackTrace();
        object = this.c;
        object2 = this.a;
        ((d)object).k(object2);
    }

    public void onResponse(k.d object, r object2) {
        boolean bl2 = object2.g();
        if (bl2) {
            object = (TemplateInfoData)object2.a();
            int n10 = 1;
            object2 = new Object[n10];
            object2[0] = object;
            Object object3 = "onDownload, TemplateInfoData: %s";
            m.a.a.b((String)object3, object2);
            object2 = this.c.O((TemplateInfoData)object);
            if (object2 != null) {
                Object object4;
                object3 = this.c;
                if ((object = ((e)object3).T((TemplateInfoData)object)) != null) {
                    object3 = this.c;
                    object4 = this.a;
                    e.R((e)object3, (TemplatePOJO)object4, (TrackListBean)object);
                }
                object = this.c;
                object3 = this.a;
                object4 = this.b;
                ((f)object).B((TemplatePOJO)object3, (EditorProtocol)object2, (DownLoadHelper$CancelControl)object4);
            } else {
                object = this.c;
                object2 = this.a;
                ((d)object).l(object2);
            }
            return;
        }
        object = this.c;
        object2 = this.a;
        ((d)object).i(object2);
    }
}

