/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.o0;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.album.AlbumListFragment;

public final class w
implements OnItemClickListener {
    public final /* synthetic */ AlbumListFragment a;

    public /* synthetic */ w(AlbumListFragment albumListFragment) {
        this.a = albumListFragment;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.u(baseQuickAdapter, view, n10);
    }
}

