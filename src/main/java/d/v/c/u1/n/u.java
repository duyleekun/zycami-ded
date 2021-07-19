/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.u1.n;

import android.view.View;
import com.zhiyun.cama.template.list.TemplateListAdapter;
import d.v.f.f.d;

public final class u
implements d {
    public final /* synthetic */ TemplateListAdapter a;
    public final /* synthetic */ int b;

    public /* synthetic */ u(TemplateListAdapter templateListAdapter, int n10) {
        this.a = templateListAdapter;
        this.b = n10;
    }

    public final void a(View view) {
        TemplateListAdapter templateListAdapter = this.a;
        int n10 = this.b;
        templateListAdapter.h(n10, view);
    }
}

