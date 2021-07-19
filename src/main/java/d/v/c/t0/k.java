/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.t0;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.zhiyun.cama.cloud_engine.CETemplateFragment;

public final class k
implements OnItemChildClickListener {
    public final /* synthetic */ CETemplateFragment a;

    public /* synthetic */ k(CETemplateFragment cETemplateFragment) {
        this.a = cETemplateFragment;
    }

    public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.u(baseQuickAdapter, view, n10);
    }
}

