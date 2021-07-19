/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.widget.HorizontalScrollView
 */
package com.zhiyun.cama.album;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.HorizontalScrollView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.FragmentActivity;
import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumListFragment;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.u0;
import d.v.c.x1.l;
import java.util.List;

public class AlbumListFragment$a {
    public final /* synthetic */ AlbumListFragment a;

    public AlbumListFragment$a(AlbumListFragment albumListFragment) {
        this.a = albumListFragment;
    }

    public void a() {
        FragmentActivity fragmentActivity = this.a.getActivity();
        if (fragmentActivity != null) {
            fragmentActivity = this.a.getActivity();
            fragmentActivity.onBackPressed();
        }
    }

    public void b(int n10) {
        ObservableInt observableInt = AlbumListFragment.j(this.a);
        int n11 = observableInt.get();
        if (n11 == n10) {
            return;
        }
        AlbumListFragment.k(this.a).v();
        AlbumListFragment.l(this.a).getData().clear();
        AlbumListFragment.l(this.a).notifyDataSetChanged();
        AlbumListFragment.m(this.a).c(n10);
        AlbumListFragment.j(this.a).set(n10);
        AlbumListFragment.k(this.a).f(n10);
        n11 = 0;
        observableInt = null;
        if (n10 != 0) {
            int n12 = 3;
            if (n10 != n12) {
                HorizontalScrollView horizontalScrollView = AlbumListFragment.n((AlbumListFragment)this.a).g;
                n10 = horizontalScrollView.getWidth() / 2;
            } else {
                HorizontalScrollView horizontalScrollView = AlbumListFragment.n((AlbumListFragment)this.a).g;
                n10 = horizontalScrollView.getRight();
            }
        } else {
            n10 = 0;
            Object var5_7 = null;
        }
        AlbumListFragment.n((AlbumListFragment)this.a).g.smoothScrollTo(n10, 0);
    }

    public void c() {
        Object object = AlbumListFragment.o(this.a);
        boolean bl2 = AlbumListFragment.o(this.a).get() ^ true;
        ((ObservableBoolean)object).set(bl2);
        object = AlbumListFragment.l(this.a);
        bl2 = AlbumListFragment.o(this.a).get();
        ((AlbumListAdapter)object).t(bl2);
        AlbumListFragment.k(this.a).v();
    }

    public void d() {
        List list = AlbumListFragment.l(this.a).e();
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return;
        }
        Parcelable[] parcelableArray = new AlbumSection[list.size()];
        list.toArray(parcelableArray);
        list = new Bundle();
        list.putParcelableArray("album_delete", parcelableArray);
        l.e(this.a, 2131362006, (Bundle)list);
    }

    public void e() {
        List list = AlbumListFragment.l(this.a).e();
        int n10 = list.isEmpty();
        if (n10 != 0) {
            return;
        }
        AlbumListFragment.k(this.a).v();
        Object object = AlbumListFragment.k(this.a);
        AlbumListAdapter albumListAdapter = AlbumListFragment.l(this.a);
        int n11 = albumListAdapter.a() ^ 1;
        ((u0)object).s(list, n11 != 0);
        object = AlbumListFragment.j(this.a);
        n10 = ((ObservableInt)object).get();
        n11 = 3;
        if (n10 == n11) {
            object = AlbumListFragment.k(this.a);
            ((u0)object).u(list);
        }
    }
}

