/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g.d0;

import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;
import d.v.j.g.d0.d;
import d.v.j.g.d0.f;
import java.util.List;
import m.a.a;

public class f$b
implements DownLoadHelper$OnDownloadFileEntityCallback {
    public int a = 0;
    public int b;
    public boolean c;
    public final /* synthetic */ List d;
    public final /* synthetic */ TemplatePOJO e;
    public final /* synthetic */ EditorProtocol f;
    public final /* synthetic */ List g;
    public final /* synthetic */ f h;

    public f$b(f f10, List list, TemplatePOJO templatePOJO, EditorProtocol editorProtocol, List list2) {
        int n10;
        this.h = f10;
        this.d = list;
        this.e = templatePOJO;
        this.f = editorProtocol;
        this.g = list2;
        this.b = n10 = list.size();
        this.c = false;
    }

    public void cancel(DownloadEntity object) {
        this.downloadFailed((DownloadEntity)object, null);
        Object[] objectArray = new StringBuilder();
        objectArray.append("cancel:");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.e((String)object, objectArray);
    }

    public void downloadCount(DownloadEntity object, int n10, int n11) {
        this.a = n10;
        Object object2 = new StringBuilder();
        String string2 = "downloadCount:";
        object2.append(string2);
        object2.append(object);
        object2.append(" \u4e2a\u6570:");
        object2.append(n10);
        object2.append("/");
        object2.append(n11);
        object = object2.toString();
        object2 = new Object[]{};
        m.a.a.b((String)object, object2);
        if (n10 == n11) {
            object = this.h;
            TemplatePOJO templatePOJO = this.e;
            EditorProtocol editorProtocol = this.f;
            object2 = this.g;
            ((f)object).A(templatePOJO, editorProtocol, (List)object2);
        }
    }

    public void downloadFailed(DownloadEntity object, Throwable object2) {
        Object[] objectArray = new StringBuilder();
        objectArray.append("downloadFailed:");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.g((Throwable)object2, (String)object, objectArray);
        object = this.h;
        object2 = this.e;
        ((d)object).i(object2);
    }

    public void downloadProgress(DownloadEntity object, int n10, long l10, long l11) {
        int n11 = this.a;
        int n12 = this.b;
        n11 = DownLoadHelper.getProgress(n10, n11, n12);
        Object object2 = this.h;
        TemplatePOJO templatePOJO = this.e;
        ((d)object2).s(templatePOJO, n11);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("downloadProgress:");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append("----");
        ((StringBuilder)object2).append(n11);
        object = ((StringBuilder)object2).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
    }

    public void downloadSuccess(DownloadEntity object) {
        Object[] objectArray = new StringBuilder();
        objectArray.append("downloadSuccess:");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
    }

    public void saveFailed(DownloadEntity object, Throwable object2) {
        Object[] objectArray = new StringBuilder();
        objectArray.append("saveFailed:");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.g((Throwable)object2, (String)object, objectArray);
        object = this.h;
        object2 = this.e;
        ((d)object).i(object2);
    }
}

