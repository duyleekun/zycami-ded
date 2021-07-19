/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.util.DownloadState;
import d.v.c.u1.l.l;
import d.v.j.f.g;

public class l$c {
    public final /* synthetic */ l a;

    public l$c(l l10) {
        this.a = l10;
    }

    public void a() {
        PlayLayout playLayout = l.y(this.a);
        boolean bl2 = playLayout.i();
        if (bl2) {
            return;
        }
        this.a.z0();
        playLayout = l.y(this.a);
        boolean bl3 = l.y(this.a).i();
        playLayout.setNeedRestorePlay(bl3);
    }

    public void b() {
        this.a.z0();
        PlayLayout playLayout = l.y(this.a);
        boolean bl2 = l.y(this.a).i();
        playLayout.setNeedRestorePlay(bl2);
    }

    public void c() {
        TemplatePOJO templatePOJO = l.z(this.a).g();
        Object object = templatePOJO.getTemplateData();
        if (object != null) {
            boolean bl2 = object.isDownloadFinished();
            if (bl2) {
                g g10 = l.z(this.a);
                bl2 = g10.b(templatePOJO);
                if (bl2) {
                    object = this.a;
                    l.A((l)object, templatePOJO);
                } else {
                    boolean bl3 = object.isNetworkTemplate();
                    if (bl3) {
                        object = this.a;
                        l.B((l)object);
                    } else {
                        object = this.a;
                        l.C((l)object);
                    }
                    object = l.z(this.a);
                    ((g)object).K(templatePOJO);
                }
            } else {
                DownloadState downloadState;
                object = l.D(this.a).b();
                if (object == null || (object = l.D(this.a).b()) != (downloadState = DownloadState.DOWNLOAD_SUCCESSFUL)) {
                    object = this.a;
                    l.E((l)object, templatePOJO);
                }
            }
        }
    }

    public void d() {
        this.a.i();
    }
}

