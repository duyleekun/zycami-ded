/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.y0.b.u;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.zhiyun.cama.device.connect.help.ConnectHelpFragment;

public final class a
implements OnItemChildClickListener {
    public final /* synthetic */ ConnectHelpFragment a;

    public /* synthetic */ a(ConnectHelpFragment connectHelpFragment) {
        this.a = connectHelpFragment;
    }

    public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.n(baseQuickAdapter, view, n10);
    }
}

