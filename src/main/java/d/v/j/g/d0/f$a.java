/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g.d0;

import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfo;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.j.g.d0.d;
import d.v.j.g.d0.f;
import k.r;
import m.a.a;

public class f$a
implements k.f {
    public final /* synthetic */ TemplatePOJO a;
    public final /* synthetic */ DownLoadHelper$CancelControl b;
    public final /* synthetic */ f c;

    public f$a(f f10, TemplatePOJO templatePOJO, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.c = f10;
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
        boolean bl2 = ((r)object2).g();
        if (bl2 && (object = (TemplateInfo)((r)object2).a()) != null) {
            object = ((TemplateInfo)object).getData();
            int n10 = 1;
            object2 = new Object[n10];
            object2[0] = object;
            Object object3 = "onDownload, data: %s";
            m.a.a.b((String)object3, (Object[])object2);
            object2 = this.c;
            object = ((f)object2).O((TemplateInfoData)object);
            if (object != null) {
                object2 = this.c;
                object3 = this.a;
                DownLoadHelper$CancelControl downLoadHelper$CancelControl = this.b;
                ((f)object2).B((TemplatePOJO)object3, (EditorProtocol)object, downLoadHelper$CancelControl);
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

