/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.u1.n;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.template.list.TemplateListAdapter;
import com.zhiyun.cama.template.list.TemplateListAdapter$d;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.u1.l.l;
import d.v.c.u1.n.d0;
import d.v.f.g.b;
import d.v.j.g.z;

public class d0$c
implements TemplateListAdapter$d {
    public final /* synthetic */ d0 a;

    public d0$c(d0 d02) {
        this.a = d02;
    }

    public void a(View object, int n10) {
        object = this.a;
        int n11 = ((d0)object).G();
        if (n10 != n11) {
            return;
        }
        object = (TemplatePOJO)d0.A(this.a).d().get(n10);
        ((TemplatePOJO)object).getTemplateData();
        object = ((TemplatePOJO)object).getTemplate();
        n10 = (int)(((Template)object).isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        object = l.j0(((Template)object).getId());
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        ((b)object).q(fragmentManager);
    }

    public void b(int n10) {
        Object object = this.a;
        int n11 = ((d0)object).G();
        if (n10 != n11) {
            return;
        }
        Object object2 = (TemplatePOJO)d0.A(this.a).d().get(n10);
        object = ((TemplatePOJO)object2).getTemplateData();
        object2 = ((TemplatePOJO)object2).getTemplate();
        TemplateListAdapter templateListAdapter = d0.A(this.a);
        object = ((TemplateData)object).getVideoUrl();
        n11 = (int)(templateListAdapter.q((String)object) ? 1 : 0);
        n10 = (int)(((Template)object2).isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        if (n11 && (n10 = (int)(((z)(object2 = d0.B(this.a))).g() ? 1 : 0)) == 0) {
            object2 = this.a;
            d0.C((d0)object2);
        } else {
            object2 = this.a;
            n11 = 1;
            ((d0)object2).u0(n11 != 0);
        }
    }

    public void c(View view, int n10) {
        this.a.z0(n10);
    }
}

