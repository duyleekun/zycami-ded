/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.album;

import android.view.View;
import androidx.databinding.ObservableBoolean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.zhiyun.cama.album.AlbumDetailFragment;
import com.zhiyun.cama.album.AlbumPagerAdapter;
import com.zhiyun.cama.album.AlbumSection;

public class AlbumDetailFragment$b
implements OnItemChildClickListener {
    public final /* synthetic */ AlbumDetailFragment a;

    public AlbumDetailFragment$b(AlbumDetailFragment albumDetailFragment) {
        this.a = albumDetailFragment;
    }

    public void onItemChildClick(BaseQuickAdapter object, View object2, int n10) {
        int n11;
        int n12 = object2.getId();
        if (n12 == (n11 = 2131362584)) {
            object = this.a;
            AlbumDetailFragment.m((AlbumDetailFragment)object);
        } else {
            n12 = object2.getId();
            n11 = 2131363668;
            boolean bl2 = true;
            if (n12 == n11) {
                object = AlbumDetailFragment.j(this.a);
                ((AlbumPagerAdapter)object).s(n10, bl2);
            } else {
                n12 = object2.getId();
                if (n12 == (n11 = 2131362992)) {
                    object = AlbumDetailFragment.j(this.a);
                    object2 = ((AlbumSection)AlbumDetailFragment.j((AlbumDetailFragment)this.a).getItem((int)n10)).getAlbum().playing;
                    boolean bl3 = ((ObservableBoolean)object2).get() ^ bl2;
                    ((AlbumPagerAdapter)object).s(n10, bl3);
                } else {
                    int n13;
                    n12 = object2.getId();
                    if (n12 == (n13 = 2131363767)) {
                        object = this.a;
                        AlbumDetailFragment.n((AlbumDetailFragment)object);
                    }
                }
            }
        }
    }
}

