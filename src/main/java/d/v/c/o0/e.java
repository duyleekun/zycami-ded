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
import com.zhiyun.cama.album.AlbumDetailFragment;

public final class e
implements OnItemClickListener {
    public final /* synthetic */ AlbumDetailFragment a;

    public /* synthetic */ e(AlbumDetailFragment albumDetailFragment) {
        this.a = albumDetailFragment;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.z(baseQuickAdapter, view, n10);
    }
}

