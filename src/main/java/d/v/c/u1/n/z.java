/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.u1.n;

import android.view.View;
import com.zhiyun.cama.template.list.TemplateListAdapter;
import com.zhiyun.cama.template.list.TemplateListAdapter$e;
import d.v.f.f.d;

public final class z
implements d {
    public final /* synthetic */ TemplateListAdapter a;
    public final /* synthetic */ TemplateListAdapter$e b;
    public final /* synthetic */ int c;

    public /* synthetic */ z(TemplateListAdapter templateListAdapter, TemplateListAdapter$e templateListAdapter$e, int n10) {
        this.a = templateListAdapter;
        this.b = templateListAdapter$e;
        this.c = n10;
    }

    public final void a(View view) {
        TemplateListAdapter templateListAdapter = this.a;
        TemplateListAdapter$e templateListAdapter$e = this.b;
        int n10 = this.c;
        templateListAdapter.j(templateListAdapter$e, n10, view);
    }
}

