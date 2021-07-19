/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.o0;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.zhiyun.cama.album.AlbumListFragment;

public final class t
implements OnItemChildClickListener {
    public final /* synthetic */ AlbumListFragment a;

    public /* synthetic */ t(AlbumListFragment albumListFragment) {
        this.a = albumListFragment;
    }

    public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.w(baseQuickAdapter, view, n10);
    }
}

