/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s1;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.speed.EditorSpeedFragment;

public final class d
implements OnItemClickListener {
    public final /* synthetic */ EditorSpeedFragment a;

    public /* synthetic */ d(EditorSpeedFragment editorSpeedFragment) {
        this.a = editorSpeedFragment;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.i0(baseQuickAdapter, view, n10);
    }
}

