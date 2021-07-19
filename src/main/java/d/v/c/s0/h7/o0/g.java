/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s0.h7.o0;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import d.v.c.s0.h7.o0.v0;

public final class g
implements OnItemChildClickListener {
    public final /* synthetic */ v0 a;

    public /* synthetic */ g(v0 v02) {
        this.a = v02;
    }

    public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.u(baseQuickAdapter, view, n10);
    }
}

