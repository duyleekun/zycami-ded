/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.album;

import androidx.databinding.ObservableField;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhiyun.cama.album.AlbumDetailFragment;

public class AlbumDetailFragment$a
extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ AlbumDetailFragment a;

    public AlbumDetailFragment$a(AlbumDetailFragment albumDetailFragment) {
        this.a = albumDetailFragment;
    }

    public void onPageSelected(int n10) {
        super.onPageSelected(n10);
        Object object = AlbumDetailFragment.j(this.a);
        int n11 = ((BaseQuickAdapter)object).getItemCount();
        if (n11 > 0) {
            object = AlbumDetailFragment.k(this.a);
            Object object2 = AlbumDetailFragment.j(this.a).getItem(n10);
            ((ObservableField)object).set(object2);
            object = this.a;
            AlbumDetailFragment.l((AlbumDetailFragment)object, n10);
        }
    }
}

