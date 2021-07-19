/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 */
package d.v.c.s0.h7.q0;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.m1.b;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.q0.x;
import d.v.c.s0.h7.q0.z;
import d.v.e.l.n2;
import d.v.f.i.g;

public class x$a {
    public final /* synthetic */ x a;

    public x$a(x x10) {
        this.a = x10;
    }

    private void b(TemplatePOJO object) {
        this.a.dismissAllowingStateLoss();
        Object object2 = x.u(this.a);
        long l10 = ((TemplatePOJO)object).getTemplateData().getId();
        object = object2.j(l10);
        x.v(this.a).e0((LiveData)object);
        object = x.v(this.a);
        object2 = CameraSet$StoryState.STORY_RECORD;
        ((m0)object).g0((CameraSet$StoryState)((Object)object2));
    }

    public void a(View object, TemplatePOJO templatePOJO) {
        object = templatePOJO.getTemplateData();
        boolean bl2 = ((TemplateData)object).isDownloadFinished();
        if (bl2) {
            object = x.v(this.a);
            bl2 = ((m0)object).M(templatePOJO);
            if (bl2) {
                object = templatePOJO.getTemplateData();
                bl2 = ((TemplateData)object).isPrimeUsable();
                if (!bl2) {
                    this.b(templatePOJO);
                    return;
                }
                object = this.a.requireContext();
                bl2 = b.b((Context)object);
                if (bl2) {
                    this.b(templatePOJO);
                }
            } else {
                object = this.a.getResources();
                int n10 = 2131953150;
                object = g.o((Resources)object, n10);
                n2.e((String)object);
            }
        } else {
            object = x.w(this.a);
            ((z)object).d(templatePOJO);
        }
    }

    public void c() {
        this.a.dismissAllowingStateLoss();
    }
}

