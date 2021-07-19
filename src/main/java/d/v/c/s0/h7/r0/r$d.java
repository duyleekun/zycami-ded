/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 */
package d.v.c.s0.h7.r0;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.m1.b;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.r0.r;
import d.v.e.l.n2;
import d.v.f.i.g;

public class r$d {
    public final /* synthetic */ r a;

    public r$d(r r10) {
        this.a = r10;
    }

    public void a(View object) {
        object = r.m(this.a).o();
        Object object2 = r.m(this.a);
        boolean n10 = ((m0)object2).M((TemplatePOJO)object);
        if (n10) {
            object2 = ((TemplatePOJO)object).getTemplateData();
            boolean bl2 = ((TemplateData)object2).isPrimeUsable();
            if (!bl2) {
                r.k(this.a).f((TemplatePOJO)object);
                object = r.m(this.a);
                object2 = CameraSet$StoryState.STORY_RECORD;
                ((m0)object).g0((CameraSet$StoryState)((Object)object2));
                return;
            }
            object2 = this.a.requireContext();
            boolean bl3 = b.b((Context)object2);
            if (bl3) {
                r.k(this.a).f((TemplatePOJO)object);
                object = r.m(this.a);
                object2 = CameraSet$StoryState.STORY_RECORD;
                ((m0)object).g0((CameraSet$StoryState)((Object)object2));
            }
        } else {
            object = this.a.getResources();
            int n11 = 2131953150;
            object = g.o((Resources)object, n11);
            n2.e((String)object);
        }
    }

    public void b(View view) {
        r.j(this.a);
    }
}

