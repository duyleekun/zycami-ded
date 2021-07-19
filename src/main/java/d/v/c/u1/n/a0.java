/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.u1.n;

import android.view.View;
import com.zhiyun.cama.template.list.TemplateListAdapter;

public final class a0
implements View.OnClickListener {
    public final /* synthetic */ TemplateListAdapter a;
    public final /* synthetic */ int b;

    public /* synthetic */ a0(TemplateListAdapter templateListAdapter, int n10) {
        this.a = templateListAdapter;
        this.b = n10;
    }

    public final void onClick(View view) {
        TemplateListAdapter templateListAdapter = this.a;
        int n10 = this.b;
        templateListAdapter.n(n10, view);
    }
}

